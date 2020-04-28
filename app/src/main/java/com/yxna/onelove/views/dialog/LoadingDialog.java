package com.yxna.onelove.views.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.yxna.onelove.R;
import com.yxna.onelove.views.dialog.BaseDialog;


/**
 * @author Bobo
 * @date 2019/9/21
 * describe
 */
public class LoadingDialog extends BaseDialog {

    public LoadingDialog(Context context) {
        super(context);
    }

    @Override
    protected View getDefaultView(Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.loading_dialog, null);
        return v;
    }
}
