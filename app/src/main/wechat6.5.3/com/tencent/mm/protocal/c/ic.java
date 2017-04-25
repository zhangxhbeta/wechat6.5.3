package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class ic extends a {
    public String hOy;
    public String mjc;
    public String mjd;
    public String mje;
    public int mjf;
    public String mjg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mjc == null) {
                throw new b("Not all required fields were included: ProductId");
            } else if (this.hOy == null) {
                throw new b("Not all required fields were included: ProductName");
            } else if (this.mjd == null) {
                throw new b("Not all required fields were included: SellerName");
            } else if (this.mje == null) {
                throw new b("Not all required fields were included: SellerUserName");
            } else {
                if (this.mjc != null) {
                    aVar.e(1, this.mjc);
                }
                if (this.hOy != null) {
                    aVar.e(2, this.hOy);
                }
                if (this.mjd != null) {
                    aVar.e(3, this.mjd);
                }
                if (this.mje != null) {
                    aVar.e(4, this.mje);
                }
                aVar.dV(5, this.mjf);
                if (this.mjg == null) {
                    return 0;
                }
                aVar.e(6, this.mjg);
                return 0;
            }
        } else if (i == 1) {
            if (this.mjc != null) {
                r0 = a.a.a.b.b.a.f(1, this.mjc) + 0;
            } else {
                r0 = 0;
            }
            if (this.hOy != null) {
                r0 += a.a.a.b.b.a.f(2, this.hOy);
            }
            if (this.mjd != null) {
                r0 += a.a.a.b.b.a.f(3, this.mjd);
            }
            if (this.mje != null) {
                r0 += a.a.a.b.b.a.f(4, this.mje);
            }
            r0 += a.a.a.a.dS(5, this.mjf);
            if (this.mjg != null) {
                r0 += a.a.a.b.b.a.f(6, this.mjg);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mjc == null) {
                throw new b("Not all required fields were included: ProductId");
            } else if (this.hOy == null) {
                throw new b("Not all required fields were included: ProductName");
            } else if (this.mjd == null) {
                throw new b("Not all required fields were included: SellerName");
            } else if (this.mje != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: SellerUserName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ic icVar = (ic) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    icVar.mjc = aVar3.pMj.readString();
                    return 0;
                case 2:
                    icVar.hOy = aVar3.pMj.readString();
                    return 0;
                case 3:
                    icVar.mjd = aVar3.pMj.readString();
                    return 0;
                case 4:
                    icVar.mje = aVar3.pMj.readString();
                    return 0;
                case 5:
                    icVar.mjf = aVar3.pMj.mH();
                    return 0;
                case 6:
                    icVar.mjg = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
