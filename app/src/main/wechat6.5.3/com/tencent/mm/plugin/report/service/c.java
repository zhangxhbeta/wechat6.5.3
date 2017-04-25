package com.tencent.mm.plugin.report.service;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class c extends a {
    public boolean itJ;
    public int itQ;
    public String itR;
    public boolean itS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.itR == null) {
                throw new b("Not all required fields were included: Value");
            }
            aVar.dV(1, this.itQ);
            if (this.itR != null) {
                aVar.e(2, this.itR);
            }
            aVar.ab(3, this.itS);
            aVar.ab(4, this.itJ);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.itQ) + 0;
            if (this.itR != null) {
                r0 += a.a.a.b.b.a.f(2, this.itR);
            }
            return (r0 + (a.a.a.b.b.a.cw(3) + 1)) + (a.a.a.b.b.a.cw(4) + 1);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.itR != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Value");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.itQ = aVar3.pMj.mH();
                    return 0;
                case 2:
                    cVar.itR = aVar3.pMj.readString();
                    return 0;
                case 3:
                    cVar.itS = aVar3.bQJ();
                    return 0;
                case 4:
                    cVar.itJ = aVar3.bQJ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
