package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class b extends a {
    public int efm;
    public d gkt;
    public a gkw;
    public String gkx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.efm);
            if (this.gkt != null) {
                aVar.dX(2, this.gkt.aHr());
                this.gkt.a(aVar);
            }
            if (this.gkw != null) {
                aVar.dX(3, this.gkw.aHr());
                this.gkw.a(aVar);
            }
            if (this.gkx != null) {
                aVar.e(4, this.gkx);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.efm) + 0;
            if (this.gkt != null) {
                r0 += a.a.a.a.dU(2, this.gkt.aHr());
            }
            if (this.gkw != null) {
                r0 += a.a.a.a.dU(3, this.gkw.aHr());
            }
            if (this.gkx != null) {
                return r0 + a.a.a.b.b.a.f(4, this.gkx);
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
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bVar.efm = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        d dVar = new d();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        bVar.gkt = dVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = aVar5.a(aVar4, aVar5, a.a(aVar4))) {
                        }
                        bVar.gkw = aVar5;
                    }
                    return 0;
                case 4:
                    bVar.gkx = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
