package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ey extends aqx {
    public LinkedList<String> meA = new LinkedList();
    public int mfJ;
    public LinkedList<nu> mfM = new LinkedList();
    public int mfh;

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
            aVar.dV(2, this.mfJ);
            aVar.d(3, 1, this.meA);
            aVar.dV(4, this.mfh);
            aVar.d(5, 8, this.mfM);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + a.a.a.a.dS(2, this.mfJ)) + a.a.a.a.c(3, 1, this.meA)) + a.a.a.a.dS(4, this.mfh)) + a.a.a.a.c(5, 8, this.mfM);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.meA.clear();
            this.mfM.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
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
            ey eyVar = (ey) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        eyVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    eyVar.mfJ = aVar3.pMj.mH();
                    return 0;
                case 3:
                    eyVar.meA.add(aVar3.pMj.readString());
                    return 0;
                case 4:
                    eyVar.mfh = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        nu nuVar = new nu();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = nuVar.a(aVar4, nuVar, aqx.a(aVar4))) {
                        }
                        eyVar.mfM.add(nuVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
