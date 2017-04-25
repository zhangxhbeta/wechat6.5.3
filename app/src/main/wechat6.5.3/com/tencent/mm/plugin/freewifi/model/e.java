package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.mm.plugin.freewifi.c.a;
import com.tencent.mm.plugin.freewifi.d.d;
import com.tencent.mm.plugin.freewifi.e.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.protocal.c.ke;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e {
    public String fYH = "";

    class AnonymousClass1 implements com.tencent.mm.v.e {
        final /* synthetic */ bm enQ;
        final /* synthetic */ e fYI;

        AnonymousClass1(e eVar, bm bmVar) {
            this.fYI = eVar;
            this.enQ = bmVar;
        }

        public final void a(int i, int i2, String str, k kVar) {
            v.i("MicroMsg.FreeWifi.FreeWifiMessageService", "desc=net request [NetSceneCheckIfCallUp] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (m.bF(i, i2)) {
                long j = ((d) kVar).apy().mmM;
                if (j == 0) {
                    v.e("MicroMsg.FreeWifi.FreeWifiMessageService", "It cannot get time from server.");
                    return;
                }
                e eVar = this.fYI;
                bm bmVar = this.enQ;
                ke apy = ((d) kVar).apy();
                if (bmVar == null || bmVar.mbW == null) {
                    v.e("MicroMsg.FreeWifi.FreeWifiMessageService", "cmdAddMsg is null");
                    return;
                }
                String a = com.tencent.mm.platformtools.m.a(bmVar.mbW);
                v.i("MicroMsg.FreeWifi.FreeWifiMessageService", "freewifi push message cmdAM.NewMsgId=%d, msgContent=%s", new Object[]{Long.valueOf(bmVar.mcb), a});
                if (m.ty(a)) {
                    v.e("MicroMsg.FreeWifi.FreeWifiMessageService", "msgContent is empty. return.");
                    return;
                }
                a tF = a.tF(a);
                if (tF == null) {
                    v.e("MicroMsg.FreeWifi.FreeWifiMessageService", "parse schemaMsg failed. return.");
                    return;
                }
                Matcher matcher;
                com.tencent.mm.plugin.freewifi.f.a aVar = new com.tencent.mm.plugin.freewifi.f.a();
                aVar.gao = tF.fYr;
                aVar.gaq = tF.fYs;
                aVar.gap = tF.bssid;
                aVar.gau = tF.ssid;
                aVar.gay = tF.fYu;
                aVar.gas = tF.fYq;
                aVar.gar = tF.fYt;
                String tD = m.tD("MicroMsg.FreeWifi.FreeWifiMessageService");
                aVar.aYA = tD;
                aVar.gat = tD.equals(tF.fYq) ? 0 : 1;
                String tB = m.tB("MicroMsg.FreeWifi.FreeWifiMessageService");
                aVar.gav = tB;
                aVar.gaw = tB.equals(tF.ssid) ? 0 : 1;
                aVar.gax = j;
                aVar.gay = tF.fYu;
                int i3 = j > tF.fYu ? 1 : 0;
                aVar.gaz = i3 == 1 ? 1 : 0;
                aVar.gaD = apy.mmD;
                aVar.gaE = tB;
                boolean equals = tB.equals(apy.mmD);
                aVar.gaF = equals ? 1 : 0;
                aVar.gaA = 1;
                aVar.gaB = apy.mmL;
                CharSequence charSequence = tF.fYt;
                if (!m.ty(charSequence)) {
                    matcher = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher(charSequence);
                    if (matcher.find()) {
                        aVar.gaC = matcher.group(2);
                    }
                }
                e.a(aVar);
                if (!equals) {
                    v.e("MicroMsg.FreeWifi.FreeWifiMessageService", "ssid has changed ! svr back ssid is not equal client ssid. ");
                    return;
                } else if (i3 != 0) {
                    v.e("MicroMsg.FreeWifi.FreeWifiMessageService", "Msg time expired. return.");
                    return;
                } else if (apy.mmL == 0 && !m.ty(charSequence)) {
                    matcher = Pattern.compile("apKey=([^&]+)&ticket=([^&$]+)").matcher(charSequence);
                    if (matcher.find()) {
                        Object group = matcher.group(1);
                        try {
                            a = URLDecoder.decode(group, "utf8");
                            tD = matcher.group(2);
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_ap_key", a);
                            intent.putExtra("free_wifi_source", 5);
                            intent.putExtra("free_wifi_threeone_startup_type", 3);
                            intent.putExtra("free_wifi_schema_ticket", tD);
                            intent.putExtra("free_wifi_sessionkey", tD);
                            if (!eVar.fYH.equals(tD)) {
                                eVar.fYH = tD;
                                b.apF();
                                b.x(intent);
                                return;
                            }
                            return;
                        } catch (UnsupportedEncodingException e) {
                            v.i("MicroMsg.FreeWifi.FreeWifiMessageService", "sessionKey=%s, step=%d, method=Protocol31Handler.handleInterruptedProtocol31Schema, desc=Exception happens when decoding apkey. schemaUrl=%s, apkey=%s, e.getMessage()=%s", new Object[]{"", Integer.valueOf(0), charSequence, group, e.getMessage()});
                            return;
                        }
                    }
                    return;
                } else {
                    return;
                }
            }
            com.tencent.mm.plugin.freewifi.f.a aVar2 = new com.tencent.mm.plugin.freewifi.f.a();
            aVar2.gan = i2;
            aVar2.gam = i;
            e.a(aVar2);
        }
    }

    static void a(com.tencent.mm.plugin.freewifi.f.a aVar) {
        g.iuh.h(13493, new Object[]{Integer.valueOf(aVar.gam), Integer.valueOf(aVar.gan), m.tA(aVar.gao), m.tA(aVar.gap), Long.valueOf(aVar.gaq), m.tA(aVar.gar), m.tA(aVar.gas), m.tA(aVar.aYA), Integer.valueOf(aVar.gat), m.tA(aVar.gau), m.tA(aVar.gav), Integer.valueOf(aVar.gaw), Long.valueOf(aVar.gax), Long.valueOf(aVar.gay), Integer.valueOf(aVar.gaz), Integer.valueOf(aVar.gaA), Integer.valueOf(aVar.gaB), m.tA(aVar.gaC), m.tA(aVar.gaD), m.tA(aVar.gaE), Integer.valueOf(aVar.gaF)});
    }
}
