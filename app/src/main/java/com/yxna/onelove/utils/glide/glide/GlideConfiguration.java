package com.yxna.onelove.utils.glide.glide;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.Registry;
import com.bumptech.glide.module.GlideModule;

/**
 * Date: 2018/11/1
 * Author: Ender
 * Description:
 */
public class GlideConfiguration implements GlideModule {
    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {

    }

    @Override
    public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
    }
}
