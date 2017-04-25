package com.tencent.pb.common.b;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;

public final class g {
    private NetworkInfo bXS = null;
    private WifiInfo bXT = null;
    private int ppE = 1;

    public final synchronized boolean pX() {
        boolean z;
        WifiInfo wifiInfo = null;
        synchronized (this) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) d.kzS.getSystemService("connectivity");
                if (connectivityManager == null) {
                    c.i("NetworkChangeMgr", "can't get ConnectivityManager");
                    this.ppE = 1;
                    this.bXT = null;
                    this.bXS = null;
                    z = true;
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        this.ppE = 1;
                        this.bXT = null;
                        this.bXS = null;
                        z = true;
                    } else {
                        int i;
                        c.d("NetworkChangeMgr", "NetworkChangeMgr ", activeNetworkInfo);
                        if (!activeNetworkInfo.isConnected()) {
                            i = 1;
                        } else if (activeNetworkInfo.getType() == 1) {
                            wifiInfo = ((WifiManager) d.kzS.getSystemService("wifi")).getConnectionInfo();
                            i = 2;
                        } else {
                            i = 3;
                        }
                        if (i == this.ppE) {
                            if (i == 1) {
                                z = false;
                            } else if (i == 2) {
                                if (wifiInfo != null && this.bXT != null && this.bXT.getBSSID().equals(wifiInfo.getBSSID()) && this.bXT.getSSID().equals(wifiInfo.getSSID()) && this.bXT.getNetworkId() == wifiInfo.getNetworkId()) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                            } else if (this.bXS != null && this.bXS.getExtraInfo() != null && activeNetworkInfo.getExtraInfo() != null && this.bXS.getExtraInfo().equals(activeNetworkInfo.getExtraInfo()) && this.bXS.getSubtype() == activeNetworkInfo.getSubtype() && this.bXS.getType() == activeNetworkInfo.getType()) {
                                z = false;
                            } else if (this.bXS != null && this.bXS.getExtraInfo() == null && activeNetworkInfo.getExtraInfo() == null && this.bXS.getSubtype() == activeNetworkInfo.getSubtype() && this.bXS.getType() == activeNetworkInfo.getType()) {
                                z = false;
                            }
                            this.ppE = i;
                            this.bXT = wifiInfo;
                            this.bXS = activeNetworkInfo;
                        }
                        z = true;
                        this.ppE = i;
                        this.bXT = wifiInfo;
                        this.bXS = activeNetworkInfo;
                    }
                }
            } catch (Exception e) {
                c.i("NetworkChangeMgr", e);
                this.ppE = 1;
                this.bXT = null;
                this.bXS = null;
                z = true;
            }
        }
        return z;
    }
}
