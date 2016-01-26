package com.bob.dreamonmusic.activity;


import android.os.Handler;
import android.os.Message;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.bob.dreamonmusic.R;

import com.bob.dreamonmusic.SlidingMenu.SlidingMenu;
import com.bob.dreamonmusic.fragment.MenuFragment;
import com.bob.dreamonmusic.fragment.LocalMusicFragment;
import com.bob.dreamonmusic.fragment.MainFragment;
import com.bob.dreamonmusic.utils.SplashScreen;

public class MainActivity extends FragmentActivity {

    private  SplashScreen mSplashScreen;

    private static final String LEFT_TAG="left";
    private static final String MAIN_TAG="main";

    //滑动菜单
    public SlidingMenu mSlidingMenu;
    public FragmentManager fragmentManager;


    public  Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            mSplashScreen.removeSplashScreen();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSplashScreen=new SplashScreen(this);
        mSplashScreen.show(R.layout.splash);
        handler.sendMessageDelayed(handler.obtainMessage(), 3000);

        //配置滑动菜单
        initSlidingMenu();
        //碎片管理初始化
        initFragment();
    }

    // 配置滑动菜单
    public void initSlidingMenu(){
        mSlidingMenu = new SlidingMenu(this);
        mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        mSlidingMenu.setMode(SlidingMenu.RIGHT);
        mSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);
        mSlidingMenu.setShadowDrawable(R.drawable.shadow);
        mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        mSlidingMenu.setFadeDegree(0.35f);
        mSlidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        mSlidingMenu.setMenu(R.layout.menu_fragment);
        mSlidingMenu.setBehindOffset(100);
    }

    private void initFragment(){
        //管理器
        fragmentManager=getSupportFragmentManager();
        //开启事务
        FragmentTransaction ft=fragmentManager.beginTransaction();
        //替换
        ft.replace(R.id.left_menu, new MenuFragment(), LEFT_TAG);
        ft.replace(R.id.fl_main_container, new MainFragment(), MAIN_TAG);
        //提取
        ft.commit();
    }

    //获得菜单对象
    public MenuFragment getLeftMenuFragment(){
        fragmentManager=getSupportFragmentManager();
        MenuFragment leftMenuFragment=(MenuFragment)fragmentManager.findFragmentByTag(LEFT_TAG);
        return leftMenuFragment;
    }

    //获得主窗口对象
    public MainFragment getMainContentFragment(){
        fragmentManager=getSupportFragmentManager();
        MainFragment mainContentFragment=(MainFragment)fragmentManager.findFragmentByTag(MAIN_TAG);
        return mainContentFragment;
    }

    //切换到LocalMusicFragment
    public void switchToLocalMusicFragment(){
        fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction();
        ft.replace(R.id.fl_main_container, new LocalMusicFragment());
        ft.commit();
    }

    //切换到LocalMusicFragment
    public void switchToMainFragment(){
        fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction();
        ft.replace(R.id.fl_main_container, new MainFragment());
        ft.commit();
    }

    public FragmentManager getManager(){
        return fragmentManager=getSupportFragmentManager();
    }

}
