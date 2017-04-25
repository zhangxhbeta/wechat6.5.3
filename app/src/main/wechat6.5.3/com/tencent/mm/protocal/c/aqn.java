package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;

public final class aqn extends a {
    public int mDX;
    public long mNN;
    public String mPM;
    public String mPN;
    public int mPO;
    public int mPP;
    public int mPQ;
    public String mPR;
    public String mPS;
    public String mPT;
    public int maG;
    public long miQ;
    public int mnz;
    public String mzu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.maG);
            if (this.mzu != null) {
                aVar.e(2, this.mzu);
            }
            if (this.mPM != null) {
                aVar.e(3, this.mPM);
            }
            aVar.C(4, this.miQ);
            if (this.mPN != null) {
                aVar.e(5, this.mPN);
            }
            aVar.dV(6, this.mPO);
            aVar.dV(7, this.mPP);
            aVar.dV(8, this.mPQ);
            aVar.C(9, this.mNN);
            aVar.dV(10, this.mDX);
            if (this.mPR != null) {
                aVar.e(11, this.mPR);
            }
            aVar.dV(12, this.mnz);
            if (this.mPS != null) {
                aVar.e(13, this.mPS);
            }
            if (this.mPT != null) {
                aVar.e(14, this.mPT);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.maG) + 0;
            if (this.mzu != null) {
                r0 += a.a.a.b.b.a.f(2, this.mzu);
            }
            if (this.mPM != null) {
                r0 += a.a.a.b.b.a.f(3, this.mPM);
            }
            r0 += a.a.a.a.B(4, this.miQ);
            if (this.mPN != null) {
                r0 += a.a.a.b.b.a.f(5, this.mPN);
            }
            r0 = ((((r0 + a.a.a.a.dS(6, this.mPO)) + a.a.a.a.dS(7, this.mPP)) + a.a.a.a.dS(8, this.mPQ)) + a.a.a.a.B(9, this.mNN)) + a.a.a.a.dS(10, this.mDX);
            if (this.mPR != null) {
                r0 += a.a.a.b.b.a.f(11, this.mPR);
            }
            r0 += a.a.a.a.dS(12, this.mnz);
            if (this.mPS != null) {
                r0 += a.a.a.b.b.a.f(13, this.mPS);
            }
            if (this.mPT != null) {
                return r0 + a.a.a.b.b.a.f(14, this.mPT);
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
            aqn com_tencent_mm_protocal_c_aqn = (aqn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aqn.maG = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqn.mzu = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqn.mPM = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aqn.miQ = aVar3.pMj.mI();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aqn.mPN = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aqn.mPO = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aqn.mPP = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aqn.mPQ = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aqn.mNN = aVar3.pMj.mI();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aqn.mDX = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aqn.mPR = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aqn.mnz = aVar3.pMj.mH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_aqn.mPS = aVar3.pMj.readString();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_aqn.mPT = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
