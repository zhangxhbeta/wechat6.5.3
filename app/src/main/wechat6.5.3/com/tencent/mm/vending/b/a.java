package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import com.tencent.mm.vending.h.f;
import com.tencent.mm.vending.h.g;
import java.util.LinkedList;
import junit.framework.Assert;

public abstract class a<_Callback> {
    protected d aQW;
    private LinkedList<b> pgU;
    public f pgV;

    public a() {
        this(g.bKQ());
    }

    public a(d dVar) {
        this.pgU = new LinkedList();
        Assert.assertNotNull(dVar);
        this.aQW = dVar;
        this.pgV = new f(dVar, null);
    }

    public final synchronized b a(b bVar) {
        this.pgU.add(bVar);
        return bVar;
    }

    public final synchronized void b(b bVar) {
        if (bVar != null) {
            this.pgU.remove(bVar);
        }
    }

    public final synchronized LinkedList<b> bKF() {
        return new LinkedList(this.pgU);
    }

    public final synchronized int size() {
        return this.pgU.size();
    }

    public final synchronized boolean contains(_Callback _Callback) {
        return this.pgU.contains(new b(_Callback, this));
    }
}
