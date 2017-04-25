package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class azv extends a {
    public int mWB;
    public int mWC;
    public long mWD;
    public String mjV;
    public String mpF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mWB);
            if (this.mjV != null) {
                aVar.e(2, this.mjV);
            }
            if (this.mpF != null) {
                aVar.e(3, this.mpF);
            }
            aVar.dV(4, this.mWC);
            aVar.C(5, this.mWD);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mWB) + 0;
            if (this.mjV != null) {
                r0 += a.a.a.b.b.a.f(2, this.mjV);
            }
            if (this.mpF != null) {
                r0 += a.a.a.b.b.a.f(3, this.mpF);
            }
            return (r0 + a.a.a.a.dS(4, this.mWC)) + a.a.a.a.B(5, this.mWD);
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
            azv com_tencent_mm_protocal_c_azv = (azv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_azv.mWB = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_azv.mjV = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azv.mpF = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_azv.mWC = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_azv.mWD = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
