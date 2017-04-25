package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class FreeWifiNetworkReceiver extends BroadcastReceiver {
    public b fYU;
    public a fYV;

    public interface a {
        void a(State state);
    }

    public interface b {
        void kY(int i);
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            v.e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "intent is null");
            return;
        }
        String action = intent.getAction();
        v.i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "FreeWifiNetworkReceiver action : %s", new Object[]{action});
        if (be.kS(action)) {
            v.e("MicroMsg.FreeWifi.WifiStateChangedReceiver", "action is null");
        } else if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
            v.i("MicroMsg.FreeWifi.WifiStateChangedReceiver", "now wifi state : %d", new Object[]{Integer.valueOf(intent.getIntExtra("wifi_state", 0))});
            if (this.fYU != null) {
                this.fYU.kY(r0);
            }
        } else if (action.equals("android.net.wifi.STATE_CHANGE")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("networkInfo");
            if (parcelableExtra != null) {
                NetworkInfo networkInfo = (NetworkInfo) parcelableExtra;
                if (networkInfo != null && this.fYV != null) {
                    this.fYV.a(networkInfo.getState());
                }
            }
        }
    }
}
