package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class akd extends a {
    public int mFd;
    public int mKZ;
    public int mLa;
    public int mLb;
    public int mLc;
    public int mLd;
    public int mLe;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mFd);
            aVar.dV(2, this.mKZ);
            aVar.dV(3, this.mLa);
            aVar.dV(4, this.mLb);
            aVar.dV(5, this.mLc);
            aVar.dV(6, this.mLd);
            aVar.dV(7, this.mLe);
            return 0;
        } else if (i == 1) {
            return ((((((a.a.a.a.dS(1, this.mFd) + 0) + a.a.a.a.dS(2, this.mKZ)) + a.a.a.a.dS(3, this.mLa)) + a.a.a.a.dS(4, this.mLb)) + a.a.a.a.dS(5, this.mLc)) + a.a.a.a.dS(6, this.mLd)) + a.a.a.a.dS(7, this.mLe);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                akd com_tencent_mm_protocal_c_akd = (akd) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_akd.mFd = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_akd.mKZ = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_akd.mLa = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_akd.mLb = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_akd.mLc = aVar3.pMj.mH();
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_akd.mLd = aVar3.pMj.mH();
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_akd.mLe = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
