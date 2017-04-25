package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class br extends a implements avb {
    public String fvD;
    public String gln;
    public int mcj;

    public final int getRet() {
        return this.mcj;
    }

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mcj);
            if (this.gln != null) {
                aVar.e(2, this.gln);
            }
            if (this.fvD != null) {
                aVar.e(3, this.fvD);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mcj) + 0;
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(2, this.gln);
            }
            if (this.fvD != null) {
                return r0 + a.a.a.b.b.a.f(3, this.fvD);
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
            br brVar = (br) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    brVar.mcj = aVar3.pMj.mH();
                    return 0;
                case 2:
                    brVar.gln = aVar3.pMj.readString();
                    return 0;
                case 3:
                    brVar.fvD = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
