package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class bcy extends a {
    public String gln;
    public String mZa;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gln == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.mZa == null) {
                throw new b("Not all required fields were included: MatchWord");
            } else {
                if (this.gln != null) {
                    aVar.e(1, this.gln);
                }
                if (this.mZa == null) {
                    return 0;
                }
                aVar.e(2, this.mZa);
                return 0;
            }
        } else if (i == 1) {
            if (this.gln != null) {
                r0 = a.a.a.b.b.a.f(1, this.gln) + 0;
            } else {
                r0 = 0;
            }
            if (this.mZa != null) {
                r0 += a.a.a.b.b.a.f(2, this.mZa);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.gln == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.mZa != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MatchWord");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bcy com_tencent_mm_protocal_c_bcy = (bcy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bcy.gln = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bcy.mZa = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
