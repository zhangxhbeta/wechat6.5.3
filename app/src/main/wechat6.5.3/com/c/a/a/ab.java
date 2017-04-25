package com.c.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import com.tencent.mm.plugin.gif.MMGIFException;
import java.util.List;

final class ab extends c {
    private static ab aNP;
    WifiManager aHy;
    private final BroadcastReceiver aNQ = new BroadcastReceiver(this) {
        final /* synthetic */ ab aNU;

        {
            this.aNU = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.net.wifi.SCAN_RESULTS")) {
                ab abVar = this.aNU;
                try {
                    List scanResults = abVar.aHy.getScanResults();
                    if (scanResults == null || scanResults.isEmpty()) {
                        throw new Exception("WifiScanMsg: null or empty scan result list");
                    }
                    abVar.c(new a(scanResults));
                } catch (Exception e) {
                }
            }
        }
    };
    private final IntentFilter aNR = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    private ac aNS;
    private long aNT = 10000;

    static class a extends p {
        final List<ScanResult> aNV;

        a(List<ScanResult> list) {
            super(MMGIFException.D_GIF_ERR_OPEN_FAILED);
            this.aNV = list;
        }
    }

    private ab() {
    }

    static ab nI() {
        if (aNP == null) {
            aNP = new ab();
        }
        return aNP;
    }

    private boolean isAvailable() {
        return this.aHy != null;
    }

    final synchronized void a(Handler handler, a aVar) {
        if (aVar == null) {
            aVar = new a(10000);
        }
        super.a(handler, aVar);
    }

    final void N(Context context) {
        this.aHy = (WifiManager) context.getSystemService("wifi");
    }

    final void a(Context context, Handler handler, a aVar) {
        if (isAvailable()) {
            context.registerReceiver(this.aNQ, this.aNR, null, handler);
            this.aNT = aVar.aHt;
            WifiManager wifiManager = this.aHy;
            if (handler == null) {
                handler = new Handler(context.getMainLooper());
            }
            this.aNS = new ac(wifiManager, handler);
            this.aNS.b(this.aNT, 0);
        }
    }

    final void O(Context context) {
        if (isAvailable()) {
            context.unregisterReceiver(this.aNQ);
            this.aNS.stop();
        }
    }

    final void na() {
    }

    final void nb() {
        if (isAvailable() && this.aHp && this.aNT < 90000) {
            this.aNS.b(90000, 0);
        }
    }

    final void nc() {
        if (isAvailable() && this.aHp && this.aNT < 90000) {
            this.aNS.b(this.aNT, 0);
        }
    }
}
