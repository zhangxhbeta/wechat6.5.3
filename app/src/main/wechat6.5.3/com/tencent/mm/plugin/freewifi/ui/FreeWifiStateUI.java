package com.tencent.mm.plugin.freewifi.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo.State;
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
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.a;
import com.tencent.mm.plugin.freewifi.model.FreeWifiNetworkReceiver.b;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;

@Deprecated
public abstract class FreeWifiStateUI extends MMActivity implements a, b {
    protected int aPW;
    protected String aYz;
    protected String bCj;
    private int baO = 1;
    protected int bbT;
    protected String bmJ;
    private final c cPf;
    protected String fZD;
    protected String fZF;
    protected String gaW;
    protected FreeWifiNetworkReceiver gaX;
    protected boolean gaY = false;
    protected String gbB;
    protected String gbC;
    protected String gbD;
    protected String gbE;
    private ah gba = new ah(new ah.a(this) {
        final /* synthetic */ FreeWifiStateUI gcH;

        {
            this.gcH = r1;
        }

        public final boolean oU() {
            if (!be.kS(this.gcH.ssid)) {
                this.gcH.baO = this.gcH.apP();
                v.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now auth time out, ssid is %s, the connect state is %d", new Object[]{this.gcH.ssid, Integer.valueOf(this.gcH.baO)});
                this.gcH.gbb.QI();
                k.a aoy = k.aoy();
                aoy.ssid = this.gcH.ssid;
                aoy.aYz = this.gcH.aYz;
                aoy.fXa = m.s(this.gcH.getIntent());
                aoy.fXb = m.u(this.gcH.getIntent());
                aoy.fXc = k.b.AddNetwork.fXM;
                aoy.fXd = k.b.AddNetwork.name;
                aoy.bpc = -16;
                aoy.bkh = m.v(this.gcH.getIntent());
                aoy.fWZ = this.gcH.bmJ;
                aoy.fXe = this.gcH.gcD;
                aoy.aoA().aoz();
                if (this.gcH.baO != 2) {
                    this.gcH.apT();
                    this.gcH.apR();
                    d.a(this.gcH.ssid, 3, this.gcH.getIntent());
                }
            }
            return false;
        }
    }, false);
    private ah gbb = new ah(new ah.a(this) {
        final /* synthetic */ FreeWifiStateUI gcH;

        {
            this.gcH = r1;
        }

        public final boolean oU() {
            if (!d.tH(this.gcH.ssid)) {
                return true;
            }
            this.gcH.a(State.CONNECTED);
            this.gcH.gbb.QI();
            return false;
        }
    }, true);
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
    private p gcy = null;
    protected String ssid;

    public abstract void a(State state);

    protected abstract void apN();

    protected abstract void apO();

    protected abstract int apP();

    public FreeWifiStateUI() {
        c.a aVar = new c.a();
        aVar.cPq = true;
        aVar.cPr = true;
        aVar.cPH = 2130838251;
        aVar.cPP = true;
        aVar.cPQ = 0.0f;
        this.cPf = aVar.GU();
        this.gbc = new g.a(this) {
            final /* synthetic */ FreeWifiStateUI gcH;
            private int gcI = -999999999;

            {
                this.gcH = r2;
            }

            public final void a(String str, i iVar) {
                this.gcH.baO = this.gcH.apP();
                if (this.gcI != this.gcH.baO) {
                    this.gcI = this.gcH.baO;
                    this.gcH.ku(this.gcH.baO);
                }
            }
        };
    }

