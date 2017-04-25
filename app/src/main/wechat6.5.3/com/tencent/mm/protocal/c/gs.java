package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class gs extends a {
    public b mhA;
    public String mhz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mhz != null) {
                aVar.e(1, this.mhz);
            }
            if (this.mhA == null) {
                return 0;
            }
            aVar.b(2, this.mhA);
            return 0;
        } else if (i == 1) {
            if (this.mhz != null) {
                r0 = a.a.a.b.b.a.f(1, this.mhz) + 0;
            } else {
                r0 = 0;
            }
            if (this.mhA != null) {
                r0 += a.a.a.a.a(2, this.mhA);
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
            gs gsVar = (gs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    gsVar.mhz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    gsVar.mhA = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
