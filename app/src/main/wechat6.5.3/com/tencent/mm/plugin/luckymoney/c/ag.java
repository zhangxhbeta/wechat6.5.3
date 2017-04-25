package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.ba.a;

public final class ag extends a {
    public int cdf;
    public String content;
    public int hcu;
    public int hcv;
    public String iconUrl;
    public String name;
    public String type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.cdf);
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.type != null) {
                aVar.e(3, this.type);
            }
            if (this.content != null) {
                aVar.e(4, this.content);
            }
            aVar.dV(5, this.hcu);
            if (this.iconUrl != null) {
                aVar.e(6, this.iconUrl);
            }
            aVar.dV(7, this.hcv);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.cdf) + 0;
            if (this.name != null) {
                r0 += a.a.a.b.b.a.f(2, this.name);
            }
            if (this.type != null) {
                r0 += a.a.a.b.b.a.f(3, this.type);
            }
            if (this.content != null) {
                r0 += a.a.a.b.b.a.f(4, this.content);
            }
            r0 += a.a.a.a.dS(5, this.hcu);
            if (this.iconUrl != null) {
                r0 += a.a.a.b.b.a.f(6, this.iconUrl);
            }
            return r0 + a.a.a.a.dS(7, this.hcv);
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
            ag agVar = (ag) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    agVar.cdf = aVar3.pMj.mH();
                    return 0;
                case 2:
                    agVar.name = aVar3.pMj.readString();
                    return 0;
                case 3:
                    agVar.type = aVar3.pMj.readString();
                    return 0;
                case 4:
                    agVar.content = aVar3.pMj.readString();
                    return 0;
                case 5:
                    agVar.hcu = aVar3.pMj.mH();
                    return 0;
                case 6:
                    agVar.iconUrl = aVar3.pMj.readString();
                    return 0;
                case 7:
                    agVar.hcv = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
