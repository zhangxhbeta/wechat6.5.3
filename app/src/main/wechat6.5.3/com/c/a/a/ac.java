package com.c.a.a;

import android.net.wifi.WifiManager;
import android.os.Handler;

final class ac extends e {
    private final WifiManager aNW;

    ac(WifiManager wifiManager, Handler handler) {
        super(handler);
        this.aNW = wifiManager;
    }

    final void ne() {
        this.aNW.startScan();
    }
}
