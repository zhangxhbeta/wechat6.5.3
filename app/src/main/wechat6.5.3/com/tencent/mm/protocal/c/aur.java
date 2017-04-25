package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aur extends aqx {
    public LinkedList<aup> cqE = new LinkedList();
    public int eEm;
    public long mSh;
    public int mSj;

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
            aVar.d(2, 8, this.cqE);
            aVar.dV(3, this.mSj);
            aVar.C(4, this.mSh);
            aVar.dV(5, this.eEm);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + a.a.a.a.c(2, 8, this.cqE)) + a.a.a.a.dS(3, this.mSj)) + a.a.a.a.B(4, this.mSh)) + a.a.a.a.dS(5, this.eEm);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.cqE.clear();
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
            aur com_tencent_mm_protocal_c_aur = (aur) objArr[1];
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
                        com_tencent_mm_protocal_c_aur.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        aup com_tencent_mm_protocal_c_aup = new aup();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aup.a(aVar4, com_tencent_mm_protocal_c_aup, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aur.cqE.add(com_tencent_mm_protocal_c_aup);
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aur.mSj = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aur.mSh = aVar3.pMj.mI();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aur.eEm = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
