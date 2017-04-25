package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public final class k {
    private static Class pzg;
    private static Method pzh;

    static {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            pzg = cls;
            pzh = cls.getDeclaredMethod("get", new Class[]{String.class, String.class});
        } catch (Throwable th) {
        }
    }

    public static String ej(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : ek(str, str2);
    }

    private static String ek(String str, String str2) {
        if (pzg == null || pzh == null) {
            return str2;
        }
        try {
            return (String) pzh.invoke(pzg, new Object[]{str, str2});
        } catch (Throwable th) {
            return str2;
        }
    }
}
