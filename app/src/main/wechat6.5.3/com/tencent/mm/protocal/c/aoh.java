package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class aoh extends a {
    public int mAf;
    public int mOw;
    public String mpI;
    public int mqV;
    public String muK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mAf);
            if (this.muK != null) {
                aVar.e(2, this.muK);
            }
            if (this.mpI != null) {
                aVar.e(3, this.mpI);
            }
            aVar.dV(4, this.mqV);
            aVar.dV(5, this.mOw);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mAf) + 0;
            if (this.muK != null) {
                r0 += a.a.a.b.b.a.f(2, this.muK);
            }
            if (this.mpI != null) {
                r0 += a.a.a.b.b.a.f(3, this.mpI);
            }
            return (r0 + a.a.a.a.dS(4, this.mqV)) + a.a.a.a.dS(5, this.mOw);
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
            aoh com_tencent_mm_protocal_c_aoh = (aoh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_aoh.mAf = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aoh.muK = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aoh.mpI = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aoh.mqV = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aoh.mOw = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
