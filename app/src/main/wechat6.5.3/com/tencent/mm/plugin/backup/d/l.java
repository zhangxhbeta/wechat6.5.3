package com.tencent.mm.plugin.backup.d;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class l extends a {
    public String ID;
    public long eeN;
    public int eeQ;
    public int eeR;
    public int eeS;
    public long eeT;
    public long eeU;
    public LinkedList<n> eff = new LinkedList();
    public LinkedList<n> efg = new LinkedList();

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
            aVar.d(8, 8, this.eff);
            aVar.d(9, 8, this.efg);
            return 0;
        } else if (i == 1) {
            if (this.ID != null) {
                r0 = a.a.a.b.b.a.f(1, this.ID) + 0;
            } else {
                r0 = 0;
            }
            return (((((((r0 + a.a.a.a.dS(2, this.eeQ)) + a.a.a.a.dS(3, this.eeR)) + a.a.a.a.dS(4, this.eeS)) + a.a.a.a.B(5, this.eeN)) + a.a.a.a.B(6, this.eeT)) + a.a.a.a.B(7, this.eeU)) + a.a.a.a.c(8, 8, this.eff)) + a.a.a.a.c(9, 8, this.efg);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.eff.clear();
            this.efg.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            l lVar = (l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a nVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    lVar.ID = aVar3.pMj.readString();
                    return 0;
                case 2:
                    lVar.eeQ = aVar3.pMj.mH();
                    return 0;
                case 3:
                    lVar.eeR = aVar3.pMj.mH();
                    return 0;
                case 4:
                    lVar.eeS = aVar3.pMj.mH();
                    return 0;
                case 5:
                    lVar.eeN = aVar3.pMj.mI();
                    return 0;
                case 6:
                    lVar.eeT = aVar3.pMj.mI();
                    return 0;
                case 7:
                    lVar.eeU = aVar3.pMj.mI();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        nVar = new n();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = nVar.a(aVar4, nVar, a.a(aVar4))) {
                        }
                        lVar.eff.add(nVar);
                    }
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        nVar = new n();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = nVar.a(aVar4, nVar, a.a(aVar4))) {
                        }
                        lVar.efg.add(nVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
