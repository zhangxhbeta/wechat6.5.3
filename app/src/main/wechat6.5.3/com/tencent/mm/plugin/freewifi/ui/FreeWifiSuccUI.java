package com.tencent.mm.plugin.freewifi.ui;

import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.e;

public class FreeWifiSuccUI extends MMActivity implements e {
    private String bCj;
    private String bmJ;
    private CheckBox eMi;
    private Button edz;
    private String fZF;
    private String gcD;
    private int gcE;
    private String gcF;
    private View gcK;
    private TextView gcL;
    private View gcM;
    private TextView gcN;
    private View gcO;
    private int gcP;
    private boolean gcQ = false;
    private boolean gcR = false;
    private TextView gcw;

    static /* synthetic */ void a(FreeWifiSuccUI freeWifiSuccUI) {
        freeWifiSuccUI.aqi();
        WifiInfo aoZ = d.aoZ();
        a aoy = k.aoy();
        if (aoZ != null) {
            String macAddress = aoZ.getMacAddress();
            if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
                macAddress = m.aoD();
            }
            aoy.ssid = m.tz(aoZ.getSSID());
            aoy.bssid = aoZ.getBSSID();
            aoy.aYA = macAddress;
        }
        aoy.aYz = m.w(freeWifiSuccUI.getIntent());
        aoy.fWZ = freeWifiSuccUI.bmJ;
        aoy.fXa = m.s(freeWifiSuccUI.getIntent());
        aoy.fXb = m.u(freeWifiSuccUI.getIntent());
        aoy.fXc = b.BackpageFinished.fXM;
        aoy.fXd = b.BackpageFinished.name;
        aoy.bkh = m.v(freeWifiSuccUI.getIntent());
        aoy.fXe = freeWifiSuccUI.gcD;
        aoy.aoA().aoz();
        if (freeWifiSuccUI.gcE == 1 && !be.kS(freeWifiSuccUI.gcF)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", Uri.parse(freeWifiSuccUI.gcF).buildUpon().appendQueryParameter("lang", u.d(freeWifiSuccUI.getSharedPreferences(aa.bti(), 0))).build().toString());
            intent.putExtra("show_bottom", false);
            intent.putExtra("stastic_scene", 7);
            intent.putExtra("neverBlockLocalRequest", true);
            c.b(freeWifiSuccUI, "webview", ".ui.tools.WebViewUI", intent);
            v.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "jump to ad page after connect wifi success, url is : %s", new Object[]{intent.getStringExtra("rawUrl")});
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bmJ = getIntent().getStringExtra("free_wifi_appid");
        this.fZF = getIntent().getStringExtra("free_wifi_app_nickname");
        this.gcD = getIntent().getStringExtra("free_wifi_app_username");
        this.gcE = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
        this.gcF = getIntent().getStringExtra("free_wifi_finish_url");
        this.gcP = getIntent().getIntExtra(com.tencent.mm.ui.d.a.nzL, 0);
        this.bCj = getIntent().getStringExtra("free_wifi_signature");
        v.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[]{this.bmJ, this.fZF, this.gcD, Integer.valueOf(this.gcE), this.gcF, this.bCj});
        WifiInfo aoZ = d.aoZ();
        a aoy = k.aoy();
        String macAddress = aoZ.getMacAddress();
        if (VERSION.SDK_INT > 22 && (macAddress == null || macAddress.equals("02:00:00:00:00:00"))) {
            macAddress = m.aoD();
        }
        if (aoZ != null) {
            aoy.ssid = m.tz(aoZ.getSSID());
            aoy.bssid = aoZ.getBSSID();
            aoy.aYA = macAddress;
        }
        aoy.aYz = getIntent().getStringExtra("free_wifi_ap_key");
        aoy.fWZ = this.bmJ;
        aoy.fXa = m.s(getIntent());
        aoy.fXb = m.u(getIntent());
        aoy.fXc = b.GetBackPage.fXM;
        aoy.fXd = b.GetBackPage.name;
        aoy.bkh = m.v(getIntent());
        aoy.fXe = this.gcD;
        aoy.aoA().aoz();
    }

    protected void onResume() {
        super.onResume();
        NI();
    }

    public void finish() {
        super.finish();
        aqi();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.FreeWifi.FreeWifiSuccUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        ak.vy().b(1703, this);
    }

    protected final int NO() {
        return 1;
    }

    protected final int getLayoutId() {
        return 2130903668;
    }

    protected final void NI() {
        vD(2131232984);
        iV(false);
        this.gcK = findViewById(2131757114);
        this.gcL = (TextView) findViewById(2131757116);
        this.eMi = (CheckBox) findViewById(2131757117);
        this.gcM = findViewById(2131757118);
        this.gcN = (TextView) findViewById(2131757119);
        this.gcO = findViewById(2131757120);
        this.gcw = (TextView) findViewById(2131757121);
        this.edz = (Button) findViewById(2131757123);
        this.edz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FreeWifiSuccUI gcS;

            {
                this.gcS = r1;
            }

            public final void onClick(View view) {
                this.gcS.finish();
                FreeWifiSuccUI.a(this.gcS);
            }
        });
        if (be.kS(this.bmJ) || be.kS(this.gcD) || be.kS(this.fZF)) {
            this.gcK.setVisibility(8);
            this.gcM.setVisibility(8);
            this.gcO.setVisibility(8);
        } else if (com.tencent.mm.model.m.eD(this.gcD) && com.tencent.mm.model.m.eC(this.gcD)) {
            l.a(d.apa(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), true);
            this.gcK.setVisibility(8);
            this.gcM.setVisibility(8);
            this.gcO.setVisibility(0);
            this.gcw.setText(this.fZF);
            this.gcO.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FreeWifiSuccUI gcS;

                {
                    this.gcS = r1;
                }

                public final void onClick(View view) {
                    if (!be.kS(this.gcS.gcD)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", this.gcS.gcD);
                        c.b(this.gcS, "profile", ".ui.ContactInfoUI", intent);
                    }
                }
            });
        } else {
            l.a(d.apa(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), false);
            this.gcO.setVisibility(8);
            this.gcK.setVisibility(0);
            if (be.kS(this.bCj)) {
                this.gcM.setVisibility(8);
                findViewById(2131757115).setBackgroundColor(getResources().getColor(2131690127));
            } else {
                this.gcM.setVisibility(0);
                this.gcN.setText(this.bCj);
            }
            this.gcL.setText(getString(2131232963, new Object[]{this.fZF}));
            if (this.gcP == 1) {
                this.eMi.setChecked(true);
                this.gcQ = true;
            } else {
                this.eMi.setChecked(false);
                this.gcQ = false;
            }
            this.eMi.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
                final /* synthetic */ FreeWifiSuccUI gcS;

                {
                    this.gcS = r1;
                }

                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        this.gcS.gcQ = true;
                    } else {
                        this.gcS.gcQ = false;
                    }
                }
            });
        }
        if (m.v(getIntent()) == 10) {
            final String str = p.ceF.ceZ;
            if (!m.ty(str) && !m.ty(p.aw(this.nDR.nEl))) {
                Button button = (Button) findViewById(2131757124);
                button.setText(String.format(getString(2131232983), new Object[]{p.aw(this.nDR.nEl)}));
                button.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ FreeWifiSuccUI gcS;

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        c.b(this.gcS, "profile", ".ui.ContactInfoUI", intent);
                    }
                });
                button.setVisibility(0);
            }
        }
    }

    private void aqi() {
        if (!this.gcR) {
            this.gcR = true;
            if (!(!this.gcQ || be.kS(this.bmJ) || (com.tencent.mm.model.m.eD(this.gcD) && com.tencent.mm.model.m.eC(this.gcD)))) {
                ak.vy().a(1703, this);
                ak.vy().a(new i(this.bmJ, getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_channel_id", 0), m.s(getIntent())), 0);
            }
            l.b(d.apa(), getIntent().getStringExtra("free_wifi_ap_key"), getIntent().getIntExtra("free_wifi_protocol_type", 0), this.gcQ);
        }
    }
}
