package com.a.tmdbclient;

import android.app.Application;

import com.a.tmdbclient.di.AppComponent;
import com.a.tmdbclient.di.DaggerAppComponent;


public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.create();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
