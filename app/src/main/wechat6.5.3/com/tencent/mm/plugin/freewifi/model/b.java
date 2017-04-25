package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class b {
    a fYy;
    BroadcastReceiver fYz;

    private static class a {
        String bssid;
        long fYB;
        String fYC;
        String ssid;
        int type;

        private a() {
            this.ssid = "";
            this.bssid = "";
            this.fYC = "";
        }

        public final a aoS() {
            a aVar = new a();
            aVar.fYB = this.fYB;
            aVar.type = this.type;
            aVar.ssid = this.ssid;
            aVar.bssid = this.bssid;
            aVar.fYC = this.fYC;
            return aVar;
        }

        public final String toString() {
            return String.format("NetworkInfoConnectedRecord(timeMillis=%d, type=%d, ssid=%s, bssid=%s, mobileNetworkType=%s)", new Object[]{Long.valueOf(this.fYB), Integer.valueOf(this.type), this.ssid, this.bssid, this.fYC});
        }
    }

    private static class b {
        private static b fYD = new b();
    }

    private b() {
        this.fYy = new a();
        this.fYz = new BroadcastReceiver(this) {
            final /* synthetic */ b fYA;

            {
                this.fYA = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    try {
                        v.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connChangedBroadcastReceiver");
                        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        if (networkInfo == null) {
                            v.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo is null");
                            return;
                        }
                        v.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo=" + networkInfo.toString() + "; networkInfo.isConnected()=%b, networkInfo.getState()=%s, networkInfo.getDetailedState()=%s, networkInfo.getExtraInfo()=%s, networkInfo.isConnectedOrConnecting()=%b, networkInfo.isAvailable()=%b, ", new Object[]{Boolean.valueOf(networkInfo.isConnected()), networkInfo.getState(), networkInfo.getDetailedState(), networkInfo.getExtraInfo(), Boolean.valueOf(networkInfo.isConnectedOrConnecting()), Boolean.valueOf(networkInfo.isAvailable())});
                        if (!networkInfo.isConnected()) {
                            v.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network is not connected.");
                        } else if (networkInfo.getType() != 0 && networkInfo.getType() != 1) {
                            v.v("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "network type is not wifi or mobile.");
                        } else if (context == null) {
                            v.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "context is null.");
                        } else if (networkInfo.getType() == 1) {
                            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                            if (wifiManager == null) {
                                v.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManager is null.");
                                return;
                            }
                            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                            if (connectionInfo == null) {
                                v.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiInfo is null.");
                                return;
                            }
                            String tz = m.tz(connectionInfo.getSSID());
                            String toLowerCase = m.tA(connectionInfo.getBSSID()).toLowerCase();
                            v.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfo.getExtraInfo()=%s, wifiInfo.getSsid()=%s, wifiInfo.getBssid=%s", new Object[]{m.tz(m.tA(networkInfo.getExtraInfo())), tz, toLowerCase});
                            if (!m.tA(m.tz(m.tA(networkInfo.getExtraInfo()))).equals(tz)) {
                                v.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "wifiManage ssid is not equal to networkInfo.getExtraInfo(). networkwork might changed. return.");
                            } else if (this.fYA.fYy.type == 1 && m.tA(this.fYA.fYy.ssid).equals(tz) && m.tA(this.fYA.fYy.bssid).equals(toLowerCase)) {
                                v.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                            } else {
                                a aVar = new a();
                                aVar.fYB = System.currentTimeMillis();
                                aVar.type = 1;
                                aVar.ssid = tz;
                                aVar.bssid = toLowerCase;
                                aVar.fYC = "";
                                b.b(this.fYA.fYy.aoS(), aVar);
                                this.fYA.fYy = aVar;
                            }
                        } else if (networkInfo.getType() != 0) {
                        } else {
                            if (this.fYA.fYy.type == 0 && m.tA(this.fYA.fYy.fYC).equals(m.tA(networkInfo.getExtraInfo()))) {
                                v.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "Dulplicated intent.");
                                return;
                            }
                            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                            if (connectivityManager == null) {
                                v.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "connManager is null.");
                                return;
                            }
                            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
                            if (networkInfo2 == null) {
                                v.e("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi is null.");
                                return;
                            }
                            v.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "networkInfoWifi.getState()=%s, networkInfoWifi.getDetailedState()=%s", new Object[]{networkInfo2.getState(), networkInfo2.getDetailedState()});
                            if (networkInfo2.getDetailedState() != DetailedState.DISCONNECTED) {
                                v.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "It receives a type mobile connected event, but wifi network is not disconnected, so in fact user is probably switching wifi among ssids, not trying to connect to mobile network. ");
                                return;
                            }
                            a aVar2 = new a();
                            aVar2.fYB = System.currentTimeMillis();
                            aVar2.type = 0;
                            aVar2.ssid = "";
                            aVar2.bssid = "";
                            aVar2.fYC = m.tA(networkInfo.getExtraInfo());
                            b.a(this.fYA.fYy.aoS(), aVar2);
                            this.fYA.fYy = aVar2;
                        }
                    } catch (Exception e) {
                        com.tencent.mm.plugin.freewifi.k.a aoy = k.aoy();
                        aoy.aYz = "UnExpectedException";
                        aoy.bpc = -1;
                        aoy.eOP = m.e(e);
                        aoy.aoA().aoz();
                        v.e("MicroMsg.FreeWifi.UnExcepctedException", m.f(e));
                    }
                }
            }
        };
    }

    public final void aom() {
        try {
            aa.getContext().unregisterReceiver(this.fYz);
        } catch (IllegalArgumentException e) {
        }
    }

    static void a(a aVar, a aVar2) {
        m.tE("on mobile connected.");
        v.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onMobileConnected. lastRecord=%s, newRecord=%s", new Object[]{aVar.toString(), aVar2.toString()});
        com.tencent.mm.plugin.freewifi.f.b.kZ(0);
    }

    static void b(a aVar, a aVar2) {
        m.tE("on wifi connected.");
        v.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "onWifiConnected. lastRecord=%s, newRecord=%s", new Object[]{aVar.toString(), aVar2.toString()});
        if (aVar.type == 1 && aVar.ssid.equals(aVar2.ssid) && !aVar.bssid.equals(aVar2.bssid)) {
            String str = aVar.ssid;
            String str2 = aVar.bssid;
            String str3 = aVar2.bssid;
            m.tE("on wifi roaming.");
            v.i("MicroMsg.FreeWifi.FreeWifiConnChangedManager", "WifiRoaming. ssid=%s, fromBssid=%s, toBssid=%s", new Object[]{str, str2, str3});
        }
        com.tencent.mm.plugin.freewifi.f.b.kZ(1);
    }
}
