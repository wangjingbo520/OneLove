package com.yxna.onelove.adapter;

import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.yxna.onelove.R;

import java.util.List;

/**
 * @author wjb（H）
 * @date describe
 */
public class AnsQuestionAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public AnsQuestionAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
        addChildClickViewIds(R.id.mRadioGroup);

    }


    @Override
    protected void convert(@NonNull BaseViewHolder helper, String item) {
        RadioGroup view = helper.findView(R.id.mRadioGroup);
    }


}