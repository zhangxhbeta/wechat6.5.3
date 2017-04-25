package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class qs extends a {
    public int eWn;
    public int index;
    public String username;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.index);
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            aVar.dV(3, this.eWn);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.index) + 0;
            if (this.username != null) {
                r0 += a.a.a.b.b.a.f(2, this.username);
            }
            return r0 + a.a.a.a.dS(3, this.eWn);
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
            qs qsVar = (qs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qsVar.index = aVar3.pMj.mH();
                    return 0;
                case 2:
                    qsVar.username = aVar3.pMj.readString();
                    return 0;
                case 3:
                    qsVar.eWn = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
