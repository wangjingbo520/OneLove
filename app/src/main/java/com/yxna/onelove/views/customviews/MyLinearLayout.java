package com.yxna.onelove.views.customviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

/**
 * @author wjb（H）
 * @date describe
 */
public class MyLinearLayout extends LinearLayout {

    private boolean isCanHozLeftScroll = true;
    private boolean isCanHozRightScroll = true;

    float x1 = 0;
    float x2 = 0;


    public void setCanHozLeftScroll(boolean canHozLeftScroll) {
        isCanHozLeftScroll = canHozLeftScroll;
    }

    public void setCanHozRightScroll(boolean canHozRightScroll) {
        isCanHozRightScroll = canHozRightScroll;
    }

    public MyLinearLayout(Context context) {
        super(context);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            x1 = event.getX();
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            x2 = event.getX();
            if (x1 - x2 > 0) {
                return isCanHozLeftScroll;
            }
        }

        return super.onInterceptTouchEvent(event);
    }
}
