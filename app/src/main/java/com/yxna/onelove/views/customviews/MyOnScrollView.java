package com.yxna.onelove.views.customviews;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author wjb（H）
 * @date describe
 */
public class MyOnScrollView extends RecyclerView.OnScrollListener {

    public MyOnScrollView(IScrollView iScrollView) {
        this.iScrollView = iScrollView;
    }

    private boolean isSlidingToLeft = false;
    private IScrollView iScrollView;
    private int index = 0;

    public IScrollView getiScrollView() {
        return iScrollView;
    }

    public void setiScrollView(IScrollView iScrollView) {
        this.iScrollView = iScrollView;
    }

    public interface IScrollView {
        void scrollIndex(int position);
    }

    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        LinearLayoutManager manager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
            if (recyclerView.getChildCount() > 0) {
                index = ((RecyclerView.LayoutParams) recyclerView.getChildAt(0).getLayoutParams()).getViewAdapterPosition();
                if (iScrollView != null) {
                    iScrollView.scrollIndex(index + 1);
                }
            }

            // 获取最后一个完全显示的itemPosition
            int lastItemPosition = manager.findLastCompletelyVisibleItemPosition();
            int itemCount = manager.getItemCount();
            // 滑动到了最后一个
            if (lastItemPosition == (itemCount - 1) && isSlidingToLeft) {
                Log.e("====>", "onScrollStateChanged: 滑动到了最后一个");
            }
        }
    }

}

