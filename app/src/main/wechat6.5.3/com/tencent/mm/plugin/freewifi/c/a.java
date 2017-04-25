package com.tencent.mm.plugin.freewifi.c;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Map;

public final class a {
    public String bssid;
    public String fYq;
    public String fYr;
    public long fYs;
    public String fYt;
    public long fYu;
    public String ssid;
    public String type;
    public long uin;

    private a() {
    }

    public static a tF(String str) {
        v.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "It starts to parse msgContent for FreeWifiSchemaMsg. msgContent=%s", new Object[]{str});
        if (m.ty(str)) {
            v.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "msgCoentent is empty. return.");
            return null;
        }
        v.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Shorten msgContent into one line. msgContent=%s", new Object[]{str});
        Map q = bf.q(str, "sysmsg");
        if (q == null || q.size() == 0) {
            v.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsing xml failed");
            return null;
        }
        v.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "Parsed values = " + q.toString());
        if ("freewifi".equalsIgnoreCase((String) q.get(".sysmsg.$type"))) {
            a aVar = new a();
            aVar.type = (String) q.get(".sysmsg.type");
            v.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type=" + aVar.type);
            if ("schemamsg".equals(aVar.type)) {
                boolean h = m.h(q, "MicroMsg.FreeWifi.FreeWifiSchemaMsg");
                v.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "checkMsgPushedVersion=" + h);
                if (h) {
                    aVar.uin = be.getLong((String) q.get(".sysmsg.uin"), 0);
                    v.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.uin=" + aVar.uin);
                    aVar.ssid = (String) q.get(".sysmsg.schemamsg.ssid");
                    v.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.ssid=" + aVar.ssid);
                    if (m.ty(aVar.ssid)) {
                        v.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.ssid is empty. return.");
                        return null;
                    }
                    aVar.bssid = m.tA((String) q.get(".sysmsg.schemamsg.bssid"));
                    v.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.bssid=" + aVar.bssid);
                    aVar.fYq = (String) q.get(".sysmsg.schemamsg.mobilemac");
                    v.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mobilemac=" + aVar.fYq);
                    if (m.ty(aVar.fYq)) {
                        v.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.mobilemac is empty. return.");
                        return null;
                    }
                    aVar.fYr = (String) q.get(".sysmsg.schemamsg.mpappid");
                    v.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpappid=" + aVar.fYr);
                    aVar.fYs = be.getLong((String) q.get(".sysmsg.schemamsg.mpshopid"), 0);
                    v.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.mpshopid=" + aVar.fYs);
                    aVar.fYt = (String) q.get(".sysmsg.schemamsg.schemaurl");
                    v.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.schemaurl=" + aVar.fYt);
                    if (m.ty(aVar.fYt)) {
                        v.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "scemaMsg.schemaurl is empty. return.");
                        return null;
                    }
                    aVar.fYu = be.getLong((String) q.get(".sysmsg.schemamsg.expiredseconds"), 0);
                    v.i("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schema.expiredseconds=" + aVar.fYu);
                    return aVar;
                }
                v.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "version not matched. return.");
                return null;
            }
            v.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "schemaMsg.type is not schemamsg. return.");
            return null;
        }
        v.e("MicroMsg.FreeWifi.FreeWifiSchemaMsg", "sysmsg type is not freewifi. return.");
        return null;
    }
}
