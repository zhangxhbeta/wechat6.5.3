package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class jh extends a {
    public String bol;
    public int eBR;
    public String eEN;
    public int mlC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.bol != null) {
                aVar.e(1, this.bol);
            }
            if (this.eEN != null) {
                aVar.e(2, this.eEN);
            }
            aVar.dV(3, this.eBR);
            aVar.dV(4, this.mlC);
            return 0;
        } else if (i == 1) {
            if (this.bol != null) {
                r0 = a.a.a.b.b.a.f(1, this.bol) + 0;
            } else {
                r0 = 0;
            }
            if (this.eEN != null) {
                r0 += a.a.a.b.b.a.f(2, this.eEN);
            }
            return (r0 + a.a.a.a.dS(3, this.eBR)) + a.a.a.a.dS(4, this.mlC);
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
            jh jhVar = (jh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jhVar.bol = aVar3.pMj.readString();
                    return 0;
                case 2:
                    jhVar.eEN = aVar3.pMj.readString();
                    return 0;
                case 3:
                    jhVar.eBR = aVar3.pMj.mH();
                    return 0;
                case 4:
                    jhVar.mlC = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
