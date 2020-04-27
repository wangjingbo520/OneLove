package com.yxna.onelove.net.volley;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.yxna.onelove.MyApp;
import com.yxna.onelove.base.BaseVolleyActivity;
import com.yxna.onelove.utils.ToastUtil;
import com.yxna.onelove.views.LoadingDialog;

import java.util.HashMap;
import java.util.Map;


/**
 * @author wjb
 * describe
 */
public class RequestHandler {

    public interface IVolleyResponse {
        void onSuccess(String response, String interfaceMethod);

        void onFailed(VolleyError error);
    }

    public static void addRequest(
            Context context, final int method, final HashMap<String, String> params,
            final Map<String, String> header, String interfaceMethod, IVolleyResponse volleyResponse, boolean isShowLoadingDialog) {
        if (isShowLoadingDialog) {
            addRequest(context, method, params, header, new DefaultDialogRequestListener(context)
                    , interfaceMethod, volleyResponse);
        } else {
            addRequest(context, method, params, header, new DefaultRequestListener(), interfaceMethod, volleyResponse);
        }
    }


    private static void addRequest(Context context, int method, final HashMap<String, String> params, final Map<String, String> header,
                                   final NetWorkRequestListener listener, String interfaceMethod, IVolleyResponse volleyResponse) {
        listener.onPreRequest();
        StringRequest request = new StringRequest(method, InterfaceMethod.base_url + interfaceMethod, response -> {
            volleyResponse.onSuccess(response, interfaceMethod);
            listener.onResponse();
        }, volleyError -> {
            listener.onFailed();
            volleyResponse.onFailed(volleyError);
        }) {
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> map = header;
                if (map == null) {
                    map = new HashMap<>();
                }
                // 在此统一添加header
                //  map.put("Content-type", "application/x-www-form-urlencoded");
//                if (TextUtils.isEmpty(MyApp.getDevice_id())) {
//                    MyApp.initDeviceId(Utils.getIMEI(MyApp.myApp.getApplicationContext()));
//                }
//                String device_id = MyApp.getDevice_id();
//                map.put("device_id", device_id);
                return map;
            }

            @Override
            protected HashMap<String, String> getParams() {
                return params;
            }
        };

        request.setRetryPolicy(new DefaultRetryPolicy(
                //连接超时设置
                10 * 1000,
                //重新尝试连接次数
                3,
                //曲线增长因子
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));

        RequestManager.getInstance(MyApp.getInstance()).getRequestQueue().add(request);
    }


    private static void onVolleyErrorResponse(VolleyError error, Handler handler) {
        String message = error.getMessage();
        if (error instanceof com.android.volley.NetworkError) {
            ToastUtil.showMessage("错误：" + message);
            handler.sendEmptyMessage(0);
        } else if (error instanceof TimeoutError) {
            ToastUtil.showMessage("错误：连接超时，" + message);
            handler.sendEmptyMessage(1);
        } else if (error instanceof AuthFailureError) {
            ToastUtil.showMessage("错误：身份验证失败，" + message);
            handler.sendEmptyMessage(2);
        } else if (error instanceof ParseError) {
            handler.sendEmptyMessage(3);
            ToastUtil.showMessage("服务器解析错误，" + message);
            ;
        } else if (error instanceof ServerError) {
            ToastUtil.showMessage("服务器响应错误！");
            handler.sendEmptyMessage(4);
        } else {
            ToastUtil.showMessage("error：" + message);
        }
    }


    /**
     * 请求过程中显示加载对话框，且自动处理其生命周期
     */
    private static class DefaultDialogRequestListener extends DefaultRequestListener {

        Context context;
        LoadingDialog dialog;

        private DefaultDialogRequestListener(Context context) {
            this.context = context;
            dialog = new LoadingDialog(context);
        }

        @Override
        public void onPreRequest() {
            dialog.show();
        }

        @Override
        public void onResponse() {
            dialog.dismiss();
        }

        @Override
        public void onFailed() {
            dialog.dismiss();
        }
    }


    /**
     * 请求过程中没有加载进度框
     */
    private static class DefaultRequestListener implements NetWorkRequestListener {


        @Override
        public void onPreRequest() {

        }

        @Override
        public void onResponse() {

        }

        @Override
        public void onFailed() {

        }

    }

    /**
     * 用于所有网络请求，在不同时机回调的接口
     */
    private interface NetWorkRequestListener {
        void onPreRequest();

        void onResponse();

        void onFailed();

    }
}
