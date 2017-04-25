package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bfa extends aqp {
    public String gom;
    public int mNO;
    public String mOk;
    public long mZV;
    public int mqS;
    public long mqT;
    public bfz naI;
    public int naJ;

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
            if (this.mOk != null) {
                aVar.e(2, this.mOk);
            }
            aVar.dV(3, this.mqS);
            aVar.C(4, this.mqT);
            if (this.gom != null) {
                aVar.e(6, this.gom);
            }
            if (this.naI != null) {
                aVar.dX(8, this.naI.aHr());
                this.naI.a(aVar);
            }
            aVar.dV(9, this.naJ);
            aVar.C(10, this.mZV);
            aVar.dV(11, this.mNO);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mOk != null) {
                r0 += a.a.a.b.b.a.f(2, this.mOk);
            }
            r0 = (r0 + a.a.a.a.dS(3, this.mqS)) + a.a.a.a.B(4, this.mqT);
            if (this.gom != null) {
                r0 += a.a.a.b.b.a.f(6, this.gom);
            }
            if (this.naI != null) {
                r0 += a.a.a.a.dU(8, this.naI.aHr());
            }
            return ((r0 + a.a.a.a.dS(9, this.naJ)) + a.a.a.a.B(10, this.mZV)) + a.a.a.a.dS(11, this.mNO);
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
            bfa com_tencent_mm_protocal_c_bfa = (bfa) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
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
                        com_tencent_mm_protocal_c_bfa.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfa.mOk = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfa.mqS = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfa.mqT = aVar3.pMj.mI();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bfa.gom = aVar3.pMj.readString();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bfz com_tencent_mm_protocal_c_bfz = new bfz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfz.a(aVar4, com_tencent_mm_protocal_c_bfz, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfa.naI = com_tencent_mm_protocal_c_bfz;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bfa.naJ = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bfa.mZV = aVar3.pMj.mI();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bfa.mNO = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
