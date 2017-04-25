package com.tencent.mm.sdk.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.tencent.mm.app.MMApplicationLike;

public final class aa {
    private static Resources BE = null;
    private static String aRm = "com.tencent.mm";
    private static Context context = null;
    private static String niA = "com.tencent.mm";
    private static String niB = "com.tencent.mm.ui.LauncherUI";
    private static boolean niC = false;
    public static boolean niD = false;
    private static ActivityManager niE = null;
    private static String processName = aRm;

    public static void iv(boolean z) {
        niC = z;
    }

    public static boolean btf() {
        return niC;
    }

    public static String btg() {
        return niB;
    }

    public static void setContext(Context context) {
        context = context;
        aRm = context.getPackageName();
        v.d("MicroMsg.MMApplicationContext", "setup application context for package: " + aRm);
    }

    public static Context getContext() {
        return context;
    }

    public static String getPackageName() {
        return aRm;
    }

    public static String bth() {
        return niA;
    }

    public static String bti() {
        return aRm + "_preferences";
    }

    private static String btj() {
        return aRm + "_preferences_exdevice_";
    }

    public static SharedPreferences btk() {
        if (context != null) {
            return context.getSharedPreferences(bti(), 0);
        }
        return null;
    }

    public static SharedPreferences btl() {
        if (context != null) {
            return context.getSharedPreferences(aRm + "_preferences_tools", 0);
        }
        return null;
    }

    public static SharedPreferences btm() {
        if (context == null) {
            return null;
        }
        if (VERSION.SDK_INT >= 11) {
            return context.getSharedPreferences(btj(), 4);
        }
        return context.getSharedPreferences(btj(), 0);
    }

    public static String btn() {
        return aRm + "_tmp_preferences";
    }

    public static String getProcessName() {
        return processName;
    }

    public static void Kh(String str) {
        processName = str;
    }

    public static boolean bto() {
        Object obj = processName;
        if (obj == null || obj.length() == 0) {
            obj = aRm;
        }
        return aRm.equals(obj);
    }

    public static boolean btp() {
        String str = processName;
        if (str == null || str.length() == 0) {
            str = aRm;
        }
        return "com.tencent.mm:push".equalsIgnoreCase(str);
    }

    public static boolean btq() {
        String str = processName;
        if (str == null || str.length() == 0) {
            str = aRm;
        }
        return "com.tencent.mm:tools".equalsIgnoreCase(str);
    }

    public static boolean btr() {
        String str = processName;
        if (str == null || str.length() == 0) {
            str = aRm;
        }
        return "com.tencent.mm:exdevice".equalsIgnoreCase(str);
    }

    public static boolean bts() {
        if (context == null || aRm == null) {
            return false;
        }
        if (niE == null) {
            niE = (ActivityManager) context.getSystemService("activity");
        }
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : niE.getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName.equals(aRm)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            v.e("MicroMsg.MMApplicationContext", "isMMProcessExist Exception: " + e.toString());
            return false;
        } catch (Error e2) {
            v.e("MicroMsg.MMApplicationContext", "isMMProcessExist Error: " + e2.toString());
            return false;
        }
    }

    public static Resources getResources() {
        return BE;
    }

    public static void setResources(Resources resources) {
        BE = resources;
        MMApplicationLike.getTinkerApplicationLike().setResources(BE);
    }
}
