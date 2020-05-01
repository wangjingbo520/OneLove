package com.yxna.onelove.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.views.customviews.TitleView;

import butterknife.BindView;


/**
 * @author Bobo
 * @date 2019/9/21
 * describe
 */
public class BalanceDetailActivity extends BaseActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, BalanceDetailActivity.class);
        context.startActivity(starter);
    }

    @BindView(R.id.titleView)
    TitleView titleView;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setTitle("余额明细");
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_balance_detail;
    }
}
