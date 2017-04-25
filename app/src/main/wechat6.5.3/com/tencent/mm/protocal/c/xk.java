package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class xk extends aqx {
    public int mbK;
    public int mzF;
    public LinkedList<ako> mzG = new LinkedList();
    public String mzH;
    public int mzI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            aVar.dV(2, this.mzF);
            aVar.d(3, 8, this.mzG);
            if (this.mzH != null) {
                aVar.e(4, this.mzH);
            }
            aVar.dV(5, this.mbK);
            aVar.dV(6, this.mzI);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.mzF)) + a.a.a.a.c(3, 8, this.mzG);
            if (this.mzH != null) {
                r0 += a.a.a.b.b.a.f(4, this.mzH);
            }
            return (r0 + a.a.a.a.dS(5, this.mbK)) + a.a.a.a.dS(6, this.mzI);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mzG.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            xk xkVar = (xk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            com.tencent.mm.ba.a eoVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        xkVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    xkVar.mzF = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new ako();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        xkVar.mzG.add(eoVar);
                    }
                    return 0;
                case 4:
                    xkVar.mzH = aVar3.pMj.readString();
                    return 0;
                case 5:
                    xkVar.mbK = aVar3.pMj.mH();
                    return 0;
                case 6:
                    xkVar.mzI = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
