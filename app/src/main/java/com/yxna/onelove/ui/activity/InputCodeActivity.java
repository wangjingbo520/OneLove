package com.yxna.onelove.ui.activity;

import android.content.Intent;
import android.os.Bundle;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.views.customviews.PhoneCode;
import com.yxna.onelove.views.customviews.TitleView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author Bobo
 * @date 2019/9/21
 * describe
 */
public class InputCodeActivity extends BaseActivity {

    @BindView(R.id.titleView)
    TitleView titleView;
    @BindView(R.id.phoneCode)
    PhoneCode phoneCode;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setBackfinishListenser(mActivity);
        phoneCode.setOnInputListener(new PhoneCode.OnInputListener() {
            @Override
            public void onSucess(String code) {
                //TODO: 例如底部【下一步】按钮可点击
                startActivity(new Intent(InputCodeActivity.this, SelectSexActivity.class));
            }

            @Override
            public void onInput() {
                //TODO:例如底部【下一步】按钮不可点击

            }
        });
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_input_code;
    }


}
