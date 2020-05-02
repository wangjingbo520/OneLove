package com.yxna.onelove.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.gyf.immersionbar.ImmersionBar;
import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseActivity;

/**
 * @author wjb
 * describe
 */
public class PurchaseVipActivity extends BaseActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, PurchaseVipActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
//        ImmersionBar.with(this).statusBarView(R.id.top_view)
//                .navigationBarColor(R.color.colorPrimary)
//                .fullScreen(true)
//                .addTag("PicAndColor")
//                .init();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_purchase_vip;
    }
}
