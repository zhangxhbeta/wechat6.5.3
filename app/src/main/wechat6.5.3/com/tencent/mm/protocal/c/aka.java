package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class aka extends a {
    public String efy;
    public int fvo;
    public String gln;
    public int mEk;
    public String mKI;
    public String mgi;
    public String mnX;
    public int muJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.fvo);
            if (this.efy != null) {
                aVar.e(2, this.efy);
            }
            if (this.mgi != null) {
                aVar.e(3, this.mgi);
            }
            if (this.mnX != null) {
                aVar.e(4, this.mnX);
            }
            if (this.gln != null) {
                aVar.e(5, this.gln);
            }
            aVar.dV(6, this.mEk);
            aVar.dV(7, this.muJ);
            if (this.mKI != null) {
                aVar.e(8, this.mKI);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.fvo) + 0;
            if (this.efy != null) {
                r0 += a.a.a.b.b.a.f(2, this.efy);
            }
            if (this.mgi != null) {
                r0 += a.a.a.b.b.a.f(3, this.mgi);
            }
            if (this.mnX != null) {
                r0 += a.a.a.b.b.a.f(4, this.mnX);
            }
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(5, this.gln);
            }
            r0 = (r0 + a.a.a.a.dS(6, this.mEk)) + a.a.a.a.dS(7, this.muJ);
            if (this.mKI != null) {
                return r0 + a.a.a.b.b.a.f(8, this.mKI);
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
            aka com_tencent_mm_protocal_c_aka = (aka) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aka.fvo = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aka.efy = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aka.mgi = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aka.mnX = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aka.gln = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aka.mEk = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aka.muJ = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aka.mKI = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
