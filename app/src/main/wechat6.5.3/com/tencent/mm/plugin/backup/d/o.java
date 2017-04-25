package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class o extends a {
    public String ID;
    public b eew;
    public int efk;
    public int efl;
    public int efm;
    public int efn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new a.a.a.b("Not all required fields were included: ID");
            }
            aVar.dV(1, this.efk);
            if (this.ID != null) {
                aVar.e(2, this.ID);
            }
            if (this.eew != null) {
                aVar.b(3, this.eew);
            }
            aVar.dV(4, this.efl);
            aVar.dV(5, this.efm);
            aVar.dV(6, this.efn);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.efk) + 0;
            if (this.ID != null) {
                r0 += a.a.a.b.b.a.f(2, this.ID);
            }
            if (this.eew != null) {
                r0 += a.a.a.a.a(3, this.eew);
            }
            return ((r0 + a.a.a.a.dS(4, this.efl)) + a.a.a.a.dS(5, this.efm)) + a.a.a.a.dS(6, this.efn);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.ID != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            o oVar = (o) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    oVar.efk = aVar3.pMj.mH();
                    return 0;
                case 2:
                    oVar.ID = aVar3.pMj.readString();
                    return 0;
                case 3:
                    oVar.eew = aVar3.bQK();
                    return 0;
                case 4:
                    oVar.efl = aVar3.pMj.mH();
                    return 0;
                case 5:
                    oVar.efm = aVar3.pMj.mH();
                    return 0;
                case 6:
                    oVar.efn = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
