package com.bob.dreamonmusic.activity;


import android.os.Handler;
import android.os.Message;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.bob.dreamonmusic.R;

import com.bob.dreamonmusic.SlidingMenu.SlidingMenu;
import com.bob.dreamonmusic.fragment.LeftFragment;
import com.bob.dreamonmusic.fragment.MainFragment;
import com.bob.dreamonmusic.utils.SplashScreen;

public class MainActivity extends FragmentActivity {

    private  SplashScreen mSplashScreen;

    private static final String LEFT_TAG="left";
    private static final String MAIN_TAG="main";

    //滑动菜单
    public SlidingMenu mSlidingMenu;


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
        FragmentManager fragmentManager=getSupportFragmentManager();
        //开启事务
        FragmentTransaction ft=fragmentManager.beginTransaction();
        //替换
        ft.replace(R.id.left_menu, new LeftFragment(), LEFT_TAG);
        ft.replace(R.id.fl_main_container, new MainFragment(), MAIN_TAG);
        //提取
        ft.commit();
    }

    //获得菜单对象
    public LeftFragment getLeftMenuFragment(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        LeftFragment leftMenuFragment=(LeftFragment)fragmentManager.findFragmentByTag(LEFT_TAG);
        return leftMenuFragment;
    }

    //获得主窗口对象
    public MainFragment getMainContentFragment(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        MainFragment mainContentFragment=(MainFragment)fragmentManager.findFragmentByTag(MAIN_TAG);
        return mainContentFragment;
    }

}
