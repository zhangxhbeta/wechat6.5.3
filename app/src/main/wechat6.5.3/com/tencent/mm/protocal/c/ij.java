package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import android.support.v7.a.a.k;
import java.util.LinkedList;

public final class ij extends aqp {
    public String gom;
    public String gon;
    public int maG;
    public String mbZ;
    public int mfj;
    public String mjI;
    public int mjJ;
    public int mjK;
    public are mjL;
    public float mjM;
    public float mjN;
    public String mjO;
    public int mjP;
    public int mjQ;
    public int mjR;
    public int mjS;
    public String mjT;
    public int mjU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mjI != null) {
                aVar.e(1, this.mjI);
            }
            if (this.gon != null) {
                aVar.e(2, this.gon);
            }
            if (this.gom != null) {
                aVar.e(3, this.gom);
            }
            aVar.dV(4, this.mjJ);
            aVar.dV(5, this.mjK);
            if (this.mbZ != null) {
                aVar.e(6, this.mbZ);
            }
            if (this.mjL != null) {
                aVar.dX(7, this.mjL.aHr());
                this.mjL.a(aVar);
            }
            aVar.dV(8, this.maG);
            aVar.j(9, this.mjM);
            aVar.j(10, this.mjN);
            if (this.mjO != null) {
                aVar.e(11, this.mjO);
            }
            aVar.dV(12, this.mjP);
            aVar.dV(13, this.mjQ);
            aVar.dV(14, this.mjR);
            aVar.dV(15, this.mjS);
            if (this.mjT != null) {
                aVar.e(16, this.mjT);
            }
            aVar.dV(17, this.mfj);
            aVar.dV(18, this.mjU);
            return 0;
        } else if (i == 1) {
            if (this.mjI != null) {
                r0 = a.a.a.b.b.a.f(1, this.mjI) + 0;
            } else {
                r0 = 0;
            }
            if (this.gon != null) {
                r0 += a.a.a.b.b.a.f(2, this.gon);
            }
            if (this.gom != null) {
                r0 += a.a.a.b.b.a.f(3, this.gom);
            }
            r0 = (r0 + a.a.a.a.dS(4, this.mjJ)) + a.a.a.a.dS(5, this.mjK);
            if (this.mbZ != null) {
                r0 += a.a.a.b.b.a.f(6, this.mbZ);
            }
            if (this.mjL != null) {
                r0 += a.a.a.a.dU(7, this.mjL.aHr());
            }
            r0 = ((r0 + a.a.a.a.dS(8, this.maG)) + (a.a.a.b.b.a.cw(9) + 4)) + (a.a.a.b.b.a.cw(10) + 4);
            if (this.mjO != null) {
                r0 += a.a.a.b.b.a.f(11, this.mjO);
            }
            r0 = (((r0 + a.a.a.a.dS(12, this.mjP)) + a.a.a.a.dS(13, this.mjQ)) + a.a.a.a.dS(14, this.mjR)) + a.a.a.a.dS(15, this.mjS);
            if (this.mjT != null) {
                r0 += a.a.a.b.b.a.f(16, this.mjT);
            }
            return (r0 + a.a.a.a.dS(17, this.mfj)) + a.a.a.a.dS(18, this.mjU);
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
            ij ijVar = (ij) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ijVar.mjI = aVar3.pMj.readString();
                    return 0;
                case 2:
                    ijVar.gon = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ijVar.gom = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ijVar.mjJ = aVar3.pMj.mH();
                    return 0;
                case 5:
                    ijVar.mjK = aVar3.pMj.mH();
                    return 0;
                case 6:
                    ijVar.mbZ = aVar3.pMj.readString();
                    return 0;
                case 7:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a com_tencent_mm_protocal_c_are = new are();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        ijVar.mjL = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 8:
                    ijVar.maG = aVar3.pMj.mH();
                    return 0;
                case 9:
                    ijVar.mjM = aVar3.pMj.readFloat();
                    return 0;
                case 10:
                    ijVar.mjN = aVar3.pMj.readFloat();
                    return 0;
                case 11:
                    ijVar.mjO = aVar3.pMj.readString();
                    return 0;
                case 12:
                    ijVar.mjP = aVar3.pMj.mH();
                    return 0;
                case 13:
                    ijVar.mjQ = aVar3.pMj.mH();
                    return 0;
                case 14:
                    ijVar.mjR = aVar3.pMj.mH();
                    return 0;
                case 15:
                    ijVar.mjS = aVar3.pMj.mH();
                    return 0;
                case 16:
                    ijVar.mjT = aVar3.pMj.readString();
                    return 0;
                case 17:
                    ijVar.mfj = aVar3.pMj.mH();
                    return 0;
                case k.MG /*18*/:
                    ijVar.mjU = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
