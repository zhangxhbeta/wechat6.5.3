package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class by extends a {
    public int efm;
    public bs gnY;
    public aj gnZ;
    public bu goa;
    public bn gob;
    public bo goc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.efm);
            if (this.gnY != null) {
                aVar.dX(2, this.gnY.aHr());
                this.gnY.a(aVar);
            }
            if (this.gnZ != null) {
                aVar.dX(3, this.gnZ.aHr());
                this.gnZ.a(aVar);
            }
            if (this.goa != null) {
                aVar.dX(4, this.goa.aHr());
                this.goa.a(aVar);
            }
            if (this.gob != null) {
                aVar.dX(5, this.gob.aHr());
                this.gob.a(aVar);
            }
            if (this.goc != null) {
                aVar.dX(6, this.goc.aHr());
                this.goc.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.efm) + 0;
            if (this.gnY != null) {
                r0 += a.a.a.a.dU(2, this.gnY.aHr());
            }
            if (this.gnZ != null) {
                r0 += a.a.a.a.dU(3, this.gnZ.aHr());
            }
            if (this.goa != null) {
                r0 += a.a.a.a.dU(4, this.goa.aHr());
            }
            if (this.gob != null) {
                r0 += a.a.a.a.dU(5, this.gob.aHr());
            }
            if (this.goc != null) {
                return r0 + a.a.a.a.dU(6, this.goc.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            by byVar = (by) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    byVar.efm = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bs bsVar = new bs();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bsVar.a(aVar4, bsVar, a.a(aVar4))) {
                        }
                        byVar.gnY = bsVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        aj ajVar = new aj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ajVar.a(aVar4, ajVar, a.a(aVar4))) {
                        }
                        byVar.gnZ = ajVar;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bu buVar = new bu();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = buVar.a(aVar4, buVar, a.a(aVar4))) {
                        }
                        byVar.goa = buVar;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bn bnVar = new bn();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bnVar.a(aVar4, bnVar, a.a(aVar4))) {
                        }
                        byVar.gob = bnVar;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bo boVar = new bo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = boVar.a(aVar4, boVar, a.a(aVar4))) {
                        }
                        byVar.goc = boVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
