package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;

public final class h extends a {
    public String haA;
    public String haB;
    public long haE;
    public long haH;
    public String haI;
    public int haW;
    public int hau;
    public String hbg;
    public long hbh;
    public String hbi;
    public String hbj;
    public String hbk;
    public long hbl;
    public int hbm;
    public int status;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.hbg != null) {
                aVar.e(1, this.hbg);
            }
            if (this.haA != null) {
                aVar.e(2, this.haA);
            }
            aVar.C(3, this.hbh);
            if (this.hbi != null) {
                aVar.e(4, this.hbi);
            }
            aVar.dV(5, this.hau);
            if (this.hbj != null) {
                aVar.e(6, this.hbj);
            }
            if (this.hbk != null) {
                aVar.e(7, this.hbk);
            }
            aVar.C(8, this.haH);
            aVar.C(9, this.hbl);
            aVar.C(10, this.haE);
            aVar.dV(11, this.status);
            aVar.dV(12, this.hbm);
            if (this.haI != null) {
                aVar.e(13, this.haI);
            }
            if (this.haB != null) {
                aVar.e(14, this.haB);
            }
            aVar.dV(15, this.haW);
            return 0;
        } else if (i == 1) {
            if (this.hbg != null) {
                r0 = a.a.a.b.b.a.f(1, this.hbg) + 0;
            } else {
                r0 = 0;
            }
            if (this.haA != null) {
                r0 += a.a.a.b.b.a.f(2, this.haA);
            }
            r0 += a.a.a.a.B(3, this.hbh);
            if (this.hbi != null) {
                r0 += a.a.a.b.b.a.f(4, this.hbi);
            }
            r0 += a.a.a.a.dS(5, this.hau);
            if (this.hbj != null) {
                r0 += a.a.a.b.b.a.f(6, this.hbj);
            }
            if (this.hbk != null) {
                r0 += a.a.a.b.b.a.f(7, this.hbk);
            }
            r0 = ((((r0 + a.a.a.a.B(8, this.haH)) + a.a.a.a.B(9, this.hbl)) + a.a.a.a.B(10, this.haE)) + a.a.a.a.dS(11, this.status)) + a.a.a.a.dS(12, this.hbm);
            if (this.haI != null) {
                r0 += a.a.a.b.b.a.f(13, this.haI);
            }
            if (this.haB != null) {
                r0 += a.a.a.b.b.a.f(14, this.haB);
            }
            return r0 + a.a.a.a.dS(15, this.haW);
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
            h hVar = (h) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    hVar.hbg = aVar3.pMj.readString();
                    return 0;
                case 2:
                    hVar.haA = aVar3.pMj.readString();
                    return 0;
                case 3:
                    hVar.hbh = aVar3.pMj.mI();
                    return 0;
                case 4:
                    hVar.hbi = aVar3.pMj.readString();
                    return 0;
                case 5:
                    hVar.hau = aVar3.pMj.mH();
                    return 0;
                case 6:
                    hVar.hbj = aVar3.pMj.readString();
                    return 0;
                case 7:
                    hVar.hbk = aVar3.pMj.readString();
                    return 0;
                case 8:
                    hVar.haH = aVar3.pMj.mI();
                    return 0;
                case 9:
                    hVar.hbl = aVar3.pMj.mI();
                    return 0;
                case 10:
                    hVar.haE = aVar3.pMj.mI();
                    return 0;
                case 11:
                    hVar.status = aVar3.pMj.mH();
                    return 0;
                case 12:
                    hVar.hbm = aVar3.pMj.mH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    hVar.haI = aVar3.pMj.readString();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    hVar.haB = aVar3.pMj.readString();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    hVar.haW = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
