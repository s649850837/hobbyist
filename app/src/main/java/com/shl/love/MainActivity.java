package com.shl.love;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LruCache;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.shl.love.pager.PagerActivity;
import com.shl.love.service.ServiceTest;

import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.Callable;

public class MainActivity extends AppCompatActivity  implements View.OnTouchListener {

    private ServiceTest serviceTest;
    private Boolean isBinded=false;
    private    Button button;
    private ServiceConnection serviceConnection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            isBinded=true;
            ServiceTest.MyBinder myBinder=(ServiceTest.MyBinder) service;
            serviceTest=myBinder.getService();
            Log.e("aa","servide value=="+serviceTest.getValue());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBinded=false;

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context a=getApplication();
        MyApplication b=(MyApplication) getApplication();
        Log.e("main","a=="+a.toString());
        Log.e("main","b=="+b.toString());
        Button button=findViewById(R.id.btn_hello);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"haha",Toast.LENGTH_SHORT);
                Intent intent=new Intent(MainActivity.this,PagerActivity.class);
                startActivity(intent);
            }
        });


        Intent intent=new Intent(this, ServiceTest.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);


    }

    @Override
    protected void onResume() {
        super.onResume();
        LinearLayout s=new LinearLayout(this);
        LruCache cache=new LruCache(10);
        HashMap map=new HashMap();
        HashSet set=new HashSet();
        LinkedList linkedList=new LinkedList();










    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(MainActivity.this,"tttt",Toast.LENGTH_SHORT);
        return super.onTouchEvent(event);
    }


    @Override
    protected void onDestroy() {
        Log.i("Main","MainActivity destroy");
        super.onDestroy();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }

    public  class  hThread implements Callable<String>,Thread.UncaughtExceptionHandler{

        @Override
        public String call() throws Exception {
            return null;
        }


        @Override
        public void uncaughtException(Thread t, Throwable e) {

        }
    }

    public  void updateUI(){
        isBinded=false;
    }


    static class TestHandle extends Handler{
        private WeakReference<MainActivity> weakReference;
        public  TestHandle (MainActivity activity){
            weakReference = new WeakReference<MainActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MainActivity mainActivity=weakReference.get();
            if (mainActivity!=null){
                mainActivity.updateUI();
            }
        }
    }

    class  MyTask extends AsyncTask{
        int i;

        @Override
        protected Object doInBackground(Object[] objects) {
            publishProgress(i);
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Object[] values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
        }





    }

}
