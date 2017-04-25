package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class acc extends a {
    public long bst;
    public b mDh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.C(1, this.bst);
            if (this.mDh != null) {
                aVar.b(2, this.mDh);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.B(1, this.bst) + 0;
            if (this.mDh != null) {
                return r0 + a.a.a.a.a(2, this.mDh);
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
            acc com_tencent_mm_protocal_c_acc = (acc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_acc.bst = aVar3.pMj.mI();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_acc.mDh = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
