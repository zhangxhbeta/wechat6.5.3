package com.tencent.mm.plugin.freewifi;

import android.app.Activity;
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

public final class e {
    private WifiManager aNW = ((WifiManager) aa.getContext().getSystemService("wifi"));
    Condition aPJ = this.fWu.newCondition();
    private Activity aXH;
    private int fWH = 10;
    Lock fWu = new ReentrantLock();
    private BroadcastReceiver fWx;

    public e(Activity activity) {
        this.aXH = activity;
    }

    public final int aoo() {
        if (3 == this.aNW.getWifiState()) {
            return 0;
        }
        this.fWx = new BroadcastReceiver(this) {
            final /* synthetic */ e fWI;

            {
                this.fWI = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                if ("android.net.wifi.WIFI_STATE_CHANGED".equals(intent.getAction())) {
                    int intExtra = intent.getIntExtra("wifi_state", 0);
                    v.i("MicroMsg.FreeWifi.EnableWifiHelper", "wifi enabled state=" + intExtra);
                    if (intExtra == 3) {
                        try {
                            this.fWI.fWu.lock();
                            this.fWI.aPJ.signalAll();
                        } finally {
                            this.fWI.aom();
                            this.fWI.fWu.unlock();
                        }
                    }
                }
            }
        };
        try {
            this.fWu.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            this.aXH.registerReceiver(this.fWx, intentFilter);
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
            this.aXH.unregisterReceiver(this.fWx);
        } catch (IllegalArgumentException e) {
        }
    }
}
