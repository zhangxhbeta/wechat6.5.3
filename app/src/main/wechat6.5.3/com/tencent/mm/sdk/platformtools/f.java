package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public final class f {
    public static int aPW = 0;
    public static String aPX = (VERSION.SDK_INT);
    public static int aPY = 0;
    public static int aQc = 0;
    public static int nhU = 0;
    public static int nhV = 0;
    public static String nhW = ("market://details?id=" + aa.getPackageName());
    public static boolean nhX = false;
    public static boolean nhY = true;
    public static boolean nhZ = false;
    public static boolean nia = false;

    public static void dE(Context context) {
        try {
            aPW = Integer.parseInt((String) q.Kb(be.e(context.getAssets().open("channel.ini"))).get("CHANNEL"));
        } catch (Throwable e) {
            v.e("MicroMsg.SDK.ChannelUtil", "setup channel id from channel.ini failed");
            v.a("MicroMsg.SDK.ChannelUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public static void dF(Context context) {
        try {
            Map Kb = q.Kb(be.e(context.getAssets().open("profile.ini")));
            String ma = be.ma((String) Kb.get("PROFILE_DEVICE_TYPE"));
            aPX = ma;
            if (ma.length() <= 0) {
                aPX = VERSION.SDK_INT;
            }
            aPY = parseInt((String) Kb.get("UPDATE_MODE"));
            nhV = parseInt((String) Kb.get("BUILD_REVISION"));
            nhZ = parseBoolean((String) Kb.get("GPRS_ALERT"));
            aQc = parseInt((String) Kb.get("AUTO_ADD_ACOUNT"));
            nia = parseBoolean((String) Kb.get("NOKIA_AOL"));
            v.w("MicroMsg.SDK.ChannelUtil", "profileDeviceType=" + aPX);
            v.w("MicroMsg.SDK.ChannelUtil", "updateMode=" + aPY);
            v.w("MicroMsg.SDK.ChannelUtil", "shouldShowGprsAlert=" + nhZ);
            v.w("MicroMsg.SDK.ChannelUtil", "autoAddAccount=" + aQc);
            v.w("MicroMsg.SDK.ChannelUtil", "isNokiaol=" + nia);
            ma = (String) Kb.get("MARKET_URL");
            if (!(ma == null || ma.trim().length() == 0 || Uri.parse(ma) == null)) {
                nhW = ma;
            }
            v.w("MicroMsg.SDK.ChannelUtil", "marketURL=" + nhW);
        } catch (Throwable e) {
            v.e("MicroMsg.SDK.ChannelUtil", "setup profile from profile.ini failed");
            v.a("MicroMsg.SDK.ChannelUtil", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    private static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            v.w("MicroMsg.SDK.ChannelUtil", e.getMessage());
            return 0;
        }
    }

    private static boolean parseBoolean(String str) {
        boolean z = false;
        try {
            z = Boolean.parseBoolean(str);
        } catch (Throwable e) {
            v.a("MicroMsg.SDK.ChannelUtil", e, SQLiteDatabase.KeyEmpty, new Object[z]);
            v.w("MicroMsg.SDK.ChannelUtil", e.getMessage());
        }
        return z;
    }

    public static String S(Context context, int i) {
        return b(context, i, nhX);
    }

    public static String b(Context context, int i, boolean z) {
        String str;
        int i2 = (i >> 8) & WebView.NORMAL_MODE_ALPHA;
        if (i2 == 0) {
            str = ((i >> 24) & 15) + "." + ((i >> 16) & WebView.NORMAL_MODE_ALPHA);
        } else {
            str = ((i >> 24) & 15) + "." + ((i >> 16) & WebView.NORMAL_MODE_ALPHA) + "." + i2;
        }
        v.d("MicroMsg.SDK.ChannelUtil", "minminor " + i2);
        i2 = 268435455 & i;
        if (context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), FileUtils.S_IWUSR);
                if (packageInfo != null) {
                    i2 = packageInfo.versionCode;
                    str = packageInfo.versionName;
                }
            } catch (Throwable e) {
                Throwable th = e;
                int i3 = i2;
                v.a("MicroMsg.SDK.ChannelUtil", th, SQLiteDatabase.KeyEmpty, new Object[0]);
                i2 = i3;
            }
        }
        if (z) {
            str = str + "_" + i2;
            v.d("MicroMsg.SDK.ChannelUtil", "full version: " + str);
            return str;
        }
        String[] split = str.split("\\.");
        if (split == null || split.length < 4) {
            return str;
        }
        str = split[0] + "." + split[1];
        return !split[2].trim().equals("0") ? str + "." + split[2] : str;
    }
}
