package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class bin extends a {
    public b mdy;
    public int mff;
    public String ncy;
    public boolean ndb;
    public boolean ndc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ncy == null) {
                throw new a.a.a.b("Not all required fields were included: Talker");
            }
            if (this.ncy != null) {
                aVar.e(1, this.ncy);
            }
            aVar.dV(2, this.mff);
            if (this.mdy != null) {
                aVar.b(3, this.mdy);
            }
            aVar.ab(4, this.ndb);
            aVar.ab(5, this.ndc);
            return 0;
        } else if (i == 1) {
            if (this.ncy != null) {
                r0 = a.a.a.b.b.a.f(1, this.ncy) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mff);
            if (this.mdy != null) {
                r0 += a.a.a.a.a(3, this.mdy);
            }
            return (r0 + (a.a.a.b.b.a.cw(4) + 1)) + (a.a.a.b.b.a.cw(5) + 1);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.ncy != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: Talker");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bin com_tencent_mm_protocal_c_bin = (bin) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bin.ncy = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bin.mff = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bin.mdy = aVar3.bQK();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bin.ndb = aVar3.bQJ();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bin.ndc = aVar3.bQJ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
