package com.cg.baseandroidx;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class tempFragment3 extends BaseFragment {

    public static tempFragment3 newInstance() {

        Bundle bundle = new Bundle();
        tempFragment3 hFragment = new tempFragment3();
        hFragment.setArguments(bundle);
        return hFragment;
    }

    @Override
    public void onFragmentLoad() {
        Log.e("tempFragment3.java(onFragmentLoad)", "行数: 9  第三个页面加载");
    }

    @Override
    public void onFragmentLoadStop() {
        Log.e("tempFragment3.java(onFragmentLoadStop)", "行数: 14  第三个页面加载完");
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_temp3;
    }
}
