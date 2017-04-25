package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class nl extends aqp {
    public int efm;
    public String glj;
    public String gln;
    public int mcM;
    public int mdA;
    public int mdB;
    public int mdz;
    public String mfo;
    public String mpq;
    public int mpr;
    public int mps;

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
            aVar.dV(3, this.mcM);
            if (this.mfo != null) {
                aVar.e(4, this.mfo);
            }
            if (this.gln != null) {
                aVar.e(5, this.gln);
            }
            aVar.dV(6, this.mdz);
            aVar.dV(7, this.mdA);
            aVar.dV(8, this.mdB);
            if (this.mpq != null) {
                aVar.e(9, this.mpq);
            }
            aVar.dV(10, this.mpr);
            aVar.dV(11, this.efm);
            aVar.dV(12, this.mps);
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
            r0 += a.a.a.a.dS(3, this.mcM);
            if (this.mfo != null) {
                r0 += a.a.a.b.b.a.f(4, this.mfo);
            }
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(5, this.gln);
            }
            r0 = ((r0 + a.a.a.a.dS(6, this.mdz)) + a.a.a.a.dS(7, this.mdA)) + a.a.a.a.dS(8, this.mdB);
            if (this.mpq != null) {
                r0 += a.a.a.b.b.a.f(9, this.mpq);
            }
            return ((r0 + a.a.a.a.dS(10, this.mpr)) + a.a.a.a.dS(11, this.efm)) + a.a.a.a.dS(12, this.mps);
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
            nl nlVar = (nl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        nlVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    nlVar.glj = aVar3.pMj.readString();
                    return 0;
                case 3:
                    nlVar.mcM = aVar3.pMj.mH();
                    return 0;
                case 4:
                    nlVar.mfo = aVar3.pMj.readString();
                    return 0;
                case 5:
                    nlVar.gln = aVar3.pMj.readString();
                    return 0;
                case 6:
                    nlVar.mdz = aVar3.pMj.mH();
                    return 0;
                case 7:
                    nlVar.mdA = aVar3.pMj.mH();
                    return 0;
                case 8:
                    nlVar.mdB = aVar3.pMj.mH();
                    return 0;
                case 9:
                    nlVar.mpq = aVar3.pMj.readString();
                    return 0;
                case 10:
                    nlVar.mpr = aVar3.pMj.mH();
                    return 0;
                case 11:
                    nlVar.efm = aVar3.pMj.mH();
                    return 0;
                case 12:
                    nlVar.mps = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
