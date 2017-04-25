package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class bhf extends a {
    public String aXz;
    public int gof;
    public String hQP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.aXz == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.hQP == null) {
                throw new b("Not all required fields were included: Content");
            } else {
                aVar.dV(1, this.gof);
                if (this.aXz != null) {
                    aVar.e(2, this.aXz);
                }
                if (this.hQP != null) {
                    aVar.e(3, this.hQP);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.gof) + 0;
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(2, this.aXz);
            }
            if (this.hQP != null) {
                return r0 + a.a.a.b.b.a.f(3, this.hQP);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.aXz == null) {
                throw new b("Not all required fields were included: Title");
            } else if (this.hQP != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bhf com_tencent_mm_protocal_c_bhf = (bhf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bhf.gof = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bhf.aXz = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bhf.hQP = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
