package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class at extends a {
    public long endTime;
    public int jcb;
    public int jcc;
    public float mbi;
    public float mbj;
    public float mbk;
    public long mbl;
    public long mbm;
    public long mbn;
    public long mbo;
    public long startTime;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.jcb);
            aVar.dV(2, this.jcc);
            aVar.j(3, this.mbi);
            aVar.j(4, this.mbj);
            aVar.j(5, this.mbk);
            aVar.C(6, this.startTime);
            aVar.C(7, this.endTime);
            aVar.C(8, this.mbl);
            aVar.C(9, this.mbm);
            aVar.C(10, this.mbn);
            aVar.C(11, this.mbo);
            return 0;
        } else if (i == 1) {
            return ((((((((((a.a.a.a.dS(1, this.jcb) + 0) + a.a.a.a.dS(2, this.jcc)) + (a.a.a.b.b.a.cw(3) + 4)) + (a.a.a.b.b.a.cw(4) + 4)) + (a.a.a.b.b.a.cw(5) + 4)) + a.a.a.a.B(6, this.startTime)) + a.a.a.a.B(7, this.endTime)) + a.a.a.a.B(8, this.mbl)) + a.a.a.a.B(9, this.mbm)) + a.a.a.a.B(10, this.mbn)) + a.a.a.a.B(11, this.mbo);
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
                at atVar = (at) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        atVar.jcb = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        atVar.jcc = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        atVar.mbi = aVar3.pMj.readFloat();
                        return 0;
                    case 4:
                        atVar.mbj = aVar3.pMj.readFloat();
                        return 0;
                    case 5:
                        atVar.mbk = aVar3.pMj.readFloat();
                        return 0;
                    case 6:
                        atVar.startTime = aVar3.pMj.mI();
                        return 0;
                    case 7:
                        atVar.endTime = aVar3.pMj.mI();
                        return 0;
                    case 8:
                        atVar.mbl = aVar3.pMj.mI();
                        return 0;
                    case 9:
                        atVar.mbm = aVar3.pMj.mI();
                        return 0;
                    case 10:
                        atVar.mbn = aVar3.pMj.mI();
                        return 0;
                    case 11:
                        atVar.mbo = aVar3.pMj.mI();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
