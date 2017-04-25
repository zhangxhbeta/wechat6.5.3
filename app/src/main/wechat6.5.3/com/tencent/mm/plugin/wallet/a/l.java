package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;

public final class l extends a {
    public String hNe;
    public String kHv;
    public String kHw;
    public String kHx;
    public int kIc;
    public int kId;
    public long kIe;
    public String kIf;
    public String kIg;
    public String kIh;
    public double kIi;
    public double kIj;
    public int kIk;
    public String kIl;
    public String kIm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.kIc);
            aVar.dV(2, this.kId);
            aVar.C(3, this.kIe);
            if (this.kIf != null) {
                aVar.e(4, this.kIf);
            }
            if (this.kHv != null) {
                aVar.e(5, this.kHv);
            }
            if (this.kIg != null) {
                aVar.e(6, this.kIg);
            }
            if (this.kIh != null) {
                aVar.e(7, this.kIh);
            }
            if (this.kHw != null) {
                aVar.e(8, this.kHw);
            }
            if (this.kHx != null) {
                aVar.e(9, this.kHx);
            }
            aVar.a(10, this.kIi);
            aVar.a(11, this.kIj);
            aVar.dV(12, this.kIk);
            if (this.kIl != null) {
                aVar.e(13, this.kIl);
            }
            if (this.hNe != null) {
                aVar.e(14, this.hNe);
            }
            if (this.kIm != null) {
                aVar.e(16, this.kIm);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.dS(1, this.kIc) + 0) + a.a.a.a.dS(2, this.kId)) + a.a.a.a.B(3, this.kIe);
            if (this.kIf != null) {
                r0 += a.a.a.b.b.a.f(4, this.kIf);
            }
            if (this.kHv != null) {
                r0 += a.a.a.b.b.a.f(5, this.kHv);
            }
            if (this.kIg != null) {
                r0 += a.a.a.b.b.a.f(6, this.kIg);
            }
            if (this.kIh != null) {
                r0 += a.a.a.b.b.a.f(7, this.kIh);
            }
            if (this.kHw != null) {
                r0 += a.a.a.b.b.a.f(8, this.kHw);
            }
            if (this.kHx != null) {
                r0 += a.a.a.b.b.a.f(9, this.kHx);
            }
            r0 = ((r0 + (a.a.a.b.b.a.cw(10) + 8)) + (a.a.a.b.b.a.cw(11) + 8)) + a.a.a.a.dS(12, this.kIk);
            if (this.kIl != null) {
                r0 += a.a.a.b.b.a.f(13, this.kIl);
            }
            if (this.hNe != null) {
                r0 += a.a.a.b.b.a.f(14, this.hNe);
            }
            if (this.kIm != null) {
                return r0 + a.a.a.b.b.a.f(16, this.kIm);
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
            l lVar = (l) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    lVar.kIc = aVar3.pMj.mH();
                    return 0;
                case 2:
                    lVar.kId = aVar3.pMj.mH();
                    return 0;
                case 3:
                    lVar.kIe = aVar3.pMj.mI();
                    return 0;
                case 4:
                    lVar.kIf = aVar3.pMj.readString();
                    return 0;
                case 5:
                    lVar.kHv = aVar3.pMj.readString();
                    return 0;
                case 6:
                    lVar.kIg = aVar3.pMj.readString();
                    return 0;
                case 7:
                    lVar.kIh = aVar3.pMj.readString();
                    return 0;
                case 8:
                    lVar.kHw = aVar3.pMj.readString();
                    return 0;
                case 9:
                    lVar.kHx = aVar3.pMj.readString();
                    return 0;
                case 10:
                    lVar.kIi = aVar3.pMj.readDouble();
                    return 0;
                case 11:
                    lVar.kIj = aVar3.pMj.readDouble();
                    return 0;
                case 12:
                    lVar.kIk = aVar3.pMj.mH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    lVar.kIl = aVar3.pMj.readString();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    lVar.hNe = aVar3.pMj.readString();
                    return 0;
                case 16:
                    lVar.kIm = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
