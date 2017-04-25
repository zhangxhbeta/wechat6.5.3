package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.a;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.v;

@Deprecated
public abstract class FreeWifiNoAuthStateUI extends FreeWifiStateUI {
    private String fWC;
    private int gaP;
    private boolean gaQ;

    protected abstract String apQ();

    public void onCreate(Bundle bundle) {
        this.gaP = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
        this.fWC = getIntent().getStringExtra("free_wifi_passowrd");
        this.gaQ = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
        super.onCreate(bundle);
        d.a(this.ssid, 4, getIntent());
        v.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "Comes from webview, do auth");
    }

    protected final void NI() {
        super.NI();
        Fd(apQ());
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void a(State state) {
        v.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "now network state : %s", new Object[]{state.toString()});
        if (state == State.CONNECTED && d.tH(this.ssid)) {
            apT();
            this.gaY = false;
            d.a(this.ssid, 2, getIntent());
        }
    }

    protected final void apN() {
        apO();
    }

    protected final void apO() {
        if (this.gaY) {
            v.i("MicroMsg.FreeWifi.FreeWifiNoAuthStateUI", "it is authing now");
            return;
        }
        this.gaY = true;
        apS();
        int c = d.c(this.ssid, this.fWC, this.gaP, this.gaQ);
        a aoy = k.aoy();
        aoy.ssid = this.ssid;
        aoy.aYz = this.aYz;
        aoy.fXa = m.s(getIntent());
        aoy.fXb = m.u(getIntent());
        aoy.fXc = b.AddNetwork.fXM;
        aoy.fXd = b.AddNetwork.name;
        aoy.bpc = c;
        aoy.bkh = m.v(getIntent());
        aoy.fWZ = this.bmJ;
        aoy.fXe = this.gcD;
        aoy.aoA().aoz();
    }

    protected int apP() {
        if (!d.tH(this.ssid)) {
            return 1;
        }
        d.a(this.ssid, 2, getIntent());
        return 2;
    }
}
