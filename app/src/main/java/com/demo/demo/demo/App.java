package com.demo.demo.demo;

import android.app.Application;

import com.demo.demo.demo.sqlite.DataDb;

/**
 * Created by Administrator on 2017/2/27/027.
 */

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        DataDb.init(this);
    }
}
