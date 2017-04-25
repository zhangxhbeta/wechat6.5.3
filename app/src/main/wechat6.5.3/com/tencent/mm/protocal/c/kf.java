package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class kf extends aqp {
    public LinkedList<String> mmN = new LinkedList();
    public LinkedList<Integer> mmO = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.d(2, 1, this.mmN);
            aVar.d(3, 2, this.mmO);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + a.a.a.a.c(2, 1, this.mmN)) + a.a.a.a.c(3, 2, this.mmO);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mmN.clear();
            this.mmO.clear();
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
            kf kfVar = (kf) objArr[1];
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
                        kfVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    kfVar.mmN.add(aVar3.pMj.readString());
                    return 0;
                case 3:
                    kfVar.mmO.add(Integer.valueOf(aVar3.pMj.mH()));
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
