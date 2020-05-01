package com.yxna.onelove.utils;

import android.content.Context;

import androidx.annotation.ColorRes;

import java.util.regex.Pattern;


/**
 * @author wjb
 * describe
 */
public class CommUtils {
    private CommUtils() {

    }

    private static long lastClickTime;

    private final static int INTERVAL_LOW = 300;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < INTERVAL_LOW) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    public static int getIntResColor(Context context, @ColorRes int resId) {
        return context.getResources().getColor(resId);
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 校验汉字
     *
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches("^[\u4e00-\u9fa5]{1,9}$", chinese);
    }

    public static boolean isLegalId(String id){
        return id.toUpperCase().matches("(^\\d{15}$)|(^\\d{17}([0-9]|X)$)");
    }

    /**
     * 校验身份证
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])", idCard);
    }
}
