package com.shuhao.libs.utils;

import android.content.Context;
import android.util.Log;

import com.shuhao.libs.common.CommonDialog;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static com.zhy.http.okhttp.log.LoggerInterceptor.TAG;

/**
 * Created by luke on 2017/10/12.
 */

public class DialogPool {
    private static Map<Context, Map> contextMap;

    public static CommonDialog getDialog(Class dialogT, Context context) {
        CommonDialog dialog = null;
        Map<String, CommonDialog> dialogMap;
        if (contextMap == null) {
            contextMap = new HashMap<>();
        }

        if (contextMap.containsKey(context)) {
            dialogMap = contextMap.get(context);
        } else {
            dialogMap = new HashMap<>();
        }

        Log.e(TAG, "getDialog: " + dialogT.getName());
        String dialogName = dialogT.getName();
        if (dialogMap.containsKey(dialogName)) {
            return dialogMap.get(dialogName);
        } else {
            try {
                Constructor constructor = dialogT.getDeclaredConstructor(new Class[]{Context.class});
                constructor.setAccessible(true);
                dialog = (CommonDialog) constructor.newInstance(new Object[]{context});
                dialogMap.put(dialogT.getName(), dialog);
                contextMap.put(context, dialogMap);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return dialog;
        }
    }

    public static void reShow(Context context) {
        if (contextMap == null)
            return;
        if (!contextMap.containsKey(context))
            return;

        Map<String, CommonDialog> dialogMap = contextMap.get(context);
        for (CommonDialog dialog : dialogMap.values()) {
            if (dialog.isShow) {
                dialog.reShow();
            }
        }
    }
}
