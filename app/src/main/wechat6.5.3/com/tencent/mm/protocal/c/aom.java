package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class aom extends a {
    public int gly;
    public String mOz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mOz == null) {
                throw new b("Not all required fields were included: jsonData");
            }
            aVar.dV(1, this.gly);
            if (this.mOz != null) {
                aVar.e(2, this.mOz);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.gly) + 0;
            if (this.mOz != null) {
                return r0 + a.a.a.b.b.a.f(2, this.mOz);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mOz != null) {
                return 0;
            }
            throw new b("Not all required fields were included: jsonData");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aom com_tencent_mm_protocal_c_aom = (aom) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aom.gly = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aom.mOz = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
