package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bfr extends aqx {
    public int mNZ;
    public int mqS;
    public long mqT;
    public int nbv;
    public LinkedList<beg> nbw = new LinkedList();
    public int nbx;
    public LinkedList<beg> nby = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            aVar.dV(2, this.mqS);
            aVar.dV(3, this.nbv);
            aVar.d(4, 8, this.nbw);
            aVar.dV(5, this.nbx);
            aVar.d(6, 8, this.nby);
            aVar.C(7, this.mqT);
            aVar.dV(8, this.mNZ);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return ((((((r0 + a.a.a.a.dS(2, this.mqS)) + a.a.a.a.dS(3, this.nbv)) + a.a.a.a.c(4, 8, this.nbw)) + a.a.a.a.dS(5, this.nbx)) + a.a.a.a.c(6, 8, this.nby)) + a.a.a.a.B(7, this.mqT)) + a.a.a.a.dS(8, this.mNZ);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.nbw.clear();
            this.nby.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bfr com_tencent_mm_protocal_c_bfr = (bfr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            beg com_tencent_mm_protocal_c_beg;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfr.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfr.mqS = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfr.nbv = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_beg = new beg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_beg.a(aVar4, com_tencent_mm_protocal_c_beg, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfr.nbw.add(com_tencent_mm_protocal_c_beg);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bfr.nbx = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_beg = new beg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_beg.a(aVar4, com_tencent_mm_protocal_c_beg, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfr.nby.add(com_tencent_mm_protocal_c_beg);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bfr.mqT = aVar3.pMj.mI();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bfr.mNZ = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
