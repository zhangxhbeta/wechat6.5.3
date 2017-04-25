package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class bic extends a {
    public b mdy;
    public int ncT;
    public long ncz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mdy == null) {
                throw new a.a.a.b("Not all required fields were included: VoiceData");
            }
            aVar.C(1, this.ncz);
            if (this.mdy != null) {
                aVar.b(2, this.mdy);
            }
            aVar.dV(3, this.ncT);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.B(1, this.ncz) + 0;
            if (this.mdy != null) {
                r0 += a.a.a.a.a(2, this.mdy);
            }
            return r0 + a.a.a.a.dS(3, this.ncT);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mdy != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: VoiceData");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bic com_tencent_mm_protocal_c_bic = (bic) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bic.ncz = aVar3.pMj.mI();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bic.mdy = aVar3.bQK();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bic.ncT = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
