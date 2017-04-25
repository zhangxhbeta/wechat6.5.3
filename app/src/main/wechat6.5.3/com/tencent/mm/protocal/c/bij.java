package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bij extends a {
    public int eet;
    public int efm;
    public String gom;
    public int hNS;
    public int mIR;
    public String mbZ;
    public int ncV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gom != null) {
                aVar.e(1, this.gom);
            }
            aVar.dV(2, this.efm);
            aVar.dV(3, this.eet);
            aVar.dV(4, this.hNS);
            aVar.dV(5, this.mIR);
            if (this.mbZ != null) {
                aVar.e(6, this.mbZ);
            }
            aVar.dV(7, this.ncV);
            return 0;
        } else if (i == 1) {
            if (this.gom != null) {
                r0 = a.a.a.b.b.a.f(1, this.gom) + 0;
            } else {
                r0 = 0;
            }
            r0 = (((r0 + a.a.a.a.dS(2, this.efm)) + a.a.a.a.dS(3, this.eet)) + a.a.a.a.dS(4, this.hNS)) + a.a.a.a.dS(5, this.mIR);
            if (this.mbZ != null) {
                r0 += a.a.a.b.b.a.f(6, this.mbZ);
            }
            return r0 + a.a.a.a.dS(7, this.ncV);
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
            bij com_tencent_mm_protocal_c_bij = (bij) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bij.gom = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bij.efm = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bij.eet = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bij.hNS = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bij.mIR = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bij.mbZ = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bij.ncV = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
