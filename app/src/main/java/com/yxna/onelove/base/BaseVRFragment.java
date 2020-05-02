package com.yxna.onelove.base;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.yxna.onelove.net.volley.RequestHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author wjb（H）
 * @date describe
 */
public abstract class BaseVRFragment extends BaseFragment {

    HashMap<String, String> header = null;

    //简单粗暴傻瓜式的请求方式，在我看来比mvp+retrofit+rxjava用起来舒服些,哈哈
    protected void doPost(HashMap<String, String> params, String api_name) {
        params.put("clientType", 2 + "");
        params.put("version", "");
        params.put("clientNum", 1 + "");
        RequestHandler.addRequest(mContext, Request.Method.POST, params, header,
                api_name, new RequestHandler.IVolleyResponse() {
                    @Override
                    public void onSuccess(String response, String interfaceMethod) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            int code = jsonObject.getInt("code");
                            if (code == 200) {
                                Object obj = jsonObject.get("result");
                                if (obj instanceof JSONObject) {
                                    onNetJSONObject((JSONObject) obj, api_name);
                                } else if (obj instanceof JSONArray) {
                                    onNetJSONArray((JSONArray) obj, api_name);
                                }
                            } else if (code == 300) {
                                //......
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailed(VolleyError error) {

                    }
                }, true);
    }


    public void onNetJSONArray(JSONArray obj, String api_name) {
    }

    public void onNetJSONObject(JSONObject obj, String api_name) {

    }
}
