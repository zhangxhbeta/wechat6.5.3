package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class atj extends a {
    public b mFe;
    public b mRA;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mRA == null) {
                throw new a.a.a.b("Not all required fields were included: Name");
            } else if (this.mFe == null) {
                throw new a.a.a.b("Not all required fields were included: Value");
            } else {
                if (this.mRA != null) {
                    aVar.b(1, this.mRA);
                }
                if (this.mFe == null) {
                    return 0;
                }
                aVar.b(2, this.mFe);
                return 0;
            }
        } else if (i == 1) {
            if (this.mRA != null) {
                r0 = a.a.a.a.a(1, this.mRA) + 0;
            } else {
                r0 = 0;
            }
            if (this.mFe != null) {
                r0 += a.a.a.a.a(2, this.mFe);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mRA == null) {
                throw new a.a.a.b("Not all required fields were included: Name");
            } else if (this.mFe != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: Value");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            atj com_tencent_mm_protocal_c_atj = (atj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_atj.mRA = aVar3.bQK();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_atj.mFe = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
