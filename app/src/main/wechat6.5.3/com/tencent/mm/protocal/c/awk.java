package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class awk extends a {
    public int jhO;
    public int jhP;
    public String mcR;
    public String mcS;
    public String mcT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mcR != null) {
                aVar.e(1, this.mcR);
            }
            if (this.mcS != null) {
                aVar.e(2, this.mcS);
            }
            if (this.mcT != null) {
                aVar.e(3, this.mcT);
            }
            aVar.dV(4, this.jhO);
            aVar.dV(5, this.jhP);
            return 0;
        } else if (i == 1) {
            if (this.mcR != null) {
                r0 = a.a.a.b.b.a.f(1, this.mcR) + 0;
            } else {
                r0 = 0;
            }
            if (this.mcS != null) {
                r0 += a.a.a.b.b.a.f(2, this.mcS);
            }
            if (this.mcT != null) {
                r0 += a.a.a.b.b.a.f(3, this.mcT);
            }
            return (r0 + a.a.a.a.dS(4, this.jhO)) + a.a.a.a.dS(5, this.jhP);
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
            awk com_tencent_mm_protocal_c_awk = (awk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_awk.mcR = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_awk.mcS = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_awk.mcT = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_awk.jhO = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_awk.jhP = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
