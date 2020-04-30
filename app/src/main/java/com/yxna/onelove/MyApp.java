package com.yxna.onelove;

import android.app.Application;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

/**
 * @author wjb
 * describe
 */
public class MyApp extends Application {

    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator((context, layout) -> new ClassicsHeader(context));
        SmartRefreshLayout.setDefaultRefreshFooterCreator((context, layout) -> new ClassicsFooter(context).setDrawableSize(20));
    }

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
