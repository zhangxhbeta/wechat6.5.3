package com.tencent.mm.plugin.a;

import com.tencent.mm.model.be;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class b {
    public static void gM(int i) {
        if (i > 0) {
            be.zN();
            be.zN();
            if (i == 20) {
                aa.getContext().getSharedPreferences(aa.bti(), 0).edit().putInt("reg_style_id", i).commit();
            }
        }
    }

    private static int Fp() {
        return aa.getContext().getSharedPreferences(aa.bti(), 0).getInt("reg_style_id", 0);
    }

    public static void mh(String str) {
        aa.getContext().getSharedPreferences(aa.bti(), 0).edit().putString("reg_last_exit_ui", str).commit();
    }

    public static String Oa() {
        return aa.getContext().getSharedPreferences(aa.bti(), 0).getString("reg_last_exit_ui", SQLiteDatabase.KeyEmpty);
    }

    public static void mi(String str) {
        aa.getContext().getSharedPreferences(aa.bti(), 0).edit().putString("reg_next_enter_ui", str).commit();
    }

    public static void mj(String str) {
        com.tencent.mm.plugin.report.b.itm.a(10645, str + "," + Fp() + "," + com.tencent.mm.sdk.platformtools.be.Ni() + "," + Oa(), true, true);
    }

    public static void b(boolean z, String str) {
        String str2;
        if (z) {
            str2 = str + "," + Fp() + "," + com.tencent.mm.sdk.platformtools.be.Ni() + "," + Oa();
        } else {
            str2 = str + "," + Fp() + "," + com.tencent.mm.sdk.platformtools.be.Ni() + "," + aa.getContext().getSharedPreferences(aa.bti(), 0).getString("reg_next_enter_ui", SQLiteDatabase.KeyEmpty);
        }
        com.tencent.mm.plugin.report.b.itm.a(10645, str2, true, true);
    }
}
