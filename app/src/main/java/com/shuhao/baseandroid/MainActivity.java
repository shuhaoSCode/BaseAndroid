package com.shuhao.baseandroid;

import com.shuhao.libs.common.CommonActivity;

import butterknife.OnClick;

public class MainActivity extends CommonActivity {

    @Override
    protected void onCreate() {
        getToast("哈哈哈");
    }

    @OnClick(R.id.main_button)
    void mainButton() {
        getToast("main_button");
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }
}
