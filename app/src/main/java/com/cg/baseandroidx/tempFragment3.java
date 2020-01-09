package com.cg.baseandroidx;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class tempFragment3 extends BaseFragment {

    private ImageView img_glide;

    public static tempFragment3 newInstance() {

        Bundle bundle = new Bundle();
        tempFragment3 hFragment = new tempFragment3();
        hFragment.setArguments(bundle);
        return hFragment;
    }

    @Override
    public void onFragmentLoad() {
        Glide.with(this)
                .load("http://imgsrc.baidu.com/forum/pic/item/8fdda144ad345982ce4d1cf903f431adcaef8492.jpg")
                .apply(new RequestOptions().placeholder(R.mipmap.ic_launcher).error(R.mipmap.img_login_loading1))
                .into(img_glide);
    }

    @Override
    public void onFragmentLoadStop() {
        Log.e("tempFragment3", "行数: 14  第三个页面加载完");
    }

    @Override
    protected void initView(View rootView) {
        img_glide = (ImageView)rootView.findViewById(R.id.img_glide);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_temp3;
    }
}
