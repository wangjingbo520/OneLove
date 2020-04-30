package com.yxna.onelove.ui.fragment;

import android.view.View;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseFragment;
import com.yxna.onelove.views.customviews.TitleView;

import butterknife.BindView;


/**
 * @author wjb
 * describe
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.titleView)
    TitleView titleView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getContentLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View root) {
        titleView.setTitle("首页");
        titleView.setBackImageGone(true);
    }

    @Override
    protected void initData() {

    }
}
