package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.w;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class o implements c {
    private final int akM;
    private final int akN;
    final Looper akP;
    final com.google.android.gms.common.b akQ;
    final com.google.android.gms.common.api.a.a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> akR;
    final h alI;
    final Map<a<?>, Integer> alJ;
    final Condition alZ;
    final Lock alt = new ReentrantLock();
    final l ama;
    final Queue<e<?>> amb = new LinkedList();
    volatile boolean amc;
    long amd = 120000;
    long ame = 5000;
    final a amf;
    BroadcastReceiver amg;
    final Map<com.google.android.gms.common.api.a.c<?>, com.google.android.gms.common.api.a.b> amh = new HashMap();
    final Map<com.google.android.gms.common.api.a.c<?>, ConnectionResult> ami = new HashMap();
    Set<Scope> amj = new HashSet();
    volatile p amk;
    private ConnectionResult aml = null;
    private final Set<r<?>> amm = Collections.newSetFromMap(new WeakHashMap());
    final Set<e<?>> amn = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    final d amo = new d(this) {
        final /* synthetic */ o amr;

        {
            this.amr = r1;
        }

        public final void b(e<?> eVar) {
            this.amr.amn.remove(eVar);
        }
    };
    private final com.google.android.gms.common.api.c.b amp = new com.google.android.gms.common.api.c.b(this) {
        final /* synthetic */ o amr;

        {
            this.amr = r1;
        }

        public final void bH(int i) {
            this.amr.alt.lock();
            try {
                this.amr.amk.bH(i);
            } finally {
                this.amr.alt.unlock();
            }
        }

        public final void g(Bundle bundle) {
            this.amr.alt.lock();
            try {
                this.amr.amk.g(bundle);
            } finally {
                this.amr.alt.unlock();
            }
        }
    };
    private final com.google.android.gms.common.internal.l.a amq = new com.google.android.gms.common.internal.l.a(this) {
        final /* synthetic */ o amr;

        {
            this.amr = r1;
        }

        public final boolean isConnected() {
            return this.amr.amk instanceof l;
        }
    };
    final Context mContext;

    final class a extends Handler {
        final /* synthetic */ o amr;

        a(o oVar, Looper looper) {
            this.amr = oVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    o oVar = this.amr;
                    oVar.alt.lock();
                    try {
                        if (oVar.jC()) {
                            oVar.connect();
                        }
                        oVar.alt.unlock();
                        return;
                    } catch (Throwable th) {
                        oVar.alt.unlock();
                    }
                case 2:
                    o.a(this.amr);
                    return;
                case 3:
                    ((b) message.obj).b(this.amr);
                    return;
                case 4:
                    throw ((RuntimeException) message.obj);
                default:
                    new StringBuilder("Unknown message id: ").append(message.what);
                    return;
            }
        }
    }

    static abstract class b {
        private final p amu;

        protected b(p pVar) {
            this.amu = pVar;
        }

        public final void b(o oVar) {
            oVar.alt.lock();
            try {
                if (oVar.amk == this.amu) {
                    js();
                    oVar.alt.unlock();
                }
            } finally {
                oVar.alt.unlock();
            }
        }

        protected abstract void js();
    }

    private static class c extends BroadcastReceiver {
        private WeakReference<o> amv;

        c(o oVar) {
            this.amv = new WeakReference(oVar);
        }

        public final void onReceive(Context context, Intent intent) {
            Uri data = intent.getData();
            String str = null;
            if (data != null) {
                str = data.getSchemeSpecificPart();
            }
            if (str != null && str.equals("com.google.android.gms")) {
                o oVar = (o) this.amv.get();
                if (oVar != null) {
                    o.a(oVar);
                }
            }
        }
    }

    interface d {
        void b(e<?> eVar);
    }

    interface e<A extends com.google.android.gms.common.api.a.b> {
        void a(Status status);

        void a(A a);

        void a(d dVar);

        void c(Status status);

        void cancel();

        com.google.android.gms.common.api.a.c<A> jb();
    }

    public o(Context context, Looper looper, h hVar, com.google.android.gms.common.b bVar, com.google.android.gms.common.api.a.a<? extends com.google.android.gms.signin.d, com.google.android.gms.signin.e> aVar, Map<a<?>, Object> map, ArrayList<com.google.android.gms.common.api.c.b> arrayList, ArrayList<com.google.android.gms.common.api.c.c> arrayList2, int i, int i2) {
        this.mContext = context;
        this.ama = new l(looper, this.amq);
        this.akP = looper;
        this.amf = new a(this, looper);
        this.akQ = bVar;
        this.akM = i;
        this.akN = i2;
        this.alJ = new HashMap();
        this.alZ = this.alt.newCondition();
        this.amk = new n(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.ama.a((com.google.android.gms.common.api.c.b) it.next());
        }
        it = arrayList2.iterator();
        while (it.hasNext()) {
            this.ama.a((com.google.android.gms.common.api.c.c) it.next());
        }
        Map map2 = hVar.aoz;
        for (a aVar2 : map.keySet()) {
            int i3;
            Object cVar;
            Object obj = map.get(aVar2);
            if (map2.get(aVar2) != null) {
                i3 = ((com.google.android.gms.common.internal.h.a) map2.get(aVar2)).aoC ? 1 : 2;
            } else {
                i3 = 0;
            }
            this.alJ.put(aVar2, Integer.valueOf(i3));
            if ((aVar2.akD != null ? 1 : null) != null) {
                w.a(aVar2.akB != null, "This API was constructed with a ClientBuilder. Use getClientBuilder");
                com.google.android.gms.common.api.a.e eVar = aVar2.akB;
                cVar = new com.google.android.gms.common.internal.c(context, looper, eVar.jj(), this.amp, a(aVar2, i3), hVar, eVar.ji());
            } else {
                cVar = aVar2.ja().a(context, looper, hVar, obj, this.amp, a(aVar2, i3));
            }
            this.amh.put(aVar2.jb(), cVar);
        }
        this.alI = hVar;
        this.akR = aVar;
    }

    private final com.google.android.gms.common.api.c.c a(final a<?> aVar, final int i) {
        return new com.google.android.gms.common.api.c.c(this) {
            final /* synthetic */ o amr;

            public final void a(ConnectionResult connectionResult) {
                this.amr.alt.lock();
                try {
                    this.amr.amk.a(connectionResult, aVar, i);
                } finally {
                    this.amr.alt.unlock();
                }
            }
        };
    }

    static /* synthetic */ void a(o oVar) {
        oVar.alt.lock();
        try {
            if (oVar.amc) {
                oVar.connect();
            }
            oVar.alt.unlock();
        } catch (Throwable th) {
            oVar.alt.unlock();
        }
    }

    public final ConnectionResult a(TimeUnit timeUnit) {
        ConnectionResult connectionResult;
        w.a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.alt.lock();
        try {
            connect();
            long toNanos = timeUnit.toNanos(30);
            while (this.amk instanceof m) {
                toNanos = this.alZ.awaitNanos(toNanos);
                if (toNanos <= 0) {
                    connectionResult = new ConnectionResult(14, null);
                    break;
                }
            }
            if (this.amk instanceof l) {
                connectionResult = ConnectionResult.akm;
                this.alt.unlock();
            } else if (this.aml != null) {
                connectionResult = this.aml;
                this.alt.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.alt.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.alt.unlock();
        }
        return connectionResult;
    }

    public final <A extends com.google.android.gms.common.api.a.b, R extends g, T extends com.google.android.gms.common.api.k.a<R, A>> T a(T t) {
        w.b(t.akC != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        w.b(this.amh.containsKey(t.akC), "GoogleApiClient is not configured to use the API required for this call.");
        this.alt.lock();
        try {
            T a = this.amk.a(t);
            return a;
        } finally {
            this.alt.unlock();
        }
    }

    public final void a(com.google.android.gms.common.api.c.b bVar) {
        this.ama.a(bVar);
    }

    public final void a(com.google.android.gms.common.api.c.c cVar) {
        this.ama.a(cVar);
    }

    final void a(b bVar) {
        this.amf.sendMessage(this.amf.obtainMessage(3, bVar));
    }

    public final void a(String str, PrintWriter printWriter) {
        printWriter.append(str).append("mState=").append(this.amk.getName());
        printWriter.append(" mResuming=").print(this.amc);
        printWriter.append(" mWorkQueue.size()=").print(this.amb.size());
        printWriter.append(" mUnconsumedRunners.size()=").println(this.amn.size());
        String str2 = str + "  ";
        for (a aVar : this.alJ.keySet()) {
            printWriter.append(str).append(aVar.mName).println(":");
            ((com.google.android.gms.common.api.a.b) this.amh.get(aVar.jb())).a(str2, printWriter);
        }
    }

    public final void b(com.google.android.gms.common.api.c.b bVar) {
        l lVar = this.ama;
        w.Z(bVar);
        synchronized (lVar.aoG) {
            if (!lVar.aoZ.remove(bVar)) {
                new StringBuilder("unregisterConnectionCallbacks(): listener ").append(bVar).append(" not found");
            } else if (lVar.ape) {
                lVar.apa.add(bVar);
            }
        }
    }

    public final void b(com.google.android.gms.common.api.c.c cVar) {
        l lVar = this.ama;
        w.Z(cVar);
        synchronized (lVar.aoG) {
            if (!lVar.apb.remove(cVar)) {
                new StringBuilder("unregisterConnectionFailedListener(): listener ").append(cVar).append(" not found");
            }
        }
    }

    public final void connect() {
        this.alt.lock();
        try {
            this.amk.connect();
        } finally {
            this.alt.unlock();
        }
    }

    public final void disconnect() {
        this.alt.lock();
        try {
            jC();
            this.amk.disconnect();
        } finally {
            this.alt.unlock();
        }
    }

    final void f(ConnectionResult connectionResult) {
        this.alt.lock();
        try {
            this.aml = connectionResult;
            this.amk = new n(this);
            this.amk.begin();
            this.alZ.signalAll();
        } finally {
            this.alt.unlock();
        }
    }

    public final Looper getLooper() {
        return this.akP;
    }

    public final boolean isConnected() {
        return this.amk instanceof l;
    }

    public final boolean isConnecting() {
        return this.amk instanceof m;
    }

    final void jB() {
        for (e eVar : this.amn) {
            eVar.a(null);
            eVar.cancel();
        }
        this.amn.clear();
        for (r rVar : this.amm) {
            rVar.amx = null;
        }
        this.amm.clear();
    }

    final boolean jC() {
        if (!this.amc) {
            return false;
        }
        this.amc = false;
        this.amf.removeMessages(2);
        this.amf.removeMessages(1);
        if (this.amg != null) {
            this.mContext.getApplicationContext().unregisterReceiver(this.amg);
            this.amg = null;
        }
        return true;
    }
}
