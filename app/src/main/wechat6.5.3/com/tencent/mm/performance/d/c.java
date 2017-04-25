package com.tencent.mm.performance.d;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class c {
    public static Object a(Class<?> cls, String str, Object obj) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Throwable e) {
            v.a("MicroMsg.ReflectHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }

    private static Object a(Class<?> cls, String str, Object obj, Class<?>[] clsArr, Object[] objArr) {
        Object obj2 = null;
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, null);
            declaredMethod.setAccessible(true);
            obj2 = declaredMethod.invoke(null, null);
        } catch (Throwable e) {
            v.a("MicroMsg.ReflectHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return obj2;
    }

    public static Object ag(String str, String str2) {
        Object obj = null;
        try {
            obj = a(Class.forName(str), str2, null, null, null);
        } catch (Throwable e) {
            v.a("MicroMsg.ReflectHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return obj;
    }
}
