package com.bob.dreamonmusic.MainPager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.bob.dreamonmusic.R;

/**
 * Created by Administrator on 2016/1/22.
 */
public class VideoPager extends MainBasePager {

    public VideoPager(Context context) {
        super(context);
    }


    @Override
    public View initView() {
        View view=View.inflate(mContext, R.layout.main_base_pager,null);
        return view;
    }

    @Override
    public void initData() {
       super.initData();
    }
}
