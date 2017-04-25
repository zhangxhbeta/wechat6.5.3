package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class pv extends a {
    public int eeO;
    public int mfj;
    public String mjT;
    public String mmi;
    public String mmj;
    public String mmk;
    public int mml;
    public String mrI;
    public String mrJ;
    public int mrK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mmi != null) {
                aVar.e(1, this.mmi);
            }
            if (this.mmj != null) {
                aVar.e(2, this.mmj);
            }
            if (this.mmk != null) {
                aVar.e(3, this.mmk);
            }
            aVar.dV(4, this.mml);
            if (this.mrI != null) {
                aVar.e(5, this.mrI);
            }
            if (this.mjT != null) {
                aVar.e(6, this.mjT);
            }
            aVar.dV(7, this.mfj);
            if (this.mrJ != null) {
                aVar.e(8, this.mrJ);
            }
            aVar.dV(9, this.eeO);
            aVar.dV(10, this.mrK);
            return 0;
        } else if (i == 1) {
            if (this.mmi != null) {
                r0 = a.a.a.b.b.a.f(1, this.mmi) + 0;
            } else {
                r0 = 0;
            }
            if (this.mmj != null) {
                r0 += a.a.a.b.b.a.f(2, this.mmj);
            }
            if (this.mmk != null) {
                r0 += a.a.a.b.b.a.f(3, this.mmk);
            }
            r0 += a.a.a.a.dS(4, this.mml);
            if (this.mrI != null) {
                r0 += a.a.a.b.b.a.f(5, this.mrI);
            }
            if (this.mjT != null) {
                r0 += a.a.a.b.b.a.f(6, this.mjT);
            }
            r0 += a.a.a.a.dS(7, this.mfj);
            if (this.mrJ != null) {
                r0 += a.a.a.b.b.a.f(8, this.mrJ);
            }
            return (r0 + a.a.a.a.dS(9, this.eeO)) + a.a.a.a.dS(10, this.mrK);
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
            pv pvVar = (pv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pvVar.mmi = aVar3.pMj.readString();
                    return 0;
                case 2:
                    pvVar.mmj = aVar3.pMj.readString();
                    return 0;
                case 3:
                    pvVar.mmk = aVar3.pMj.readString();
                    return 0;
                case 4:
                    pvVar.mml = aVar3.pMj.mH();
                    return 0;
                case 5:
                    pvVar.mrI = aVar3.pMj.readString();
                    return 0;
                case 6:
                    pvVar.mjT = aVar3.pMj.readString();
                    return 0;
                case 7:
                    pvVar.mfj = aVar3.pMj.mH();
                    return 0;
                case 8:
                    pvVar.mrJ = aVar3.pMj.readString();
                    return 0;
                case 9:
                    pvVar.eeO = aVar3.pMj.mH();
                    return 0;
                case 10:
                    pvVar.mrK = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
