package com.tencent.mm.plugin.appbrand.k;

import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Method;

public final class i {
    public static Object a(Class<?> cls, String str, Object obj, Class<?>[] clsArr, Object[] objArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Throwable e) {
            v.a("MicroMsg.ReflectUtil", e, "", new Object[0]);
            return null;
        }
    }

    public static <T> T a(Class<?> cls, String str, Object obj, Class<?>[] clsArr, Object[] objArr, T t) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            t = declaredMethod.invoke(obj, objArr);
        } catch (Throwable e) {
            v.a("MicroMsg.ReflectUtil", e, "", new Object[0]);
        }
        return t;
    }
}
