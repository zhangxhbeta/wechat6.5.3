package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class azu extends a {
    public String gkB;
    public String mMa;
    public double mhY;
    public double mhZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.a(1, this.mhZ);
            aVar.a(2, this.mhY);
            if (this.gkB != null) {
                aVar.e(3, this.gkB);
            }
            if (this.mMa != null) {
                aVar.e(4, this.mMa);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.b.b.a.cw(1) + 8) + 0) + (a.a.a.b.b.a.cw(2) + 8);
            if (this.gkB != null) {
                r0 += a.a.a.b.b.a.f(3, this.gkB);
            }
            if (this.mMa != null) {
                return r0 + a.a.a.b.b.a.f(4, this.mMa);
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
            azu com_tencent_mm_protocal_c_azu = (azu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_azu.mhZ = aVar3.pMj.readDouble();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_azu.mhY = aVar3.pMj.readDouble();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_azu.gkB = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_azu.mMa = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
