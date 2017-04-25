package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;

public final class bn extends a {
    public String aXz;
    public String gkC;
    public String gkT;
    public int gkU;
    public String gkV;
    public String gnD;
    public int gnE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.aXz != null) {
                aVar.e(1, this.aXz);
            }
            if (this.gkC != null) {
                aVar.e(2, this.gkC);
            }
            if (this.gnD != null) {
                aVar.e(3, this.gnD);
            }
            if (this.gkT != null) {
                aVar.e(4, this.gkT);
            }
            aVar.dV(5, this.gnE);
            aVar.dV(6, this.gkU);
            if (this.gkV == null) {
                return 0;
            }
            aVar.e(7, this.gkV);
            return 0;
        } else if (i == 1) {
            if (this.aXz != null) {
                r0 = a.a.a.b.b.a.f(1, this.aXz) + 0;
            } else {
                r0 = 0;
            }
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkC);
            }
            if (this.gnD != null) {
                r0 += a.a.a.b.b.a.f(3, this.gnD);
            }
            if (this.gkT != null) {
                r0 += a.a.a.b.b.a.f(4, this.gkT);
            }
            r0 = (r0 + a.a.a.a.dS(5, this.gnE)) + a.a.a.a.dS(6, this.gkU);
            if (this.gkV != null) {
                r0 += a.a.a.b.b.a.f(7, this.gkV);
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
            bn bnVar = (bn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bnVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    bnVar.gkC = aVar3.pMj.readString();
                    return 0;
                case 3:
                    bnVar.gnD = aVar3.pMj.readString();
                    return 0;
                case 4:
                    bnVar.gkT = aVar3.pMj.readString();
                    return 0;
                case 5:
                    bnVar.gnE = aVar3.pMj.mH();
                    return 0;
                case 6:
                    bnVar.gkU = aVar3.pMj.mH();
                    return 0;
                case 7:
                    bnVar.gkV = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
