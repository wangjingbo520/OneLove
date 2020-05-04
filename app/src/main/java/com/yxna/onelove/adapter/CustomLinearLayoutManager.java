package com.yxna.onelove.adapter;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author wjb（H）
 * @date describe
 */
public class CustomLinearLayoutManager extends LinearLayoutManager {
    private boolean isScrollEnabled = true;

    //
    public CustomLinearLayoutManager(Context context) {
        super(context);
    }

    public void setScrollEnabled(boolean flag) {
        this.isScrollEnabled = flag;
    }
//
//
//    /**
//     * 禁止滑动
//     * canScrollHorizontally（禁止横向滑动）
//     *
//     * @return
//     */
//    @Override
//    public boolean canScrollHorizontally() {
//        return isScrollEnabled && super.canScrollVertically();
//    }


    @Override
    public boolean canScrollHorizontally() {
        return isScrollEnabled;
    }
}
