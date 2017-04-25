package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class alr extends a {
    public String bmJ;
    public String eBM;
    public int mMx;
    public String mMy;
    public String mMz;
    public String mkK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.bmJ != null) {
                aVar.e(1, this.bmJ);
            }
            aVar.dV(2, this.mMx);
            if (this.mMy != null) {
                aVar.e(3, this.mMy);
            }
            if (this.mMz != null) {
                aVar.e(4, this.mMz);
            }
            if (this.mkK != null) {
                aVar.e(5, this.mkK);
            }
            if (this.eBM == null) {
                return 0;
            }
            aVar.e(6, this.eBM);
            return 0;
        } else if (i == 1) {
            if (this.bmJ != null) {
                r0 = a.a.a.b.b.a.f(1, this.bmJ) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mMx);
            if (this.mMy != null) {
                r0 += a.a.a.b.b.a.f(3, this.mMy);
            }
            if (this.mMz != null) {
                r0 += a.a.a.b.b.a.f(4, this.mMz);
            }
            if (this.mkK != null) {
                r0 += a.a.a.b.b.a.f(5, this.mkK);
            }
            if (this.eBM != null) {
                r0 += a.a.a.b.b.a.f(6, this.eBM);
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
            alr com_tencent_mm_protocal_c_alr = (alr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_alr.bmJ = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_alr.mMx = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_alr.mMy = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_alr.mMz = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_alr.mkK = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_alr.eBM = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
