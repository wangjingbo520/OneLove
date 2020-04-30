package com.yxna.onelove.ui.fragment;

import android.content.Intent;
import android.view.View;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseFragment;
import com.yxna.onelove.ui.activity.SettingActivity;
import com.yxna.onelove.views.customviews.TitleView;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author Bobo
 * @date 2019/9/21
 * describe
 */

public class MyFragment extends BaseFragment {
    @BindView(R.id.titleView)
    TitleView titleView;

    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getContentLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView(View root) {
        titleView.setBackImageGone(true);
        titleView.setTitle("我的");

    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(), SettingActivity.class));
    }
}
