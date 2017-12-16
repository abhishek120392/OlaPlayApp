package com.example.abhishek.olaplayapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by Abhishek on 16/12/17.
 */

public class AlbumSong extends SugarRecord {

    @Expose
    public String song;
    @Unique
    @Expose
    public String url;
    @Expose
    public String artists;
    @Expose
    @SerializedName("cover_image")
    public String coverImage;

}
