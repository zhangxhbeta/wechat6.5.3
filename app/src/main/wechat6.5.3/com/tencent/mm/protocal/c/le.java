package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class le extends a {
    public String apU;
    public long mnH;
    public String mnI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.apU == null) {
                throw new b("Not all required fields were included: key");
            }
            if (this.apU != null) {
                aVar.e(1, this.apU);
            }
            aVar.C(2, this.mnH);
            if (this.mnI == null) {
                return 0;
            }
            aVar.e(3, this.mnI);
            return 0;
        } else if (i == 1) {
            if (this.apU != null) {
                r0 = a.a.a.b.b.a.f(1, this.apU) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.B(2, this.mnH);
            if (this.mnI != null) {
                r0 += a.a.a.b.b.a.f(3, this.mnI);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.apU != null) {
                return 0;
            }
            throw new b("Not all required fields were included: key");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            le leVar = (le) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    leVar.apU = aVar3.pMj.readString();
                    return 0;
                case 2:
                    leVar.mnH = aVar3.pMj.mI();
                    return 0;
                case 3:
                    leVar.mnI = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
