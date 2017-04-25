package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ba.a;

public final class d extends a {
    public long eba;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((a.a.a.c.a) objArr[0]).C(1, this.eba);
            return 0;
        } else if (i == 1) {
            return a.a.a.a.B(1, this.eba) + 0;
        } else {
            if (i == 2) {
                a.a.a.a.a aVar = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar2 = (a.a.a.a.a) objArr[0];
                d dVar = (d) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        dVar.eba = aVar2.pMj.mI();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
