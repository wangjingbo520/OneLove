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
 * @author wjb
 * describe
 */
public class UpdatePhoneActivity extends BaseActivity {

    @BindView(R.id.titleView)
    TitleView titleView;

    public static void start(Context context) {
        Intent starter = new Intent(context,
                UpdatePhoneActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setTitle("修改手机号");
        titleView.setBackfinishListenser(this);
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_update_phone;
    }
}
