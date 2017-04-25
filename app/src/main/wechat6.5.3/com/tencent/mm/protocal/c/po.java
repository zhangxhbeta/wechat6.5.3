package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class po extends a {
    public String gkB;
    public long iuq;
    public int mru;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.C(1, this.iuq);
            if (this.gkB != null) {
                aVar.e(2, this.gkB);
            }
            aVar.dV(3, this.mru);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.B(1, this.iuq) + 0;
            if (this.gkB != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkB);
            }
            return r0 + a.a.a.a.dS(3, this.mru);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            po poVar = (po) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    poVar.iuq = aVar3.pMj.mI();
                    return 0;
                case 2:
                    poVar.gkB = aVar3.pMj.readString();
                    return 0;
                case 3:
                    poVar.mru = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
