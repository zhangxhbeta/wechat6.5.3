package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;

public final class e extends a {
    public int gkP;
    public int gkQ;
    public int gkR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.gkP);
            aVar.dV(2, this.gkQ);
            aVar.dV(3, this.gkR);
            return 0;
        } else if (i == 1) {
            return ((a.a.a.a.dS(1, this.gkP) + 0) + a.a.a.a.dS(2, this.gkQ)) + a.a.a.a.dS(3, this.gkR);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                e eVar = (e) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        eVar.gkP = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        eVar.gkQ = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        eVar.gkR = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
