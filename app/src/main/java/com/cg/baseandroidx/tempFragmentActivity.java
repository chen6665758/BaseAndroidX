package com.cg.baseandroidx;


import android.Manifest;
import android.os.Bundle;
import android.util.Log;

import com.cg.baseandroidx.Adapters.tempVpAdapter;
import com.cg.baseandroidx.infos.Constants;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import pub.devrel.easypermissions.EasyPermissions;

public class tempFragmentActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {

    private ViewPager vp_main;
    private tempFragment1 tempF1;
    private tempFragment2 tempF2;
    private tempFragment3 tempF3;
    private List<Fragment> list_fragment;
    private tempVpAdapter tAdapter;

    //权限参数
    private int PermissionsCode = 1000;
    private List<String> perms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initControls();
        perms = new ArrayList<>();
        perms.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        perms.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        hasPermissions();
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
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
