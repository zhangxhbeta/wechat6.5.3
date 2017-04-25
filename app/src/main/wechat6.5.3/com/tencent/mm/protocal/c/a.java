package com.tencent.mm.protocal.c;

public final class a extends com.tencent.mm.ba.a {
    public String bhe;
    public int bkU;
    public String hcm;
    public String hcn;
    public String kMP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.bkU);
            if (this.bhe != null) {
                aVar.e(2, this.bhe);
            }
            if (this.hcm != null) {
                aVar.e(3, this.hcm);
            }
            if (this.hcn != null) {
                aVar.e(4, this.hcn);
            }
            if (this.kMP != null) {
                aVar.e(5, this.kMP);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.bkU) + 0;
            if (this.bhe != null) {
                r0 += a.a.a.b.b.a.f(2, this.bhe);
            }
            if (this.hcm != null) {
                r0 += a.a.a.b.b.a.f(3, this.hcm);
            }
            if (this.hcn != null) {
                r0 += a.a.a.b.b.a.f(4, this.hcn);
            }
            if (this.kMP != null) {
                return r0 + a.a.a.b.b.a.f(5, this.kMP);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aVar4.bkU = aVar3.pMj.mH();
                    return 0;
                case 2:
                    aVar4.bhe = aVar3.pMj.readString();
                    return 0;
                case 3:
                    aVar4.hcm = aVar3.pMj.readString();
                    return 0;
                case 4:
                    aVar4.hcn = aVar3.pMj.readString();
                    return 0;
                case 5:
                    aVar4.kMP = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
