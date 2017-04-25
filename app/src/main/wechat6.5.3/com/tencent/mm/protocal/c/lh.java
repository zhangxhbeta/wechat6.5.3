package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class lh extends a {
    public String aYx;
    public String aYy;
    public int mnM;
    public int mnN;
    public String mnO;
    public int version;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.version);
            aVar.dV(2, this.mnM);
            aVar.dV(3, this.mnN);
            if (this.aYy != null) {
                aVar.e(4, this.aYy);
            }
            if (this.mnO != null) {
                aVar.e(5, this.mnO);
            }
            if (this.aYx != null) {
                aVar.e(6, this.aYx);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.dS(1, this.version) + 0) + a.a.a.a.dS(2, this.mnM)) + a.a.a.a.dS(3, this.mnN);
            if (this.aYy != null) {
                r0 += a.a.a.b.b.a.f(4, this.aYy);
            }
            if (this.mnO != null) {
                r0 += a.a.a.b.b.a.f(5, this.mnO);
            }
            if (this.aYx != null) {
                return r0 + a.a.a.b.b.a.f(6, this.aYx);
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
            lh lhVar = (lh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lhVar.version = aVar3.pMj.mH();
                    return 0;
                case 2:
                    lhVar.mnM = aVar3.pMj.mH();
                    return 0;
                case 3:
                    lhVar.mnN = aVar3.pMj.mH();
                    return 0;
                case 4:
                    lhVar.aYy = aVar3.pMj.readString();
                    return 0;
                case 5:
                    lhVar.mnO = aVar3.pMj.readString();
                    return 0;
                case 6:
                    lhVar.aYx = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
