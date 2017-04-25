package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class aqk extends a {
    public String efb;
    public int iZX;
    public int mPI;
    public int mPJ;
    public String mPK;
    public String mio;
    public String mip;
    public String miq;
    public String mir;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.efb != null) {
                aVar.e(1, this.efb);
            }
            aVar.dV(2, this.mPI);
            if (this.mio != null) {
                aVar.e(3, this.mio);
            }
            if (this.mip != null) {
                aVar.e(4, this.mip);
            }
            aVar.dV(5, this.iZX);
            aVar.dV(6, this.mPJ);
            if (this.miq != null) {
                aVar.e(7, this.miq);
            }
            if (this.mir != null) {
                aVar.e(8, this.mir);
            }
            if (this.mPK == null) {
                return 0;
            }
            aVar.e(9, this.mPK);
            return 0;
        } else if (i == 1) {
            if (this.efb != null) {
                r0 = a.a.a.b.b.a.f(1, this.efb) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mPI);
            if (this.mio != null) {
                r0 += a.a.a.b.b.a.f(3, this.mio);
            }
            if (this.mip != null) {
                r0 += a.a.a.b.b.a.f(4, this.mip);
            }
            r0 = (r0 + a.a.a.a.dS(5, this.iZX)) + a.a.a.a.dS(6, this.mPJ);
            if (this.miq != null) {
                r0 += a.a.a.b.b.a.f(7, this.miq);
            }
            if (this.mir != null) {
                r0 += a.a.a.b.b.a.f(8, this.mir);
            }
            if (this.mPK != null) {
                r0 += a.a.a.b.b.a.f(9, this.mPK);
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
            aqk com_tencent_mm_protocal_c_aqk = (aqk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aqk.efb = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqk.mPI = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqk.mio = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aqk.mip = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aqk.iZX = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aqk.mPJ = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aqk.miq = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aqk.mir = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aqk.mPK = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
