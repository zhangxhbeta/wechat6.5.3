package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class ht extends a {
    public b miE;
    public b miF;
    public int port;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.type);
            aVar.dV(2, this.port);
            if (this.miE != null) {
                aVar.b(3, this.miE);
            }
            if (this.miF != null) {
                aVar.b(4, this.miF);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.dS(1, this.type) + 0) + a.a.a.a.dS(2, this.port);
            if (this.miE != null) {
                r0 += a.a.a.a.a(3, this.miE);
            }
            if (this.miF != null) {
                return r0 + a.a.a.a.a(4, this.miF);
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
            ht htVar = (ht) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    htVar.type = aVar3.pMj.mH();
                    return 0;
                case 2:
                    htVar.port = aVar3.pMj.mH();
                    return 0;
                case 3:
                    htVar.miE = aVar3.bQK();
                    return 0;
                case 4:
                    htVar.miF = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
