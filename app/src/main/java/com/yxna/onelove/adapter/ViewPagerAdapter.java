package com.yxna.onelove.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * @author wjb（H）
 * @date describe
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String[] mTitles;
    private ArrayList<Fragment> mFragments;

    public ViewPagerAdapter(FragmentManager fm, String[] mTitles, ArrayList<Fragment>
            mFragments) {
        super(fm);
        this.mTitles = mTitles;
        this.mFragments = mFragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

}
