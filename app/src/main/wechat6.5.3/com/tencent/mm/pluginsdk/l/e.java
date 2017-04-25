package com.tencent.mm.pluginsdk.l;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.e.a.gu;
import com.tencent.mm.pluginsdk.l.a.c;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class e {
    public static c bol() {
        String string = aa.btk().getString("cpu_id", "");
        String string2 = aa.btk().getString("uid", "");
        if (be.kS(string) || be.kS(string2)) {
            v.w("MicroMsg.SoterDeviceInfoManager", "hy: no cpu id and uid retrieved. load again");
            gu guVar = new gu();
            a.nhr.z(guVar);
            string = guVar.bgq.bgr;
            string2 = guVar.bgq.bgs;
            if (be.kS(string) || be.kS(string2)) {
                return new c();
            }
            do(string, string2);
            return new c(string, string2);
        }
        v.i("MicroMsg.SoterDeviceInfoManager", "hy:device info exists in preference. directly return");
        return new c(string, string2);
    }

    public static void do(String str, String str2) {
        SharedPreferences btk = aa.btk();
        if (btk != null) {
            v.i("MicroMsg.SoterDeviceInfoManager", "hy: save device info");
            Editor edit = btk.edit();
            edit.putString("cpu_id", str);
            edit.putString("uid", str2);
            edit.apply();
        }
    }
}
