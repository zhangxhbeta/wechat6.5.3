package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class bii extends a {
    public int maG;
    public b mdy;
    public long ncU;
    public String ncy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ncy == null) {
                throw new a.a.a.b("Not all required fields were included: Talker");
            } else if (this.mdy == null) {
                throw new a.a.a.b("Not all required fields were included: VoiceData");
            } else {
                if (this.ncy != null) {
                    aVar.e(1, this.ncy);
                }
                aVar.C(2, this.ncU);
                if (this.mdy != null) {
                    aVar.b(3, this.mdy);
                }
                aVar.dV(4, this.maG);
                return 0;
            }
        } else if (i == 1) {
            if (this.ncy != null) {
                r0 = a.a.a.b.b.a.f(1, this.ncy) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.B(2, this.ncU);
            if (this.mdy != null) {
                r0 += a.a.a.a.a(3, this.mdy);
            }
            return r0 + a.a.a.a.dS(4, this.maG);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.ncy == null) {
                throw new a.a.a.b("Not all required fields were included: Talker");
            } else if (this.mdy != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: VoiceData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bii com_tencent_mm_protocal_c_bii = (bii) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bii.ncy = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bii.ncU = aVar3.pMj.mI();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bii.mdy = aVar3.bQK();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bii.maG = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
