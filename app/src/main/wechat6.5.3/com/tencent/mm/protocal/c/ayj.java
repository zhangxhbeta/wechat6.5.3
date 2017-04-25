package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class ayj extends a {
    public String cqg;
    public int cqh;
    public String cqi;
    public String cqj;
    public String cqk;
    public String cql;
    public String cqm;
    public String cqn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.cqg != null) {
                aVar.e(1, this.cqg);
            }
            aVar.dV(2, this.cqh);
            if (this.cqj != null) {
                aVar.e(3, this.cqj);
            }
            if (this.cqk != null) {
                aVar.e(4, this.cqk);
            }
            if (this.cqi != null) {
                aVar.e(5, this.cqi);
            }
            if (this.cql != null) {
                aVar.e(6, this.cql);
            }
            if (this.cqm != null) {
                aVar.e(7, this.cqm);
            }
            if (this.cqn == null) {
                return 0;
            }
            aVar.e(8, this.cqn);
            return 0;
        } else if (i == 1) {
            if (this.cqg != null) {
                r0 = a.a.a.b.b.a.f(1, this.cqg) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.cqh);
            if (this.cqj != null) {
                r0 += a.a.a.b.b.a.f(3, this.cqj);
            }
            if (this.cqk != null) {
                r0 += a.a.a.b.b.a.f(4, this.cqk);
            }
            if (this.cqi != null) {
                r0 += a.a.a.b.b.a.f(5, this.cqi);
            }
            if (this.cql != null) {
                r0 += a.a.a.b.b.a.f(6, this.cql);
            }
            if (this.cqm != null) {
                r0 += a.a.a.b.b.a.f(7, this.cqm);
            }
            if (this.cqn != null) {
                r0 += a.a.a.b.b.a.f(8, this.cqn);
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
            ayj com_tencent_mm_protocal_c_ayj = (ayj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ayj.cqg = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ayj.cqh = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ayj.cqj = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ayj.cqk = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ayj.cqi = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ayj.cql = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ayj.cqm = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ayj.cqn = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
