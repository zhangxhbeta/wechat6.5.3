package com.tencent.mm.compatible.d;

import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;

public final class u {
    public static boolean ceY = false;
    public String ceZ = SQLiteDatabase.KeyEmpty;
    Map<String, String> cfa = null;
    public int cfb = 0;

    public final void dT(int i) {
        this.cfb = i;
        ceY = true;
        Editor edit = MultiProcessSharedPreferences.getSharedPreferences(aa.getContext(), "system_config_prefs", 4).edit();
        edit.putInt("update_swip_back_status", i);
        edit.commit();
        v.v("MicroMsg.ManuFacturerInfo", "update mSwipBackStatus(%s)", Integer.valueOf(this.cfb));
    }

    public static boolean sa() {
        if (!ceY) {
            return false;
        }
        ceY = false;
        return true;
    }

    public final void ds(String str) {
        this.ceZ = str;
    }

    public final void i(Map<String, String> map) {
        this.cfa = map;
    }
}
