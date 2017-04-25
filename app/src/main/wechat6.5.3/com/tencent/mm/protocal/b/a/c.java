package com.tencent.mm.protocal.b.a;

import com.tencent.mm.ba.a;
import com.tencent.mm.protocal.c.pw;
import java.util.LinkedList;

public final class c extends a {
    public LinkedList<pw> cqE = new LinkedList();
    public String desc;
    public String lYv;
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            aVar.d(3, 8, this.cqE);
            if (this.lYv == null) {
                return 0;
            }
            aVar.e(4, this.lYv);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(2, this.desc);
            }
            r0 += a.a.a.a.c(3, 8, this.cqE);
            if (this.lYv != null) {
                r0 += a.a.a.b.b.a.f(4, this.lYv);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.cqE.clear();
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
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cVar.title = aVar3.pMj.readString();
                    return 0;
                case 2:
                    cVar.desc = aVar3.pMj.readString();
                    return 0;
                case 3:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a pwVar = new pw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = pwVar.a(aVar4, pwVar, a.a(aVar4))) {
                        }
                        cVar.cqE.add(pwVar);
                    }
                    return 0;
                case 4:
                    cVar.lYv = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
