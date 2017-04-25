package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class ahn extends a {
    public boolean mHc;
    public boolean mHd;
    public int mHe;
    public int mHf;
    public String pRv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.ab(1, this.mHc);
            aVar.ab(2, this.mHd);
            aVar.dV(3, this.mHe);
            aVar.dV(4, this.mHf);
            if (this.pRv != null) {
                aVar.e(5, this.pRv);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((((a.a.a.b.b.a.cw(1) + 1) + 0) + (a.a.a.b.b.a.cw(2) + 1)) + a.a.a.a.dS(3, this.mHe)) + a.a.a.a.dS(4, this.mHf);
            if (this.pRv != null) {
                return r0 + a.a.a.b.b.a.f(5, this.pRv);
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
            ahn com_tencent_mm_protocal_c_ahn = (ahn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ahn.mHc = aVar3.bQJ();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ahn.mHd = aVar3.bQJ();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ahn.mHe = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ahn.mHf = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ahn.pRv = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
