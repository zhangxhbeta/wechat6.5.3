package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class lp extends a {
    public int eeO;
    public int mbT;
    public long mcb;
    public String mon;
    public int moo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mbT);
            if (this.mon != null) {
                aVar.e(2, this.mon);
            }
            aVar.dV(3, this.eeO);
            aVar.dV(4, this.moo);
            aVar.C(5, this.mcb);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mbT) + 0;
            if (this.mon != null) {
                r0 += a.a.a.b.b.a.f(2, this.mon);
            }
            return ((r0 + a.a.a.a.dS(3, this.eeO)) + a.a.a.a.dS(4, this.moo)) + a.a.a.a.B(5, this.mcb);
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
            lp lpVar = (lp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lpVar.mbT = aVar3.pMj.mH();
                    return 0;
                case 2:
                    lpVar.mon = aVar3.pMj.readString();
                    return 0;
                case 3:
                    lpVar.eeO = aVar3.pMj.mH();
                    return 0;
                case 4:
                    lpVar.moo = aVar3.pMj.mH();
                    return 0;
                case 5:
                    lpVar.mcb = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
