package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class if extends a {
    public long mjq;
    public String mjr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mjr == null) {
                throw new b("Not all required fields were included: ObjectDesc");
            }
            aVar.C(1, this.mjq);
            if (this.mjr != null) {
                aVar.e(2, this.mjr);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.B(1, this.mjq) + 0;
            if (this.mjr != null) {
                return r0 + a.a.a.b.b.a.f(2, this.mjr);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mjr != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ObjectDesc");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            if ifVar = (if) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ifVar.mjq = aVar3.pMj.mI();
                    return 0;
                case 2:
                    ifVar.mjr = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
