package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class ax extends a {
    public int mbu;
    public b mbv;
    public long mbw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mbu);
            if (this.mbv != null) {
                aVar.b(2, this.mbv);
            }
            aVar.C(3, this.mbw);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mbu) + 0;
            if (this.mbv != null) {
                r0 += a.a.a.a.a(2, this.mbv);
            }
            return r0 + a.a.a.a.B(3, this.mbw);
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
            ax axVar = (ax) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    axVar.mbu = aVar3.pMj.mH();
                    return 0;
                case 2:
                    axVar.mbv = aVar3.bQK();
                    return 0;
                case 3:
                    axVar.mbw = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
