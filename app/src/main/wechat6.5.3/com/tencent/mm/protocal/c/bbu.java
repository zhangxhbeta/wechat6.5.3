package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class bbu extends a {
    public b mXF;
    public int mdA;
    public int mdz;
    public String mpI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mXF == null) {
                throw new a.a.a.b("Not all required fields were included: EmojiBuffer");
            }
            if (this.mpI != null) {
                aVar.e(1, this.mpI);
            }
            aVar.dV(2, this.mdA);
            aVar.dV(3, this.mdz);
            if (this.mXF == null) {
                return 0;
            }
            aVar.b(4, this.mXF);
            return 0;
        } else if (i == 1) {
            if (this.mpI != null) {
                r0 = a.a.a.b.b.a.f(1, this.mpI) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.mdA)) + a.a.a.a.dS(3, this.mdz);
            if (this.mXF != null) {
                r0 += a.a.a.a.a(4, this.mXF);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mXF != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: EmojiBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bbu com_tencent_mm_protocal_c_bbu = (bbu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bbu.mpI = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bbu.mdA = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bbu.mdz = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bbu.mXF = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
