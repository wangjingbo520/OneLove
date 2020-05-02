package com.yxna.onelove.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yxna.onelove.utils.ToastUtil;

import butterknife.ButterKnife;

/**
 * @author wjb（H）
 * @date describe
 */
public abstract class BaseFragment extends Fragment {

    public Activity mContext;

    public void showToast(String message) {
        ToastUtil.showMessage(message);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(getContentLayout(), container, false);
        ButterKnife.bind(this, root);
        mContext = getActivity();
        initView(root);
        initData();
        return root;
    }

    protected abstract int getContentLayout();

    protected abstract void initView(View root);

    protected abstract void initData();


}
