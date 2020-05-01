package com.yxna.onelove.views.dialog.pic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;


import java.util.ArrayList;
import java.util.List;

import me.jessyan.autosize.utils.LogUtils;

/**
 * Created by shiwenshui 2020/4/12 12:20
 */
public abstract class BasePicSelectDialogFragment extends BaseDialogFragment {

    private static final int PICTURE_REQ_CODE = 6666;

    protected static final String KEY_MAX_PIC_NUM = "max_pic_num";
    protected static final String KEY_COMPRESS = "compress";
    protected static final String KEY_CROP = "crop";

    private int maxPicNum;
    private boolean compress;
    private boolean crop;

    private OnPicSelectorResultCallback mCallback;

    public void setOnPicSelectorResultCallback(OnPicSelectorResultCallback callback) {
        mCallback = callback;
    }

    @Override
    protected void initArgs(Bundle args) {
        maxPicNum = args.getInt(KEY_MAX_PIC_NUM);
        compress = args.getBoolean(KEY_COMPRESS);
        crop = args.getBoolean(KEY_CROP);
        if (maxPicNum <= 0) {
            maxPicNum = 1;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == PICTURE_REQ_CODE) {
                if (data != null) {
                    List<LocalMediaBean> localMediaBeans =
                            PictureSelectorUtil.obtainMultipleResult(data);
                    LogUtils.d(localMediaBeans.toString());
                    if (mCallback != null) {
                        final List<String> pics = new ArrayList<>();
                        String path;
                        for (int i = 0; i < localMediaBeans.size(); i++) {
                            if (crop) {
                                path = localMediaBeans.get(i).cutPath;
                            } else if (compress) {
                                path = localMediaBeans.get(i).compressPath;
                            } else {
                                path = localMediaBeans.get(i).path;
                            }
                            pics.add(path);
                        }

                        mCallback.onResult(pics);
                    }
                }
            }
            dismiss();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mCallback = null;
    }

    protected void takePicClick() {
        PictureSelectorUtil.takePicture(this, compress, crop, PICTURE_REQ_CODE);
    }

    protected void albumClick() {
        PictureSelectorUtil.album(this, maxPicNum, compress, crop, PICTURE_REQ_CODE);
    }
}
