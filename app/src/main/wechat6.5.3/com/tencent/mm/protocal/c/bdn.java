package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bdn extends a {
    public String itR;
    public String mQn;
    public String mZs;
    public int mZt;
    public String mZu;
    public String mZv;
    public String mvR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.itR != null) {
                aVar.e(1, this.itR);
            }
            if (this.mZs != null) {
                aVar.e(2, this.mZs);
            }
            if (this.mvR != null) {
                aVar.e(3, this.mvR);
            }
            aVar.dV(4, this.mZt);
            if (this.mQn != null) {
                aVar.e(5, this.mQn);
            }
            if (this.mZu != null) {
                aVar.e(6, this.mZu);
            }
            if (this.mZv == null) {
                return 0;
            }
            aVar.e(7, this.mZv);
            return 0;
        } else if (i == 1) {
            if (this.itR != null) {
                r0 = a.a.a.b.b.a.f(1, this.itR) + 0;
            } else {
                r0 = 0;
            }
            if (this.mZs != null) {
                r0 += a.a.a.b.b.a.f(2, this.mZs);
            }
            if (this.mvR != null) {
                r0 += a.a.a.b.b.a.f(3, this.mvR);
            }
            r0 += a.a.a.a.dS(4, this.mZt);
            if (this.mQn != null) {
                r0 += a.a.a.b.b.a.f(5, this.mQn);
            }
            if (this.mZu != null) {
                r0 += a.a.a.b.b.a.f(6, this.mZu);
            }
            if (this.mZv != null) {
                r0 += a.a.a.b.b.a.f(7, this.mZv);
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
            bdn com_tencent_mm_protocal_c_bdn = (bdn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bdn.itR = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bdn.mZs = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bdn.mvR = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bdn.mZt = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bdn.mQn = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bdn.mZu = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bdn.mZv = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
