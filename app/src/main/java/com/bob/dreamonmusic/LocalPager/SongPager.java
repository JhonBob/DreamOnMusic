package com.bob.dreamonmusic.LocalPager;

import android.content.Context;
import android.view.View;

import com.bob.dreamonmusic.R;

/**
 * Created by Administrator on 2016/1/23.
 */
public class SongPager extends LocalBasePager{

    public SongPager(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        View view=View.inflate(mContext, R.layout.song_pager,null);
        return view;
    }

}
