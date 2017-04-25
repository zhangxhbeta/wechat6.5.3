package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class bes extends a {
    public long mqT;
    public int naB;
    public int naC;
    public int naD;
    public int naE;
    public b naF;
    public long nat;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.C(1, this.nat);
            aVar.C(2, this.mqT);
            aVar.dV(3, this.naB);
            aVar.dV(4, this.naC);
            aVar.dV(5, this.naD);
            aVar.dV(6, this.naE);
            if (this.naF != null) {
                aVar.b(7, this.naF);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((((a.a.a.a.B(1, this.nat) + 0) + a.a.a.a.B(2, this.mqT)) + a.a.a.a.dS(3, this.naB)) + a.a.a.a.dS(4, this.naC)) + a.a.a.a.dS(5, this.naD)) + a.a.a.a.dS(6, this.naE);
            if (this.naF != null) {
                return r0 + a.a.a.a.a(7, this.naF);
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
            bes com_tencent_mm_protocal_c_bes = (bes) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bes.nat = aVar3.pMj.mI();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bes.mqT = aVar3.pMj.mI();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bes.naB = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bes.naC = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bes.naD = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bes.naE = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bes.naF = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
