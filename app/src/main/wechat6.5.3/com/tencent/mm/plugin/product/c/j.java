package com.tencent.mm.plugin.product.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class j extends a {
    public int bkU;
    public g hRj;
    public String hRk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.bkU);
            if (this.hRj != null) {
                aVar.dX(2, this.hRj.aHr());
                this.hRj.a(aVar);
            }
            if (this.hRk != null) {
                aVar.e(3, this.hRk);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.bkU) + 0;
            if (this.hRj != null) {
                r0 += a.a.a.a.dU(2, this.hRj.aHr());
            }
            if (this.hRk != null) {
                return r0 + a.a.a.b.b.a.f(3, this.hRk);
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
            j jVar = (j) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    jVar.bkU = aVar3.pMj.mH();
                    return 0;
                case 2:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        g gVar = new g();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = gVar.a(aVar4, gVar, a.a(aVar4))) {
                        }
                        jVar.hRj = gVar;
                    }
                    return 0;
                case 3:
                    jVar.hRk = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
