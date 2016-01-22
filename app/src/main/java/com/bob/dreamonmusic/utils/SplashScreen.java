package com.bob.dreamonmusic.utils;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.bob.dreamonmusic.R;

/**
 * Created by Administrator on 2016/1/21.
 */

//播放器启动动画
public class SplashScreen {
    private Activity context;
    //private LayoutParams params;
    private Dialog splashDialog;



    public SplashScreen(Activity context) {
        this.context=context;
    }

    //图片和动画效果设置
    public void show(final int imageResouece){
        Runnable runnable=new Runnable(){
            @Override
            public void run() {
                //DisplayMetrics metrics=new DisplayMetrics();
                //创建一个布局
                //LinearLayout root=new LinearLayout(context);
                //以设备真实宽高作为Dialog的宽高
               // root.setMinimumHeight(metrics.heightPixels);
               // root.setMinimumWidth(metrics.widthPixels);
                //root.setOrientation(LinearLayout.VERTICAL);
                //root.setBackgroundColor(Color.BLACK);
                 //params=new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        // ViewGroup.LayoutParams.MATCH_PARENT,0.0f);
                //root.setLayoutParams(params);
                //root.setBackgroundResource(imageResouece);

                //创建Dialog
                splashDialog=new Dialog(context,android.R.style.Theme_Translucent_NoTitleBar);

                //确保屏幕全屏
                if ((context.getWindow().getAttributes().flags & WindowManager.LayoutParams.FLAG_FULLSCREEN)
                        ==WindowManager.LayoutParams.FLAG_FULLSCREEN){
                    splashDialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
                }

                //动画
                Window window=splashDialog.getWindow();
                window.setWindowAnimations(R.style.dialog_anim_slide_left);

                splashDialog.setContentView(imageResouece);
                splashDialog.setCancelable(false);
                splashDialog.show();



            }
        };
        //交由主线程运行
        context.runOnUiThread(runnable);
    }

    //移除播放器启动动画
    public void removeSplashScreen(){
        if (splashDialog != null && splashDialog.isShowing()) {
            splashDialog.dismiss();
            splashDialog = null;
        }
    }
}
