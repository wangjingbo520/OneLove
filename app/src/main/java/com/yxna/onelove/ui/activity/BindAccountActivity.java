package com.yxna.onelove.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.views.customviews.TitleView;

import butterknife.BindView;

/**
 * @author wjb
 * describe
 */
public class BindAccountActivity extends BaseActivity {

    @BindView(R.id.titleView)
    TitleView titleView;

    public static void start(Context context) {
        Intent starter = new Intent(context, BindAccountActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setBackfinishListenser(this);
        titleView.setTitle("绑定账号");
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_bind_account;
    }
}
