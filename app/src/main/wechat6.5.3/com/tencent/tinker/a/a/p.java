package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class p extends a<p> {
    public int pBj;
    public int pBk;
    public int pBl;

    public final /* synthetic */ int compareTo(Object obj) {
        p pVar = (p) obj;
        if (this.pBj != pVar.pBj) {
            return c.dK(this.pBj, pVar.pBj);
        }
        return this.pBk != pVar.pBk ? c.dK(this.pBk, pVar.pBk) : c.dK(this.pBl, pVar.pBl);
    }

    public p(int i, int i2, int i3, int i4) {
        super(i);
        this.pBj = i2;
        this.pBl = i3;
        this.pBk = i4;
    }
}
