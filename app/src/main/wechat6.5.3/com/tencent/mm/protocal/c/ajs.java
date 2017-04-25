package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class ajs extends a {
    public String mKq;
    public String mKr;
    public int mKs;
    public int mKt;
    public int mKu;
    public int mKv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mKq != null) {
                aVar.e(1, this.mKq);
            }
            if (this.mKr != null) {
                aVar.e(2, this.mKr);
            }
            aVar.dV(3, this.mKs);
            aVar.dV(4, this.mKt);
            aVar.dV(5, this.mKu);
            aVar.dV(7, this.mKv);
            return 0;
        } else if (i == 1) {
            if (this.mKq != null) {
                r0 = a.a.a.b.b.a.f(1, this.mKq) + 0;
            } else {
                r0 = 0;
            }
            if (this.mKr != null) {
                r0 += a.a.a.b.b.a.f(2, this.mKr);
            }
            return (((r0 + a.a.a.a.dS(3, this.mKs)) + a.a.a.a.dS(4, this.mKt)) + a.a.a.a.dS(5, this.mKu)) + a.a.a.a.dS(7, this.mKv);
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
            ajs com_tencent_mm_protocal_c_ajs = (ajs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_ajs.mKq = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ajs.mKr = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ajs.mKs = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ajs.mKt = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ajs.mKu = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ajs.mKv = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
