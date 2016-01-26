package com.bob.dreamonmusic.MainPager;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

import com.bob.dreamonmusic.R;

/**
 * Created by Administrator on 2016/1/22.
 */
public abstract class MainBasePager {
    public Context mContext;
    public View rootView;


    public MainBasePager(Context context) {
        this.mContext=context;
        rootView=initView();
    }

    public abstract View initView();

    public View getRootView(){
        return rootView;
    }

    public void initData(){}
}
