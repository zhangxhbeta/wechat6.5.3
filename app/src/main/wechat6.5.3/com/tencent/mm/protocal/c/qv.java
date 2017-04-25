package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class qv extends a {
    public int bcd;
    public int fZE;
    public String id;
    public String muG;
    public long muH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            aVar.dV(2, this.fZE);
            if (this.muG != null) {
                aVar.e(3, this.muG);
            }
            aVar.C(4, this.muH);
            aVar.dV(5, this.bcd);
            return 0;
        } else if (i == 1) {
            if (this.id != null) {
                r0 = a.a.a.b.b.a.f(1, this.id) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.fZE);
            if (this.muG != null) {
                r0 += a.a.a.b.b.a.f(3, this.muG);
            }
            return (r0 + a.a.a.a.B(4, this.muH)) + a.a.a.a.dS(5, this.bcd);
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
            qv qvVar = (qv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qvVar.id = aVar3.pMj.readString();
                    return 0;
                case 2:
                    qvVar.fZE = aVar3.pMj.mH();
                    return 0;
                case 3:
                    qvVar.muG = aVar3.pMj.readString();
                    return 0;
                case 4:
                    qvVar.muH = aVar3.pMj.mI();
                    return 0;
                case 5:
                    qvVar.bcd = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
