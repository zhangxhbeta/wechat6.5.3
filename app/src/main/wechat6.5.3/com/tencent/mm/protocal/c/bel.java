package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class bel extends a {
    public String mGp;
    public int mNM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mGp == null) {
                throw new b("Not all required fields were included: Ip");
            }
            if (this.mGp != null) {
                aVar.e(1, this.mGp);
            }
            aVar.dV(2, this.mNM);
            return 0;
        } else if (i == 1) {
            if (this.mGp != null) {
                r0 = a.a.a.b.b.a.f(1, this.mGp) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.dS(2, this.mNM);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mGp != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Ip");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bel com_tencent_mm_protocal_c_bel = (bel) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bel.mGp = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bel.mNM = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
