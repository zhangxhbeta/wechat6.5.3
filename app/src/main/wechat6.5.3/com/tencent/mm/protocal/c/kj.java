package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class kj extends aqp {
    public String glj;
    public String mgs;
    public am mkb;
    public String mmT;
    public String mmU;
    public String mmV;
    public String mmW;
    public int mmX;
    public String mmu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.glj != null) {
                aVar.e(2, this.glj);
            }
            if (this.mmT != null) {
                aVar.e(3, this.mmT);
            }
            if (this.mgs != null) {
                aVar.e(4, this.mgs);
            }
            if (this.mmU != null) {
                aVar.e(5, this.mmU);
            }
            if (this.mmV != null) {
                aVar.e(6, this.mmV);
            }
            if (this.mmW != null) {
                aVar.e(7, this.mmW);
            }
            if (this.mmu != null) {
                aVar.e(8, this.mmu);
            }
            aVar.dV(9, this.mmX);
            if (this.mkb == null) {
                return 0;
            }
            aVar.dX(10, this.mkb.aHr());
            this.mkb.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.glj != null) {
                r0 += a.a.a.b.b.a.f(2, this.glj);
            }
            if (this.mmT != null) {
                r0 += a.a.a.b.b.a.f(3, this.mmT);
            }
            if (this.mgs != null) {
                r0 += a.a.a.b.b.a.f(4, this.mgs);
            }
            if (this.mmU != null) {
                r0 += a.a.a.b.b.a.f(5, this.mmU);
            }
            if (this.mmV != null) {
                r0 += a.a.a.b.b.a.f(6, this.mmV);
            }
            if (this.mmW != null) {
                r0 += a.a.a.b.b.a.f(7, this.mmW);
            }
            if (this.mmu != null) {
                r0 += a.a.a.b.b.a.f(8, this.mmu);
            }
            r0 += a.a.a.a.dS(9, this.mmX);
            if (this.mkb != null) {
                r0 += a.a.a.a.dU(10, this.mkb.aHr());
            }
            return r0;
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
            kj kjVar = (kj) objArr[1];
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
                        kjVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    kjVar.glj = aVar3.pMj.readString();
                    return 0;
                case 3:
                    kjVar.mmT = aVar3.pMj.readString();
                    return 0;
                case 4:
                    kjVar.mgs = aVar3.pMj.readString();
                    return 0;
                case 5:
                    kjVar.mmU = aVar3.pMj.readString();
                    return 0;
                case 6:
                    kjVar.mmV = aVar3.pMj.readString();
                    return 0;
                case 7:
                    kjVar.mmW = aVar3.pMj.readString();
                    return 0;
                case 8:
                    kjVar.mmu = aVar3.pMj.readString();
                    return 0;
                case 9:
                    kjVar.mmX = aVar3.pMj.mH();
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        am amVar = new am();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = amVar.a(aVar4, amVar, aqp.a(aVar4))) {
                        }
                        kjVar.mkb = amVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
