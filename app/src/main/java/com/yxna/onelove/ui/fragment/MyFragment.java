package com.yxna.onelove.ui.fragment;

import android.view.View;

import com.yxna.onelove.R;
import com.yxna.onelove.base.BaseFragment;
import com.yxna.onelove.ui.activity.AnswerActivity;
import com.yxna.onelove.ui.activity.FaceActivity;
import com.yxna.onelove.ui.activity.FeedbackActivity;
import com.yxna.onelove.ui.activity.GiftActivity;
import com.yxna.onelove.ui.activity.HistoryActivity;
import com.yxna.onelove.ui.activity.MyCollectActivity;
import com.yxna.onelove.ui.activity.MyInfoActivity;
import com.yxna.onelove.ui.activity.RechargeActivity;
import com.yxna.onelove.ui.activity.SettingActivity;
import com.yxna.onelove.ui.activity.TalkingSkillActivity;
import com.yxna.onelove.ui.activity.TaskActivity;
import com.yxna.onelove.ui.activity.TestActivity;
import com.yxna.onelove.views.customviews.CircleImageView;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * @author Bobo
 * @date 2019/9/21
 * describe
 */

public class MyFragment extends BaseFragment {

    @BindView(R.id.pic)
    CircleImageView pic;

    @Override
    protected int getContentLayout() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView(View root) {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.ivEmail, R.id.ivEdit, R.id.llCollect,
            R.id.llFace, R.id.llHistory, R.id.llTask,
            R.id.llHuashu, R.id.llTest, R.id.llAnswer, R.id.llGift
            , R.id.llSetting, R.id.llOpinion, R.id.llVip, R.id.pic})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivEmail:
                break;
            case R.id.ivEdit:
                break;
            case R.id.llCollect:
                MyCollectActivity.start(getActivity());
                break;
            case R.id.llFace:
                FaceActivity.start(getActivity());
                break;
            case R.id.llHistory:
                HistoryActivity.start(getActivity());
                break;
            case R.id.llTask:
                TaskActivity.start(getActivity());
                break;
            case R.id.llHuashu:
                TalkingSkillActivity.start(getActivity());
                break;
            case R.id.llTest:
                TestActivity.start(getActivity());
                break;
            case R.id.llAnswer:
                AnswerActivity.start(getActivity());
                break;
            case R.id.llGift:
                GiftActivity.start(getActivity());
                break;
            case R.id.llSetting:
                SettingActivity.start(getActivity());
                break;
            case R.id.llOpinion:
                FeedbackActivity.start(getActivity());
                break;
            case R.id.llVip:
                RechargeActivity.start(getActivity());
                break;
            case R.id.pic:
                MyInfoActivity.start(getActivity());
                break;
            default:
                break;
        }
    }


}
