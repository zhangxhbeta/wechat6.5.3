package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class aup extends a {
    public String bol;
    public int eEu;
    public long mSh;
    public int mlC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.bol != null) {
                aVar.e(1, this.bol);
            }
            aVar.dV(2, this.eEu);
            aVar.dV(3, this.mlC);
            aVar.C(4, this.mSh);
            return 0;
        } else if (i == 1) {
            if (this.bol != null) {
                r0 = a.a.a.b.b.a.f(1, this.bol) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + a.a.a.a.dS(2, this.eEu)) + a.a.a.a.dS(3, this.mlC)) + a.a.a.a.B(4, this.mSh);
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
            aup com_tencent_mm_protocal_c_aup = (aup) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aup.bol = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aup.eEu = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aup.mlC = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aup.mSh = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
