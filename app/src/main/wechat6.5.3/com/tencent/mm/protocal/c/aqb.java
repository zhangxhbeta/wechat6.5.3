package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class aqb extends a {
    public String fvp;
    public int mOy;
    public String mfU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fvp != null) {
                aVar.e(1, this.fvp);
            }
            if (this.mfU != null) {
                aVar.e(2, this.mfU);
            }
            aVar.dV(3, this.mOy);
            return 0;
        } else if (i == 1) {
            if (this.fvp != null) {
                r0 = a.a.a.b.b.a.f(1, this.fvp) + 0;
            } else {
                r0 = 0;
            }
            if (this.mfU != null) {
                r0 += a.a.a.b.b.a.f(2, this.mfU);
            }
            return r0 + a.a.a.a.dS(3, this.mOy);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aqb com_tencent_mm_protocal_c_aqb = (aqb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aqb.fvp = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aqb.mfU = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aqb.mOy = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
