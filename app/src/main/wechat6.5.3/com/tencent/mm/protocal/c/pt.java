package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class pt extends a {
    public int eeO;
    public String efy;
    public String gln;
    public String mqa;
    public String mrE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gln != null) {
                aVar.e(1, this.gln);
            }
            if (this.mrE != null) {
                aVar.e(2, this.mrE);
            }
            if (this.efy != null) {
                aVar.e(3, this.efy);
            }
            if (this.mqa != null) {
                aVar.e(4, this.mqa);
            }
            aVar.dV(5, this.eeO);
            return 0;
        } else if (i == 1) {
            if (this.gln != null) {
                r0 = a.a.a.b.b.a.f(1, this.gln) + 0;
            } else {
                r0 = 0;
            }
            if (this.mrE != null) {
                r0 += a.a.a.b.b.a.f(2, this.mrE);
            }
            if (this.efy != null) {
                r0 += a.a.a.b.b.a.f(3, this.efy);
            }
            if (this.mqa != null) {
                r0 += a.a.a.b.b.a.f(4, this.mqa);
            }
            return r0 + a.a.a.a.dS(5, this.eeO);
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
            pt ptVar = (pt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ptVar.gln = aVar3.pMj.readString();
                    return 0;
                case 2:
                    ptVar.mrE = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ptVar.efy = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ptVar.mqa = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ptVar.eeO = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
