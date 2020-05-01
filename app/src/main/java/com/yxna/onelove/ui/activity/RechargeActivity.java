package com.yxna.onelove.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yxna.onelove.R;
import com.yxna.onelove.adapter.ChargeAdapter;
import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.bean.ChargeModel;
import com.yxna.onelove.views.customviews.MyGridView;
import com.yxna.onelove.views.customviews.TitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @author Bobo
 * @date 2019/9/21
 * describe
 */
public class RechargeActivity extends BaseActivity {
    @BindView(R.id.titleView)
    TitleView titleView;
    @BindView(R.id.gridview)
    MyGridView gridview;
    private ChargeAdapter chargeAdapter;


    public static void start(Context context) {
        Intent starter = new Intent(context, RechargeActivity.class);
        context.startActivity(starter);
    }


    @Override
    protected void initData() {
        List<ChargeModel> list = new ArrayList<>();
        String[] content = mActivity.getResources().getStringArray(R.array.charge);
        String[] money = mActivity.getResources().getStringArray(R.array.money);
        for (int i = 0; i < content.length; i++) {
            list.add(new ChargeModel(content[i], money[i]));
        }

        chargeAdapter = new ChargeAdapter(this, list);
        gridview.setAdapter(chargeAdapter);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setTitle("金币充值");
        titleView.setBackfinishListenser(this);
        titleView.setRightDrawable(R.mipmap.icon_help);
        titleView.setRightListenser(() -> {
        });
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_recharge;
    }


    @OnClick({R.id.tvDetail, R.id.tvPay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvDetail:
                BalanceDetailActivity.start(mActivity);
                break;
            case R.id.tvPay:
                break;
        }
    }
}
