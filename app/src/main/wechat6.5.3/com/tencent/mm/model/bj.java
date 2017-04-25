package com.tencent.mm.model;

import com.tencent.mm.ba.a;

public final class bj extends a {
    public String cvi;
    public long cvj;
    public int key;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.key);
            if (this.cvi != null) {
                aVar.e(2, this.cvi);
            }
            aVar.C(3, this.cvj);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.key) + 0;
            if (this.cvi != null) {
                r0 += a.a.a.b.b.a.f(2, this.cvi);
            }
            return r0 + a.a.a.a.B(3, this.cvj);
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
            bj bjVar = (bj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bjVar.key = aVar3.pMj.mH();
                    return 0;
                case 2:
                    bjVar.cvi = aVar3.pMj.readString();
                    return 0;
                case 3:
                    bjVar.cvj = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
