package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class gg extends aqp {
    public are mfv;
    public String mgB;
    public String mgC;
    public String mgI;
    public int mgR;
    public String mgS;
    public String mgT;
    public String mgU;
    public int mgV;
    public arf mgW;
    public are mgX;
    public int mgY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.mgR);
            if (this.mgI != null) {
                aVar.e(3, this.mgI);
            }
            if (this.mgS != null) {
                aVar.e(4, this.mgS);
            }
            if (this.mgT != null) {
                aVar.e(5, this.mgT);
            }
            if (this.mgU != null) {
                aVar.e(6, this.mgU);
            }
            aVar.dV(7, this.mgV);
            if (this.mgW != null) {
                aVar.dX(8, this.mgW.aHr());
                this.mgW.a(aVar);
            }
            if (this.mgX != null) {
                aVar.dX(9, this.mgX.aHr());
                this.mgX.a(aVar);
            }
            aVar.dV(10, this.mgY);
            if (this.mgB != null) {
                aVar.e(11, this.mgB);
            }
            if (this.mgC != null) {
                aVar.e(12, this.mgC);
            }
            if (this.mfv == null) {
                return 0;
            }
            aVar.dX(13, this.mfv.aHr());
            this.mfv.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mgR);
            if (this.mgI != null) {
                r0 += a.a.a.b.b.a.f(3, this.mgI);
            }
            if (this.mgS != null) {
                r0 += a.a.a.b.b.a.f(4, this.mgS);
            }
            if (this.mgT != null) {
                r0 += a.a.a.b.b.a.f(5, this.mgT);
            }
            if (this.mgU != null) {
                r0 += a.a.a.b.b.a.f(6, this.mgU);
            }
            r0 += a.a.a.a.dS(7, this.mgV);
            if (this.mgW != null) {
                r0 += a.a.a.a.dU(8, this.mgW.aHr());
            }
            if (this.mgX != null) {
                r0 += a.a.a.a.dU(9, this.mgX.aHr());
            }
            r0 += a.a.a.a.dS(10, this.mgY);
            if (this.mgB != null) {
                r0 += a.a.a.b.b.a.f(11, this.mgB);
            }
            if (this.mgC != null) {
                r0 += a.a.a.b.b.a.f(12, this.mgC);
            }
            if (this.mfv != null) {
                r0 += a.a.a.a.dU(13, this.mfv.aHr());
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
            gg ggVar = (gg) objArr[1];
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
                        ggVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    ggVar.mgR = aVar3.pMj.mH();
                    return 0;
                case 3:
                    ggVar.mgI = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ggVar.mgS = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ggVar.mgT = aVar3.pMj.readString();
                    return 0;
                case 6:
                    ggVar.mgU = aVar3.pMj.readString();
                    return 0;
                case 7:
                    ggVar.mgV = aVar3.pMj.mH();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ggVar.mgW = enVar;
                    }
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ggVar.mgX = enVar;
                    }
                    return 0;
                case 10:
                    ggVar.mgY = aVar3.pMj.mH();
                    return 0;
                case 11:
                    ggVar.mgB = aVar3.pMj.readString();
                    return 0;
                case 12:
                    ggVar.mgC = aVar3.pMj.readString();
                    return 0;
                case 13:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ggVar.mfv = enVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
