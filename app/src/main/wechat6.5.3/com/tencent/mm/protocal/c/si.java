package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class si extends aqx {
    public String mdQ;
    public String mdS;
    public aky mwi;
    public int mwj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mwi == null) {
                throw new b("Not all required fields were included: AppInfo");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.mwi != null) {
                    aVar.dX(2, this.mwi.aHr());
                    this.mwi.a(aVar);
                }
                aVar.dV(3, this.mwj);
                if (this.mdS != null) {
                    aVar.e(4, this.mdS);
                }
                if (this.mdQ == null) {
                    return 0;
                }
                aVar.e(5, this.mdQ);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mwi != null) {
                r0 += a.a.a.a.dU(2, this.mwi.aHr());
            }
            r0 += a.a.a.a.dS(3, this.mwj);
            if (this.mdS != null) {
                r0 += a.a.a.b.b.a.f(4, this.mdS);
            }
            if (this.mdQ != null) {
                r0 += a.a.a.b.b.a.f(5, this.mdQ);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mwi != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AppInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            si siVar = (si) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a eoVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        siVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new aky();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        siVar.mwi = eoVar;
                    }
                    return 0;
                case 3:
                    siVar.mwj = aVar3.pMj.mH();
                    return 0;
                case 4:
                    siVar.mdS = aVar3.pMj.readString();
                    return 0;
                case 5:
                    siVar.mdQ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
