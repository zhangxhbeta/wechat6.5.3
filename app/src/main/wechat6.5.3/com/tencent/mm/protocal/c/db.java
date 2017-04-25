package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class db extends a {
    public int mdC;
    public int mdD;
    public int mdE;
    public int mdF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mdC);
            aVar.dV(2, this.mdD);
            aVar.dV(3, this.mdE);
            aVar.dV(4, this.mdF);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.dS(1, this.mdC) + 0) + a.a.a.a.dS(2, this.mdD)) + a.a.a.a.dS(3, this.mdE)) + a.a.a.a.dS(4, this.mdF);
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
                db dbVar = (db) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        dbVar.mdC = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        dbVar.mdD = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        dbVar.mdE = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        dbVar.mdF = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
