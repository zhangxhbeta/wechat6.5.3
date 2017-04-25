package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class pc extends a {
    public String gkB;
    public int gof;
    public int mjf;
    public String mqp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkB != null) {
                aVar.e(1, this.gkB);
            }
            aVar.dV(2, this.mjf);
            if (this.mqp != null) {
                aVar.e(3, this.mqp);
            }
            aVar.dV(4, this.gof);
            return 0;
        } else if (i == 1) {
            if (this.gkB != null) {
                r0 = a.a.a.b.b.a.f(1, this.gkB) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mjf);
            if (this.mqp != null) {
                r0 += a.a.a.b.b.a.f(3, this.mqp);
            }
            return r0 + a.a.a.a.dS(4, this.gof);
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
            pc pcVar = (pc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pcVar.gkB = aVar3.pMj.readString();
                    return 0;
                case 2:
                    pcVar.mjf = aVar3.pMj.mH();
                    return 0;
                case 3:
                    pcVar.mqp = aVar3.pMj.readString();
                    return 0;
                case 4:
                    pcVar.gof = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
