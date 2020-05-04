package com.yxna.onelove.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.views.customviews.TitleView;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author wjb
 * describe
 */
public class RealLoveActivity extends BaseActivity implements View.OnTouchListener {

    @BindView(R.id.titleView)
    TitleView titleView;

    private static final int FLING_MIN_DISTANCE = 50;   //最小距离
    private static final int FLING_MIN_VELOCITY = 0;  //最小速度

    public static void start(Context context) {
        Intent starter = new Intent(context, RealLoveActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void initData() {

    }

    private GestureDetector mGestureDetector;

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setTitle("真爱识别器");
        titleView.setRightDrawable(R.mipmap.text_icon_colletc_nosel);

        mGestureDetector = new GestureDetector(this, myGestureListener);

        FrameLayout frameLayout = findViewById(R.id.fl);
        frameLayout.setOnTouchListener(this);
        frameLayout.setLongClickable(true);

    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_real_love;
    }


    @OnClick(R.id.tvBeginTest)
    public void onViewClicked() {
        AnswerQuestionActivity.start(mActivity);
    }


    GestureDetector.SimpleOnGestureListener myGestureListener = new GestureDetector.SimpleOnGestureListener() {
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            Log.e("<--滑动测试-->", "开始滑动");
            float x = e1.getX() - e2.getX();
            float x2 = e2.getX() - e1.getX();
            if (x > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                Toast.makeText(RealLoveActivity.this, "向左手势", Toast.LENGTH_SHORT).show();

                // startActivity(new Intent(HuadongTestActivity.this,HuadongOtherActivity.class));

            } else if (x2 > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY) {
                Toast.makeText(RealLoveActivity.this, "向右手势", Toast.LENGTH_SHORT).show();
            }

            return false;
        }
    };

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return mGestureDetector.onTouchEvent(motionEvent);
    }


//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//        // TODO Auto-generated method stub
//        return mGestureDetector.onTouchEvent(event);
//    }
}
