package com.tencent.mm.protocal.b.a;

import a.a.a.b;

public final class a extends com.tencent.mm.ba.a {
    public int actionType;
    public int id;
    public String lYs;
    public String lYt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.lYs == null) {
                throw new b("Not all required fields were included: btnStr");
            }
            aVar.dV(1, this.id);
            aVar.dV(2, this.actionType);
            if (this.lYs != null) {
                aVar.e(3, this.lYs);
            }
            if (this.lYt != null) {
                aVar.e(4, this.lYt);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.dS(1, this.id) + 0) + a.a.a.a.dS(2, this.actionType);
            if (this.lYs != null) {
                r0 += a.a.a.b.b.a.f(3, this.lYs);
            }
            if (this.lYt != null) {
                return r0 + a.a.a.b.b.a.f(4, this.lYt);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.lYs != null) {
                return 0;
            }
            throw new b("Not all required fields were included: btnStr");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.id = aVar3.pMj.mH();
                    return 0;
                case 2:
                    aVar4.actionType = aVar3.pMj.mH();
                    return 0;
                case 3:
                    aVar4.lYs = aVar3.pMj.readString();
                    return 0;
                case 4:
                    aVar4.lYt = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
