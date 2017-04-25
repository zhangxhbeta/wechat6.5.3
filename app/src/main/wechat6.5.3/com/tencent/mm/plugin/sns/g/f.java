package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.ba.a;

public final class f extends a {
    public int jqx;
    public long jqz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.C(1, this.jqz);
            aVar.dV(2, this.jqx);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.B(1, this.jqz) + 0) + a.a.a.a.dS(2, this.jqx);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                f fVar = (f) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        fVar.jqz = aVar3.pMj.mI();
                        return 0;
                    case 2:
                        fVar.jqx = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
