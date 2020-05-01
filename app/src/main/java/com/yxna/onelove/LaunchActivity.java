package com.yxna.onelove;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.yxna.onelove.base.BaseActivity;
import com.yxna.onelove.utils.ToastUtil;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * @author wjb
 * describe
 */

@RuntimePermissions
public class LaunchActivity extends BaseActivity {


    @Override
    protected void initData() {

    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        LaunchActivityPermissionsDispatcher.getMultiWithPermissionCheck(this);
    }


    @NeedsPermission({Manifest.permission.CAMERA, Manifest.permission.READ_PHONE_STATE, Manifest
            .permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void getMulti() {
        startActivity(new Intent(this, TabHomeActivity.class));
    }

    @Override
    protected int getContentLayout() {
        return R.layout.activity_splash;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        LaunchActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode,
                grantResults);
    }

    /**
     * 这个方法会拦截你发出的请求，这个方法用于告诉用户你接下来申请的权限是干嘛的，说服用户给你权限
     */
    @OnShowRationale({Manifest.permission.CAMERA, Manifest.permission.READ_PHONE_STATE, Manifest
            .permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void showRationale(final PermissionRequest request) {
        new AlertDialog.Builder(this)
                .setMessage("使用向阳宝贝需要申请相关权限，下一步将继续请求权限")
                .setPositiveButton("下一步", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.proceed();//继续执行请求
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                request.cancel();//取消执行请求
            }
        }).show();
    }


    @OnPermissionDenied({Manifest.permission.CAMERA, Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void multiDenied() {
        //您已经拒绝权限,继续申请
        ToastUtil.showMessage("您已经拒绝权限,程序自动退出");
        finish();
    }

    /**
     * 用于标注如果权限请求失败,而且用户勾选不再询问的时候执行的方法，注解括号里面有参数，传入想要申请的权限
     */
    @OnNeverAskAgain({Manifest.permission.CAMERA, Manifest.permission.READ_PHONE_STATE, Manifest
            .permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    void multiNeverAsk() {

        new AlertDialog.Builder(this)
                .setMessage("您已经拒绝请求权限,请到设置页面打开权限")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startSetting(LaunchActivity.this, getPackageName());

                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).show();
    }

    private void startSetting(Context context, String packageName) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (Build.VERSION.SDK_INT >= 9) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", packageName, null));
        } else if (Build.VERSION.SDK_INT <= 8) {
            intent.setAction(Intent.ACTION_VIEW);
            intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            intent.putExtra("com.android.settings.ApplicationPkgName", packageName);
        }
        context.startActivity(intent);
    }

}
