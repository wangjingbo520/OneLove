package com.yxna.onelove.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yxna.onelove.utils.ToastUtil;

import butterknife.ButterKnife;

/**
 * @author wjb（H）
 * @date describe
 */
public abstract class BaseFragment extends Fragment {

    public void showToast(String message) {
        ToastUtil.showMessage(message);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(getContentLayout(), container, false);
        ButterKnife.bind(this, root);
        initView(root);
        initData();
        return root;
    }

    protected abstract int getContentLayout();

    protected abstract void initView(View root);

    protected abstract void initData();




}
