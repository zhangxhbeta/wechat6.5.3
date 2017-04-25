package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class afh extends a {
    public int mFk;
    public String mio;
    public String mip;
    public String miq;
    public String mir;
    public String mis;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mio != null) {
                aVar.e(1, this.mio);
            }
            if (this.mip != null) {
                aVar.e(2, this.mip);
            }
            if (this.miq != null) {
                aVar.e(3, this.miq);
            }
            if (this.mir != null) {
                aVar.e(4, this.mir);
            }
            if (this.mis != null) {
                aVar.e(5, this.mis);
            }
            aVar.dV(6, this.mFk);
            return 0;
        } else if (i == 1) {
            if (this.mio != null) {
                r0 = a.a.a.b.b.a.f(1, this.mio) + 0;
            } else {
                r0 = 0;
            }
            if (this.mip != null) {
                r0 += a.a.a.b.b.a.f(2, this.mip);
            }
            if (this.miq != null) {
                r0 += a.a.a.b.b.a.f(3, this.miq);
            }
            if (this.mir != null) {
                r0 += a.a.a.b.b.a.f(4, this.mir);
            }
            if (this.mis != null) {
                r0 += a.a.a.b.b.a.f(5, this.mis);
            }
            return r0 + a.a.a.a.dS(6, this.mFk);
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
            afh com_tencent_mm_protocal_c_afh = (afh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_afh.mio = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afh.mip = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afh.miq = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_afh.mir = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_afh.mis = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_afh.mFk = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
