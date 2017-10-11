package com.shuhao.libs.common;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.blankj.utilcode.util.ScreenUtils;
import com.shuhao.libs.R;

import butterknife.ButterKnife;

import static com.zhy.http.okhttp.log.LoggerInterceptor.TAG;

/**
 * Created by luke on 2017/10/11.
 */

public abstract class CommonDialog extends Dialog {

    Context context;
    Dialog dialog;

    public boolean isShow;

    public CommonDialog(@NonNull Context context) {
        super(context);
        this.context = context;
        dialog = new Dialog(context, R.style.NobackDialog);
        dialog.setContentView(bindLayout());
        ButterKnife.bind(this, dialog);
        initDialog();
        isShow = false;
    }

    public void show() {
        dialog.show();
        //设置屏幕大小
        setDialogWindowAttr(dialog, this.context);
        onShow();
        isShow = true;
    }

    public void dismiss() {
        dialog.dismiss();
        onDismiss();
        isShow = false;
    }

    public void reShow() {
        if (isShow) {
            dismiss();
            show();
        }
    }

    /**
     * [初始化]
     *
     * @return
     */

    protected abstract void initDialog();

    /**
     * [绑定layout]
     *
     * @return
     */
    protected abstract int bindLayout();

    /**
     * [显示]
     *
     * @return
     */
    protected abstract void onShow();

    /**
     * [关闭后执行]
     *
     * @return
     */
    protected abstract void onDismiss();

    /**
     * [设置大小]
     *
     * @return
     */
    private static void setDialogWindowAttr(Dialog dlg, Context ctx) {
        Window window = dlg.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.gravity = Gravity.CENTER;
        int width = ScreenUtils.getScreenWidth();
        int height = ScreenUtils.getScreenHeight();
        lp.width = width;
        lp.height = height;
        dlg.getWindow().setAttributes(lp);
    }


}
