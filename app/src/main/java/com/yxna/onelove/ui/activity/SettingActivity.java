package com.yxna.onelove.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseVRActivity;
import com.yxna.onelove.views.customviews.TitleView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author wjb
 * describe
 */
public class SettingActivity extends BaseVRActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, SettingActivity.class);
        context.startActivity(starter);
    }

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


    @OnClick({R.id.llMessageNotifi, R.id.llHistory, R.id.llBindAccount,
            R.id.llPersonInfo, R.id.llServer, R.id.llYinsi,
            R.id.llAboutUs, R.id.llClearCache, R.id.llExitLogin})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llMessageNotifi:
                break;
            case R.id.llHistory:
                break;
            case R.id.llBindAccount:
                BindAccountActivity.start(this);
                break;
            case R.id.llPersonInfo:
                MyInfoActivity.start(this);
                break;
            case R.id.llServer:
                break;
            case R.id.llYinsi:
                break;
            case R.id.llAboutUs:
                break;
            case R.id.llClearCache:
                break;
            case R.id.llExitLogin:
                break;
        }
    }
}
