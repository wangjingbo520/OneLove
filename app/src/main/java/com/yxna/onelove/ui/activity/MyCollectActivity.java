package com.yxna.onelove.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.yxna.onelove.R;
import com.yxna.onelove.adapter.ViewPagerAdapter;
import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.ui.fragment.FindChildrenFragment;
import com.yxna.onelove.ui.fragment.collect.FacePackgeFragment;
import com.yxna.onelove.ui.fragment.collect.PictureTextFragment;
import com.yxna.onelove.ui.fragment.collect.QueAnswerFragment;
import com.yxna.onelove.ui.fragment.collect.TestFragment;
import com.yxna.onelove.ui.fragment.collect.VideoFragment;
import com.yxna.onelove.views.customviews.TitleView;

import java.util.ArrayList;

import butterknife.BindView;


/**
 * @author Bobo
 * @date 2019/9/21
 * describe
 */
public class MyCollectActivity extends BaseActivity {
    @BindView(R.id.titleView)
    TitleView titleView;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    private FragmentManager fragmentManager;
    private ArrayList<Fragment> mFragments;


    public static void start(Context context) {
        Intent starter = new Intent(context, MyCollectActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setTitle("我的收藏");
        fragmentManager = getSupportFragmentManager();
        mFragments = new ArrayList<>();
        String[] mTitles = {"图文", "视频", "测试", "问答", "表情包"};
        mFragments.add(new PictureTextFragment());
        mFragments.add(new VideoFragment());
        mFragments.add(new TestFragment());
        mFragments.add(new QueAnswerFragment());
        mFragments.add(new FacePackgeFragment());
        viewpager.setAdapter(new ViewPagerAdapter(fragmentManager, mTitles,
                mFragments));
        tabLayout.setupWithViewPager(viewpager);
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_collect;
    }


}
