package com.bob.dreamonmusic.MainPager;

import android.content.Context;
import android.view.View;
import com.bob.dreamonmusic.R;

/**
 * Created by Administrator on 2016/1/22.
 */
public class MainBasePager {
    public Context mContext;
    public View rootView;

    public MainBasePager(Context context) {
        this.mContext=context;
        rootView=initView();
    }

    private View initView(){
        View view=View.inflate(mContext, R.layout.main_base_pager,null);
        return view;
    }

    public View getRootView(){
        return rootView;
    }

    public void initData(){}
}
