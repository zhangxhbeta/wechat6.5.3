package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class ju extends a {
    public String mmi;
    public String mmj;
    public String mmk;
    public int mml;
    public int mmm;
    public String mmn;
    public int mmo;

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
            aVar.dV(5, this.mmm);
            if (this.mmn != null) {
                aVar.e(6, this.mmn);
            }
            aVar.dV(7, this.mmo);
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
            r0 = (r0 + a.a.a.a.dS(4, this.mml)) + a.a.a.a.dS(5, this.mmm);
            if (this.mmn != null) {
                r0 += a.a.a.b.b.a.f(6, this.mmn);
            }
            return r0 + a.a.a.a.dS(7, this.mmo);
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
            ju juVar = (ju) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    juVar.mmi = aVar3.pMj.readString();
                    return 0;
                case 2:
                    juVar.mmj = aVar3.pMj.readString();
                    return 0;
                case 3:
                    juVar.mmk = aVar3.pMj.readString();
                    return 0;
                case 4:
                    juVar.mml = aVar3.pMj.mH();
                    return 0;
                case 5:
                    juVar.mmm = aVar3.pMj.mH();
                    return 0;
                case 6:
                    juVar.mmn = aVar3.pMj.readString();
                    return 0;
                case 7:
                    juVar.mmo = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
