package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class avm extends a {
    public int efm;
    public int hNS;
    public String hQP;
    public String mOk;
    public String mSK;
    public String mSL;
    public int mSM;
    public int mSN;
    public int mSO;
    public long mSP;
    public long mSQ;
    public are mSR;
    public int mcP;
    public String mqR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mOk != null) {
                aVar.e(1, this.mOk);
            }
            if (this.mqR != null) {
                aVar.e(2, this.mqR);
            }
            if (this.mSK != null) {
                aVar.e(3, this.mSK);
            }
            if (this.mSL != null) {
                aVar.e(4, this.mSL);
            }
            aVar.dV(5, this.efm);
            aVar.dV(6, this.mcP);
            aVar.dV(7, this.hNS);
            if (this.hQP != null) {
                aVar.e(8, this.hQP);
            }
            aVar.dV(9, this.mSM);
            aVar.dV(10, this.mSN);
            aVar.dV(11, this.mSO);
            aVar.C(12, this.mSP);
            aVar.C(13, this.mSQ);
            if (this.mSR == null) {
                return 0;
            }
            aVar.dX(14, this.mSR.aHr());
            this.mSR.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mOk != null) {
                r0 = a.a.a.b.b.a.f(1, this.mOk) + 0;
            } else {
                r0 = 0;
            }
            if (this.mqR != null) {
                r0 += a.a.a.b.b.a.f(2, this.mqR);
            }
            if (this.mSK != null) {
                r0 += a.a.a.b.b.a.f(3, this.mSK);
            }
            if (this.mSL != null) {
                r0 += a.a.a.b.b.a.f(4, this.mSL);
            }
            r0 = ((r0 + a.a.a.a.dS(5, this.efm)) + a.a.a.a.dS(6, this.mcP)) + a.a.a.a.dS(7, this.hNS);
            if (this.hQP != null) {
                r0 += a.a.a.b.b.a.f(8, this.hQP);
            }
            r0 = ((((r0 + a.a.a.a.dS(9, this.mSM)) + a.a.a.a.dS(10, this.mSN)) + a.a.a.a.dS(11, this.mSO)) + a.a.a.a.B(12, this.mSP)) + a.a.a.a.B(13, this.mSQ);
            if (this.mSR != null) {
                r0 += a.a.a.a.dU(14, this.mSR.aHr());
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
            avm com_tencent_mm_protocal_c_avm = (avm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_avm.mOk = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avm.mqR = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_avm.mSK = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_avm.mSL = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_avm.efm = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_avm.mcP = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_avm.hNS = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_avm.hQP = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_avm.mSM = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_avm.mSN = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_avm.mSO = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_avm.mSP = aVar3.pMj.mI();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_avm.mSQ = aVar3.pMj.mI();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avm.mSR = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
