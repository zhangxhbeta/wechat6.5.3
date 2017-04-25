package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bk extends a {
    public int efm;
    public String gkV;
    public LinkedList<ar> gmZ = new LinkedList();
    public c gnt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.efm);
            if (this.gnt != null) {
                aVar.dX(2, this.gnt.aHr());
                this.gnt.a(aVar);
            }
            aVar.d(3, 8, this.gmZ);
            if (this.gkV != null) {
                aVar.e(4, this.gkV);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.efm) + 0;
            if (this.gnt != null) {
                r0 += a.a.a.a.dU(2, this.gnt.aHr());
            }
            r0 += a.a.a.a.c(3, 8, this.gmZ);
            if (this.gkV != null) {
                return r0 + a.a.a.b.b.a.f(4, this.gkV);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.gmZ.clear();
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
            bk bkVar = (bk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bkVar.efm = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        c cVar = new c();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = cVar.a(aVar4, cVar, a.a(aVar4))) {
                        }
                        bkVar.gnt = cVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ar arVar = new ar();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = arVar.a(aVar4, arVar, a.a(aVar4))) {
                        }
                        bkVar.gmZ.add(arVar);
                    }
                    return 0;
                case 4:
                    bkVar.gkV = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
