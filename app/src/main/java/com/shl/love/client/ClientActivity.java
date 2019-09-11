package com.shl.love.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.LruCache;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.shl.love.MyApplication;
import com.shl.love.R;
import com.shl.love.aidl.Book;
import com.shl.love.aidl.IBookManager;
import com.shl.love.pager.PagerActivity;
import com.shl.love.service.BookManagerService;
import com.shl.love.service.ServiceTest;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

public class ClientActivity extends AppCompatActivity {
    private static final String Tag = "Client11";
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            IBookManager iBookManager = IBookManager.Stub.asInterface(service);
            try {
                List<Book> list = iBookManager.getBookList();
                Log.e(Tag, "booklist type=" + list.getClass().getCanonicalName());
                Log.e(Tag, "booklist tostring=" + list.toString());

                Book book=new Book(3,"yaya");
                iBookManager.addBook(book);
                List<Book> newList = iBookManager.getBookList();
                Log.e(Tag, "newList tostring=" + newList.toString());

            } catch (RemoteException e) {
                e.printStackTrace();

            }

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=findViewById(R.id.btn_hello);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ClientActivity.this, BookManagerService.class);
                bindService(intent, serviceConnection, BIND_AUTO_CREATE);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();


    }


    @Override
    protected void onDestroy() {
        unbindService(serviceConnection);
        super.onDestroy();
    }


}
