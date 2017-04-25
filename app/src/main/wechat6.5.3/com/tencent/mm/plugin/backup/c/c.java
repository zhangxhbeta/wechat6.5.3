package com.tencent.mm.plugin.backup.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class c extends a {
    public String eer;
    public int ees;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.eer == null) {
                throw new b("Not all required fields were included: BakChatName");
            }
            if (this.eer != null) {
                aVar.e(1, this.eer);
            }
            aVar.dV(2, this.ees);
            return 0;
        } else if (i == 1) {
            if (this.eer != null) {
                r0 = a.a.a.b.b.a.f(1, this.eer) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.dS(2, this.ees);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.eer != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BakChatName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.eer = aVar3.pMj.readString();
                    return 0;
                case 2:
                    cVar.ees = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
