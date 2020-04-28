package com.yxna.onelove;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.ui.fragment.AskFragment;
import com.yxna.onelove.ui.fragment.FindFragment;
import com.yxna.onelove.ui.fragment.HomeFragment;
import com.yxna.onelove.ui.fragment.MyFragment;
import com.yxna.onelove.views.customviews.TabView;
import com.yxna.onelove.views.customviews.TitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author wjb
 * describe
 */
public class TabHomeActivity extends BaseActivity {
    @BindView(R.id.titleView)
    TitleView titleView;
    @BindView(R.id.ivHome)
    ImageView ivHome;
    @BindView(R.id.tvHome)
    TextView tvHome;
    @BindView(R.id.ivAsk)
    ImageView ivAsk;
    @BindView(R.id.tvAsk)
    TextView tvAsk;
    @BindView(R.id.ivFind)
    ImageView ivFind;
    @BindView(R.id.tvFind)
    TextView tvFind;
    @BindView(R.id.ivMy)
    ImageView ivMy;
    @BindView(R.id.tvMy)
    TextView tvMy;

    private static final String HOME_FRAGMENT_KEY = "homeFragment";
    private static final String ASK_FRAGMENT_KEY = "askFragment";
    private static final String FIND_FRAGMENT_KEY = "findFragment";
    private static final String MY_FRAGMENT_KEY = "myFragment";

    private TabView tabHome;
    private TabView tabAsk;
    private TabView tabFind;
    private TabView tabMy;

    private TabView curTab;

    private HomeFragment homeFragment;
    private AskFragment askFragment;
    private FindFragment findFragment;
    private MyFragment myFragment;

    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void initData() {

    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_tab_home;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setBackImageGone(true);
        titleView.setTitle("首页");
        initTab();
        if (savedInstanceState != null) {
            /*获取保存的fragment  没有的话返回null*/
            homeFragment = (HomeFragment) getSupportFragmentManager().getFragment
                    (savedInstanceState, HOME_FRAGMENT_KEY);
            askFragment = (AskFragment) getSupportFragmentManager().getFragment
                    (savedInstanceState, ASK_FRAGMENT_KEY);
            findFragment = (FindFragment) getSupportFragmentManager().getFragment
                    (savedInstanceState, FIND_FRAGMENT_KEY);
            myFragment = (MyFragment) getSupportFragmentManager().getFragment
                    (savedInstanceState, MY_FRAGMENT_KEY);
            addToList(homeFragment);
            addToList(askFragment);
            addToList(findFragment);
            addToList(myFragment);
        } else {
            initFragment();
        }
    }

    private void initTab() {
        tabHome = new TabView();
        tabHome.setView(ivHome, tvHome);
        tabHome.setIcon(R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        tabHome.setTextColor(getResources().getColor(R.color.white), getResources().getColor(R
                .color.white));

        tabAsk = new TabView();
        tabAsk.setView(ivAsk, tvAsk);
        tabAsk.setIcon(R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        tabAsk.setTextColor(getResources().getColor(R.color.white), getResources().getColor(R
                .color.white));

        tabFind = new TabView();
        tabFind.setView(ivFind, tvFind);
        tabFind.setIcon(R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        tabFind.setTextColor(getResources().getColor(R.color.white), getResources().getColor(R
                .color.white));

        tabMy = new TabView();
        tabMy.setView(ivMy, tvMy);
        tabMy.setIcon(R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        tabMy.setTextColor(getResources().getColor(R.color.white), getResources().getColor(R
                .color.white));

        curTab = tabHome;
    }

    private void initFragment() {
        /* 默认显示home  fragment*/
        homeFragment = new HomeFragment();
        addFragment(homeFragment);
        showFragment(homeFragment);
    }

    private void addFragment(Fragment fragment) {
        if (!fragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().add(R.id.tab_content, fragment).commit();
            fragmentList.add(fragment);
        }
    }

    private void showFragment(Fragment fragment) {
        for (Fragment frag : fragmentList) {
            if (frag != fragment) {
                getSupportFragmentManager().beginTransaction().hide(frag).commit();
            }
        }
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        if (homeFragment != null) {
            getSupportFragmentManager().putFragment(outState, HOME_FRAGMENT_KEY, homeFragment);
        }
        if (askFragment != null) {
            getSupportFragmentManager().putFragment(outState, ASK_FRAGMENT_KEY,
                    askFragment);
        }
        if (findFragment != null) {
            getSupportFragmentManager().putFragment(outState, FIND_FRAGMENT_KEY, findFragment);
        }

        if (myFragment != null) {
            getSupportFragmentManager().putFragment(outState, MY_FRAGMENT_KEY, myFragment);
        }

        super.onSaveInstanceState(outState);
    }

    private void addToList(Fragment fragment) {
        if (fragment != null) {
            fragmentList.add(fragment);
        }
    }


    @OnClick({R.id.llHome, R.id.llAsk, R.id.llFind, R.id.llMy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llHome:
                setChecked(1);
                break;
            case R.id.llAsk:
                setChecked(2);
                break;
            case R.id.llFind:
                setChecked(3);
                break;
            case R.id.llMy:
                setChecked(4);
                break;
            default:
                break;
        }
    }

    private void setChecked(int index) {
        switch (index) {
            case 1:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                addFragment(homeFragment);
                showFragment(homeFragment);
                titleView.setTitle("首页");
                selectTab(tabHome);
                break;
            case 2:
                if (askFragment == null) {
                    askFragment = new AskFragment();
                }
                addFragment(askFragment);
                showFragment(askFragment);
                titleView.setTitle("问答");
                selectTab(tabAsk);
                break;
            case 3:
                if (findFragment == null) {
                    findFragment = new FindFragment();
                }
                addFragment(findFragment);
                showFragment(findFragment);
                titleView.setTitle("发现");
                selectTab(tabFind);
                break;
            case 4:
                if (myFragment == null) {
                    myFragment = new MyFragment();
                }
                addFragment(myFragment);
                showFragment(myFragment);
                titleView.setTitle("我的");
                selectTab(tabMy);
                break;
            default:
                break;
        }
    }

    private void selectTab(TabView tabView) {
        if (null != tabView && !tabView.equals(curTab)) {
            curTab.clickIn();
            tabView.clickOn();
            curTab = tabView;
        }
    }
}
