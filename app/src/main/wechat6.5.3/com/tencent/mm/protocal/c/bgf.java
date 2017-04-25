package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bgf extends a {
    public String aXz;
    public String mNw;
    public String mdM;
    public int nbM;
    public String nbN;
    public String nbO;
    public String nbP;
    public String nbQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.aXz != null) {
                aVar.e(1, this.aXz);
            }
            if (this.mdM != null) {
                aVar.e(2, this.mdM);
            }
            aVar.dV(3, this.nbM);
            if (this.nbN != null) {
                aVar.e(4, this.nbN);
            }
            if (this.mNw != null) {
                aVar.e(5, this.mNw);
            }
            if (this.nbO != null) {
                aVar.e(6, this.nbO);
            }
            if (this.nbP != null) {
                aVar.e(7, this.nbP);
            }
            if (this.nbQ == null) {
                return 0;
            }
            aVar.e(8, this.nbQ);
            return 0;
        } else if (i == 1) {
            if (this.aXz != null) {
                r0 = a.a.a.b.b.a.f(1, this.aXz) + 0;
            } else {
                r0 = 0;
            }
            if (this.mdM != null) {
                r0 += a.a.a.b.b.a.f(2, this.mdM);
            }
            r0 += a.a.a.a.dS(3, this.nbM);
            if (this.nbN != null) {
                r0 += a.a.a.b.b.a.f(4, this.nbN);
            }
            if (this.mNw != null) {
                r0 += a.a.a.b.b.a.f(5, this.mNw);
            }
            if (this.nbO != null) {
                r0 += a.a.a.b.b.a.f(6, this.nbO);
            }
            if (this.nbP != null) {
                r0 += a.a.a.b.b.a.f(7, this.nbP);
            }
            if (this.nbQ != null) {
                r0 += a.a.a.b.b.a.f(8, this.nbQ);
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
            bgf com_tencent_mm_protocal_c_bgf = (bgf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bgf.aXz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bgf.mdM = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bgf.nbM = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bgf.nbN = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bgf.mNw = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bgf.nbO = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bgf.nbP = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bgf.nbQ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
