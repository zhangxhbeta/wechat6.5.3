package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class jf extends a {
    public int mlA;
    public String mlv;
    public String mlw;
    public int mlx;
    public int mly;
    public int mlz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mlv != null) {
                aVar.e(1, this.mlv);
            }
            if (this.mlw != null) {
                aVar.e(2, this.mlw);
            }
            aVar.dV(3, this.mlx);
            aVar.dV(4, this.mly);
            aVar.dV(5, this.mlz);
            aVar.dV(6, this.mlA);
            return 0;
        } else if (i == 1) {
            if (this.mlv != null) {
                r0 = a.a.a.b.b.a.f(1, this.mlv) + 0;
            } else {
                r0 = 0;
            }
            if (this.mlw != null) {
                r0 += a.a.a.b.b.a.f(2, this.mlw);
            }
            return (((r0 + a.a.a.a.dS(3, this.mlx)) + a.a.a.a.dS(4, this.mly)) + a.a.a.a.dS(5, this.mlz)) + a.a.a.a.dS(6, this.mlA);
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
            jf jfVar = (jf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    jfVar.mlv = aVar3.pMj.readString();
                    return 0;
                case 2:
                    jfVar.mlw = aVar3.pMj.readString();
                    return 0;
                case 3:
                    jfVar.mlx = aVar3.pMj.mH();
                    return 0;
                case 4:
                    jfVar.mly = aVar3.pMj.mH();
                    return 0;
                case 5:
                    jfVar.mlz = aVar3.pMj.mH();
                    return 0;
                case 6:
                    jfVar.mlA = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
