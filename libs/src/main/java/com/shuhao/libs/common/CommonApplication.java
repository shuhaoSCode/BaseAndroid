package com.shuhao.libs.common;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by luke on 2017/9/20.
 */

public class CommonApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
