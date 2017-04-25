package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class awx extends aqx {
    public int eet;
    public LinkedList<awv> eeu = new LinkedList();
    public int lZm;
    public String mUk;

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
            aVar.dV(2, this.lZm);
            if (this.mUk != null) {
                aVar.e(3, this.mUk);
            }
            aVar.dV(4, this.eet);
            aVar.d(5, 8, this.eeu);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.lZm);
            if (this.mUk != null) {
                r0 += a.a.a.b.b.a.f(3, this.mUk);
            }
            return (r0 + a.a.a.a.dS(4, this.eet)) + a.a.a.a.c(5, 8, this.eeu);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.eeu.clear();
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
            awx com_tencent_mm_protocal_c_awx = (awx) objArr[1];
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
                        com_tencent_mm_protocal_c_awx.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_awx.lZm = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_awx.mUk = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_awx.eet = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        awv com_tencent_mm_protocal_c_awv = new awv();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_awv.a(aVar4, com_tencent_mm_protocal_c_awv, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awx.eeu.add(com_tencent_mm_protocal_c_awv);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
