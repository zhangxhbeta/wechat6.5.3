package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class id extends a {
    public int efm;
    public hx mjh;
    public hw mji;
    public long mjj;
    public ic mjk;
    public if mjl;
    public ib mjm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.efm);
            if (this.mjh != null) {
                aVar.dX(2, this.mjh.aHr());
                this.mjh.a(aVar);
            }
            if (this.mji != null) {
                aVar.dX(3, this.mji.aHr());
                this.mji.a(aVar);
            }
            aVar.C(4, this.mjj);
            if (this.mjk != null) {
                aVar.dX(5, this.mjk.aHr());
                this.mjk.a(aVar);
            }
            if (this.mjl != null) {
                aVar.dX(6, this.mjl.aHr());
                this.mjl.a(aVar);
            }
            if (this.mjm != null) {
                aVar.dX(7, this.mjm.aHr());
                this.mjm.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.efm) + 0;
            if (this.mjh != null) {
                r0 += a.a.a.a.dU(2, this.mjh.aHr());
            }
            if (this.mji != null) {
                r0 += a.a.a.a.dU(3, this.mji.aHr());
            }
            r0 += a.a.a.a.B(4, this.mjj);
            if (this.mjk != null) {
                r0 += a.a.a.a.dU(5, this.mjk.aHr());
            }
            if (this.mjl != null) {
                r0 += a.a.a.a.dU(6, this.mjl.aHr());
            }
            if (this.mjm != null) {
                return r0 + a.a.a.a.dU(7, this.mjm.aHr());
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
            id idVar = (id) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    idVar.efm = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        hx hxVar = new hx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hxVar.a(aVar4, hxVar, a.a(aVar4))) {
                        }
                        idVar.mjh = hxVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        hw hwVar = new hw();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = hwVar.a(aVar4, hwVar, a.a(aVar4))) {
                        }
                        idVar.mji = hwVar;
                    }
                    return 0;
                case 4:
                    idVar.mjj = aVar3.pMj.mI();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        ic icVar = new ic();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = icVar.a(aVar4, icVar, a.a(aVar4))) {
                        }
                        idVar.mjk = icVar;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        if ifVar = new if();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ifVar.a(aVar4, ifVar, a.a(aVar4))) {
                        }
                        idVar.mjl = ifVar;
                    }
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        ib ibVar = new ib();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = ibVar.a(aVar4, ibVar, a.a(aVar4))) {
                        }
                        idVar.mjm = ibVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
