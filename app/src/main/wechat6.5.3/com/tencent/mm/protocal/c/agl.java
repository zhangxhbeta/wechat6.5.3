package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class agl extends a {
    public int eeO;
    public String efy;
    public String gln;
    public String itR;
    public String mlY;
    public String mlZ;
    public String mvR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.itR != null) {
                aVar.e(1, this.itR);
            }
            if (this.gln != null) {
                aVar.e(2, this.gln);
            }
            aVar.dV(3, this.eeO);
            if (this.mlY != null) {
                aVar.e(4, this.mlY);
            }
            if (this.mlZ != null) {
                aVar.e(5, this.mlZ);
            }
            if (this.efy != null) {
                aVar.e(6, this.efy);
            }
            if (this.mvR == null) {
                return 0;
            }
            aVar.e(7, this.mvR);
            return 0;
        } else if (i == 1) {
            if (this.itR != null) {
                r0 = a.a.a.b.b.a.f(1, this.itR) + 0;
            } else {
                r0 = 0;
            }
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(2, this.gln);
            }
            r0 += a.a.a.a.dS(3, this.eeO);
            if (this.mlY != null) {
                r0 += a.a.a.b.b.a.f(4, this.mlY);
            }
            if (this.mlZ != null) {
                r0 += a.a.a.b.b.a.f(5, this.mlZ);
            }
            if (this.efy != null) {
                r0 += a.a.a.b.b.a.f(6, this.efy);
            }
            if (this.mvR != null) {
                r0 += a.a.a.b.b.a.f(7, this.mvR);
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
            agl com_tencent_mm_protocal_c_agl = (agl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_agl.itR = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_agl.gln = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_agl.eeO = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_agl.mlY = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_agl.mlZ = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_agl.efy = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_agl.mvR = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
