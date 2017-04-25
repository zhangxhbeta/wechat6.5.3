package com.tencent.mm.plugin.product.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public class l extends a {
    public int hQE;
    public String hRl;
    public int hRm;
    public LinkedList<e> hRn = new LinkedList();
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.hRl == null) {
                throw new b("Not all required fields were included: id_info");
            }
            if (this.hRl != null) {
                aVar.e(1, this.hRl);
            }
            aVar.dV(2, this.hRm);
            if (this.url != null) {
                aVar.e(3, this.url);
            }
            aVar.d(4, 8, this.hRn);
            aVar.dV(5, this.hQE);
            return 0;
        } else if (i == 1) {
            if (this.hRl != null) {
                r0 = a.a.a.b.b.a.f(1, this.hRl) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.hRm);
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(3, this.url);
            }
            return (r0 + a.a.a.a.c(4, 8, this.hRn)) + a.a.a.a.dS(5, this.hQE);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.hRn.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.hRl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: id_info");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    lVar.hRl = aVar3.pMj.readString();
                    return 0;
                case 2:
                    lVar.hRm = aVar3.pMj.mH();
                    return 0;
                case 3:
                    lVar.url = aVar3.pMj.readString();
                    return 0;
                case 4:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        e eVar = new e();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, a.a(aVar4))) {
                        }
                        lVar.hRn.add(eVar);
                    }
                    return 0;
                case 5:
                    lVar.hQE = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
