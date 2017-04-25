package com.tencent.mm.protocal.a.a;

import com.tencent.mm.ba.a;

public final class n extends a {
    public int lXC;
    public int lYl;
    public int lYm;
    public int lYn;
    public int lYo;
    public int lYp;
    public int lYq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.lXC);
            aVar.dV(2, this.lYl);
            aVar.dV(3, this.lYm);
            aVar.dV(4, this.lYn);
            aVar.dV(5, this.lYo);
            aVar.dV(6, this.lYp);
            aVar.dV(7, this.lYq);
            return 0;
        } else if (i == 1) {
            return ((((((a.a.a.a.dS(1, this.lXC) + 0) + a.a.a.a.dS(2, this.lYl)) + a.a.a.a.dS(3, this.lYm)) + a.a.a.a.dS(4, this.lYn)) + a.a.a.a.dS(5, this.lYo)) + a.a.a.a.dS(6, this.lYp)) + a.a.a.a.dS(7, this.lYq);
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
                n nVar = (n) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        nVar.lXC = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        nVar.lYl = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        nVar.lYm = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        nVar.lYn = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        nVar.lYo = aVar3.pMj.mH();
                        return 0;
                    case 6:
                        nVar.lYp = aVar3.pMj.mH();
                        return 0;
                    case 7:
                        nVar.lYq = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
