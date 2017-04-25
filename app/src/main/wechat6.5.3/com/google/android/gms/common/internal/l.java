package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.c.b;
import com.google.android.gms.common.api.c.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class l implements Callback {
    public final Object aoG = new Object();
    public final a aoY;
    public final ArrayList<b> aoZ = new ArrayList();
    public final ArrayList<b> apa = new ArrayList();
    public final ArrayList<c> apb = new ArrayList();
    public volatile boolean apc = false;
    public final AtomicInteger apd = new AtomicInteger(0);
    public boolean ape = false;
    public final Handler mHandler;

    public interface a {
        boolean isConnected();
    }

    public l(Looper looper, a aVar) {
        this.aoY = aVar;
        this.mHandler = new Handler(looper, this);
    }

    public final void a(b bVar) {
        w.Z(bVar);
        synchronized (this.aoG) {
            if (this.aoZ.contains(bVar)) {
                new StringBuilder("registerConnectionCallbacks(): listener ").append(bVar).append(" is already registered");
            } else {
                this.aoZ.add(bVar);
            }
        }
        if (this.aoY.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, bVar));
        }
    }

    public final void a(c cVar) {
        w.Z(cVar);
        synchronized (this.aoG) {
            if (this.apb.contains(cVar)) {
                new StringBuilder("registerConnectionFailedListener(): listener ").append(cVar).append(" is already registered");
            } else {
                this.apb.add(cVar);
            }
        }
    }

    public final void bN(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            z = true;
        }
        w.a(z, "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.aoG) {
            this.ape = true;
            ArrayList arrayList = new ArrayList(this.aoZ);
            int i2 = this.apd.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (this.apc && this.apd.get() == i2) {
                    if (this.aoZ.contains(bVar)) {
                        bVar.bH(i);
                    }
                }
            }
            this.apa.clear();
            this.ape = false;
        }
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            b bVar = (b) message.obj;
            synchronized (this.aoG) {
                if (this.apc && this.aoY.isConnected() && this.aoZ.contains(bVar)) {
                    bVar.g(null);
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        return false;
    }

    public final void jX() {
        this.apc = false;
        this.apd.incrementAndGet();
    }
}
