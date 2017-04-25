package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class agp extends a {
    public float aJp;
    public String cHe;
    public String gUr;
    public String jGR;
    public int jGT;
    public int jGV;
    public String mGi;
    public String mGj;
    public int mGk;
    public int mGl;
    public b mGm;
    public float mjM;
    public float mjN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.j(1, this.mjM);
            aVar.j(2, this.mjN);
            if (this.cHe != null) {
                aVar.e(3, this.cHe);
            }
            if (this.gUr != null) {
                aVar.e(4, this.gUr);
            }
            if (this.jGR != null) {
                aVar.e(5, this.jGR);
            }
            if (this.mGi != null) {
                aVar.e(6, this.mGi);
            }
            aVar.dV(7, this.jGT);
            if (this.mGj != null) {
                aVar.e(8, this.mGj);
            }
            aVar.dV(9, this.mGk);
            aVar.dV(10, this.mGl);
            aVar.dV(11, this.jGV);
            aVar.j(12, this.aJp);
            if (this.mGm != null) {
                aVar.b(13, this.mGm);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.b.b.a.cw(1) + 4) + 0) + (a.a.a.b.b.a.cw(2) + 4);
            if (this.cHe != null) {
                r0 += a.a.a.b.b.a.f(3, this.cHe);
            }
            if (this.gUr != null) {
                r0 += a.a.a.b.b.a.f(4, this.gUr);
            }
            if (this.jGR != null) {
                r0 += a.a.a.b.b.a.f(5, this.jGR);
            }
            if (this.mGi != null) {
                r0 += a.a.a.b.b.a.f(6, this.mGi);
            }
            r0 += a.a.a.a.dS(7, this.jGT);
            if (this.mGj != null) {
                r0 += a.a.a.b.b.a.f(8, this.mGj);
            }
            r0 = (((r0 + a.a.a.a.dS(9, this.mGk)) + a.a.a.a.dS(10, this.mGl)) + a.a.a.a.dS(11, this.jGV)) + (a.a.a.b.b.a.cw(12) + 4);
            if (this.mGm != null) {
                return r0 + a.a.a.a.a(13, this.mGm);
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
            agp com_tencent_mm_protocal_c_agp = (agp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_agp.mjM = aVar3.pMj.readFloat();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_agp.mjN = aVar3.pMj.readFloat();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_agp.cHe = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_agp.gUr = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_agp.jGR = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_agp.mGi = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_agp.jGT = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_agp.mGj = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_agp.mGk = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_agp.mGl = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_agp.jGV = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_agp.aJp = aVar3.pMj.readFloat();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_agp.mGm = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
