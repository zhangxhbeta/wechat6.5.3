package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class aod extends a {
    public int fvC;
    public String fvD;
    public int gFM;
    public String gFN;
    public int mNm;
    public int mOo;
    public int mOp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mNm);
            aVar.dV(2, this.mOp);
            aVar.dV(3, this.mOo);
            aVar.dV(4, this.fvC);
            if (this.fvD != null) {
                aVar.e(5, this.fvD);
            }
            aVar.dV(6, this.gFM);
            if (this.gFN != null) {
                aVar.e(7, this.gFN);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.a.dS(1, this.mNm) + 0) + a.a.a.a.dS(2, this.mOp)) + a.a.a.a.dS(3, this.mOo)) + a.a.a.a.dS(4, this.fvC);
            if (this.fvD != null) {
                r0 += a.a.a.b.b.a.f(5, this.fvD);
            }
            r0 += a.a.a.a.dS(6, this.gFM);
            if (this.gFN != null) {
                return r0 + a.a.a.b.b.a.f(7, this.gFN);
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
            aod com_tencent_mm_protocal_c_aod = (aod) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aod.mNm = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aod.mOp = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aod.mOo = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aod.fvC = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aod.fvD = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aod.gFM = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aod.gFN = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
