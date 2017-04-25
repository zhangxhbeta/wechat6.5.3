package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class afy extends a {
    public String efy;
    public String gln;
    public String mlY;
    public String mlZ;
    public String mvR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gln != null) {
                aVar.e(1, this.gln);
            }
            if (this.efy != null) {
                aVar.e(2, this.efy);
            }
            if (this.mlY != null) {
                aVar.e(3, this.mlY);
            }
            if (this.mlZ != null) {
                aVar.e(4, this.mlZ);
            }
            if (this.mvR == null) {
                return 0;
            }
            aVar.e(5, this.mvR);
            return 0;
        } else if (i == 1) {
            if (this.gln != null) {
                r0 = a.a.a.b.b.a.f(1, this.gln) + 0;
            } else {
                r0 = 0;
            }
            if (this.efy != null) {
                r0 += a.a.a.b.b.a.f(2, this.efy);
            }
            if (this.mlY != null) {
                r0 += a.a.a.b.b.a.f(3, this.mlY);
            }
            if (this.mlZ != null) {
                r0 += a.a.a.b.b.a.f(4, this.mlZ);
            }
            if (this.mvR != null) {
                r0 += a.a.a.b.b.a.f(5, this.mvR);
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
            afy com_tencent_mm_protocal_c_afy = (afy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_afy.gln = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afy.efy = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afy.mlY = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_afy.mlZ = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_afy.mvR = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
