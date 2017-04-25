package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class bgo extends a {
    public b nbV;
    public b nbW;
    public b nbX;
    public b nbY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.nbV != null) {
                aVar.b(1, this.nbV);
            }
            if (this.nbW != null) {
                aVar.b(2, this.nbW);
            }
            if (this.nbX != null) {
                aVar.b(3, this.nbX);
            }
            if (this.nbY == null) {
                return 0;
            }
            aVar.b(4, this.nbY);
            return 0;
        } else if (i == 1) {
            if (this.nbV != null) {
                r0 = a.a.a.a.a(1, this.nbV) + 0;
            } else {
                r0 = 0;
            }
            if (this.nbW != null) {
                r0 += a.a.a.a.a(2, this.nbW);
            }
            if (this.nbX != null) {
                r0 += a.a.a.a.a(3, this.nbX);
            }
            if (this.nbY != null) {
                r0 += a.a.a.a.a(4, this.nbY);
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
            bgo com_tencent_mm_protocal_c_bgo = (bgo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bgo.nbV = aVar3.bQK();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bgo.nbW = aVar3.bQK();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bgo.nbX = aVar3.bQK();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bgo.nbY = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
