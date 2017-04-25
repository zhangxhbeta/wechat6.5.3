package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;

public final class bhw extends a {
    public String aXz;
    public int gof;
    public String hQP;
    public int ncK;
    public boolean ncL;
    public boolean ncM;
    public boolean ncN;
    public b ncq;
    public String ncy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ncy == null) {
                throw new a.a.a.b("Not all required fields were included: Talker");
            } else if (this.aXz == null) {
                throw new a.a.a.b("Not all required fields were included: Title");
            } else if (this.hQP == null) {
                throw new a.a.a.b("Not all required fields were included: Content");
            } else {
                aVar.dV(1, this.gof);
                if (this.ncy != null) {
                    aVar.e(2, this.ncy);
                }
                if (this.aXz != null) {
                    aVar.e(3, this.aXz);
                }
                if (this.hQP != null) {
                    aVar.e(4, this.hQP);
                }
                aVar.dV(5, this.ncK);
                if (this.ncq != null) {
                    aVar.b(6, this.ncq);
                }
                aVar.ab(7, this.ncL);
                aVar.ab(8, this.ncM);
                aVar.ab(9, this.ncN);
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.gof) + 0;
            if (this.ncy != null) {
                r0 += a.a.a.b.b.a.f(2, this.ncy);
            }
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(3, this.aXz);
            }
            if (this.hQP != null) {
                r0 += a.a.a.b.b.a.f(4, this.hQP);
            }
            r0 += a.a.a.a.dS(5, this.ncK);
            if (this.ncq != null) {
                r0 += a.a.a.a.a(6, this.ncq);
            }
            return ((r0 + (a.a.a.b.b.a.cw(7) + 1)) + (a.a.a.b.b.a.cw(8) + 1)) + (a.a.a.b.b.a.cw(9) + 1);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.ncy == null) {
                throw new a.a.a.b("Not all required fields were included: Talker");
            } else if (this.aXz == null) {
                throw new a.a.a.b("Not all required fields were included: Title");
            } else if (this.hQP != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: Content");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bhw com_tencent_mm_protocal_c_bhw = (bhw) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_bhw.gof = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bhw.ncy = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bhw.aXz = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bhw.hQP = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bhw.ncK = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bhw.ncq = aVar3.bQK();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bhw.ncL = aVar3.bQJ();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bhw.ncM = aVar3.bQJ();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bhw.ncN = aVar3.bQJ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
