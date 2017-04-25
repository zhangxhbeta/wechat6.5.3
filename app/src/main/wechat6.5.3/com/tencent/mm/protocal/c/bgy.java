package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class bgy extends a {
    public String mdw;
    public long nco;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mdw == null) {
                throw new b("Not all required fields were included: Username");
            }
            aVar.C(1, this.nco);
            if (this.mdw != null) {
                aVar.e(2, this.mdw);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.B(1, this.nco) + 0;
            if (this.mdw != null) {
                return r0 + a.a.a.b.b.a.f(2, this.mdw);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mdw != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Username");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bgy com_tencent_mm_protocal_c_bgy = (bgy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bgy.nco = aVar3.pMj.mI();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bgy.mdw = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
