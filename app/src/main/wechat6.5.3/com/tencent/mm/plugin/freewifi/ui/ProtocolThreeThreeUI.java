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
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.g.c;
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
public class ProtocolThreeThreeUI extends MMActivity {
    protected int aPW;
    protected String appId;
    protected String bCj;
    private int baO = 1;
    protected int bbT;
    protected String bssid;
    protected String fZF;
    private int fZP = 0;
    protected String fZS;
    protected String fZT;
    protected String fZU;
    protected String fZV;
    protected String fZW;
    private Uri fZX;
    private String fZY;
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
        final /* synthetic */ ProtocolThreeThreeUI gdf;

        {
            this.gdf = r1;
        }

        public final boolean oU() {
            if (!be.kS(this.gdf.ssid)) {
                this.gdf.baO = this.gdf.apP();
                if (this.gdf.baO != 2) {
                    v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectTimeoutHandler, desc=wifi connecttimeout. state=%s", new Object[]{m.s(this.gdf.getIntent()), Integer.valueOf(m.t(this.gdf.getIntent())), d.kX(this.gdf.baO)});
                    d.a(this.gdf.ssid, 3, this.gdf.getIntent());
                }
            }
            return false;
        }
    }, false);
    protected String ssid;

    static /* synthetic */ void a(ProtocolThreeThreeUI protocolThreeThreeUI, String str) {
        protocolThreeThreeUI.fZP++;
        if (protocolThreeThreeUI.fZP > 3) {
            v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", new Object[]{m.s(protocolThreeThreeUI.getIntent()), Integer.valueOf(m.t(protocolThreeThreeUI.getIntent()))});
            d.a(protocolThreeThreeUI.ssid, 3, protocolThreeThreeUI.getIntent());
            return;
        }
        v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", new Object[]{m.s(protocolThreeThreeUI.getIntent()), Integer.valueOf(m.t(protocolThreeThreeUI.getIntent())), str});
        if (m.ty(str)) {
            d.a(protocolThreeThreeUI.ssid, 3, protocolThreeThreeUI.getIntent());
            return;
        }
        AnonymousClass7 anonymousClass7 = new com.tencent.mm.plugin.freewifi.a.a.a(protocolThreeThreeUI) {
            final /* synthetic */ ProtocolThreeThreeUI gdf;

            {
                this.gdf = r1;
            }

            public final void c(HttpURLConnection httpURLConnection) {
                int responseCode = httpURLConnection.getResponseCode();
                v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", new Object[]{m.s(this.gdf.getIntent()), Integer.valueOf(m.t(this.gdf.getIntent())), Integer.valueOf(responseCode)});
                if (responseCode == 200) {
                    j.apm().aoU().post(new Runnable(this.gdf) {
                        final /* synthetic */ ProtocolThreeThreeUI gdf;

                        {
                            this.gdf = r1;
                        }

                        public final void run() {
                            String aoW = d.aoW();
                            String aoY = d.aoY();
                            int aoX = d.aoX();
                            v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", new Object[]{m.s(this.gdf.getIntent()), Integer.valueOf(m.t(this.gdf.getIntent())), "", aoW, aoY, Integer.valueOf(aoX)});
                            new f(this.gdf.ssid, this.gdf.bssid, this.gdf.appId, this.gdf.fZS, this.gdf.fZT, this.gdf.fZU, this.gdf.fZV, this.gdf.fZW).b(new e(this) {
                                final /* synthetic */ AnonymousClass8 gdh;

                                {
                                    this.gdh = r1;
                                }

                                public final void a(int i, int i2, String str, k kVar) {
                                    v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", new Object[]{m.s(this.gdh.gdf.getIntent()), Integer.valueOf(m.t(this.gdh.gdf.getIntent())), Integer.valueOf(i), Integer.valueOf(i2), str});
                                    if (i == 0 && i2 == 0) {
                                        dq apx = ((f) kVar).apx();
                                        if (apx != null) {
                                            v.i("MicroMsg.FreeWifi.Protocol33UI", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{apx.mbH, apx.efy, apx.gln, Integer.valueOf(apx.mex), apx.mey, apx.cHf});
                                            this.gdh.gdf.fZF = apx.efy;
                                            this.gdh.gdf.gcD = apx.gln;
                                            this.gdh.gdf.gcE = apx.mex;
                                            this.gdh.gdf.gcF = apx.mey;
                                            this.gdh.gdf.bCj = apx.cHf;
                                            this.gdh.gdf.gcG = apx.mez;
                                            v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=FreeWifiConnector.getBackPageInfoAfterConnectSuccess, desc=net request [apauth.getBackPageFor33] gets response. backpageinfo:  appid: %s, appNickName: %s, appUserName: %s, finishActionCode: %s, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", new Object[]{m.s(this.gdh.gdf.getIntent()), Integer.valueOf(m.t(this.gdh.gdf.getIntent())), this.gdh.gdf.appId, this.gdh.gdf.fZF, this.gdh.gdf.gcD, Integer.valueOf(this.gdh.gdf.gcE), this.gdh.gdf.gcF, this.gdh.gdf.bCj, this.gdh.gdf.gcG});
                                        }
                                        d.a(this.gdh.gdf.ssid, 2, this.gdh.gdf.getIntent());
                                        v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it changes the connect state of the model to CONNECT_STATE_CONNECT_SUCCESS. state=%d", new Object[]{m.s(this.gdh.gdf.getIntent()), Integer.valueOf(m.t(this.gdh.gdf.getIntent())), Integer.valueOf(2)});
                                    } else if (i2 == -30032) {
                                        Intent intent = new Intent();
                                        intent.putExtra("free_wifi_error_ui_error_msg", this.gdh.gdf.getString(2131232952));
                                        intent.setClass(this.gdh.gdf, FreeWifiErrorUI.class);
                                        this.gdh.gdf.finish();
                                        this.gdh.gdf.startActivity(intent);
                                    } else {
                                        d.a(this.gdh.gdf.ssid, 3, this.gdh.gdf.getIntent());
                                        v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=NetSceneGetBackPageFor33 returns unkown errcode. errCode=%d", new Object[]{m.s(this.gdh.gdf.getIntent()), Integer.valueOf(m.t(this.gdh.gdf.getIntent())), Integer.valueOf(i2)});
                                    }
                                }
                            });
                        }
                    });
                } else if (responseCode == 302) {
                    ProtocolThreeThreeUI.a(this.gdf, httpURLConnection.getHeaderField("Location"));
                } else {
                    v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", new Object[]{m.s(this.gdf.getIntent()), Integer.valueOf(m.t(this.gdf.getIntent()))});
                    d.a(this.gdf.ssid, 3, this.gdf.getIntent());
                }
            }

            public final void h(Exception exception) {
                v.e("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s", new Object[]{m.s(this.gdf.getIntent()), Integer.valueOf(m.t(this.gdf.getIntent())), exception.getMessage()});
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fZY = getIntent().getStringExtra("free_wifi_schema_uri");
        this.fZX = Uri.parse(this.fZY);
        this.appId = this.fZX.getQueryParameter("appId");
        this.fZS = this.fZX.getQueryParameter("shopId");
        this.fZT = this.fZX.getQueryParameter("authUrl");
        this.fZU = this.fZX.getQueryParameter("extend");
        this.fZV = this.fZX.getQueryParameter("timestamp");
        this.fZW = this.fZX.getQueryParameter("sign");
        v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onCreate, desc=it goes into Protocol33 connect frontpage. uri = %s", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), this.fZY});
        NI();
        if (be.kS(this.ssid)) {
            v.e("MicroMsg.FreeWifi.Protocol33UI", "ssid is null");
        } else {
            c cVar;
            int i;
            c tP = j.apj().tP(this.ssid);
            if (tP == null) {
                tP = new c();
                tP.field_ssidmd5 = z.Kg(this.ssid);
                tP.field_ssid = this.ssid;
                cVar = tP;
                i = 1;
            } else {
                cVar = tP;
                i = 0;
            }
            cVar.field_url = "";
            cVar.field_mid = "";
            cVar.field_wifiType = 33;
            cVar.field_connectState = 1;
            if (i != 0) {
                j.apj().b(cVar);
            } else {
                j.apj().a(cVar, new String[0]);
            }
            v.i("MicroMsg.FreeWifi.Protocol33UI", "ssid : %s, mid : %s, source : %d", new Object[]{this.ssid, "", Integer.valueOf(this.bbT)});
            this.gbc = new a(this) {
                private int gcI = -999999999;
                final /* synthetic */ ProtocolThreeThreeUI gdf;

                {
                    this.gdf = r2;
                }

                public final void a(String str, i iVar) {
                    this.gdf.baO = this.gdf.apP();
                    if (this.gcI != this.gdf.baO) {
                        this.gcI = this.gdf.baO;
                        this.gdf.la(this.gdf.baO);
                    }
                }
            };
            j.apj().c(this.gbc);
            v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=Initializing the model behind the view, so anything that changes the model will notify the view. model : field_ssidmd5=%s, field_ssid=%s, field_url=%s, field_mid=%s, field_wifiType=%d, field_connectState=%d", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), cVar.field_ssidmd5, cVar.field_ssid, cVar.field_url, cVar.field_mid, Integer.valueOf(cVar.field_wifiType), Integer.valueOf(cVar.field_connectState)});
            v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.initModel, desc=it initializes the front page. ", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
            d.a(this.ssid, 4, getIntent());
        }
        l.o(d.apa(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0));
    }

    public final void NI() {
        this.ssid = m.tB("MicroMsg.FreeWifi.Protocol33UI");
        this.bssid = m.tC("MicroMsg.FreeWifi.Protocol33UI");
        this.bbT = getIntent().getIntExtra("free_wifi_source", 1);
        this.aPW = getIntent().getIntExtra("free_wifi_channel_id", 0);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ProtocolThreeThreeUI gdf;

            {
                this.gdf = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gdf.goBack();
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
            final /* synthetic */ ProtocolThreeThreeUI gdf;

            {
                this.gdf = r1;
            }

            public final void onClick(View view) {
                l.p(d.apa(), this.gdf.getIntent().getStringExtra("free_wifi_ap_key"), this.gdf.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connectWifiBtn.setOnClickListener, desc=User click the connect button and starts the connect wifi process. state=%s", new Object[]{m.s(this.gdf.getIntent()), Integer.valueOf(m.t(this.gdf.getIntent())), d.kX(this.gdf.apP())});
                if (this.gdf.apP() == 2) {
                    this.gdf.finish();
                    return;
                }
                d.a(this.gdf.ssid, 1, this.gdf.getIntent());
                this.gdf.connect();
            }
        });
        this.gby = (Button) findViewById(2131757092);
        this.gby.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ProtocolThreeThreeUI gdf;

            {
                this.gdf = r1;
            }

            public final void onClick(View view) {
            }
        });
        if (be.kS(this.ssid)) {
            this.gbt.setText(getString(2131232982));
            this.gbx.setVisibility(4);
        }
        Fd(getString(2131232984));
    }

    protected final void connect() {
        if (m.ty(this.ssid)) {
            v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
            d.a(this.ssid, 3, getIntent());
        } else if (m.ty(this.fZT)) {
            v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
            d.a(this.ssid, 3, getIntent());
        } else {
            this.baO = apP();
            v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connecting wifi by protocol 3.1. current connect state=%s", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), d.kX(this.baO)});
            if (this.baO != 2) {
                this.gdb.ea(30000);
                v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.connect, desc=it starts connectTimeoutHandler. timeout=%d s", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), Integer.valueOf(60)});
                m.ty(this.fZT);
                StringBuilder stringBuilder = new StringBuilder(this.fZT);
                if (this.fZT.indexOf("?") == -1) {
                    stringBuilder.append("?extend=").append(this.fZU);
                } else {
                    stringBuilder.append("&extend=").append(this.fZU);
                }
                final String stringBuilder2 = stringBuilder.toString();
                j.apm().aoU().post(new Runnable(this) {
                    final /* synthetic */ ProtocolThreeThreeUI gdf;

                    public final void run() {
                        v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", new Object[]{m.s(this.gdf.getIntent()), Integer.valueOf(m.t(this.gdf.getIntent())), stringBuilder2});
                        com.tencent.mm.plugin.freewifi.a.a.aoH();
                        com.tencent.mm.plugin.freewifi.a.a.a(stringBuilder2, new com.tencent.mm.plugin.freewifi.a.a.a(this) {
                            final /* synthetic */ AnonymousClass6 gdg;

                            {
                                this.gdg = r1;
                            }

                            public final void c(HttpURLConnection httpURLConnection) {
                                int responseCode = httpURLConnection.getResponseCode();
                                v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", new Object[]{m.s(this.gdg.gdf.getIntent()), Integer.valueOf(m.t(this.gdg.gdf.getIntent())), Integer.valueOf(responseCode)});
                                if (responseCode == 200) {
                                    j.apm().aoU().post(/* anonymous class already generated */);
                                } else if (responseCode == 302) {
                                    ProtocolThreeThreeUI.a(this.gdg.gdf, httpURLConnection.getHeaderField("Location"));
                                } else {
                                    v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", new Object[]{m.s(this.gdg.gdf.getIntent()), Integer.valueOf(m.t(this.gdg.gdf.getIntent()))});
                                    d.a(this.gdg.gdf.ssid, 3, this.gdg.gdf.getIntent());
                                }
                            }

                            public final void h(Exception exception) {
                                v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s", new Object[]{m.s(this.gdg.gdf.getIntent()), Integer.valueOf(m.t(this.gdg.gdf.getIntent())), exception.getMessage()});
                                d.a(this.gdg.gdf.ssid, 3, this.gdg.gdf.getIntent());
                            }
                        });
                    }
                });
                return;
            }
            d.a(this.ssid, 2, getIntent());
        }
    }

    protected final void la(int i) {
        v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.onConnectStateChange, desc=it receives notifications whenever the connect state of model changes and then updates the view accordingly. state=%d", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent())), Integer.valueOf(i)});
        switch (i) {
            case 1:
                this.gbu.setVisibility(4);
                this.gbx.setText(2131231988);
                this.gcy = g.a(this.nDR.nEl, getString(2131231988), true, new OnCancelListener(this) {
                    final /* synthetic */ ProtocolThreeThreeUI gdf;

                    {
                        this.gdf = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        d.a(this.gdf.ssid, 4, this.gdf.getIntent());
                        v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting.ProgressDlg.onCancel, desc=it changes the connect state of the model to CONNECT_STATE_WAIT_START because the user cancles the connect process in progress. state=%d", new Object[]{m.s(this.gdf.getIntent()), Integer.valueOf(m.t(this.gdf.getIntent())), Integer.valueOf(4)});
                    }
                });
                v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnecting, desc=it adds a loading ui on the connect front page.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
                return;
            case 2:
                if (this.gcy != null) {
                    this.gcy.dismiss();
                }
                this.gdb.QI();
                this.gbx.setText(2131231985);
                this.gbx.setClickable(false);
                Intent intent = getIntent();
                intent.putExtra("free_wifi_appid", this.appId);
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
                v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toSuccess, desc=connect succeeded.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
                return;
            case 3:
                if (this.gcy != null) {
                    this.gcy.dismiss();
                }
                this.gdb.QI();
                this.gbu.setVisibility(0);
                this.gbx.setText(2131232980);
                v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toFail, desc=connect failed.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
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
                } else {
                    this.gbt.setText(getString(2131231989, new Object[]{this.ssid}));
                }
                v.i("MicroMsg.FreeWifi.Protocol33UI", "sessionKey=%s, step=%d, method=Protocol33UI.toConnectStart, desc=it initializes the connect front page.", new Object[]{m.s(getIntent()), Integer.valueOf(m.t(getIntent()))});
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
            v.d("MicroMsg.FreeWifi.Protocol33UI", "Illegal SSID");
            return 0;
        }
        c tP = j.apj().tP(this.ssid);
        if (tP == null || !tP.field_ssid.equalsIgnoreCase(this.ssid)) {
            return 0;
        }
        return tP.field_connectState;
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
