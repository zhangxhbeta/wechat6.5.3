package com.tencent.mm.bf;

import com.tencent.mm.ba.a;

public final class c extends a {
    public int cyv;
    public int nnp;
    public int nnq;
    public int nnr;
    public int nns = -1;
    public int nnt;
    public int size;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.nnp);
            aVar.dV(2, this.nnq);
            aVar.dV(3, this.nnr);
            aVar.dV(41, this.nns);
            aVar.dV(5, this.nnt);
            aVar.dV(6, this.cyv);
            aVar.dV(7, this.size);
            return 0;
        } else if (i == 1) {
            return ((((((a.a.a.a.dS(1, this.nnp) + 0) + a.a.a.a.dS(2, this.nnq)) + a.a.a.a.dS(3, this.nnr)) + a.a.a.a.dS(41, this.nns)) + a.a.a.a.dS(5, this.nnt)) + a.a.a.a.dS(6, this.cyv)) + a.a.a.a.dS(7, this.size);
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
                c cVar = (c) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cVar.nnp = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        cVar.nnq = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        cVar.nnr = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        cVar.nnt = aVar3.pMj.mH();
                        return 0;
                    case 6:
                        cVar.cyv = aVar3.pMj.mH();
                        return 0;
                    case 7:
                        cVar.size = aVar3.pMj.mH();
                        return 0;
                    case 41:
                        cVar.nns = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
