package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class acf extends a {
    public String mDp;
    public String mDq;
    public int mDr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mDp != null) {
                aVar.e(1, this.mDp);
            }
            if (this.mDq != null) {
                aVar.e(2, this.mDq);
            }
            aVar.dV(3, this.mDr);
            return 0;
        } else if (i == 1) {
            if (this.mDp != null) {
                r0 = a.a.a.b.b.a.f(1, this.mDp) + 0;
            } else {
                r0 = 0;
            }
            if (this.mDq != null) {
                r0 += a.a.a.b.b.a.f(2, this.mDq);
            }
            return r0 + a.a.a.a.dS(3, this.mDr);
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
            acf com_tencent_mm_protocal_c_acf = (acf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_acf.mDp = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_acf.mDq = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_acf.mDr = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
