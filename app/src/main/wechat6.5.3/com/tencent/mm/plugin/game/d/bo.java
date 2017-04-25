package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;

public final class bo extends a {
    public String aXz;
    public String gkC;
    public String gkT;
    public int gkU;
    public String gkV;
    public String gkW;
    public String gmN;
    public int gnF;
    public boolean gnG;
    public String gnH;
    public String gnI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkW != null) {
                aVar.e(1, this.gkW);
            }
            if (this.aXz != null) {
                aVar.e(2, this.aXz);
            }
            if (this.gkC != null) {
                aVar.e(3, this.gkC);
            }
            if (this.gmN != null) {
                aVar.e(4, this.gmN);
            }
            aVar.dV(5, this.gnF);
            aVar.ab(6, this.gnG);
            if (this.gkT != null) {
                aVar.e(7, this.gkT);
            }
            aVar.dV(8, this.gkU);
            if (this.gkV != null) {
                aVar.e(9, this.gkV);
            }
            if (this.gnH != null) {
                aVar.e(10, this.gnH);
            }
            if (this.gnI == null) {
                return 0;
            }
            aVar.e(11, this.gnI);
            return 0;
        } else if (i == 1) {
            if (this.gkW != null) {
                r0 = a.a.a.b.b.a.f(1, this.gkW) + 0;
            } else {
                r0 = 0;
            }
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(2, this.aXz);
            }
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(3, this.gkC);
            }
            if (this.gmN != null) {
                r0 += a.a.a.b.b.a.f(4, this.gmN);
            }
            r0 = (r0 + a.a.a.a.dS(5, this.gnF)) + (a.a.a.b.b.a.cw(6) + 1);
            if (this.gkT != null) {
                r0 += a.a.a.b.b.a.f(7, this.gkT);
            }
            r0 += a.a.a.a.dS(8, this.gkU);
            if (this.gkV != null) {
                r0 += a.a.a.b.b.a.f(9, this.gkV);
            }
            if (this.gnH != null) {
                r0 += a.a.a.b.b.a.f(10, this.gnH);
            }
            if (this.gnI != null) {
                r0 += a.a.a.b.b.a.f(11, this.gnI);
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
            bo boVar = (bo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    boVar.gkW = aVar3.pMj.readString();
                    return 0;
                case 2:
                    boVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 3:
                    boVar.gkC = aVar3.pMj.readString();
                    return 0;
                case 4:
                    boVar.gmN = aVar3.pMj.readString();
                    return 0;
                case 5:
                    boVar.gnF = aVar3.pMj.mH();
                    return 0;
                case 6:
                    boVar.gnG = aVar3.bQJ();
                    return 0;
                case 7:
                    boVar.gkT = aVar3.pMj.readString();
                    return 0;
                case 8:
                    boVar.gkU = aVar3.pMj.mH();
                    return 0;
                case 9:
                    boVar.gkV = aVar3.pMj.readString();
                    return 0;
                case 10:
                    boVar.gnH = aVar3.pMj.readString();
                    return 0;
                case 11:
                    boVar.gnI = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
