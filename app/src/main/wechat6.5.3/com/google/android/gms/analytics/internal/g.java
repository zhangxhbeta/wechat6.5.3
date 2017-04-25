package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.analytics.internal.m.AnonymousClass1;
import com.google.android.gms.common.internal.w;

class g extends BroadcastReceiver {
    static final String afX = g.class.getName();
    final q afY;
    boolean afZ;
    boolean aga;

    g(q qVar) {
        w.Z(qVar);
        this.afY = qVar;
    }

    void hv() {
        this.afY.hZ();
        this.afY.ib();
    }

    boolean hw() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.afY.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (SecurityException e) {
            return false;
        }
    }

    public void onReceive(Context context, Intent intent) {
        hv();
        String action = intent.getAction();
        this.afY.hZ().d("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean hw = hw();
            if (this.aga != hw) {
                this.aga = hw;
                n ib = this.afY.ib();
                ib.d("Network connectivity status changed", Boolean.valueOf(hw));
                ib.afY.ia().c(new AnonymousClass1(ib, hw));
            }
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.afY.hZ().f("NetworkBroadcastReceiver received unknown action", action);
        } else if (!intent.hasExtra(afX)) {
            m ib2 = this.afY.ib();
            ib2.C("Radio powered up");
            ib2.hQ();
        }
    }

    public final void unregister() {
        if (this.afZ) {
            this.afY.hZ().C("Unregistering connectivity change receiver");
            this.afZ = false;
            this.aga = false;
            try {
                this.afY.mContext.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.afY.hZ().g("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
