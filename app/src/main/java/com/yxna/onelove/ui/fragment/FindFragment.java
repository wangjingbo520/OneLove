package com.yxna.onelove.ui.fragment;

import android.view.View;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.yxna.onelove.R;
import com.yxna.onelove.adapter.ViewPagerAdapter;
import com.yxna.onelove.base.BaseFragment;
import com.yxna.onelove.ui.activity.FindSearchActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author wjb
 * describe
 */
public class FindFragment extends BaseFragment {

    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.etSearchResult)
    EditText etSearchResult;

    private FragmentManager fragmentManager;
    private ArrayList<Fragment> mFragments;

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initView(View root) {
        fragmentManager = getChildFragmentManager();
        mFragments = new ArrayList<>();
        String[] mTitles = {"全部", "demo2", "demo3", "demo4", "demo5", "demo6", "demo7", "demo8"};
        mFragments.add(new AllFragment());
        mFragments.add(new FindChildrenFragment());
        mFragments.add(new FindChildrenFragment());
        mFragments.add(new FindChildrenFragment());
        mFragments.add(new FindChildrenFragment());
        mFragments.add(new FindChildrenFragment());
        mFragments.add(new FindChildrenFragment());
        mFragments.add(new FindChildrenFragment());
        viewpager.setOffscreenPageLimit(3);
        viewpager.setAdapter(new ViewPagerAdapter(fragmentManager, mTitles,
                mFragments));
        tabLayout.setupWithViewPager(viewpager);
        //  setIndicator(tlTab);

    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.etSearchResult, R.id.ivClearResult})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.etSearchResult:
                FindSearchActivity.start(mContext);
                break;
            case R.id.ivClearResult:
                etSearchResult.setText("");
                break;
        }
    }
}
