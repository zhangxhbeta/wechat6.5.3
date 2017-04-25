package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class r extends a<r> {
    public int pBm;
    public int pBn;
    public int pBo;

    public final /* synthetic */ int compareTo(Object obj) {
        r rVar = (r) obj;
        int dK = c.dK(this.pBm, rVar.pBm);
        if (dK != 0) {
            return dK;
        }
        dK = c.dK(this.pBn, rVar.pBn);
        return dK == 0 ? c.dL(this.pBo, rVar.pBo) : dK;
    }

    public r(int i, int i2, int i3, int i4) {
        super(i);
        this.pBm = i2;
        this.pBn = i3;
        this.pBo = i4;
    }
}
