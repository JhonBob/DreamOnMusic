package com.bob.dreamonmusic.LocalPager;

import android.content.Context;
import android.view.View;

/**
 * Created by Administrator on 2016/1/23.
 */
public abstract class LocalBasePager {

    public Context mContext;
    public View rootView;

    public LocalBasePager(Context context) {
        this.mContext=context;
        rootView=initView();
    }

    public abstract View initView();

    public View getRootView(){
        return rootView;
    }

    public void initData(){}
}
