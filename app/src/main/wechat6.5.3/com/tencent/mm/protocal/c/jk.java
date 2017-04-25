package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class jk extends a {
    public String eBZ;
    public int mlH;
    public String mlI;
    public String mlJ;
    public String mlK;
    public int mlL;
    public String mlM;
    public int mlN;
    public String mlO;
    public int mlP;
    public String mlQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mlH);
            if (this.mlI != null) {
                aVar.e(2, this.mlI);
            }
            if (this.mlJ != null) {
                aVar.e(3, this.mlJ);
            }
            if (this.mlK != null) {
                aVar.e(4, this.mlK);
            }
            aVar.dV(5, this.mlL);
            if (this.mlM != null) {
                aVar.e(6, this.mlM);
            }
            aVar.dV(7, this.mlN);
            if (this.eBZ != null) {
                aVar.e(8, this.eBZ);
            }
            if (this.mlO != null) {
                aVar.e(9, this.mlO);
            }
            aVar.dV(10, this.mlP);
            if (this.mlQ != null) {
                aVar.e(11, this.mlQ);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mlH) + 0;
            if (this.mlI != null) {
                r0 += a.a.a.b.b.a.f(2, this.mlI);
            }
            if (this.mlJ != null) {
                r0 += a.a.a.b.b.a.f(3, this.mlJ);
            }
            if (this.mlK != null) {
                r0 += a.a.a.b.b.a.f(4, this.mlK);
            }
            r0 += a.a.a.a.dS(5, this.mlL);
            if (this.mlM != null) {
                r0 += a.a.a.b.b.a.f(6, this.mlM);
            }
            r0 += a.a.a.a.dS(7, this.mlN);
            if (this.eBZ != null) {
                r0 += a.a.a.b.b.a.f(8, this.eBZ);
            }
            if (this.mlO != null) {
                r0 += a.a.a.b.b.a.f(9, this.mlO);
            }
            r0 += a.a.a.a.dS(10, this.mlP);
            if (this.mlQ != null) {
                return r0 + a.a.a.b.b.a.f(11, this.mlQ);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            jk jkVar = (jk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jkVar.mlH = aVar3.pMj.mH();
                    return 0;
                case 2:
                    jkVar.mlI = aVar3.pMj.readString();
                    return 0;
                case 3:
                    jkVar.mlJ = aVar3.pMj.readString();
                    return 0;
                case 4:
                    jkVar.mlK = aVar3.pMj.readString();
                    return 0;
                case 5:
                    jkVar.mlL = aVar3.pMj.mH();
                    return 0;
                case 6:
                    jkVar.mlM = aVar3.pMj.readString();
                    return 0;
                case 7:
                    jkVar.mlN = aVar3.pMj.mH();
                    return 0;
                case 8:
                    jkVar.eBZ = aVar3.pMj.readString();
                    return 0;
                case 9:
                    jkVar.mlO = aVar3.pMj.readString();
                    return 0;
                case 10:
                    jkVar.mlP = aVar3.pMj.mH();
                    return 0;
                case 11:
                    jkVar.mlQ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
