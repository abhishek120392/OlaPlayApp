package com.example.abhishek.olaplayapp.connection;

import com.example.abhishek.olaplayapp.models.AlbumSong;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Abhishek on 16/12/17.
 */

public interface ApiInterface {

    @GET("studio")
    Call<List<AlbumSong>> fetchSongs();

}
