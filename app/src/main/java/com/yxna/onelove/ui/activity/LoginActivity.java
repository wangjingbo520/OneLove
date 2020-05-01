package com.yxna.onelove.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.yxna.onelove.R;
import com.yxna.onelove.TabHomeActivity;
import com.yxna.onelove.base.BaseVRActivity;
import com.yxna.onelove.net.volley.InterfaceMethod;
import com.yxna.onelove.views.customviews.TitleView;

import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @author wjb
 * describe
 */
public class LoginActivity extends BaseVRActivity {

    @BindView(R.id.titleView)
    TitleView titleView;
    @BindView(R.id.etPhoneNumber)
    EditText etPhoneNumber;
    @BindView(R.id.tvGetcode)
    TextView tvGetcode;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        titleView.setRightDrawable(R.mipmap.close);
        titleView.setBackImageGone(true);
        tvGetcode.setClickable(false);
        titleView.setRightListenser(() -> finish());
        etPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() == 11) {
                    tvGetcode.setBackgroundResource(R.drawable.yes_selector);
                    tvGetcode.setClickable(true);
                } else {
                    tvGetcode.setBackgroundResource(R.drawable.no_selector);
                    tvGetcode.setClickable(false);
                }
            }
        });

    }


    @Override
    protected int getContentLayout() {
        return R.layout.activity_login;
    }


    @OnClick({R.id.tvGetcode, R.id.ivWx, R.id.ivWb})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvGetcode:
                startActivity(new Intent(this, TabHomeActivity.class));
                //getCode();
                break;
            case R.id.ivWx:
                break;
            case R.id.ivWb:
                break;
        }
    }

    private void getCode() {
        String phone = etPhoneNumber.getText().toString().trim();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phone", phone);
        hashMap.put("type", "1");
        doPost(hashMap, InterfaceMethod.getVerificationCode);
    }


    @Override
    public void onNetJSONObject(JSONObject obj, String api_name) {
        super.onNetJSONObject(obj, api_name);
        showToast("验证码已发送");
        startActivity(new Intent(this, TabHomeActivity.class));
    }
}
