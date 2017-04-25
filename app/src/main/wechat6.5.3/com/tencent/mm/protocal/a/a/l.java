package com.tencent.mm.protocal.a.a;

import com.tencent.mm.ba.a;

public final class l extends a {
    public int action;
    public int lYb;
    public int lYc;
    public int lYd;
    public int lYe;
    public int lYf;
    public int lYg;
    public int lYh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.lYb);
            aVar.dV(2, this.action);
            aVar.dV(3, this.lYc);
            aVar.dV(4, this.lYd);
            aVar.dV(5, this.lYe);
            aVar.dV(6, this.lYf);
            aVar.dV(7, this.lYg);
            aVar.dV(8, this.lYh);
            return 0;
        } else if (i == 1) {
            return (((((((a.a.a.a.dS(1, this.lYb) + 0) + a.a.a.a.dS(2, this.action)) + a.a.a.a.dS(3, this.lYc)) + a.a.a.a.dS(4, this.lYd)) + a.a.a.a.dS(5, this.lYe)) + a.a.a.a.dS(6, this.lYf)) + a.a.a.a.dS(7, this.lYg)) + a.a.a.a.dS(8, this.lYh);
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
                l lVar = (l) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        lVar.lYb = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        lVar.action = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        lVar.lYc = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        lVar.lYd = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        lVar.lYe = aVar3.pMj.mH();
                        return 0;
                    case 6:
                        lVar.lYf = aVar3.pMj.mH();
                        return 0;
                    case 7:
                        lVar.lYg = aVar3.pMj.mH();
                        return 0;
                    case 8:
                        lVar.lYh = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
