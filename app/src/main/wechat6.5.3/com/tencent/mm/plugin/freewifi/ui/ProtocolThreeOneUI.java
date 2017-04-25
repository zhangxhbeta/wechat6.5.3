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
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.net.HttpURLConnection;

@Deprecated
public class ProtocolThreeOneUI extends MMActivity {
    protected int aPW;
    private boolean aSZ = false;
    private String aYz;
    protected String bCj;
    private int baO = 1;
    private String bax;
    protected int bbT;
    protected String bmJ;
    private final c cPf;
    protected String fZD;
    protected String fZF;
    private String fZO;
    private int fZP = 0;
    protected String gaW;
    protected String gbB;
    protected String gbC;
    protected String gbD;
    protected String gbE;
    private a gbc;
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
        final /* synthetic */ ProtocolThreeOneUI gdc;

        {
            this.gdc = r1;
        }

        public final boolean oU() {
            if (!be.kS(this.gdc.ssid)) {
                this.gdc.baO = this.gdc.apP();
                if (this.gdc.baO != 2) {
                    this.gdc.aSZ = true;
                    v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[]{m.s(this.gdc.getIntent()), Integer.valueOf(m.t(this.gdc.getIntent())), d.kX(this.gdc.baO)});
                    d.a(this.gdc.ssid, 3, this.gdc.getIntent());
                    this.gdc.N(31, "AUTH_TIMEOUT");
                }
            }
            return false;
        }
    }, false);
    private Intent intent;
    protected String ssid;

    public ProtocolThreeOneUI() {
        c.a aVar = new c.a();
        aVar.cPq = true;
        aVar.cPr = true;
        aVar.cPH = 2130838251;
        aVar.cPP = true;
        aVar.cPQ = 0.0f;
        this.cPf = aVar.GU();
    }

    static /* synthetic */ void a(ProtocolThreeOneUI protocolThreeOneUI, String str) {
        protocolThreeOneUI.fZP++;
        if (protocolThreeOneUI.fZP > 3) {
            v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.s(protocolThreeOneUI.getIntent()), Integer.valueOf(m.t(protocolThreeOneUI.getIntent()))});
            d.a(protocolThreeOneUI.ssid, 3, protocolThreeOneUI.getIntent());
            protocolThreeOneUI.N(33, "AUTH_302_TIMES_EXCESS");
            return;
        }
        v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.s(protocolThreeOneUI.getIntent()), Integer.valueOf(m.t(protocolThreeOneUI.getIntent())), str});
        if (m.ty(str)) {
            d.a(protocolThreeOneUI.ssid, 3, protocolThreeOneUI.getIntent());
            protocolThreeOneUI.N(34, "EMPTY_AUTH_LOCATION");
            return;
        }
        AnonymousClass7 anonymousClass7 = new com.tencent.mm.plugin.freewifi.a.a.a(protocolThreeOneUI) {
            final /* synthetic */ ProtocolThreeOneUI gdc;

            {
                this.gdc = r1;
            }

            public final void c(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.s(this.gdc.getIntent()), Integer.valueOf(m.t(this.gdc.getIntent())), Integer.valueOf(responseCode)});
                if (responseCode == 200) {
                    ProtocolThreeOneUI.e(this.gdc);
                } else if (responseCode == 302) {
                    ProtocolThreeOneUI.a(this.gdc, httpURLConnection.getHeaderField("Location"));
                } else {
                    v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.s(this.gdc.getIntent()), Integer.valueOf(m.t(this.gdc.getIntent()))});
                    d.a(this.gdc.ssid, 3, this.gdc.getIntent());
                    this.gdc.N(32, "INVALID_HTTP_RESP_CODE");
                }
            }

            public final void h(Exception exception) {
                v.e("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", new Object[]{m.s(this.gdc.getIntent()), Integer.valueOf(m.t(this.gdc.getIntent())), exception.getMessage()});
                d.a(this.gdc.ssid, 3, this.gdc.getIntent());
                this.gdc.N(101, m.e(exception));
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter("method"))) {
            com.tencent.mm.plugin.freewifi.a.a.aoH();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), anonymousClass7);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.aoH();
        com.tencent.mm.plugin.freewifi.a.a.a(str, anonymousClass7);
    }

    static /* synthetic */ void e(ProtocolThreeOneUI protocolThreeOneUI) {
        protocolThreeOneUI.N(0, "");
        j.apm().aoU().post(new Runnable(protocolThreeOneUI) {
            final /* synthetic */ ProtocolThreeOneUI gdc;

            {
                this.gdc = r1;
            }

            public final void run() {
                v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPage]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.s(this.gdc.getIntent()), Integer.valueOf(m.t(this.gdc.getIntent())), this.gdc.fZD, d.aoW(), d.aoY(), Integer.valueOf(d.aoX())});
                new com.tencent.mm.plugin.freewifi.d.a(this.gdc.fZD, r2, r3, r4, this.gdc.aPW, m.s(this.gdc.getIntent())).b(new e(this) {
                    final /* synthetic */ AnonymousClass8 gde;

                    {
                        this.gde = r1;
                    }

                    public final void a(int i, int i2, String str, k kVar) {
                        v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPage] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.s(this.gde.gdc.getIntent()), Integer.valueOf(m.t(this.gde.gdc.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str});
                        if (i == 0 && i2 == 0 && (kVar instanceof com.tencent.mm.plugin.freewifi.d.a)) {
                            dq apx = ((com.tencent.mm.plugin.freewifi.d.a) kVar).apx();
                            if (apx != null) {
                                v.i("MicroMsg.FreeWifi.Protocol31UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{apx.mbH, apx.efy, apx.gln, Integer.valueOf(apx.mex), apx.mey, apx.cHf});
                                this.gde.gdc.bmJ = apx.mbH;
                                this.gde.gdc.fZF = apx.efy;
                                this.gde.gdc.gcD = apx.gln;
                                this.gde.gdc.gcE = apx.mex;
                                this.gde.gdc.gcF = apx.mey;
                                this.gde.gdc.bCj = apx.cHf;
                                this.gde.gdc.gcG = apx.mez;
                                v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPage] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{m.s(this.gde.gdc.getIntent()), Integer.valueOf(m.t(this.gde.gdc.getIntent())), this.gde.gdc.bmJ, this.gde.gdc.fZF, this.gde.gdc.gcD, Integer.valueOf(this.gde.gdc.gcE), this.gde.gdc.gcF, this.gde.gdc.bCj, this.gde.gdc.gcG});
                            }
                            d.a(this.gde.gdc.ssid, 2, this.gde.gdc.getIntent());
                            v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[]{m.s(this.gde.gdc.getIntent()), Integer.valueOf(m.t(this.gde.gdc.getIntent())), Integer.valueOf(2)});
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
        this.bax = getIntent().getStringExtra("free_wifi_schema_ticket");
        this.fZO = getIntent().getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
        v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onCreate, desc=it goes into Protocol31 connect frontpage. apKey=%s, ticket=%s", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), this.aYz, this.bax});
        NI();
        if (be.kS(this.ssid)) {
            v.e("MicroMsg.FreeWifi.Protocol31UI", "ssid is null");
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
            cVar.field_wifiType = 3;
            cVar.field_connectState = 1;
            if (i != 0) {
                j.apj().b(cVar);
            } else {
                j.apj().a(cVar, new String[0]);
            }
            v.i("MicroMsg.FreeWifi.Protocol31UI", "ssid : %s, mid : %s, source : %d", new Object[]{this.ssid, this.gaW, Integer.valueOf(this.bbT)});
            this.gbc = new a(this) {
                private int gcI = -999999999;
                final /* synthetic */ ProtocolThreeOneUI gdc;

                {
                    this.gdc = r2;
                }

                public final void a(String str, i iVar) {
                    this.gdc.baO = this.gdc.apP();
                    if (this.gcI != this.gdc.baO) {
                        this.gcI = this.gdc.baO;
                        this.gdc.la(this.gdc.baO);
                    }
                }
            };
            j.apj().c(this.gbc);
            v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), cVar.field_ssidmd5, cVar.field_ssid, cVar.field_url, cVar.field_mid, Integer.valueOf(cVar.field_wifiType), Integer.valueOf(cVar.field_connectState)});
            v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initModel, desc=it initializes the front page. ", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
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
        v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.initView, desc=Initializing the view. ssid=%s, mid=%s, fullUrl=%s, source=%d, channel=%d, appid=%s, headImgUrl=%s, welcomeMsg=%s, privacyUrl=%s", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), this.ssid, this.gaW, this.fZD, Integer.valueOf(this.bbT), Integer.valueOf(this.aPW), this.bmJ, this.gbB, this.gbC, this.gbE});
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ProtocolThreeOneUI gdc;

            {
                this.gdc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gdc.goBack();
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
            final /* synthetic */ ProtocolThreeOneUI gdc;

            {
                this.gdc = r1;
            }

            public final void onClick(View view) {
                l.p(d.apa(), this.gdc.getIntent().getStringExtra("free_wifi_ap_key"), this.gdc.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[]{m.s(this.gdc.getIntent()), Integer.valueOf(m.t(this.gdc.getIntent())), d.kX(this.gdc.apP())});
                if (this.gdc.apP() == 2) {
                    this.gdc.finish();
                    return;
                }
                d.a(this.gdc.ssid, 1, this.gdc.getIntent());
                this.gdc.connect();
            }
        });
        this.gby = (Button) findViewById(2131757092);
        this.gby.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProtocolThreeOneUI gdc;

            {
                this.gdc = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.gdc.gbE);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.ay.c.b(this.gdc.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
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
        v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), d.kX(this.baO)});
        if (this.baO != 2) {
            this.gdb.ea(15000);
            v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), Integer.valueOf(60)});
            final String str = this.fZO;
            j.apm().aoU().post(new Runnable(this) {
                final /* synthetic */ ProtocolThreeOneUI gdc;

                public final void run() {
                    v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.s(this.gdc.getIntent()), Integer.valueOf(m.t(this.gdc.getIntent())), str});
                    com.tencent.mm.plugin.freewifi.a.a.aoH();
                    com.tencent.mm.plugin.freewifi.a.a.a(str, new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                        final /* synthetic */ AnonymousClass6 gdd;

                        {
                            this.gdd = r1;
                        }

                        public final void c(HttpURLConnection httpURLConnection) {
                            int responseCode = httpURLConnection.getResponseCode();
                            v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.s(this.gdd.gdc.getIntent()), Integer.valueOf(m.t(this.gdd.gdc.getIntent())), Integer.valueOf(responseCode)});
                            if (!this.gdd.gdc.aSZ) {
                                if (responseCode == 200) {
                                    ProtocolThreeOneUI.e(this.gdd.gdc);
                                } else if (responseCode == 302) {
                                    ProtocolThreeOneUI.a(this.gdd.gdc, httpURLConnection.getHeaderField("Location"));
                                } else {
                                    v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.s(this.gdd.gdc.getIntent()), Integer.valueOf(m.t(this.gdd.gdc.getIntent()))});
                                    d.a(this.gdd.gdc.ssid, 3, this.gdd.gdc.getIntent());
                                    this.gdd.gdc.N(32, "INVALID_HTTP_RESP_CODE");
                                }
                            }
                        }

                        public final void h(Exception exception) {
                            v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.s(this.gdd.gdc.getIntent()), Integer.valueOf(m.t(this.gdd.gdc.getIntent())), exception.getMessage()});
                            d.a(this.gdd.gdc.ssid, 3, this.gdd.gdc.getIntent());
                            this.gdd.gdc.N(101, m.e(exception));
                        }
                    });
                }
            });
            return;
        }
        d.a(this.ssid, 2, getIntent());
    }

    protected final void la(int i) {
        v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.gbu.setVisibility(4);
                this.gbx.setText(2131231988);
                this.gcy = g.a(this.nDR.nEl, getString(2131231988), true, new OnCancelListener(this) {
                    final /* synthetic */ ProtocolThreeOneUI gdc;

                    {
                        this.gdc = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        d.a(this.gdc.ssid, 4, this.gdc.getIntent());
                        v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[]{m.s(this.gdc.getIntent()), Integer.valueOf(m.t(this.gdc.getIntent())), Integer.valueOf(4)});
                    }
                });
                v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
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
                v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toSuccess, desc=connect succeeded.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
                return;
            case 3:
                if (this.gcy != null) {
                    this.gcy.dismiss();
                }
                this.gdb.QI();
                this.gbu.setVisibility(0);
                this.gbx.setText(2131232980);
                v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toFail, desc=connect failed.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
                return;
            case 4:
                if (this.gcy != null) {
                    this.gcy.dismiss();
                }
                this.gdb.QI();
                this.gbu.setVisibility(4);
                this.gbx.setText(2131231991);
                if (!(m.v(getIntent()) != 10 || m.ty(com.tencent.mm.compatible.d.p.ceF.ceZ) || m.ty(com.tencent.mm.compatible.d.p.aw(this.nDR.nEl)))) {
                    this.gbx.setText(String.format(getString(2131232945), new Object[]{com.tencent.mm.compatible.d.p.aw(this.nDR.nEl)}));
                }
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
                v.i("MicroMsg.FreeWifi.Protocol31UI", "sessionKey=%s, step=%d, method=Protocol31UI.toConnectStart, desc=it initializes the connect front page.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
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
            v.d("MicroMsg.FreeWifi.Protocol31UI", "Illegal SSID");
            return 0;
        }
        com.tencent.mm.plugin.freewifi.g.c tP = j.apj().tP(this.ssid);
        if (tP == null || !tP.field_ssid.equalsIgnoreCase(this.ssid)) {
            return 0;
        }
        return tP.field_connectState;
    }

    protected final int NO() {
        return 1;
    }

    private void N(int i, String str) {
        com.tencent.mm.plugin.freewifi.k.a aoy = com.tencent.mm.plugin.freewifi.k.aoy();
        aoy.ssid = this.ssid;
        aoy.bssid = m.tC("MicroMsg.FreeWifi.Protocol31UI");
        aoy.aYA = m.tD("MicroMsg.FreeWifi.Protocol31UI");
        aoy.aYz = this.aYz;
        aoy.fWZ = this.bmJ;
        aoy.fXa = m.s(this.intent);
        aoy.fXb = m.u(this.intent);
        aoy.fXc = b.fXD.fXM;
        aoy.fXd = b.fXD.name;
        aoy.bpc = i;
        aoy.eOP = str;
        aoy.bkh = m.v(this.intent);
        aoy.fXe = this.gcD;
        aoy.aoA().aoz();
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
