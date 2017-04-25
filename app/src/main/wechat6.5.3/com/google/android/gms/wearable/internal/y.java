package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.wearable.internal.x.a;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class y<T> {
    private final Map<T, ap<T>> aFu = new HashMap();

    y() {
    }

    public final void a(ao aoVar) {
        synchronized (this.aFu) {
            v eVar = new e();
            for (Entry entry : this.aFu.entrySet()) {
                ap apVar = (ap) entry.getValue();
                if (apVar != null) {
                    apVar.aFO = null;
                    apVar.aFP = null;
                    apVar.aFQ = null;
                    apVar.aFR = null;
                    apVar.aFS = null;
                    apVar.aFT = null;
                    apVar.aFU = null;
                    apVar.aFV = null;
                    if (aoVar.isConnected()) {
                        try {
                            ((x) aoVar.jT()).a(eVar, new RemoveListenerRequest(apVar));
                            if (Log.isLoggable("WearableClient", 2)) {
                                new StringBuilder("disconnect: removed: ").append(entry.getKey()).append("/").append(apVar);
                            }
                        } catch (RemoteException e) {
                            new StringBuilder("disconnect: Didn't remove: ").append(entry.getKey()).append("/").append(apVar);
                        }
                    } else {
                        continue;
                    }
                }
            }
            this.aFu.clear();
        }
    }

    public final void u(IBinder iBinder) {
        synchronized (this.aFu) {
            x t = a.t(iBinder);
            v eVar = new e();
            for (Entry entry : this.aFu.entrySet()) {
                ap apVar = (ap) entry.getValue();
                try {
                    t.a(eVar, new AddListenerRequest(apVar));
                    if (Log.isLoggable("WearableClient", 2)) {
                        new StringBuilder("onPostInitHandler: added: ").append(entry.getKey()).append("/").append(apVar);
                    }
                } catch (RemoteException e) {
                    new StringBuilder("onPostInitHandler: Didn't add: ").append(entry.getKey()).append("/").append(apVar);
                }
            }
        }
    }
}
