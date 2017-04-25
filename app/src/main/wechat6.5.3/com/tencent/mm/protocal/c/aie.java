package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import java.util.LinkedList;

public final class aie extends a {
    public String aZy;
    public int bcm;
    public String bmJ;
    public String bou;
    public int cxZ;
    public String gkC;
    public int job;
    public int mHR;
    public ahz mIF;
    public int mIG;
    public LinkedList<ahz> mIH = new LinkedList();
    public int mII;
    public String mIJ;
    public String mIK;
    public String mIL;
    public ahn mIM;
    public String mIk;
    public int mIl;
    public int mIm;
    public int mIt;
    public String mIu;
    public String token;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mIl);
            aVar.dV(2, this.mIm);
            aVar.dV(3, this.mHR);
            if (this.mIF != null) {
                aVar.dX(4, this.mIF.aHr());
                this.mIF.a(aVar);
            }
            aVar.dV(5, this.mIG);
            aVar.d(6, 8, this.mIH);
            aVar.dV(7, this.cxZ);
            aVar.dV(8, this.mII);
            if (this.gkC != null) {
                aVar.e(9, this.gkC);
            }
            if (this.mIJ != null) {
                aVar.e(10, this.mIJ);
            }
            if (this.token != null) {
                aVar.e(11, this.token);
            }
            if (this.mIu != null) {
                aVar.e(12, this.mIu);
            }
            aVar.dV(13, this.mIt);
            if (this.bou != null) {
                aVar.e(14, this.bou);
            }
            if (this.mIK != null) {
                aVar.e(15, this.mIK);
            }
            if (this.mIL != null) {
                aVar.e(16, this.mIL);
            }
            if (this.aZy != null) {
                aVar.e(17, this.aZy);
            }
            if (this.bmJ != null) {
                aVar.e(18, this.bmJ);
            }
            aVar.dV(19, this.job);
            aVar.dV(20, this.bcm);
            if (this.mIk != null) {
                aVar.e(21, this.mIk);
            }
            if (this.mIM != null) {
                aVar.dX(22, this.mIM.aHr());
                this.mIM.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.dS(1, this.mIl) + 0) + a.a.a.a.dS(2, this.mIm)) + a.a.a.a.dS(3, this.mHR);
            if (this.mIF != null) {
                r0 += a.a.a.a.dU(4, this.mIF.aHr());
            }
            r0 = (((r0 + a.a.a.a.dS(5, this.mIG)) + a.a.a.a.c(6, 8, this.mIH)) + a.a.a.a.dS(7, this.cxZ)) + a.a.a.a.dS(8, this.mII);
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(9, this.gkC);
            }
            if (this.mIJ != null) {
                r0 += a.a.a.b.b.a.f(10, this.mIJ);
            }
            if (this.token != null) {
                r0 += a.a.a.b.b.a.f(11, this.token);
            }
            if (this.mIu != null) {
                r0 += a.a.a.b.b.a.f(12, this.mIu);
            }
            r0 += a.a.a.a.dS(13, this.mIt);
            if (this.bou != null) {
                r0 += a.a.a.b.b.a.f(14, this.bou);
            }
            if (this.mIK != null) {
                r0 += a.a.a.b.b.a.f(15, this.mIK);
            }
            if (this.mIL != null) {
                r0 += a.a.a.b.b.a.f(16, this.mIL);
            }
            if (this.aZy != null) {
                r0 += a.a.a.b.b.a.f(17, this.aZy);
            }
            if (this.bmJ != null) {
                r0 += a.a.a.b.b.a.f(18, this.bmJ);
            }
            r0 = (r0 + a.a.a.a.dS(19, this.job)) + a.a.a.a.dS(20, this.bcm);
            if (this.mIk != null) {
                r0 += a.a.a.b.b.a.f(21, this.mIk);
            }
            if (this.mIM != null) {
                return r0 + a.a.a.a.dU(22, this.mIM.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mIH.clear();
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
            aie com_tencent_mm_protocal_c_aie = (aie) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            ahz com_tencent_mm_protocal_c_ahz;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aie.mIl = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aie.mIm = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aie.mHR = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_ahz = new ahz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ahz.a(aVar4, com_tencent_mm_protocal_c_ahz, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aie.mIF = com_tencent_mm_protocal_c_ahz;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aie.mIG = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_ahz = new ahz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ahz.a(aVar4, com_tencent_mm_protocal_c_ahz, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aie.mIH.add(com_tencent_mm_protocal_c_ahz);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aie.cxZ = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aie.mII = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aie.gkC = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aie.mIJ = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aie.token = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aie.mIu = aVar3.pMj.readString();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_aie.mIt = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_aie.bou = aVar3.pMj.readString();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    com_tencent_mm_protocal_c_aie.mIK = aVar3.pMj.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aie.mIL = aVar3.pMj.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_aie.aZy = aVar3.pMj.readString();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_aie.bmJ = aVar3.pMj.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_aie.job = aVar3.pMj.mH();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_aie.bcm = aVar3.pMj.mH();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_aie.mIk = aVar3.pMj.readString();
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ahn com_tencent_mm_protocal_c_ahn = new ahn();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ahn.a(aVar4, com_tencent_mm_protocal_c_ahn, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aie.mIM = com_tencent_mm_protocal_c_ahn;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
