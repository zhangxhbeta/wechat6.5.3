package com.tencent.mm.protocal.b.a;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class b extends a {
    public int id;
    public LinkedList<a> lYu = new LinkedList();
    public String lcr;
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.id);
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.lcr != null) {
                aVar.e(3, this.lcr);
            }
            aVar.d(4, 8, this.lYu);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.id) + 0;
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(2, this.title);
            }
            if (this.lcr != null) {
                r0 += a.a.a.b.b.a.f(3, this.lcr);
            }
            return r0 + a.a.a.a.c(4, 8, this.lYu);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.lYu.clear();
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
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar.id = aVar3.pMj.mH();
                    return 0;
                case 2:
                    bVar.title = aVar3.pMj.readString();
                    return 0;
                case 3:
                    bVar.lcr = aVar3.pMj.readString();
                    return 0;
                case 4:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a aVar4 = new a();
                        a.a.a.a.a aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = aVar4.a(aVar5, aVar4, a.a(aVar5))) {
                        }
                        bVar.lYu.add(aVar4);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
