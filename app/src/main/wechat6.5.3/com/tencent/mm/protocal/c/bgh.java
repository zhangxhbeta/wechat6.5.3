package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bgh extends a {
    public String gon;
    public String mNw;
    public String muL;
    public String nbR;
    public String nbS;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mNw != null) {
                aVar.e(1, this.mNw);
            }
            if (this.nbR != null) {
                aVar.e(2, this.nbR);
            }
            if (this.gon != null) {
                aVar.e(3, this.gon);
            }
            if (this.muL != null) {
                aVar.e(4, this.muL);
            }
            if (this.nbS == null) {
                return 0;
            }
            aVar.e(5, this.nbS);
            return 0;
        } else if (i == 1) {
            if (this.mNw != null) {
                r0 = a.a.a.b.b.a.f(1, this.mNw) + 0;
            } else {
                r0 = 0;
            }
            if (this.nbR != null) {
                r0 += a.a.a.b.b.a.f(2, this.nbR);
            }
            if (this.gon != null) {
                r0 += a.a.a.b.b.a.f(3, this.gon);
            }
            if (this.muL != null) {
                r0 += a.a.a.b.b.a.f(4, this.muL);
            }
            if (this.nbS != null) {
                r0 += a.a.a.b.b.a.f(5, this.nbS);
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
            bgh com_tencent_mm_protocal_c_bgh = (bgh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bgh.mNw = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bgh.nbR = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bgh.gon = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bgh.muL = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bgh.nbS = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
