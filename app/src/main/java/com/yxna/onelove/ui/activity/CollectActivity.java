package com.yxna.onelove.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.views.customviews.TitleView;

import butterknife.BindView;


/**
 * @author Bobo
 * @date 2019/9/21
 * describe
 */
public class CollectActivity extends BaseActivity {
    @BindView(R.id.titleView)
    TitleView titleView;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    public static void start(Context context) {
        Intent starter = new Intent(context, CollectActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setTitle("我的收藏");

    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_collect;
    }
}
