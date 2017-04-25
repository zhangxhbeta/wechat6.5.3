package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class aum extends aqp {
    public int bon;
    public LinkedList<auo> cqE = new LinkedList();
    public axv lZP;
    public int mSd;
    public String mSe;
    public auw mSf;
    public String mxa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.mSd);
            aVar.d(3, 8, this.cqE);
            if (this.mSe != null) {
                aVar.e(4, this.mSe);
            }
            if (this.mxa != null) {
                aVar.e(5, this.mxa);
            }
            if (this.mSf != null) {
                aVar.dX(6, this.mSf.aHr());
                this.mSf.a(aVar);
            }
            aVar.dV(7, this.bon);
            if (this.lZP == null) {
                return 0;
            }
            aVar.dX(8, this.lZP.aHr());
            this.lZP.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.mSd)) + a.a.a.a.c(3, 8, this.cqE);
            if (this.mSe != null) {
                r0 += a.a.a.b.b.a.f(4, this.mSe);
            }
            if (this.mxa != null) {
                r0 += a.a.a.b.b.a.f(5, this.mxa);
            }
            if (this.mSf != null) {
                r0 += a.a.a.a.dU(6, this.mSf.aHr());
            }
            r0 += a.a.a.a.dS(7, this.bon);
            if (this.lZP != null) {
                r0 += a.a.a.a.dU(8, this.lZP.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.cqE.clear();
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
            aum com_tencent_mm_protocal_c_aum = (aum) objArr[1];
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
                        com_tencent_mm_protocal_c_aum.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aum.mSd = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        auo com_tencent_mm_protocal_c_auo = new auo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_auo.a(aVar4, com_tencent_mm_protocal_c_auo, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aum.cqE.add(com_tencent_mm_protocal_c_auo);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aum.mSe = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aum.mxa = aVar3.pMj.readString();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        auw com_tencent_mm_protocal_c_auw = new auw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_auw.a(aVar4, com_tencent_mm_protocal_c_auw, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aum.mSf = com_tencent_mm_protocal_c_auw;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aum.bon = aVar3.pMj.mH();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        axv com_tencent_mm_protocal_c_axv = new axv();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_axv.a(aVar4, com_tencent_mm_protocal_c_axv, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aum.lZP = com_tencent_mm_protocal_c_axv;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
