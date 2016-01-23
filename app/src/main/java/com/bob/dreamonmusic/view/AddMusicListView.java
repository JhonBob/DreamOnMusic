package com.bob.dreamonmusic.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Administrator on 2016/1/23.
 */
public class AddMusicListView extends ListView {
    public AddMusicListView(Context context) {
        super(context);
    }

    public AddMusicListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AddMusicListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
