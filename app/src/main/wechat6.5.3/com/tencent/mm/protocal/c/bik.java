package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bik extends a {
    public int mIS;
    public int mcj;
    public long ncz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mcj);
            aVar.dV(2, this.mIS);
            aVar.C(3, this.ncz);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.dS(1, this.mcj) + 0) + a.a.a.a.dS(2, this.mIS)) + a.a.a.a.B(3, this.ncz);
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
                bik com_tencent_mm_protocal_c_bik = (bik) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bik.mcj = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bik.mIS = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bik.ncz = aVar3.pMj.mI();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
