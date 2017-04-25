package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class r extends a {
    public long lYE;
    public String lYO;
    public long lYP;
    public int lYQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.lYO != null) {
                aVar.e(1, this.lYO);
            }
            aVar.C(2, this.lYE);
            aVar.C(3, this.lYP);
            aVar.dV(4, this.lYQ);
            return 0;
        } else if (i == 1) {
            if (this.lYO != null) {
                r0 = a.a.a.b.b.a.f(1, this.lYO) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + a.a.a.a.B(2, this.lYE)) + a.a.a.a.B(3, this.lYP)) + a.a.a.a.dS(4, this.lYQ);
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
            r rVar = (r) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rVar.lYO = aVar3.pMj.readString();
                    return 0;
                case 2:
                    rVar.lYE = aVar3.pMj.mI();
                    return 0;
                case 3:
                    rVar.lYP = aVar3.pMj.mI();
                    return 0;
                case 4:
                    rVar.lYQ = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
