package com.tencent.mm.v;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.j.c.a;
import com.tencent.mm.protocal.l.c;

public abstract class i implements p {
    private c czA;
    public boolean czB = false;

    public abstract c zd();

    public final c Bx() {
        if (this.czA == null) {
            this.czA = zd();
            c cVar = this.czA;
            cVar.lWP = com.tencent.mm.compatible.d.p.rK();
            cVar.lWO = d.cmW;
            cVar.lWN = d.lWh;
            cVar.cW(a.lWC.zb());
        }
        return this.czA;
    }

    public int Bu() {
        return 0;
    }

    public boolean By() {
        return this.czB;
    }
}
