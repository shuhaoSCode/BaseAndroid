package com.shuhao.baseandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.shuhao.libs.common.CommonDialog;

import butterknife.OnClick;

import static com.zhy.http.okhttp.log.LoggerInterceptor.TAG;

/**
 * Created by luke on 2017/10/11.
 */

public class DemoDialog extends CommonDialog {

    public DemoDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void initDialog() {
        Log.e(TAG, "initDialog");
    }

    @Override
    protected int bindLayout() {
        return R.layout.test_dialog;
    }

    @Override
    protected void onShow() {
        Log.e(TAG, "onShow");
    }

    @Override
    protected void onDismiss() {
        Log.e(TAG, "onDismiss");
    }

    @OnClick(R.id.dialog_btn_close)
    void dialog_btn_close() {
        dismiss();
    }
}
