package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class w extends a {
    public String hcl;
    public String hcm;
    public String hcn;
    public String hco;
    public int lZi;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.lZi);
            if (this.hcl != null) {
                aVar.e(2, this.hcl);
            }
            if (this.hcm != null) {
                aVar.e(3, this.hcm);
            }
            if (this.hcn != null) {
                aVar.e(4, this.hcn);
            }
            if (this.hco != null) {
                aVar.e(5, this.hco);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.lZi) + 0;
            if (this.hcl != null) {
                r0 += a.a.a.b.b.a.f(2, this.hcl);
            }
            if (this.hcm != null) {
                r0 += a.a.a.b.b.a.f(3, this.hcm);
            }
            if (this.hcn != null) {
                r0 += a.a.a.b.b.a.f(4, this.hcn);
            }
            if (this.hco != null) {
                return r0 + a.a.a.b.b.a.f(5, this.hco);
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
            w wVar = (w) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    wVar.lZi = aVar3.pMj.mH();
                    return 0;
                case 2:
                    wVar.hcl = aVar3.pMj.readString();
                    return 0;
                case 3:
                    wVar.hcm = aVar3.pMj.readString();
                    return 0;
                case 4:
                    wVar.hcn = aVar3.pMj.readString();
                    return 0;
                case 5:
                    wVar.hco = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
