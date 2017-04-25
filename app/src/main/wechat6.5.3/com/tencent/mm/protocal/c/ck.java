package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class ck extends a {
    public String mbH;
    public b mcE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mbH != null) {
                aVar.e(1, this.mbH);
            }
            if (this.mcE == null) {
                return 0;
            }
            aVar.b(2, this.mcE);
            return 0;
        } else if (i == 1) {
            if (this.mbH != null) {
                r0 = a.a.a.b.b.a.f(1, this.mbH) + 0;
            } else {
                r0 = 0;
            }
            if (this.mcE != null) {
                r0 += a.a.a.a.a(2, this.mcE);
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
            ck ckVar = (ck) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ckVar.mbH = aVar3.pMj.readString();
                    return 0;
                case 2:
                    ckVar.mcE = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
