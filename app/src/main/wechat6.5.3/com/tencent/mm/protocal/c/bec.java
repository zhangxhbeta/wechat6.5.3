package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bec extends a {
    public int mZJ;
    public String mZM;
    public int mfh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mZJ);
            aVar.dV(2, this.mfh);
            if (this.mZM != null) {
                aVar.e(3, this.mZM);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.dS(1, this.mZJ) + 0) + a.a.a.a.dS(2, this.mfh);
            if (this.mZM != null) {
                return r0 + a.a.a.b.b.a.f(3, this.mZM);
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
            bec com_tencent_mm_protocal_c_bec = (bec) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bec.mZJ = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bec.mfh = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bec.mZM = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
