package com.tencent.mm.plugin.freewifi.ui;

import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.v;

@Deprecated
public abstract class FreeWifiActivateNoAuthStateUI extends FreeWifiActivateStateUI {
    private String fWC;
    private int gaP;
    private boolean gaQ;

    protected abstract String apQ();

    public void onCreate(Bundle bundle) {
        this.gaP = getIntent().getIntExtra("free_wifi_encrypt_type", 0);
        this.fWC = getIntent().getStringExtra("free_wifi_passowrd");
        this.gaQ = getIntent().getBooleanExtra("free_wifi_hide_ssid", false);
        super.onCreate(bundle);
        d.a(this.ssid, 1, getIntent());
        v.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "Comes from webview, do auth");
    }

    protected final void NI() {
        super.NI();
        this.gaV.setVisibility(0);
        Fd(apQ());
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    public void a(State state) {
        v.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "now network state : %s", new Object[]{state.toString()});
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
            v.i("MicroMsg.FreeWifi.FreeWifiActivateNoAuthStateUI", "it is authing now");
            return;
        }
        this.gaY = true;
        apS();
        d.c(this.ssid, this.fWC, this.gaP, this.gaQ);
    }

    protected int apP() {
        if (!d.tH(this.ssid)) {
            return 1;
        }
        d.a(this.ssid, 2, getIntent());
        return 2;
    }
}
