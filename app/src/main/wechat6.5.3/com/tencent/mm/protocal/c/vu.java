package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class vu extends a {
    public int lZm;
    public String mdM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mdM == null) {
                throw new b("Not all required fields were included: ProductID");
            }
            if (this.mdM != null) {
                aVar.e(1, this.mdM);
            }
            aVar.dV(2, this.lZm);
            return 0;
        } else if (i == 1) {
            if (this.mdM != null) {
                r0 = a.a.a.b.b.a.f(1, this.mdM) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.dS(2, this.lZm);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mdM != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ProductID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            vu vuVar = (vu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vuVar.mdM = aVar3.pMj.readString();
                    return 0;
                case 2:
                    vuVar.lZm = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
