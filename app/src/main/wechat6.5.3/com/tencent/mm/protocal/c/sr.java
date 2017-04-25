package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class sr extends aqp {
    public String appId;
    public String fZS;
    public String fZT;
    public String fZU;
    public String fZV;
    public String fZW;
    public String lZp;
    public int lZq;
    public cc mwq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.appId != null) {
                aVar.e(2, this.appId);
            }
            if (this.fZS != null) {
                aVar.e(3, this.fZS);
            }
            if (this.fZT != null) {
                aVar.e(4, this.fZT);
            }
            if (this.fZU != null) {
                aVar.e(5, this.fZU);
            }
            if (this.fZV != null) {
                aVar.e(6, this.fZV);
            }
            if (this.fZW != null) {
                aVar.e(7, this.fZW);
            }
            if (this.mwq != null) {
                aVar.dX(8, this.mwq.aHr());
                this.mwq.a(aVar);
            }
            if (this.lZp != null) {
                aVar.e(9, this.lZp);
            }
            aVar.dV(10, this.lZq);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.appId != null) {
                r0 += a.a.a.b.b.a.f(2, this.appId);
            }
            if (this.fZS != null) {
                r0 += a.a.a.b.b.a.f(3, this.fZS);
            }
            if (this.fZT != null) {
                r0 += a.a.a.b.b.a.f(4, this.fZT);
            }
            if (this.fZU != null) {
                r0 += a.a.a.b.b.a.f(5, this.fZU);
            }
            if (this.fZV != null) {
                r0 += a.a.a.b.b.a.f(6, this.fZV);
            }
            if (this.fZW != null) {
                r0 += a.a.a.b.b.a.f(7, this.fZW);
            }
            if (this.mwq != null) {
                r0 += a.a.a.a.dU(8, this.mwq.aHr());
            }
            if (this.lZp != null) {
                r0 += a.a.a.b.b.a.f(9, this.lZp);
            }
            return r0 + a.a.a.a.dS(10, this.lZq);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            sr srVar = (sr) objArr[1];
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
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        srVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    srVar.appId = aVar3.pMj.readString();
                    return 0;
                case 3:
                    srVar.fZS = aVar3.pMj.readString();
                    return 0;
                case 4:
                    srVar.fZT = aVar3.pMj.readString();
                    return 0;
                case 5:
                    srVar.fZU = aVar3.pMj.readString();
                    return 0;
                case 6:
                    srVar.fZV = aVar3.pMj.readString();
                    return 0;
                case 7:
                    srVar.fZW = aVar3.pMj.readString();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        cc ccVar = new cc();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ccVar.a(aVar4, ccVar, aqp.a(aVar4))) {
                        }
                        srVar.mwq = ccVar;
                    }
                    return 0;
                case 9:
                    srVar.lZp = aVar3.pMj.readString();
                    return 0;
                case 10:
                    srVar.lZq = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
