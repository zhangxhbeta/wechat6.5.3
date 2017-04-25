package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class bia extends a {
    public int mVA;
    public String ncO;
    public b ncP;
    public b ncQ;
    public String ncR;
    public String ncS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ncO == null) {
                throw new a.a.a.b("Not all required fields were included: Msg");
            }
            aVar.dV(1, this.mVA);
            if (this.ncO != null) {
                aVar.e(2, this.ncO);
            }
            if (this.ncP != null) {
                aVar.b(3, this.ncP);
            }
            if (this.ncQ != null) {
                aVar.b(4, this.ncQ);
            }
            if (this.ncR != null) {
                aVar.e(5, this.ncR);
            }
            if (this.ncS != null) {
                aVar.e(6, this.ncS);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mVA) + 0;
            if (this.ncO != null) {
                r0 += a.a.a.b.b.a.f(2, this.ncO);
            }
            if (this.ncP != null) {
                r0 += a.a.a.a.a(3, this.ncP);
            }
            if (this.ncQ != null) {
                r0 += a.a.a.a.a(4, this.ncQ);
            }
            if (this.ncR != null) {
                r0 += a.a.a.b.b.a.f(5, this.ncR);
            }
            if (this.ncS != null) {
                return r0 + a.a.a.b.b.a.f(6, this.ncS);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.ncO != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: Msg");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bia com_tencent_mm_protocal_c_bia = (bia) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bia.mVA = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bia.ncO = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bia.ncP = aVar3.bQK();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bia.ncQ = aVar3.bQK();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bia.ncR = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bia.ncS = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
