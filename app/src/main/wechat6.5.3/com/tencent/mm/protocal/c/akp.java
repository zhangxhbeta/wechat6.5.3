package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class akp extends a {
    public String cUd;
    public int mLA;
    public String mLB;
    public int mLC;
    public String mLD;
    public int mLz;
    public int miI;
    public int mnk;
    public int moo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.cUd != null) {
                aVar.e(1, this.cUd);
            }
            aVar.dV(2, this.mLz);
            aVar.dV(3, this.mLA);
            aVar.dV(4, this.miI);
            if (this.mLB != null) {
                aVar.e(5, this.mLB);
            }
            aVar.dV(6, this.moo);
            aVar.dV(7, this.mLC);
            aVar.dV(8, this.mnk);
            if (this.mLD == null) {
                return 0;
            }
            aVar.e(9, this.mLD);
            return 0;
        } else if (i == 1) {
            if (this.cUd != null) {
                r0 = a.a.a.b.b.a.f(1, this.cUd) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.dS(2, this.mLz)) + a.a.a.a.dS(3, this.mLA)) + a.a.a.a.dS(4, this.miI);
            if (this.mLB != null) {
                r0 += a.a.a.b.b.a.f(5, this.mLB);
            }
            r0 = ((r0 + a.a.a.a.dS(6, this.moo)) + a.a.a.a.dS(7, this.mLC)) + a.a.a.a.dS(8, this.mnk);
            if (this.mLD != null) {
                r0 += a.a.a.b.b.a.f(9, this.mLD);
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
            akp com_tencent_mm_protocal_c_akp = (akp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_akp.cUd = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akp.mLz = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akp.mLA = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akp.miI = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_akp.mLB = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_akp.moo = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_akp.mLC = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_akp.mnk = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_akp.mLD = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
