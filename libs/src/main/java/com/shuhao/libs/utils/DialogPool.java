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
    //根据context存放dialogMap
    private static Map<Context, Map> contextMap;

    public static CommonDialog getDialog(Class dialogT, Context context) {
        CommonDialog dialog = null;
        Map<String, CommonDialog> dialogMap;
        if (contextMap == null) {
            contextMap = new HashMap<>();
        }

        //判断是否包含当前context
        if (contextMap.containsKey(context)) {
            dialogMap = contextMap.get(context);
        } else {
            dialogMap = new HashMap<>();
        }

        Log.e(TAG, "getDialog: " + dialogT.getName());
        //获取class名称
        String dialogName = dialogT.getName();
        //判断当前dialogMap是否包含dialogName
        if (dialogMap.containsKey(dialogName)) {
            return dialogMap.get(dialogName);
        } else {
            try {
                //通过反射创建dialog并设置参数
                Constructor constructor = dialogT.getDeclaredConstructor(new Class[]{Context.class});
                constructor.setAccessible(true);
                dialog = (CommonDialog) constructor.newInstance(new Object[]{context});
                //缓存dialog
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

    /**
     * [防止屏幕旋转出现破板 reShow]
     *
     * @param context
     * @return
     */
    public static void reShow(Context context) {
        if (contextMap == null)
            return;
        if (!contextMap.containsKey(context))
            return;

        //遍历dialogMap中所有dialog 查看是否需要处理
        Map<String, CommonDialog> dialogMap = contextMap.get(context);
        for (CommonDialog dialog : dialogMap.values()) {
            if (dialog.isShow) {
                dialog.reShow();
            }
        }
    }
}
