package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bp extends a {
    public d gkt;
    public String gnJ;
    public LinkedList<by> gnK = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkt == null) {
                throw new b("Not all required fields were included: AppItem");
            }
            if (this.gkt != null) {
                aVar.dX(1, this.gkt.aHr());
                this.gkt.a(aVar);
            }
            if (this.gnJ != null) {
                aVar.e(2, this.gnJ);
            }
            aVar.d(3, 8, this.gnK);
            return 0;
        } else if (i == 1) {
            if (this.gkt != null) {
                r0 = a.a.a.a.dU(1, this.gkt.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.gnJ != null) {
                r0 += a.a.a.b.b.a.f(2, this.gnJ);
            }
            return r0 + a.a.a.a.c(3, 8, this.gnK);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.gnK.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.gkt != null) {
                return 0;
            }
            throw new b("Not all required fields were included: AppItem");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bp bpVar = (bp) objArr[1];
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
                        bpVar.gkt = dVar;
                    }
                    return 0;
                case 2:
                    bpVar.gnJ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        by byVar = new by();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = byVar.a(aVar4, byVar, a.a(aVar4))) {
                        }
                        bpVar.gnK.add(byVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
