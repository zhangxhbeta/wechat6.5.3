package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.ba.a;

public final class m extends a {
    public String haI;
    public long hbh;
    public String hbi;
    public String hbu;
    public String hbv;
    public String hbw;
    public String hbx;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.hbu != null) {
                aVar.e(1, this.hbu);
            }
            if (this.hbv != null) {
                aVar.e(2, this.hbv);
            }
            aVar.C(3, this.hbh);
            if (this.hbi != null) {
                aVar.e(4, this.hbi);
            }
            if (this.hbw != null) {
                aVar.e(5, this.hbw);
            }
            if (this.haI != null) {
                aVar.e(6, this.haI);
            }
            if (this.hbx == null) {
                return 0;
            }
            aVar.e(7, this.hbx);
            return 0;
        } else if (i == 1) {
            if (this.hbu != null) {
                r0 = a.a.a.b.b.a.f(1, this.hbu) + 0;
            } else {
                r0 = 0;
            }
            if (this.hbv != null) {
                r0 += a.a.a.b.b.a.f(2, this.hbv);
            }
            r0 += a.a.a.a.B(3, this.hbh);
            if (this.hbi != null) {
                r0 += a.a.a.b.b.a.f(4, this.hbi);
            }
            if (this.hbw != null) {
                r0 += a.a.a.b.b.a.f(5, this.hbw);
            }
            if (this.haI != null) {
                r0 += a.a.a.b.b.a.f(6, this.haI);
            }
            if (this.hbx != null) {
                r0 += a.a.a.b.b.a.f(7, this.hbx);
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
            m mVar = (m) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    mVar.hbu = aVar3.pMj.readString();
                    return 0;
                case 2:
                    mVar.hbv = aVar3.pMj.readString();
                    return 0;
                case 3:
                    mVar.hbh = aVar3.pMj.mI();
                    return 0;
                case 4:
                    mVar.hbi = aVar3.pMj.readString();
                    return 0;
                case 5:
                    mVar.hbw = aVar3.pMj.readString();
                    return 0;
                case 6:
                    mVar.haI = aVar3.pMj.readString();
                    return 0;
                case 7:
                    mVar.hbx = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
