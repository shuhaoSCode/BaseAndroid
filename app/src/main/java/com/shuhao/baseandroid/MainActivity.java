package com.shuhao.baseandroid;

import android.content.DialogInterface;
import android.util.Log;

import com.shuhao.libs.common.CommonActivity;
import com.shuhao.libs.common.CommonDialog;
import com.shuhao.libs.utils.DialogPool;

import butterknife.OnClick;

public class MainActivity extends CommonActivity {

    DemoDialog dialog;

    @Override
    protected void onCreate() {
        dialog = (DemoDialog) DialogPool.getDialog(DemoDialog.class, this);
        dialog.show();
    }

    @OnClick(R.id.main_button)
    void mainButton() {
        dialog = (DemoDialog) DialogPool.getDialog(DemoDialog.class, this);
        dialog.show();
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }
}
