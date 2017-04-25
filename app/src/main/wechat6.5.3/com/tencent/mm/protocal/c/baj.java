package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class baj extends a {
    public int mWY;
    public int mWZ;
    public String mXa;
    public b mXb;
    public int mXc;
    public int mXd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mWY);
            aVar.dV(2, this.mWZ);
            if (this.mXa != null) {
                aVar.e(3, this.mXa);
            }
            if (this.mXb != null) {
                aVar.b(4, this.mXb);
            }
            aVar.dV(5, this.mXc);
            aVar.dV(6, this.mXd);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.dS(1, this.mWY) + 0) + a.a.a.a.dS(2, this.mWZ);
            if (this.mXa != null) {
                r0 += a.a.a.b.b.a.f(3, this.mXa);
            }
            if (this.mXb != null) {
                r0 += a.a.a.a.a(4, this.mXb);
            }
            return (r0 + a.a.a.a.dS(5, this.mXc)) + a.a.a.a.dS(6, this.mXd);
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
            baj com_tencent_mm_protocal_c_baj = (baj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_baj.mWY = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_baj.mWZ = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_baj.mXa = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_baj.mXb = aVar3.bQK();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_baj.mXc = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_baj.mXd = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
