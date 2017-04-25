package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class ahf extends a {
    public String aXz;
    public String mGT;
    public int mbK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mGT != null) {
                aVar.e(1, this.mGT);
            }
            if (this.aXz != null) {
                aVar.e(2, this.aXz);
            }
            aVar.dV(3, this.mbK);
            return 0;
        } else if (i == 1) {
            if (this.mGT != null) {
                r0 = a.a.a.b.b.a.f(1, this.mGT) + 0;
            } else {
                r0 = 0;
            }
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(2, this.aXz);
            }
            return r0 + a.a.a.a.dS(3, this.mbK);
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
            ahf com_tencent_mm_protocal_c_ahf = (ahf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ahf.mGT = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ahf.aXz = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ahf.mbK = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
