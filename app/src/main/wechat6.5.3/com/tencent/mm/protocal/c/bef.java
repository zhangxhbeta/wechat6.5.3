package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bef extends aqx {
    public int mZQ;
    public int mZW;
    public bfo mZX;
    public int mZY;
    public int mZZ;
    public int mqS;
    public long mqT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            aVar.dV(2, this.mqS);
            aVar.C(3, this.mqT);
            aVar.dV(4, this.mZW);
            if (this.mZX != null) {
                aVar.dX(5, this.mZX.aHr());
                this.mZX.a(aVar);
            }
            aVar.dV(6, this.mZQ);
            aVar.dV(7, this.mZY);
            aVar.dV(8, this.mZZ);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.dS(2, this.mqS)) + a.a.a.a.B(3, this.mqT)) + a.a.a.a.dS(4, this.mZW);
            if (this.mZX != null) {
                r0 += a.a.a.a.dU(5, this.mZX.aHr());
            }
            return ((r0 + a.a.a.a.dS(6, this.mZQ)) + a.a.a.a.dS(7, this.mZY)) + a.a.a.a.dS(8, this.mZZ);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bef com_tencent_mm_protocal_c_bef = (bef) objArr[1];
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
                        com_tencent_mm_protocal_c_bef.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bef.mqS = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bef.mqT = aVar3.pMj.mI();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bef.mZW = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bfo com_tencent_mm_protocal_c_bfo = new bfo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfo.a(aVar4, com_tencent_mm_protocal_c_bfo, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bef.mZX = com_tencent_mm_protocal_c_bfo;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bef.mZQ = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bef.mZY = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bef.mZZ = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
