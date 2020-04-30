package com.yxna.onelove.utils;

import android.view.View;

/**
 * @author wjb
 * describe
 */
public abstract class OnSingleClickListener implements View.OnClickListener {

    //两次点击按钮的最小间隔，目前为1000
    private static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime;

    abstract void onSingleClick(View view);

    @Override
    public void onClick(View v) {
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
            lastClickTime = curClickTime;
            onSingleClick(v);
        }
    }
}