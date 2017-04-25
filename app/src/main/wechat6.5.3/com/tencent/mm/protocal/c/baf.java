package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class baf extends a {
    public int mWO;
    public String mWR;
    public String mWS;
    public int mcj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mWO);
            if (this.mWR != null) {
                aVar.e(2, this.mWR);
            }
            aVar.dV(3, this.mcj);
            if (this.mWS != null) {
                aVar.e(4, this.mWS);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mWO) + 0;
            if (this.mWR != null) {
                r0 += a.a.a.b.b.a.f(2, this.mWR);
            }
            r0 += a.a.a.a.dS(3, this.mcj);
            if (this.mWS != null) {
                return r0 + a.a.a.b.b.a.f(4, this.mWS);
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
            baf com_tencent_mm_protocal_c_baf = (baf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_baf.mWO = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_baf.mWR = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_baf.mcj = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_baf.mWS = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
