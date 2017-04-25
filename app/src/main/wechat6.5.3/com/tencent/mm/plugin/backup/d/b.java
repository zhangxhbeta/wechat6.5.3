package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ba.a;

public final class b extends a {
    public int eev;
    public com.tencent.mm.ba.b eew;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.eev);
            if (this.eew != null) {
                aVar.b(2, this.eew);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.eev) + 0;
            if (this.eew != null) {
                return r0 + a.a.a.a.a(2, this.eew);
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
                    bVar.eev = aVar3.pMj.mH();
                    return 0;
                case 2:
                    bVar.eew = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
