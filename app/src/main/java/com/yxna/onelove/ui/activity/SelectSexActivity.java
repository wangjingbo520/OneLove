package com.yxna.onelove.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.views.customviews.TitleView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectSexActivity extends BaseActivity implements TitleView.IRigntListener {
    @BindView(R.id.titleView)
    TitleView titleView;
    @BindView(R.id.ivLeft)
    ImageView ivLeft;
    @BindView(R.id.ivRight)
    ImageView ivRight;

    //1:男性   2：女生
    private int sex;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setRightDrawable(R.mipmap.close);
        titleView.setBackImageGone(true);
        titleView.setRightListenser(this);
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_select_sex;
    }

    @Override
    public void onTitleRightClick() {
        if (sex == 0) {
            showToast("您还没选择性别");
            return;
        }

        finish();
    }


    @OnClick({R.id.ivLeft, R.id.ivRight})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivLeft:
                ivLeft.setImageResource(R.mipmap.sexual_icon_boy_sel);
                ivRight.setImageResource(R.mipmap.sexual_icon_gril_nosel);
                sex = 1;
                break;
            case R.id.ivRight:
                ivLeft.setImageResource(R.mipmap.sexual_icon_boy_nosel);
                ivRight.setImageResource(R.mipmap.sexual_icon_gril_sel);
                sex = 2;
                break;
            default:
                break;
        }
    }
}
