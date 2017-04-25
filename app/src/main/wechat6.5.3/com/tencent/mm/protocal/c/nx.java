package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class nx extends a {
    public long mcb;
    public int mcj;
    public int mdA;
    public int mdz;
    public String mpI;
    public int mpO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mcj);
            aVar.dV(2, this.mdA);
            aVar.dV(3, this.mdz);
            if (this.mpI != null) {
                aVar.e(4, this.mpI);
            }
            aVar.dV(5, this.mpO);
            aVar.C(6, this.mcb);
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.dS(1, this.mcj) + 0) + a.a.a.a.dS(2, this.mdA)) + a.a.a.a.dS(3, this.mdz);
            if (this.mpI != null) {
                r0 += a.a.a.b.b.a.f(4, this.mpI);
            }
            return (r0 + a.a.a.a.dS(5, this.mpO)) + a.a.a.a.B(6, this.mcb);
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
            nx nxVar = (nx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nxVar.mcj = aVar3.pMj.mH();
                    return 0;
                case 2:
                    nxVar.mdA = aVar3.pMj.mH();
                    return 0;
                case 3:
                    nxVar.mdz = aVar3.pMj.mH();
                    return 0;
                case 4:
                    nxVar.mpI = aVar3.pMj.readString();
                    return 0;
                case 5:
                    nxVar.mpO = aVar3.pMj.mH();
                    return 0;
                case 6:
                    nxVar.mcb = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
