package com.shuhao.baseandroid;

import android.app.Dialog;

import com.shuhao.libs.common.CommonActivity;

import butterknife.OnClick;

public class MainActivity extends CommonActivity {

    @Override
    protected void onCreate() {

    }

    @OnClick(R.id.main_button)
    void mainButton() {
        DemoDialog demoDialog = new DemoDialog(this);
        demoDialog.show();
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }
}
