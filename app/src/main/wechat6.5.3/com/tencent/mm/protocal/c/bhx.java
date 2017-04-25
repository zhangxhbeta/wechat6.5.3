package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class bhx extends a {
    public int ncK;
    public String ncy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ncy == null) {
                throw new b("Not all required fields were included: Talker");
            }
            if (this.ncy != null) {
                aVar.e(1, this.ncy);
            }
            aVar.dV(2, this.ncK);
            return 0;
        } else if (i == 1) {
            if (this.ncy != null) {
                r0 = a.a.a.b.b.a.f(1, this.ncy) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.dS(2, this.ncK);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.ncy != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Talker");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bhx com_tencent_mm_protocal_c_bhx = (bhx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bhx.ncy = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bhx.ncK = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
