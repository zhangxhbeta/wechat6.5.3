package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class nv extends a {
    public int mpG;
    public String mpH;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mpH == null) {
                throw new b("Not all required fields were included: TagDesc");
            }
            aVar.dV(1, this.mpG);
            if (this.mpH != null) {
                aVar.e(2, this.mpH);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mpG) + 0;
            if (this.mpH != null) {
                return r0 + a.a.a.b.b.a.f(2, this.mpH);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mpH != null) {
                return 0;
            }
            throw new b("Not all required fields were included: TagDesc");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            nv nvVar = (nv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    nvVar.mpG = aVar3.pMj.mH();
                    return 0;
                case 2:
                    nvVar.mpH = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
