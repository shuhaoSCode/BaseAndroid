package com.shuhao.libs.utils;

import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

/**
 * Created by luke on 2017/10/12.
 */

public class L {

    public static void d(Object object) {
        Logger.d(object);
    }

    public static void e(Object object) {
        Logger.e(object.toString());
    }

    public static void i(Object object) {
        Logger.i(object.toString());
    }

    public static void v(Object object) {
        Logger.v(object.toString());
    }

    public static void w(Object object) {
        Logger.w(object.toString());
    }

    public static void json(String json) {
        Logger.json(json);
    }

    public static void xml(String xml) {
        Logger.xml(xml);
    }

    public static void map(Map map) {
        Set set = map.entrySet();
        if (set.size() < 1) {
            d("[]");
            return;
        }
        String maps = "";
        for (Object aSet : set) {
            Map.Entry entry = (Map.Entry) aSet;
            maps += entry.getKey() + " = " + entry.getValue() + ",\n";
        }
        e(maps);
    }

    public static void list(List list) {
        if (list == null) {
            d("[list = null]");
            return;
        }

        if (list.size() == 0) {
            d("[list.size = 0]");
            return;
        }

        String listS = "";
        for (int i = 0; i < list.size(); i++) {
            listS += i + ": " + list.get(i).toString() + ",\n";
        }
        d(listS);
    }

}
