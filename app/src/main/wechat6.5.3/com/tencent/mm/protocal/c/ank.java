package com.tencent.mm.protocal.c;

import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ank extends a {
    public int eet;
    public int efm;
    public String gkB;
    public String hOx;
    public int mND;
    public LinkedList<afg> mNE = new LinkedList();
    public int mNF;
    public String mNG;
    public String mNH;
    public int mNI;
    public String mNJ;
    public int mNK;
    public LinkedList<ng> mNL = new LinkedList();
    public int maG;
    public String mqp;
    public String mzY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mND);
            aVar.d(2, 8, this.mNE);
            aVar.dV(3, this.eet);
            aVar.dV(4, this.mNF);
            if (this.mqp != null) {
                aVar.e(5, this.mqp);
            }
            if (this.mzY != null) {
                aVar.e(6, this.mzY);
            }
            if (this.mNG != null) {
                aVar.e(7, this.mNG);
            }
            if (this.mNH != null) {
                aVar.e(8, this.mNH);
            }
            aVar.dV(9, this.efm);
            if (this.gkB != null) {
                aVar.e(10, this.gkB);
            }
            if (this.hOx != null) {
                aVar.e(11, this.hOx);
            }
            aVar.dV(12, this.mNI);
            aVar.dV(13, this.maG);
            if (this.mNJ != null) {
                aVar.e(14, this.mNJ);
            }
            aVar.dV(15, this.mNK);
            aVar.d(16, 8, this.mNL);
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.a.dS(1, this.mND) + 0) + a.a.a.a.c(2, 8, this.mNE)) + a.a.a.a.dS(3, this.eet)) + a.a.a.a.dS(4, this.mNF);
            if (this.mqp != null) {
                r0 += a.a.a.b.b.a.f(5, this.mqp);
            }
            if (this.mzY != null) {
                r0 += a.a.a.b.b.a.f(6, this.mzY);
            }
            if (this.mNG != null) {
                r0 += a.a.a.b.b.a.f(7, this.mNG);
            }
            if (this.mNH != null) {
                r0 += a.a.a.b.b.a.f(8, this.mNH);
            }
            r0 += a.a.a.a.dS(9, this.efm);
            if (this.gkB != null) {
                r0 += a.a.a.b.b.a.f(10, this.gkB);
            }
            if (this.hOx != null) {
                r0 += a.a.a.b.b.a.f(11, this.hOx);
            }
            r0 = (r0 + a.a.a.a.dS(12, this.mNI)) + a.a.a.a.dS(13, this.maG);
            if (this.mNJ != null) {
                r0 += a.a.a.b.b.a.f(14, this.mNJ);
            }
            return (r0 + a.a.a.a.dS(15, this.mNK)) + a.a.a.a.c(16, 8, this.mNL);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mNE.clear();
            this.mNL.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            ank com_tencent_mm_protocal_c_ank = (ank) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_ank.mND = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        afg com_tencent_mm_protocal_c_afg = new afg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_afg.a(aVar4, com_tencent_mm_protocal_c_afg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ank.mNE.add(com_tencent_mm_protocal_c_afg);
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ank.eet = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ank.mNF = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ank.mqp = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ank.mzY = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ank.mNG = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ank.mNH = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    com_tencent_mm_protocal_c_ank.efm = aVar3.pMj.mH();
                    return 0;
                case NetStatusUtil.LTE /*10*/:
                    com_tencent_mm_protocal_c_ank.gkB = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ank.hOx = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ank.mNI = aVar3.pMj.mH();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ank.maG = aVar3.pMj.mH();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ank.mNJ = aVar3.pMj.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_ank.mNK = aVar3.pMj.mH();
                    return 0;
                case 16:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ng ngVar = new ng();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ngVar.a(aVar4, ngVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ank.mNL.add(ngVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
