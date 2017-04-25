package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class rx extends aqx {
    public int mqK;
    public LinkedList<b> mvY = new LinkedList();
    public int mvZ;
    public LinkedList<Integer> mwa = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new a.a.a.b("Not all required fields were included: BaseResponse");
            }
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            aVar.d(2, 6, this.mvY);
            aVar.dV(3, this.mvZ);
            aVar.dV(4, this.mqK);
            aVar.d(5, 2, this.mwa);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return (((r0 + a.a.a.a.c(2, 6, this.mvY)) + a.a.a.a.dS(3, this.mvZ)) + a.a.a.a.dS(4, this.mqK)) + a.a.a.a.c(5, 2, this.mwa);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mvY.clear();
            this.mwa.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            rx rxVar = (rx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a eoVar = new eo();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        rxVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    rxVar.mvY.add(aVar3.bQK());
                    return 0;
                case 3:
                    rxVar.mvZ = aVar3.pMj.mH();
                    return 0;
                case 4:
                    rxVar.mqK = aVar3.pMj.mH();
                    return 0;
                case 5:
                    rxVar.mwa.add(Integer.valueOf(aVar3.pMj.mH()));
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
