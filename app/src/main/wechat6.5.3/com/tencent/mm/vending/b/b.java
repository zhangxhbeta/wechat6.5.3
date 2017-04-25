package com.tencent.mm.vending.b;

import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class b<_Callback> implements a {
    public d aQW;
    private int mPriority = -1;
    private a pgW;
    public _Callback pgX;
    private int pgY;

    public final b<_Callback> c(com.tencent.mm.vending.e.b bVar) {
        Assert.assertNotNull(bVar);
        bVar.a(this);
        return this;
    }

    public b(_Callback _Callback, a aVar) {
        Assert.assertNotNull("Callback should not be null!", _Callback);
        this.pgY = _Callback.hashCode();
        this.pgX = _Callback;
        this.pgW = aVar;
    }

    public final int hashCode() {
        return this.pgY;
    }

    public final boolean equals(Object obj) {
        return obj != null && obj.hashCode() == this.pgY;
    }

    public final void dead() {
        Assert.assertNotNull(this.pgW);
        this.pgW.b(this);
    }
}
