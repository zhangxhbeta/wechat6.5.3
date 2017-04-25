package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class rg extends a {
    public String gkz;
    public String mdJ;
    public int muU;
    public String muV;
    public String mvd;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gkz == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.mvd == null) {
                throw new b("Not all required fields were included: RecommendKey");
            } else {
                if (this.gkz != null) {
                    aVar.e(1, this.gkz);
                }
                if (this.mvd != null) {
                    aVar.e(2, this.mvd);
                }
                if (this.mdJ != null) {
                    aVar.e(3, this.mdJ);
                }
                aVar.dV(4, this.muU);
                if (this.muV == null) {
                    return 0;
                }
                aVar.e(5, this.muV);
                return 0;
            }
        } else if (i == 1) {
            if (this.gkz != null) {
                r0 = a.a.a.b.b.a.f(1, this.gkz) + 0;
            } else {
                r0 = 0;
            }
            if (this.mvd != null) {
                r0 += a.a.a.b.b.a.f(2, this.mvd);
            }
            if (this.mdJ != null) {
                r0 += a.a.a.b.b.a.f(3, this.mdJ);
            }
            r0 += a.a.a.a.dS(4, this.muU);
            if (this.muV != null) {
                r0 += a.a.a.b.b.a.f(5, this.muV);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.gkz == null) {
                throw new b("Not all required fields were included: AppID");
            } else if (this.mvd != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RecommendKey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            rg rgVar = (rg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rgVar.gkz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    rgVar.mvd = aVar3.pMj.readString();
                    return 0;
                case 3:
                    rgVar.mdJ = aVar3.pMj.readString();
                    return 0;
                case 4:
                    rgVar.muU = aVar3.pMj.mH();
                    return 0;
                case 5:
                    rgVar.muV = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
