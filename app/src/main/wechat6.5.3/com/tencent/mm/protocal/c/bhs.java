package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class bhs extends a {
    public int gll;
    public String hQP;
    public String mGq;
    public long ncE;
    public boolean ncF;
    public b ncG;
    public String ncy;
    public long ncz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mGq == null) {
                throw new a.a.a.b("Not all required fields were included: Nickname");
            } else if (this.hQP == null) {
                throw new a.a.a.b("Not all required fields were included: Content");
            } else if (this.ncy == null) {
                throw new a.a.a.b("Not all required fields were included: Talker");
            } else {
                aVar.C(1, this.ncz);
                if (this.mGq != null) {
                    aVar.e(2, this.mGq);
                }
                if (this.hQP != null) {
                    aVar.e(3, this.hQP);
                }
                aVar.dV(4, this.gll);
                if (this.ncy != null) {
                    aVar.e(5, this.ncy);
                }
                aVar.C(6, this.ncE);
                aVar.ab(7, this.ncF);
                if (this.ncG != null) {
                    aVar.b(8, this.ncG);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.B(1, this.ncz) + 0;
            if (this.mGq != null) {
                r0 += a.a.a.b.b.a.f(2, this.mGq);
            }
            if (this.hQP != null) {
                r0 += a.a.a.b.b.a.f(3, this.hQP);
            }
            r0 += a.a.a.a.dS(4, this.gll);
            if (this.ncy != null) {
                r0 += a.a.a.b.b.a.f(5, this.ncy);
            }
            r0 = (r0 + a.a.a.a.B(6, this.ncE)) + (a.a.a.b.b.a.cw(7) + 1);
            if (this.ncG != null) {
                return r0 + a.a.a.a.a(8, this.ncG);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mGq == null) {
                throw new a.a.a.b("Not all required fields were included: Nickname");
            } else if (this.hQP == null) {
                throw new a.a.a.b("Not all required fields were included: Content");
            } else if (this.ncy != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: Talker");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bhs com_tencent_mm_protocal_c_bhs = (bhs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bhs.ncz = aVar3.pMj.mI();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bhs.mGq = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bhs.hQP = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bhs.gll = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bhs.ncy = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bhs.ncE = aVar3.pMj.mI();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bhs.ncF = aVar3.bQJ();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bhs.ncG = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
