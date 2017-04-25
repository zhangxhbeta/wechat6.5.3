package com.tencent.mm.plugin.freewifi.g;

import android.database.Cursor;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;

public final class d extends f<c> {
    public static final String[] cic = new String[]{f.a(c.chq, "FreeWifiInfo"), "CREATE INDEX IF NOT EXISTS freewifi_md5_ssid  on FreeWifiInfo  (  ssidmd5 )"};

    public d(com.tencent.mm.sdk.h.d dVar) {
        super(dVar, c.chq, "FreeWifiInfo", null);
    }

    public final c tO(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
            return null;
        }
        v.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", new Object[]{"select * from FreeWifiInfo where ssidmd5 = '" + z.Kg(str) + "' and wifiType = 1"});
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery == null) {
            v.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.b(rawQuery);
            rawQuery.close();
            return cVar;
        } else {
            rawQuery.close();
            return null;
        }
    }

    public final c tP(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "ssid is null");
            return null;
        }
        v.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getFreeWifiInfoBySSID, sql : %s", new Object[]{"select * from FreeWifiInfo where ssidmd5 = '" + z.Kg(str) + "'"});
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery == null) {
            v.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "cursor is null");
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.b(rawQuery);
            rawQuery.close();
            return cVar;
        } else {
            rawQuery.close();
            return null;
        }
    }

    public final c apL() {
        v.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "getLastConnectSuccessWifiInfo, sql : %s", new Object[]{"select * from FreeWifiInfo where connectState = 2"});
        Cursor rawQuery = rawQuery("select * from FreeWifiInfo where connectState = 2", new String[0]);
        if (rawQuery == null) {
            v.e("MicroMsg.FreeWifi.FreeWifiInfoStorage", "no connected sucess wifi info");
            return null;
        } else if (rawQuery.moveToFirst()) {
            c cVar = new c();
            cVar.b(rawQuery);
            rawQuery.close();
            return cVar;
        } else {
            rawQuery.close();
            return null;
        }
    }

    public final void tQ(String str) {
        v.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "updateOtherAp : %s", new Object[]{"update FreeWifiInfo set connectState = -1 where ssidmd5 !='" + z.Kg(str) + "'"});
        boolean dF = dF("FreeWifiInfo", r0);
        v.d("MicroMsg.FreeWifi.FreeWifiInfoStorage", "update other ap  ret = %b", new Object[]{Boolean.valueOf(dF)});
    }
}
