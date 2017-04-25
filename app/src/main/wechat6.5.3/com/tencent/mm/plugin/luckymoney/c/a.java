package com.tencent.mm.plugin.luckymoney.c;

public final class a extends com.tencent.mm.ba.a {
    public int cdf;
    public String hae;
    public String haf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.cdf);
            if (this.hae != null) {
                aVar.e(2, this.hae);
            }
            if (this.haf != null) {
                aVar.e(3, this.haf);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.cdf) + 0;
            if (this.hae != null) {
                r0 += a.a.a.b.b.a.f(2, this.hae);
            }
            if (this.haf != null) {
                return r0 + a.a.a.b.b.a.f(3, this.haf);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.cdf = aVar3.pMj.mH();
                    return 0;
                case 2:
                    aVar4.hae = aVar3.pMj.readString();
                    return 0;
                case 3:
                    aVar4.haf = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
