package com.cg.baseandroidx.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class tempVpAdapter extends FragmentPagerAdapter {

    private List<Fragment> list_fragment;

    public tempVpAdapter(FragmentManager fm,List<Fragment> list_fragment) {
        super(fm);

        this.list_fragment = list_fragment;
    }

    @Override
    public Fragment getItem(int i) {
        return list_fragment.get(i);
    }

    @Override
    public int getCount() {
        return list_fragment.size();
    }
}
