package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class acm extends a {
    public String aXz;
    public int efm;
    public String glb;
    public String hNZ;
    public String mDD;
    public String mDE;
    public String mDF;
    public String mDG;
    public String mDH;
    public int mDI;
    public String mDJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.aXz != null) {
                aVar.e(1, this.aXz);
            }
            if (this.mDD != null) {
                aVar.e(2, this.mDD);
            }
            aVar.dV(3, this.efm);
            if (this.glb != null) {
                aVar.e(4, this.glb);
            }
            if (this.mDE != null) {
                aVar.e(5, this.mDE);
            }
            if (this.mDF != null) {
                aVar.e(6, this.mDF);
            }
            if (this.mDG != null) {
                aVar.e(7, this.mDG);
            }
            if (this.hNZ != null) {
                aVar.e(8, this.hNZ);
            }
            if (this.mDH != null) {
                aVar.e(9, this.mDH);
            }
            aVar.dV(10, this.mDI);
            if (this.mDJ == null) {
                return 0;
            }
            aVar.e(11, this.mDJ);
            return 0;
        } else if (i == 1) {
            if (this.aXz != null) {
                r0 = a.a.a.b.b.a.f(1, this.aXz) + 0;
            } else {
                r0 = 0;
            }
            if (this.mDD != null) {
                r0 += a.a.a.b.b.a.f(2, this.mDD);
            }
            r0 += a.a.a.a.dS(3, this.efm);
            if (this.glb != null) {
                r0 += a.a.a.b.b.a.f(4, this.glb);
            }
            if (this.mDE != null) {
                r0 += a.a.a.b.b.a.f(5, this.mDE);
            }
            if (this.mDF != null) {
                r0 += a.a.a.b.b.a.f(6, this.mDF);
            }
            if (this.mDG != null) {
                r0 += a.a.a.b.b.a.f(7, this.mDG);
            }
            if (this.hNZ != null) {
                r0 += a.a.a.b.b.a.f(8, this.hNZ);
            }
            if (this.mDH != null) {
                r0 += a.a.a.b.b.a.f(9, this.mDH);
            }
            r0 += a.a.a.a.dS(10, this.mDI);
            if (this.mDJ != null) {
                r0 += a.a.a.b.b.a.f(11, this.mDJ);
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
            acm com_tencent_mm_protocal_c_acm = (acm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_acm.aXz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_acm.mDD = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_acm.efm = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_acm.glb = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_acm.mDE = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_acm.mDF = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_acm.mDG = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_acm.hNZ = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_acm.mDH = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_acm.mDI = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_acm.mDJ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
