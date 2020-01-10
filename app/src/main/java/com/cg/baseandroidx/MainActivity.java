package com.cg.baseandroidx;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cg.baseandroidx.Adapters.tempBannerViewHolder;
import com.cg.baseandroidx.models.tempBannerModel;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.bannerview.constants.IndicatorGravity;
import com.zhpan.bannerview.constants.PageStyle;
import com.zhpan.bannerview.holder.HolderCreator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    /**
     * banner
     */
    private BannerViewPager<tempBannerModel, tempBannerViewHolder> mBannerViewPager;

    private Button btn_tempFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;

        initControls();
    }

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    /**
     * 初始化控件
     */
    private void initControls()
    {
        //banner的初始化
        mBannerViewPager = (BannerViewPager)findViewById(R.id.banner_view);
        initBanner();

        btn_tempFragment = (Button)findViewById(R.id.btn_tempFragment);
        btn_tempFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jump_intent(tempFragmentActivity.class,null);
            }
        });
    }

    /**
     * 初始化banner
     */
    private void initBanner()
    {
        List<tempBannerModel> mList = new ArrayList<>();
        tempBannerModel model1 = new tempBannerModel();
        model1.setId("1");
        model1.setTitle("第一个数据");
        model1.setPicURL("http://pic1.win4000.com/wallpaper/2018-01-08/5a52d6a461031.jpg");
        mList.add(model1);
        tempBannerModel model2 = new tempBannerModel();
        model2.setId("2");
        model2.setTitle("第二个数据");
        model2.setPicURL("http://pic1.win4000.com/wallpaper/2018-01-08/5a52d6b207316.jpg");
        mList.add(model2);
        tempBannerModel model3 = new tempBannerModel();
        model3.setId("1");
        model3.setTitle("第三个数据");
        model3.setPicURL("http://pic1.win4000.com/wallpaper/2018-01-08/5a52d6a461031.jpg");
        mList.add(model3);

        mBannerViewPager.showIndicator(false)
                .setInterval(3000)
                .setCanLoop(true)
                .setAutoPlay(true)
                .setRoundCorner(10)
                .setRevealWidth(100)//一屏多页中左右页面显示的大小
                .setPageStyle(PageStyle.MULTI_PAGE)//设置一屏多页的样式
                .setPageMargin(30)//一屏多页的页间距
                .setIndicatorColor(Color.parseColor("#00000000"), Color.parseColor("#00000000"))
                .setIndicatorGravity(IndicatorGravity.END)
                .setScrollDuration(1000).setHolderCreator(new HolderCreator<tempBannerViewHolder>() {
                    @Override
                    public tempBannerViewHolder createViewHolder() {
                        return new tempBannerViewHolder();
                    }
                })
                .setOnPageClickListener(new BannerViewPager.OnPageClickListener() {
                    @Override
                    public void onPageClick(int position) {
                        tempBannerModel bannerData = mBannerViewPager.getList().get(position);
                        Toast.makeText(MainActivity.this,
                                "点击了图片" + position + " " + bannerData.getTitle(), Toast.LENGTH_SHORT).show();
                    }
                } ).create(mList);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mBannerViewPager != null) {
            mBannerViewPager.stopLoop();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mBannerViewPager != null)
            mBannerViewPager.startLoop();
    }


    @Override
    public void Jump_intent(Class<?> cla, Bundle bundle) {
        if(mContext !=null)
        {
            Intent intent = new Intent(mContext, cla);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            startActivity(intent);
            //overridePendingTransition(0, 0);
        }
    }
}
