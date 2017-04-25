package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.ba.a;

public final class b extends a {
    public String kHv;
    public String kHw;
    public String kHx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.kHv != null) {
                aVar.e(1, this.kHv);
            }
            if (this.kHw != null) {
                aVar.e(2, this.kHw);
            }
            if (this.kHx == null) {
                return 0;
            }
            aVar.e(3, this.kHx);
            return 0;
        } else if (i == 1) {
            if (this.kHv != null) {
                r0 = a.a.a.b.b.a.f(1, this.kHv) + 0;
            } else {
                r0 = 0;
            }
            if (this.kHw != null) {
                r0 += a.a.a.b.b.a.f(2, this.kHw);
            }
            if (this.kHx != null) {
                r0 += a.a.a.b.b.a.f(3, this.kHx);
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
            b bVar = (b) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.kHv = aVar3.pMj.readString();
                    return 0;
                case 2:
                    bVar.kHw = aVar3.pMj.readString();
                    return 0;
                case 3:
                    bVar.kHx = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
