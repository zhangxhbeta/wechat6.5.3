package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class avc extends a {
    public String gIE;
    public String mqb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mqb != null) {
                aVar.e(1, this.mqb);
            }
            if (this.gIE == null) {
                return 0;
            }
            aVar.e(2, this.gIE);
            return 0;
        } else if (i == 1) {
            if (this.mqb != null) {
                r0 = a.a.a.b.b.a.f(1, this.mqb) + 0;
            } else {
                r0 = 0;
            }
            if (this.gIE != null) {
                r0 += a.a.a.b.b.a.f(2, this.gIE);
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
            avc com_tencent_mm_protocal_c_avc = (avc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_avc.mqb = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avc.gIE = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
