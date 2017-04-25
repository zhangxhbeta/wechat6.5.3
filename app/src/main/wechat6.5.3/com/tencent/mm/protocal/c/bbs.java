package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class bbs extends aqp {
    public int aMN;
    public String aRh;
    public String aZN;
    public String cps;
    public String mXA;
    public LinkedList<axu> mXB = new LinkedList();
    public int mXC;
    public int mXD;
    public int mXv;
    public int mXw;
    public String mXx;
    public String mXy;
    public int mXz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.aRh != null) {
                aVar.e(2, this.aRh);
            }
            if (this.aZN != null) {
                aVar.e(3, this.aZN);
            }
            aVar.dV(4, this.mXv);
            aVar.dV(5, this.mXw);
            aVar.dV(6, this.aMN);
            if (this.mXx != null) {
                aVar.e(7, this.mXx);
            }
            if (this.mXy != null) {
                aVar.e(8, this.mXy);
            }
            if (this.cps != null) {
                aVar.e(9, this.cps);
            }
            aVar.dV(10, this.mXz);
            if (this.mXA != null) {
                aVar.e(11, this.mXA);
            }
            aVar.d(12, 8, this.mXB);
            aVar.dV(13, this.mXC);
            aVar.dV(14, this.mXD);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.aRh != null) {
                r0 += a.a.a.b.b.a.f(2, this.aRh);
            }
            if (this.aZN != null) {
                r0 += a.a.a.b.b.a.f(3, this.aZN);
            }
            r0 = ((r0 + a.a.a.a.dS(4, this.mXv)) + a.a.a.a.dS(5, this.mXw)) + a.a.a.a.dS(6, this.aMN);
            if (this.mXx != null) {
                r0 += a.a.a.b.b.a.f(7, this.mXx);
            }
            if (this.mXy != null) {
                r0 += a.a.a.b.b.a.f(8, this.mXy);
            }
            if (this.cps != null) {
                r0 += a.a.a.b.b.a.f(9, this.cps);
            }
            r0 += a.a.a.a.dS(10, this.mXz);
            if (this.mXA != null) {
                r0 += a.a.a.b.b.a.f(11, this.mXA);
            }
            return ((r0 + a.a.a.a.c(12, 8, this.mXB)) + a.a.a.a.dS(13, this.mXC)) + a.a.a.a.dS(14, this.mXD);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mXB.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bbs com_tencent_mm_protocal_c_bbs = (bbs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbs.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bbs.aRh = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bbs.aZN = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bbs.mXv = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bbs.mXw = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bbs.aMN = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bbs.mXx = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bbs.mXy = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bbs.cps = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bbs.mXz = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bbs.mXA = aVar3.pMj.readString();
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        axu com_tencent_mm_protocal_c_axu = new axu();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_axu.a(aVar4, com_tencent_mm_protocal_c_axu, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bbs.mXB.add(com_tencent_mm_protocal_c_axu);
                    }
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_bbs.mXC = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_bbs.mXD = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
