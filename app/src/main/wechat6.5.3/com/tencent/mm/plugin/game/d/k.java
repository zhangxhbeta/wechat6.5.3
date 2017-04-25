package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;

public final class k extends a {
    public String gkx;
    public int gli;
    public String glj;
    public int glk;
    public int gll;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.gli);
            if (this.glj != null) {
                aVar.e(2, this.glj);
            }
            aVar.dV(3, this.glk);
            if (this.gkx != null) {
                aVar.e(4, this.gkx);
            }
            aVar.dV(5, this.gll);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.gli) + 0;
            if (this.glj != null) {
                r0 += a.a.a.b.b.a.f(2, this.glj);
            }
            r0 += a.a.a.a.dS(3, this.glk);
            if (this.gkx != null) {
                r0 += a.a.a.b.b.a.f(4, this.gkx);
            }
            return r0 + a.a.a.a.dS(5, this.gll);
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
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.gli = aVar3.pMj.mH();
                    return 0;
                case 2:
                    kVar.glj = aVar3.pMj.readString();
                    return 0;
                case 3:
                    kVar.glk = aVar3.pMj.mH();
                    return 0;
                case 4:
                    kVar.gkx = aVar3.pMj.readString();
                    return 0;
                case 5:
                    kVar.gll = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
