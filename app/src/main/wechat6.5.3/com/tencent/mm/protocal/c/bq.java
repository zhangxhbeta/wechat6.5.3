package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bq extends a {
    public String gln;
    public String gor;
    public int maG;
    public int mci;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gln != null) {
                aVar.e(1, this.gln);
            }
            aVar.dV(2, this.maG);
            aVar.dV(3, this.mci);
            if (this.gor == null) {
                return 0;
            }
            aVar.e(4, this.gor);
            return 0;
        } else if (i == 1) {
            if (this.gln != null) {
                r0 = a.a.a.b.b.a.f(1, this.gln) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.maG)) + a.a.a.a.dS(3, this.mci);
            if (this.gor != null) {
                r0 += a.a.a.b.b.a.f(4, this.gor);
            }
            return r0;
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
            bq bqVar = (bq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bqVar.gln = aVar3.pMj.readString();
                    return 0;
                case 2:
                    bqVar.maG = aVar3.pMj.mH();
                    return 0;
                case 3:
                    bqVar.mci = aVar3.pMj.mH();
                    return 0;
                case 4:
                    bqVar.gor = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
