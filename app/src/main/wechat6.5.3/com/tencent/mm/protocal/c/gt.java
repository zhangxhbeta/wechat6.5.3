package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class gt extends a {
    public b mhA;
    public LinkedList<gr> mhB = new LinkedList();
    public String mhz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mhz == null) {
                throw new a.a.a.b("Not all required fields were included: BizUserName");
            }
            if (this.mhz != null) {
                aVar.e(1, this.mhz);
            }
            if (this.mhA != null) {
                aVar.b(2, this.mhA);
            }
            aVar.d(3, 8, this.mhB);
            return 0;
        } else if (i == 1) {
            if (this.mhz != null) {
                r0 = a.a.a.b.b.a.f(1, this.mhz) + 0;
            } else {
                r0 = 0;
            }
            if (this.mhA != null) {
                r0 += a.a.a.a.a(2, this.mhA);
            }
            return r0 + a.a.a.a.c(3, 8, this.mhB);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mhB.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mhz != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: BizUserName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            gt gtVar = (gt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    gtVar.mhz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    gtVar.mhA = aVar3.bQK();
                    return 0;
                case 3:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        gr grVar = new gr();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = grVar.a(aVar4, grVar, a.a(aVar4))) {
                        }
                        gtVar.mhB.add(grVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
