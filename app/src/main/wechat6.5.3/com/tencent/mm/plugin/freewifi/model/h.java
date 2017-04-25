package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class h {
    boolean eow;
    a fYW;
    BroadcastReceiver fYX;

    public interface a {
        void az(List<ScanResult> list);
    }

    private static class b {
        private static h fYZ = new h();
    }

    private h() {
        this.eow = false;
        this.fYX = new BroadcastReceiver(this) {
            final /* synthetic */ h fYY;

            {
                this.fYY = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                int i = 0;
                if (context == null || intent == null) {
                    v.e("MicroMsg.FreeWifi.WifiScanReceiver", "context is null or intent null");
                    return;
                }
                this.fYY.eow = false;
                context.unregisterReceiver(this.fYY.fYX);
                if ("android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                    WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
                    if (wifiManager == null) {
                        v.e("MicroMsg.FreeWifi.WifiScanReceiver", "bran, WifiScanReceiver onReceive, get wifi manager failed");
                        return;
                    }
                    List scanResults;
                    try {
                        scanResults = wifiManager.getScanResults();
                    } catch (SecurityException e) {
                        scanResults = new ArrayList(0);
                        v.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiManager.getScanResults() throws security exception. " + e.getMessage());
                    }
                    h hVar = this.fYY;
                    if (scanResults != null && scanResults.size() > 20) {
                        Collections.sort(scanResults, new Comparator<ScanResult>(hVar) {
                            final /* synthetic */ h fYY;

                            {
                                this.fYY = r1;
                            }

                            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                                ScanResult scanResult = (ScanResult) obj;
                                ScanResult scanResult2 = (ScanResult) obj2;
                                if (scanResult.level < scanResult2.level) {
                                    return 1;
                                }
                                return scanResult.level == scanResult2.level ? 0 : -1;
                            }
                        });
                        scanResults = scanResults.subList(0, 20);
                    }
                    String str = "MicroMsg.FreeWifi.WifiScanReceiver";
                    StringBuilder stringBuilder = new StringBuilder("wifiManager scanResults size = ");
                    if (scanResults != null) {
                        i = scanResults.size();
                    }
                    v.i(str, stringBuilder.append(i).toString());
                    if (this.fYY.fYW != null) {
                        this.fYY.fYW.az(scanResults);
                    }
                }
            }
        };
    }

    public final boolean a(a aVar) {
        if (this.eow) {
            return false;
        }
        this.eow = true;
        this.fYW = aVar;
        WifiManager wifiManager = (WifiManager) aa.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            v.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiDetectingTask, get wifi manager failed");
            return false;
        }
        aa.getContext().registerReceiver(this.fYX, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        wifiManager.startScan();
        return true;
    }
}
