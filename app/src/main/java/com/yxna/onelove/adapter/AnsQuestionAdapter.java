package com.yxna.onelove.adapter;

import android.view.View;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

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
        assert view != null;
        view.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

            }
        });

    }

}