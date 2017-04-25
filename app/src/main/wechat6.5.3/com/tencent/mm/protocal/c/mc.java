package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class mc extends a {
    public int cHq;
    public String cHr;
    public String cHs;
    public String cHt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.cHq);
            if (this.cHr != null) {
                aVar.e(2, this.cHr);
            }
            if (this.cHs != null) {
                aVar.e(3, this.cHs);
            }
            if (this.cHt != null) {
                aVar.e(4, this.cHt);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.cHq) + 0;
            if (this.cHr != null) {
                r0 += a.a.a.b.b.a.f(2, this.cHr);
            }
            if (this.cHs != null) {
                r0 += a.a.a.b.b.a.f(3, this.cHs);
            }
            if (this.cHt != null) {
                return r0 + a.a.a.b.b.a.f(4, this.cHt);
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
            mc mcVar = (mc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mcVar.cHq = aVar3.pMj.mH();
                    return 0;
                case 2:
                    mcVar.cHr = aVar3.pMj.readString();
                    return 0;
                case 3:
                    mcVar.cHs = aVar3.pMj.readString();
                    return 0;
                case 4:
                    mcVar.cHt = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
