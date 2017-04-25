package com.tencent.mm.svg.c;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;

public final class b {
    private static boolean cls = false;
    private static String gpe = SQLiteDatabase.KeyEmpty;
    private static boolean nyM = false;
    private static boolean nyN = false;

    public static void GT(String str) {
        gpe = str;
    }

    public static final boolean byh() {
        return nyN;
    }

    public static final void iD(boolean z) {
        nyN = z;
    }

    private static final Object NR(String str) {
        try {
            Class cls = Class.forName(gpe + ".svg.SVGBuildConfig");
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(cls);
        } catch (Throwable e) {
            c.a("MicroMSG.WeChatSVGConfig", e, "NoSuchFieldException", new Object[0]);
            return null;
        } catch (Throwable e2) {
            c.a("MicroMSG.WeChatSVGConfig", e2, "IllegalArgumentException", new Object[0]);
            return null;
        } catch (Throwable e22) {
            c.a("MicroMSG.WeChatSVGConfig", e22, "ClassNotFoundException", new Object[0]);
            return null;
        } catch (Throwable e222) {
            c.a("MicroMSG.WeChatSVGConfig", e222, "IllegalAccessException", new Object[0]);
            return null;
        }
    }

    public static final boolean byi() {
        if (!cls) {
            Object NR = NR("WxSVGCode");
            if (NR == null) {
                nyM = false;
            } else {
                nyM = ((Boolean) NR).booleanValue();
            }
            c.i("MicroMSG.WeChatSVGConfig", "Initialized mUsingWeChatSVGCode %s", Boolean.valueOf(nyM));
            cls = true;
        }
        if (nyM) {
            return false;
        }
        return true;
    }

    public static final Class<?> byj() {
        Object NR = NR("WxSVGRawClass");
        if (NR != null) {
            return (Class) NR;
        }
        return null;
    }

    public static long byk() {
        return System.nanoTime();
    }

    public static long et(long j) {
        return (System.nanoTime() - j) / 1000;
    }
}
