package com.yxna.onelove.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.yxna.onelove.MainActivity;
import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.views.customviews.TitleView;
import com.yxna.onelove.views.dialog.pic.BaseDialogFragment;
import com.yxna.onelove.views.dialog.pic.UploadCommDialogFragment;

import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author wjb
 * describe
 */
public class MyInfoActivity extends BaseActivity {

    @BindView(R.id.titleView)
    TitleView titleView;

    public static void start(Context context) {
        Intent starter = new Intent(context, MyInfoActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void initData() {
        titleView.setTitle("个人资料");
        titleView.setBackfinishListenser(this);
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
                dateSelector();
                break;
            case R.id.llPhone:
                UpdatePhoneActivity.start(this);
                break;
        }
    }

    private void dateSelector() {
        TimePickerView pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
//                Toast.makeText(MainActivity.this, getTime(date), Toast.LENGTH_SHORT).show();
            }
        }).setTitleText("选择日期")
                .setTitleColor(R.color.themeColor)
                .setCancelColor(R.color.themeColor)
                .setSubmitColor(R.color.themeColor).build();
        pvTime.show();
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
