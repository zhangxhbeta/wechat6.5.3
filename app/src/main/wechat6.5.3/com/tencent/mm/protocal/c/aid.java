package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class aid extends a {
    public float lHK;
    public float mID;
    public float mIE;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.j(1, this.mID);
            aVar.j(2, this.lHK);
            aVar.j(3, this.mIE);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.b.b.a.cw(1) + 4) + 0) + (a.a.a.b.b.a.cw(2) + 4)) + (a.a.a.b.b.a.cw(3) + 4);
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
                aid com_tencent_mm_protocal_c_aid = (aid) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_aid.mID = aVar3.pMj.readFloat();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_aid.lHK = aVar3.pMj.readFloat();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_aid.mIE = aVar3.pMj.readFloat();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
