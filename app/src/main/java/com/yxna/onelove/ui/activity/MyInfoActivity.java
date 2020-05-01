package com.yxna.onelove.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.views.customviews.TitleView;
import com.yxna.onelove.views.dialog.pic.BaseDialogFragment;
import com.yxna.onelove.views.dialog.pic.UploadCommDialogFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author wjb
 * describe
 */
public class MyInfoActivity extends BaseActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, MyInfoActivity.class);
        context.startActivity(starter);
    }

    @BindView(R.id.titleView)
    TitleView titleView;

    @Override
    protected void initData() {
        titleView.setTitle("个人资料");
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_my_info;
    }


    @OnClick({R.id.llPic, R.id.llNichen, R.id.llAge, R.id.llPhone})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llPic:
                showPopwindow();
                break;
            case R.id.llNichen:
                break;
            case R.id.llAge:
                break;
            case R.id.llPhone:
                break;
        }
    }


    private void showPopwindow() {
        UploadCommDialogFragment picDialogFragment = UploadCommDialogFragment.newInstance(1, true, true);
        picDialogFragment.setOnPicSelectorResultCallback(new BaseDialogFragment.OnPicSelectorResultCallback() {
            @Override
            public void onResult(List<String> beanList) {

            }
        });
        picDialogFragment.show(getSupportFragmentManager(), "UploadPicDialogFragment");
    }
}
