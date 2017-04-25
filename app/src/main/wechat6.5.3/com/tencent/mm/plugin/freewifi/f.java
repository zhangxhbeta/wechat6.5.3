package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class f {
    private WifiManager aNW = ((WifiManager) aa.getContext().getSystemService("wifi"));
    Condition aPJ = this.fWu.newCondition();
    private Context context;
    private int fWH = 10;
    Lock fWu = new ReentrantLock();
    private BroadcastReceiver fWx;

    public f(Context context) {
        this.context = context;
    }

    public final int aoo() {
        if (3 == this.aNW.getWifiState()) {
            return 0;
        }
        this.fWx = new BroadcastReceiver(this) {
            final /* synthetic */ f fWJ;

            {
                this.fWJ = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("wifi_state", 0);
                    v.i("MicroMsg.FreeWifi.EnableWifiHelper", "wifi enabled state=" + intExtra);
                    if (intExtra == 3) {
                        try {
                            this.fWJ.fWu.lock();
                            this.fWJ.aPJ.signalAll();
                        } finally {
                            this.fWJ.aom();
                            this.fWJ.fWu.unlock();
                        }
                    }
                }
            }
        };
        try {
            this.fWu.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            this.context.registerReceiver(this.fWx, intentFilter);
            this.aNW.setWifiEnabled(true);
            if (this.aPJ.await((long) this.fWH, TimeUnit.SECONDS)) {
                return 0;
            }
            aom();
            this.fWu.unlock();
            return 1;
        } catch (InterruptedException e) {
            return 2;
        } finally {
            aom();
            this.fWu.unlock();
        }
    }

    public final void aom() {
        try {
            this.context.unregisterReceiver(this.fWx);
        } catch (IllegalArgumentException e) {
        }
    }
}
