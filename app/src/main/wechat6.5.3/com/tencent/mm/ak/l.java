package com.tencent.mm.ak;

import com.tencent.mm.ak.j.b;
import com.tencent.mm.protocal.c.aiu;
import com.tencent.mm.protocal.c.nh;
import com.tencent.mm.protocal.c.ni;

@Deprecated
public final class l extends b {
    private aiu cTI;

    public l(boolean z, int i, int i2) {
        int i3 = 1;
        super(31);
        this.cTI = new aiu();
        nh nhVar = new nh();
        nhVar.mpg = z ? 1 : 0;
        if (z) {
            i3 = 0;
        }
        nhVar.mpi = i3;
        ni niVar = new ni();
        niVar.mpk = i;
        niVar.mpl = i2;
        nhVar.mph = niVar;
        niVar.mpk = 0;
        niVar.mpl = 0;
        nhVar.mpj = niVar;
        this.cTI.mJr = nhVar;
        this.cTG = this.cTI;
    }

    public l() {
        this(false, 22, 8);
    }
}
