package com.cg.baseandroidx;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cg.baseandroidx.customs.MyLoading;
import com.cg.baseandroidx.untils.ConnectionDetector;
import com.google.gson.Gson;

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

* 功能：基础Fragment页面
* 作者：cg
* 时间：2020/1/9 10:48
*/
public abstract class BaseFragment extends Fragment {

    View rootView;        //子类的根布局
    boolean isViewCreated = false;           //布局是否已经加载完
    boolean isCurrentVisible = false;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        //只有view初始化了，才能进行分发
        if(isViewCreated == true) {
            //加载网络数据
            if (isVisibleToUser && !isCurrentVisible) {//加载数据时，只有不可见-》可见时分发
                dispatchVisibleHint(true);
            } else if(!isVisibleToUser && isCurrentVisible) {//停止数据更新
                dispatchVisibleHint(false);
            }
        }
    }

    /**
     * 分发可见事件
     * @param visibleState
     */
    private void dispatchVisibleHint(boolean visibleState)
    {
        //如果状态没有改变，则不做处理
        if(isCurrentVisible == visibleState)
        {
            return;
        }
        isCurrentVisible = visibleState;
        //true 可见，触发数据加载   false 触发加载的中断事件
        if(visibleState)
        {
            onFragmentLoad();
        }else{
            onFragmentLoadStop();
        }
    }

    /**
     * 数据加载
     */
    public abstract void onFragmentLoad();

    /**
     * 数据中断
     */
    public abstract void onFragmentLoadStop();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if(rootView == null) {
            rootView = inflater.inflate(getLayoutRes(), null);
        }

        initView(rootView);

        isViewCreated = true;

        //只有默认fragment才会走到这里
        if(getUserVisibleHint() && isHidden())
        {
            dispatchVisibleHint(true);
        }

        return rootView;
    }

    /**
     * 初始化布局控件
     * @param rootView
     */
    protected abstract void initView(View rootView);

    /**
     * 加载布局
     * @return
     */
    protected abstract int getLayoutRes();


    @Override
    public void onResume() {
        super.onResume();
        if(!isCurrentVisible && getUserVisibleHint())
        {
            dispatchVisibleHint(true);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(isCurrentVisible && getUserVisibleHint())
        {
            dispatchVisibleHint(false);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    public Context mContext;
    public ConnectionDetector cd;
    public Boolean isInternetPresent = false;       //判断网络是否链接
    public SharedPreferences.Editor shared_editor;
    public static SharedPreferences mSharedPreferences;
    public String pkgName;
    public Bundle bundle;
    public Gson gson;
    public MyLoading progress_Dialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getActivity();
        progress_Dialog = MyLoading.createDialog(getActivity());
        //progress_Dialog.setMessage("努力加载中");
        //ApplicationAddActivity(getActivity());
        pkgName = mContext.getApplicationContext().getPackageName();
        bundle = new Bundle();
        cd = new ConnectionDetector(mContext);
        isInternetPresent = cd.isConnectingToInternet();// 判断网络
        mSharedPreferences = mContext.getSharedPreferences("data", 0);// 获取SharedPreferences对象
        shared_editor = mContext.getSharedPreferences("data", 0).edit();// 获取Editor对象。

        gson = new Gson();
    }
}
