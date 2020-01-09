package com.cg.baseandroidx;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class tempFragment2 extends BaseFragment {

    public static tempFragment2 newInstance() {

        Bundle bundle = new Bundle();
        tempFragment2 hFragment = new tempFragment2();
        hFragment.setArguments(bundle);
        return hFragment;
    }

    @Override
    public void onFragmentLoad() {
        Log.e("tempFragment2", "行数: 13  第二个页面加载数据");
    }

    @Override
    public void onFragmentLoadStop() {
        Log.e("tempFragment2", "行数: 18  第二个页面停止加载数据");
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_temp2;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
