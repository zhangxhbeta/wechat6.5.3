package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class ahk extends a {
    public int efm;
    public long mGW;
    public long mGX;
    public String miU;
    public String min;
    public int scene;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.scene);
            if (this.min != null) {
                aVar.e(2, this.min);
            }
            aVar.C(3, this.mGW);
            aVar.C(4, this.mGX);
            if (this.miU != null) {
                aVar.e(5, this.miU);
            }
            aVar.dV(6, this.efm);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.scene) + 0;
            if (this.min != null) {
                r0 += a.a.a.b.b.a.f(2, this.min);
            }
            r0 = (r0 + a.a.a.a.B(3, this.mGW)) + a.a.a.a.B(4, this.mGX);
            if (this.miU != null) {
                r0 += a.a.a.b.b.a.f(5, this.miU);
            }
            return r0 + a.a.a.a.dS(6, this.efm);
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
            ahk com_tencent_mm_protocal_c_ahk = (ahk) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ahk.scene = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ahk.min = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ahk.mGW = aVar3.pMj.mI();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ahk.mGX = aVar3.pMj.mI();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ahk.miU = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ahk.efm = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
