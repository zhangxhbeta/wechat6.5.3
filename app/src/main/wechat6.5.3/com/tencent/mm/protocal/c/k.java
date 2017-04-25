package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.as;

public final class k extends a {
    public long bst;
    public int cqN;
    public String lYF;
    public String lYG;
    public String lYw;
    public String lYx;
    public int state;
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.lYw != null) {
                aVar.e(1, this.lYw);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            aVar.C(3, this.bst);
            if (this.lYF != null) {
                aVar.e(5, this.lYF);
            }
            aVar.dV(10, this.state);
            aVar.dV(11, this.cqN);
            if (this.lYG != null) {
                aVar.e(12, this.lYG);
            }
            if (this.lYx == null) {
                return 0;
            }
            aVar.e(13, this.lYx);
            return 0;
        } else if (i == 1) {
            if (this.lYw != null) {
                r0 = a.a.a.b.b.a.f(1, this.lYw) + 0;
            } else {
                r0 = 0;
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(2, this.title);
            }
            r0 += a.a.a.a.B(3, this.bst);
            if (this.lYF != null) {
                r0 += a.a.a.b.b.a.f(5, this.lYF);
            }
            r0 = (r0 + a.a.a.a.dS(10, this.state)) + a.a.a.a.dS(11, this.cqN);
            if (this.lYG != null) {
                r0 += a.a.a.b.b.a.f(12, this.lYG);
            }
            if (this.lYx != null) {
                r0 += a.a.a.b.b.a.f(13, this.lYx);
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
            k kVar = (k) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    kVar.lYw = aVar3.pMj.readString();
                    return 0;
                case 2:
                    kVar.title = aVar3.pMj.readString();
                    return 0;
                case 3:
                    kVar.bst = aVar3.pMj.mI();
                    return 0;
                case 5:
                    kVar.lYF = aVar3.pMj.readString();
                    return 0;
                case 10:
                    kVar.state = aVar3.pMj.mH();
                    return 0;
                case 11:
                    kVar.cqN = aVar3.pMj.mH();
                    return 0;
                case 12:
                    kVar.lYG = aVar3.pMj.readString();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    kVar.lYx = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
