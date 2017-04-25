package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class aji extends a {
    public int mJE;
    public b mJF;
    public String mJG;
    public int mil;
    public String mlY;
    public String mlZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mil);
            aVar.dV(2, this.mJE);
            if (this.mJF != null) {
                aVar.b(3, this.mJF);
            }
            if (this.mJG != null) {
                aVar.e(4, this.mJG);
            }
            if (this.mlY != null) {
                aVar.e(5, this.mlY);
            }
            if (this.mlZ != null) {
                aVar.e(6, this.mlZ);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.dS(1, this.mil) + 0) + a.a.a.a.dS(2, this.mJE);
            if (this.mJF != null) {
                r0 += a.a.a.a.a(3, this.mJF);
            }
            if (this.mJG != null) {
                r0 += a.a.a.b.b.a.f(4, this.mJG);
            }
            if (this.mlY != null) {
                r0 += a.a.a.b.b.a.f(5, this.mlY);
            }
            if (this.mlZ != null) {
                return r0 + a.a.a.b.b.a.f(6, this.mlZ);
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
            aji com_tencent_mm_protocal_c_aji = (aji) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aji.mil = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aji.mJE = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aji.mJF = aVar3.bQK();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aji.mJG = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aji.mlY = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aji.mlZ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
