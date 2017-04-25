package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class aja extends a {
    public int efm;
    public String gmM;
    public String itR;
    public String mJy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gmM != null) {
                aVar.e(1, this.gmM);
            }
            if (this.mJy != null) {
                aVar.e(2, this.mJy);
            }
            if (this.itR != null) {
                aVar.e(3, this.itR);
            }
            aVar.dV(4, this.efm);
            return 0;
        } else if (i == 1) {
            if (this.gmM != null) {
                r0 = a.a.a.b.b.a.f(1, this.gmM) + 0;
            } else {
                r0 = 0;
            }
            if (this.mJy != null) {
                r0 += a.a.a.b.b.a.f(2, this.mJy);
            }
            if (this.itR != null) {
                r0 += a.a.a.b.b.a.f(3, this.itR);
            }
            return r0 + a.a.a.a.dS(4, this.efm);
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
            aja com_tencent_mm_protocal_c_aja = (aja) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aja.gmM = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aja.mJy = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aja.itR = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aja.efm = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
