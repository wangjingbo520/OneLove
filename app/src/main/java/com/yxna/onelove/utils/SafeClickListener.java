package com.yxna.onelove.utils;

import android.view.View;


/**
 * created by sws on 2020/3/31
 */
public abstract class SafeClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        if (CommUtils.isFastDoubleClick()) {
            return;
        }
        onClickEvent(v);
    }

    protected abstract void onClickEvent(View view);
}
