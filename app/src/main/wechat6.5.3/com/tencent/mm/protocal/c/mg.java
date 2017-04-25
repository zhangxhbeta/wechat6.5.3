package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class mg extends aqp {
    public int eOX;
    public int maG;
    public LinkedList<mp> mbB = new LinkedList();
    public String moN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.eOX);
            aVar.d(3, 8, this.mbB);
            if (this.moN != null) {
                aVar.e(4, this.moN);
            }
            aVar.dV(5, this.maG);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.eOX)) + a.a.a.a.c(3, 8, this.mbB);
            if (this.moN != null) {
                r0 += a.a.a.b.b.a.f(4, this.moN);
            }
            return r0 + a.a.a.a.dS(5, this.maG);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mbB.clear();
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
            mg mgVar = (mg) objArr[1];
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
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        mgVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    mgVar.eOX = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        mp mpVar = new mp();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = mpVar.a(aVar4, mpVar, aqp.a(aVar4))) {
                        }
                        mgVar.mbB.add(mpVar);
                    }
                    return 0;
                case 4:
                    mgVar.moN = aVar3.pMj.readString();
                    return 0;
                case 5:
                    mgVar.maG = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
