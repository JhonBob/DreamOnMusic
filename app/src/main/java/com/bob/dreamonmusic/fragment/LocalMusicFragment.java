package com.bob.dreamonmusic.fragment;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bob.dreamonmusic.LocalPager.AlbumPager;
import com.bob.dreamonmusic.LocalPager.FolderPager;
import com.bob.dreamonmusic.LocalPager.LocalBasePager;
import com.bob.dreamonmusic.LocalPager.SingerPager;
import com.bob.dreamonmusic.LocalPager.SongPager;
import com.bob.dreamonmusic.R;
import com.bob.dreamonmusic.SlidingMenu.SlidingMenu;
import com.bob.dreamonmusic.TabPageIndicator.TabPageIndicator;
import com.bob.dreamonmusic.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/23.
 */
public class LocalMusicFragment extends BaseFragment implements ViewPager.OnPageChangeListener{

    private ViewPager mViewPager;
    private TabPageIndicator tabPageIndicator;
    private List<LocalBasePager> localBasePagerList;
    private LocalMusicAdapter localAdapter;
    private String [] title=new String[]{"歌曲","歌手","专辑","文件夹"};

    @Override
    public View initView(LayoutInflater inflater) {
        View view=inflater.inflate(R.layout.localmusic_fragment, null);
        mViewPager=(ViewPager)view.findViewById(R.id.vp_local_content);
        tabPageIndicator=(TabPageIndicator)view.findViewById(R.id.tpi_local_menu);
        return view;
    }

    @Override
    public void initData() {
        localBasePagerList=new ArrayList<>();
        localBasePagerList.add(new SongPager(mActivity));
        localBasePagerList.add(new SingerPager(mActivity));
        localBasePagerList.add(new AlbumPager(mActivity));
        localBasePagerList.add(new FolderPager(mActivity));



        localAdapter=new LocalMusicAdapter();
        mViewPager.setAdapter(localAdapter);
        mViewPager.setCurrentItem(0);
        localBasePagerList.get(0).initData();
        tabPageIndicator.setViewPager(mViewPager);
        tabPageIndicator.setOnPageChangeListener(this);
    }

    class LocalMusicAdapter extends PagerAdapter{
        @Override
        public int getCount() {
            return localBasePagerList.size();
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
            LocalBasePager pager=localBasePagerList.get(position);
            View rootView=pager.getRootView();
            container.addView(rootView);
            pager.initData();
            return rootView;
        }

        //返回字符串作为标签数据
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }


    int onPageScrolled = -1;

    @Override
    public void onPageScrollStateChanged(int state) {
        if (onPageScrolled == 0 && state == 0) {
            ((MainActivity)mActivity).switchToMainFragment();
        }
    }

    @Override
    public void onPageSelected(int position) {
        isEnableSlidingMenu(false);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        onPageScrolled = position;
    }


    //是否启用滑动菜单
    private void isEnableSlidingMenu(boolean isEnable) {
        if(isEnable) {
            ((MainActivity) mActivity).mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        }else {
            ((MainActivity) mActivity).mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        }
    }

}
