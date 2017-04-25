package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ra extends a {
    public LinkedList<gw> mhL = new LinkedList();
    public gu muP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.muP != null) {
                aVar.dX(1, this.muP.aHr());
                this.muP.a(aVar);
            }
            aVar.d(2, 8, this.mhL);
            return 0;
        } else if (i == 1) {
            if (this.muP != null) {
                r0 = a.a.a.a.dU(1, this.muP.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.c(2, 8, this.mhL);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mhL.clear();
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
            ra raVar = (ra) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a guVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        guVar = new gu();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = guVar.a(aVar4, guVar, a.a(aVar4))) {
                        }
                        raVar.muP = guVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        guVar = new gw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = guVar.a(aVar4, guVar, a.a(aVar4))) {
                        }
                        raVar.mhL.add(guVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
