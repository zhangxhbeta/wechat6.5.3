package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class qd extends a {
    public int eeO;
    public int mbJ;
    public int mbK;
    public int mbL;
    public int mbM;
    public String mbQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mbJ);
            aVar.dV(2, this.eeO);
            if (this.mbQ != null) {
                aVar.e(3, this.mbQ);
            }
            aVar.dV(4, this.mbK);
            aVar.dV(5, this.mbL);
            aVar.dV(6, this.mbM);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.dS(1, this.mbJ) + 0) + a.a.a.a.dS(2, this.eeO);
            if (this.mbQ != null) {
                r0 += a.a.a.b.b.a.f(3, this.mbQ);
            }
            return ((r0 + a.a.a.a.dS(4, this.mbK)) + a.a.a.a.dS(5, this.mbL)) + a.a.a.a.dS(6, this.mbM);
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
            qd qdVar = (qd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qdVar.mbJ = aVar3.pMj.mH();
                    return 0;
                case 2:
                    qdVar.eeO = aVar3.pMj.mH();
                    return 0;
                case 3:
                    qdVar.mbQ = aVar3.pMj.readString();
                    return 0;
                case 4:
                    qdVar.mbK = aVar3.pMj.mH();
                    return 0;
                case 5:
                    qdVar.mbL = aVar3.pMj.mH();
                    return 0;
                case 6:
                    qdVar.mbM = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
