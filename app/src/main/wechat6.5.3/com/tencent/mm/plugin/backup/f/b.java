package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.ba.a;

public final class b extends a {
    public int cNp;
    public int ehf;
    public int ehg;
    public int ehi;
    public int ehj;
    public long ehk;
    public long ehl;
    public int ehm;
    public int ehn;
    public int networkType;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.cNp);
            aVar.C(2, this.ehk);
            aVar.C(3, this.ehl);
            aVar.dV(4, this.networkType);
            aVar.dV(5, this.ehf);
            aVar.dV(6, this.ehg);
            aVar.dV(7, this.ehm);
            aVar.dV(8, this.ehn);
            aVar.dV(9, this.ehi);
            aVar.dV(10, this.ehj);
            return 0;
        } else if (i == 1) {
            return (((((((((a.a.a.a.dS(1, this.cNp) + 0) + a.a.a.a.B(2, this.ehk)) + a.a.a.a.B(3, this.ehl)) + a.a.a.a.dS(4, this.networkType)) + a.a.a.a.dS(5, this.ehf)) + a.a.a.a.dS(6, this.ehg)) + a.a.a.a.dS(7, this.ehm)) + a.a.a.a.dS(8, this.ehn)) + a.a.a.a.dS(9, this.ehi)) + a.a.a.a.dS(10, this.ehj);
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
                b bVar = (b) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bVar.cNp = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        bVar.ehk = aVar3.pMj.mI();
                        return 0;
                    case 3:
                        bVar.ehl = aVar3.pMj.mI();
                        return 0;
                    case 4:
                        bVar.networkType = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        bVar.ehf = aVar3.pMj.mH();
                        return 0;
                    case 6:
                        bVar.ehg = aVar3.pMj.mH();
                        return 0;
                    case 7:
                        bVar.ehm = aVar3.pMj.mH();
                        return 0;
                    case 8:
                        bVar.ehn = aVar3.pMj.mH();
                        return 0;
                    case 9:
                        bVar.ehi = aVar3.pMj.mH();
                        return 0;
                    case 10:
                        bVar.ehj = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
