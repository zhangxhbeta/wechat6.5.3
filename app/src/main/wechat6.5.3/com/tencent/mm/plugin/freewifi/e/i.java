package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import java.net.HttpURLConnection;

public final class i extends e implements a {
    private int fZP;
    protected String fZS;
    protected String fZT;
    protected String fZU;
    protected String fZV;
    protected String fZW;
    private Uri fZX;
    private String fZY;

    static /* synthetic */ void a(i iVar, String str) {
        iVar.fZP++;
        if (iVar.fZP > 3) {
            v.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.s(iVar.intent), Integer.valueOf(m.t(iVar.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = iVar.fZC;
            d dVar = d.FAIL;
            a aVar = new a();
            aVar.gbN = m.a(iVar.fZE, b.ThreeThreeAuth, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            return;
        }
        v.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.s(iVar.intent), Integer.valueOf(m.t(iVar.intent)), str});
        if (m.ty(str)) {
            freeWifiFrontPageUI = iVar.fZC;
            dVar = d.FAIL;
            aVar = new a();
            aVar.gbN = m.a(iVar.fZE, b.ThreeThreeAuth, 34);
            freeWifiFrontPageUI.a(dVar, aVar);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a anonymousClass2 = new com.tencent.mm.plugin.freewifi.a.a.a(iVar) {
            final /* synthetic */ i fZZ;

            {
                this.fZZ = r1;
            }

            public final void c(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                v.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.s(this.fZZ.intent), Integer.valueOf(m.t(this.fZZ.intent)), Integer.valueOf(responseCode)});
                if (responseCode == 200) {
                    this.fZZ.apJ();
                } else if (responseCode == 302) {
                    i.a(this.fZZ, httpURLConnection.getHeaderField("Location"));
                } else {
                    v.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.s(this.fZZ.intent), Integer.valueOf(m.t(this.fZZ.intent))});
                    FreeWifiFrontPageUI freeWifiFrontPageUI = this.fZZ.fZC;
                    d dVar = d.FAIL;
                    a aVar = new a();
                    aVar.gbN = m.a(this.fZZ.fZE, b.ThreeThreeAuth, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                }
            }

            public final void h(Exception exception) {
                v.e("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[]{m.s(this.fZZ.intent), Integer.valueOf(m.t(this.fZZ.intent)), exception.getMessage(), m.f(exception)});
                FreeWifiFrontPageUI freeWifiFrontPageUI = this.fZZ.fZC;
                d dVar = d.FAIL;
                a aVar = new a();
                aVar.gbN = m.a(this.fZZ.fZE, b.ThreeThreeAuth, m.g(exception));
                freeWifiFrontPageUI.a(dVar, aVar);
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

    public i(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        this.fZP = 0;
        this.fZY = this.intent.getStringExtra("free_wifi_schema_uri");
        this.fZX = Uri.parse(this.fZY);
        this.appId = this.fZX.getQueryParameter("appId");
        this.fZS = this.fZX.getQueryParameter("shopId");
        this.fZT = this.fZX.getQueryParameter("authUrl");
        this.fZU = this.fZX.getQueryParameter("extend");
        this.fZV = this.fZX.getQueryParameter("timestamp");
        this.fZW = this.fZX.getQueryParameter("sign");
        v.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=Data retrieved. schemaUri=%s, appid=%s, shopId=%s, authUrl=%s, extend=%s, timestamp=%s, sign=%s", new Object[]{m.s(this.intent), Integer.valueOf(m.t(this.intent)), this.fZX, this.appId, this.fZS, this.fZT, this.fZU, this.fZV, this.fZW});
    }

    public final void connect() {
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        a aVar;
        if (m.ty(this.ssid)) {
            v.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[]{m.s(this.intent), Integer.valueOf(m.t(this.intent))});
            freeWifiFrontPageUI = this.fZC;
            dVar = d.FAIL;
            aVar = new a();
            aVar.gbN = m.a(this.fZE, b.ThreeThreeAuth, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
        } else if (m.ty(this.fZT)) {
            v.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[]{m.s(this.intent), Integer.valueOf(m.t(this.intent))});
            freeWifiFrontPageUI = this.fZC;
            dVar = d.FAIL;
            aVar = new a();
            aVar.gbN = m.a(this.fZE, b.ThreeThreeAuth, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
        } else {
            StringBuilder stringBuilder = new StringBuilder(this.fZT);
            if (this.fZT.indexOf("?") == -1) {
                stringBuilder.append("?extend=").append(this.fZU);
            } else {
                stringBuilder.append("&extend=").append(this.fZU);
            }
            final String stringBuilder2 = stringBuilder.toString();
            j.apm().aoU().post(new Runnable(this) {
                final /* synthetic */ i fZZ;

                public final void run() {
                    v.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.s(this.fZZ.intent), Integer.valueOf(m.t(this.fZZ.intent)), stringBuilder2});
                    com.tencent.mm.plugin.freewifi.a.a.aoH();
                    com.tencent.mm.plugin.freewifi.a.a.a(stringBuilder2, new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                        final /* synthetic */ AnonymousClass1 gaa;

                        {
                            this.gaa = r1;
                        }

                        public final void c(HttpURLConnection httpURLConnection) {
                            int responseCode = httpURLConnection.getResponseCode();
                            v.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.s(this.gaa.fZZ.intent), Integer.valueOf(m.t(this.gaa.fZZ.intent)), Integer.valueOf(responseCode)});
                            if (responseCode == 200) {
                                this.gaa.fZZ.apJ();
                            } else if (responseCode == 302) {
                                i.a(this.gaa.fZZ, httpURLConnection.getHeaderField("Location"));
                            } else {
                                v.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.s(this.gaa.fZZ.intent), Integer.valueOf(m.t(this.gaa.fZZ.intent))});
                                FreeWifiFrontPageUI freeWifiFrontPageUI = this.gaa.fZZ.fZC;
                                d dVar = d.FAIL;
                                a aVar = new a();
                                aVar.gbN = m.a(this.gaa.fZZ.fZE, b.ThreeThreeAuth, 32);
                                freeWifiFrontPageUI.a(dVar, aVar);
                            }
                        }

                        public final void h(Exception exception) {
                            v.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[]{m.s(this.gaa.fZZ.intent), Integer.valueOf(m.t(this.gaa.fZZ.intent)), exception.getMessage(), m.f(exception)});
                            FreeWifiFrontPageUI freeWifiFrontPageUI = this.gaa.fZZ.fZC;
                            d dVar = d.FAIL;
                            a aVar = new a();
                            aVar.gbN = m.a(this.gaa.fZZ.fZE, b.ThreeThreeAuth, m.g(exception));
                            freeWifiFrontPageUI.a(dVar, aVar);
                        }
                    });
                }
            });
        }
    }

    protected final void apJ() {
        j.apm().aoU().post(new Runnable(this) {
            final /* synthetic */ i fZZ;

            {
                this.fZZ = r1;
            }

            public final void run() {
                k.a aoy = k.aoy();
                aoy.ssid = this.fZZ.ssid;
                aoy.bssid = m.tC("MicroMsg.FreeWifi.Protocol33");
                aoy.aYA = m.tD("MicroMsg.FreeWifi.Protocol33");
                aoy.aYz = this.fZZ.aYz;
                aoy.fXa = m.s(this.fZZ.intent);
                aoy.fXb = this.fZZ.fZE;
                aoy.fXc = b.GetBackPage33.fXM;
                aoy.fXd = b.GetBackPage33.name;
                aoy.bkh = m.v(this.fZZ.intent);
                aoy.bpc = 0;
                aoy.aoA().aoz();
                String aoW = com.tencent.mm.plugin.freewifi.model.d.aoW();
                String aoY = com.tencent.mm.plugin.freewifi.model.d.aoY();
                int aoX = com.tencent.mm.plugin.freewifi.model.d.aoX();
                v.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.s(this.fZZ.intent), Integer.valueOf(m.t(this.fZZ.intent)), "", aoW, aoY, Integer.valueOf(aoX)});
                new f(this.fZZ.ssid, m.tC("MicroMsg.FreeWifi.Protocol33"), this.fZZ.appId, this.fZZ.fZS, this.fZZ.fZT, this.fZZ.fZU, this.fZZ.fZV, this.fZZ.fZW).b(new e(this) {
                    final /* synthetic */ AnonymousClass3 gab;

                    {
                        this.gab = r1;
                    }

                    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                        v.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.s(this.gab.fZZ.intent), Integer.valueOf(m.t(this.gab.fZZ.intent)), Integer.valueOf(i), Integer.valueOf(i2), str});
                        k.a aoy = k.aoy();
                        aoy.ssid = this.gab.fZZ.ssid;
                        aoy.bssid = m.tC("MicroMsg.FreeWifi.Protocol33");
                        aoy.aYA = m.tD("MicroMsg.FreeWifi.Protocol33");
                        aoy.aYz = this.gab.fZZ.aYz;
                        aoy.fXa = m.s(this.gab.fZZ.intent);
                        aoy.fXb = m.u(this.gab.fZZ.intent);
                        aoy.fXc = b.GetBackPage33Return.fXM;
                        aoy.fXd = b.GetBackPage33Return.name;
                        aoy.bkh = m.v(this.gab.fZZ.intent);
                        aoy.bpc = i2;
                        aoy.eOP = str;
                        aoy.aoA().aoz();
                        FreeWifiFrontPageUI freeWifiFrontPageUI;
                        d dVar;
                        a aVar;
                        if (i == 0 && i2 == 0) {
                            dq apx = ((f) kVar).apx();
                            if (apx != null) {
                                v.i("MicroMsg.FreeWifi.Protocol33", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{apx.mbH, apx.efy, apx.gln, Integer.valueOf(apx.mex), apx.mey, apx.cHf, apx.mez});
                                FreeWifiFrontPageUI freeWifiFrontPageUI2 = this.gab.fZZ.fZC;
                                d dVar2 = d.SUCCESS;
                                FreeWifiFrontPageUI.b bVar = new FreeWifiFrontPageUI.b();
                                bVar.gbO = apx;
                                freeWifiFrontPageUI2.a(dVar2, bVar);
                                return;
                            }
                            freeWifiFrontPageUI = this.gab.fZZ.fZC;
                            dVar = d.FAIL;
                            aVar = new a();
                            aVar.gbN = m.a(this.gab.fZZ.fZE, b.GetBackPage33Return, 20);
                            freeWifiFrontPageUI.a(dVar, aVar);
                        } else if (i2 == -30032) {
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_error_ui_error_msg", this.gab.fZZ.fZC.getString(2131232952));
                            intent.setClass(this.gab.fZZ.fZC, FreeWifiErrorUI.class);
                            this.gab.fZZ.fZC.finish();
                            this.gab.fZZ.fZC.startActivity(intent);
                        } else {
                            freeWifiFrontPageUI = this.gab.fZZ.fZC;
                            dVar = d.FAIL;
                            aVar = new a();
                            aVar.gbM = 2131232948;
                            aVar.gbN = m.a(this.gab.fZZ.fZE, b.GetBackPage33Return, i2);
                            freeWifiFrontPageUI.a(dVar, aVar);
                        }
                    }
                });
            }
        });
    }
}
