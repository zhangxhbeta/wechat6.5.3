package com.tencent.mm.plugin.freewifi.b;

import android.content.Intent;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.eb;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiManufacturerLoadingUI;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;

public final class b {

    private static class a {
        private static b fYf = new b();
    }

    private b() {
    }

    public final synchronized void a(eb ebVar) {
        v.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Method connectWifi gets called");
        final String tz = m.tz(ebVar.bbZ.ssid);
        final String str = ebVar.bbZ.bssid;
        if (m.ty(tz)) {
            a(ebVar, 1141, "Ssid is empty.");
        } else if (m.ty(str)) {
            a(ebVar, 1142, "Bssid is empty.");
        } else {
            v.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "args: ssid=" + ebVar.bbZ.ssid + "; bssid=" + ebVar.bbZ.bssid + "; version=" + ebVar.bbZ.version);
            v.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Try to get connect info from cache");
            com.tencent.mm.plugin.freewifi.b.a.b bC = a.fYb.bC(tz, str);
            v.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "read cache done.");
            if (bC != null) {
                final String str2 = bC.aYz;
                int i = bC.fXb;
                if (i == 4) {
                    v.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to start up password ap connect page.");
                    ad.o(new Runnable(this) {
                        final /* synthetic */ b fYc;

                        public final void run() {
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_ap_key", str2);
                            intent.putExtra("free_wifi_sessionkey", m.aoC());
                            intent.putExtra("free_wifi_source", 6);
                            intent.addFlags(67108864);
                            c.b(aa.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
                        }
                    });
                    a(ebVar, 1, null);
                } else if (i == 31) {
                    v.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "Ready to connect 31 page.");
                    ad.o(new Runnable(this) {
                        final /* synthetic */ b fYc;

                        public final void run() {
                            Intent intent = new Intent();
                            intent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Ssid", tz);
                            intent.putExtra("ConstantsFreeWifi.FreeWifiManufacturerConnectWifiHelper_Bssid", str);
                            intent.setClass(aa.getContext(), FreeWifiManufacturerLoadingUI.class);
                            intent.addFlags(268435456);
                            aa.getContext().startActivity(intent);
                        }
                    });
                    a(ebVar, 1, null);
                } else {
                    a(ebVar, 1143, "Wechant installed Currently doesn't support connect protocol " + i);
                }
            } else if (a.fYb.size() == 0) {
                a(ebVar, 1145, "Ap connect info cache in wechat is empty. It may be wechat got killed before.");
            } else {
                a(ebVar, 1144, "Ap connect info cache in wechat is not empty but the ap tried to connect to is not contained in the cache.");
            }
        }
    }

    private static void a(eb ebVar, int i, String str) {
        ebVar.bca.bcd = i;
        ebVar.bca.bce = str;
        ebVar.bca.bcc = 1;
        v.i("MicroMsg.FreeWifi.FreeWifiManufacturerConnectWifiHelper", "FreeWifiManufacturerConnectWifiHelper setResult. errorcode=%d, errmsg=%s", new Object[]{Integer.valueOf(i), str});
        if (ebVar.bpT != null) {
            ebVar.bpT.run();
        }
    }
}
