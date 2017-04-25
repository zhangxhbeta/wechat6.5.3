package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bt extends a {
    public String cHd;
    public String cHe;
    public String cHl;
    public String gln;
    public String glo;
    public String mcl;
    public String mcm;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.cHl != null) {
                aVar.e(1, this.cHl);
            }
            if (this.cHd != null) {
                aVar.e(2, this.cHd);
            }
            if (this.cHe != null) {
                aVar.e(3, this.cHe);
            }
            if (this.glo != null) {
                aVar.e(4, this.glo);
            }
            if (this.gln != null) {
                aVar.e(5, this.gln);
            }
            if (this.mcl != null) {
                aVar.e(6, this.mcl);
            }
            if (this.mcm == null) {
                return 0;
            }
            aVar.e(7, this.mcm);
            return 0;
        } else if (i == 1) {
            if (this.cHl != null) {
                r0 = a.a.a.b.b.a.f(1, this.cHl) + 0;
            } else {
                r0 = 0;
            }
            if (this.cHd != null) {
                r0 += a.a.a.b.b.a.f(2, this.cHd);
            }
            if (this.cHe != null) {
                r0 += a.a.a.b.b.a.f(3, this.cHe);
            }
            if (this.glo != null) {
                r0 += a.a.a.b.b.a.f(4, this.glo);
            }
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(5, this.gln);
            }
            if (this.mcl != null) {
                r0 += a.a.a.b.b.a.f(6, this.mcl);
            }
            if (this.mcm != null) {
                r0 += a.a.a.b.b.a.f(7, this.mcm);
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
            bt btVar = (bt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    btVar.cHl = aVar3.pMj.readString();
                    return 0;
                case 2:
                    btVar.cHd = aVar3.pMj.readString();
                    return 0;
                case 3:
                    btVar.cHe = aVar3.pMj.readString();
                    return 0;
                case 4:
                    btVar.glo = aVar3.pMj.readString();
                    return 0;
                case 5:
                    btVar.gln = aVar3.pMj.readString();
                    return 0;
                case 6:
                    btVar.mcl = aVar3.pMj.readString();
                    return 0;
                case 7:
                    btVar.mcm = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
