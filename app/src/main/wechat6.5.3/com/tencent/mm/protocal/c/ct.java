package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class ct extends a {
    public b mdk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mdk == null) {
                throw new a.a.a.b("Not all required fields were included: Cookies");
            } else if (this.mdk == null) {
                return 0;
            } else {
                aVar.b(1, this.mdk);
                return 0;
            }
        } else if (i == 1) {
            if (this.mdk != null) {
                r0 = a.a.a.a.a(1, this.mdk) + 0;
            } else {
                r0 = 0;
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mdk != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: Cookies");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ct ctVar = (ct) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ctVar.mdk = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
