package com.tencent.mm.plugin.product.c;

import com.tencent.mm.ba.a;

public final class g extends a {
    public String bCk;
    public String bCl;
    public String cJf;
    public String cJg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.cJg != null) {
                aVar.e(1, this.cJg);
            }
            if (this.bCk != null) {
                aVar.e(2, this.bCk);
            }
            if (this.bCl != null) {
                aVar.e(3, this.bCl);
            }
            if (this.cJf == null) {
                return 0;
            }
            aVar.e(4, this.cJf);
            return 0;
        } else if (i == 1) {
            if (this.cJg != null) {
                r0 = a.a.a.b.b.a.f(1, this.cJg) + 0;
            } else {
                r0 = 0;
            }
            if (this.bCk != null) {
                r0 += a.a.a.b.b.a.f(2, this.bCk);
            }
            if (this.bCl != null) {
                r0 += a.a.a.b.b.a.f(3, this.bCl);
            }
            if (this.cJf != null) {
                r0 += a.a.a.b.b.a.f(4, this.cJf);
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
            g gVar = (g) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gVar.cJg = aVar3.pMj.readString();
                    return 0;
                case 2:
                    gVar.bCk = aVar3.pMj.readString();
                    return 0;
                case 3:
                    gVar.bCl = aVar3.pMj.readString();
                    return 0;
                case 4:
                    gVar.cJf = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
