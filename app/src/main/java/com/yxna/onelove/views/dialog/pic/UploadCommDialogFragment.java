package com.yxna.onelove.views.dialog.pic;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.yxna.onelove.R;
import com.yxna.onelove.utils.SafeClickListener;


/**
 * @author wjb
 * describe
 */
public class UploadCommDialogFragment extends BasePicSelectDialogFragment {


    private TextView takePicTv;
    private TextView albumTv;
    private TextView cancelTv;

    public static UploadCommDialogFragment newInstance() {
        return  new UploadCommDialogFragment();
    }

    public static UploadCommDialogFragment newInstance(int maxPicNum, boolean compress, boolean crop) {
        Bundle args = new Bundle();
        args.putInt(KEY_MAX_PIC_NUM, maxPicNum);
        args.putBoolean(KEY_COMPRESS, compress);
        args.putBoolean(KEY_CROP, crop);
        UploadCommDialogFragment fragment = new UploadCommDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected boolean enterFromBottom() {
        return true;
    }

    @Override
    protected boolean isEnabledNormalStyle() {
        return true;
    }

    @Override
    public void onStart() {
        super.onStart();
        setDialogWidthHeight(1, 0);
    }

    @Override
    protected int attachLayoutId() {
        return R.layout.dialog_upload_pic_layout;
    }

    @Override
    protected void initView(View view) {
        takePicTv = findView(view, R.id.tv_select_avatar_take_a_photo);
        albumTv = findView(view, R.id.tv_select_avatar_select_from_album);
        cancelTv = findView(view, R.id.tv_select_avatar_cancel);
    }

    @Override
    protected void initData() {
        takePicTv.setOnClickListener(new SafeClickListener() {
            @Override
            protected void onClickEvent(View view) {
                takePicClick();
            }
        });
        albumTv.setOnClickListener(new SafeClickListener() {
            @Override
            protected void onClickEvent(View view) {
                albumClick();
            }
        });
        cancelTv.setOnClickListener(new SafeClickListener() {
            @Override
            protected void onClickEvent(View view) {
                dismiss();
            }
        });
    }

}
