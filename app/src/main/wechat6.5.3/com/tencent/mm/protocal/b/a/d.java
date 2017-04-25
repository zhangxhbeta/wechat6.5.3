package com.tencent.mm.protocal.b.a;

import com.tencent.mm.ba.a;

public final class d extends a {
    public String bdZ;
    public int bmj;
    public String desc;
    public String fKQ;
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
            if (this.bdZ != null) {
                aVar.e(3, this.bdZ);
            }
            aVar.dV(4, this.bmj);
            if (this.fKQ == null) {
                return 0;
            }
            aVar.e(5, this.fKQ);
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
            if (this.bdZ != null) {
                r0 += a.a.a.b.b.a.f(3, this.bdZ);
            }
            r0 += a.a.a.a.dS(4, this.bmj);
            if (this.fKQ != null) {
                r0 += a.a.a.b.b.a.f(5, this.fKQ);
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
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.title = aVar3.pMj.readString();
                    return 0;
                case 2:
                    dVar.desc = aVar3.pMj.readString();
                    return 0;
                case 3:
                    dVar.bdZ = aVar3.pMj.readString();
                    return 0;
                case 4:
                    dVar.bmj = aVar3.pMj.mH();
                    return 0;
                case 5:
                    dVar.fKQ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
