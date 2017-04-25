package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class agg extends a {
    public String cID;
    public String dCJ;
    public String mEm;
    public String mFR;
    public String mFS;
    public String mFT;
    public String mFU;
    public String mFV;
    public String name;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mEm == null) {
                throw new b("Not all required fields were included: linkedin_id");
            }
            if (this.mEm != null) {
                aVar.e(1, this.mEm);
            }
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.dCJ != null) {
                aVar.e(3, this.dCJ);
            }
            if (this.mFR != null) {
                aVar.e(4, this.mFR);
            }
            if (this.mFS != null) {
                aVar.e(5, this.mFS);
            }
            if (this.mFT != null) {
                aVar.e(6, this.mFT);
            }
            if (this.mFU != null) {
                aVar.e(7, this.mFU);
            }
            if (this.mFV != null) {
                aVar.e(8, this.mFV);
            }
            if (this.cID == null) {
                return 0;
            }
            aVar.e(9, this.cID);
            return 0;
        } else if (i == 1) {
            if (this.mEm != null) {
                r0 = a.a.a.b.b.a.f(1, this.mEm) + 0;
            } else {
                r0 = 0;
            }
            if (this.name != null) {
                r0 += a.a.a.b.b.a.f(2, this.name);
            }
            if (this.dCJ != null) {
                r0 += a.a.a.b.b.a.f(3, this.dCJ);
            }
            if (this.mFR != null) {
                r0 += a.a.a.b.b.a.f(4, this.mFR);
            }
            if (this.mFS != null) {
                r0 += a.a.a.b.b.a.f(5, this.mFS);
            }
            if (this.mFT != null) {
                r0 += a.a.a.b.b.a.f(6, this.mFT);
            }
            if (this.mFU != null) {
                r0 += a.a.a.b.b.a.f(7, this.mFU);
            }
            if (this.mFV != null) {
                r0 += a.a.a.b.b.a.f(8, this.mFV);
            }
            if (this.cID != null) {
                r0 += a.a.a.b.b.a.f(9, this.cID);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mEm != null) {
                return 0;
            }
            throw new b("Not all required fields were included: linkedin_id");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            agg com_tencent_mm_protocal_c_agg = (agg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_agg.mEm = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_agg.name = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_agg.dCJ = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_agg.mFR = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_agg.mFS = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_agg.mFT = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_agg.mFU = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_agg.mFV = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_agg.cID = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
