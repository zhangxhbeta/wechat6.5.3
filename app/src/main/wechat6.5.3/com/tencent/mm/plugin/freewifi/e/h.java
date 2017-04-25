package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.v;
import java.net.HttpURLConnection;

public final class h extends e implements a {
    private String fZO = this.intent.getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    private int fZP = 0;

    static /* synthetic */ void a(h hVar, String str) {
        hVar.fZP++;
        if (hVar.fZP > 3) {
            v.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.s(hVar.intent), Integer.valueOf(m.t(hVar.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = hVar.fZC;
            d dVar = d.FAIL;
            a aVar = new a();
            aVar.gbN = m.a(hVar.fZE, b.ThreeOneAuth, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            hVar.N(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        v.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.s(hVar.intent), Integer.valueOf(m.t(hVar.intent)), str});
        if (m.ty(str)) {
            freeWifiFrontPageUI = hVar.fZC;
            dVar = d.FAIL;
            aVar = new a();
            aVar.gbN = m.a(hVar.fZE, b.ThreeOneAuth, 34);
            freeWifiFrontPageUI.a(dVar, aVar);
            hVar.N(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a anonymousClass2 = new com.tencent.mm.plugin.freewifi.a.a.a(hVar) {
            final /* synthetic */ h fZQ;

            {
                this.fZQ = r1;
            }

            public final void c(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                v.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.s(this.fZQ.intent), Integer.valueOf(m.t(this.fZQ.intent)), Integer.valueOf(responseCode)});
                if (responseCode == 200) {
                    this.fZQ.N(0, "");
                    m.a(this.fZQ.intent, this.fZQ.aYz, this.fZQ.fZE, this.fZQ.aPW, this.fZQ.fZC, "MicroMsg.FreeWifi.ProtocolThreeOne");
                } else if (responseCode == 302) {
                    h.a(this.fZQ, httpURLConnection.getHeaderField("Location"));
                } else {
                    v.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.s(this.fZQ.intent), Integer.valueOf(m.t(this.fZQ.intent))});
                    FreeWifiFrontPageUI freeWifiFrontPageUI = this.fZQ.fZC;
                    d dVar = d.FAIL;
                    a aVar = new a();
                    aVar.gbN = m.a(this.fZQ.fZE, b.ThreeOneAuth, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    this.fZQ.N(32, "INVALID_HTTP_RESP_CODE");
                }
            }

            public final void h(Exception exception) {
                v.e("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[]{m.s(this.fZQ.intent), Integer.valueOf(m.t(this.fZQ.intent)), exception.getMessage(), m.f(exception)});
                FreeWifiFrontPageUI freeWifiFrontPageUI = this.fZQ.fZC;
                d dVar = d.FAIL;
                a aVar = new a();
                aVar.gbN = m.a(this.fZQ.fZE, b.ThreeOneAuth, m.g(exception));
                freeWifiFrontPageUI.a(dVar, aVar);
                this.fZQ.N(m.g(exception), m.e(exception));
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aoH();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), anonymousClass2);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aoH();
        com.tencent.mm.plugin.freewifi.a.a.a(str, anonymousClass2);
    }

    public h(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        v.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, desc=Data retrieved. authUrlWithParams=%s", new Object[]{m.s(this.intent), Integer.valueOf(m.t(this.intent)), this.fZO});
    }

    public final void connect() {
        v.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.connect, desc=it starts connecting wifi by protocol 3.1. authUrlWithParams=%s", new Object[]{m.s(this.intent), Integer.valueOf(m.t(this.intent)), this.fZO});
        final String str = this.fZO;
        j.apm().aoU().post(new Runnable(this) {
            final /* synthetic */ h fZQ;

            public final void run() {
                v.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.s(this.fZQ.intent), Integer.valueOf(m.t(this.fZQ.intent)), str});
                com.tencent.mm.plugin.freewifi.a.a.aoH();
                com.tencent.mm.plugin.freewifi.a.a.a(str, new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                    final /* synthetic */ AnonymousClass1 fZR;

                    {
                        this.fZR = r1;
                    }

                    public final void c(HttpURLConnection httpURLConnection) {
                        int responseCode = httpURLConnection.getResponseCode();
                        v.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.s(this.fZR.fZQ.intent), Integer.valueOf(m.t(this.fZR.fZQ.intent)), Integer.valueOf(responseCode)});
                        if (responseCode == 200) {
                            this.fZR.fZQ.N(0, "");
                            m.a(this.fZR.fZQ.intent, this.fZR.fZQ.aYz, this.fZR.fZQ.fZE, this.fZR.fZQ.aPW, this.fZR.fZQ.fZC, "MicroMsg.FreeWifi.ProtocolThreeOne");
                        } else if (responseCode == 302) {
                            h.a(this.fZR.fZQ, httpURLConnection.getHeaderField("Location"));
                        } else {
                            v.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.s(this.fZR.fZQ.intent), Integer.valueOf(m.t(this.fZR.fZQ.intent))});
                            FreeWifiFrontPageUI freeWifiFrontPageUI = this.fZR.fZQ.fZC;
                            d dVar = d.FAIL;
                            a aVar = new a();
                            aVar.gbN = m.a(this.fZR.fZQ.fZE, b.ThreeOneAuth, 32);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            this.fZR.fZQ.N(32, "INVALID_HTTP_RESP_CODE");
                        }
                    }

                    public final void h(Exception exception) {
                        v.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stackTrace=%s", new Object[]{m.s(this.fZR.fZQ.intent), Integer.valueOf(m.t(this.fZR.fZQ.intent)), exception.getMessage(), m.f(exception)});
                        FreeWifiFrontPageUI freeWifiFrontPageUI = this.fZR.fZQ.fZC;
                        d dVar = d.FAIL;
                        a aVar = new a();
                        aVar.gbN = m.a(this.fZR.fZQ.fZE, b.ThreeOneAuth, m.g(exception));
                        freeWifiFrontPageUI.a(dVar, aVar);
                        this.fZR.fZQ.N(m.g(exception), m.e(exception));
                    }
                });
            }
        });
    }

    private void N(int i, String str) {
        boolean z;
        k.a aoy = k.aoy();
        aoy.ssid = this.ssid;
        aoy.bssid = m.tC("MicroMsg.FreeWifi.ProtocolThreeOne");
        aoy.aYA = m.tD("MicroMsg.FreeWifi.ProtocolThreeOne");
        aoy.aYz = this.aYz;
        aoy.fWZ = this.appId;
        aoy.fXa = m.s(this.intent);
        aoy.fXb = 31;
        aoy.fXc = b.ThreeOneAuth.fXM;
        aoy.fXd = b.ThreeOneAuth.name;
        aoy.bpc = i;
        aoy.eOP = str;
        aoy.bkh = m.v(this.intent);
        k aoA = aoy.aoA();
        Intent intent = this.intent;
        if (i != 0) {
            z = true;
        } else {
            z = false;
        }
        aoA.b(intent, z).aoz();
    }
}
