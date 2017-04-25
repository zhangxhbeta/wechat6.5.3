package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.v.k;

public abstract class e extends k implements j {
    protected boolean iQe = false;
    long iQf = 0;

    public abstract aqx aOr();

    public e(long j) {
        this.iQf = j;
    }

    public final boolean aOq() {
        return this.iQe;
    }
}
