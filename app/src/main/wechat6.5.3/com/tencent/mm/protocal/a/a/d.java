package com.tencent.mm.protocal.a.a;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class d extends a {
    public int count;
    public int iOT;
    public int lXC;
    public b lXL;
    public int lXM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.lXL == null) {
                throw new a.a.a.b("Not all required fields were included: value");
            }
            aVar.dV(1, this.lXC);
            if (this.lXL != null) {
                aVar.b(2, this.lXL);
            }
            aVar.dV(3, this.lXM);
            aVar.dV(4, this.iOT);
            aVar.dV(5, this.count);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.lXC) + 0;
            if (this.lXL != null) {
                r0 += a.a.a.a.a(2, this.lXL);
            }
            return ((r0 + a.a.a.a.dS(3, this.lXM)) + a.a.a.a.dS(4, this.iOT)) + a.a.a.a.dS(5, this.count);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.lXL != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: value");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.lXC = aVar3.pMj.mH();
                    return 0;
                case 2:
                    dVar.lXL = aVar3.bQK();
                    return 0;
                case 3:
                    dVar.lXM = aVar3.pMj.mH();
                    return 0;
                case 4:
                    dVar.iOT = aVar3.pMj.mH();
                    return 0;
                case 5:
                    dVar.count = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
