package com.yxna.onelove.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.views.customviews.TitleView;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author wjb
 * describe
 */
public class RealLoveActivity extends BaseActivity {

    @BindView(R.id.titleView)
    TitleView titleView;

    public static void start(Context context) {
        Intent starter = new Intent(context, RealLoveActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setTitle("真爱识别器");
        titleView.setRightDrawable(R.mipmap.text_icon_colletc_nosel);
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_real_love;
    }


    @OnClick(R.id.tvBeginTest)
    public void onViewClicked() {
        AnswerQuestionActivity.start(mActivity);
    }
}
