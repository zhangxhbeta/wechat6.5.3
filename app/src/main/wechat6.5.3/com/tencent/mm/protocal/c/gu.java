package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class gu extends a {
    public String mhD;
    public String mhE;
    public int mhF;
    public int mhG;
    public String mhH;
    public String mhI;
    public String name;
    public int type;
    public int ver;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mhD != null) {
                aVar.e(1, this.mhD);
            }
            aVar.dV(2, this.type);
            if (this.mhE != null) {
                aVar.e(3, this.mhE);
            }
            if (this.name != null) {
                aVar.e(4, this.name);
            }
            aVar.dV(5, this.ver);
            aVar.dV(6, this.mhF);
            aVar.dV(7, this.mhG);
            if (this.mhH != null) {
                aVar.e(8, this.mhH);
            }
            if (this.mhI == null) {
                return 0;
            }
            aVar.e(9, this.mhI);
            return 0;
        } else if (i == 1) {
            if (this.mhD != null) {
                r0 = a.a.a.b.b.a.f(1, this.mhD) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.type);
            if (this.mhE != null) {
                r0 += a.a.a.b.b.a.f(3, this.mhE);
            }
            if (this.name != null) {
                r0 += a.a.a.b.b.a.f(4, this.name);
            }
            r0 = ((r0 + a.a.a.a.dS(5, this.ver)) + a.a.a.a.dS(6, this.mhF)) + a.a.a.a.dS(7, this.mhG);
            if (this.mhH != null) {
                r0 += a.a.a.b.b.a.f(8, this.mhH);
            }
            if (this.mhI != null) {
                r0 += a.a.a.b.b.a.f(9, this.mhI);
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
            gu guVar = (gu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    guVar.mhD = aVar3.pMj.readString();
                    return 0;
                case 2:
                    guVar.type = aVar3.pMj.mH();
                    return 0;
                case 3:
                    guVar.mhE = aVar3.pMj.readString();
                    return 0;
                case 4:
                    guVar.name = aVar3.pMj.readString();
                    return 0;
                case 5:
                    guVar.ver = aVar3.pMj.mH();
                    return 0;
                case 6:
                    guVar.mhF = aVar3.pMj.mH();
                    return 0;
                case 7:
                    guVar.mhG = aVar3.pMj.mH();
                    return 0;
                case 8:
                    guVar.mhH = aVar3.pMj.readString();
                    return 0;
                case 9:
                    guVar.mhI = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
