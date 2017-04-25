package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class bgt extends a {
    public String hOq;
    public String mPN;
    public String mzu;
    public String ncd;
    public String nce;
    public int ncf;
    public String ncg;
    public String nch;
    public String nci;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ncd != null) {
                aVar.e(1, this.ncd);
            }
            if (this.nce != null) {
                aVar.e(2, this.nce);
            }
            if (this.mzu != null) {
                aVar.e(3, this.mzu);
            }
            if (this.mPN != null) {
                aVar.e(4, this.mPN);
            }
            aVar.dV(5, this.ncf);
            if (this.hOq != null) {
                aVar.e(6, this.hOq);
            }
            if (this.ncg != null) {
                aVar.e(7, this.ncg);
            }
            if (this.nch != null) {
                aVar.e(8, this.nch);
            }
            if (this.nci == null) {
                return 0;
            }
            aVar.e(19, this.nci);
            return 0;
        } else if (i == 1) {
            if (this.ncd != null) {
                r0 = a.a.a.b.b.a.f(1, this.ncd) + 0;
            } else {
                r0 = 0;
            }
            if (this.nce != null) {
                r0 += a.a.a.b.b.a.f(2, this.nce);
            }
            if (this.mzu != null) {
                r0 += a.a.a.b.b.a.f(3, this.mzu);
            }
            if (this.mPN != null) {
                r0 += a.a.a.b.b.a.f(4, this.mPN);
            }
            r0 += a.a.a.a.dS(5, this.ncf);
            if (this.hOq != null) {
                r0 += a.a.a.b.b.a.f(6, this.hOq);
            }
            if (this.ncg != null) {
                r0 += a.a.a.b.b.a.f(7, this.ncg);
            }
            if (this.nch != null) {
                r0 += a.a.a.b.b.a.f(8, this.nch);
            }
            if (this.nci != null) {
                r0 += a.a.a.b.b.a.f(19, this.nci);
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
            bgt com_tencent_mm_protocal_c_bgt = (bgt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bgt.ncd = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bgt.nce = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bgt.mzu = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bgt.mPN = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bgt.ncf = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bgt.hOq = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bgt.ncg = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bgt.nch = aVar3.pMj.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bgt.nci = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
