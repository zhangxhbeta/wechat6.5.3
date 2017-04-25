package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class je extends a {
    public int eeO;
    public int mbL;
    public String mls;
    public long mlt;
    public int mlu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mls != null) {
                aVar.e(1, this.mls);
            }
            aVar.C(2, this.mlt);
            aVar.dV(3, this.mlu);
            aVar.dV(4, this.mbL);
            aVar.dV(5, this.eeO);
            return 0;
        } else if (i == 1) {
            if (this.mls != null) {
                r0 = a.a.a.b.b.a.f(1, this.mls) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + a.a.a.a.B(2, this.mlt)) + a.a.a.a.dS(3, this.mlu)) + a.a.a.a.dS(4, this.mbL)) + a.a.a.a.dS(5, this.eeO);
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
            je jeVar = (je) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jeVar.mls = aVar3.pMj.readString();
                    return 0;
                case 2:
                    jeVar.mlt = aVar3.pMj.mI();
                    return 0;
                case 3:
                    jeVar.mlu = aVar3.pMj.mH();
                    return 0;
                case 4:
                    jeVar.mbL = aVar3.pMj.mH();
                    return 0;
                case 5:
                    jeVar.eeO = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
