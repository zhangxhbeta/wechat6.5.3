package com.c.a.a;

import android.content.Context;
import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedList;

abstract class d {
    boolean aHp;
    private Context aHq;
    private Collection<WeakReference<m>> aHr;
    private a aHs;
    boolean isReady;
    private Handler mHandler;

    static class a {
        final long aHt;

        a(long j) {
            this.aHt = Math.max(j, 0);
        }
    }

    abstract void N(Context context);

    abstract void O(Context context);

    abstract void a(Context context, Handler handler, a aVar);

    abstract void na();

    d() {
    }

    final void c(p pVar) {
        if (this.aHp && this.aHr != null) {
            for (WeakReference weakReference : this.aHr) {
                m mVar = (m) weakReference.get();
                if (mVar != null) {
                    mVar.a(pVar);
                }
            }
        }
    }

    final synchronized void a(Context context, m... mVarArr) {
        if (context == null) {
            throw new Exception("Module: context cannot be null");
        }
        nd();
        b(context.getApplicationContext(), mVarArr);
        this.isReady = true;
    }

    final synchronized void nd() {
        if (this.isReady) {
            stop();
            na();
            this.isReady = false;
        }
    }

    synchronized void a(Handler handler, a aVar) {
        stop();
        this.mHandler = handler;
        this.aHs = aVar;
        a(this.aHq, this.mHandler, this.aHs);
        this.aHp = true;
    }

    synchronized void stop() {
        if (this.aHp) {
            O(this.aHq);
            this.mHandler = null;
            this.aHs = null;
            this.aHp = false;
        }
    }

    private void b(Context context, m... mVarArr) {
        this.aHq = context;
        if (mVarArr == null) {
            this.aHr = null;
        } else {
            this.aHr = new LinkedList();
            for (Object weakReference : mVarArr) {
                this.aHr.add(new WeakReference(weakReference));
            }
        }
        N(context);
    }
}
