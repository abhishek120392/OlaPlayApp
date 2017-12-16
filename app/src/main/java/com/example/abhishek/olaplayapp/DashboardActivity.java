package com.example.abhishek.olaplayapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.abhishek.olaplayapp.connection.REST;
import com.example.abhishek.olaplayapp.models.AlbumSong;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity implements Callback<List<AlbumSong>>{

    List<AlbumSong> albumSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        if (AlbumSong.listAll(ArrayList.class) != null){
            if (AlbumSong.listAll(ArrayList.class).size() != 0){

            }
        } else {
            Call<List<AlbumSong>> call = REST.API.fetchSongs();
            call.enqueue(this);
        }
    }

    @Override
    public void onResponse(Call<List<AlbumSong>> call, Response<List<AlbumSong>> response) {
        if (response.isSuccessful()){
            try{
                albumSongs = response.body();
                for (AlbumSong song : albumSongs){
                    System.out.println(song.url);
                }
                AlbumSong.saveInTx(albumSongs);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onFailure(Call<List<AlbumSong>> call, Throwable t) {
        t.printStackTrace();
    }
}
