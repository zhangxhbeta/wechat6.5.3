package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bh extends a {
    public int efm;
    public int mbJ;
    public int mbK;
    public int mbL;
    public int mbM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mbJ);
            aVar.dV(2, this.efm);
            aVar.dV(3, this.mbK);
            aVar.dV(4, this.mbL);
            aVar.dV(5, this.mbM);
            return 0;
        } else if (i == 1) {
            return ((((a.a.a.a.dS(1, this.mbJ) + 0) + a.a.a.a.dS(2, this.efm)) + a.a.a.a.dS(3, this.mbK)) + a.a.a.a.dS(4, this.mbL)) + a.a.a.a.dS(5, this.mbM);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                bh bhVar = (bh) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bhVar.mbJ = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        bhVar.efm = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        bhVar.mbK = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        bhVar.mbL = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        bhVar.mbM = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
