package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;

public final class ao extends a {
    public String cZo;
    public String desc;
    public String gmJ;
    public String gmK;
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.cZo != null) {
                aVar.e(2, this.cZo);
            }
            if (this.gmJ != null) {
                aVar.e(3, this.gmJ);
            }
            if (this.desc != null) {
                aVar.e(4, this.desc);
            }
            if (this.gmK == null) {
                return 0;
            }
            aVar.e(5, this.gmK);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.cZo != null) {
                r0 += a.a.a.b.b.a.f(2, this.cZo);
            }
            if (this.gmJ != null) {
                r0 += a.a.a.b.b.a.f(3, this.gmJ);
            }
            if (this.desc != null) {
                r0 += a.a.a.b.b.a.f(4, this.desc);
            }
            if (this.gmK != null) {
                r0 += a.a.a.b.b.a.f(5, this.gmK);
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
            ao aoVar = (ao) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aoVar.title = aVar3.pMj.readString();
                    return 0;
                case 2:
                    aoVar.cZo = aVar3.pMj.readString();
                    return 0;
                case 3:
                    aoVar.gmJ = aVar3.pMj.readString();
                    return 0;
                case 4:
                    aoVar.desc = aVar3.pMj.readString();
                    return 0;
                case 5:
                    aoVar.gmK = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
