package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class bm extends a {
    public String gln;
    public boolean gnA;
    public int gnB;
    public String gnC;
    public int gnx;
    public long gny;
    public String gnz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gln == null) {
                throw new b("Not all required fields were included: UserName");
            }
            if (this.gln != null) {
                aVar.e(1, this.gln);
            }
            aVar.dV(2, this.gnx);
            aVar.C(3, this.gny);
            if (this.gnz != null) {
                aVar.e(4, this.gnz);
            }
            aVar.ab(5, this.gnA);
            aVar.dV(6, this.gnB);
            if (this.gnC == null) {
                return 0;
            }
            aVar.e(7, this.gnC);
            return 0;
        } else if (i == 1) {
            if (this.gln != null) {
                r0 = a.a.a.b.b.a.f(1, this.gln) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.gnx)) + a.a.a.a.B(3, this.gny);
            if (this.gnz != null) {
                r0 += a.a.a.b.b.a.f(4, this.gnz);
            }
            r0 = (r0 + (a.a.a.b.b.a.cw(5) + 1)) + a.a.a.a.dS(6, this.gnB);
            if (this.gnC != null) {
                r0 += a.a.a.b.b.a.f(7, this.gnC);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.gln != null) {
                return 0;
            }
            throw new b("Not all required fields were included: UserName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bm bmVar = (bm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bmVar.gln = aVar3.pMj.readString();
                    return 0;
                case 2:
                    bmVar.gnx = aVar3.pMj.mH();
                    return 0;
                case 3:
                    bmVar.gny = aVar3.pMj.mI();
                    return 0;
                case 4:
                    bmVar.gnz = aVar3.pMj.readString();
                    return 0;
                case 5:
                    bmVar.gnA = aVar3.bQJ();
                    return 0;
                case 6:
                    bmVar.gnB = aVar3.pMj.mH();
                    return 0;
                case 7:
                    bmVar.gnC = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
