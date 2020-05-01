package com.yxna.onelove.views.dialog.pic;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;


import com.luck.picture.lib.tools.ToastUtils;
import com.yxna.onelove.R;
import com.yxna.onelove.utils.CommUtils;

import java.util.List;

/**
 * created by sws on 2020/4/1
 */
public abstract class BaseDialogFragment extends DialogFragment {

    protected void setDialogWidthHeight(float widthPercent, float heightPercent) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            if (window != null) {
                int widthPixels =
                        window.getContext().getResources().getDisplayMetrics().widthPixels;
                int heightPixels =
                        window.getContext().getResources().getDisplayMetrics().heightPixels;
                int width = widthPercent == 0 ? ViewGroup.LayoutParams.WRAP_CONTENT :
                        (int) (widthPixels * widthPercent);
                int height = heightPercent == 0 ? ViewGroup.LayoutParams.WRAP_CONTENT :
                        (int) (heightPixels * heightPercent);
                window.setLayout(width, height);
            }
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isEnabledNormalStyle()) {
            setNormalStyle();
        }
        Bundle arguments = getArguments();
        if (arguments != null) {
            initArgs(arguments);
        }
    }

    protected void initArgs(Bundle args) {

    }

    protected boolean isEnabledNormalStyle() {
        return false;
    }

    private void setNormalStyle() {
        setStyle(STYLE_NO_FRAME, R.style.NormalDialogStyle);
    }

    @Override
    public void dismiss() {
        mDialogCancelCallback = null;
        if (mDialogDismissCallback != null) {
            mDialogDismissCallback.onDismiss();
        }
        mDialogDismissCallback = null;
        if (isResumed()) {
            super.dismiss();
        } else {
            super.dismissAllowingStateLoss();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (enterFromBottom()) {
            setPopupBottom();
        }
    }

    protected void setPopupBottom() {
        Dialog dialog = getDialog();
        if (dialog != null) {
            // 设置显示动画
            dialog.setCanceledOnTouchOutside(true);
            Window window = dialog.getWindow();
            if (window != null) {
                window.setWindowAnimations(R.style.Pop_window_anim_style);
                WindowManager.LayoutParams wl = window.getAttributes();
                wl.x = 0;
                wl.y = CommUtils.getScreenHeight(requireContext());
                // 设置显示位置
                dialog.onWindowAttributesChanged(wl);
            }
        }
    }

    protected boolean enterFromBottom() {
        return false;
    }

    protected boolean isDestroy;

    @Override
    public void onDestroy() {
        super.onDestroy();
        isDestroy = true;
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        if (mDialogCancelCallback != null) {
            mDialogCancelCallback.onCancel();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(requireContext()).inflate(attachLayoutId(), container,
                false);
        initView(view);
        return view;
    }

    protected abstract @LayoutRes int attachLayoutId();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    protected abstract void initView(View view);

    protected abstract void initData();

    @Override
    public void show(@NonNull FragmentManager manager, String tag) {
        try {
            super.show(manager, tag);
        } catch (IllegalStateException ignore) {
            //  容错处理,不做操作
        }
    }



    protected DialogCancelCallback mDialogCancelCallback;

    public void setDialogCancelCallback(DialogCancelCallback callback) {
        mDialogCancelCallback = callback;
    }

    public interface DialogCancelCallback {
        void onCancel();
    }

    protected <T extends View> T findView(View view, @IdRes int id) {
        return view.findViewById(id);
    }

    private DialogDismissCallback mDialogDismissCallback;

    public void setDialogDismissCallback(DialogDismissCallback callback) {
        mDialogDismissCallback = callback;
    }

    public interface DialogDismissCallback {
        void onDismiss();
    }

    public interface OnPicSelectorResultCallback {
        void onResult(List<String> pics);
    }
}
