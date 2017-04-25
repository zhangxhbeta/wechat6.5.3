package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ss extends aqx {
    public dq gbO;
    public int lZE;
    public int lZq;
    public int lZu;
    public String lZv;
    public auy lZw;

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
            aVar.dV(2, this.lZu);
            aVar.dV(3, this.lZE);
            if (this.lZv != null) {
                aVar.e(4, this.lZv);
            }
            if (this.lZw != null) {
                aVar.dX(5, this.lZw.aHr());
                this.lZw.a(aVar);
            }
            if (this.gbO != null) {
                aVar.dX(6, this.gbO.aHr());
                this.gbO.a(aVar);
            }
            aVar.dV(7, this.lZq);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.lZu)) + a.a.a.a.dS(3, this.lZE);
            if (this.lZv != null) {
                r0 += a.a.a.b.b.a.f(4, this.lZv);
            }
            if (this.lZw != null) {
                r0 += a.a.a.a.dU(5, this.lZw.aHr());
            }
            if (this.gbO != null) {
                r0 += a.a.a.a.dU(6, this.gbO.aHr());
            }
            return r0 + a.a.a.a.dS(7, this.lZq);
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
            ss ssVar = (ss) objArr[1];
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
                        ssVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    ssVar.lZu = aVar3.pMj.mH();
                    return 0;
                case 3:
                    ssVar.lZE = aVar3.pMj.mH();
                    return 0;
                case 4:
                    ssVar.lZv = aVar3.pMj.readString();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        auy com_tencent_mm_protocal_c_auy = new auy();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_auy.a(aVar4, com_tencent_mm_protocal_c_auy, aqx.a(aVar4))) {
                        }
                        ssVar.lZw = com_tencent_mm_protocal_c_auy;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        dq dqVar = new dq();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dqVar.a(aVar4, dqVar, aqx.a(aVar4))) {
                        }
                        ssVar.gbO = dqVar;
                    }
                    return 0;
                case 7:
                    ssVar.lZq = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
