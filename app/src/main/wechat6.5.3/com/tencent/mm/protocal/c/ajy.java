package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ajy extends aqp {
    public String fvz;
    public String gln;
    public are mKC;
    public are mKD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mKC == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.mKD == null) {
                throw new b("Not all required fields were included: MaxSynckey");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.gln != null) {
                    aVar.e(2, this.gln);
                }
                if (this.mKC != null) {
                    aVar.dX(3, this.mKC.aHr());
                    this.mKC.a(aVar);
                }
                if (this.mKD != null) {
                    aVar.dX(4, this.mKD.aHr());
                    this.mKD.a(aVar);
                }
                if (this.fvz == null) {
                    return 0;
                }
                aVar.e(5, this.fvz);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(2, this.gln);
            }
            if (this.mKC != null) {
                r0 += a.a.a.a.dU(3, this.mKC.aHr());
            }
            if (this.mKD != null) {
                r0 += a.a.a.a.dU(4, this.mKD.aHr());
            }
            if (this.fvz != null) {
                r0 += a.a.a.b.b.a.f(5, this.fvz);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mKC == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.mKD != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MaxSynckey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ajy com_tencent_mm_protocal_c_ajy = (ajy) objArr[1];
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
                        com_tencent_mm_protocal_c_ajy.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ajy.gln = aVar3.pMj.readString();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajy.mKC = enVar;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajy.mKD = enVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ajy.fvz = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
