package com.yxna.onelove.net.volley;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;
import com.yxna.onelove.MyApp;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;


/**
 * @author wjb
 * describe
 */
public class RequestManager {

    private RequestManager() {

    }

    public enum Type {
        HTTP,
        HTTPS_DEFALT,
        HTTPS_SELF_CERTIFIED
    }

    private static RequestManager instance;

    public RequestQueue mRequestQueue;

    private RequestQueue mRequestQueueWithSelfCertifiedSsl;

    private RequestQueue mRequestQueueWithDefaultSsl;

    public RequestManager(Context context, Type type) {
        mRequestQueue = newRequestQueue(context, type);
    }

    public static RequestManager getInstance(Context context, Type type) {
        if (instance == null) {
            instance = new RequestManager(context, type);
        }
        return instance;
    }


    private RequestQueue newRequestQueue(Context context, Type type) {
        if (type == Type.HTTP) {
            mRequestQueue = Volley.newRequestQueue(context);
        }

        if (type == Type.HTTPS_DEFALT) {
            mRequestQueue = getRequestQueueWithDefaultSsl();
        }

        if (type == Type.HTTPS_SELF_CERTIFIED) {
            mRequestQueue = getRequestQueueWithSelfCertifiedSsl();
        }

        return mRequestQueue;
    }

    public RequestQueue getRequestQueue() {
        return mRequestQueue;
    }

    public RequestQueue getRequestQueueWithDefaultSsl() {
        // lazy initialize the request queue, the queue instance will be
        // created when it is accessed for the first time
        if (mRequestQueueWithDefaultSsl == null) {
            Network network = new BasicNetwork(new HurlStack());
            Cache cache = new DiskBasedCache(MyApp.getInstance().getCacheDir(), 1024 * 1024);
            RequestQueue queue = new RequestQueue(cache, network);
            queue.start();
            mRequestQueueWithDefaultSsl = queue;  //Volley.newRequestQueue(getApplicationContext());
            trustAllCertificate();
        }
        return mRequestQueueWithDefaultSsl;
    }

    public RequestQueue getRequestQueueWithSelfCertifiedSsl() {
        if (mRequestQueueWithSelfCertifiedSsl == null) {
            try {
                SSLSocketFactory sslSocketFactory = VolleySSLSocketFactory.getSSLSocketFactory(MyApp.getInstance());
                Network network = new BasicNetwork(new HurlStack(null, sslSocketFactory));
                Cache cache = new DiskBasedCache(MyApp.getInstance().getCacheDir(), 1024 * 1024);
                RequestQueue queue = new RequestQueue(cache, network);
                queue.start();
                mRequestQueueWithSelfCertifiedSsl = queue;  //Volley.newRequestQueue(getApplicationContext());
            } catch (Exception e) {
                e.printStackTrace();
            }

            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostName, SSLSession ssls) {
                    return true;
                }
            });
        }

        return mRequestQueueWithSelfCertifiedSsl;
    }

    public void addRequest(Request request, Object tag) {
        if (tag != null) {
            request.setTag(tag);
        } else if (!TextUtils.isEmpty(request.getUrl())) {
            request.setTag(request.getUrl());
        }
        mRequestQueue.add(request);
    }

    public static void trustAllCertificate() {
        try {
            SSLContext sslc = SSLContext.getInstance("TLS");
            TrustManager[] trustManagerArray = {new NullX509TrustManager()};
            sslc.init(null, trustManagerArray, null);
            HttpsURLConnection.setDefaultSSLSocketFactory(sslc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(new NullHostnameVerifier());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class NullX509TrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            System.out.println();
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
            System.out.println();
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static class NullHostnameVerifier implements HostnameVerifier {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    }
}