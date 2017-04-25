package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class ph extends a {
    public int mrf;
    public String mrg;
    public String mrh;
    public String mri;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mrf);
            if (this.mrg != null) {
                aVar.e(2, this.mrg);
            }
            if (this.mrh != null) {
                aVar.e(3, this.mrh);
            }
            if (this.mri != null) {
                aVar.e(4, this.mri);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mrf) + 0;
            if (this.mrg != null) {
                r0 += a.a.a.b.b.a.f(2, this.mrg);
            }
            if (this.mrh != null) {
                r0 += a.a.a.b.b.a.f(3, this.mrh);
            }
            if (this.mri != null) {
                return r0 + a.a.a.b.b.a.f(4, this.mri);
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
            ph phVar = (ph) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    phVar.mrf = aVar3.pMj.mH();
                    return 0;
                case 2:
                    phVar.mrg = aVar3.pMj.readString();
                    return 0;
                case 3:
                    phVar.mrh = aVar3.pMj.readString();
                    return 0;
                case 4:
                    phVar.mri = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
