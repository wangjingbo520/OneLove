package com.yxna.onelove.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.yxna.onelove.MainActivity;
import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.views.customviews.TitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * @author wjb
 * describe 答題
 */
public class AnswerQuestionActivity extends BaseActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, AnswerQuestionActivity.class);
        context.startActivity(starter);
    }

    @BindView(R.id.titleView)
    TitleView titleView;

    @Override
    protected void initData() {


    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setTitle("真爱识别器");
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_answer_question;
    }

    private void init(){
        //上一题
//        btn_up.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (corrent > 0) {
//                    corrent--;
//
//                    Question q = list.get(corrent);
//
//                    tv_title.setText(q.question);
//
//                    mRadioButton[0].setText(q.answerA);
//                    mRadioButton[1].setText(q.answerB);
//                    mRadioButton[2].setText(q.answerC);
//                    mRadioButton[3].setText(q.answerD);
//
//                    tv_result.setText(q.explaination);
//
//                    mRadioGroup.clearCheck();
//
//                    //设置选中
//                    if (q.selectedAnswer != -1) {
//                        mRadioButton[q.selectedAnswer].setChecked(true);
//                    }
//                }
//
//            }
//        });
//
//        //下一题
//        btn_down.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //判断是否为最后一题
//                if (corrent < count - 1) {
//                    corrent++;
//                    Question q = list.get(corrent);
//
//                    tv_title.setText(q.question);
//
//                    mRadioButton[0].setText(q.answerA);
//                    mRadioButton[1].setText(q.answerB);
//                    mRadioButton[2].setText(q.answerC);
//                    mRadioButton[3].setText(q.answerD);
//
//                    tv_result.setText(q.explaination);
//
//                    mRadioGroup.clearCheck();
//
//                    //设置选中
//                    if (q.selectedAnswer != -1) {
//                        mRadioButton[q.selectedAnswer].setChecked(true);
//                    }
//                } else if (corrent == count - 1 && wrongMode == true) {
//
//                    new AlertDialog.Builder(MainActivity.this).setTitle("提示").setMessage("已经到达最后一道题，是否退出？")
//                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog, int which) {
//                                    finish();
//                                }
//                            }).setNegativeButton("取消",null).show();
//
//                } else {
//                    //没有题目了，开始检测正确性
//                    final List<Integer> wrongList = checkAnswer(list);
//
//                    if(wrongList.size() == 0){
//                        new AlertDialog.Builder(MainActivity.this).setTitle("提示").setMessage("你好厉害，答对了所有题！")
//                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        finish();
//                                    }
//                                }).setNegativeButton("取消",null).show();
//                    }
//
//                    //窗口提示
//                    new AlertDialog.Builder(MainActivity.this).setTitle("恭喜，答题完成！")
//                            .setMessage("答对了" + (list.size() - wrongList.size()) + "道题" + "\n"
//                                    + "答错了" + wrongList.size() + "道题" + "\n" + "是否查看错题？").setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            wrongMode = true;
//                            List<Question> newList = new ArrayList<Question>();
//                            for (int i = 0; i < wrongList.size(); i++) {
//                                newList.add(list.get(wrongList.get(i)));
//                            }
//                            list.clear();
//                            for (int i = 0; i < newList.size(); i++) {
//                                list.add(newList.get(i));
//                            }
//                            corrent = 0;
//                            count = list.size();
//
//                            //更新当前显示的内容
//                            Question q = list.get(corrent);
//
//                            tv_title.setText(q.question);
//
//                            mRadioButton[0].setText(q.answerA);
//                            mRadioButton[1].setText(q.answerB);
//                            mRadioButton[2].setText(q.answerC);
//                            mRadioButton[3].setText(q.answerD);
//
//                            tv_result.setText(q.explaination);
//                            //显示结果
//                            tv_result.setVisibility(View.VISIBLE);
//                        }
//                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            finish();
//                        }
//                    }).show();
//                }
//            }
//        });
//
//        //答案选中
//        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                for (int i = 0; i < 4; i++) {
//                    if (mRadioButton[i].isChecked() == true) {
//                        list.get(corrent).selectedAnswer = i;
//                        break;
//                    }
//                }
//            }
//        });
    }


    /**
     * 判断是否答题正确
     *
     * @param list
     * @return
     */
//    private List<Integer> checkAnswer(List<Question> list) {
//        List<Integer> wrongList = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            //判断对错
//            if (list.get(i).answer != list.get(i).selectedAnswer){
//                wrongList.add(i);
//            }
//        }
//        return wrongList;
//    }
}
