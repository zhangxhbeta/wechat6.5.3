package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class n extends a<n> {
    public int pAw;
    public int pBj;
    public int pBk;

    public final /* synthetic */ int compareTo(Object obj) {
        n nVar = (n) obj;
        if (this.pBj != nVar.pBj) {
            return c.dK(this.pBj, nVar.pBj);
        }
        return this.pBk != nVar.pBk ? c.dK(this.pBk, nVar.pBk) : c.dK(this.pAw, nVar.pAw);
    }

    public n(int i, int i2, int i3, int i4) {
        super(i);
        this.pBj = i2;
        this.pAw = i3;
        this.pBk = i4;
    }
}
