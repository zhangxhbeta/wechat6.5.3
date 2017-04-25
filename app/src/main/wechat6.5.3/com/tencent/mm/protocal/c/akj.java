package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class akj extends a {
    public int mLn;
    public long mLo;
    public long mLp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mLn);
            aVar.C(2, this.mLo);
            aVar.C(3, this.mLp);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.dS(1, this.mLn) + 0) + a.a.a.a.B(2, this.mLo)) + a.a.a.a.B(3, this.mLp);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                akj com_tencent_mm_protocal_c_akj = (akj) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_akj.mLn = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_akj.mLo = aVar3.pMj.mI();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_akj.mLp = aVar3.pMj.mI();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
