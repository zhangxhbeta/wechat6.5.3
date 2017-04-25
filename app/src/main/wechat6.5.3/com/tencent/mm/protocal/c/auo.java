package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class auo extends a {
    public String bol;
    public String bom;
    public String eBK;
    public String lZL;
    public String lZM;
    public int lZN;
    public String mSg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.bol != null) {
                aVar.e(1, this.bol);
            }
            if (this.eBK != null) {
                aVar.e(2, this.eBK);
            }
            if (this.bom != null) {
                aVar.e(3, this.bom);
            }
            if (this.lZL != null) {
                aVar.e(4, this.lZL);
            }
            if (this.lZM != null) {
                aVar.e(5, this.lZM);
            }
            aVar.dV(6, this.lZN);
            if (this.mSg == null) {
                return 0;
            }
            aVar.e(7, this.mSg);
            return 0;
        } else if (i == 1) {
            if (this.bol != null) {
                r0 = a.a.a.b.b.a.f(1, this.bol) + 0;
            } else {
                r0 = 0;
            }
            if (this.eBK != null) {
                r0 += a.a.a.b.b.a.f(2, this.eBK);
            }
            if (this.bom != null) {
                r0 += a.a.a.b.b.a.f(3, this.bom);
            }
            if (this.lZL != null) {
                r0 += a.a.a.b.b.a.f(4, this.lZL);
            }
            if (this.lZM != null) {
                r0 += a.a.a.b.b.a.f(5, this.lZM);
            }
            r0 += a.a.a.a.dS(6, this.lZN);
            if (this.mSg != null) {
                r0 += a.a.a.b.b.a.f(7, this.mSg);
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
            auo com_tencent_mm_protocal_c_auo = (auo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_auo.bol = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_auo.eBK = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_auo.bom = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_auo.lZL = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_auo.lZM = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_auo.lZN = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_auo.mSg = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
