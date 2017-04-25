package com.tencent.mm.vending.h;

import android.os.Looper;
import com.tencent.mm.vending.i.a;
import com.tencent.mm.vending.i.b;

public abstract class d {
    public static final h phX = new h(Looper.getMainLooper(), "Vending.UI");
    public static final h phY = new h(b.bKT().pii.getLooper(), "Vending.LOGIC");
    public static final h phZ = new h(a.bKS().pig.getLooper(), "Vending.HEAVY_WORK");

    public abstract void cancel();

    public abstract void d(Runnable runnable, long j);

    public abstract void g(Runnable runnable);

    public abstract String getType();

    static {
        g.bKR();
    }

    public static synchronized d bKQ() {
        d bKQ;
        synchronized (d.class) {
            bKQ = g.bKQ();
        }
        return bKQ;
    }
}
