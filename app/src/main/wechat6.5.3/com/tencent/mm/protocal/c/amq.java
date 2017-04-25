package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class amq extends a {
    public String gkB;
    public String mqz;
    public int mxS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mxS);
            if (this.gkB != null) {
                aVar.e(2, this.gkB);
            }
            if (this.mqz != null) {
                aVar.e(3, this.mqz);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mxS) + 0;
            if (this.gkB != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkB);
            }
            if (this.mqz != null) {
                return r0 + a.a.a.b.b.a.f(3, this.mqz);
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
            amq com_tencent_mm_protocal_c_amq = (amq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_amq.mxS = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_amq.gkB = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_amq.mqz = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
