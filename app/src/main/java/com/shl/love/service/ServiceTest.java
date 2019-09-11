package com.shl.love.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class ServiceTest extends Service{

    private  int i=100;

    public  class  MyBinder extends Binder {
        public  ServiceTest getService(){
            return ServiceTest.this;
        }
    }

    private  MyBinder binder=new MyBinder();


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }


    public  int getValue(){
        return  i;
    }
}