    static /* synthetic */ void d(FreeWifiStateUI freeWifiStateUI) {
        if (freeWifiStateUI.gaX == null) {
            freeWifiStateUI.apU();
        }
        freeWifiStateUI.gaX.fYU = freeWifiStateUI;
        d.aoV();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r9) {
        /*
        r8 = this;
        r7 = 3;
        r6 = 2;
        r1 = 1;
        r2 = 0;
        super.onCreate(r9);
        r0 = r8.getIntent();
        r3 = "free_wifi_ap_key";
        r0 = r0.getStringExtra(r3);
        r8.aYz = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_ssid";
        r0 = r0.getStringExtra(r3);
        r8.ssid = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_mid";
        r0 = r0.getStringExtra(r3);
        r8.gaW = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_url";
        r0 = r0.getStringExtra(r3);
        r8.fZD = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_source";
        r0 = r0.getIntExtra(r3, r1);
        r8.bbT = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_channel_id";
        r0 = r0.getIntExtra(r3, r2);
        r8.aPW = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_appid";
        r0 = r0.getStringExtra(r3);
        r8.bmJ = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_head_img_url";
        r0 = r0.getStringExtra(r3);
        r8.gbB = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_welcome_msg";
        r0 = r0.getStringExtra(r3);
        r8.gbC = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_welcome_sub_title";
        r0 = r0.getStringExtra(r3);
        r8.gbD = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_privacy_url";
        r0 = r0.getStringExtra(r3);
        r8.gbE = r0;
        r0 = r8.getIntent();
        r3 = "free_wifi_app_nickname";
        r0 = r0.getStringExtra(r3);
        r8.fZF = r0;
        r0 = r8.bbT;
        switch(r0) {
            case 1: goto L_0x011b;
            case 2: goto L_0x00e3;
            case 3: goto L_0x011b;
            case 4: goto L_0x011b;
            case 5: goto L_0x011b;
            case 6: goto L_0x011b;
            default: goto L_0x00a8;
        };
    L_0x00a8:
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 == 0) goto L_0x0179;
    L_0x00b0:
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r1 = "ssid is null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
    L_0x00b9:
        r8.NI();
        r0 = com.tencent.mm.plugin.freewifi.model.j.apj();
        r1 = r8.gbc;
        r0.c(r1);
        r0 = com.tencent.mm.plugin.freewifi.model.d.apa();
        r1 = r8.getIntent();
        r3 = "free_wifi_ap_key";
        r1 = r1.getStringExtra(r3);
        r3 = r8.getIntent();
        r4 = "free_wifi_protocol_type";
        r2 = r3.getIntExtra(r4, r2);
        com.tencent.mm.plugin.freewifi.l.o(r0, r1, r2);
        return;
    L_0x00e3:
        r0 = com.tencent.mm.plugin.freewifi.model.j.apj();
        r0 = r0.apL();
        if (r0 == 0) goto L_0x0111;
    L_0x00ed:
        r3 = r0.field_ssid;
        r8.ssid = r3;
        r3 = r0.field_mid;
        r8.gaW = r3;
        r0 = r0.field_url;
        r8.fZD = r0;
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r3 = "source from mainui banner, ssid : %s, mid : %s, url : %s";
        r4 = new java.lang.Object[r7];
        r5 = r8.ssid;
        r4[r2] = r5;
        r5 = r8.gaW;
        r4[r1] = r5;
        r5 = r8.fZD;
        r4[r6] = r5;
        com.tencent.mm.sdk.platformtools.v.i(r0, r3, r4);
        goto L_0x00a8;
    L_0x0111:
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r3 = "there is no connect sucessfull wifi info";
        com.tencent.mm.sdk.platformtools.v.i(r0, r3);
        goto L_0x00a8;
    L_0x011b:
        r0 = r8.ssid;
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r0 == 0) goto L_0x012d;
    L_0x0123:
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r1 = "ssid is null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);
        goto L_0x00b9;
    L_0x012d:
        r0 = com.tencent.mm.plugin.freewifi.model.j.apj();
        r3 = r8.ssid;
        r0 = r0.tP(r3);
        if (r0 != 0) goto L_0x0196;
    L_0x0139:
        r0 = new com.tencent.mm.plugin.freewifi.g.c;
        r0.<init>();
        r3 = r8.ssid;
        r3 = com.tencent.mm.sdk.platformtools.z.Kg(r3);
        r0.field_ssidmd5 = r3;
        r3 = r8.ssid;
        r0.field_ssid = r3;
        r3 = r0;
        r0 = r1;
    L_0x014c:
        r4 = r8.fZD;
        r3.field_url = r4;
        r4 = r8.gaW;
        r3.field_mid = r4;
        r4 = r8.getIntent();
        r5 = "free_wifi_auth_type";
        r4 = r4.getIntExtra(r5, r6);
        r3.field_wifiType = r4;
        r3.field_connectState = r1;
        if (r0 == 0) goto L_0x016e;
    L_0x0165:
        r0 = com.tencent.mm.plugin.freewifi.model.j.apj();
        r0.b(r3);
        goto L_0x00a8;
    L_0x016e:
        r0 = com.tencent.mm.plugin.freewifi.model.j.apj();
        r4 = new java.lang.String[r2];
        r0.a(r3, r4);
        goto L_0x00a8;
    L_0x0179:
        r0 = "MicroMsg.FreeWifi.FreeWifiStateUI";
        r3 = "ssid : %s, mid : %s, source : %d";
        r4 = new java.lang.Object[r7];
        r5 = r8.ssid;
        r4[r2] = r5;
        r5 = r8.gaW;
        r4[r1] = r5;
        r1 = r8.bbT;
        r1 = java.lang.Integer.valueOf(r1);
        r4[r6] = r1;
        com.tencent.mm.sdk.platformtools.v.i(r0, r3, r4);
        goto L_0x00b9;
    L_0x0196:
        r3 = r0;
        r0 = r2;
        goto L_0x014c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.ui.FreeWifiStateUI.onCreate(android.os.Bundle):void");
    }

    protected final int NO() {
        return 1;
    }

    protected void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiStateUI gcH;

            {
                this.gcH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gcH.goBack();
                return true;
            }
        });
        if (getIntent().getIntExtra("free_wifi_protocol_type", 0) == 1) {
            findViewById(2131757093).setVisibility(0);
        }
        this.gbr = (ImageView) findViewById(2131757085);
        this.gbs = (TextView) findViewById(2131757086);
        this.gbt = (TextView) findViewById(2131757087);
        this.gbu = (TextView) findViewById(2131757088);
        this.gbx = (Button) findViewById(2131757091);
        this.gbx.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiStateUI gcH;

            {
                this.gcH = r1;
            }

            public final void onClick(View view) {
                l.p(d.apa(), this.gcH.getIntent().getStringExtra("free_wifi_ap_key"), this.gcH.getIntent().getIntExtra("free_wifi_protocol_type", 0));
                if (this.gcH.apP() == 2) {
                    this.gcH.finish();
                    return;
                }
                d.a(this.gcH.ssid, 1, this.gcH.getIntent());
                this.gcH.gaY = false;
                this.gcH.apV();
            }
        });
        this.gby = (Button) findViewById(2131757092);
        this.gby.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiStateUI gcH;

            {
                this.gcH = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.gcH.gbE);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                com.tencent.mm.ay.c.b(this.gcH.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        if (be.kS(this.ssid)) {
            this.gbt.setText(getString(2131232982));
            this.gbx.setVisibility(4);
        }
    }

    protected final void apR() {
        if (this.gaX != null) {
            v.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister wifi state change receiver");
            this.gaX.fYU = null;
        }
    }

    protected final void apS() {
        if (this.gaX == null) {
            apU();
        }
        this.gaX.fYV = this;
    }

    protected final void apT() {
        if (this.gaX != null) {
            v.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now unregister network changed receiver");
            this.gaX.fYV = null;
        }
    }

    private void apU() {
        this.gaX = new FreeWifiNetworkReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(this.gaX, intentFilter);
    }

    protected final void apV() {
        if (d.isWifiEnabled()) {
            this.baO = apP();
            v.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now before connect, the connect state : %d", new Object[]{Integer.valueOf(this.baO)});
            if (this.baO != 2) {
                if (m.u(getIntent()) == 4) {
                    this.gba.ea(30000);
                } else {
                    this.gba.ea(60000);
                }
                this.gbb.ea(1000);
                if (d.tH(this.ssid)) {
                    v.i("MicroMsg.FreeWifi.FreeWifiStateUI", "start auth now, isAuting : %b", new Object[]{Boolean.valueOf(this.gaY)});
                    if (this.gaY) {
                        v.d("MicroMsg.FreeWifi.FreeWifiStateUI", "now it is authing");
                        return;
                    }
                    this.gba.ea(60000);
                    this.gbb.ea(1000);
                    apN();
                    this.gaY = true;
                    return;
                }
                j.apm().aoU().post(new Runnable(this) {
                    final /* synthetic */ FreeWifiStateUI gcH;

                    {
                        this.gcH = r1;
                    }

                    public final void run() {
                        v.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now network ssid is not wechat freewifi :%s", new Object[]{this.gcH.ssid});
                        this.gcH.apO();
                    }
                });
                return;
            }
            d.a(this.ssid, this.baO, getIntent());
            return;
        }
        this.gba.ea(60000);
        this.gbb.ea(1000);
        v.i("MicroMsg.FreeWifi.FreeWifiStateUI", "wifi is not enable, enable it");
        j.apm().aoU().post(new Runnable(this) {
            final /* synthetic */ FreeWifiStateUI gcH;

            {
                this.gcH = r1;
            }

            public final void run() {
                FreeWifiStateUI.d(this.gcH);
            }
        });
    }

    protected final void ku(int i) {
        v.i("MicroMsg.FreeWifi.FreeWifiStateUI", "Current connection state : %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case -2014:
                if (this.gcy != null) {
                    this.gcy.dismiss();
                }
                this.gba.QI();
                this.gbb.QI();
                this.gbu.setVisibility(0);
                this.gbx.setText(2131232980);
                return;
            case -1:
                return;
            case 1:
                this.gbu.setVisibility(4);
                this.gbx.setText(2131231988);
                this.gcy = com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131231988), true, new OnCancelListener(this) {
                    final /* synthetic */ FreeWifiStateUI gcH;

                    {
                        this.gcH = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        d.a(this.gcH.ssid, 4, this.gcH.getIntent());
                    }
                });
                return;
            case 2:
                if (this.gcy != null) {
                    this.gcy.dismiss();
                }
                this.gba.QI();
                this.gbb.QI();
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
                return;
            case 3:
                if (this.gcy != null) {
                    this.gcy.dismiss();
                }
                this.gba.QI();
                this.gbb.QI();
                this.gbu.setVisibility(0);
                this.gbx.setText(2131232980);
                return;
            case 4:
                if (this.gcy != null) {
                    this.gcy.dismiss();
                }
                this.gba.QI();
                this.gbb.QI();
                this.gaY = false;
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
                    if (!be.kS(this.gbC)) {
                        this.gbs.setText(this.gbC);
                    }
                    if (!be.kS(this.gbB)) {
                        n.GL().a(this.gbB, this.gbr, this.cPf);
                        return;
                    }
                    return;
                }
                return;
            default:
                if (this.gcy != null) {
                    this.gcy.dismiss();
                }
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
                    if (!be.kS(this.gbC)) {
                        this.gbs.setText(this.gbC);
                    }
                    if (!be.kS(this.gbB)) {
                        n.GL().a(this.gbB, this.gbr, this.cPf);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    protected final int getLayoutId() {
        return 2130903660;
    }

    protected void onDestroy() {
        super.onDestroy();
        j.apj().d(this.gbc);
        apR();
        apT();
        if (this.gaX != null) {
            unregisterReceiver(this.gaX);
        }
        this.gba.QI();
        this.gbb.QI();
        j.apm().release();
    }

    public final void kY(int i) {
        v.i("MicroMsg.FreeWifi.FreeWifiStateUI", "now wifi state : %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 3:
                apR();
                apV();
                return;
            default:
                return;
        }
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
}
