package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class ana extends a {
    public double mNp;
    public double mhY;
    public double mhZ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.a(1, this.mhZ);
            aVar.a(2, this.mhY);
            aVar.a(3, this.mNp);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.b.b.a.cw(1) + 8) + 0) + (a.a.a.b.b.a.cw(2) + 8)) + (a.a.a.b.b.a.cw(3) + 8);
        } else {
            if (i == 2) {
                a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.bQL();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
                ana com_tencent_mm_protocal_c_ana = (ana) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_ana.mhZ = aVar3.pMj.readDouble();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_ana.mhY = aVar3.pMj.readDouble();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_ana.mNp = aVar3.pMj.readDouble();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
