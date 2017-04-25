package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bga extends aqp {
    public long mZV;
    public bfz naI;
    public bfz nbG;
    public bfz nbH;
    public bfz nbI;
    public bfz nbJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.naI == null) {
                throw new b("Not all required fields were included: ReportData");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.naI != null) {
                aVar.dX(2, this.naI.aHr());
                this.naI.a(aVar);
            }
            if (this.nbG != null) {
                aVar.dX(3, this.nbG.aHr());
                this.nbG.a(aVar);
            }
            if (this.nbH != null) {
                aVar.dX(4, this.nbH.aHr());
                this.nbH.a(aVar);
            }
            if (this.nbI != null) {
                aVar.dX(5, this.nbI.aHr());
                this.nbI.a(aVar);
            }
            aVar.C(6, this.mZV);
            if (this.nbJ == null) {
                return 0;
            }
            aVar.dX(7, this.nbJ.aHr());
            this.nbJ.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.naI != null) {
                r0 += a.a.a.a.dU(2, this.naI.aHr());
            }
            if (this.nbG != null) {
                r0 += a.a.a.a.dU(3, this.nbG.aHr());
            }
            if (this.nbH != null) {
                r0 += a.a.a.a.dU(4, this.nbH.aHr());
            }
            if (this.nbI != null) {
                r0 += a.a.a.a.dU(5, this.nbI.aHr());
            }
            r0 += a.a.a.a.B(6, this.mZV);
            if (this.nbJ != null) {
                r0 += a.a.a.a.dU(7, this.nbJ.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.naI != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ReportData");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bga com_tencent_mm_protocal_c_bga = (bga) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            bfz com_tencent_mm_protocal_c_bfz;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bga.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_bfz = new bfz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfz.a(aVar4, com_tencent_mm_protocal_c_bfz, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bga.naI = com_tencent_mm_protocal_c_bfz;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_bfz = new bfz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfz.a(aVar4, com_tencent_mm_protocal_c_bfz, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bga.nbG = com_tencent_mm_protocal_c_bfz;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_bfz = new bfz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfz.a(aVar4, com_tencent_mm_protocal_c_bfz, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bga.nbH = com_tencent_mm_protocal_c_bfz;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_bfz = new bfz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfz.a(aVar4, com_tencent_mm_protocal_c_bfz, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bga.nbI = com_tencent_mm_protocal_c_bfz;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bga.mZV = aVar3.pMj.mI();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_bfz = new bfz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfz.a(aVar4, com_tencent_mm_protocal_c_bfz, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bga.nbJ = com_tencent_mm_protocal_c_bfz;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
