package com.yxna.onelove.ui.fragment;

import android.view.View;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseFragment;
import com.yxna.onelove.ui.activity.PutQuestionActivity;

import butterknife.OnClick;


/**
 * @author wjb
 * describe
 */
public class AskFragment extends BaseFragment {

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_ask;
    }

    @Override
    protected void initView(View root) {
    }

    @Override
    protected void initData() {

    }


    @OnClick({R.id.llSearch, R.id.tvQuesition})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.llSearch:
                break;
            case R.id.tvQuesition:
                PutQuestionActivity.start(getActivity());
                break;
            default:
                break;
        }
    }
}
