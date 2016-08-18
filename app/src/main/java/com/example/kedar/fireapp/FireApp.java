package com.example.kedar.fireapp;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by kedar on 8/17/2016.
 */
public class FireApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}
