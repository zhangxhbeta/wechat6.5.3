package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class jp extends a {
    public String efy;
    public String gln;
    public String mlX;
    public String mlY;
    public String mlZ;
    public int mma;
    public String mmb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gln != null) {
                aVar.e(1, this.gln);
            }
            if (this.efy != null) {
                aVar.e(2, this.efy);
            }
            if (this.mlX != null) {
                aVar.e(3, this.mlX);
            }
            if (this.mlY != null) {
                aVar.e(4, this.mlY);
            }
            if (this.mlZ != null) {
                aVar.e(5, this.mlZ);
            }
            aVar.dV(6, this.mma);
            if (this.mmb == null) {
                return 0;
            }
            aVar.e(7, this.mmb);
            return 0;
        } else if (i == 1) {
            if (this.gln != null) {
                r0 = a.a.a.b.b.a.f(1, this.gln) + 0;
            } else {
                r0 = 0;
            }
            if (this.efy != null) {
                r0 += a.a.a.b.b.a.f(2, this.efy);
            }
            if (this.mlX != null) {
                r0 += a.a.a.b.b.a.f(3, this.mlX);
            }
            if (this.mlY != null) {
                r0 += a.a.a.b.b.a.f(4, this.mlY);
            }
            if (this.mlZ != null) {
                r0 += a.a.a.b.b.a.f(5, this.mlZ);
            }
            r0 += a.a.a.a.dS(6, this.mma);
            if (this.mmb != null) {
                r0 += a.a.a.b.b.a.f(7, this.mmb);
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
            jp jpVar = (jp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jpVar.gln = aVar3.pMj.readString();
                    return 0;
                case 2:
                    jpVar.efy = aVar3.pMj.readString();
                    return 0;
                case 3:
                    jpVar.mlX = aVar3.pMj.readString();
                    return 0;
                case 4:
                    jpVar.mlY = aVar3.pMj.readString();
                    return 0;
                case 5:
                    jpVar.mlZ = aVar3.pMj.readString();
                    return 0;
                case 6:
                    jpVar.mma = aVar3.pMj.mH();
                    return 0;
                case 7:
                    jpVar.mmb = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
