package com.cg.baseandroidx;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Date;

public class tempFragment3 extends BaseFragment {

    private ImageView img_glide;
    private TimePickerView pvTime;

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

        initDate();

        img_glide = (ImageView)rootView.findViewById(R.id.img_glide);
        img_glide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvTime.show();
            }
        });
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_temp3;
    }


    //初始化时间控件
    private void initDate() {
        //时间选择器
        pvTime = new TimePickerBuilder(getActivity(), new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                Toast.makeText(getActivity(), date.toString(), Toast.LENGTH_SHORT).show();
            }
        }).build();
    }
}
