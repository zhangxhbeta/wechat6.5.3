package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class aiy extends aqp {
    public int mJu;
    public LinkedList<aix> mJv = new LinkedList();
    public int mJw;
    public String mJx;
    public int mbJ;
    public LinkedList<aja> mfQ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.mbJ);
            aVar.dV(3, this.mJu);
            aVar.d(4, 8, this.mJv);
            aVar.dV(5, this.mJw);
            aVar.d(6, 8, this.mfQ);
            if (this.mJx == null) {
                return 0;
            }
            aVar.e(7, this.mJx);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + a.a.a.a.dS(2, this.mbJ)) + a.a.a.a.dS(3, this.mJu)) + a.a.a.a.c(4, 8, this.mJv)) + a.a.a.a.dS(5, this.mJw)) + a.a.a.a.c(6, 8, this.mfQ);
            if (this.mJx != null) {
                r0 += a.a.a.b.b.a.f(7, this.mJx);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mJv.clear();
            this.mfQ.clear();
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
            aiy com_tencent_mm_protocal_c_aiy = (aiy) objArr[1];
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
                        com_tencent_mm_protocal_c_aiy.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aiy.mbJ = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aiy.mJu = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        aix com_tencent_mm_protocal_c_aix = new aix();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aix.a(aVar4, com_tencent_mm_protocal_c_aix, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aiy.mJv.add(com_tencent_mm_protocal_c_aix);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aiy.mJw = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        aja com_tencent_mm_protocal_c_aja = new aja();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aja.a(aVar4, com_tencent_mm_protocal_c_aja, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aiy.mfQ.add(com_tencent_mm_protocal_c_aja);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aiy.mJx = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
