package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class hy extends a {
    public String aXz;
    public int eeQ;
    public int mfb;
    public long miQ;
    public int miR;
    public LinkedList<String> miS = new LinkedList();
    public LinkedList<id> miT = new LinkedList();
    public String miU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.miU == null) {
                throw new b("Not all required fields were included: SearchID");
            }
            aVar.C(1, this.miQ);
            aVar.dV(2, this.miR);
            if (this.aXz != null) {
                aVar.e(3, this.aXz);
            }
            aVar.d(4, 1, this.miS);
            aVar.d(5, 8, this.miT);
            aVar.dV(6, this.eeQ);
            if (this.miU != null) {
                aVar.e(7, this.miU);
            }
            aVar.dV(8, this.mfb);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.B(1, this.miQ) + 0) + a.a.a.a.dS(2, this.miR);
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(3, this.aXz);
            }
            r0 = ((r0 + a.a.a.a.c(4, 1, this.miS)) + a.a.a.a.c(5, 8, this.miT)) + a.a.a.a.dS(6, this.eeQ);
            if (this.miU != null) {
                r0 += a.a.a.b.b.a.f(7, this.miU);
            }
            return r0 + a.a.a.a.dS(8, this.mfb);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.miS.clear();
            this.miT.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.miU != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SearchID");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            hy hyVar = (hy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    hyVar.miQ = aVar3.pMj.mI();
                    return 0;
                case 2:
                    hyVar.miR = aVar3.pMj.mH();
                    return 0;
                case 3:
                    hyVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 4:
                    hyVar.miS.add(aVar3.pMj.readString());
                    return 0;
                case 5:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        id idVar = new id();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = idVar.a(aVar4, idVar, a.a(aVar4))) {
                        }
                        hyVar.miT.add(idVar);
                    }
                    return 0;
                case 6:
                    hyVar.eeQ = aVar3.pMj.mH();
                    return 0;
                case 7:
                    hyVar.miU = aVar3.pMj.readString();
                    return 0;
                case 8:
                    hyVar.mfb = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
