package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ala extends aqx {
    public lm mLW;
    public lm mLX;
    public int mpw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mLW == null) {
                throw new b("Not all required fields were included: SmallContentBuff");
            } else if (this.mLX == null) {
                throw new b("Not all required fields were included: BigContentBuff");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.mLW != null) {
                    aVar.dX(2, this.mLW.aHr());
                    this.mLW.a(aVar);
                }
                if (this.mLX != null) {
                    aVar.dX(3, this.mLX.aHr());
                    this.mLX.a(aVar);
                }
                aVar.dV(4, this.mpw);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mLW != null) {
                r0 += a.a.a.a.dU(2, this.mLW.aHr());
            }
            if (this.mLX != null) {
                r0 += a.a.a.a.dU(3, this.mLX.aHr());
            }
            return r0 + a.a.a.a.dS(4, this.mpw);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mLW == null) {
                throw new b("Not all required fields were included: SmallContentBuff");
            } else if (this.mLX != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BigContentBuff");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ala com_tencent_mm_protocal_c_ala = (ala) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            lm lmVar;
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
                        com_tencent_mm_protocal_c_ala.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        lmVar = new lm();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lmVar.a(aVar4, lmVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ala.mLW = lmVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        lmVar = new lm();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lmVar.a(aVar4, lmVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ala.mLX = lmVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ala.mpw = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
