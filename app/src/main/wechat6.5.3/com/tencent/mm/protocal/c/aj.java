package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class aj extends a {
    public String glj;
    public String maD;
    public String maE;
    public String maF;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.glj != null) {
                aVar.e(1, this.glj);
            }
            if (this.maD != null) {
                aVar.e(2, this.maD);
            }
            if (this.maE != null) {
                aVar.e(3, this.maE);
            }
            if (this.maF == null) {
                return 0;
            }
            aVar.e(4, this.maF);
            return 0;
        } else if (i == 1) {
            if (this.glj != null) {
                r0 = a.a.a.b.b.a.f(1, this.glj) + 0;
            } else {
                r0 = 0;
            }
            if (this.maD != null) {
                r0 += a.a.a.b.b.a.f(2, this.maD);
            }
            if (this.maE != null) {
                r0 += a.a.a.b.b.a.f(3, this.maE);
            }
            if (this.maF != null) {
                r0 += a.a.a.b.b.a.f(4, this.maF);
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
            aj ajVar = (aj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ajVar.glj = aVar3.pMj.readString();
                    return 0;
                case 2:
                    ajVar.maD = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ajVar.maE = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ajVar.maF = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
