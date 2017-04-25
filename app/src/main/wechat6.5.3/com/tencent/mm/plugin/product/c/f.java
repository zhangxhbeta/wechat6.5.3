package com.tencent.mm.plugin.product.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class f extends a {
    public j hRg;
    public String hRh;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.hRg != null) {
                aVar.dX(1, this.hRg.aHr());
                this.hRg.a(aVar);
            }
            if (this.hRh == null) {
                return 0;
            }
            aVar.e(2, this.hRh);
            return 0;
        } else if (i == 1) {
            if (this.hRg != null) {
                r0 = a.a.a.a.dU(1, this.hRg.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.hRh != null) {
                r0 += a.a.a.b.b.a.f(2, this.hRh);
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
            f fVar = (f) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        j jVar = new j();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = jVar.a(aVar4, jVar, a.a(aVar4))) {
                        }
                        fVar.hRg = jVar;
                    }
                    return 0;
                case 2:
                    fVar.hRh = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
