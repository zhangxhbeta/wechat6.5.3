package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bbv extends a {
    public int mcj;
    public int mdA;
    public int mdz;
    public String mpI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mcj);
            aVar.dV(2, this.mdA);
            aVar.dV(3, this.mdz);
            if (this.mpI != null) {
                aVar.e(4, this.mpI);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.dS(1, this.mcj) + 0) + a.a.a.a.dS(2, this.mdA)) + a.a.a.a.dS(3, this.mdz);
            if (this.mpI != null) {
                return r0 + a.a.a.b.b.a.f(4, this.mpI);
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
            bbv com_tencent_mm_protocal_c_bbv = (bbv) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bbv.mcj = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bbv.mdA = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bbv.mdz = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bbv.mpI = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
