package com.yxna.onelove.views.customviews;

import android.content.Context;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author wjb（H）
 * @date describe
 */
public class MyRecyclerView extends RecyclerView {

    private static float DECELERATION_RATE = (float) (Math.log(0.78) / Math.log(0.9));
    private static final float INFLEXION = 0.35f; // Tension lines cross at (INFLEXION, 1)
    private float mFlingFriction = ViewConfiguration.getScrollFriction();
    private float mPhysicalCoeff;
    private static final String TAG = "MyRecyclerView";
    private final int height;

    public MyRecyclerView(Context context) {
        this(context, null);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        final float ppi = context.getResources().getDisplayMetrics().density * 160.0f;
        mPhysicalCoeff = SensorManager.GRAVITY_EARTH // g (m/s^2)
                * 39.37f // inch/meter
                * ppi
                * 0.84f; // look and feel tuning

        height = context.getResources().getDisplayMetrics().heightPixels;
    }

    public double getSplineDeceleration(int velocity) {
        return Math.log(INFLEXION * Math.abs(velocity) / (mFlingFriction * mPhysicalCoeff));
    }

    // 惯性滑动的距离
    public double getSplineFlingDistance(int velocity) {
        final double l = getSplineDeceleration(velocity);
        final double decelMinusOne = DECELERATION_RATE - 1.0;
        return mFlingFriction * mPhysicalCoeff * Math.exp(DECELERATION_RATE / decelMinusOne * l);
    }

    /* Returns the duration, expressed in milliseconds */
    public int getSplineFlingDuration(int velocity) {
        final double l = getSplineDeceleration(velocity);
        final double decelMinusOne = DECELERATION_RATE - 1.0;
        return (int) (1000.0 * Math.exp(l / decelMinusOne));
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(target, dx, dy, consumed);
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return super.onNestedPreFling(target, velocityX, velocityY);
    }

    @Override
    public boolean fling(int velocityX, int velocityY) {
        if (velocityY > 0) {
            if (getLayoutManager() != null
                    && getLayoutManager() instanceof LinearLayoutManager) {
                LinearLayoutManager manager = (LinearLayoutManager) getLayoutManager();
                final int firstPosition = manager.findFirstVisibleItemPosition();
                final int lastPosition = manager.findLastVisibleItemPosition();
// 假设一个item高度为 500， 通过惯性滑动距离和高度可以计算出来会经过多少个item
                int position = (int) (firstPosition + getSplineFlingDistance((int) velocityY) / 500);
// 以8个item为一个内容区
                int s1 = firstPosition / 8;
                int s = lastPosition > position ? lastPosition / 8 : position / 8;
                if (s > s1) {
                    s = s1 + 1;
                }
                int pos = s * 8;
                int top = height;
                if (s > s1 && lastPosition >= pos && pos > firstPosition) {
                    top = getChildAt(pos - firstPosition).getTop();
                }

                if (s > 0 && s > s1) {
                    smoothScrollToPosition(pos);
                    return true;
                }
            }
        }
        return super.fling(velocityX, velocityY);
    }

    public int getDisplyHeight() {
        return height;
    }

}
