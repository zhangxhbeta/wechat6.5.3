package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class f extends a<f> {
    public int pAA;
    public int pAB;
    public int pAC;
    public int pAt;
    public int pAw;
    public int pAx;
    public int pAy;
    public int pAz;

    public final /* synthetic */ int compareTo(Object obj) {
        f fVar = (f) obj;
        int dK = c.dK(this.pAw, fVar.pAw);
        if (dK != 0) {
            return dK;
        }
        dK = c.dL(this.pAt, fVar.pAt);
        if (dK != 0) {
            return dK;
        }
        dK = c.dK(this.pAx, fVar.pAx);
        if (dK != 0) {
            return dK;
        }
        dK = c.dL(this.pAy, fVar.pAy);
        if (dK != 0) {
            return dK;
        }
        dK = c.dK(this.pAz, fVar.pAz);
        if (dK != 0) {
            return dK;
        }
        dK = c.dL(this.pAA, fVar.pAA);
        if (dK != 0) {
            return dK;
        }
        dK = c.dL(this.pAB, fVar.pAB);
        return dK == 0 ? c.dL(this.pAC, fVar.pAC) : dK;
    }

    public f(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        super(i);
        this.pAw = i2;
        this.pAt = i3;
        this.pAx = i4;
        this.pAy = i5;
        this.pAz = i6;
        this.pAA = i7;
        this.pAB = i8;
        this.pAC = i9;
    }
}
