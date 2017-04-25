package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.v;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

public final class j extends e implements a {
    String bfm = this.intent.getStringExtra("free_wifi_openid");
    private a fZJ;
    private int fZP = 0;
    String fZV = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    String fZW = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
    String gac = this.intent.getStringExtra("free_wifi_tid");

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ j gad;
        final /* synthetic */ String val$url;

        AnonymousClass3(j jVar, String str) {
            this.gad = jVar;
            this.val$url = str;
        }

        public final void run() {
            v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.s(this.gad.intent), Integer.valueOf(m.t(this.gad.intent)), this.val$url});
            com.tencent.mm.plugin.freewifi.a.a.aoH();
            com.tencent.mm.plugin.freewifi.a.a.a(this.val$url, new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                final /* synthetic */ AnonymousClass3 gal;

                {
                    this.gal = r1;
                }

                public final void c(HttpURLConnection httpURLConnection) {
                    int responseCode = httpURLConnection.getResponseCode();
                    v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.s(this.gal.gad.intent), Integer.valueOf(m.t(this.gal.gad.intent)), Integer.valueOf(responseCode)});
                    if (responseCode == 200) {
                        this.gal.gad.O(0, "");
                        m.a(this.gal.gad.intent, this.gal.gad.aYz, this.gal.gad.fZE, this.gal.gad.aPW, this.gal.gad.fZC, "MicroMsg.FreeWifi.Protocol32");
                    } else if (responseCode == 302) {
                        j.a(this.gal.gad, httpURLConnection.getHeaderField("Location"));
                    } else {
                        v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", new Object[]{m.s(this.gal.gad.intent), Integer.valueOf(m.t(this.gal.gad.intent))});
                        FreeWifiFrontPageUI freeWifiFrontPageUI = this.gal.gad.fZC;
                        d dVar = d.FAIL;
                        FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                        aVar.gbN = m.a(this.gal.gad.fZE, b.ThreeTwoAuth, 32);
                        freeWifiFrontPageUI.a(dVar, aVar);
                        this.gal.gad.O(32, "INVALID_HTTP_RESP_CODE");
                    }
                }

                public final void h(Exception exception) {
                    v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[]{m.s(this.gal.gad.intent), Integer.valueOf(m.t(this.gal.gad.intent)), exception.getMessage(), m.f(exception)});
                    FreeWifiFrontPageUI freeWifiFrontPageUI = this.gal.gad.fZC;
                    d dVar = d.FAIL;
                    FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                    aVar.gbN = m.a(this.gal.gad.fZE, b.ThreeTwoAuth, m.g(exception));
                    freeWifiFrontPageUI.a(dVar, aVar);
                    this.gal.gad.O(m.g(exception), m.e(exception));
                }
            });
        }
    }

    static /* synthetic */ void a(j jVar) {
        v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connectSsid, desc=it starts to connect ssid. ssid=%s", new Object[]{m.s(jVar.intent), Integer.valueOf(m.t(jVar.intent)), jVar.ssid});
        jVar.fZJ.a(new a.a(jVar) {
            final /* synthetic */ j gad;

            {
                this.gad = r1;
            }

            public final void onSuccess() {
                k.a aoy = k.aoy();
                aoy.ssid = this.gad.ssid;
                aoy.bssid = m.tC("MicroMsg.FreeWifi.Protocol32");
                aoy.aYA = m.tD("MicroMsg.FreeWifi.Protocol32");
                aoy.aYz = this.gad.aYz;
                aoy.fWZ = this.gad.appId;
                aoy.fXa = m.s(this.gad.intent);
                aoy.fXb = m.u(this.gad.intent);
                aoy.fXc = b.AddNetwork.fXM;
                aoy.fXd = b.AddNetwork.name;
                aoy.bpc = 0;
                aoy.bkh = m.v(this.gad.intent);
                aoy.aoA().aoz();
                final String aov = b.fWU.aov();
                v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", new Object[]{m.s(this.gad.intent), Integer.valueOf(m.t(this.gad.intent)), this.gad.ssid, aov});
                com.tencent.mm.plugin.freewifi.a.a.a anonymousClass1 = new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                    int gae = 0;
                    private final int gaf = 3;
                    private int gag = 0;
                    private com.tencent.mm.plugin.freewifi.a.a.a gah = new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                        final /* synthetic */ AnonymousClass1 gak;

                        {
                            this.gak = r1;
                        }

                        public final void c(HttpURLConnection httpURLConnection) {
                            int responseCode = httpURLConnection.getResponseCode();
                            FreeWifiFrontPageUI freeWifiFrontPageUI;
                            d dVar;
                            FreeWifiFrontPageUI.a aVar;
                            if (responseCode == 200) {
                                v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", new Object[]{m.s(this.gak.gaj.gad.intent), Integer.valueOf(m.t(this.gak.gaj.gad.intent))});
                                freeWifiFrontPageUI = this.gak.gaj.gad.fZC;
                                dVar = d.FAIL;
                                aVar = new FreeWifiFrontPageUI.a();
                                aVar.gbN = m.a(this.gak.gaj.gad.fZE, b.ThreeTwoBlack, 35);
                                freeWifiFrontPageUI.a(dVar, aVar);
                                this.gak.gaj.gad.O(35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
                            } else if (responseCode == 302) {
                                this.gak.tM(httpURLConnection.getHeaderField("Location"));
                            } else {
                                v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.s(this.gak.gaj.gad.intent), Integer.valueOf(m.t(this.gak.gaj.gad.intent))});
                                freeWifiFrontPageUI = this.gak.gaj.gad.fZC;
                                dVar = d.FAIL;
                                aVar = new FreeWifiFrontPageUI.a();
                                aVar.gbN = m.a(this.gak.gaj.gad.fZE, b.ThreeTwoBlack, 32);
                                freeWifiFrontPageUI.a(dVar, aVar);
                                this.gak.gaj.gad.O(32, "INVALID_HTTP_RESP_CODE");
                            }
                        }

                        public final void h(Exception exception) {
                            v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s,stacktrace=%s", new Object[]{m.s(this.gak.gaj.gad.intent), Integer.valueOf(m.t(this.gak.gaj.gad.intent)), exception.getMessage(), m.f(exception)});
                            FreeWifiFrontPageUI freeWifiFrontPageUI = this.gak.gaj.gad.fZC;
                            d dVar = d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.gbN = m.a(this.gak.gaj.gad.fZE, b.ThreeTwoBlack, m.g(exception));
                            freeWifiFrontPageUI.a(dVar, aVar);
                            this.gak.gaj.gad.O(m.g(exception), m.e(exception));
                        }
                    };
                    final /* synthetic */ AnonymousClass2 gaj;

                    public final void c(HttpURLConnection httpURLConnection) {
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", new Object[]{m.s(this.gaj.gad.intent), Integer.valueOf(m.t(this.gaj.gad.intent))});
                            this.gaj.gad.O(0, "");
                            m.a(this.gaj.gad.intent, this.gaj.gad.aYz, this.gaj.gad.fZE, this.gaj.gad.aPW, this.gaj.gad.fZC, "MicroMsg.FreeWifi.Protocol32");
                        } else if (responseCode == 302) {
                            tM(httpURLConnection.getHeaderField("Location"));
                        } else {
                            v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.s(this.gaj.gad.intent), Integer.valueOf(m.t(this.gaj.gad.intent))});
                            FreeWifiFrontPageUI freeWifiFrontPageUI = this.gaj.gad.fZC;
                            d dVar = d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.gbN = m.a(this.gaj.gad.fZE, b.ThreeTwoBlack, 32);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            j.b(this.gaj.gad, 32, "INVALID_HTTP_RESP_CODE");
                        }
                    }

                    public final void h(Exception exception) {
                        FreeWifiFrontPageUI freeWifiFrontPageUI;
                        d dVar;
                        FreeWifiFrontPageUI.a aVar;
                        v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", new Object[]{m.s(this.gaj.gad.intent), Integer.valueOf(m.t(this.gaj.gad.intent)), exception.getMessage(), m.f(exception)});
                        if (exception instanceof UnknownHostException) {
                            j.b(this.gaj.gad, 102, m.e(exception));
                            v.i("MicroMsg.FreeWifi.Protocol32", "countBlackHttpRequest=" + this.gae);
                            int i = this.gae + 1;
                            this.gae = i;
                            if (i <= 3) {
                                try {
                                    Thread.sleep(3000);
                                    com.tencent.mm.plugin.freewifi.a.a.aoH();
                                    com.tencent.mm.plugin.freewifi.a.a.a(aov, this);
                                    return;
                                } catch (InterruptedException e) {
                                    v.e("MicroMsg.FreeWifi.Protocol32", "InterruptedException e stacktrace=%s", new Object[]{m.f(exception)});
                                    j.b(this.gaj.gad, 103, m.e(exception));
                                    freeWifiFrontPageUI = this.gaj.gad.fZC;
                                    dVar = d.FAIL;
                                    aVar = new FreeWifiFrontPageUI.a();
                                    aVar.gbN = m.a(this.gaj.gad.fZE, b.ThreeTwoBlack, 103);
                                    freeWifiFrontPageUI.a(dVar, aVar);
                                    return;
                                }
                            }
                            freeWifiFrontPageUI = this.gaj.gad.fZC;
                            dVar = d.FAIL;
                            aVar = new FreeWifiFrontPageUI.a();
                            aVar.gbN = m.a(this.gaj.gad.fZE, b.ThreeTwoBlack, m.g(exception));
                            freeWifiFrontPageUI.a(dVar, aVar);
                            j.b(this.gaj.gad, m.g(exception), m.e(exception));
                            return;
                        }
                        freeWifiFrontPageUI = this.gaj.gad.fZC;
                        dVar = d.FAIL;
                        aVar = new FreeWifiFrontPageUI.a();
                        aVar.gbN = m.a(this.gaj.gad.fZE, b.ThreeTwoBlack, m.g(exception));
                        freeWifiFrontPageUI.a(dVar, aVar);
                        j.b(this.gaj.gad, m.g(exception), m.e(exception));
                    }

                    private void tM(String str) {
                        Uri parse = Uri.parse(str);
                        String queryParameter = parse.getQueryParameter("authUrl");
                        String tA = m.tA(parse.getQueryParameter("extend"));
                        v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", new Object[]{m.s(this.gaj.gad.intent), Integer.valueOf(m.t(this.gaj.gad.intent)), str, queryParameter, tA});
                        if (m.ty(queryParameter)) {
                            this.gag++;
                            if (this.gag < 3) {
                                com.tencent.mm.plugin.freewifi.a.a.aoH();
                                com.tencent.mm.plugin.freewifi.a.a.a(str, this.gah);
                                return;
                            }
                            v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.s(this.gaj.gad.intent), Integer.valueOf(m.t(this.gaj.gad.intent))});
                            FreeWifiFrontPageUI freeWifiFrontPageUI = this.gaj.gad.fZC;
                            d dVar = d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.gbN = m.a(this.gaj.gad.fZE, b.ThreeTwoBlack, 36);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            this.gaj.gad.O(36, "BLACK_302_TIMES_EXCESS");
                            return;
                        }
                        StringBuilder stringBuilder = new StringBuilder(queryParameter);
                        if (queryParameter.indexOf("?") != -1) {
                            stringBuilder.append("&extend=").append(tA);
                        } else {
                            stringBuilder.append("?extend=").append(tA);
                        }
                        stringBuilder.append("&openId=").append(m.tA(this.gaj.gad.bfm)).append("&tid=").append(m.tA(this.gaj.gad.gac)).append("&timestamp=").append(this.gaj.gad.fZV).append("&sign=").append(this.gaj.gad.fZW);
                        com.tencent.mm.plugin.freewifi.model.j.apm().aoU().post(new AnonymousClass3(this.gaj.gad, stringBuilder.toString()));
                        v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. http authentication url = %s", new Object[]{m.s(this.gaj.gad.intent), Integer.valueOf(m.t(this.gaj.gad.intent)), stringBuilder.toString()});
                    }
                };
                com.tencent.mm.plugin.freewifi.a.a.aoH();
                com.tencent.mm.plugin.freewifi.a.a.a(aov, anonymousClass1);
            }

            public final void kR(int i) {
                v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[]{m.s(this.gad.intent), Integer.valueOf(m.t(this.gad.intent)), this.gad.ssid, Integer.valueOf(i)});
                FreeWifiFrontPageUI freeWifiFrontPageUI = this.gad.fZC;
                d dVar = d.FAIL;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.gbN = m.a(this.gad.fZE, b.AddNetwork, i);
                freeWifiFrontPageUI.a(dVar, aVar);
                k.a aoy = k.aoy();
                aoy.ssid = this.gad.ssid;
                aoy.bssid = m.tC("MicroMsg.FreeWifi.Protocol32");
                aoy.aYA = m.tD("MicroMsg.FreeWifi.Protocol32");
                aoy.aYz = this.gad.aYz;
                aoy.fWZ = this.gad.appId;
                aoy.fXa = m.s(this.gad.intent);
                aoy.fXb = m.u(this.gad.intent);
                aoy.fXd = b.AddNetwork.name;
                aoy.fXc = b.AddNetwork.fXM;
                aoy.bpc = i;
                aoy.bkh = m.v(this.gad.intent);
                aoy.aoA().aoz();
            }
        });
    }

    static /* synthetic */ void a(j jVar, String str) {
        jVar.fZP++;
        if (jVar.fZP > 3) {
            v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.s(jVar.intent), Integer.valueOf(m.t(jVar.intent))});
            FreeWifiFrontPageUI freeWifiFrontPageUI = jVar.fZC;
            d dVar = d.FAIL;
            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
            aVar.gbN = m.a(jVar.fZE, b.ThreeTwoAuth, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            jVar.O(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.s(jVar.intent), Integer.valueOf(m.t(jVar.intent)), str});
        if (m.ty(str)) {
            freeWifiFrontPageUI = jVar.fZC;
            dVar = d.FAIL;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.gbN = m.a(jVar.fZE, b.ThreeTwoAuth, 34);
            freeWifiFrontPageUI.a(dVar, aVar);
            jVar.O(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.a anonymousClass4 = new com.tencent.mm.plugin.freewifi.a.a.a(jVar) {
            final /* synthetic */ j gad;

            {
                this.gad = r1;
            }

            public final void c(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.s(this.gad.intent), Integer.valueOf(m.t(this.gad.intent)), Integer.valueOf(responseCode)});
                if (responseCode == 200) {
                    this.gad.O(0, "");
                    m.a(this.gad.intent, this.gad.aYz, this.gad.fZE, this.gad.aPW, this.gad.fZC, "MicroMsg.FreeWifi.Protocol32");
                } else if (responseCode == 302) {
                    j.a(this.gad, httpURLConnection.getHeaderField("Location"));
                } else {
                    v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.s(this.gad.intent), Integer.valueOf(m.t(this.gad.intent))});
                    FreeWifiFrontPageUI freeWifiFrontPageUI = this.gad.fZC;
                    d dVar = d.FAIL;
                    FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                    aVar.gbN = m.a(this.gad.fZE, b.ThreeTwoAuth, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    this.gad.O(32, "INVALID_HTTP_RESP_CODE");
                }
            }

            public final void h(Exception exception) {
                v.e("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", new Object[]{m.s(this.gad.intent), Integer.valueOf(m.t(this.gad.intent)), exception.getMessage(), m.f(exception)});
                FreeWifiFrontPageUI freeWifiFrontPageUI = this.gad.fZC;
                d dVar = d.FAIL;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.gbN = m.a(this.gad.fZE, b.ThreeTwoAuth, m.g(exception));
                freeWifiFrontPageUI.a(dVar, aVar);
                this.gad.O(m.g(exception), m.e(exception));
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aoH();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), anonymousClass4);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aoH();
        com.tencent.mm.plugin.freewifi.a.a.a(str, anonymousClass4);
    }

    static /* synthetic */ void b(j jVar, int i, String str) {
        k.a aoy = k.aoy();
        aoy.ssid = jVar.ssid;
        aoy.bssid = m.tC("MicroMsg.FreeWifi.Protocol32");
        aoy.aYA = m.tD("MicroMsg.FreeWifi.Protocol32");
        aoy.aYz = jVar.aYz;
        aoy.fWZ = jVar.appId;
        aoy.fXa = m.s(jVar.intent);
        aoy.fXb = 32;
        aoy.fXc = b.ThreeTwoAuth.fXM;
        aoy.fXd = b.ThreeTwoAuth.name;
        aoy.bpc = i;
        aoy.eOP = str;
        aoy.bkh = m.v(jVar.intent);
        aoy.aoA().aoz();
    }

    public j(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        v.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. openId=%s, tid=%s, timestamp=%s, sign=%s", new Object[]{m.s(this.intent), Integer.valueOf(m.t(this.intent)), this.bfm, this.gac, this.fZV, this.fZW});
    }

    public final void connect() {
        this.fZJ = new a(this.ssid, this.fZC);
        com.tencent.mm.plugin.freewifi.model.j.apm().aoU().post(new Runnable(this) {
            final /* synthetic */ j gad;

            {
                this.gad = r1;
            }

            public final void run() {
                j.a(this.gad);
            }
        });
    }

    private void O(int i, String str) {
        k.a aoy = k.aoy();
        aoy.ssid = this.ssid;
        aoy.bssid = m.tC("MicroMsg.FreeWifi.Protocol32");
        aoy.aYA = m.tD("MicroMsg.FreeWifi.Protocol32");
        aoy.aYz = this.aYz;
        aoy.fWZ = this.appId;
        aoy.fXa = m.s(this.intent);
        aoy.fXb = 32;
        aoy.fXc = b.ThreeTwoAuth.fXM;
        aoy.fXd = b.ThreeTwoAuth.name;
        aoy.bpc = i;
        aoy.eOP = str;
        aoy.bkh = m.v(this.intent);
        aoy.aoA().aoz();
    }
}
