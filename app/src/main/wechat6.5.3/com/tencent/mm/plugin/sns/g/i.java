package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class i extends a {
    public LinkedList<h> jqC = new LinkedList();
    public g jqD;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.jqC);
            if (this.jqD != null) {
                aVar.dX(2, this.jqD.aHr());
                this.jqD.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.jqC) + 0;
            if (this.jqD != null) {
                return r0 + a.a.a.a.dU(2, this.jqD.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.jqC.clear();
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
            i iVar = (i) objArr[1];
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
                        h hVar = new h();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        iVar.jqC.add(hVar);
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        g gVar = new g();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = gVar.a(aVar4, gVar, a.a(aVar4))) {
                        }
                        iVar.jqD = gVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
