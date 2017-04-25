package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class kr extends aqp {
    public int mbT;
    public long mcb;
    public int mdz;
    public String mne;
    public bdx mnf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mne != null) {
                aVar.e(2, this.mne);
            }
            aVar.dV(3, this.mdz);
            aVar.dV(4, this.mbT);
            if (this.mnf != null) {
                aVar.dX(5, this.mnf.aHr());
                this.mnf.a(aVar);
            }
            aVar.C(6, this.mcb);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mne != null) {
                r0 += a.a.a.b.b.a.f(2, this.mne);
            }
            r0 = (r0 + a.a.a.a.dS(3, this.mdz)) + a.a.a.a.dS(4, this.mbT);
            if (this.mnf != null) {
                r0 += a.a.a.a.dU(5, this.mnf.aHr());
            }
            return r0 + a.a.a.a.B(6, this.mcb);
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
            kr krVar = (kr) objArr[1];
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
                        krVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    krVar.mne = aVar3.pMj.readString();
                    return 0;
                case 3:
                    krVar.mdz = aVar3.pMj.mH();
                    return 0;
                case 4:
                    krVar.mbT = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new bdx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        krVar.mnf = enVar;
                    }
                    return 0;
                case 6:
                    krVar.mcb = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
