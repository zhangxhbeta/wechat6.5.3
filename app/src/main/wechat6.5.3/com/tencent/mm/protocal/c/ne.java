package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ne extends a {
    public String eBN;
    public int mpd;
    public LinkedList<ld> mpe = new LinkedList();
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.eBN != null) {
                aVar.e(2, this.eBN);
            }
            aVar.dV(3, this.mpd);
            aVar.d(4, 8, this.mpe);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.eBN != null) {
                r0 += a.a.a.b.b.a.f(2, this.eBN);
            }
            return (r0 + a.a.a.a.dS(3, this.mpd)) + a.a.a.a.c(4, 8, this.mpe);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mpe.clear();
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
            ne neVar = (ne) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    neVar.title = aVar3.pMj.readString();
                    return 0;
                case 2:
                    neVar.eBN = aVar3.pMj.readString();
                    return 0;
                case 3:
                    neVar.mpd = aVar3.pMj.mH();
                    return 0;
                case 4:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ld ldVar = new ld();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = ldVar.a(aVar4, ldVar, a.a(aVar4))) {
                        }
                        neVar.mpe.add(ldVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
