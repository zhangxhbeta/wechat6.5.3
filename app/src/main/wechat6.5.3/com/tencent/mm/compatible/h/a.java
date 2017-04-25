package com.tencent.mm.compatible.h;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.d.u;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class a {
    private static int cfV = 0;

    public static boolean sh() {
        boolean z = be.ah(VERSION.INCREMENTAL, SQLiteDatabase.KeyEmpty).toLowerCase().contains("flyme") || be.ah(Build.DISPLAY, SQLiteDatabase.KeyEmpty).toLowerCase().contains("flyme");
        if (z) {
            u uVar = p.ceF;
            if (!aa.bto()) {
                uVar.cfb = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "system_config_prefs", 4).getInt("update_swip_back_status", 0);
            }
            if (uVar.cfb == 1) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return false;
            }
        }
        if (cfV == 0) {
            SharedPreferences btk = aa.btk();
            if (btk == null || !btk.getBoolean("settings_support_swipe", true)) {
                cfV = 2;
            } else {
                cfV = 1;
            }
        }
        if (cfV == 1) {
            return true;
        }
        return false;
    }

    public static void az(boolean z) {
        SharedPreferences btk = aa.btk();
        if (btk.getBoolean("settings_support_swipe", true) != z) {
            btk.edit().putBoolean("settings_support_swipe", z).commit();
        }
        v.i("MicroMsg.StyleUtil", "switchSwipebackMode, from %B to %B", Boolean.valueOf(r1), Boolean.valueOf(z));
    }
}
