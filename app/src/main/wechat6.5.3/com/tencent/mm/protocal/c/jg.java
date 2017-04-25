package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public class jg extends a {
    public String eBN;
    public String eEL;
    public long mlB;
    public String title;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.eBN != null) {
                aVar.e(2, this.eBN);
            }
            if (this.eEL != null) {
                aVar.e(3, this.eEL);
            }
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            aVar.C(5, this.mlB);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.eBN != null) {
                r0 += a.a.a.b.b.a.f(2, this.eBN);
            }
            if (this.eEL != null) {
                r0 += a.a.a.b.b.a.f(3, this.eEL);
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(4, this.url);
            }
            return r0 + a.a.a.a.B(5, this.mlB);
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
            jg jgVar = (jg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jgVar.title = aVar3.pMj.readString();
                    return 0;
                case 2:
                    jgVar.eBN = aVar3.pMj.readString();
                    return 0;
                case 3:
                    jgVar.eEL = aVar3.pMj.readString();
                    return 0;
                case 4:
                    jgVar.url = aVar3.pMj.readString();
                    return 0;
                case 5:
                    jgVar.mlB = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
