package com.tencent.wxop.stat.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public final class q {
    private static SharedPreferences pLW = null;

    public static String C(Context context, String str, String str2) {
        return hp(context).getString(l.bC(context, "wxop_" + str), str2);
    }

    public static void a(Context context, String str, long j) {
        String bC = l.bC(context, "wxop_" + str);
        Editor edit = hp(context).edit();
        edit.putLong(bC, j);
        edit.commit();
    }

    public static long bD(Context context, String str) {
        return hp(context).getLong(l.bC(context, "wxop_" + str), 0);
    }

    private static synchronized SharedPreferences hp(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (q.class) {
            sharedPreferences = context.getSharedPreferences(".mta-wxop", 0);
            pLW = sharedPreferences;
            if (sharedPreferences == null) {
                pLW = PreferenceManager.getDefaultSharedPreferences(context);
            }
            sharedPreferences = pLW;
        }
        return sharedPreferences;
    }

    public static int m(Context context, String str, int i) {
        return hp(context).getInt(l.bC(context, "wxop_" + str), i);
    }

    public static void n(Context context, String str, int i) {
        String bC = l.bC(context, "wxop_" + str);
        Editor edit = hp(context).edit();
        edit.putInt(bC, i);
        edit.commit();
    }
}
