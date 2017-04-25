package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class acr extends a {
    public double cXH;
    public String gjT;
    public int major;
    public int minor;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gjT != null) {
                aVar.e(1, this.gjT);
            }
            aVar.dV(2, this.major);
            aVar.dV(3, this.minor);
            aVar.a(4, this.cXH);
            return 0;
        } else if (i == 1) {
            if (this.gjT != null) {
                r0 = a.a.a.b.b.a.f(1, this.gjT) + 0;
            } else {
                r0 = 0;
            }
            return ((r0 + a.a.a.a.dS(2, this.major)) + a.a.a.a.dS(3, this.minor)) + (a.a.a.b.b.a.cw(4) + 8);
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
            acr com_tencent_mm_protocal_c_acr = (acr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_acr.gjT = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_acr.major = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_acr.minor = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_acr.cXH = aVar3.pMj.readDouble();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
