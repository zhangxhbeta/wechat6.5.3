package com.tencent.mm.plugin.product.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class m extends a {
    public String hRo;
    public String hRp;
    public LinkedList<h> hRq = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.hRo != null) {
                aVar.e(1, this.hRo);
            }
            if (this.hRp != null) {
                aVar.e(2, this.hRp);
            }
            aVar.d(3, 8, this.hRq);
            return 0;
        } else if (i == 1) {
            if (this.hRo != null) {
                r0 = a.a.a.b.b.a.f(1, this.hRo) + 0;
            } else {
                r0 = 0;
            }
            if (this.hRp != null) {
                r0 += a.a.a.b.b.a.f(2, this.hRp);
            }
            return r0 + a.a.a.a.c(3, 8, this.hRq);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.hRq.clear();
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
            m mVar = (m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    mVar.hRo = aVar3.pMj.readString();
                    return 0;
                case 2:
                    mVar.hRp = aVar3.pMj.readString();
                    return 0;
                case 3:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        h hVar = new h();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                        }
                        mVar.hRq.add(hVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
