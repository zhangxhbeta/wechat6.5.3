package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class atf extends aqp {
    public int mIZ;
    public int mRw;
    public LinkedList<bgg> mRx = new LinkedList();
    public int mRy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.mIZ);
            aVar.dV(3, this.mRw);
            aVar.d(4, 8, this.mRx);
            aVar.dV(5, this.mRy);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + a.a.a.a.dS(2, this.mIZ)) + a.a.a.a.dS(3, this.mRw)) + a.a.a.a.c(4, 8, this.mRx)) + a.a.a.a.dS(5, this.mRy);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mRx.clear();
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
            atf com_tencent_mm_protocal_c_atf = (atf) objArr[1];
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
                        com_tencent_mm_protocal_c_atf.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_atf.mIZ = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_atf.mRw = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bgg com_tencent_mm_protocal_c_bgg = new bgg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bgg.a(aVar4, com_tencent_mm_protocal_c_bgg, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_atf.mRx.add(com_tencent_mm_protocal_c_bgg);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_atf.mRy = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
