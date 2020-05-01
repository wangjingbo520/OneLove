package com.yxna.onelove.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseActivity;


/**
 * @author Bobo
 * @date 2019/9/21
 * describe
 */
public class CollectActivity extends BaseActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, CollectActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_collect;
    }
}
