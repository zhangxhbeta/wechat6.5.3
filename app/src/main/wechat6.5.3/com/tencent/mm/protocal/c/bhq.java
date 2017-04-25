package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bhq extends a {
    public boolean ncD;
    public long ncz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.C(1, this.ncz);
            aVar.ab(2, this.ncD);
            return 0;
        } else if (i == 1) {
            return (a.a.a.a.B(1, this.ncz) + 0) + (a.a.a.b.b.a.cw(2) + 1);
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
                bhq com_tencent_mm_protocal_c_bhq = (bhq) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_bhq.ncz = aVar3.pMj.mI();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_bhq.ncD = aVar3.bQJ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
