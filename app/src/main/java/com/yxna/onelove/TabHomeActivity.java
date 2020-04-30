package com.yxna.onelove;

import android.os.Bundle;

import com.gyf.immersionbar.ImmersionBar;
import com.yxna.onelove.adapter.MainViewPagerAdapter;
import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.ui.fragment.AskFragment;
import com.yxna.onelove.ui.fragment.FindFragment;
import com.yxna.onelove.ui.fragment.HomeFragment;
import com.yxna.onelove.ui.fragment.MyFragment;
import com.yxna.onelove.views.customviews.NoAnimationViewPager;
import com.yxna.onelove.views.customviews.bottomview.NavigationController;
import com.yxna.onelove.views.customviews.bottomview.PageNavigationView;

import butterknife.BindView;

/**
 * @author wjb
 * describe
 */
public class TabHomeActivity extends BaseActivity {
    @BindView(R.id.act_main_bottom_view)
    PageNavigationView mPageNavigationView;
    @BindView(R.id.viewpager)
    NoAnimationViewPager viewpager;

    private HomeFragment homeFragment;
    private AskFragment askFragment;
    private FindFragment findFragment;
    private MyFragment myFragment;

    private MainViewPagerAdapter mMainViewPagerAdapter;
    private NavigationController mNavigationController;

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .init();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_tab_home;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initTab();
    }

    private void initTab() {
        homeFragment = new HomeFragment();
        askFragment = new AskFragment();
        findFragment = new FindFragment();
        myFragment = new MyFragment();
        mMainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager(), 0, this);
        mMainViewPagerAdapter.addFragment(homeFragment);
        mMainViewPagerAdapter.addFragment(askFragment);
        mMainViewPagerAdapter.addFragment(findFragment);
        mMainViewPagerAdapter.addFragment(myFragment);
        viewpager.setAdapter(mMainViewPagerAdapter);

        mNavigationController = mPageNavigationView.material()
                .dontTintIcon()
                .setRipperColor(getColor(R.color.textColor9))
                .addItem(
                        R.mipmap.ic_launcher,
                        R.mipmap.ic_launcher,
                        "首页",
                        getColor(R.color.themeColor))
                .addItem(
                        R.mipmap.ic_launcher,
                        R.mipmap.ic_launcher,
                        "问答",
                        getColor(R.color.themeColor))
                .addItem(
                        R.mipmap.ic_launcher,
                        R.mipmap.ic_launcher,
                        "发现",
                        getColor(R.color.themeColor))
                .addItem(
                        R.mipmap.ic_launcher,
                        R.mipmap.ic_launcher,
                        "我的",
                        getColor(R.color.themeColor))
                .setDefaultColor(getColor(R.color.textColor3))
                .build();
        mNavigationController.setupWithViewPager(viewpager);
    }


}
