package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bit extends a {
    public String mGq;
    public String muL;
    public String ndl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ndl != null) {
                aVar.e(1, this.ndl);
            }
            if (this.muL != null) {
                aVar.e(2, this.muL);
            }
            if (this.mGq == null) {
                return 0;
            }
            aVar.e(3, this.mGq);
            return 0;
        } else if (i == 1) {
            if (this.ndl != null) {
                r0 = a.a.a.b.b.a.f(1, this.ndl) + 0;
            } else {
                r0 = 0;
            }
            if (this.muL != null) {
                r0 += a.a.a.b.b.a.f(2, this.muL);
            }
            if (this.mGq != null) {
                r0 += a.a.a.b.b.a.f(3, this.mGq);
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
            bit com_tencent_mm_protocal_c_bit = (bit) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bit.ndl = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bit.muL = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bit.mGq = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
