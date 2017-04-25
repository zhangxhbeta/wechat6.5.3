package com.tencent.mm.al;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class d extends a {
    public LinkedList<e> cTX = new LinkedList();
    public int cTY;
    public int cTZ;
    public int cUa;
    public int cUb;
    public String cUc;
    public String cUd;
    public int cUe;
    public int cUf;
    public int cUg;
    public int maxSize;
    public String name;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.cTX);
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            aVar.dV(3, this.cTY);
            aVar.dV(4, this.cTZ);
            aVar.dV(5, this.cUa);
            aVar.dV(6, this.cUb);
            if (this.cUc != null) {
                aVar.e(7, this.cUc);
            }
            if (this.cUd != null) {
                aVar.e(8, this.cUd);
            }
            aVar.dV(9, this.cUe);
            aVar.dV(10, this.cUf);
            aVar.dV(11, this.cUg);
            aVar.dV(12, this.maxSize);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.cTX) + 0;
            if (this.name != null) {
                r0 += a.a.a.b.b.a.f(2, this.name);
            }
            r0 = (((r0 + a.a.a.a.dS(3, this.cTY)) + a.a.a.a.dS(4, this.cTZ)) + a.a.a.a.dS(5, this.cUa)) + a.a.a.a.dS(6, this.cUb);
            if (this.cUc != null) {
                r0 += a.a.a.b.b.a.f(7, this.cUc);
            }
            if (this.cUd != null) {
                r0 += a.a.a.b.b.a.f(8, this.cUd);
            }
            return (((r0 + a.a.a.a.dS(9, this.cUe)) + a.a.a.a.dS(10, this.cUf)) + a.a.a.a.dS(11, this.cUg)) + a.a.a.a.dS(12, this.maxSize);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.cTX.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a eVar = new e();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        dVar.cTX.add(eVar);
                    }
                    return 0;
                case 2:
                    dVar.name = aVar3.pMj.readString();
                    return 0;
                case 3:
                    dVar.cTY = aVar3.pMj.mH();
                    return 0;
                case 4:
                    dVar.cTZ = aVar3.pMj.mH();
                    return 0;
                case 5:
                    dVar.cUa = aVar3.pMj.mH();
                    return 0;
                case 6:
                    dVar.cUb = aVar3.pMj.mH();
                    return 0;
                case 7:
                    dVar.cUc = aVar3.pMj.readString();
                    return 0;
                case 8:
                    dVar.cUd = aVar3.pMj.readString();
                    return 0;
                case 9:
                    dVar.cUe = aVar3.pMj.mH();
                    return 0;
                case 10:
                    dVar.cUf = aVar3.pMj.mH();
                    return 0;
                case 11:
                    dVar.cUg = aVar3.pMj.mH();
                    return 0;
                case 12:
                    dVar.maxSize = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
