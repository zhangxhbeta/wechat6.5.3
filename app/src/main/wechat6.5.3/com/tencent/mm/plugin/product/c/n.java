package com.tencent.mm.plugin.product.c;

import com.tencent.mm.ba.a;

public final class n extends a {
    public int bkU;
    public String bmJ;
    public String hRr;
    public String name;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.bmJ != null) {
                aVar.e(1, this.bmJ);
            }
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.hRr != null) {
                aVar.e(3, this.hRr);
            }
            if (this.username != null) {
                aVar.e(4, this.username);
            }
            aVar.dV(5, this.bkU);
            return 0;
        } else if (i == 1) {
            if (this.bmJ != null) {
                r0 = a.a.a.b.b.a.f(1, this.bmJ) + 0;
            } else {
                r0 = 0;
            }
            if (this.name != null) {
                r0 += a.a.a.b.b.a.f(2, this.name);
            }
            if (this.hRr != null) {
                r0 += a.a.a.b.b.a.f(3, this.hRr);
            }
            if (this.username != null) {
                r0 += a.a.a.b.b.a.f(4, this.username);
            }
            return r0 + a.a.a.a.dS(5, this.bkU);
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
            n nVar = (n) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nVar.bmJ = aVar3.pMj.readString();
                    return 0;
                case 2:
                    nVar.name = aVar3.pMj.readString();
                    return 0;
                case 3:
                    nVar.hRr = aVar3.pMj.readString();
                    return 0;
                case 4:
                    nVar.username = aVar3.pMj.readString();
                    return 0;
                case 5:
                    nVar.bkU = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
