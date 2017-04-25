package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ej extends aqp {
    public String mcN;
    public int mdB;
    public String meZ;
    public int mfa;
    public dy mfp;
    public are mfq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.meZ != null) {
                aVar.e(2, this.meZ);
            }
            if (this.mcN != null) {
                aVar.e(3, this.mcN);
            }
            if (this.mfp != null) {
                aVar.dX(4, this.mfp.aHr());
                this.mfp.a(aVar);
            }
            aVar.dV(5, this.mfa);
            aVar.dV(6, this.mdB);
            if (this.mfq == null) {
                return 0;
            }
            aVar.dX(7, this.mfq.aHr());
            this.mfq.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.meZ != null) {
                r0 += a.a.a.b.b.a.f(2, this.meZ);
            }
            if (this.mcN != null) {
                r0 += a.a.a.b.b.a.f(3, this.mcN);
            }
            if (this.mfp != null) {
                r0 += a.a.a.a.dU(4, this.mfp.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(5, this.mfa)) + a.a.a.a.dS(6, this.mdB);
            if (this.mfq != null) {
                r0 += a.a.a.a.dU(7, this.mfq.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ej ejVar = (ej) objArr[1];
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
                        ejVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    ejVar.meZ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ejVar.mcN = aVar3.pMj.readString();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new dy();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ejVar.mfp = enVar;
                    }
                    return 0;
                case 5:
                    ejVar.mfa = aVar3.pMj.mH();
                    return 0;
                case 6:
                    ejVar.mdB = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ejVar.mfq = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
