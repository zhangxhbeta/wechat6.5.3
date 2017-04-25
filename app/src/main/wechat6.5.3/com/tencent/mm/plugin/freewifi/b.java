package com.tencent.mm.plugin.freewifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.mm.plugin.freewifi.model.d;
import com.tencent.mm.sdk.platformtools.v;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class b {
    private WifiManager aNW;
    Condition aPJ;
    private long cAo = 15000;
    private Context context;
    Lock fWu;
    boolean fWv = false;
    boolean fWw = false;
    private BroadcastReceiver fWx;
    String ssid;

    public b(String str, Context context) {
        this.ssid = str;
        this.fWu = new ReentrantLock();
        this.aPJ = this.fWu.newCondition();
        this.aNW = (WifiManager) context.getSystemService("wifi");
        this.context = context;
    }

    public final int aon() {
        if (((ConnectivityManager) this.context.getSystemService("connectivity")).getNetworkInfo(1).isConnected() && this.ssid.equals(d.apb())) {
            return 0;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            throw new RuntimeException("ConnectNetworkHelper组件不能在主线程中运行。");
        }
        this.fWx = new BroadcastReceiver(this) {
            final /* synthetic */ b fWA;

            {
                this.fWA = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                NetworkInfo networkInfo;
                if (intent.getAction().equals("android.net.wifi.STATE_CHANGE")) {
                    networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (networkInfo != null) {
                        v.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[]{this.fWA.ssid, m.tB("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString()});
                    }
                    if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && this.fWA.ssid.equals(m.tz(networkInfo.getExtraInfo()))) {
                        try {
                            this.fWA.fWu.lock();
                            this.fWA.fWv = true;
                            v.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "WifiManager.NETWORK_STATE_CHANGED_ACTION broadcastreceiver signal connected state.");
                            this.fWA.aPJ.signalAll();
                        } finally {
                            this.fWA.fWu.unlock();
                        }
                    }
                } else if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                    if (networkInfo != null) {
                        v.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastReceiver, targetssid=%s, Utils.getConnectedWifiSsid(TAG)=%s,networkInfo.isConnected()=%b, networkInfo.isConnectedOrConnecting()=%b, networkInfo.getExtraInfo()=%s, networkInfo.getType()=%d, networkInfo.toString()=%s", new Object[]{this.fWA.ssid, m.tB("MicroMsg.FreeWifi.ConnectNetworkHelper"), Boolean.valueOf(networkInfo.isConnected()), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), networkInfo.getExtraInfo(), Integer.valueOf(networkInfo.getType()), networkInfo.toString()});
                    }
                    if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == 1 && this.fWA.ssid.equals(m.tz(networkInfo.getExtraInfo()))) {
                        try {
                            this.fWA.fWu.lock();
                            this.fWA.fWw = true;
                            v.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "ConnectivityManager.CONNECTIVITY_ACTION broadcastreceiver signal connected state.");
                            this.fWA.aPJ.signalAll();
                        } finally {
                            this.fWA.fWu.unlock();
                        }
                    }
                }
            }
        };
        try {
            int aoo;
            this.fWu.lock();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.STATE_CHANGE");
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.context.registerReceiver(this.fWx, intentFilter);
            if (!this.aNW.isWifiEnabled()) {
                aoo = new f(this.context).aoo();
                v.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "enable ret = " + aoo);
                if (aoo != 0) {
                    return aoo;
                }
            }
            aoo = d.tI(this.ssid);
            if (aoo != 0) {
                aom();
                aom();
                this.fWu.unlock();
                return aoo;
            }
            boolean z = false;
            while (true) {
                if (!this.fWv || !this.fWw) {
                    long currentTimeMillis = System.currentTimeMillis();
                    z = this.aPJ.await(this.cAo, TimeUnit.MILLISECONDS);
                    if (!z) {
                        break;
                    }
                    currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                    this.cAo -= currentTimeMillis;
                    v.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "costMillis=" + currentTimeMillis + "; left timeout=" + this.cAo);
                    this.cAo = this.cAo > 0 ? this.cAo : 3000;
                } else {
                    break;
                }
            }
            if (!z) {
                return -16;
            }
            aom();
            this.fWu.unlock();
            return 0;
        } catch (InterruptedException e) {
            v.i("MicroMsg.FreeWifi.ConnectNetworkHelper", "desc=ConnectNetworkHelper encounter interrupted exception. msg=%s", new Object[]{e.getMessage()});
            return -17;
        } finally {
            aom();
            this.fWu.unlock();
        }
    }

    private void aom() {
        try {
            this.context.unregisterReceiver(this.fWx);
        } catch (IllegalArgumentException e) {
        }
    }
}
