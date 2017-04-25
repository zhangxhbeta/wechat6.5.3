package com.tencent.mm.plugin.exdevice.e;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class m extends a {
    public c fvR;
    public int fvU;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.fvR == null) {
                throw new b("Not all required fields were included: BasePush");
            }
            if (this.fvR != null) {
                aVar.dX(1, this.fvR.aHr());
                this.fvR.a(aVar);
            }
            aVar.dV(2, this.fvU);
            return 0;
        } else if (i == 1) {
            if (this.fvR != null) {
                r0 = a.a.a.a.dU(1, this.fvR.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.dS(2, this.fvU);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.fvR != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BasePush");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        c cVar = new c();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = cVar.a(aVar4, cVar, a.a(aVar4))) {
                        }
                        mVar.fvR = cVar;
                    }
                    return 0;
                case 2:
                    mVar.fvU = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
