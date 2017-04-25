package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bh extends a {
    public String gmE;
    public LinkedList<bi> gnq = new LinkedList();
    public String gnr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.gnq);
            if (this.gmE != null) {
                aVar.e(2, this.gmE);
            }
            if (this.gnr != null) {
                aVar.e(3, this.gnr);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.gnq) + 0;
            if (this.gmE != null) {
                r0 += a.a.a.b.b.a.f(2, this.gmE);
            }
            if (this.gnr != null) {
                return r0 + a.a.a.b.b.a.f(3, this.gnr);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.gnq.clear();
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
            bh bhVar = (bh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bi biVar = new bi();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = biVar.a(aVar4, biVar, a.a(aVar4))) {
                        }
                        bhVar.gnq.add(biVar);
                    }
                    return 0;
                case 2:
                    bhVar.gmE = aVar3.pMj.readString();
                    return 0;
                case 3:
                    bhVar.gnr = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
