package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class uy extends a {
    public int mnl;
    public int mnm;
    public int mnn;
    public b mnp;
    public int mxD;
    public int mxE;
    public int mxF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mnl);
            aVar.dV(2, this.mnm);
            aVar.dV(3, this.mnn);
            if (this.mnp != null) {
                aVar.b(4, this.mnp);
            }
            aVar.dV(5, this.mxD);
            aVar.dV(6, this.mxE);
            aVar.dV(7, this.mxF);
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.dS(1, this.mnl) + 0) + a.a.a.a.dS(2, this.mnm)) + a.a.a.a.dS(3, this.mnn);
            if (this.mnp != null) {
                r0 += a.a.a.a.a(4, this.mnp);
            }
            return ((r0 + a.a.a.a.dS(5, this.mxD)) + a.a.a.a.dS(6, this.mxE)) + a.a.a.a.dS(7, this.mxF);
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
            uy uyVar = (uy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uyVar.mnl = aVar3.pMj.mH();
                    return 0;
                case 2:
                    uyVar.mnm = aVar3.pMj.mH();
                    return 0;
                case 3:
                    uyVar.mnn = aVar3.pMj.mH();
                    return 0;
                case 4:
                    uyVar.mnp = aVar3.bQK();
                    return 0;
                case 5:
                    uyVar.mxD = aVar3.pMj.mH();
                    return 0;
                case 6:
                    uyVar.mxE = aVar3.pMj.mH();
                    return 0;
                case 7:
                    uyVar.mxF = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
