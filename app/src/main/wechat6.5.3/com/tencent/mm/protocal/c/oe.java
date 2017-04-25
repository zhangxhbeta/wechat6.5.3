package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class oe extends a {
    public String gnp;
    public int mfK;
    public String mpX;
    public String mpY;
    public int mpZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mpY != null) {
                aVar.e(1, this.mpY);
            }
            aVar.dV(2, this.mfK);
            aVar.dV(3, this.mpZ);
            if (this.gnp != null) {
                aVar.e(4, this.gnp);
            }
            if (this.mpX == null) {
                return 0;
            }
            aVar.e(5, this.mpX);
            return 0;
        } else if (i == 1) {
            if (this.mpY != null) {
                r0 = a.a.a.b.b.a.f(1, this.mpY) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.mfK)) + a.a.a.a.dS(3, this.mpZ);
            if (this.gnp != null) {
                r0 += a.a.a.b.b.a.f(4, this.gnp);
            }
            if (this.mpX != null) {
                r0 += a.a.a.b.b.a.f(5, this.mpX);
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
            oe oeVar = (oe) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    oeVar.mpY = aVar3.pMj.readString();
                    return 0;
                case 2:
                    oeVar.mfK = aVar3.pMj.mH();
                    return 0;
                case 3:
                    oeVar.mpZ = aVar3.pMj.mH();
                    return 0;
                case 4:
                    oeVar.gnp = aVar3.pMj.readString();
                    return 0;
                case 5:
                    oeVar.mpX = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
