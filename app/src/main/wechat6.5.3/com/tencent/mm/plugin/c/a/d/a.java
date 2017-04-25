package com.tencent.mm.plugin.c.a.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class a {
    final a esH;
    public final BroadcastReceiver esI = new BroadcastReceiver(this) {
        final /* synthetic */ a esJ;

        {
            this.esJ = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent == null) {
                v.e("McroMsg.exdevice.BluetoohtStateMonitor", "null == intent");
            } else if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                v.i("McroMsg.exdevice.BluetoohtStateMonitor", "onReceive, action = " + intent.getAction());
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                if (10 == intExtra || 12 == intExtra) {
                    this.esJ.esH.it(intExtra);
                }
            }
        }
    };

    public interface a {
        void it(int i);
    }

    public a(a aVar) {
        v.i("McroMsg.exdevice.BluetoohtStateMonitor", "register BluetoothState receiver");
        this.esH = aVar;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        aa.getContext().registerReceiver(this.esI, intentFilter);
    }
}
