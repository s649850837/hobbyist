package com.shl.love;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class MyApplication extends Application {


    @Override
    public Context getApplicationContext() {
        return super.getApplicationContext();
    }

    @Override
    public void onCreate() {
        Log.e("app","start  hahha ");
        super.onCreate();

    }


    @Override
    public void onTerminate() {
        super.onTerminate();
        Log.e("app","onTerminate  hahha ");
    }
}
