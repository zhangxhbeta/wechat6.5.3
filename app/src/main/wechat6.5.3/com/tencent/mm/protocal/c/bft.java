package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bft extends aqp {
    public String mOk;
    public long mZV;
    public int mqS;
    public long mqT;
    public bfz naI;

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
            if (this.naI != null) {
                aVar.dX(5, this.naI.aHr());
                this.naI.a(aVar);
            }
            aVar.C(6, this.mZV);
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
            if (this.naI != null) {
                r0 += a.a.a.a.dU(5, this.naI.aHr());
            }
            return r0 + a.a.a.a.B(6, this.mZV);
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
            bft com_tencent_mm_protocal_c_bft = (bft) objArr[1];
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
                        com_tencent_mm_protocal_c_bft.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bft.mOk = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bft.mqS = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bft.mqT = aVar3.pMj.mI();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bfz com_tencent_mm_protocal_c_bfz = new bfz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfz.a(aVar4, com_tencent_mm_protocal_c_bfz, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bft.naI = com_tencent_mm_protocal_c_bfz;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bft.mZV = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
