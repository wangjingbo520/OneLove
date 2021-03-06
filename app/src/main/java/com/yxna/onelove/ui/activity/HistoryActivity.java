package com.yxna.onelove.ui.activity;

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
public class HistoryActivity extends BaseActivity {

    @BindView(R.id.titleView)
    TitleView titleView;

    public static void start(Context context) {
        Intent starter = new Intent(context, HistoryActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setTitle("历史");

    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_history;
    }
}
