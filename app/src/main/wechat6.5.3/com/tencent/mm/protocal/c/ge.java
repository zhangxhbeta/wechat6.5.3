package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ge extends aqp {
    public String fvz;
    public String gln;
    public int meB;
    public String meg;
    public String mep;
    public int mgA;
    public String mgB;
    public String mgC;
    public are mgD;
    public int mgE;
    public int mgF;
    public String mgw;
    public String mgx;
    public int mgy;
    public String mgz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.gln != null) {
                aVar.e(2, this.gln);
            }
            if (this.mgw != null) {
                aVar.e(3, this.mgw);
            }
            aVar.dV(4, this.meB);
            if (this.mgx != null) {
                aVar.e(5, this.mgx);
            }
            aVar.dV(6, this.mgy);
            if (this.mgz != null) {
                aVar.e(7, this.mgz);
            }
            if (this.meg != null) {
                aVar.e(8, this.meg);
            }
            aVar.dV(9, this.mgA);
            if (this.mgB != null) {
                aVar.e(10, this.mgB);
            }
            if (this.mgC != null) {
                aVar.e(11, this.mgC);
            }
            if (this.mgD != null) {
                aVar.dX(12, this.mgD.aHr());
                this.mgD.a(aVar);
            }
            if (this.fvz != null) {
                aVar.e(13, this.fvz);
            }
            aVar.dV(14, this.mgE);
            aVar.dV(15, this.mgF);
            if (this.mep == null) {
                return 0;
            }
            aVar.e(16, this.mep);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(2, this.gln);
            }
            if (this.mgw != null) {
                r0 += a.a.a.b.b.a.f(3, this.mgw);
            }
            r0 += a.a.a.a.dS(4, this.meB);
            if (this.mgx != null) {
                r0 += a.a.a.b.b.a.f(5, this.mgx);
            }
            r0 += a.a.a.a.dS(6, this.mgy);
            if (this.mgz != null) {
                r0 += a.a.a.b.b.a.f(7, this.mgz);
            }
            if (this.meg != null) {
                r0 += a.a.a.b.b.a.f(8, this.meg);
            }
            r0 += a.a.a.a.dS(9, this.mgA);
            if (this.mgB != null) {
                r0 += a.a.a.b.b.a.f(10, this.mgB);
            }
            if (this.mgC != null) {
                r0 += a.a.a.b.b.a.f(11, this.mgC);
            }
            if (this.mgD != null) {
                r0 += a.a.a.a.dU(12, this.mgD.aHr());
            }
            if (this.fvz != null) {
                r0 += a.a.a.b.b.a.f(13, this.fvz);
            }
            r0 = (r0 + a.a.a.a.dS(14, this.mgE)) + a.a.a.a.dS(15, this.mgF);
            if (this.mep != null) {
                r0 += a.a.a.b.b.a.f(16, this.mep);
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
            ge geVar = (ge) objArr[1];
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
                        geVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    geVar.gln = aVar3.pMj.readString();
                    return 0;
                case 3:
                    geVar.mgw = aVar3.pMj.readString();
                    return 0;
                case 4:
                    geVar.meB = aVar3.pMj.mH();
                    return 0;
                case 5:
                    geVar.mgx = aVar3.pMj.readString();
                    return 0;
                case 6:
                    geVar.mgy = aVar3.pMj.mH();
                    return 0;
                case 7:
                    geVar.mgz = aVar3.pMj.readString();
                    return 0;
                case 8:
                    geVar.meg = aVar3.pMj.readString();
                    return 0;
                case 9:
                    geVar.mgA = aVar3.pMj.mH();
                    return 0;
                case 10:
                    geVar.mgB = aVar3.pMj.readString();
                    return 0;
                case 11:
                    geVar.mgC = aVar3.pMj.readString();
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        geVar.mgD = enVar;
                    }
                    return 0;
                case 13:
                    geVar.fvz = aVar3.pMj.readString();
                    return 0;
                case 14:
                    geVar.mgE = aVar3.pMj.mH();
                    return 0;
                case 15:
                    geVar.mgF = aVar3.pMj.mH();
                    return 0;
                case 16:
                    geVar.mep = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
