package com.tencent.mm.model;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.report.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.t;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class am {
    public static SharedPreferences zc() {
        SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("auth_info_key_prefs", 4);
        if (!sharedPreferences.getBoolean("key_auth_info_prefs_created", false)) {
            b.itm.a(148, 12, 1, true);
            q qVar = new q(t.cng + "autoauth.cfg");
            boolean commit;
            if (qVar.nnY || qVar.get(3) == null) {
                SharedPreferences sharedPreferences2 = aa.getContext().getSharedPreferences("auto_auth_key_prefs", 4);
                Editor edit = sharedPreferences.edit();
                edit.putBoolean("key_auth_info_prefs_created", true);
                edit.putInt("key_auth_update_version", sharedPreferences2.getInt("key_auth_update_version", 0));
                edit.putInt("_auth_uin", sharedPreferences2.getInt("_auth_uin", 0));
                edit.putString("_auth_key", sharedPreferences2.getString("_auth_key", SQLiteDatabase.KeyEmpty));
                edit.putString("server_id", aa.getContext().getSharedPreferences("server_id_prefs", 4).getString("server_id", SQLiteDatabase.KeyEmpty));
                commit = edit.commit();
                v.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use oldAAKsp now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", Boolean.valueOf(commit), Boolean.valueOf(sharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(sharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(sharedPreferences.getInt("_auth_uin", 0)), sharedPreferences.getString("_auth_key", SQLiteDatabase.KeyEmpty), sharedPreferences.getString("server_id", SQLiteDatabase.KeyEmpty));
            } else {
                Editor edit2 = sharedPreferences.edit();
                edit2.putBoolean("key_auth_info_prefs_created", true);
                edit2.putInt("key_auth_update_version", ((Integer) qVar.get(1)).intValue());
                edit2.putInt("_auth_uin", ((Integer) qVar.get(2)).intValue());
                edit2.putString("_auth_key", (String) qVar.get(3));
                edit2.putString("server_id", (String) qVar.get(4));
                commit = edit2.commit();
                v.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use autoauthcfg now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", Boolean.valueOf(commit), Boolean.valueOf(sharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(sharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(sharedPreferences.getInt("_auth_uin", 0)), sharedPreferences.getString("_auth_key", SQLiteDatabase.KeyEmpty), sharedPreferences.getString("server_id", SQLiteDatabase.KeyEmpty));
                b.itm.a(148, 51, 1, true);
                return sharedPreferences;
            }
        }
        return sharedPreferences;
    }
}
