package com.yxna.onelove.base;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.gyf.immersionbar.ImmersionBar;
import com.yxna.onelove.utils.ToastUtil;

import butterknife.ButterKnife;


/**
 * @author wjb
 * describe
 */
@SuppressLint("Registered")
public abstract class BaseActivity extends AppCompatActivity {
    public AppCompatActivity mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentLayout());
        ButterKnife.bind(this);
        initImmersionBar();
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

    /**
     * 初始化沉浸式
     * Init immersion bar.
     */
    protected void initImmersionBar() {
        //设置共同沉浸式样式
        ImmersionBar.with(this)
                .statusBarDarkFont(true)
                .navigationBarDarkIcon(false)
                .init();
    }


}
