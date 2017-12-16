package com.example.abhishek.olaplayapp;

import com.example.abhishek.olaplayapp.connection.REST;
import com.orm.SugarApp;

/**
 * Created by Abhishek on 16/12/17.
 */

public class OlaPlayApplication extends SugarApp {

    @Override
    public void onCreate() {
        super.onCreate();
        new REST().initialize("http://starlord.hackerearth.com/", this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
