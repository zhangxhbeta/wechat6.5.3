package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class akz extends aqp {
    public int gll;
    public String mLT;
    public ln mLU;
    public ln mLV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mLU == null) {
                throw new b("Not all required fields were included: BigContentInfo");
            } else if (this.mLV == null) {
                throw new b("Not all required fields were included: SmallContentInfo");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.mLT != null) {
                    aVar.e(2, this.mLT);
                }
                if (this.mLU != null) {
                    aVar.dX(3, this.mLU.aHr());
                    this.mLU.a(aVar);
                }
                if (this.mLV != null) {
                    aVar.dX(4, this.mLV.aHr());
                    this.mLV.a(aVar);
                }
                aVar.dV(5, this.gll);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mLT != null) {
                r0 += a.a.a.b.b.a.f(2, this.mLT);
            }
            if (this.mLU != null) {
                r0 += a.a.a.a.dU(3, this.mLU.aHr());
            }
            if (this.mLV != null) {
                r0 += a.a.a.a.dU(4, this.mLV.aHr());
            }
            return r0 + a.a.a.a.dS(5, this.gll);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mLU == null) {
                throw new b("Not all required fields were included: BigContentInfo");
            } else if (this.mLV != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SmallContentInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            akz com_tencent_mm_protocal_c_akz = (akz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            ln lnVar;
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
                        com_tencent_mm_protocal_c_akz.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akz.mLT = aVar3.pMj.readString();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        lnVar = new ln();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lnVar.a(aVar4, lnVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akz.mLU = lnVar;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        lnVar = new ln();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lnVar.a(aVar4, lnVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akz.mLV = lnVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_akz.gll = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
