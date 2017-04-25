package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class acy extends a {
    public int aXy;
    public int mDS;
    public int mDT;
    public int mDU;
    public int mDV;
    public int mDW;
    public int mDX;
    public int mDY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mDS);
            aVar.dV(2, this.aXy);
            aVar.dV(3, this.mDT);
            aVar.dV(4, this.mDU);
            aVar.dV(5, this.mDV);
            aVar.dV(6, this.mDW);
            aVar.dV(7, this.mDX);
            aVar.dV(8, this.mDY);
            return 0;
        } else if (i == 1) {
            return (((((((a.a.a.a.dS(1, this.mDS) + 0) + a.a.a.a.dS(2, this.aXy)) + a.a.a.a.dS(3, this.mDT)) + a.a.a.a.dS(4, this.mDU)) + a.a.a.a.dS(5, this.mDV)) + a.a.a.a.dS(6, this.mDW)) + a.a.a.a.dS(7, this.mDX)) + a.a.a.a.dS(8, this.mDY);
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
                acy com_tencent_mm_protocal_c_acy = (acy) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_acy.mDS = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_acy.aXy = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_acy.mDT = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_acy.mDU = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_acy.mDV = aVar3.pMj.mH();
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_acy.mDW = aVar3.pMj.mH();
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_acy.mDX = aVar3.pMj.mH();
                        return 0;
                    case 8:
                        com_tencent_mm_protocal_c_acy.mDY = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
