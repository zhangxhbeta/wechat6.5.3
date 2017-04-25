package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class afe extends a {
    public int eet;
    public int mFd;
    public b mFe;
    public int mFf;
    public int mFg;
    public int mpl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mFd);
            if (this.mFe != null) {
                aVar.b(2, this.mFe);
            }
            aVar.dV(3, this.mFf);
            aVar.dV(4, this.mpl);
            aVar.dV(5, this.eet);
            aVar.dV(6, this.mFg);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mFd) + 0;
            if (this.mFe != null) {
                r0 += a.a.a.a.a(2, this.mFe);
            }
            return (((r0 + a.a.a.a.dS(3, this.mFf)) + a.a.a.a.dS(4, this.mpl)) + a.a.a.a.dS(5, this.eet)) + a.a.a.a.dS(6, this.mFg);
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
            afe com_tencent_mm_protocal_c_afe = (afe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_afe.mFd = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afe.mFe = aVar3.bQK();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afe.mFf = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_afe.mpl = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_afe.eet = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_afe.mFg = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
