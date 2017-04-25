package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class arh extends a {
    public String gkB;
    public int hNS;
    public String meq;
    public String moU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkB != null) {
                aVar.e(1, this.gkB);
            }
            if (this.moU != null) {
                aVar.e(2, this.moU);
            }
            if (this.meq != null) {
                aVar.e(3, this.meq);
            }
            aVar.dV(4, this.hNS);
            return 0;
        } else if (i == 1) {
            if (this.gkB != null) {
                r0 = a.a.a.b.b.a.f(1, this.gkB) + 0;
            } else {
                r0 = 0;
            }
            if (this.moU != null) {
                r0 += a.a.a.b.b.a.f(2, this.moU);
            }
            if (this.meq != null) {
                r0 += a.a.a.b.b.a.f(3, this.meq);
            }
            return r0 + a.a.a.a.dS(4, this.hNS);
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
            arh com_tencent_mm_protocal_c_arh = (arh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_arh.gkB = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_arh.moU = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_arh.meq = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_arh.hNS = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
