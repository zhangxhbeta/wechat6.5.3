package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class bgs extends a {
    public b ncb;
    public b ncc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ncb != null) {
                aVar.b(1, this.ncb);
            }
            if (this.ncc == null) {
                return 0;
            }
            aVar.b(2, this.ncc);
            return 0;
        } else if (i == 1) {
            if (this.ncb != null) {
                r0 = a.a.a.a.a(1, this.ncb) + 0;
            } else {
                r0 = 0;
            }
            if (this.ncc != null) {
                r0 += a.a.a.a.a(2, this.ncc);
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
            bgs com_tencent_mm_protocal_c_bgs = (bgs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bgs.ncb = aVar3.bQK();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bgs.ncc = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
