package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class dq extends a {
    public String cHf;
    public String efy;
    public int gcP;
    public String gln;
    public String mbH;
    public int mex;
    public String mey;
    public String mez;

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
            aVar.dV(4, this.mex);
            if (this.mey != null) {
                aVar.e(5, this.mey);
            }
            if (this.cHf != null) {
                aVar.e(6, this.cHf);
            }
            if (this.mez != null) {
                aVar.e(7, this.mez);
            }
            aVar.dV(8, this.gcP);
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
            r0 += a.a.a.a.dS(4, this.mex);
            if (this.mey != null) {
                r0 += a.a.a.b.b.a.f(5, this.mey);
            }
            if (this.cHf != null) {
                r0 += a.a.a.b.b.a.f(6, this.cHf);
            }
            if (this.mez != null) {
                r0 += a.a.a.b.b.a.f(7, this.mez);
            }
            return r0 + a.a.a.a.dS(8, this.gcP);
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
            dq dqVar = (dq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dqVar.mbH = aVar3.pMj.readString();
                    return 0;
                case 2:
                    dqVar.efy = aVar3.pMj.readString();
                    return 0;
                case 3:
                    dqVar.gln = aVar3.pMj.readString();
                    return 0;
                case 4:
                    dqVar.mex = aVar3.pMj.mH();
                    return 0;
                case 5:
                    dqVar.mey = aVar3.pMj.readString();
                    return 0;
                case 6:
                    dqVar.cHf = aVar3.pMj.readString();
                    return 0;
                case 7:
                    dqVar.mez = aVar3.pMj.readString();
                    return 0;
                case 8:
                    dqVar.gcP = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
