package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiNetCheckUI;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class b {
    private static String TAG = "MicroMsg.FreeWifi.Protocol31Entry";

    private static class a {
        private static b fZw = new b();
    }

    private b() {
    }

    public static b apF() {
        return a.fZw;
    }

    public static void x(Intent intent) {
        boolean z = true;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("free_wifi_ap_key");
            if (!m.ty(stringExtra)) {
                int intExtra = intent.getIntExtra("free_wifi_threeone_startup_type", 0);
                if (2 == intExtra) {
                    intExtra = 11;
                } else if (3 == intExtra) {
                    intExtra = 12;
                } else if (4 == intExtra) {
                    intExtra = 13;
                } else {
                    intExtra = 1;
                }
                intent.putExtra("free_wifi_channel_id", intExtra);
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_PROTOCOL_NUMBER", 31);
                m.d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
                intent.putExtra("ConstantsFreeWifi.FREE_WIFI_REPORT_WIFI_SERVER_ID", m.s(intent) + "_" + m.u(intent) + "_" + m.v(intent) + "_" + System.currentTimeMillis());
                boolean l = a.fZB.l(intent.getIntExtra("free_wifi_threeone_startup_type", 0), intent.getStringExtra("free_wifi_ap_key"), intent.getStringExtra("free_wifi_schema_ticket"));
                com.tencent.mm.plugin.freewifi.k.a aoy = k.aoy();
                aoy.ssid = m.tB(TAG);
                aoy.bssid = m.tC(TAG);
                aoy.aYz = stringExtra;
                aoy.fXa = intent.getStringExtra("free_wifi_schema_ticket");
                aoy.fXb = m.u(intent);
                aoy.fXc = com.tencent.mm.plugin.freewifi.k.b.GetThreeOneLock.fXM;
                aoy.fXd = com.tencent.mm.plugin.freewifi.k.b.GetThreeOneLock.name;
                aoy.bkh = m.v(intent);
                if (l) {
                    intExtra = 0;
                } else {
                    intExtra = -1;
                }
                aoy.bpc = intExtra;
                k aoA = aoy.aoA();
                if (l) {
                    z = false;
                }
                aoA.b(intent, z).aoz();
                v.i(TAG, "getLock = " + l);
                m.tE("type=" + intent.getIntExtra("free_wifi_threeone_startup_type", 0) + ";getLock=" + l);
                if (l) {
                    m.d(intent, intent.getStringExtra("free_wifi_schema_ticket"));
                    intent.setClass(aa.getContext(), FreeWifiNetCheckUI.class);
                    intent.addFlags(67108864);
                    c.b(aa.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                }
            }
        }
    }
}
