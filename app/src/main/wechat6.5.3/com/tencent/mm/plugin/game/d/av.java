package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class av extends a {
    public String aXz;
    public LinkedList<aw> gmU = new LinkedList();
    public ax gmV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.aXz == null) {
                throw new b("Not all required fields were included: Title");
            }
            if (this.aXz != null) {
                aVar.e(1, this.aXz);
            }
            aVar.d(2, 8, this.gmU);
            if (this.gmV == null) {
                return 0;
            }
            aVar.dX(3, this.gmV.aHr());
            this.gmV.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.aXz != null) {
                r0 = a.a.a.b.b.a.f(1, this.aXz) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.c(2, 8, this.gmU);
            if (this.gmV != null) {
                r0 += a.a.a.a.dU(3, this.gmV.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.gmU.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.aXz != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Title");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            av avVar = (av) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    avVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        aw awVar = new aw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = awVar.a(aVar4, awVar, a.a(aVar4))) {
                        }
                        avVar.gmU.add(awVar);
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ax axVar = new ax();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = axVar.a(aVar4, axVar, a.a(aVar4))) {
                        }
                        avVar.gmV = axVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
