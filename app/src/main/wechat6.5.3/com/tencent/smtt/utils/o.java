package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;

public final class o {
    private static String pzl = null;
    private static String pzm = "GA";
    private static String pzn = "GE";
    private static String pzo = "9422";
    private static String pzp = "0";
    private static String pzq = SQLiteDatabase.KeyEmpty;
    private static boolean pzr = false;
    private static boolean pzs = false;
    private static boolean pzt = false;

    private static String a(Context context, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z) {
        String str8;
        String str9 = null;
        String str10 = "PHONE";
        StringBuilder stringBuilder = new StringBuilder();
        String str11 = gc(context) + "*" + gd(context);
        try {
            ApplicationInfo applicationInfo = context.getApplicationContext().getApplicationInfo();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0);
            str9 = applicationInfo.packageName;
            if (TextUtils.isEmpty(str7)) {
                str7 = packageInfo.versionName;
            }
        } catch (Exception e) {
            str7 = null;
        }
        String str12 = str9.equals("com.tencent.mm") ? "WX" : str9.equals("com.tencent.mobileqq") ? "QQ" : str9.equals("com.qzone") ? "QZ" : str9.equals("com.tencent.mtt") ? "QB" : "TRD";
        if ("QB".equals(str12)) {
            if (z) {
                str8 = "PAD";
            }
            str8 = str10;
        } else {
            boolean z2;
            if (pzs) {
                z2 = pzt;
            } else {
                int min = Math.min(gc(context), gd(context)) * 160;
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                DisplayMetrics displayMetrics = new DisplayMetrics();
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                pzt = min / displayMetrics.densityDpi >= 700;
                pzs = true;
                z2 = pzt;
            }
            if (z2) {
                str8 = "PAD";
            }
            str8 = str10;
        }
        stringBuilder.append("QV=3");
        b(stringBuilder, "PL", "ADR");
        b(stringBuilder, "PR", str12);
        b(stringBuilder, "PP", str9);
        b(stringBuilder, "PPVN", str7);
        if (!TextUtils.isEmpty(str)) {
            b(stringBuilder, "TBSVC", str);
        }
        b(stringBuilder, "CO", "SYS");
        if (!TextUtils.isEmpty(str2)) {
            b(stringBuilder, "COVC", str2);
        }
        b(stringBuilder, "PB", str4);
        b(stringBuilder, "VE", str3);
        b(stringBuilder, "DE", str8);
        str8 = "CHID";
        if (TextUtils.isEmpty(str6)) {
            str6 = "0";
        }
        b(stringBuilder, str8, str6);
        b(stringBuilder, "LCID", str5);
        str9 = " " + Build.MODEL.replaceAll("[ |\\/|\\_|\\&|\\|]", SQLiteDatabase.KeyEmpty) + " ";
        try {
            Object str13 = new String(str9.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e2) {
            str8 = str9;
        }
        if (!TextUtils.isEmpty(str13)) {
            b(stringBuilder, "MO", str13);
        }
        b(stringBuilder, "RL", str11);
        str9 = VERSION.RELEASE;
        try {
            str13 = new String(str9.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e3) {
            str8 = str9;
        }
        if (!TextUtils.isEmpty(str13)) {
            b(stringBuilder, "OS", str13);
        }
        b(stringBuilder, "API", VERSION.SDK_INT);
        return stringBuilder.toString();
    }

    private static void b(StringBuilder stringBuilder, String str, String str2) {
        stringBuilder.append("&").append(str).append("=").append(str2);
    }

    public static String gb(Context context) {
        if (!TextUtils.isEmpty(pzl)) {
            return pzl;
        }
        String a = a(context, String.valueOf(WebView.getTbsSDKVersion(context)), "0", pzm, pzn, pzo, pzp, pzq, pzr);
        pzl = a;
        return a;
    }

    private static int gc(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    private static int gd(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
    }
}
