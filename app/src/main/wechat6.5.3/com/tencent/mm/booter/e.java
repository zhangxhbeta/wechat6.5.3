package com.tencent.mm.booter;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.mm.network.z;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class e {
    NetworkInfo bXS = null;
    WifiInfo bXT = null;

    final boolean pX() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) z.getContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                v.w("MicroMsg.NetworkChangeMgr", "can't get ConnectivityManager");
                this.bXS = null;
                this.bXT = null;
                return false;
            }
            NetworkInfo activeNetworkInfo;
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception e) {
                v.e("MicroMsg.NetworkChangeMgr", "getActiveNetworkInfo failed.");
                activeNetworkInfo = null;
            }
            if (activeNetworkInfo == null) {
                v.w("MicroMsg.NetworkChangeMgr", "ActiveNetwork is null, has no network");
                this.bXS = null;
                this.bXT = null;
                return false;
            }
            WifiInfo connectionInfo;
            int i = activeNetworkInfo.getType() == 1 ? 1 : 0;
            if (i != 0) {
                connectionInfo = ((WifiManager) z.getContext().getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null && this.bXT != null && this.bXT.getBSSID().equals(connectionInfo.getBSSID()) && this.bXT.getSSID().equals(connectionInfo.getSSID()) && this.bXT.getNetworkId() == connectionInfo.getNetworkId()) {
                    v.w("MicroMsg.NetworkChangeMgr", "Same Wifi, do not NetworkChanged");
                    return false;
                }
                v.d("MicroMsg.NetworkChangeMgr", "New Wifi Info:%s", connectionInfo);
                v.d("MicroMsg.NetworkChangeMgr", "OldWifi Info:%s", this.bXT);
            } else if (this.bXS != null && this.bXS.getExtraInfo() != null && activeNetworkInfo.getExtraInfo() != null && this.bXS.getExtraInfo().equals(activeNetworkInfo.getExtraInfo()) && this.bXS.getSubtype() == activeNetworkInfo.getSubtype() && this.bXS.getType() == activeNetworkInfo.getType()) {
                v.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
                return false;
            } else if (this.bXS != null && this.bXS.getExtraInfo() == null && activeNetworkInfo.getExtraInfo() == null && this.bXS.getSubtype() == activeNetworkInfo.getSubtype() && this.bXS.getType() == activeNetworkInfo.getType()) {
                v.w("MicroMsg.NetworkChangeMgr", "Same Network, do not NetworkChanged");
                return false;
            } else {
                connectionInfo = null;
            }
            if (i == 0) {
                v.d("MicroMsg.NetworkChangeMgr", "New NetworkInfo:%s", activeNetworkInfo);
                if (this.bXS != null) {
                    v.d("MicroMsg.NetworkChangeMgr", "Old NetworkInfo:%s", this.bXS);
                }
            }
            this.bXS = activeNetworkInfo;
            this.bXT = connectionInfo;
            return true;
        } catch (Throwable e2) {
            v.a("MicroMsg.NetworkChangeMgr", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }
}
