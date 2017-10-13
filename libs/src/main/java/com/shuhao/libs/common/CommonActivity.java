package com.shuhao.libs.common;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.shuhao.libs.utils.DialogPool;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;

/**
 * Created by luke on 2017/9/20.
 */

public abstract class CommonActivity extends AutoLayoutActivity {

    public Context mContext;
    public Activity mActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        ButterKnife.bind(this);
        mContext = this;
        mActivity = (CommonActivity) mContext;
        onCreate();
    }

    protected abstract void onCreate();

    protected abstract int bindLayout();

    protected void getToast(Object toast) {
        ToastUtils.showLong(toast.toString());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        DialogPool.reShow(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
