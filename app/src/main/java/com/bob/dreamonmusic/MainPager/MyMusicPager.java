package com.bob.dreamonmusic.MainPager;


import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.bob.dreamonmusic.R;
import com.bob.dreamonmusic.activity.MainActivity;


/**
 * Created by Administrator on 2016/1/22.
 */
public class MyMusicPager extends MainBasePager implements View.OnClickListener {

    private ListView mListView;
    private LinearLayout LocalMusic;

    public MyMusicPager(Context context) {
        super(context);
    }


    @Override
    public View initView() {
        View view=View.inflate(mContext, R.layout.mymusic_pager,null);
        mListView=(ListView)view.findViewById(R.id.add_music);
        LocalMusic=(LinearLayout)view.findViewById(R.id.local_music);
        LocalMusic.setOnClickListener(this);
        return view;
    }

    @Override
    public void initData() {

    }


    class AddMusicAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.local_music:
                ((MainActivity)mContext).switchToLocalMusicFragment();
                break;
            default:
                break;
        }
    }


}
