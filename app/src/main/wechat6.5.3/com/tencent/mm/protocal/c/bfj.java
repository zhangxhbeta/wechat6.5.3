package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bfj extends aqx {
    public int eOX;
    public int hNS;
    public int mqS;
    public long mqT;
    public int naJ;
    public String naR;
    public LinkedList<bgc> naS = new LinkedList();

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
            aVar.dV(4, this.hNS);
            aVar.dV(6, this.eOX);
            aVar.d(7, 8, this.naS);
            if (this.naR != null) {
                aVar.e(8, this.naR);
            }
            aVar.dV(9, this.naJ);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + a.a.a.a.dS(2, this.mqS)) + a.a.a.a.B(3, this.mqT)) + a.a.a.a.dS(4, this.hNS)) + a.a.a.a.dS(6, this.eOX)) + a.a.a.a.c(7, 8, this.naS);
            if (this.naR != null) {
                r0 += a.a.a.b.b.a.f(8, this.naR);
            }
            return r0 + a.a.a.a.dS(9, this.naJ);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.naS.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            bfj com_tencent_mm_protocal_c_bfj = (bfj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfj.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfj.mqS = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfj.mqT = aVar3.pMj.mI();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfj.hNS = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bfj.eOX = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bgc com_tencent_mm_protocal_c_bgc = new bgc();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bgc.a(aVar4, com_tencent_mm_protocal_c_bgc, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfj.naS.add(com_tencent_mm_protocal_c_bgc);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bfj.naR = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bfj.naJ = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
