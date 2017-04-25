package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class cq extends a {
    public int mdb;
    public int mdc;
    public int mdd;
    public int mde;
    public int mdf;
    public int mdg;
    public int mdh;
    public int mdi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mdb);
            aVar.dV(2, this.mdc);
            aVar.dV(3, this.mdd);
            aVar.dV(4, this.mde);
            aVar.dV(5, this.mdf);
            aVar.dV(6, this.mdg);
            aVar.dV(7, this.mdh);
            aVar.dV(8, this.mdi);
            return 0;
        } else if (i == 1) {
            return (((((((a.a.a.a.dS(1, this.mdb) + 0) + a.a.a.a.dS(2, this.mdc)) + a.a.a.a.dS(3, this.mdd)) + a.a.a.a.dS(4, this.mde)) + a.a.a.a.dS(5, this.mdf)) + a.a.a.a.dS(6, this.mdg)) + a.a.a.a.dS(7, this.mdh)) + a.a.a.a.dS(8, this.mdi);
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
                cq cqVar = (cq) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cqVar.mdb = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        cqVar.mdc = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        cqVar.mdd = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        cqVar.mde = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        cqVar.mdf = aVar3.pMj.mH();
                        return 0;
                    case 6:
                        cqVar.mdg = aVar3.pMj.mH();
                        return 0;
                    case 7:
                        cqVar.mdh = aVar3.pMj.mH();
                        return 0;
                    case 8:
                        cqVar.mdi = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
