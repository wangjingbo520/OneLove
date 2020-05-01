package com.yxna.onelove.views.dialog.pic;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.style.PictureParameterStyle;
import com.luck.picture.lib.style.PictureWindowAnimationStyle;
import com.yxna.onelove.R;
import com.yxna.onelove.utils.PicSelectStyleUtil;
import com.yxna.onelove.utils.glide.glide.GlideEngine;

import java.util.ArrayList;
import java.util.List;


/**
 * @author wjb
 * describe
 */
public class PictureSelectorUtil {
    private PictureSelectorUtil() {

    }

    public static List<LocalMediaBean> obtainMultipleResult(Intent intent) {
        List<LocalMediaBean> data = new ArrayList<>(9);
        if (intent != null) {
            List<LocalMedia> localMedia = PictureSelector.obtainMultipleResult(intent);
            if (localMedia != null && localMedia.size() > 0) {
                LocalMediaBean bean;
                for (LocalMedia media : localMedia) {
                    bean = new LocalMediaBean();
                    bean.fileName = media.getFileName();
                    bean.path = media.getPath();
                    bean.compressPath = media.getCompressPath();
                    bean.cutPath = media.getCutPath();
                    data.add(bean);
                }
            }
        }
        return data;
    }

    public static void takePicture(Fragment fragment, boolean compress, boolean crop, int requestCode) {
        PictureSelector.create(fragment)
                .openCamera(PictureMimeType.ofImage())
                .selectionMode(PictureConfig.SINGLE)
                .previewImage(true)// 是否可预览图片
                .isWeChatStyle(true)// 是否开启微信图片选择风格
                .isCamera(false)// 是否显示拍照按钮
                .enableCrop(crop)// 是否裁剪
                .compress(compress)// 是否压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                .withAspectRatio(3, 4)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .freeStyleCropEnabled(false)// 裁剪框是否可拖拽 true or false
                .rotateEnabled(false)// 裁剪是否可旋转图片 true or false
                .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                .circleDimmedLayer(false)// 是否圆形裁剪
                .forResult(requestCode);
    }

    public static void album(Fragment fragment, int requestCode) {
        PictureWindowAnimationStyle mWindowAnimationStyle = new PictureWindowAnimationStyle();
        mWindowAnimationStyle.ofAllAnimation(R.anim.picture_anim_up_in, R.anim.picture_anim_down_out);
        PictureSelector.create(fragment)
                .openGallery(PictureMimeType.ofImage())
                .loadImageEngine(GlideEngine.createGlideEngine())// 外部传入图片加载引擎，必传项
//                .setPictureStyle(new PictureParameterStyle())// 动态自定义相册主题
//                .setPictureStyle(getWhiteStyle(fragment.getContext()))// 动态自定义相册主题
                .setPictureStyle(PicSelectStyleUtil.getPicSelectStyle(fragment.getContext()))// 动态自定义相册主题
                .isWeChatStyle(true)// 是否开启微信图片选择风格
                .imageSpanCount(4)// 每行显示个数
                .setPictureWindowAnimationStyle(mWindowAnimationStyle)
                .selectionMode(PictureConfig.SINGLE)
                .previewImage(true)// 是否可预览图片
                .isCamera(false)// 是否显示拍照按钮
                .enableCrop(true)// 是否裁剪
                .compress(true)// 是否压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                .withAspectRatio(3, 4)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .freeStyleCropEnabled(false)// 裁剪框是否可拖拽 true or false
                .rotateEnabled(false)// 裁剪是否可旋转图片 true or false
                .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                .circleDimmedLayer(false)// 是否圆形裁剪
                .forResult(requestCode);
    }

    public static void album(Fragment fragment, int maxNum, boolean compress, boolean crop, int requestCode) {
        PictureWindowAnimationStyle mWindowAnimationStyle = new PictureWindowAnimationStyle();
        mWindowAnimationStyle.ofAllAnimation(R.anim.picture_anim_up_in, R.anim.picture_anim_down_out);
        PictureSelector.create(fragment)
                .openGallery(PictureMimeType.ofImage())
                .loadImageEngine(GlideEngine.createGlideEngine())// 外部传入图片加载引擎，必传项
//                .setPictureStyle(new PictureParameterStyle())// 动态自定义相册主题
//                .setPictureStyle(getWhiteStyle(fragment.getContext()))// 动态自定义相册主题
                .setPictureStyle(PicSelectStyleUtil.getPicSelectStyle(fragment.getContext()))// 动态自定义相册主题
                .isWeChatStyle(true)// 是否开启微信图片选择风格
                .imageSpanCount(4)// 每行显示个数
                .maxSelectNum(maxNum)//最多选择多少张图片
                .setPictureWindowAnimationStyle(mWindowAnimationStyle)
                .selectionMode(PictureConfig.MULTIPLE)
                .previewImage(true)// 是否可预览图片
                .isCamera(false)// 是否显示拍照按钮
                .enableCrop(crop)// 是否裁剪
                .compress(compress)// 是否压缩
                .synOrAsy(true)//同步true或异步false 压缩 默认同步
                .withAspectRatio(3, 4)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                .freeStyleCropEnabled(false)// 裁剪框是否可拖拽 true or false
                .rotateEnabled(false)// 裁剪是否可旋转图片 true or false
                .scaleEnabled(false)// 裁剪是否可放大缩小图片 true or false
                .circleDimmedLayer(false)// 是否圆形裁剪
                .forResult(requestCode);
    }

}
