package com.yxna.onelove.adapter;

import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yxna.onelove.R;

import java.util.List;

/**
 * @author wjb（H）
 * @date describe
 */
public class AnsQuestionAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private INextQuestion iNextQuestion;

    public INextQuestion getiNextQuestion() {
        return iNextQuestion;
    }

    public void setiNextQuestion(INextQuestion iNextQuestion) {
        this.iNextQuestion = iNextQuestion;
    }

    public interface INextQuestion {
        void nextQuestion(int postion, String question);
    }

    public AnsQuestionAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
        addChildClickViewIds(R.id.mRadioGroup, R.id.RadioA, R.id.RadioB, R.id.RadioC, R.id.RadioD);
        setOnItemChildClickListener(onItemChildClickListener);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {

    }


    private OnItemChildClickListener onItemChildClickListener = (adapter, view, position) -> {
        String question = getData().get(position);
        switch (view.getId()) {
            case R.id.RadioA:
                jumpNextQuestion(position, question);
                break;
            case R.id.RadioB:
                break;
            case R.id.RadioC:
                break;
            case R.id.RadioD:
                break;
            default:
                break;
        }

    };

    private void jumpNextQuestion(int position, String question) {
        if (iNextQuestion != null) {
            new Handler().postDelayed(() -> iNextQuestion.nextQuestion(position, question), 500);
        }
    }


}