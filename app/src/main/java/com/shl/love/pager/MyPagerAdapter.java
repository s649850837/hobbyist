package com.shl.love.pager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MyPagerAdapter extends PagerAdapter {
    private ArrayList <View> mList;
    private ArrayList<String> mListTitle;

    public MyPagerAdapter( ){

    }

    public MyPagerAdapter(ArrayList<View> list,ArrayList<String> mListTitle){
        super();
        this.mList=list;
        this.mListTitle=mListTitle;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mList.get(position));
        return mList.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(mList.get(position));
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mListTitle.get(position);
    }
}
