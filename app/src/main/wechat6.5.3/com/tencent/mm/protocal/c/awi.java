package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class awi extends a {
    public int mTH;
    public axk mTI;
    public aop mTJ;
    public mz mTK;
    public anh mTL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mTH);
            if (this.mTI != null) {
                aVar.dX(2, this.mTI.aHr());
                this.mTI.a(aVar);
            }
            if (this.mTJ != null) {
                aVar.dX(3, this.mTJ.aHr());
                this.mTJ.a(aVar);
            }
            if (this.mTK != null) {
                aVar.dX(4, this.mTK.aHr());
                this.mTK.a(aVar);
            }
            if (this.mTL != null) {
                aVar.dX(5, this.mTL.aHr());
                this.mTL.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mTH) + 0;
            if (this.mTI != null) {
                r0 += a.a.a.a.dU(2, this.mTI.aHr());
            }
            if (this.mTJ != null) {
                r0 += a.a.a.a.dU(3, this.mTJ.aHr());
            }
            if (this.mTK != null) {
                r0 += a.a.a.a.dU(4, this.mTK.aHr());
            }
            if (this.mTL != null) {
                return r0 + a.a.a.a.dU(5, this.mTL.aHr());
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
            awi com_tencent_mm_protocal_c_awi = (awi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_awi.mTH = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        axk com_tencent_mm_protocal_c_axk = new axk();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_axk.a(aVar4, com_tencent_mm_protocal_c_axk, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awi.mTI = com_tencent_mm_protocal_c_axk;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        aop com_tencent_mm_protocal_c_aop = new aop();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aop.a(aVar4, com_tencent_mm_protocal_c_aop, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awi.mTJ = com_tencent_mm_protocal_c_aop;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        mz mzVar = new mz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mzVar.a(aVar4, mzVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awi.mTK = mzVar;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        anh com_tencent_mm_protocal_c_anh = new anh();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_anh.a(aVar4, com_tencent_mm_protocal_c_anh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awi.mTL = com_tencent_mm_protocal_c_anh;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
