package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class re extends aqp {
    public String glC;
    public String muW;
    public LinkedList<String> muX = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.muW != null) {
                aVar.e(2, this.muW);
            }
            aVar.d(3, 1, this.muX);
            if (this.glC == null) {
                return 0;
            }
            aVar.e(4, this.glC);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.muW != null) {
                r0 += a.a.a.b.b.a.f(2, this.muW);
            }
            r0 += a.a.a.a.c(3, 1, this.muX);
            if (this.glC != null) {
                r0 += a.a.a.b.b.a.f(4, this.glC);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.muX.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            re reVar = (re) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        reVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    reVar.muW = aVar3.pMj.readString();
                    return 0;
                case 3:
                    reVar.muX.add(aVar3.pMj.readString());
                    return 0;
                case 4:
                    reVar.glC = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
