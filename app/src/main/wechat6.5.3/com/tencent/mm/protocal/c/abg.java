package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class abg extends a {
    public String aXz;
    public String gkC;
    public String gnp;
    public String mCB;
    public String mCC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mCB != null) {
                aVar.e(1, this.mCB);
            }
            if (this.gnp != null) {
                aVar.e(2, this.gnp);
            }
            if (this.aXz != null) {
                aVar.e(3, this.aXz);
            }
            if (this.gkC != null) {
                aVar.e(4, this.gkC);
            }
            if (this.mCC == null) {
                return 0;
            }
            aVar.e(5, this.mCC);
            return 0;
        } else if (i == 1) {
            if (this.mCB != null) {
                r0 = a.a.a.b.b.a.f(1, this.mCB) + 0;
            } else {
                r0 = 0;
            }
            if (this.gnp != null) {
                r0 += a.a.a.b.b.a.f(2, this.gnp);
            }
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(3, this.aXz);
            }
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(4, this.gkC);
            }
            if (this.mCC != null) {
                r0 += a.a.a.b.b.a.f(5, this.mCC);
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
            abg com_tencent_mm_protocal_c_abg = (abg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_abg.mCB = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_abg.gnp = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_abg.aXz = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_abg.gkC = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_abg.mCC = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
