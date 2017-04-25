package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;

public final class bu extends a {
    public String aXz;
    public String gkC;
    public String gkT;
    public int gkU;
    public String gkV;
    public String gkW;
    public String gkX;
    public String gnR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkW != null) {
                aVar.e(1, this.gkW);
            }
            if (this.gnR != null) {
                aVar.e(2, this.gnR);
            }
            if (this.aXz != null) {
                aVar.e(3, this.aXz);
            }
            if (this.gkC != null) {
                aVar.e(4, this.gkC);
            }
            if (this.gkX != null) {
                aVar.e(5, this.gkX);
            }
            if (this.gkT != null) {
                aVar.e(6, this.gkT);
            }
            aVar.dV(7, this.gkU);
            if (this.gkV == null) {
                return 0;
            }
            aVar.e(8, this.gkV);
            return 0;
        } else if (i == 1) {
            if (this.gkW != null) {
                r0 = a.a.a.b.b.a.f(1, this.gkW) + 0;
            } else {
                r0 = 0;
            }
            if (this.gnR != null) {
                r0 += a.a.a.b.b.a.f(2, this.gnR);
            }
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(3, this.aXz);
            }
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(4, this.gkC);
            }
            if (this.gkX != null) {
                r0 += a.a.a.b.b.a.f(5, this.gkX);
            }
            if (this.gkT != null) {
                r0 += a.a.a.b.b.a.f(6, this.gkT);
            }
            r0 += a.a.a.a.dS(7, this.gkU);
            if (this.gkV != null) {
                r0 += a.a.a.b.b.a.f(8, this.gkV);
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
            bu buVar = (bu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    buVar.gkW = aVar3.pMj.readString();
                    return 0;
                case 2:
                    buVar.gnR = aVar3.pMj.readString();
                    return 0;
                case 3:
                    buVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 4:
                    buVar.gkC = aVar3.pMj.readString();
                    return 0;
                case 5:
                    buVar.gkX = aVar3.pMj.readString();
                    return 0;
                case 6:
                    buVar.gkT = aVar3.pMj.readString();
                    return 0;
                case 7:
                    buVar.gkU = aVar3.pMj.mH();
                    return 0;
                case 8:
                    buVar.gkV = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
