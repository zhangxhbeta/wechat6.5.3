package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class q extends a {
    public b eew;
    public String efo;
    public int efp = 1;
    public int efq;
    public int efr;
    public int efs;
    public int eft;
    public int efu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.efo == null) {
                throw new a.a.a.b("Not all required fields were included: DataID");
            }
            if (this.efo != null) {
                aVar.e(1, this.efo);
            }
            aVar.dV(2, this.efp);
            aVar.dV(3, this.efq);
            aVar.dV(4, this.efr);
            aVar.dV(5, this.efs);
            aVar.dV(6, this.eft);
            if (this.eew != null) {
                aVar.b(7, this.eew);
            }
            aVar.dV(8, this.efu);
            return 0;
        } else if (i == 1) {
            if (this.efo != null) {
                r0 = a.a.a.b.b.a.f(1, this.efo) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + a.a.a.a.dS(2, this.efp)) + a.a.a.a.dS(3, this.efq)) + a.a.a.a.dS(4, this.efr)) + a.a.a.a.dS(5, this.efs)) + a.a.a.a.dS(6, this.eft);
            if (this.eew != null) {
                r0 += a.a.a.a.a(7, this.eew);
            }
            return r0 + a.a.a.a.dS(8, this.efu);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.efo != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: DataID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qVar.efo = aVar3.pMj.readString();
                    return 0;
                case 2:
                    qVar.efp = aVar3.pMj.mH();
                    return 0;
                case 3:
                    qVar.efq = aVar3.pMj.mH();
                    return 0;
                case 4:
                    qVar.efr = aVar3.pMj.mH();
                    return 0;
                case 5:
                    qVar.efs = aVar3.pMj.mH();
                    return 0;
                case 6:
                    qVar.eft = aVar3.pMj.mH();
                    return 0;
                case 7:
                    qVar.eew = aVar3.bQK();
                    return 0;
                case 8:
                    qVar.efu = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
