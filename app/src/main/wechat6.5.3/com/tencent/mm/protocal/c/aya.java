package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class aya extends a {
    public int bbT;
    public int cZA;
    public String jBD;
    public String mVw;
    public String mVx;
    public int mVy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.cZA);
            if (this.mVw != null) {
                aVar.e(2, this.mVw);
            }
            if (this.mVx != null) {
                aVar.e(3, this.mVx);
            }
            aVar.dV(4, this.bbT);
            if (this.jBD != null) {
                aVar.e(5, this.jBD);
            }
            aVar.dV(6, this.mVy);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.cZA) + 0;
            if (this.mVw != null) {
                r0 += a.a.a.b.b.a.f(2, this.mVw);
            }
            if (this.mVx != null) {
                r0 += a.a.a.b.b.a.f(3, this.mVx);
            }
            r0 += a.a.a.a.dS(4, this.bbT);
            if (this.jBD != null) {
                r0 += a.a.a.b.b.a.f(5, this.jBD);
            }
            return r0 + a.a.a.a.dS(6, this.mVy);
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
            aya com_tencent_mm_protocal_c_aya = (aya) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aya.cZA = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aya.mVw = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aya.mVx = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aya.bbT = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aya.jBD = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aya.mVy = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
