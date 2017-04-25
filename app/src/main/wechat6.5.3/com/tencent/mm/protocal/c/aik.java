package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class aik extends a {
    public int cHc;
    public String cHd;
    public String cHe;
    public String cHf;
    public String cHl;
    public int efm;
    public String gln;
    public int mIT;
    public int mIU;
    public String mlY;
    public String mlZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gln != null) {
                aVar.e(1, this.gln);
            }
            aVar.dV(2, this.efm);
            aVar.dV(3, this.cHc);
            if (this.cHe != null) {
                aVar.e(4, this.cHe);
            }
            if (this.cHd != null) {
                aVar.e(5, this.cHd);
            }
            if (this.cHf != null) {
                aVar.e(6, this.cHf);
            }
            aVar.dV(7, this.mIT);
            aVar.dV(8, this.mIU);
            if (this.cHl != null) {
                aVar.e(9, this.cHl);
            }
            if (this.mlY != null) {
                aVar.e(10, this.mlY);
            }
            if (this.mlZ == null) {
                return 0;
            }
            aVar.e(11, this.mlZ);
            return 0;
        } else if (i == 1) {
            if (this.gln != null) {
                r0 = a.a.a.b.b.a.f(1, this.gln) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.efm)) + a.a.a.a.dS(3, this.cHc);
            if (this.cHe != null) {
                r0 += a.a.a.b.b.a.f(4, this.cHe);
            }
            if (this.cHd != null) {
                r0 += a.a.a.b.b.a.f(5, this.cHd);
            }
            if (this.cHf != null) {
                r0 += a.a.a.b.b.a.f(6, this.cHf);
            }
            r0 = (r0 + a.a.a.a.dS(7, this.mIT)) + a.a.a.a.dS(8, this.mIU);
            if (this.cHl != null) {
                r0 += a.a.a.b.b.a.f(9, this.cHl);
            }
            if (this.mlY != null) {
                r0 += a.a.a.b.b.a.f(10, this.mlY);
            }
            if (this.mlZ != null) {
                r0 += a.a.a.b.b.a.f(11, this.mlZ);
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
            aik com_tencent_mm_protocal_c_aik = (aik) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aik.gln = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aik.efm = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aik.cHc = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aik.cHe = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aik.cHd = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aik.cHf = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aik.mIT = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aik.mIU = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aik.cHl = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aik.mlY = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aik.mlZ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
