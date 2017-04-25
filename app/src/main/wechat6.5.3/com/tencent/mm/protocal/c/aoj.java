package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class aoj extends a {
    public String fvp;
    public int mOy;
    public String mrz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fvp != null) {
                aVar.e(1, this.fvp);
            }
            aVar.dV(2, this.mOy);
            if (this.mrz == null) {
                return 0;
            }
            aVar.e(3, this.mrz);
            return 0;
        } else if (i == 1) {
            if (this.fvp != null) {
                r0 = a.a.a.b.b.a.f(1, this.fvp) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mOy);
            if (this.mrz != null) {
                r0 += a.a.a.b.b.a.f(3, this.mrz);
            }
            return r0;
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
            aoj com_tencent_mm_protocal_c_aoj = (aoj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aoj.fvp = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aoj.mOy = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aoj.mrz = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
