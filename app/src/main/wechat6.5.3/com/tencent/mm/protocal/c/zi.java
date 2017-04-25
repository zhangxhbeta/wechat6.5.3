package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class zi extends aqp {
    public String efy;
    public String fvz;
    public String mAO;
    public String mAP;
    public String mAQ;
    public String mAR;
    public String mAS;
    public int mAT;
    public String mep;
    public are mgD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mgD == null) {
                throw new b("Not all required fields were included: RandomEncryKey");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mgD != null) {
                aVar.dX(2, this.mgD.aHr());
                this.mgD.a(aVar);
            }
            if (this.mAO != null) {
                aVar.e(3, this.mAO);
            }
            if (this.mAP != null) {
                aVar.e(4, this.mAP);
            }
            if (this.efy != null) {
                aVar.e(5, this.efy);
            }
            if (this.mAQ != null) {
                aVar.e(6, this.mAQ);
            }
            if (this.mAR != null) {
                aVar.e(7, this.mAR);
            }
            if (this.mAS != null) {
                aVar.e(8, this.mAS);
            }
            aVar.dV(9, this.mAT);
            if (this.fvz != null) {
                aVar.e(10, this.fvz);
            }
            if (this.mep == null) {
                return 0;
            }
            aVar.e(11, this.mep);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mgD != null) {
                r0 += a.a.a.a.dU(2, this.mgD.aHr());
            }
            if (this.mAO != null) {
                r0 += a.a.a.b.b.a.f(3, this.mAO);
            }
            if (this.mAP != null) {
                r0 += a.a.a.b.b.a.f(4, this.mAP);
            }
            if (this.efy != null) {
                r0 += a.a.a.b.b.a.f(5, this.efy);
            }
            if (this.mAQ != null) {
                r0 += a.a.a.b.b.a.f(6, this.mAQ);
            }
            if (this.mAR != null) {
                r0 += a.a.a.b.b.a.f(7, this.mAR);
            }
            if (this.mAS != null) {
                r0 += a.a.a.b.b.a.f(8, this.mAS);
            }
            r0 += a.a.a.a.dS(9, this.mAT);
            if (this.fvz != null) {
                r0 += a.a.a.b.b.a.f(10, this.fvz);
            }
            if (this.mep != null) {
                r0 += a.a.a.b.b.a.f(11, this.mep);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mgD != null) {
                return 0;
            }
            throw new b("Not all required fields were included: RandomEncryKey");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            zi ziVar = (zi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ziVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ziVar.mgD = enVar;
                    }
                    return 0;
                case 3:
                    ziVar.mAO = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ziVar.mAP = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ziVar.efy = aVar3.pMj.readString();
                    return 0;
                case 6:
                    ziVar.mAQ = aVar3.pMj.readString();
                    return 0;
                case 7:
                    ziVar.mAR = aVar3.pMj.readString();
                    return 0;
                case 8:
                    ziVar.mAS = aVar3.pMj.readString();
                    return 0;
                case 9:
                    ziVar.mAT = aVar3.pMj.mH();
                    return 0;
                case 10:
                    ziVar.fvz = aVar3.pMj.readString();
                    return 0;
                case 11:
                    ziVar.mep = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
