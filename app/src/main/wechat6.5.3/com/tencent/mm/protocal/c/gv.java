package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class gv extends a {
    public String mhD;
    public String mhJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mhJ != null) {
                aVar.e(2, this.mhJ);
            }
            if (this.mhD == null) {
                return 0;
            }
            aVar.e(3, this.mhD);
            return 0;
        } else if (i == 1) {
            if (this.mhJ != null) {
                r0 = a.a.a.b.b.a.f(2, this.mhJ) + 0;
            } else {
                r0 = 0;
            }
            if (this.mhD != null) {
                r0 += a.a.a.b.b.a.f(3, this.mhD);
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
            gv gvVar = (gv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 2:
                    gvVar.mhJ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    gvVar.mhD = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
