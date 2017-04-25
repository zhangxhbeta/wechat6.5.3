package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class z extends aqp {
    public int lZF;
    public nf lZG;
    public int lZH;
    public LinkedList<cc> lZn = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.lZF);
            aVar.d(3, 8, this.lZn);
            if (this.lZG != null) {
                aVar.dX(4, this.lZG.aHr());
                this.lZG.a(aVar);
            }
            aVar.dV(5, this.lZH);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.lZF)) + a.a.a.a.c(3, 8, this.lZn);
            if (this.lZG != null) {
                r0 += a.a.a.a.dU(4, this.lZG.aHr());
            }
            return r0 + a.a.a.a.dS(5, this.lZH);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.lZn.clear();
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
            z zVar = (z) objArr[1];
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
                        zVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zVar.lZF = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        cc ccVar = new cc();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ccVar.a(aVar4, ccVar, aqp.a(aVar4))) {
                        }
                        zVar.lZn.add(ccVar);
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        nf nfVar = new nf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = nfVar.a(aVar4, nfVar, aqp.a(aVar4))) {
                        }
                        zVar.lZG = nfVar;
                    }
                    return 0;
                case 5:
                    zVar.lZH = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
