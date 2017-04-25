package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class aky extends a {
    public int gkH;
    public String gkz;
    public String hNZ;
    public String mLM;
    public String mLN;
    public String mLO;
    public String mLP;
    public String mLQ;
    public String mLR;
    public String mLS;
    public String maV;
    public String maX;
    public String mhs;
    public int mht;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkz != null) {
                aVar.e(1, this.gkz);
            }
            if (this.hNZ != null) {
                aVar.e(2, this.hNZ);
            }
            if (this.mLM != null) {
                aVar.e(3, this.mLM);
            }
            if (this.maV != null) {
                aVar.e(4, this.maV);
            }
            if (this.mLN != null) {
                aVar.e(5, this.mLN);
            }
            aVar.dV(6, this.mht);
            if (this.mLO != null) {
                aVar.e(7, this.mLO);
            }
            if (this.maX != null) {
                aVar.e(8, this.maX);
            }
            if (this.mhs != null) {
                aVar.e(9, this.mhs);
            }
            if (this.mLP != null) {
                aVar.e(10, this.mLP);
            }
            if (this.mLQ != null) {
                aVar.e(11, this.mLQ);
            }
            if (this.mLR != null) {
                aVar.e(12, this.mLR);
            }
            if (this.mLS != null) {
                aVar.e(13, this.mLS);
            }
            aVar.dV(14, this.gkH);
            return 0;
        } else if (i == 1) {
            if (this.gkz != null) {
                r0 = a.a.a.b.b.a.f(1, this.gkz) + 0;
            } else {
                r0 = 0;
            }
            if (this.hNZ != null) {
                r0 += a.a.a.b.b.a.f(2, this.hNZ);
            }
            if (this.mLM != null) {
                r0 += a.a.a.b.b.a.f(3, this.mLM);
            }
            if (this.maV != null) {
                r0 += a.a.a.b.b.a.f(4, this.maV);
            }
            if (this.mLN != null) {
                r0 += a.a.a.b.b.a.f(5, this.mLN);
            }
            r0 += a.a.a.a.dS(6, this.mht);
            if (this.mLO != null) {
                r0 += a.a.a.b.b.a.f(7, this.mLO);
            }
            if (this.maX != null) {
                r0 += a.a.a.b.b.a.f(8, this.maX);
            }
            if (this.mhs != null) {
                r0 += a.a.a.b.b.a.f(9, this.mhs);
            }
            if (this.mLP != null) {
                r0 += a.a.a.b.b.a.f(10, this.mLP);
            }
            if (this.mLQ != null) {
                r0 += a.a.a.b.b.a.f(11, this.mLQ);
            }
            if (this.mLR != null) {
                r0 += a.a.a.b.b.a.f(12, this.mLR);
            }
            if (this.mLS != null) {
                r0 += a.a.a.b.b.a.f(13, this.mLS);
            }
            return r0 + a.a.a.a.dS(14, this.gkH);
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
            aky com_tencent_mm_protocal_c_aky = (aky) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aky.gkz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aky.hNZ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aky.mLM = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aky.maV = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aky.mLN = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aky.mht = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aky.mLO = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aky.maX = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aky.mhs = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aky.mLP = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aky.mLQ = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aky.mLR = aVar3.pMj.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aky.mLS = aVar3.pMj.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aky.gkH = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
