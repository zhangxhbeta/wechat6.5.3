package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class akr extends a {
    public int mLC;
    public String mLD;
    public String mLF;
    public int miI;
    public int mnk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.miI);
            if (this.mLF != null) {
                aVar.e(3, this.mLF);
            }
            aVar.dV(4, this.mLC);
            aVar.dV(5, this.mnk);
            if (this.mLD != null) {
                aVar.e(6, this.mLD);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.miI) + 0;
            if (this.mLF != null) {
                r0 += a.a.a.b.b.a.f(3, this.mLF);
            }
            r0 = (r0 + a.a.a.a.dS(4, this.mLC)) + a.a.a.a.dS(5, this.mnk);
            if (this.mLD != null) {
                return r0 + a.a.a.b.b.a.f(6, this.mLD);
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
            akr com_tencent_mm_protocal_c_akr = (akr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_akr.miI = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akr.mLF = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akr.mLC = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_akr.mnk = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_akr.mLD = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
