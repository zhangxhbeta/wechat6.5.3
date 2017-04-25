package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class auj extends aqx {
    public int mSa;
    public int mSc;
    public int mcj;
    public are meT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.meT == null) {
                throw new b("Not all required fields were included: Buffer");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.meT != null) {
                    aVar.dX(2, this.meT.aHr());
                    this.meT.a(aVar);
                }
                aVar.dV(3, this.mcj);
                aVar.dV(4, this.mSa);
                aVar.dV(5, this.mSc);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.meT != null) {
                r0 += a.a.a.a.dU(2, this.meT.aHr());
            }
            return ((r0 + a.a.a.a.dS(3, this.mcj)) + a.a.a.a.dS(4, this.mSa)) + a.a.a.a.dS(5, this.mSc);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.meT != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Buffer");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            auj com_tencent_mm_protocal_c_auj = (auj) objArr[1];
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
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auj.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auj.meT = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_auj.mcj = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_auj.mSa = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_auj.mSc = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
