package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class agf extends a {
    public String mgp;
    public String mgq;
    public String mgr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mgq != null) {
                aVar.e(1, this.mgq);
            }
            if (this.mgp != null) {
                aVar.e(2, this.mgp);
            }
            if (this.mgr == null) {
                return 0;
            }
            aVar.e(3, this.mgr);
            return 0;
        } else if (i == 1) {
            if (this.mgq != null) {
                r0 = a.a.a.b.b.a.f(1, this.mgq) + 0;
            } else {
                r0 = 0;
            }
            if (this.mgp != null) {
                r0 += a.a.a.b.b.a.f(2, this.mgp);
            }
            if (this.mgr != null) {
                r0 += a.a.a.b.b.a.f(3, this.mgr);
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
            agf com_tencent_mm_protocal_c_agf = (agf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_agf.mgq = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_agf.mgp = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_agf.mgr = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
