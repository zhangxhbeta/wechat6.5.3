package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ja extends aqp {
    public int mkE;
    public are mkF;
    public afr mkG;
    public int mkH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mkF == null) {
                throw new b("Not all required fields were included: KeyBuf");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.mkE);
            if (this.mkF != null) {
                aVar.dX(3, this.mkF.aHr());
                this.mkF.a(aVar);
            }
            if (this.mkG != null) {
                aVar.dX(4, this.mkG.aHr());
                this.mkG.a(aVar);
            }
            aVar.dV(5, this.mkH);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mkE);
            if (this.mkF != null) {
                r0 += a.a.a.a.dU(3, this.mkF.aHr());
            }
            if (this.mkG != null) {
                r0 += a.a.a.a.dU(4, this.mkG.aHr());
            }
            return r0 + a.a.a.a.dS(5, this.mkH);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mkF != null) {
                return 0;
            }
            throw new b("Not all required fields were included: KeyBuf");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ja jaVar = (ja) objArr[1];
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
                        jaVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    jaVar.mkE = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqp.a(aVar4))) {
                        }
                        jaVar.mkF = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        afr com_tencent_mm_protocal_c_afr = new afr();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_afr.a(aVar4, com_tencent_mm_protocal_c_afr, aqp.a(aVar4))) {
                        }
                        jaVar.mkG = com_tencent_mm_protocal_c_afr;
                    }
                    return 0;
                case 5:
                    jaVar.mkH = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
