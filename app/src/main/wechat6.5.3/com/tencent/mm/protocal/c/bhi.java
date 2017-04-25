package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class bhi extends a {
    public String efy;
    public String gln;
    public int gof;
    public String hQP;
    public b ncq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gln == null) {
                throw new a.a.a.b("Not all required fields were included: UserName");
            } else if (this.efy == null) {
                throw new a.a.a.b("Not all required fields were included: NickName");
            } else if (this.hQP == null) {
                throw new a.a.a.b("Not all required fields were included: Content");
            } else {
                aVar.dV(1, this.gof);
                if (this.gln != null) {
                    aVar.e(2, this.gln);
                }
                if (this.efy != null) {
                    aVar.e(3, this.efy);
                }
                if (this.hQP != null) {
                    aVar.e(4, this.hQP);
                }
                if (this.ncq != null) {
                    aVar.b(5, this.ncq);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.gof) + 0;
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(2, this.gln);
            }
            if (this.efy != null) {
                r0 += a.a.a.b.b.a.f(3, this.efy);
            }
            if (this.hQP != null) {
                r0 += a.a.a.b.b.a.f(4, this.hQP);
            }
            if (this.ncq != null) {
                return r0 + a.a.a.a.a(5, this.ncq);
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
                throw new a.a.a.b("Not all required fields were included: UserName");
            } else if (this.efy == null) {
                throw new a.a.a.b("Not all required fields were included: NickName");
            } else if (this.hQP != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bhi com_tencent_mm_protocal_c_bhi = (bhi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bhi.gof = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bhi.gln = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bhi.efy = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bhi.hQP = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bhi.ncq = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
