package com.tencent.mm.plugin.freewifi.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.freewifi.j;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.l;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.plugin.freewifi.model.i;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;

public class FreeWifiSuccWebViewUI extends WebViewUI implements e {
    private String bCj;
    private int bkh;
    private String bmJ;
    private String fZF;
    private String gcD;
    private int gcE;
    private String gcF;
    private boolean gcQ = false;

    static /* synthetic */ void a(FreeWifiSuccWebViewUI freeWifiSuccWebViewUI) {
        String str = j.userName;
        if (be.kS(freeWifiSuccWebViewUI.gcD) || !freeWifiSuccWebViewUI.gcD.equals(str)) {
            freeWifiSuccWebViewUI.gcQ = false;
        } else {
            freeWifiSuccWebViewUI.gcQ = true;
        }
        if (!(!freeWifiSuccWebViewUI.gcQ || be.kS(freeWifiSuccWebViewUI.bmJ) || (m.eD(freeWifiSuccWebViewUI.gcD) && m.eC(freeWifiSuccWebViewUI.gcD)))) {
            ak.vy().a(1703, freeWifiSuccWebViewUI);
            ak.vy().a(new i(freeWifiSuccWebViewUI.bmJ, freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_ap_key"), freeWifiSuccWebViewUI.getIntent().getIntExtra("free_wifi_channel_id", 0), com.tencent.mm.plugin.freewifi.m.s(freeWifiSuccWebViewUI.getIntent())), 0);
        }
        l.b(d.apa(), freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_ap_key"), freeWifiSuccWebViewUI.getIntent().getIntExtra("free_wifi_protocol_type", 0), freeWifiSuccWebViewUI.gcQ);
        WifiInfo aoZ = d.aoZ();
        a aoy = k.aoy();
        if (aoZ != null) {
            str = aoZ.getMacAddress();
            if (VERSION.SDK_INT > 22 && (str == null || str.equals("02:00:00:00:00:00"))) {
                str = com.tencent.mm.plugin.freewifi.m.aoD();
            }
            aoy.ssid = com.tencent.mm.plugin.freewifi.m.tz(aoZ.getSSID());
            aoy.bssid = aoZ.getBSSID();
            aoy.aYA = str;
        }
        aoy.aYz = com.tencent.mm.plugin.freewifi.m.w(freeWifiSuccWebViewUI.getIntent());
        aoy.fWZ = freeWifiSuccWebViewUI.bmJ;
        aoy.fXa = com.tencent.mm.plugin.freewifi.m.s(freeWifiSuccWebViewUI.getIntent());
        aoy.fXb = com.tencent.mm.plugin.freewifi.m.u(freeWifiSuccWebViewUI.getIntent());
        aoy.fXc = b.QinghuaiBackpageFinished.fXM;
        aoy.fXd = b.QinghuaiBackpageFinished.name;
        aoy.bkh = com.tencent.mm.plugin.freewifi.m.v(freeWifiSuccWebViewUI.getIntent());
        aoy.fXe = freeWifiSuccWebViewUI.gcD;
        aoy.aoA().aoz();
        str = freeWifiSuccWebViewUI.getIntent().getStringExtra("free_wifi_finish_url");
        if (freeWifiSuccWebViewUI.gcE == 1 && !be.kS(str)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", Uri.parse(str).buildUpon().appendQueryParameter("lang", u.d(freeWifiSuccWebViewUI.getSharedPreferences(aa.bti(), 0))).build().toString());
            intent.putExtra("show_bottom", false);
            intent.putExtra("stastic_scene", 7);
            intent.putExtra("neverBlockLocalRequest", true);
            c.b(freeWifiSuccWebViewUI, "webview", ".ui.tools.WebViewUI", intent);
            v.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "jump to ad page after connect wifi success, url is : %s", new Object[]{intent.getStringExtra("rawUrl")});
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        j.userName = "";
        j.type = 0;
        v.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "qinghuaiUrl=%s", new Object[]{getIntent().getStringExtra("free_wifi_qinghuai_url")});
        getIntent().putExtra("rawUrl", str);
        getIntent().putExtra("showShare", false);
        super.onCreate(bundle);
        this.bmJ = getIntent().getStringExtra("free_wifi_appid");
        this.fZF = getIntent().getStringExtra("free_wifi_app_nickname");
        this.gcD = getIntent().getStringExtra("free_wifi_app_username");
        this.gcE = getIntent().getIntExtra("free_wifi_finish_actioncode", 0);
        this.gcF = getIntent().getStringExtra("free_wifi_finish_url");
        this.bCj = getIntent().getStringExtra("free_wifi_signature");
        this.bkh = com.tencent.mm.plugin.freewifi.m.v(getIntent());
        if (this.bkh == 10) {
            str = p.ceF.ceZ;
            String aw = p.aw(this.nDR.nEl);
            if (!(com.tencent.mm.plugin.freewifi.m.ty(str) || com.tencent.mm.plugin.freewifi.m.ty(aw))) {
                this.gcF = Uri.parse(this.gcF).buildUpon().appendQueryParameter("manufacturer", aw).appendQueryParameter("manufacturerUsername", str).toString();
            }
        }
        v.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "get from intent, appid = %s, appNickName = %s, appUserName = %s, finishActionCode = %d, finishUrl = %s, signature = %s", new Object[]{this.bmJ, this.fZF, this.gcD, Integer.valueOf(this.gcE), this.gcF, this.bCj});
        WifiInfo aoZ = d.aoZ();
        a aoy = k.aoy();
        if (aoZ != null) {
            str = aoZ.getMacAddress();
            if (VERSION.SDK_INT > 22 && (str == null || str.equals("02:00:00:00:00:00"))) {
                str = com.tencent.mm.plugin.freewifi.m.aoD();
            }
            aoy.ssid = com.tencent.mm.plugin.freewifi.m.tz(aoZ.getSSID());
            aoy.bssid = aoZ.getBSSID();
            aoy.aYA = str;
        }
        aoy.aYz = getIntent().getStringExtra("free_wifi_ap_key");
        aoy.fWZ = this.bmJ;
        aoy.fXa = com.tencent.mm.plugin.freewifi.m.s(getIntent());
        aoy.fXb = com.tencent.mm.plugin.freewifi.m.u(getIntent());
        aoy.fXc = b.GetBackPage.fXM;
        aoy.fXd = b.GetBackPage.name;
        aoy.bkh = com.tencent.mm.plugin.freewifi.m.v(getIntent());
        aoy.fXe = this.gcD;
        aoy.aoA().aoz();
    }

    @TargetApi(11)
    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(1703, this);
    }

    protected final void aqj() {
        super.aqj();
    }

    public void finish() {
        super.finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    protected final void NI() {
        super.NI();
        iV(false);
        a(0, getString(2131232962), new OnMenuItemClickListener(this) {
            final /* synthetic */ FreeWifiSuccWebViewUI gcU;

            {
                this.gcU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gcU.finish();
                FreeWifiSuccWebViewUI.a(this.gcU);
                return true;
            }
        }, com.tencent.mm.ui.k.b.nEY);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        if (!getString(2131232962).equals((String) menu.getItem(0).getTitle())) {
            a(0, getString(2131232962), new OnMenuItemClickListener(this) {
                final /* synthetic */ FreeWifiSuccWebViewUI gcU;

                {
                    this.gcU = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.gcU.finish();
                    FreeWifiSuccWebViewUI.a(this.gcU);
                    return true;
                }
            }, com.tencent.mm.ui.k.b.nEY);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.FreeWifi.FreeWifiSuccWebViewUI", "onSceneEnd, scnee type = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2)});
        ak.vy().b(1703, this);
    }
}
