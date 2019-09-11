package com.shl.love.pager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.shl.love.R;

import java.util.ArrayList;

public class PagerActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private MyPagerAdapter myPagerAdapter;
    private ArrayList<View>  mArrayList;
    private ArrayList<String>  mArrayListTitle;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        mArrayList=new ArrayList<>();
        mArrayListTitle=new ArrayList<>();
        LayoutInflater layoutInflater=getLayoutInflater();

        mArrayList.add(layoutInflater.inflate(R.layout.activity_pager_one,null,false));
        mArrayList.add(layoutInflater.inflate(R.layout.activity_pager_two,null,false));
        mArrayList.add(layoutInflater.inflate(R.layout.activity_pager_three,null,false));
        mArrayListTitle.add("One");
        mArrayListTitle.add("Two");
        mArrayListTitle.add("Three");

        myPagerAdapter=new MyPagerAdapter(mArrayList,mArrayListTitle);
        mViewPager=findViewById(R.id.view_pager);
        mViewPager.setAdapter(myPagerAdapter);


    }
}
