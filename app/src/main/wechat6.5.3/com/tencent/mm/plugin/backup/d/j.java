package com.tencent.mm.plugin.backup.d;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class j extends a {
    public String ID;
    public long eeN;
    public int eeQ;
    public int eeR;
    public int eeS;
    public long eeT;
    public long eeU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ID == null) {
                throw new b("Not all required fields were included: ID");
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            aVar.dV(2, this.eeQ);
            aVar.dV(3, this.eeR);
            aVar.dV(4, this.eeS);
            aVar.C(5, this.eeN);
            aVar.C(6, this.eeT);
            aVar.C(7, this.eeU);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                r0 = a.a.a.b.b.a.f(1, this.ID) + 0;
            } else {
                r0 = 0;
            }
            return (((((r0 + a.a.a.a.dS(2, this.eeQ)) + a.a.a.a.dS(3, this.eeR)) + a.a.a.a.dS(4, this.eeS)) + a.a.a.a.B(5, this.eeN)) + a.a.a.a.B(6, this.eeT)) + a.a.a.a.B(7, this.eeU);
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
            throw new b("Not all required fields were included: ID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jVar.ID = aVar3.pMj.readString();
                    return 0;
                case 2:
                    jVar.eeQ = aVar3.pMj.mH();
                    return 0;
                case 3:
                    jVar.eeR = aVar3.pMj.mH();
                    return 0;
                case 4:
                    jVar.eeS = aVar3.pMj.mH();
                    return 0;
                case 5:
                    jVar.eeN = aVar3.pMj.mI();
                    return 0;
                case 6:
                    jVar.eeT = aVar3.pMj.mI();
                    return 0;
                case 7:
                    jVar.eeU = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
