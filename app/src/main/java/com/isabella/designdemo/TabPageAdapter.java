package com.isabella.designdemo;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * description
 * Created by 张芸艳 on 2017/8/7.
 */

class TabPageAdapter extends FragmentPagerAdapter {
    private final Fragment[] fragments;
    private final String[] tabs;

    public TabPageAdapter(FragmentManager fm, Fragment[] fragments, String[] tabs) {
        super(fm);
        this.fragments = fragments;
        this.tabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
