package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class rk extends a {
    public rd mvl;
    public LinkedList<String> mvm = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mvl == null) {
                throw new b("Not all required fields were included: GameItem");
            }
            if (this.mvl != null) {
                aVar.dX(1, this.mvl.aHr());
                this.mvl.a(aVar);
            }
            aVar.d(2, 1, this.mvm);
            return 0;
        } else if (i == 1) {
            if (this.mvl != null) {
                r0 = a.a.a.a.dU(1, this.mvl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return r0 + a.a.a.a.c(2, 1, this.mvm);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mvm.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mvl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: GameItem");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            rk rkVar = (rk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        rd rdVar = new rd();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = rdVar.a(aVar4, rdVar, a.a(aVar4))) {
                        }
                        rkVar.mvl = rdVar;
                    }
                    return 0;
                case 2:
                    rkVar.mvm.add(aVar3.pMj.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
