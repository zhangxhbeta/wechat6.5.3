package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class c extends a {
    public d gkt;
    public String gkx;
    public LinkedList<cb> gky = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkt != null) {
                aVar.dX(1, this.gkt.aHr());
                this.gkt.a(aVar);
            }
            aVar.d(2, 8, this.gky);
            if (this.gkx == null) {
                return 0;
            }
            aVar.e(3, this.gkx);
            return 0;
        } else if (i == 1) {
            if (this.gkt != null) {
                r0 = a.a.a.a.dU(1, this.gkt.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.c(2, 8, this.gky);
            if (this.gkx != null) {
                r0 += a.a.a.b.b.a.f(3, this.gkx);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.gky.clear();
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
            c cVar = (c) objArr[1];
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
                        d dVar = new d();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.gkt = dVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        cb cbVar = new cb();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = cbVar.a(aVar4, cbVar, a.a(aVar4))) {
                        }
                        cVar.gky.add(cbVar);
                    }
                    return 0;
                case 3:
                    cVar.gkx = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
