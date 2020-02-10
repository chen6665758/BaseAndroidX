package com.cg.baseandroidx;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.cg.baseandroidx.Adapters.tempBannerViewHolder;
import com.cg.baseandroidx.infos.Constants;
import com.cg.baseandroidx.models.tempBannerModel;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.bannerview.constants.IndicatorGravity;
import com.zhpan.bannerview.constants.PageStyle;
import com.zhpan.bannerview.holder.HolderCreator;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {

    /**
     * banner
     */
    private BannerViewPager<tempBannerModel, tempBannerViewHolder> mBannerViewPager;

    //权限参数
    private int PermissionsCode = 1000;
    private List<String> perms;

    private TextView btn_tempFragment;
    private TextView btn_Transitio;

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
        //权限认证
        perms = new ArrayList<>();
        perms.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        perms.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        hasPermissions();

        //banner的初始化
        mBannerViewPager = (BannerViewPager)findViewById(R.id.banner_view);
        initBanner();

        btn_tempFragment = (TextView)findViewById(R.id.btn_tempFragment);
        btn_tempFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(EasyPermissions.hasPermissions(mContext, Constants.PERMISSION_WRITEREAD)) {
                    Jump_intent(tempFragmentActivity.class, null);
                }else{
                    hasPermissions();
                }
            }
        });

        btn_Transitio = (TextView)findViewById(R.id.btn_Transitio);
        btn_Transitio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Jump_intent(tempTransitioActivity.class,null);
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



    //检查自己是否申请过权限
    private void hasPermissions() {
        if (!EasyPermissions.hasPermissions(this, Constants.PERMISSION_WRITEREAD)) {

            Log.e("tempFragmentActivity", "行数: 79  这里没有走吗！");
            //EasyPermissions.requestPermissions(new PermissionRequest.Builder(this, PermissionsCode, Constants.PERMISSION_WRITEREAD).build());
            //如果用户没有点 不再提示，则此处会给出提示，否则不会走
            //此方法是控件自带，可以在这里写自己的方法
            EasyPermissions.requestPermissions(this, "您拒绝了读取文件的功能，会造成软件无法更新下载,并且会影响到维修与巡更功能！",
                    PermissionsCode,  Constants.PERMISSION_WRITEREAD);
        }
    }

    //权限受给了
    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }
    //权限没有被受给
    @Override
    public void onPermissionsDenied(int requestCode, @NonNull final List<String> perms) {

        Log.e("MainActivity.java(onPermissionsDenied)", "行数: 169  没给权限");
        //否认，弹出对话框，直到用户允许此权限为止，才不会走此方法。
//        new AlertDialog.Builder(this)
//                .setMessage("打开此")
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        /**
//                         * 若是在权限弹窗中，用户勾选了'不在提示'，且拒绝权限。
//                         * 这时候，需要跳转到设置界面去，让用户手动开启。
//                         */
//
//
//                    }
//                }).setPositiveButton("Sure", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialogInterface, int i) {
//                    hasPermissions();
//                }
//        }).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // 将结果转发到easypermissions
        Log.e("MainActivity", "行数::" + requestCode + "--" + grantResults.toString());
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
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
