package com.cg.baseandroidx.untils;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

import me.jessyan.autosize.AutoSizeConfig;

/**
/*                       _oo0oo_
/*                      o8888888o
/*                      88" . "88
/*                      (| -_- |)
/*                      0\  =  /0
/*                    ___/`---'\___
/*                  .' \\|     |// '.
/*                 / \\|||  :  |||// \
/*                / _||||| -:- |||||- \
/*               |   | \\\  -  /// |   |
/*               | \_|  ''\---/''  |_/ |
/*               \  .-\__  '-'  ___/-. /
/*             ___'. .'  /--.--\  `. .'___
/*          ."" '<  `.___\_<|>_/___.' >' "".
/*         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
/*         \  \ `_.   \_ __\ /__ _/   .-` /  /
/*     =====`-.____`.___ \_____/___.-`___.-'=====
/*                       `=---='
/*
/*     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
/*               佛祖保佑         永无BUG

* 功能：自定义Application，用来初始化一些组件与控件
* 作者：cg
* 时间：2020/1/9 10:00
*/
public class myApplication extends Application {

    private static myApplication mInstance;
    private static List<Activity> activityList = new LinkedList<Activity>();

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        initAutoSize();  //今日头条适配框架
    }

    public static myApplication getInstance() {
        return mInstance;
    }

    public void addActivity(Activity activity)  {
        activityList.add(activity);
    }
    public void removeActivity(Activity activity){
        activityList.remove(activity);
    }
    public void exitAllActivity(){
        for(Activity activity:activityList) {
            activity.finish();
        }
    }

    /**
     * 今日头条适配框架的一些设置
     */
    private void initAutoSize() {


        /*当某个 Activity 的设计图尺寸与在 AndroidManifest 中填写的全局设计图尺寸不同时，可以实现 CustomAdapt 接口扩展适配参数

        public class CustomAdaptActivity extends AppCompatActivity implements CustomAdapt {
            @Override
            public boolean isBaseOnWidth() {
                return false;
            }
            @Override
            public float getSizeInDp() {
                return 667;
            }
        }


        当某个 Activity 想放弃适配，请实现 CancelAdapt 接口

        public class CancelAdaptActivity extends AppCompatActivity implements CancelAdapt {

        }

        Fragment

        首先开启支持 Fragment 自定义参数的功能

        AutoSizeConfig.getInstance().setCustomFragment(true);

        当某个 Fragment 的设计图尺寸与在 AndroidManifest 中填写的全局设计图尺寸不同时，可以实现 CustomAdapt 接口扩展适配参数

        public class CustomAdaptFragment extends Fragment implements CustomAdapt {

            @Override
            public boolean isBaseOnWidth() {
                return false;
            }

            @Override
            public float getSizeInDp() {
                return 667;
            }
        }

        当某个 Fragment 想放弃适配，请实现 CancelAdapt 接口

        public class CancelAdaptFragment extends Fragment implements CancelAdapt {

        }


        */



        AutoSizeConfig.getInstance()
                //是否让框架支持自定义 Fragment 的适配参数, 由于这个需求是比较少见的, 所以须要使用者手动开启
                .setCustomFragment(true)
                //是否屏蔽系统字体大小对 AndroidAutoSize 的影响, 如果为 true, App 内的字体的大小将不会跟随系统设置中字体大小的改变
                //如果为 false, 则会跟随系统设置中字体大小的改变, 默认为 false
                .setExcludeFontScale(true);
    }
}
