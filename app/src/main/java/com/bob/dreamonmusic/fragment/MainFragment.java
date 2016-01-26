package com.bob.dreamonmusic.fragment;


import android.graphics.Color;
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
import com.bob.dreamonmusic.TabPageIndicator.TabPageIndicator;
import com.bob.dreamonmusic.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/21.
 */
public class MainFragment extends BaseFragment implements ViewPager.OnPageChangeListener{

    private ViewPager mViewPager;
    private List<MainBasePager> pagerList;
    private ContentAdapter mAdapter;
    private TabPageIndicator mIndicator;

    private String [] title=new String[]{"我的","乐库","唱歌","视频"};

    @Override
    public View initView(LayoutInflater inflater) {
        View view=inflater.inflate(R.layout.main_fragment,null);
        mViewPager=(ViewPager)view.findViewById(R.id.vp_cf_pager);
        mIndicator=(TabPageIndicator)view.findViewById(R.id.tpi_main_content);
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

        mIndicator.setViewPager(mViewPager);
        mIndicator.setOnPageChangeListener(this);
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

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
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
