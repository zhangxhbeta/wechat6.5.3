package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class avr extends a {
    public int efm;
    public int hNS;
    public String hQP;
    public String mGq;
    public int mJm;
    public int mSM;
    public int mSN;
    public int mSO;
    public long mSP;
    public long mSQ;
    public String mTc;
    public int mcP;
    public String mdw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mdw != null) {
                aVar.e(1, this.mdw);
            }
            if (this.mGq != null) {
                aVar.e(2, this.mGq);
            }
            aVar.dV(3, this.mcP);
            aVar.dV(4, this.efm);
            if (this.hQP != null) {
                aVar.e(5, this.hQP);
            }
            aVar.dV(6, this.hNS);
            aVar.dV(7, this.mSN);
            aVar.dV(8, this.mSM);
            if (this.mTc != null) {
                aVar.e(9, this.mTc);
            }
            aVar.dV(10, this.mSO);
            aVar.C(11, this.mSP);
            aVar.C(12, this.mSQ);
            aVar.dV(13, this.mJm);
            return 0;
        } else if (i == 1) {
            if (this.mdw != null) {
                r0 = a.a.a.b.b.a.f(1, this.mdw) + 0;
            } else {
                r0 = 0;
            }
            if (this.mGq != null) {
                r0 += a.a.a.b.b.a.f(2, this.mGq);
            }
            r0 = (r0 + a.a.a.a.dS(3, this.mcP)) + a.a.a.a.dS(4, this.efm);
            if (this.hQP != null) {
                r0 += a.a.a.b.b.a.f(5, this.hQP);
            }
            r0 = ((r0 + a.a.a.a.dS(6, this.hNS)) + a.a.a.a.dS(7, this.mSN)) + a.a.a.a.dS(8, this.mSM);
            if (this.mTc != null) {
                r0 += a.a.a.b.b.a.f(9, this.mTc);
            }
            return (((r0 + a.a.a.a.dS(10, this.mSO)) + a.a.a.a.B(11, this.mSP)) + a.a.a.a.B(12, this.mSQ)) + a.a.a.a.dS(13, this.mJm);
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
            avr com_tencent_mm_protocal_c_avr = (avr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_avr.mdw = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avr.mGq = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_avr.mcP = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_avr.efm = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_avr.hQP = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_avr.hNS = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_avr.mSN = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_avr.mSM = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_avr.mTc = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_avr.mSO = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_avr.mSP = aVar3.pMj.mI();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_avr.mSQ = aVar3.pMj.mI();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_avr.mJm = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
