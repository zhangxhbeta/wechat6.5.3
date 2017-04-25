package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class auf extends aqx {
    public int eet;
    public String hQO;
    public LinkedList<aud> mRM = new LinkedList();
    public int mRN;
    public int mcj;

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
            aVar.dV(2, this.eet);
            aVar.d(3, 8, this.mRM);
            if (this.hQO != null) {
                aVar.e(4, this.hQO);
            }
            aVar.dV(5, this.mRN);
            aVar.dV(6, this.mcj);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.eet)) + a.a.a.a.c(3, 8, this.mRM);
            if (this.hQO != null) {
                r0 += a.a.a.b.b.a.f(4, this.hQO);
            }
            return (r0 + a.a.a.a.dS(5, this.mRN)) + a.a.a.a.dS(6, this.mcj);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mRM.clear();
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
            auf com_tencent_mm_protocal_c_auf = (auf) objArr[1];
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
                        com_tencent_mm_protocal_c_auf.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_auf.eet = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        aud com_tencent_mm_protocal_c_aud = new aud();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aud.a(aVar4, com_tencent_mm_protocal_c_aud, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_auf.mRM.add(com_tencent_mm_protocal_c_aud);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_auf.hQO = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_auf.mRN = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_auf.mcj = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
