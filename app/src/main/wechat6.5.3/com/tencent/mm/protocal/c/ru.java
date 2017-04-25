package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import android.support.v7.a.a.k;
import java.util.LinkedList;

public final class ru extends aqp {
    public String gln;
    public int lZm;
    public int maG;
    public int mbK;
    public are med;
    public arf mvA;
    public String mvB;
    public int mvC;
    public String mvD;
    public are mvE;
    public int mvF;
    public int mvG;
    public String mvH;
    public int mvI;
    public int mvJ;
    public arf mvx;
    public arf mvy;
    public arf mvz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.lZm);
            if (this.med != null) {
                aVar.dX(3, this.med.aHr());
                this.med.a(aVar);
            }
            if (this.mvx != null) {
                aVar.dX(4, this.mvx.aHr());
                this.mvx.a(aVar);
            }
            if (this.mvy != null) {
                aVar.dX(5, this.mvy.aHr());
                this.mvy.a(aVar);
            }
            if (this.mvz != null) {
                aVar.dX(6, this.mvz.aHr());
                this.mvz.a(aVar);
            }
            if (this.mvA != null) {
                aVar.dX(7, this.mvA.aHr());
                this.mvA.a(aVar);
            }
            if (this.mvB != null) {
                aVar.e(8, this.mvB);
            }
            aVar.dV(9, this.mvC);
            aVar.dV(10, this.maG);
            if (this.gln != null) {
                aVar.e(11, this.gln);
            }
            if (this.mvD != null) {
                aVar.e(12, this.mvD);
            }
            if (this.mvE != null) {
                aVar.dX(13, this.mvE.aHr());
                this.mvE.a(aVar);
            }
            aVar.dV(14, this.mvF);
            aVar.dV(15, this.mvG);
            aVar.dV(16, this.mbK);
            if (this.mvH != null) {
                aVar.e(17, this.mvH);
            }
            aVar.dV(18, this.mvI);
            aVar.dV(19, this.mvJ);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.lZm);
            if (this.med != null) {
                r0 += a.a.a.a.dU(3, this.med.aHr());
            }
            if (this.mvx != null) {
                r0 += a.a.a.a.dU(4, this.mvx.aHr());
            }
            if (this.mvy != null) {
                r0 += a.a.a.a.dU(5, this.mvy.aHr());
            }
            if (this.mvz != null) {
                r0 += a.a.a.a.dU(6, this.mvz.aHr());
            }
            if (this.mvA != null) {
                r0 += a.a.a.a.dU(7, this.mvA.aHr());
            }
            if (this.mvB != null) {
                r0 += a.a.a.b.b.a.f(8, this.mvB);
            }
            r0 = (r0 + a.a.a.a.dS(9, this.mvC)) + a.a.a.a.dS(10, this.maG);
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(11, this.gln);
            }
            if (this.mvD != null) {
                r0 += a.a.a.b.b.a.f(12, this.mvD);
            }
            if (this.mvE != null) {
                r0 += a.a.a.a.dU(13, this.mvE.aHr());
            }
            r0 = ((r0 + a.a.a.a.dS(14, this.mvF)) + a.a.a.a.dS(15, this.mvG)) + a.a.a.a.dS(16, this.mbK);
            if (this.mvH != null) {
                r0 += a.a.a.b.b.a.f(17, this.mvH);
            }
            return (r0 + a.a.a.a.dS(18, this.mvI)) + a.a.a.a.dS(19, this.mvJ);
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
            ru ruVar = (ru) objArr[1];
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
                        ruVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    ruVar.lZm = aVar3.pMj.mH();
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
                        ruVar.med = enVar;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ruVar.mvx = enVar;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ruVar.mvy = enVar;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ruVar.mvz = enVar;
                    }
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ruVar.mvA = enVar;
                    }
                    return 0;
                case 8:
                    ruVar.mvB = aVar3.pMj.readString();
                    return 0;
                case 9:
                    ruVar.mvC = aVar3.pMj.mH();
                    return 0;
                case 10:
                    ruVar.maG = aVar3.pMj.mH();
                    return 0;
                case 11:
                    ruVar.gln = aVar3.pMj.readString();
                    return 0;
                case 12:
                    ruVar.mvD = aVar3.pMj.readString();
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
                        ruVar.mvE = enVar;
                    }
                    return 0;
                case 14:
                    ruVar.mvF = aVar3.pMj.mH();
                    return 0;
                case 15:
                    ruVar.mvG = aVar3.pMj.mH();
                    return 0;
                case 16:
                    ruVar.mbK = aVar3.pMj.mH();
                    return 0;
                case 17:
                    ruVar.mvH = aVar3.pMj.readString();
                    return 0;
                case k.MG /*18*/:
                    ruVar.mvI = aVar3.pMj.mH();
                    return 0;
                case 19:
                    ruVar.mvJ = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
