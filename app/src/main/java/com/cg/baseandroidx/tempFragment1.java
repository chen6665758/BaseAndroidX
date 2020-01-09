package com.cg.baseandroidx;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

public class tempFragment1 extends BaseFragment {


    public static tempFragment1 newInstance() {

        Bundle bundle = new Bundle();
        tempFragment1 hFragment = new tempFragment1();
        hFragment.setArguments(bundle);
        return hFragment;
    }

    @Override
    public void onFragmentLoad() {
        Log.e("tempFragment1.java(onFragmentLoad)", "行数: 14  第一个页面数据加载");
    }

    @Override
    public void onFragmentLoadStop() {
        Log.e("tempFragment1.java(onFragmentLoadStop)", "行数: 19  第一个页面数据停止加载");
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_temp1;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.e("tempFragment1.java(onViewCreated)", "行数: 26  我是第一个，开始加载数据");
    }
}
