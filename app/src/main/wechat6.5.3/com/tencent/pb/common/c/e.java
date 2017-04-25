package com.tencent.pb.common.c;

import java.lang.reflect.Field;

public final class e {
    public static Class<?> psV;

    private static boolean Qd(String str) {
        Class cls = null;
        try {
            cls = Class.forName(str);
        } catch (ClassNotFoundException e) {
        }
        psV = cls;
        return cls != null;
    }

    private static final Field getField(String str) {
        Field field = null;
        try {
            field = psV.getDeclaredField(str);
            field.setAccessible(true);
            return field;
        } catch (SecurityException e) {
            return field;
        } catch (NoSuchFieldException e2) {
            return field;
        }
    }

    public static Object ec(String str, String str2) {
        Object obj = null;
        Qd(str);
        Field field = getField(str2);
        if (field != null) {
            try {
                obj = field.get(null);
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e2) {
            }
        }
        return obj;
    }
}
