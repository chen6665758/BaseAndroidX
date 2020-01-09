package com.cg.baseandroidx.Adapters;


import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class tempVpAdapter extends FragmentPagerAdapter {

    private List<Fragment> list_fragment;

    public tempVpAdapter(FragmentManager fm, List<Fragment> list_fragment) {
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
