package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class n extends m implements Callback {
    private final Context agT;
    private final HashMap<a, b> aph = new HashMap();
    private final com.google.android.gms.common.stats.b api;
    private final long apj;
    private final Handler mHandler;

    private static final class a {
        private final String apk;
        private final String apl;
        private final ComponentName apm;

        public a(ComponentName componentName) {
            this.apk = null;
            this.apl = null;
            this.apm = (ComponentName) w.Z(componentName);
        }

        public a(String str, String str2) {
            this.apk = w.U(str);
            this.apl = w.U(str2);
            this.apm = null;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return v.d(this.apk, aVar.apk) && v.d(this.apm, aVar.apm);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.apk, this.apm});
        }

        public final Intent jY() {
            return this.apk != null ? new Intent(this.apk).setPackage(this.apl) : new Intent().setComponent(this.apm);
        }

        public final String toString() {
            return this.apk == null ? this.apm.flattenToString() : this.apk;
        }
    }

    private final class b {
        IBinder anH;
        ComponentName apm;
        final a apn = new a(this);
        final Set<ServiceConnection> apo = new HashSet();
        boolean apq;
        final a apr;
        final /* synthetic */ n aps;
        int mState = 2;

        public class a implements ServiceConnection {
            final /* synthetic */ b apt;

            public a(b bVar) {
                this.apt = bVar;
            }

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (this.apt.aps.aph) {
                    this.apt.anH = iBinder;
                    this.apt.apm = componentName;
                    for (ServiceConnection onServiceConnected : this.apt.apo) {
                        onServiceConnected.onServiceConnected(componentName, iBinder);
                    }
                    this.apt.mState = 1;
                }
            }

            public final void onServiceDisconnected(ComponentName componentName) {
                synchronized (this.apt.aps.aph) {
                    this.apt.anH = null;
                    this.apt.apm = componentName;
                    for (ServiceConnection onServiceDisconnected : this.apt.apo) {
                        onServiceDisconnected.onServiceDisconnected(componentName);
                    }
                    this.apt.mState = 2;
                }
            }
        }

        public b(n nVar, a aVar) {
            this.aps = nVar;
            this.apr = aVar;
        }

        public final void R(String str) {
            this.apq = this.aps.api.a(this.aps.agT, str, this.apr.jY(), this.apn, 129);
            if (this.apq) {
                this.mState = 3;
                return;
            }
            try {
                this.aps.api.a(this.aps.agT, this.apn);
            } catch (IllegalArgumentException e) {
            }
        }

        public final void a(ServiceConnection serviceConnection, String str) {
            this.aps.api.a(this.aps.agT, serviceConnection, str, this.apr.jY(), 3);
            this.apo.add(serviceConnection);
        }

        public final boolean a(ServiceConnection serviceConnection) {
            return this.apo.contains(serviceConnection);
        }

        public final boolean jZ() {
            return this.apo.isEmpty();
        }
    }

    n(Context context) {
        this.agT = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.api = com.google.android.gms.common.stats.b.kr();
        this.apj = 5000;
    }

    private void a(a aVar, ServiceConnection serviceConnection) {
        w.h(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.aph) {
            b bVar = (b) this.aph.get(aVar);
            if (bVar == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + aVar);
            } else if (bVar.a(serviceConnection)) {
                bVar.aps.api.a(bVar.aps.agT, serviceConnection, null, null, 4);
                bVar.apo.remove(serviceConnection);
                if (bVar.jZ()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, bVar), this.apj);
                }
            } else {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + aVar);
            }
        }
    }

    private boolean a(a aVar, ServiceConnection serviceConnection, String str) {
        boolean z;
        w.h(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.aph) {
            b bVar = (b) this.aph.get(aVar);
            if (bVar != null) {
                this.mHandler.removeMessages(0, bVar);
                if (!bVar.a(serviceConnection)) {
                    bVar.a(serviceConnection, str);
                    switch (bVar.mState) {
                        case 1:
                            serviceConnection.onServiceConnected(bVar.apm, bVar.anH);
                            break;
                        case 2:
                            bVar.R(str);
                            break;
                        default:
                            break;
                    }
                }
                throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + aVar);
            }
            bVar = new b(this, aVar);
            bVar.a(serviceConnection, str);
            bVar.R(str);
            this.aph.put(aVar, bVar);
            z = bVar.apq;
        }
        return z;
    }

    public final boolean a(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return a(new a(componentName), serviceConnection, str);
    }

    public final boolean a(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return a(new a(str, str2), serviceConnection, str3);
    }

    public final void b(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        a(new a(componentName), serviceConnection);
    }

    public final void b(String str, String str2, ServiceConnection serviceConnection, String str3) {
        a(new a(str, str2), serviceConnection);
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                b bVar = (b) message.obj;
                synchronized (this.aph) {
                    if (bVar.jZ()) {
                        if (bVar.apq) {
                            bVar.aps.api.a(bVar.aps.agT, bVar.apn);
                            bVar.apq = false;
                            bVar.mState = 2;
                        }
                        this.aph.remove(bVar.apr);
                    }
                }
                return true;
            default:
                return false;
        }
    }
}
