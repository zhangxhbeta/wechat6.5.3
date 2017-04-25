package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class akg extends a {
    public int fvo;
    public int jel;
    public int jem;
    public b jen;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.fvo);
            aVar.dV(2, this.jel);
            aVar.dV(3, this.jem);
            if (this.jen != null) {
                aVar.b(4, this.jen);
            }
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.dS(1, this.fvo) + 0) + a.a.a.a.dS(2, this.jel)) + a.a.a.a.dS(3, this.jem);
            if (this.jen != null) {
                return r0 + a.a.a.a.a(4, this.jen);
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
            akg com_tencent_mm_protocal_c_akg = (akg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_akg.fvo = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akg.jel = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akg.jem = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akg.jen = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
