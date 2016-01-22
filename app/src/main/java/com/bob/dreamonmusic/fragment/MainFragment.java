package com.bob.dreamonmusic.fragment;


import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bob.dreamonmusic.MainPager.MainBasePager;
import com.bob.dreamonmusic.MainPager.MyMusicPager;
import com.bob.dreamonmusic.MainPager.SingerPager;
import com.bob.dreamonmusic.MainPager.VideoPager;
import com.bob.dreamonmusic.MainPager.WarehousePager;
import com.bob.dreamonmusic.R;
import com.bob.dreamonmusic.SlidingMenu.SlidingMenu;
import com.bob.dreamonmusic.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/21.
 */
public class MainFragment extends BaseFragment implements OnClickListener,ViewPager.OnPageChangeListener{

    private ViewPager mViewPager;
    private List<MainBasePager> pagerList;
    private ContentAdapter mAdapter;
    private TextView mymusic;
    private TextView warehouse;
    private TextView sing;
    private TextView video;
    private ImageView more;

    @Override
    public View initView(LayoutInflater inflater) {
        View view=inflater.inflate(R.layout.main_fragment,null);
        mViewPager=(ViewPager)view.findViewById(R.id.vp_cf_page);
        mymusic=(TextView)view.findViewById(R.id.my_music);
        warehouse=(TextView)view.findViewById(R.id.warehouse);
        sing=(TextView)view.findViewById(R.id.sing);
        video=(TextView)view.findViewById(R.id.video);
        more=(ImageView)view.findViewById(R.id.more);

        mymusic.setOnClickListener(this);
        warehouse.setOnClickListener(this);
        sing.setOnClickListener(this);
        video.setOnClickListener(this);
        more.setOnClickListener(this);

        return view;
    }

    @Override
    public void initData() {
        pagerList=new ArrayList<>();
        pagerList.add(new MyMusicPager(mActivity));
        pagerList.add(new WarehousePager(mActivity));
        pagerList.add(new SingerPager(mActivity));
        pagerList.add(new VideoPager(mActivity));

        mAdapter=new ContentAdapter();
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);
        pagerList.get(0).initData();

        mViewPager.setOnPageChangeListener(this);
    }

    class ContentAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return pagerList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            MainBasePager pager=pagerList.get(position);
            View rootView=pager.getRootView();
            container.addView(rootView);
            //pager.initData();
            return rootView;
        }
    }

    @Override
    public void onClick(View v) {
        int index=-1;
        switch (v.getId()){
            case R.id.my_music:
                index=0;
                break;
            case R.id.warehouse:
                index=1;
                break;
            case R.id.sing:
                index=2;
                break;
            case R.id.video:
                index=3;
                break;
            case R.id.more:
                ((MainActivity)mActivity).mSlidingMenu.showMenu();
                break;
            default:
                break;
        }

        switchViewPager(index);

    }

    //页面的切换
    private void switchViewPager(int position) {
        if(position!=-1) {
            mViewPager.setCurrentItem(position);
            pagerList.get(position).initData();

            if (position==3) {
                ((MainActivity)mActivity).mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
            } else {
                ((MainActivity)mActivity).mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
            }
        }
    }



    //页面滚动处理
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        switchViewPager(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
