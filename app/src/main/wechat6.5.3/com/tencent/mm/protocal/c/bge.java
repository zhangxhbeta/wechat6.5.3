package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bge extends aqx {
    public int miR;
    public are mkF;
    public int mqS;
    public long mqT;
    public bfd nbL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mkF == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.nbL == null) {
                throw new b("Not all required fields were included: CmdList");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                aVar.dV(3, this.mqS);
                if (this.mkF != null) {
                    aVar.dX(4, this.mkF.aHr());
                    this.mkF.a(aVar);
                }
                if (this.nbL != null) {
                    aVar.dX(5, this.nbL.aHr());
                    this.nbL.a(aVar);
                }
                aVar.dV(7, this.miR);
                aVar.C(8, this.mqT);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(3, this.mqS);
            if (this.mkF != null) {
                r0 += a.a.a.a.dU(4, this.mkF.aHr());
            }
            if (this.nbL != null) {
                r0 += a.a.a.a.dU(5, this.nbL.aHr());
            }
            return (r0 + a.a.a.a.dS(7, this.miR)) + a.a.a.a.B(8, this.mqT);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mkF == null) {
                throw new b("Not all required fields were included: KeyBuf");
            } else if (this.nbL != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CmdList");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bge com_tencent_mm_protocal_c_bge = (bge) objArr[1];
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
                        com_tencent_mm_protocal_c_bge.mQl = eoVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bge.mqS = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bge.mkF = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bfd com_tencent_mm_protocal_c_bfd = new bfd();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfd.a(aVar4, com_tencent_mm_protocal_c_bfd, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bge.nbL = com_tencent_mm_protocal_c_bfd;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bge.miR = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bge.mqT = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
