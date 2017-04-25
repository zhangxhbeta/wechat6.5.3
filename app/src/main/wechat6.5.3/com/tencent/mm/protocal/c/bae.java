package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bae extends a {
    public int mWO;
    public String mWP;
    public String mWQ;
    public int maG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mWO);
            if (this.mWP != null) {
                aVar.e(2, this.mWP);
            }
            if (this.mWQ != null) {
                aVar.e(3, this.mWQ);
            }
            aVar.dV(4, this.maG);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mWO) + 0;
            if (this.mWP != null) {
                r0 += a.a.a.b.b.a.f(2, this.mWP);
            }
            if (this.mWQ != null) {
                r0 += a.a.a.b.b.a.f(3, this.mWQ);
            }
            return r0 + a.a.a.a.dS(4, this.maG);
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
            bae com_tencent_mm_protocal_c_bae = (bae) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bae.mWO = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bae.mWP = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bae.mWQ = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bae.maG = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
