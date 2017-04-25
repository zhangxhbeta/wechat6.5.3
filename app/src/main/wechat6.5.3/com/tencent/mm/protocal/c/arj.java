package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class arj extends a {
    public int eet;
    public String mNG;
    public String mNH;
    public String mzY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mzY != null) {
                aVar.e(1, this.mzY);
            }
            if (this.mNH != null) {
                aVar.e(2, this.mNH);
            }
            aVar.dV(3, this.eet);
            if (this.mNG == null) {
                return 0;
            }
            aVar.e(4, this.mNG);
            return 0;
        } else if (i == 1) {
            if (this.mzY != null) {
                r0 = a.a.a.b.b.a.f(1, this.mzY) + 0;
            } else {
                r0 = 0;
            }
            if (this.mNH != null) {
                r0 += a.a.a.b.b.a.f(2, this.mNH);
            }
            r0 += a.a.a.a.dS(3, this.eet);
            if (this.mNG != null) {
                r0 += a.a.a.b.b.a.f(4, this.mNG);
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
            arj com_tencent_mm_protocal_c_arj = (arj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_arj.mzY = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_arj.mNH = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_arj.eet = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_arj.mNG = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
