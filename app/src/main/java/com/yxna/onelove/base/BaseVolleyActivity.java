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
public abstract class BaseVolleyActivity extends BaseActivity {

    HashMap<String, String> header = new HashMap<>();


    public void doPost(HashMap<String, String> params, String api_name) {
        RequestHandler.addRequest(mActivity, Request.Method.POST, params, header,
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


    private void onNetJSONArray(JSONArray obj, String api_name) {
    }

    private void onNetJSONObject(JSONObject obj, String api_name) {

    }


}
