package com.yxna.onelove;

import android.app.Application;

/**
 * @author wjb（H）
 * @date describe
 */
public class MyApp extends Application {
    public static MyApp myApp;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }

    public static MyApp getInstance() {
        return myApp;
    }
}
