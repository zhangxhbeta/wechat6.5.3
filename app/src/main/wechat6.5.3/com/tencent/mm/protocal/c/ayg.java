package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class ayg extends a {
    public int efk;
    public int mVJ;
    public int mVK;
    public int mVL;
    public int mVM;
    public int mVN;
    public int mVO;
    public int mqK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.efk);
            aVar.dV(2, this.mqK);
            aVar.dV(3, this.mVJ);
            aVar.dV(4, this.mVK);
            aVar.dV(5, this.mVL);
            aVar.dV(6, this.mVM);
            aVar.dV(7, this.mVN);
            aVar.dV(8, this.mVO);
            return 0;
        } else if (i == 1) {
            return (((((((a.a.a.a.dS(1, this.efk) + 0) + a.a.a.a.dS(2, this.mqK)) + a.a.a.a.dS(3, this.mVJ)) + a.a.a.a.dS(4, this.mVK)) + a.a.a.a.dS(5, this.mVL)) + a.a.a.a.dS(6, this.mVM)) + a.a.a.a.dS(7, this.mVN)) + a.a.a.a.dS(8, this.mVO);
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
                ayg com_tencent_mm_protocal_c_ayg = (ayg) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_ayg.efk = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_ayg.mqK = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_ayg.mVJ = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_ayg.mVK = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_ayg.mVL = aVar3.pMj.mH();
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_ayg.mVM = aVar3.pMj.mH();
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_ayg.mVN = aVar3.pMj.mH();
                        return 0;
                    case 8:
                        com_tencent_mm_protocal_c_ayg.mVO = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
