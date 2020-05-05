package com.yxna.onelove.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.yxna.onelove.R;
import com.yxna.onelove.adapter.AnsQuestionAdapter;
import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.utils.OnSingleClickListener;
import com.yxna.onelove.views.customviews.MyLinearLayout;
import com.yxna.onelove.views.customviews.MyOnScrollView;
import com.yxna.onelove.views.customviews.TitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * @author wjb
 * describe 答題
 */
public class AnswerQuestionActivity extends BaseActivity implements AnsQuestionAdapter.INextQuestion, MyOnScrollView.IScrollView {
    @BindView(R.id.titleView)
    TitleView titleView;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.tvIndex)
    TextView tvIndex;
    @BindView(R.id.llRoot)
    MyLinearLayout llRoot;

    private AnsQuestionAdapter adapter;
    private MyOnScrollView myOnScrollView;

    private int index = 0;
    private int currentPage = 1;

    public static void start(Context context) {
        Intent starter = new Intent(context, AnswerQuestionActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setTitle("真爱识别器");
        PagerSnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);
        List<String> list = new ArrayList<>();
        list.add("==");
        list.add("==");
        list.add("==");
        list.add("==");
        list.add("==");

        tvIndex.setText("1/5");
        myOnScrollView = new MyOnScrollView(this);
        adapter = new AnsQuestionAdapter(R.layout.question_layout, list);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(myOnScrollView);
        adapter.setiNextQuestion(this);
        findViewById(R.id.btn1).setOnClickListener(new OnSingleClickListener() {
            @Override
            protected void onSingleClick(View view) {
                recyclerView.smoothScrollToPosition(index + 1);
            }
        });
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_answer_question;
    }

    @Override
    public void nextQuestion(int postion, String question) {
        recyclerView.smoothScrollToPosition(postion + 1);
    }


    @Override
    public void scrollIndex(int position) {
        tvIndex.setText(position + "/5");
    }

}
