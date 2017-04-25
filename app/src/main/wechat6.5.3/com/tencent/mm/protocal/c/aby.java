package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class aby extends a {
    public b mDg;
    public b mfA;
    public b mfC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mfC != null) {
                aVar.b(1, this.mfC);
            }
            if (this.mfA != null) {
                aVar.b(2, this.mfA);
            }
            if (this.mDg == null) {
                return 0;
            }
            aVar.b(3, this.mDg);
            return 0;
        } else if (i == 1) {
            if (this.mfC != null) {
                r0 = a.a.a.a.a(1, this.mfC) + 0;
            } else {
                r0 = 0;
            }
            if (this.mfA != null) {
                r0 += a.a.a.a.a(2, this.mfA);
            }
            if (this.mDg != null) {
                r0 += a.a.a.a.a(3, this.mDg);
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
            aby com_tencent_mm_protocal_c_aby = (aby) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aby.mfC = aVar3.bQK();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aby.mfA = aVar3.bQK();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aby.mDg = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
