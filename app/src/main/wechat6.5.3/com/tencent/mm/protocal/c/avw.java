package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class avw extends a {
    public long mTf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            ((a.a.a.c.a) objArr[0]).C(1, this.mTf);
            return 0;
        } else if (i == 1) {
            return a.a.a.a.B(1, this.mTf) + 0;
        } else {
            if (i == 2) {
                a.a.a.a.a aVar = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar); a > 0; a = a.a(aVar)) {
                    if (!super.a(aVar, this, a)) {
                        aVar.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar2 = (a.a.a.a.a) objArr[0];
                avw com_tencent_mm_protocal_c_avw = (avw) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_avw.mTf = aVar2.pMj.mI();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
