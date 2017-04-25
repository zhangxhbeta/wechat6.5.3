package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aoc extends aqx {
    public int fvC;
    public String fvD;
    public int gFM;
    public String gFN;
    public int gGc;
    public int mOl;
    public int mOn;
    public int mOo;
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
            aVar.dV(3, this.mqS);
            aVar.C(4, this.mqT);
            aVar.dV(5, this.mOn);
            aVar.dV(6, this.mOl);
            aVar.dV(7, this.gGc);
            aVar.dV(8, this.mOo);
            aVar.dV(9, this.fvC);
            if (this.fvD != null) {
                aVar.e(10, this.fvD);
            }
            aVar.dV(11, this.gFM);
            if (this.gFN == null) {
                return 0;
            }
            aVar.e(12, this.gFN);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((((r0 + a.a.a.a.dS(3, this.mqS)) + a.a.a.a.B(4, this.mqT)) + a.a.a.a.dS(5, this.mOn)) + a.a.a.a.dS(6, this.mOl)) + a.a.a.a.dS(7, this.gGc)) + a.a.a.a.dS(8, this.mOo)) + a.a.a.a.dS(9, this.fvC);
            if (this.fvD != null) {
                r0 += a.a.a.b.b.a.f(10, this.fvD);
            }
            r0 += a.a.a.a.dS(11, this.gFM);
            if (this.gFN != null) {
                r0 += a.a.a.b.b.a.f(12, this.gFN);
            }
            return r0;
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
            aoc com_tencent_mm_protocal_c_aoc = (aoc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aoc.mQl = eoVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aoc.mqS = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aoc.mqT = aVar3.pMj.mI();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aoc.mOn = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aoc.mOl = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aoc.gGc = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aoc.mOo = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aoc.fvC = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aoc.fvD = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aoc.gFM = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aoc.gFN = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
