package com.shuhao.libs.common;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.ToastUtils;
import com.zhy.autolayout.AutoLayoutActivity;

import butterknife.ButterKnife;

/**
 * Created by luke on 2017/9/20.
 */

public abstract class CommonActivity extends AutoLayoutActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(bindLayout());
        ButterKnife.bind(this);
        onCreate();
    }

    protected abstract void onCreate();

    protected abstract int bindLayout();

    protected void getToast(Object toast) {
        ToastUtils.showLong(toast.toString());
    }

}
