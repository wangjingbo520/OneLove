package com.yxna.onelove.ui.activity;

import android.os.Bundle;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseVRActivity;
import com.yxna.onelove.views.customviews.TitleView;

import butterknife.BindView;

/**
 * @author wjb
 * describe
 */
public class SettingActivity extends BaseVRActivity {

    @BindView(R.id.titleView)
    TitleView titleView;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setTitle("设置");
        titleView.setBackfinishListenser(this);
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_setting;
    }

}
