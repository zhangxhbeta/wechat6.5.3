package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bdb extends a {
    public String eeA;
    public String gnp;
    public String hNZ;
    public String mCN;
    public String mMr;
    public long mZc;
    public String meq;
    public String mnR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mnR != null) {
                aVar.e(1, this.mnR);
            }
            if (this.meq != null) {
                aVar.e(2, this.meq);
            }
            if (this.mMr != null) {
                aVar.e(3, this.mMr);
            }
            if (this.hNZ != null) {
                aVar.e(4, this.hNZ);
            }
            if (this.eeA != null) {
                aVar.e(5, this.eeA);
            }
            if (this.gnp != null) {
                aVar.e(6, this.gnp);
            }
            if (this.mCN != null) {
                aVar.e(7, this.mCN);
            }
            aVar.C(8, this.mZc);
            return 0;
        } else if (i == 1) {
            if (this.mnR != null) {
                r0 = a.a.a.b.b.a.f(1, this.mnR) + 0;
            } else {
                r0 = 0;
            }
            if (this.meq != null) {
                r0 += a.a.a.b.b.a.f(2, this.meq);
            }
            if (this.mMr != null) {
                r0 += a.a.a.b.b.a.f(3, this.mMr);
            }
            if (this.hNZ != null) {
                r0 += a.a.a.b.b.a.f(4, this.hNZ);
            }
            if (this.eeA != null) {
                r0 += a.a.a.b.b.a.f(5, this.eeA);
            }
            if (this.gnp != null) {
                r0 += a.a.a.b.b.a.f(6, this.gnp);
            }
            if (this.mCN != null) {
                r0 += a.a.a.b.b.a.f(7, this.mCN);
            }
            return r0 + a.a.a.a.B(8, this.mZc);
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
            bdb com_tencent_mm_protocal_c_bdb = (bdb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bdb.mnR = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bdb.meq = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bdb.mMr = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bdb.hNZ = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bdb.eeA = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bdb.gnp = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bdb.mCN = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bdb.mZc = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
