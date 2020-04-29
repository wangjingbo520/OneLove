package com.yxna.onelove.base;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yxna.onelove.utils.ToastUtil;

import butterknife.ButterKnife;

/**
 * @author wjb（H）
 * @date describe
 */
@SuppressLint("Registered")
public abstract class BaseActivity extends AppCompatActivity {
    public AppCompatActivity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        ButterKnife.bind(this);
        mActivity = this;
        initView(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract int getContentLayout();

    public void showToast(String message) {
        ToastUtil.showMessage(message);
    }


}
