package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class j<R extends g> implements e<R> {
    private final Object alg = new Object();
    protected final a<R> alh;
    private final CountDownLatch ali = new CountDownLatch(1);
    private final ArrayList<Object> alj = new ArrayList();
    private h<R> alk;
    private volatile R all;
    private volatile boolean alm;
    private boolean aln;
    private boolean alo;
    private q alp;

    public static class a<R extends g> extends Handler {
        public a() {
            this(Looper.getMainLooper());
        }

        public a(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    Object obj = pair.first;
                    Object obj2 = pair.second;
                    return;
                case 2:
                    ((j) message.obj).a(Status.ald);
                    return;
                default:
                    Log.wtf("AbstractPendingResult", "Don't know how to handle this message.");
                    return;
            }
        }
    }

    protected j(Looper looper) {
        this.alh = new a(looper);
    }

    private void b(R r) {
        this.all = r;
        this.alp = null;
        this.ali.countDown();
        g gVar = this.all;
        if (this.alk != null) {
            this.alh.removeMessages(2);
            if (!this.aln) {
                a aVar = this.alh;
                aVar.sendMessage(aVar.obtainMessage(1, new Pair(this.alk, jr())));
            }
        }
        Iterator it = this.alj.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.alj.clear();
    }

    private static void c(g gVar) {
        if (gVar instanceof f) {
            try {
                ((f) gVar).release();
            } catch (RuntimeException e) {
                new StringBuilder("Unable to release ").append(gVar);
            }
        }
    }

    private boolean jp() {
        return this.ali.getCount() == 0;
    }

    private R jr() {
        R r;
        boolean z = true;
        synchronized (this.alg) {
            if (this.alm) {
                z = false;
            }
            w.a(z, "Result has already been consumed.");
            w.a(jp(), "Result is not ready.");
            r = this.all;
            this.all = null;
            this.alk = null;
            this.alm = true;
        }
        jq();
        return r;
    }

    public final void a(Status status) {
        synchronized (this.alg) {
            if (!jp()) {
                a(b(status));
                this.alo = true;
            }
        }
    }

    public final void a(R r) {
        boolean z = true;
        synchronized (this.alg) {
            if (this.alo || this.aln) {
                c(r);
                return;
            }
            w.a(!jp(), "Results have already been set");
            if (this.alm) {
                z = false;
            }
            w.a(z, "Result has already been consumed");
            b((g) r);
        }
    }

    public abstract R b(Status status);

    public final R b(TimeUnit timeUnit) {
        boolean z = true;
        boolean z2 = 2 <= 0 || Looper.myLooper() != Looper.getMainLooper();
        w.a(z2, "await must not be called on the UI thread when time is greater than zero.");
        if (this.alm) {
            z = false;
        }
        w.a(z, "Result has already been consumed.");
        try {
            if (!this.ali.await(2, timeUnit)) {
                a(Status.ald);
            }
        } catch (InterruptedException e) {
            a(Status.alb);
        }
        w.a(jp(), "Result is not ready.");
        return jr();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cancel() {
        /*
        r2 = this;
        r1 = r2.alg;
        monitor-enter(r1);
        r0 = r2.aln;	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.alm;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.all;	 Catch:{ all -> 0x0023 }
        c(r0);	 Catch:{ all -> 0x0023 }
        r0 = 0;
        r2.alk = r0;	 Catch:{ all -> 0x0023 }
        r0 = 1;
        r2.aln = r0;	 Catch:{ all -> 0x0023 }
        r0 = com.google.android.gms.common.api.Status.ale;	 Catch:{ all -> 0x0023 }
        r0 = r2.b(r0);	 Catch:{ all -> 0x0023 }
        r2.b(r0);	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x000c;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.j.cancel():void");
    }

    public final R jn() {
        boolean z = true;
        w.a(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
        if (this.alm) {
            z = false;
        }
        w.a(z, "Result has already been consumed");
        try {
            this.ali.await();
        } catch (InterruptedException e) {
            a(Status.alb);
        }
        w.a(jp(), "Result is not ready.");
        return jr();
    }

    protected void jq() {
    }
}
