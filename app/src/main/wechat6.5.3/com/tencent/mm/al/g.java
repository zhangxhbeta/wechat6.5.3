package com.tencent.mm.al;

import com.tencent.mm.ba.a;

public final class g extends a {
    public int cTZ;
    public int cUl;
    public int cUm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.cTZ);
            aVar.dV(2, this.cUl);
            aVar.dV(3, this.cUm);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.dS(1, this.cTZ) + 0) + a.a.a.a.dS(2, this.cUl)) + a.a.a.a.dS(3, this.cUm);
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
                g gVar = (g) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        gVar.cTZ = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        gVar.cUl = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        gVar.cUm = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
