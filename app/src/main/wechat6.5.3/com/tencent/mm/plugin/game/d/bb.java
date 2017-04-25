package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bb extends a {
    public LinkedList<a> gmZ = new LinkedList();
    public bh gna;
    public LinkedList<i> gnb = new LinkedList();
    public be gnc;
    public LinkedList<bx> gnd = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.gmZ);
            if (this.gna != null) {
                aVar.dX(2, this.gna.aHr());
                this.gna.a(aVar);
            }
            aVar.d(3, 8, this.gnb);
            if (this.gnc != null) {
                aVar.dX(4, this.gnc.aHr());
                this.gnc.a(aVar);
            }
            aVar.d(5, 8, this.gnd);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.gmZ) + 0;
            if (this.gna != null) {
                r0 += a.a.a.a.dU(2, this.gna.aHr());
            }
            r0 += a.a.a.a.c(3, 8, this.gnb);
            if (this.gnc != null) {
                r0 += a.a.a.a.dU(4, this.gnc.aHr());
            }
            return r0 + a.a.a.a.c(5, 8, this.gnd);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.gmZ.clear();
            this.gnb.clear();
            this.gnd.clear();
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
            bb bbVar = (bb) objArr[1];
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
                        a aVar5 = new a();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = aVar5.a(aVar4, aVar5, a.a(aVar4))) {
                        }
                        bbVar.gmZ.add(aVar5);
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bh bhVar = new bh();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bhVar.a(aVar4, bhVar, a.a(aVar4))) {
                        }
                        bbVar.gna = bhVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        i iVar = new i();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = iVar.a(aVar4, iVar, a.a(aVar4))) {
                        }
                        bbVar.gnb.add(iVar);
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        be beVar = new be();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = beVar.a(aVar4, beVar, a.a(aVar4))) {
                        }
                        bbVar.gnc = beVar;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bx bxVar = new bx();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bxVar.a(aVar4, bxVar, a.a(aVar4))) {
                        }
                        bbVar.gnd.add(bxVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
