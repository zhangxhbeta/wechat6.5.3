package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class d extends a {
    public LinkedList<e> kHM = new LinkedList();
    public b kHN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.kHM);
            if (this.kHN != null) {
                aVar.b(2, this.kHN);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.kHM) + 0;
            if (this.kHN != null) {
                return r0 + a.a.a.a.a(2, this.kHN);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.kHM.clear();
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
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        e eVar = new e();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        dVar.kHM.add(eVar);
                    }
                    return 0;
                case 2:
                    dVar.kHN = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
