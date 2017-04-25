package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class en extends a {
    public int fvo;
    public int maG;
    public b mfA;
    public int mfB;
    public b mfC;
    public b mfz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mfz != null) {
                aVar.b(1, this.mfz);
            }
            aVar.dV(2, this.fvo);
            if (this.mfA != null) {
                aVar.b(3, this.mfA);
            }
            aVar.dV(4, this.mfB);
            if (this.mfC != null) {
                aVar.b(5, this.mfC);
            }
            aVar.dV(6, this.maG);
            return 0;
        } else if (i == 1) {
            if (this.mfz != null) {
                r0 = a.a.a.a.a(1, this.mfz) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.fvo);
            if (this.mfA != null) {
                r0 += a.a.a.a.a(3, this.mfA);
            }
            r0 += a.a.a.a.dS(4, this.mfB);
            if (this.mfC != null) {
                r0 += a.a.a.a.a(5, this.mfC);
            }
            return r0 + a.a.a.a.dS(6, this.maG);
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
            en enVar = (en) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    enVar.mfz = aVar3.bQK();
                    return 0;
                case 2:
                    enVar.fvo = aVar3.pMj.mH();
                    return 0;
                case 3:
                    enVar.mfA = aVar3.bQK();
                    return 0;
                case 4:
                    enVar.mfB = aVar3.pMj.mH();
                    return 0;
                case 5:
                    enVar.mfC = aVar3.bQK();
                    return 0;
                case 6:
                    enVar.maG = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
