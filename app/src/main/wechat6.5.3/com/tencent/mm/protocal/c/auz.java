package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class auz extends a {
    public int efl;
    public b mSx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mSx == null) {
                throw new a.a.a.b("Not all required fields were included: Signature");
            }
            aVar.dV(1, this.efl);
            if (this.mSx != null) {
                aVar.b(2, this.mSx);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.efl) + 0;
            if (this.mSx != null) {
                return r0 + a.a.a.a.a(2, this.mSx);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mSx != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: Signature");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            auz com_tencent_mm_protocal_c_auz = (auz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_auz.efl = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_auz.mSx = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
