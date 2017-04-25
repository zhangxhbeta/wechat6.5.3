package com.tencent.mm.protocal;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;

public final class d extends f {
    public static String cmW = ("android-" + VERSION.SDK_INT);
    public static final String lWa = Build.BRAND;
    public static final String lWb = (Build.MODEL + Build.CPU_ABI);
    public static String lWc = ("android-" + VERSION.SDK_INT);
    public static final String lWd = ("android-" + Build.MANUFACTURER);
    public static String lWe = (VERSION.SDK_INT);
    public static final String lWf = (Build.MANUFACTURER + "-" + Build.MODEL);
    public static long lWg = 0;
    public static int lWh;
    public static boolean lWi = brx();
    public static boolean lWj = brw();
    public static boolean lWk = brv();
    public static boolean lWl = bru();
    public static int lWm = 5;
    public static final byte[] lWn = null;
    public static final byte[] lWo = null;
    public static final byte[] lWp = null;

    public static void uA(int i) {
        lWh = i;
        lWk = brv();
        lWl = bru();
        lWi = brx();
        lWj = brw();
    }

    static {
        lWh = Integer.decode("0x26050341").intValue();
        try {
            int i = aa.getContext().getPackageManager().getApplicationInfo(aa.getPackageName(), FileUtils.S_IWUSR).metaData.getInt("com.tencent.mm.BuildInfo.CLIENT_VERSION");
            if (i > lWh && i - lWh < WebView.NORMAL_MODE_ALPHA && (i & WebView.NORMAL_MODE_ALPHA) >= 48) {
                lWh = i;
            }
        } catch (Exception e) {
            v.h("MicroMsg.ConstantsProtocal", SQLiteDatabase.KeyEmpty, e);
        }
    }

    private static boolean bru() {
        return (lWh & WebView.NORMAL_MODE_ALPHA) >= 32 && (lWh & WebView.NORMAL_MODE_ALPHA) <= 47;
    }

    private static boolean brv() {
        return (lWh & WebView.NORMAL_MODE_ALPHA) >= 0 && (lWh & WebView.NORMAL_MODE_ALPHA) <= 31;
    }

    private static boolean brw() {
        return (lWh & WebView.NORMAL_MODE_ALPHA) >= 96 && (lWh & WebView.NORMAL_MODE_ALPHA) <= 159;
    }

    private static boolean brx() {
        return (lWh & WebView.NORMAL_MODE_ALPHA) >= 48 && (lWh & WebView.NORMAL_MODE_ALPHA) <= 95;
    }
}
