package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class aza extends a {
    public String gln;
    public int mOq;
    public String mlX;
    public int moi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gln != null) {
                aVar.e(1, this.gln);
            }
            if (this.mlX != null) {
                aVar.e(2, this.mlX);
            }
            aVar.dV(3, this.mOq);
            aVar.dV(4, this.moi);
            return 0;
        } else if (i == 1) {
            if (this.gln != null) {
                r0 = a.a.a.b.b.a.f(1, this.gln) + 0;
            } else {
                r0 = 0;
            }
            if (this.mlX != null) {
                r0 += a.a.a.b.b.a.f(2, this.mlX);
            }
            return (r0 + a.a.a.a.dS(3, this.mOq)) + a.a.a.a.dS(4, this.moi);
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
            aza com_tencent_mm_protocal_c_aza = (aza) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aza.gln = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aza.mlX = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aza.mOq = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aza.moi = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
