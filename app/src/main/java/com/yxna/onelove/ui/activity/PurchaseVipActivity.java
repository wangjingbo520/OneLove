package com.yxna.onelove.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseActivity;

import butterknife.OnClick;

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
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_purchase_vip;
    }


    @OnClick({R.id.tvBack, R.id.tvOpen})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvBack:
                finish();
                break;
            case R.id.tvOpen:
                break;
            default:
                break;
        }
    }
}
