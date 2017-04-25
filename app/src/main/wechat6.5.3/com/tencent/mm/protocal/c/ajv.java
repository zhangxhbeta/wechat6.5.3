package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class ajv extends a {
    public int gll;
    public String gom;
    public String gon;
    public int mbT;
    public long mcb;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gon != null) {
                aVar.e(1, this.gon);
            }
            if (this.gom != null) {
                aVar.e(2, this.gom);
            }
            aVar.dV(3, this.mbT);
            aVar.dV(4, this.gll);
            aVar.C(5, this.mcb);
            return 0;
        } else if (i == 1) {
            if (this.gon != null) {
                r0 = a.a.a.b.b.a.f(1, this.gon) + 0;
            } else {
                r0 = 0;
            }
            if (this.gom != null) {
                r0 += a.a.a.b.b.a.f(2, this.gom);
            }
            return ((r0 + a.a.a.a.dS(3, this.mbT)) + a.a.a.a.dS(4, this.gll)) + a.a.a.a.B(5, this.mcb);
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
            ajv com_tencent_mm_protocal_c_ajv = (ajv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ajv.gon = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ajv.gom = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ajv.mbT = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ajv.gll = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ajv.mcb = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
