package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class azq extends aqx {
    public int mNn;
    public int mWl;
    public LinkedList<arf> mWm = new LinkedList();
    public int mdA;
    public int mdz;
    public int mwM;
    public int mwN;

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
            aVar.dV(2, this.mdA);
            aVar.dV(3, this.mdz);
            aVar.dV(4, this.mwM);
            aVar.dV(5, this.mwN);
            aVar.dV(6, this.mWl);
            aVar.d(7, 8, this.mWm);
            aVar.dV(8, this.mNn);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return ((((((r0 + a.a.a.a.dS(2, this.mdA)) + a.a.a.a.dS(3, this.mdz)) + a.a.a.a.dS(4, this.mwM)) + a.a.a.a.dS(5, this.mwN)) + a.a.a.a.dS(6, this.mWl)) + a.a.a.a.c(7, 8, this.mWm)) + a.a.a.a.dS(8, this.mNn);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mWm.clear();
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
            azq com_tencent_mm_protocal_c_azq = (azq) objArr[1];
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
                        com_tencent_mm_protocal_c_azq.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_azq.mdA = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azq.mdz = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_azq.mwM = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_azq.mwN = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_azq.mWl = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        arf com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_azq.mWm.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_azq.mNn = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
