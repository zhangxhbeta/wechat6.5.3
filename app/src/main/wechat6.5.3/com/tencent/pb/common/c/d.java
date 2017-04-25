package com.tencent.pb.common.c;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class d {
    private static boolean DEBUG = false;
    public static int jco = 320;
    public static Context kzS = null;
    private static final Uri kzU = Uri.parse("content://com.lbe.security.miui.permmgr/active");
    private static String lWe = null;
    public static boolean psQ = false;
    public static long psR = 0;
    public static String psS = null;
    private static int psT = -1;
    public static int psU = 480;
    private static String sImei = null;

    public static int bMh() {
        if (psT < 0) {
            psT = VERSION.SDK_INT;
        }
        return psT;
    }

    public static String bMi() {
        if (lWe == null) {
            lWe = VERSION.RELEASE;
        }
        return lWe;
    }

    public static String getModel() {
        return Build.MODEL;
    }

    public static String bMj() {
        return VERSION.INCREMENTAL;
    }

    public static String bMk() {
        String str;
        String str2 = "UNKNOW";
        if (bMh() > 8) {
            try {
                str = (String) ((Build) Class.forName("android.os.Build").newInstance()).getClass().getField("HARDWARE").get(str2);
            } catch (SecurityException e) {
                str = str2;
            } catch (ClassNotFoundException e2) {
                str = str2;
            } catch (IllegalAccessException e3) {
                str = str2;
            } catch (InstantiationException e4) {
                str = str2;
            } catch (NoSuchFieldException e5) {
            }
            c.d(SQLiteDatabase.KeyEmpty, "hardware:" + str);
            return str;
        }
        str = str2;
        c.d(SQLiteDatabase.KeyEmpty, "hardware:" + str);
        return str;
    }

    public static boolean Bd(String str) {
        if (SQLiteDatabase.KeyEmpty.equals(str)) {
            return false;
        }
        try {
            if (kzS.getPackageManager().getApplicationInfo(str, FileUtils.S_IWUSR) != null) {
                return true;
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public static String bMl() {
        String str = Build.MANUFACTURER;
        if (str == null) {
            return "UNKNOWN";
        }
        return str;
    }
}
