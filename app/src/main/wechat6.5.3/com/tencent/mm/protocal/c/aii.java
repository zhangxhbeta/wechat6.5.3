package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aii extends aqx {
    public int efm;
    public int hNS;
    public int mIR;
    public int mIS;
    public int mbT;
    public arf mbV;
    public long mcb;
    public int mcj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mbV == null) {
                throw new b("Not all required fields were included: ToUserName");
            }
            aVar.dV(1, this.mcj);
            if (this.mbV != null) {
                aVar.dX(2, this.mbV.aHr());
                this.mbV.a(aVar);
            }
            aVar.dV(3, this.mbT);
            aVar.dV(4, this.mIR);
            aVar.dV(5, this.hNS);
            aVar.dV(6, this.mIS);
            aVar.dV(7, this.efm);
            aVar.C(8, this.mcb);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mcj) + 0;
            if (this.mbV != null) {
                r0 += a.a.a.a.dU(2, this.mbV.aHr());
            }
            return (((((r0 + a.a.a.a.dS(3, this.mbT)) + a.a.a.a.dS(4, this.mIR)) + a.a.a.a.dS(5, this.hNS)) + a.a.a.a.dS(6, this.mIS)) + a.a.a.a.dS(7, this.efm)) + a.a.a.a.B(8, this.mcb);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mbV != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ToUserName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aii com_tencent_mm_protocal_c_aii = (aii) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aii.mcj = aVar3.pMj.mH();
                    return 0;
                case 2:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a com_tencent_mm_protocal_c_arf = new arf();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aii.mbV = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aii.mbT = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aii.mIR = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aii.hNS = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aii.mIS = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aii.efm = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aii.mcb = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
