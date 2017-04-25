package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bq extends a {
    public String gkW;
    public ba gnL;
    public LinkedList<bp> gnM = new LinkedList();
    public br gnN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkW != null) {
                aVar.e(1, this.gkW);
            }
            if (this.gnL != null) {
                aVar.dX(2, this.gnL.aHr());
                this.gnL.a(aVar);
            }
            aVar.d(3, 8, this.gnM);
            if (this.gnN == null) {
                return 0;
            }
            aVar.dX(4, this.gnN.aHr());
            this.gnN.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.gkW != null) {
                r0 = a.a.a.b.b.a.f(1, this.gkW) + 0;
            } else {
                r0 = 0;
            }
            if (this.gnL != null) {
                r0 += a.a.a.a.dU(2, this.gnL.aHr());
            }
            r0 += a.a.a.a.c(3, 8, this.gnM);
            if (this.gnN != null) {
                r0 += a.a.a.a.dU(4, this.gnN.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.gnM.clear();
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
            bq bqVar = (bq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bqVar.gkW = aVar3.pMj.readString();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ba baVar = new ba();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = baVar.a(aVar4, baVar, a.a(aVar4))) {
                        }
                        bqVar.gnL = baVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bp bpVar = new bp();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bpVar.a(aVar4, bpVar, a.a(aVar4))) {
                        }
                        bqVar.gnM.add(bpVar);
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        br brVar = new br();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = brVar.a(aVar4, brVar, a.a(aVar4))) {
                        }
                        bqVar.gnN = brVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
