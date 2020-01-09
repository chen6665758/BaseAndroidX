package com.cg.baseandroidx;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cg.baseandroidx.Adapters.tempPmrAdapter;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class tempFragment2 extends BaseFragment {

    private PullLoadMoreRecyclerView pmr_list;
    private List<String> list_data;
    private tempPmrAdapter pAdapter;

    public static tempFragment2 newInstance() {

        Bundle bundle = new Bundle();
        tempFragment2 hFragment = new tempFragment2();
        hFragment.setArguments(bundle);
        return hFragment;
    }

    @Override
    public void onFragmentLoad() {
        if(list_data.size() == 0)
        {
            for(int i=0;i<25;i++)
            {
                list_data.add("这是第 " + (i +1 ) + " 条数据");
            }

            pAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onFragmentLoadStop() {
        Log.e("tempFragment2", "行数: 18  第二个页面停止加载数据");
    }

    @Override
    protected void initView(View rootView) {
        pmr_list = (PullLoadMoreRecyclerView)rootView.findViewById(R.id.pmr_list);
        pmr_list.setLinearLayout();
        pmr_list.setPullRefreshEnable(false);
        pmr_list.setPushRefreshEnable(false);
        list_data = new ArrayList<>();
        pAdapter = new tempPmrAdapter(getActivity(),list_data);
        pmr_list.setAdapter(pAdapter);
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
