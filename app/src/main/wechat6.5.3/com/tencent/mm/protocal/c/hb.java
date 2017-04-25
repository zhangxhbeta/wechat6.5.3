package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class hb extends a {
    public String eES;
    public String mhE;
    public int mhF;
    public String mhI;
    public String mhK;
    public String mhS;
    public int ver;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mhK != null) {
                aVar.e(1, this.mhK);
            }
            if (this.eES != null) {
                aVar.e(2, this.eES);
            }
            aVar.dV(3, this.ver);
            if (this.mhE != null) {
                aVar.e(4, this.mhE);
            }
            if (this.mhS != null) {
                aVar.e(5, this.mhS);
            }
            aVar.dV(6, this.mhF);
            if (this.mhI == null) {
                return 0;
            }
            aVar.e(7, this.mhI);
            return 0;
        } else if (i == 1) {
            if (this.mhK != null) {
                r0 = a.a.a.b.b.a.f(1, this.mhK) + 0;
            } else {
                r0 = 0;
            }
            if (this.eES != null) {
                r0 += a.a.a.b.b.a.f(2, this.eES);
            }
            r0 += a.a.a.a.dS(3, this.ver);
            if (this.mhE != null) {
                r0 += a.a.a.b.b.a.f(4, this.mhE);
            }
            if (this.mhS != null) {
                r0 += a.a.a.b.b.a.f(5, this.mhS);
            }
            r0 += a.a.a.a.dS(6, this.mhF);
            if (this.mhI != null) {
                r0 += a.a.a.b.b.a.f(7, this.mhI);
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
            hb hbVar = (hb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hbVar.mhK = aVar3.pMj.readString();
                    return 0;
                case 2:
                    hbVar.eES = aVar3.pMj.readString();
                    return 0;
                case 3:
                    hbVar.ver = aVar3.pMj.mH();
                    return 0;
                case 4:
                    hbVar.mhE = aVar3.pMj.readString();
                    return 0;
                case 5:
                    hbVar.mhS = aVar3.pMj.readString();
                    return 0;
                case 6:
                    hbVar.mhF = aVar3.pMj.mH();
                    return 0;
                case 7:
                    hbVar.mhI = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
