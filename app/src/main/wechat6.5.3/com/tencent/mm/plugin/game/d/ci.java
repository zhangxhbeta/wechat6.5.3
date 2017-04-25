package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;

public final class ci extends a {
    public String gld;
    public String gop;
    public String goq;
    public String gor;
    public String gos;
    public int got;
    public String gou;
    public String gov;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gld != null) {
                aVar.e(1, this.gld);
            }
            if (this.gop != null) {
                aVar.e(2, this.gop);
            }
            if (this.goq != null) {
                aVar.e(3, this.goq);
            }
            if (this.gor != null) {
                aVar.e(4, this.gor);
            }
            if (this.gos != null) {
                aVar.e(5, this.gos);
            }
            aVar.dV(6, this.got);
            if (this.gou != null) {
                aVar.e(7, this.gou);
            }
            if (this.gov == null) {
                return 0;
            }
            aVar.e(8, this.gov);
            return 0;
        } else if (i == 1) {
            if (this.gld != null) {
                r0 = a.a.a.b.b.a.f(1, this.gld) + 0;
            } else {
                r0 = 0;
            }
            if (this.gop != null) {
                r0 += a.a.a.b.b.a.f(2, this.gop);
            }
            if (this.goq != null) {
                r0 += a.a.a.b.b.a.f(3, this.goq);
            }
            if (this.gor != null) {
                r0 += a.a.a.b.b.a.f(4, this.gor);
            }
            if (this.gos != null) {
                r0 += a.a.a.b.b.a.f(5, this.gos);
            }
            r0 += a.a.a.a.dS(6, this.got);
            if (this.gou != null) {
                r0 += a.a.a.b.b.a.f(7, this.gou);
            }
            if (this.gov != null) {
                r0 += a.a.a.b.b.a.f(8, this.gov);
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
            ci ciVar = (ci) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ciVar.gld = aVar3.pMj.readString();
                    return 0;
                case 2:
                    ciVar.gop = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ciVar.goq = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ciVar.gor = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ciVar.gos = aVar3.pMj.readString();
                    return 0;
                case 6:
                    ciVar.got = aVar3.pMj.mH();
                    return 0;
                case 7:
                    ciVar.gou = aVar3.pMj.readString();
                    return 0;
                case 8:
                    ciVar.gov = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
