package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bjh extends a {
    public String bmJ;
    public String ndM;
    public String ndN;
    public int ndO;
    public int pRE;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.type);
            if (this.bmJ != null) {
                aVar.e(2, this.bmJ);
            }
            if (this.ndM != null) {
                aVar.e(3, this.ndM);
            }
            if (this.ndN != null) {
                aVar.e(4, this.ndN);
            }
            aVar.dV(5, this.ndO);
            aVar.dV(6, this.pRE);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.type) + 0;
            if (this.bmJ != null) {
                r0 += a.a.a.b.b.a.f(2, this.bmJ);
            }
            if (this.ndM != null) {
                r0 += a.a.a.b.b.a.f(3, this.ndM);
            }
            if (this.ndN != null) {
                r0 += a.a.a.b.b.a.f(4, this.ndN);
            }
            return (r0 + a.a.a.a.dS(5, this.ndO)) + a.a.a.a.dS(6, this.pRE);
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
            bjh com_tencent_mm_protocal_c_bjh = (bjh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bjh.type = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bjh.bmJ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bjh.ndM = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bjh.ndN = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bjh.ndO = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bjh.pRE = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
