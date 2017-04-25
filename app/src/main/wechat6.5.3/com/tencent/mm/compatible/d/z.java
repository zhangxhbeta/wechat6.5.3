package com.tencent.mm.compatible.d;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Method;

public final class z {
    private static Class<?> cfu;
    private static Method cfv;
    private static Method cfw;

    static {
        cfu = null;
        cfv = null;
        cfw = null;
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            cfu = cls;
            cfv = cls.getDeclaredMethod("get", new Class[]{String.class});
            cfw = cfu.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});
            cfv.setAccessible(true);
            cfw.setAccessible(true);
        } catch (Throwable e) {
            v.a("MicroMsg.SystemProperties", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static String get(String str) {
        try {
            return (String) cfv.invoke(null, new Object[]{str});
        } catch (Throwable e) {
            v.a("MicroMsg.SystemProperties", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }
}
