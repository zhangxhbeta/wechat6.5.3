package com.tencent.pb.common.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.d.a.a;
import com.tencent.d.f;
import com.tencent.pb.common.b.g;
import com.tencent.pb.common.b.h;
import com.tencent.pb.common.c.c;

public class ConnectReceiver extends BroadcastReceiver {
    private static g psN = null;

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                if (intent.getAction() != null && "android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                    if (psN == null) {
                        psN = new g();
                    }
                    boolean isNetworkConnected = h.isNetworkConnected();
                    a aVar = (a) f.QG("EventCenter");
                    if (psN.pX() && aVar != null) {
                        if (isNetworkConnected) {
                            aVar.b("GLOBAL_TOPIC_NETWORK_CHANGE", 21, null);
                        } else {
                            aVar.b("GLOBAL_TOPIC_NETWORK_CHANGE", 33, null);
                        }
                    }
                }
            } catch (Throwable th) {
                c.i("ConnectReceiver", "onReceive", th);
            }
        }
    }
}
