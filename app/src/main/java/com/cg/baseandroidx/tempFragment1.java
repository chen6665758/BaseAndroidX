package com.cg.baseandroidx;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class tempFragment1 extends BaseFragment {


    private TextView txt_fragment1;

    public static tempFragment1 newInstance() {

        Bundle bundle = new Bundle();
        tempFragment1 hFragment = new tempFragment1();
        hFragment.setArguments(bundle);
        return hFragment;
    }

    @Override
    public void onFragmentLoad() {

        if(!txt_fragment1.getText().toString().contains("百度")) {
            OkGo.<String>get("http://www.baidu.com")
                    .tag(this)//
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            //注意这里已经是在主线程了
                            String data = response.body();//这个就是返回来的结果
                            try {
                                txt_fragment1.setText(data);
                            } catch (Exception ex) {
                                Log.e("ClockIn", "行数: 171  ex:" + ex.getMessage());


                            }
                        }

                        @Override
                        public void onError(Response<String> response) {
                            super.onError(response);
                            Log.e("ClockIn", "行数: 180  error:" + response.body());
                        }
                    });
        }
    }

    @Override
    public void onFragmentLoadStop() {

    }

    @Override
    protected void initView(View rootView) {
        txt_fragment1 = (TextView)rootView.findViewById(R.id.txt_fragment1);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_temp1;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
