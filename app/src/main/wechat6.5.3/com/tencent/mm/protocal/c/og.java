package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class og extends a {
    public String aXz;
    public String gkC;
    public String mqa;
    public String mqb;
    public String mqc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.aXz != null) {
                aVar.e(1, this.aXz);
            }
            if (this.mqa != null) {
                aVar.e(2, this.mqa);
            }
            if (this.mqb != null) {
                aVar.e(3, this.mqb);
            }
            if (this.gkC != null) {
                aVar.e(4, this.gkC);
            }
            if (this.mqc == null) {
                return 0;
            }
            aVar.e(5, this.mqc);
            return 0;
        } else if (i == 1) {
            if (this.aXz != null) {
                r0 = a.a.a.b.b.a.f(1, this.aXz) + 0;
            } else {
                r0 = 0;
            }
            if (this.mqa != null) {
                r0 += a.a.a.b.b.a.f(2, this.mqa);
            }
            if (this.mqb != null) {
                r0 += a.a.a.b.b.a.f(3, this.mqb);
            }
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(4, this.gkC);
            }
            if (this.mqc != null) {
                r0 += a.a.a.b.b.a.f(5, this.mqc);
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
            og ogVar = (og) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ogVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    ogVar.mqa = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ogVar.mqb = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ogVar.gkC = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ogVar.mqc = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
