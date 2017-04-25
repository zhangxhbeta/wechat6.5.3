package com.tencent.mm.protocal.c;

import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.ba.a;

public final class pn extends a {
    public int mrf;
    public String mrg;
    public String mrh;
    public String mro;
    public String mrp;
    public int mrq;
    public int mrr;
    public String mrs;
    public String mrt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mrf);
            if (this.mrg != null) {
                aVar.e(2, this.mrg);
            }
            if (this.mro != null) {
                aVar.e(3, this.mro);
            }
            if (this.mrp != null) {
                aVar.e(4, this.mrp);
            }
            aVar.dV(5, this.mrq);
            aVar.dV(6, this.mrr);
            if (this.mrs != null) {
                aVar.e(7, this.mrs);
            }
            if (this.mrh != null) {
                aVar.e(8, this.mrh);
            }
            if (this.mrt != null) {
                aVar.e(9, this.mrt);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mrf) + 0;
            if (this.mrg != null) {
                r0 += a.a.a.b.b.a.f(2, this.mrg);
            }
            if (this.mro != null) {
                r0 += a.a.a.b.b.a.f(3, this.mro);
            }
            if (this.mrp != null) {
                r0 += a.a.a.b.b.a.f(4, this.mrp);
            }
            r0 = (r0 + a.a.a.a.dS(5, this.mrq)) + a.a.a.a.dS(6, this.mrr);
            if (this.mrs != null) {
                r0 += a.a.a.b.b.a.f(7, this.mrs);
            }
            if (this.mrh != null) {
                r0 += a.a.a.b.b.a.f(8, this.mrh);
            }
            if (this.mrt != null) {
                return r0 + a.a.a.b.b.a.f(9, this.mrt);
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
            pn pnVar = (pn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    pnVar.mrf = aVar3.pMj.mH();
                    return 0;
                case 2:
                    pnVar.mrg = aVar3.pMj.readString();
                    return 0;
                case 3:
                    pnVar.mro = aVar3.pMj.readString();
                    return 0;
                case 4:
                    pnVar.mrp = aVar3.pMj.readString();
                    return 0;
                case 5:
                    pnVar.mrq = aVar3.pMj.mH();
                    return 0;
                case 6:
                    pnVar.mrr = aVar3.pMj.mH();
                    return 0;
                case 7:
                    pnVar.mrs = aVar3.pMj.readString();
                    return 0;
                case 8:
                    pnVar.mrh = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    pnVar.mrt = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
