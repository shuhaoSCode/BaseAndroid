package com.shuhao.baseandroid;

import android.graphics.Color;

import com.blankj.utilcode.util.ToastUtils;
import com.shuhao.libs.common.CommonApplication;

/**
 * Created by luke on 2017/9/20.
 */

public class MyApplication extends CommonApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        initToast();
    }

    private void initToast() {
        ToastUtils.setBgColor(Color.GRAY);
        ToastUtils.setMsgColor(Color.WHITE);
    }
}
