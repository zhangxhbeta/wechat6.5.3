package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

@Deprecated
public class ProtocolThreeTwoUI extends MMActivity {
    protected int aPW;
    private String aYz;
    protected String bCj;
    private int baO = 1;
    protected int bbT;
    private String bfm;
    protected String bmJ;
    private final c cPf;
    protected String fZD;
    protected String fZF;
    private a fZJ;
    private int fZP = 0;
    private String fZV;
    private String fZW;
    protected String gaW;
    private String gac;
    protected String gbB;
    protected String gbC;
    protected String gbD;
    protected String gbE;
    private g.a gbc;
    private ImageView gbr;
    private TextView gbs;
    private TextView gbt;
    private TextView gbu;
    private Button gbx;
    private Button gby;
    protected String gcD;
    protected int gcE;
    protected String gcF;
    protected String gcG;
    private p gcy;
    private ah gdb = new ah(new ah.a(this) {
        final /* synthetic */ ProtocolThreeTwoUI gdi;

        {
            this.gdi = r1;
        }

        public final boolean oU() {
            if (!be.kS(this.gdi.ssid)) {
                this.gdi.baO = this.gdi.apP();
                if (this.gdi.baO != 2) {
                    v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[]{m.s(this.gdi.getIntent()), Integer.valueOf(m.t(this.gdi.getIntent())), d.kX(this.gdi.baO)});
                    d.a(this.gdi.ssid, 3, this.gdi.getIntent());
                    this.gdi.N(33, "AUTH_302_TIMES_EXCESS");
                }
            }
            return false;
        }
    }, false);
    private Intent intent;
    protected String ssid;

    public ProtocolThreeTwoUI() {
        c.a aVar = new c.a();
        aVar.cPq = true;
        aVar.cPr = true;
        aVar.cPH = 2130838251;
        aVar.cPP = true;
        aVar.cPQ = 0.0f;
        this.cPf = aVar.GU();
    }

    static /* synthetic */ void b(ProtocolThreeTwoUI protocolThreeTwoUI, String str) {
        protocolThreeTwoUI.fZP++;
        if (protocolThreeTwoUI.fZP > 3) {
            v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.s(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.t(protocolThreeTwoUI.getIntent()))});
            d.a(protocolThreeTwoUI.ssid, 3, protocolThreeTwoUI.getIntent());
            protocolThreeTwoUI.N(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.s(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.t(protocolThreeTwoUI.getIntent())), str});
        if (m.ty(str)) {
            d.a(protocolThreeTwoUI.ssid, 3, protocolThreeTwoUI.getIntent());
            protocolThreeTwoUI.N(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        AnonymousClass11 anonymousClass11 = new com.tencent.mm.plugin.freewifi.a.a.a(protocolThreeTwoUI) {
            final /* synthetic */ ProtocolThreeTwoUI gdi;

            {
                this.gdi = r1;
            }

            public final void c(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.s(this.gdi.getIntent()), Integer.valueOf(m.t(this.gdi.getIntent())), Integer.valueOf(responseCode)});
                if (responseCode == 200) {
                    ProtocolThreeTwoUI.f(this.gdi);
                } else if (responseCode == 302) {
                    ProtocolThreeTwoUI.b(this.gdi, httpURLConnection.getHeaderField("Location"));
                } else {
                    v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.s(this.gdi.getIntent()), Integer.valueOf(m.t(this.gdi.getIntent()))});
                    d.a(this.gdi.ssid, 3, this.gdi.getIntent());
                    this.gdi.N(32, "INVALID_HTTP_RESP_CODE");
                }
            }

            public final void h(Exception exception) {
                v.e("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", new Object[]{m.s(this.gdi.getIntent()), Integer.valueOf(m.t(this.gdi.getIntent())), exception.getMessage()});
                this.gdi.N(101, m.e(exception));
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aoH();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), anonymousClass11);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aoH();
        com.tencent.mm.plugin.freewifi.a.a.a(str, anonymousClass11);
    }

    static /* synthetic */ void c(ProtocolThreeTwoUI protocolThreeTwoUI) {
        v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connectSsid, desc=it starts to connect ssid. ssid=%s", new Object[]{m.s(protocolThreeTwoUI.getIntent()), Integer.valueOf(m.t(protocolThreeTwoUI.getIntent())), protocolThreeTwoUI.ssid});
        protocolThreeTwoUI.fZJ.a(new a.a(protocolThreeTwoUI) {
            final /* synthetic */ ProtocolThreeTwoUI gdi;

            {
                this.gdi = r1;
            }

            public final void onSuccess() {
                k.a aoy = k.aoy();
                aoy.ssid = this.gdi.ssid;
                aoy.bssid = m.tC("MicroMsg.FreeWifi.Protocol32UI");
                aoy.aYA = m.tD("MicroMsg.FreeWifi.Protocol32UI");
                aoy.aYz = this.gdi.aYz;
                aoy.fWZ = this.gdi.bmJ;
                aoy.fXa = m.s(this.gdi.intent);
                aoy.fXb = m.u(this.gdi.intent);
                aoy.fXc = b.fXn.fXM;
                aoy.fXd = b.fXn.name;
                aoy.bpc = 0;
                aoy.bkh = m.v(this.gdi.intent);
                aoy.fXe = this.gdi.gcD;
                aoy.aoA().aoz();
                final String aov = h.b.aow().aov();
                v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", new Object[]{m.s(this.gdi.getIntent()), Integer.valueOf(m.t(this.gdi.getIntent())), this.gdi.ssid, aov});
                AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                    int gae = 0;
                    private final int gaf = 3;
                    private int gag = 0;
                    private com.tencent.mm.plugin.freewifi.a.a.a gah = new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                        final /* synthetic */ AnonymousClass1 gdl;

                        {
                            this.gdl = r1;
                        }

                        public final void c(HttpURLConnection httpURLConnection) {
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode == 200) {
                                v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", new Object[]{m.s(this.gdl.gdk.gdi.getIntent()), Integer.valueOf(m.t(this.gdl.gdk.gdi.getIntent()))});
                                d.a(this.gdl.gdk.gdi.ssid, 3, this.gdl.gdk.gdi.getIntent());
                                this.gdl.gdk.gdi.N(35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
                            } else if (responseCode == 302) {
                                this.gdl.tM(httpURLConnection.getHeaderField("Location"));
                            } else {
                                v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.s(this.gdl.gdk.gdi.getIntent()), Integer.valueOf(m.t(this.gdl.gdk.gdi.getIntent()))});
                                d.a(this.gdl.gdk.gdi.ssid, 3, this.gdl.gdk.gdi.getIntent());
                                this.gdl.gdk.gdi.N(32, "INVALID_HTTP_RESP_CODE");
                            }
                        }

                        public final void h(Exception exception) {
                            v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.s(this.gdl.gdk.gdi.getIntent()), Integer.valueOf(m.t(this.gdl.gdk.gdi.getIntent())), exception.getMessage()});
                            d.a(this.gdl.gdk.gdi.ssid, 3, this.gdl.gdk.gdi.getIntent());
                            this.gdl.gdk.gdi.N(101, m.e(exception));
                        }
                    };
                    final /* synthetic */ AnonymousClass9 gdk;

                    public final void c(HttpURLConnection httpURLConnection) {
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", new Object[]{m.s(this.gdk.gdi.getIntent()), Integer.valueOf(m.t(this.gdk.gdi.getIntent()))});
                            ProtocolThreeTwoUI.f(this.gdk.gdi);
                        } else if (responseCode == 302) {
                            tM(httpURLConnection.getHeaderField("Location"));
                        } else {
                            v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.s(this.gdk.gdi.getIntent()), Integer.valueOf(m.t(this.gdk.gdi.getIntent()))});
                            d.a(this.gdk.gdi.ssid, 3, this.gdk.gdi.getIntent());
                            this.gdk.gdi.N(32, "INVALID_HTTP_RESP_CODE");
                        }
                    }

                    public final void h(Exception exception) {
                        v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.s(this.gdk.gdi.getIntent()), Integer.valueOf(m.t(this.gdk.gdi.getIntent())), exception.getMessage()});
                        if (exception instanceof UnknownHostException) {
                            this.gdk.gdi.N(102, m.e(exception));
                            int i = this.gae + 1;
                            this.gae = i;
                            if (i <= 3) {
                                try {
                                    Thread.sleep(3000);
                                    com.tencent.mm.plugin.freewifi.a.a.aoH();
                                    com.tencent.mm.plugin.freewifi.a.a.a(aov, this);
                                    return;
                                } catch (InterruptedException e) {
                                    return;
                                }
                            }
                            d.a(this.gdk.gdi.ssid, 3, this.gdk.gdi.getIntent());
                            this.gdk.gdi.N(101, m.e(exception));
                            return;
                        }
                        d.a(this.gdk.gdi.ssid, 3, this.gdk.gdi.getIntent());
                        this.gdk.gdi.N(101, m.e(exception));
                    }

                    private void tM(String str) {
                        Uri parse = Uri.parse(str);
                        String queryParameter = parse.getQueryParameter("authUrl");
                        String tA = m.tA(parse.getQueryParameter("extend"));
                        v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", new Object[]{m.s(this.gdk.gdi.getIntent()), Integer.valueOf(m.t(this.gdk.gdi.getIntent())), str, queryParameter, tA});
                        if (m.ty(queryParameter)) {
                            this.gag++;
                            if (this.gag < 3) {
                                com.tencent.mm.plugin.freewifi.a.a.aoH();
                                com.tencent.mm.plugin.freewifi.a.a.a(str, this.gah);
                                return;
                            }
                            v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.s(this.gdk.gdi.getIntent()), Integer.valueOf(m.t(this.gdk.gdi.getIntent()))});
                            d.a(this.gdk.gdi.ssid, 3, this.gdk.gdi.getIntent());
                            this.gdk.gdi.N(36, "BLACK_302_TIMES_EXCESS");
                            return;
                        }
                        StringBuilder stringBuilder = new StringBuilder(queryParameter);
                        if (queryParameter.indexOf("?") != -1) {
                            stringBuilder.append("&extend=").append(tA);
                        } else {
                            stringBuilder.append("?extend=").append(tA);
                        }
                        stringBuilder.append("&openId=").append(m.tA(this.gdk.gdi.bfm)).append("&tid=").append(m.tA(this.gdk.gdi.gac)).append("&timestamp=").append(this.gdk.gdi.fZV).append("&sign=").append(this.gdk.gdi.fZW);
                        j.apm().aoU().post(new Runnable(this.gdk.gdi, stringBuilder.toString()) {
                            final /* synthetic */ ProtocolThreeTwoUI gdi;

                            public final void run() {
                                v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.s(this.gdi.getIntent()), Integer.valueOf(m.t(this.gdi.getIntent())), r3});
                                com.tencent.mm.plugin.freewifi.a.a.aoH();
                                com.tencent.mm.plugin.freewifi.a.a.a(r3, new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                                    final /* synthetic */ AnonymousClass10 gdm;

                                    {
                                        this.gdm = r1;
                                    }

                                    public final void c(HttpURLConnection httpURLConnection) {
                                        int responseCode = httpURLConnection.getResponseCode();
                                        v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.s(this.gdm.gdi.getIntent()), Integer.valueOf(m.t(this.gdm.gdi.getIntent())), Integer.valueOf(responseCode)});
                                        if (responseCode == 200) {
                                            ProtocolThreeTwoUI.f(this.gdm.gdi);
                                        } else if (responseCode == 302) {
                                            ProtocolThreeTwoUI.b(this.gdm.gdi, httpURLConnection.getHeaderField("Location"));
                                        } else {
                                            v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", new Object[]{m.s(this.gdm.gdi.getIntent()), Integer.valueOf(m.t(this.gdm.gdi.getIntent()))});
                                            d.a(this.gdm.gdi.ssid, 3, this.gdm.gdi.getIntent());
                                            this.gdm.gdi.N(32, "INVALID_HTTP_RESP_CODE");
                                        }
                                    }

                                    public final void h(Exception exception) {
                                        v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.s(this.gdm.gdi.getIntent()), Integer.valueOf(m.t(this.gdm.gdi.getIntent())), exception.getMessage()});
                                        d.a(this.gdm.gdi.ssid, 3, this.gdm.gdi.getIntent());
                                        this.gdm.gdi.N(101, m.e(exception));
                                    }
                                });
                            }
                        });
                    }
                };
                com.tencent.mm.plugin.freewifi.a.a.aoH();
                com.tencent.mm.plugin.freewifi.a.a.a(aov, anonymousClass1);
            }

            public final void kR(int i) {
                v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", new Object[]{m.s(this.gdi.getIntent()), Integer.valueOf(m.t(this.gdi.getIntent())), this.gdi.ssid, Integer.valueOf(i)});
                d.a(this.gdi.ssid, 3, this.gdi.getIntent());
                k.a aoy = k.aoy();
                aoy.ssid = this.gdi.ssid;
                aoy.bssid = m.tC("MicroMsg.FreeWifi.Protocol32UI");
                aoy.aYA = m.tD("MicroMsg.FreeWifi.Protocol32UI");
                aoy.aYz = this.gdi.aYz;
                aoy.fWZ = this.gdi.bmJ;
                aoy.fXa = m.s(this.gdi.intent);
                aoy.fXb = m.u(this.gdi.intent);
                aoy.fXc = b.fXn.fXM;
                aoy.fXd = b.fXn.name;
                aoy.bpc = i;
                aoy.bkh = m.v(this.gdi.intent);
                aoy.fXe = this.gdi.gcD;
                aoy.aoA().aoz();
            }
        });
    }

    static /* synthetic */ void f(ProtocolThreeTwoUI protocolThreeTwoUI) {
        protocolThreeTwoUI.N(0, "");
        j.apm().aoU().post(new Runnable(protocolThreeTwoUI) {
            final /* synthetic */ ProtocolThreeTwoUI gdi;

            {
                this.gdi = r1;
            }

            public final void run() {
                v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.s(this.gdi.getIntent()), Integer.valueOf(m.t(this.gdi.getIntent())), this.gdi.fZD, d.aoW(), d.aoY(), Integer.valueOf(d.aoX())});
                new com.tencent.mm.plugin.freewifi.d.a(this.gdi.fZD, r2, r3, r4, this.gdi.aPW, m.s(this.gdi.getIntent())).b(new e(this) {
                    final /* synthetic */ AnonymousClass2 gdj;

                    {
                        this.gdj = r1;
                    }

                    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                        v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.s(this.gdj.gdi.getIntent()), Integer.valueOf(m.t(this.gdj.gdi.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (i == 0 && i2 == 0 && (kVar instanceof com.tencent.mm.plugin.freewifi.d.a)) {
                            dq apx = ((com.tencent.mm.plugin.freewifi.d.a) kVar).apx();
                            if (apx != null) {
                                v.i("MicroMsg.FreeWifi.Protocol32UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{apx.mbH, apx.efy, apx.gln, Integer.valueOf(apx.mex), apx.mey, apx.cHf});
                                this.gdj.gdi.bmJ = apx.mbH;
                                this.gdj.gdi.fZF = apx.efy;
                                this.gdj.gdi.gcD = apx.gln;
                                this.gdj.gdi.gcE = apx.mex;
                                this.gdj.gdi.gcF = apx.mey;
                                this.gdj.gdi.bCj = apx.cHf;
                                this.gdj.gdi.gcG = apx.mez;
                                v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{m.s(this.gdj.gdi.getIntent()), Integer.valueOf(m.t(this.gdj.gdi.getIntent())), this.gdj.gdi.bmJ, this.gdj.gdi.fZF, this.gdj.gdi.gcD, Integer.valueOf(this.gdj.gdi.gcE), this.gdj.gdi.gcF, this.gdj.gdi.bCj, this.gdj.gdi.gcG});
                            }
                            d.a(this.gdj.gdi.ssid, 2, this.gdj.gdi.getIntent());
                            v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[]{m.s(this.gdj.gdi.getIntent()), Integer.valueOf(m.t(this.gdj.gdi.getIntent())), Integer.valueOf(2)});
                        }
                    }
                });
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.intent = getIntent();
        this.aYz = getIntent().getStringExtra("free_wifi_ap_key");
        this.bfm = getIntent().getStringExtra("free_wifi_openid");
        this.gac = getIntent().getStringExtra("free_wifi_tid");
        this.fZV = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
        this.fZW = getIntent().getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");
        v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onCreate, desc=it goes into Protocol32 connect frontpage. apKey=%s", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), this.aYz});
        NI();
        if (be.kS(this.ssid)) {
            v.e("MicroMsg.FreeWifi.Protocol32UI", "ssid is null");
        } else {
            com.tencent.mm.plugin.freewifi.g.c cVar;
            int i;
            com.tencent.mm.plugin.freewifi.g.c tP = j.apj().tP(this.ssid);
            if (tP == null) {
                tP = new com.tencent.mm.plugin.freewifi.g.c();
                tP.field_ssidmd5 = z.Kg(this.ssid);
                tP.field_ssid = this.ssid;
                cVar = tP;
                i = 1;
            } else {
                cVar = tP;
                i = 0;
            }
            cVar.field_url = this.fZD;
            cVar.field_mid = this.gaW;
            cVar.field_wifiType = 32;
            cVar.field_connectState = 1;
            if (i != 0) {
                j.apj().b(cVar);
            } else {
                j.apj().a(cVar, new String[0]);
            }
            v.i("MicroMsg.FreeWifi.Protocol32UI", "ssid : %s, mid : %s, source : %d", new Object[]{this.ssid, this.gaW, Integer.valueOf(this.bbT)});
            this.gbc = new g.a(this) {
                private int gcI = -999999999;
                final /* synthetic */ ProtocolThreeTwoUI gdi;

                {
                    this.gdi = r2;
                }

                public final void a(String str, i iVar) {
                    this.gdi.baO = this.gdi.apP();
                    if (this.gcI != this.gdi.baO) {
                        this.gcI = this.gdi.baO;
                        this.gdi.la(this.gdi.baO);
                    }
                }
            };
            j.apj().c(this.gbc);
            v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), cVar.field_ssidmd5, cVar.field_ssid, cVar.field_url, cVar.field_mid, Integer.valueOf(cVar.field_wifiType), Integer.valueOf(cVar.field_connectState)});
            v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initModel, desc=it initializes the front page. ", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
            d.a(this.ssid, 4, getIntent());
        }
        l.o(d.apa(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final void NI() {
        this.ssid = getIntent().getStringExtra("free_wifi_ssid");
        this.gaW = getIntent().getStringExtra("free_wifi_mid");
        this.fZD = getIntent().getStringExtra("free_wifi_url");
        this.bbT = getIntent().getIntExtra("free_wifi_source", 1);
        this.aPW = getIntent().getIntExtra("free_wifi_channel_id", 0);
        this.bmJ = getIntent().getStringExtra("free_wifi_appid");
        this.gbB = getIntent().getStringExtra("free_wifi_head_img_url");
        this.gbC = getIntent().getStringExtra("free_wifi_welcome_msg");
        this.gbD = getIntent().getStringExtra("free_wifi_welcome_sub_title");
        this.gbE = getIntent().getStringExtra("free_wifi_privacy_url");
        this.fZF = getIntent().getStringExtra("free_wifi_app_nickname");
        v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), this.ssid, this.gaW, this.fZD, Integer.valueOf(this.bbT), Integer.valueOf(this.aPW), this.bmJ, this.gbB, this.gbC, this.gbE});
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ProtocolThreeTwoUI gdi;

            {
                this.gdi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gdi.goBack();
                return true;
            }
        });
        findViewById(2131757093).setVisibility(0);
        this.gbr = (ImageView) findViewById(2131757085);
        this.gbs = (TextView) findViewById(2131757086);
        this.gbt = (TextView) findViewById(2131757087);
        this.gbu = (TextView) findViewById(2131757088);
        this.gbx = (Button) findViewById(2131757091);
        this.gbx.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProtocolThreeTwoUI gdi;

            {
                this.gdi = r1;
            }

            public final void onClick(View view) {
                l.p(d.apa(), this.gdi.getIntent().getStringExtra("free_wifi_ap_key"), this.gdi.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[]{m.s(this.gdi.getIntent()), Integer.valueOf(m.t(this.gdi.getIntent())), d.kX(this.gdi.apP())});
                if (this.gdi.apP() == 2) {
                    this.gdi.finish();
                    return;
                }
                d.a(this.gdi.ssid, 1, this.gdi.getIntent());
                this.gdi.connect();
            }
        });
        this.gby = (Button) findViewById(2131757092);
        this.gby.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProtocolThreeTwoUI gdi;

            {
                this.gdi = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.gdi.gbE);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.ay.c.b(this.gdi.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        if (be.kS(this.ssid)) {
            this.gbt.setText(getString(2131232982));
            this.gbx.setVisibility(4);
        }
        Fd(getString(2131232984));
    }

    protected final void connect() {
        this.baO = apP();
        v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), d.kX(this.baO)});
        if (this.baO != 2) {
            this.gdb.ea(45000);
            v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), Integer.valueOf(60)});
            this.fZJ = new a(this.ssid, this);
            j.apm().aoU().post(new Runnable(this) {
                final /* synthetic */ ProtocolThreeTwoUI gdi;

                {
                    this.gdi = r1;
                }

                public final void run() {
                    ProtocolThreeTwoUI.c(this.gdi);
                }
            });
            return;
        }
        d.a(this.ssid, 2, getIntent());
    }

    protected final void la(int i) {
        v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.gbu.setVisibility(4);
                this.gbx.setText(2131231988);
                this.gcy = com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131231988), true, new OnCancelListener(this) {
                    final /* synthetic */ ProtocolThreeTwoUI gdi;

                    {
                        this.gdi = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        d.a(this.gdi.ssid, 4, this.gdi.getIntent());
                        v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[]{m.s(this.gdi.getIntent()), Integer.valueOf(m.t(this.gdi.getIntent())), Integer.valueOf(4)});
                    }
                });
                v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
                return;
            case 2:
                if (this.gcy != null) {
                    this.gcy.dismiss();
                }
                this.gdb.QI();
                this.gbx.setText(2131231985);
                this.gbx.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.bmJ);
                intent.putExtra("free_wifi_app_nickname", this.fZF);
                intent.putExtra("free_wifi_app_username", this.gcD);
                intent.putExtra("free_wifi_signature", this.bCj);
                intent.putExtra("free_wifi_finish_actioncode", this.gcE);
                intent.putExtra("free_wifi_finish_url", this.gcF);
                if (be.kS(this.gcG)) {
                    intent.setClass(this, FreeWifiSuccUI.class);
                } else {
                    intent.putExtra("free_wifi_qinghuai_url", this.gcG);
                    intent.setClass(this, FreeWifiSuccWebViewUI.class);
                }
                finish();
                startActivity(intent);
                c.qq();
                v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toSuccess, desc=connect succeeded.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
                return;
            case 3:
                if (this.gcy != null) {
                    this.gcy.dismiss();
                }
                this.gdb.QI();
                this.gbu.setVisibility(0);
                this.gbx.setText(2131232980);
                v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toFail, desc=connect failed.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
                return;
            case 4:
                if (this.gcy != null) {
                    this.gcy.dismiss();
                }
                this.gdb.QI();
                this.gbu.setVisibility(4);
                this.gbx.setText(2131231991);
                if (this.bbT == 3) {
                    this.gbt.setText(getString(2131233838, new Object[]{this.ssid}));
                } else if (be.kS(this.gbD)) {
                    this.gbt.setText(getString(2131231987));
                } else {
                    this.gbt.setText(this.gbD);
                }
                if (!be.kS(this.bmJ)) {
                    if (!be.kS(this.fZF)) {
                        this.gbs.setText(this.fZF);
                    }
                    if (!be.kS(this.gbB)) {
                        n.GL().a(this.gbB, this.gbr, this.cPf);
                    }
                }
                v.i("MicroMsg.FreeWifi.Protocol32UI", "sessionKey=%s, step=%d, method=Protocol32UI.toConnectStart, desc=it initializes the connect front page.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return 2130903660;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        l.q(d.apa(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
        com.tencent.mm.plugin.freewifi.g.drp.i(new Intent(), this);
        finish();
    }

    protected final int apP() {
        if (be.kS(this.ssid)) {
            v.d("MicroMsg.FreeWifi.Protocol32UI", "Illegal SSID");
            return 0;
        }
        com.tencent.mm.plugin.freewifi.g.c tP = j.apj().tP(this.ssid);
        if (tP == null || !tP.field_ssid.equalsIgnoreCase(this.ssid)) {
            return 0;
        }
        return tP.field_connectState;
    }

    private void N(int i, String str) {
        k.a aoy = k.aoy();
        aoy.ssid = this.ssid;
        aoy.bssid = m.tC("MicroMsg.FreeWifi.Protocol32UI");
        aoy.aYA = m.tD("MicroMsg.FreeWifi.Protocol32UI");
        aoy.aYz = this.aYz;
        aoy.fWZ = this.bmJ;
        aoy.fXa = m.s(this.intent);
        aoy.fXb = m.u(this.intent);
        aoy.fXc = b.fXE.fXM;
        aoy.fXd = b.fXE.name;
        aoy.bpc = i;
        aoy.eOP = str;
        aoy.bkh = m.v(this.intent);
        aoy.fXe = this.gcD;
        aoy.aoA().aoz();
    }

    protected final int NO() {
        return 1;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.gbc != null) {
            j.apj().d(this.gbc);
        }
        this.gdb.QI();
        j.apm().release();
    }
}
