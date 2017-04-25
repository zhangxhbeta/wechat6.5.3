package com.tencent.mm.plugin.backup.d;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class u extends a {
    public long eeN;
    public int eev;
    public b eew;
    public int efA;
    public long efB;
    public int efz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.eev);
            if (this.eew != null) {
                aVar.b(2, this.eew);
            }
            aVar.dV(3, this.efz);
            aVar.dV(4, this.efA);
            aVar.C(5, this.efB);
            aVar.C(6, this.eeN);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.eev) + 0;
            if (this.eew != null) {
                r0 += a.a.a.a.a(2, this.eew);
            }
            return (((r0 + a.a.a.a.dS(3, this.efz)) + a.a.a.a.dS(4, this.efA)) + a.a.a.a.B(5, this.efB)) + a.a.a.a.B(6, this.eeN);
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
            u uVar = (u) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    uVar.eev = aVar3.pMj.mH();
                    return 0;
                case 2:
                    uVar.eew = aVar3.bQK();
                    return 0;
                case 3:
                    uVar.efz = aVar3.pMj.mH();
                    return 0;
                case 4:
                    uVar.efA = aVar3.pMj.mH();
                    return 0;
                case 5:
                    uVar.efB = aVar3.pMj.mI();
                    return 0;
                case 6:
                    uVar.eeN = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
