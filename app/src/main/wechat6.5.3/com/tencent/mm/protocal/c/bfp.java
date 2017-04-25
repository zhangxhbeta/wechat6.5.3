package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bfp extends a {
    public int efm;
    public int nbs;
    public int nbt;
    public int nbu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.efm);
            aVar.dV(2, this.nbs);
            aVar.dV(3, this.nbt);
            aVar.dV(4, this.nbu);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.dS(1, this.efm) + 0) + a.a.a.a.dS(2, this.nbs)) + a.a.a.a.dS(3, this.nbt)) + a.a.a.a.dS(4, this.nbu);
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
                bfp com_tencent_mm_protocal_c_bfp = (bfp) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bfp.efm = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bfp.nbs = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_bfp.nbt = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_bfp.nbu = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
