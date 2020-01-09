package com.cg.baseandroidx;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.cg.baseandroidx.Adapters.tempVpAdapter;

import java.util.ArrayList;
import java.util.List;

public class tempFragmentActivity extends BaseActivity {

    private ViewPager vp_main;
    private tempFragment1 tempF1;
    private tempFragment2 tempF2;
    private tempFragment3 tempF3;
    private List<Fragment> list_fragment;
    private tempVpAdapter tAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initControls();
    }

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_temp_fragment);
    }

    /**
     * 初始化控件
     */
    private void initControls()
    {
        vp_main = (ViewPager)findViewById(R.id.vp_main);
        tempF1 = tempFragment1.newInstance();
        tempF2 = tempFragment2.newInstance();
        tempF3 = tempFragment3.newInstance();
        list_fragment = new ArrayList<>();
        list_fragment.add(tempF1);
        list_fragment.add(tempF2);
        list_fragment.add(tempF3);
        tAdapter = new tempVpAdapter(getSupportFragmentManager(),list_fragment);
        vp_main.setAdapter(tAdapter);

    }

    @Override
    public void Jump_intent(Class<?> cla, Bundle bundle) {

    }
}
