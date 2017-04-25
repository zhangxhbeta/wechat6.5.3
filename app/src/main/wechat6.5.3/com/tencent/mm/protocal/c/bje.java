package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.as;

public final class bje extends a {
    public int efm;
    public int fvO;
    public String glj;
    public int itH;
    public int itI;
    public String ndB;
    public String ndC;
    public String ndD;
    public String ndE;
    public int ndF;
    public int ndG;
    public String ndH;
    public int ndt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.efm);
            if (this.glj != null) {
                aVar.e(2, this.glj);
            }
            if (this.ndB != null) {
                aVar.e(3, this.ndB);
            }
            aVar.dV(4, this.itH);
            aVar.dV(5, this.fvO);
            aVar.dV(6, this.itI);
            if (this.ndC != null) {
                aVar.e(7, this.ndC);
            }
            aVar.dV(8, this.ndt);
            if (this.ndD != null) {
                aVar.e(9, this.ndD);
            }
            if (this.ndE != null) {
                aVar.e(10, this.ndE);
            }
            aVar.dV(11, this.ndF);
            aVar.dV(12, this.ndG);
            if (this.ndH != null) {
                aVar.e(13, this.ndH);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.efm) + 0;
            if (this.glj != null) {
                r0 += a.a.a.b.b.a.f(2, this.glj);
            }
            if (this.ndB != null) {
                r0 += a.a.a.b.b.a.f(3, this.ndB);
            }
            r0 = ((r0 + a.a.a.a.dS(4, this.itH)) + a.a.a.a.dS(5, this.fvO)) + a.a.a.a.dS(6, this.itI);
            if (this.ndC != null) {
                r0 += a.a.a.b.b.a.f(7, this.ndC);
            }
            r0 += a.a.a.a.dS(8, this.ndt);
            if (this.ndD != null) {
                r0 += a.a.a.b.b.a.f(9, this.ndD);
            }
            if (this.ndE != null) {
                r0 += a.a.a.b.b.a.f(10, this.ndE);
            }
            r0 = (r0 + a.a.a.a.dS(11, this.ndF)) + a.a.a.a.dS(12, this.ndG);
            if (this.ndH != null) {
                return r0 + a.a.a.b.b.a.f(13, this.ndH);
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
            bje com_tencent_mm_protocal_c_bje = (bje) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bje.efm = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bje.glj = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bje.ndB = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bje.itH = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bje.fvO = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bje.itI = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bje.ndC = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bje.ndt = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bje.ndD = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bje.ndE = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bje.ndF = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bje.ndG = aVar3.pMj.mH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_bje.ndH = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
