package com.tencent.mm.plugin.freewifi.ui;

import android.os.Looper;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public final class c {
    public static void qq() {
        try {
            b aqa = b.aqa();
            a anonymousClass1 = new a() {
                public final void n(float f, float f2) {
                    try {
                        String valueOf = String.valueOf(f);
                        String valueOf2 = String.valueOf(f2);
                        if (j.apj().tP(d.aoY()) != null) {
                            g.iuh.h(12073, new Object[]{r2.field_ssid, r2.field_mac, r2.field_url, r2.field_url, valueOf2, valueOf});
                            v.i("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location. ssid=%s, mac=%s, mp_url=%s, qrcode=%s, longtitued=%s, latitude=%s", new Object[]{r2.field_ssid, r2.field_mac, r2.field_url, r2.field_url, valueOf, valueOf2});
                        }
                    } catch (Exception e) {
                        v.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location exception. " + e.getMessage() + m.f(e));
                    }
                }
            };
            if (!aqa.aHp) {
                aqa.aHp = true;
                aqa.dGN = com.tencent.mm.modelgeo.c.FY();
                if (aqa.dGN == null) {
                    v.e(b.TAG, "doGeoLocation fail, iGetLocation is null");
                    return;
                }
                if (aqa.dGO == null) {
                    aqa.dGO = new com.tencent.mm.plugin.freewifi.ui.b.AnonymousClass1(aqa, anonymousClass1);
                }
                if (aqa.dGP == null) {
                    aqa.dGP = new ac(Looper.myLooper());
                }
                aqa.dGP.postDelayed(new Runnable(aqa) {
                    final /* synthetic */ b gbV;

                    {
                        this.gbV = r1;
                    }

                    public final void run() {
                        this.gbV.aHp = false;
                        if (this.gbV.dGN != null) {
                            this.gbV.dGN.c(this.gbV.dGO);
                        }
                        if (this.gbV.dGO == null) {
                            v.w(b.TAG, "already callback");
                        } else {
                            this.gbV.dGO = null;
                        }
                    }
                }, 20000);
                aqa.dGN.a(aqa.dGO);
            }
        } catch (Exception e) {
            v.e("MicroMsg.FreeWifi.FreeWifiLocationReporter", "report location error. " + e.getMessage());
        }
    }
}
