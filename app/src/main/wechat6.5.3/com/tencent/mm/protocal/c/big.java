package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;

public final class big extends a {
    public int maG;
    public String mjc;
    public String mpI;
    public String mzO;
    public String ncy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ncy == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.mzO == null) {
                throw new b("Not all required fields were included: Text");
            } else if (this.mpI == null) {
                throw new b("Not all required fields were included: MD5");
            } else if (this.mjc == null) {
                throw new b("Not all required fields were included: ProductId");
            } else {
                if (this.ncy != null) {
                    aVar.e(1, this.ncy);
                }
                if (this.mzO != null) {
                    aVar.e(2, this.mzO);
                }
                if (this.mpI != null) {
                    aVar.e(3, this.mpI);
                }
                if (this.mjc != null) {
                    aVar.e(4, this.mjc);
                }
                aVar.dV(5, this.maG);
                return 0;
            }
        } else if (i == 1) {
            if (this.ncy != null) {
                r0 = a.a.a.b.b.a.f(1, this.ncy) + 0;
            } else {
                r0 = 0;
            }
            if (this.mzO != null) {
                r0 += a.a.a.b.b.a.f(2, this.mzO);
            }
            if (this.mpI != null) {
                r0 += a.a.a.b.b.a.f(3, this.mpI);
            }
            if (this.mjc != null) {
                r0 += a.a.a.b.b.a.f(4, this.mjc);
            }
            return r0 + a.a.a.a.dS(5, this.maG);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.ncy == null) {
                throw new b("Not all required fields were included: Talker");
            } else if (this.mzO == null) {
                throw new b("Not all required fields were included: Text");
            } else if (this.mpI == null) {
                throw new b("Not all required fields were included: MD5");
            } else if (this.mjc != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ProductId");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            big com_tencent_mm_protocal_c_big = (big) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_big.ncy = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_big.mzO = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_big.mpI = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_big.mjc = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_big.maG = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
