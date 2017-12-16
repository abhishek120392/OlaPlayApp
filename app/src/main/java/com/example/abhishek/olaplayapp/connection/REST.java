package com.example.abhishek.olaplayapp.connection;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abhishek on 16/12/17.
 */

public class REST {

    private static Retrofit retrofit;
    public static ApiInterface API;
    private static Gson gson;


    public void initialize(String baseUrl, Context ctx){
        API = getAPIInterface(baseUrl, ctx, ApiInterface.class);
    }

    protected static <T> T getAPIInterface(String baseUrl, Context ctx, Class<T> restInterface){
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit.create(restInterface);
    }

}
