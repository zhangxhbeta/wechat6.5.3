package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class hc extends a {
    public String mhJ;
    public int mhT;
    public int mhU;
    public int mhV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mhJ == null) {
                throw new b("Not all required fields were included: brand_user_name");
            }
            if (this.mhJ != null) {
                aVar.e(1, this.mhJ);
            }
            aVar.dV(2, this.mhT);
            aVar.dV(3, this.mhU);
            aVar.dV(4, this.mhV);
            return 0;
        } else if (i == 1) {
            if (this.mhJ != null) {
                r0 = a.a.a.b.b.a.f(1, this.mhJ) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + a.a.a.a.dS(2, this.mhT)) + a.a.a.a.dS(3, this.mhU)) + a.a.a.a.dS(4, this.mhV);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mhJ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: brand_user_name");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            hc hcVar = (hc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hcVar.mhJ = aVar3.pMj.readString();
                    return 0;
                case 2:
                    hcVar.mhT = aVar3.pMj.mH();
                    return 0;
                case 3:
                    hcVar.mhU = aVar3.pMj.mH();
                    return 0;
                case 4:
                    hcVar.mhV = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
