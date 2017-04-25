package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class od extends a {
    public String glb;
    public int moo;
    public String mpF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.glb != null) {
                aVar.e(1, this.glb);
            }
            if (this.mpF != null) {
                aVar.e(2, this.mpF);
            }
            aVar.dV(3, this.moo);
            return 0;
        } else if (i == 1) {
            if (this.glb != null) {
                r0 = a.a.a.b.b.a.f(1, this.glb) + 0;
            } else {
                r0 = 0;
            }
            if (this.mpF != null) {
                r0 += a.a.a.b.b.a.f(2, this.mpF);
            }
            return r0 + a.a.a.a.dS(3, this.moo);
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
            od odVar = (od) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    odVar.glb = aVar3.pMj.readString();
                    return 0;
                case 2:
                    odVar.mpF = aVar3.pMj.readString();
                    return 0;
                case 3:
                    odVar.moo = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
