package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class qz extends a {
    public String efy;
    public String gln;
    public int lZq;
    public String mbH;
    public String mgs;
    public String mmV;
    public String muL;
    public String muM;
    public String muN;
    public String muO;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mbH != null) {
                aVar.e(1, this.mbH);
            }
            if (this.efy != null) {
                aVar.e(2, this.efy);
            }
            if (this.gln != null) {
                aVar.e(3, this.gln);
            }
            if (this.muL != null) {
                aVar.e(4, this.muL);
            }
            if (this.muM != null) {
                aVar.e(5, this.muM);
            }
            if (this.muN != null) {
                aVar.e(6, this.muN);
            }
            if (this.mgs != null) {
                aVar.e(7, this.mgs);
            }
            if (this.mmV != null) {
                aVar.e(8, this.mmV);
            }
            if (this.muO != null) {
                aVar.e(9, this.muO);
            }
            aVar.dV(10, this.lZq);
            return 0;
        } else if (i == 1) {
            if (this.mbH != null) {
                r0 = a.a.a.b.b.a.f(1, this.mbH) + 0;
            } else {
                r0 = 0;
            }
            if (this.efy != null) {
                r0 += a.a.a.b.b.a.f(2, this.efy);
            }
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(3, this.gln);
            }
            if (this.muL != null) {
                r0 += a.a.a.b.b.a.f(4, this.muL);
            }
            if (this.muM != null) {
                r0 += a.a.a.b.b.a.f(5, this.muM);
            }
            if (this.muN != null) {
                r0 += a.a.a.b.b.a.f(6, this.muN);
            }
            if (this.mgs != null) {
                r0 += a.a.a.b.b.a.f(7, this.mgs);
            }
            if (this.mmV != null) {
                r0 += a.a.a.b.b.a.f(8, this.mmV);
            }
            if (this.muO != null) {
                r0 += a.a.a.b.b.a.f(9, this.muO);
            }
            return r0 + a.a.a.a.dS(10, this.lZq);
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
            qz qzVar = (qz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qzVar.mbH = aVar3.pMj.readString();
                    return 0;
                case 2:
                    qzVar.efy = aVar3.pMj.readString();
                    return 0;
                case 3:
                    qzVar.gln = aVar3.pMj.readString();
                    return 0;
                case 4:
                    qzVar.muL = aVar3.pMj.readString();
                    return 0;
                case 5:
                    qzVar.muM = aVar3.pMj.readString();
                    return 0;
                case 6:
                    qzVar.muN = aVar3.pMj.readString();
                    return 0;
                case 7:
                    qzVar.mgs = aVar3.pMj.readString();
                    return 0;
                case 8:
                    qzVar.mmV = aVar3.pMj.readString();
                    return 0;
                case 9:
                    qzVar.muO = aVar3.pMj.readString();
                    return 0;
                case 10:
                    qzVar.lZq = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
