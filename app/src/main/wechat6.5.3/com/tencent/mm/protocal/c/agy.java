package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class agy extends a {
    public String mGN;
    public String mGO;
    public String mGP;
    public int mlN;
    public String type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mGN != null) {
                aVar.e(1, this.mGN);
            }
            if (this.mGO != null) {
                aVar.e(2, this.mGO);
            }
            if (this.type != null) {
                aVar.e(3, this.type);
            }
            aVar.dV(4, this.mlN);
            if (this.mGP == null) {
                return 0;
            }
            aVar.e(5, this.mGP);
            return 0;
        } else if (i == 1) {
            if (this.mGN != null) {
                r0 = a.a.a.b.b.a.f(1, this.mGN) + 0;
            } else {
                r0 = 0;
            }
            if (this.mGO != null) {
                r0 += a.a.a.b.b.a.f(2, this.mGO);
            }
            if (this.type != null) {
                r0 += a.a.a.b.b.a.f(3, this.type);
            }
            r0 += a.a.a.a.dS(4, this.mlN);
            if (this.mGP != null) {
                r0 += a.a.a.b.b.a.f(5, this.mGP);
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
            agy com_tencent_mm_protocal_c_agy = (agy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_agy.mGN = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_agy.mGO = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_agy.type = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_agy.mlN = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_agy.mGP = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
