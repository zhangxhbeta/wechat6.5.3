package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class awr extends a {
    public float aJp;
    public int jGV;
    public float mUa;
    public float mUb;
    public float mUc;
    public float mUd;
    public int mUe;
    public long mUf;
    public long mUg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.j(1, this.mUa);
            aVar.j(2, this.mUb);
            aVar.j(3, this.mUc);
            aVar.j(4, this.mUd);
            aVar.dV(5, this.mUe);
            aVar.C(6, this.mUf);
            aVar.C(7, this.mUg);
            aVar.j(8, this.aJp);
            aVar.dV(9, this.jGV);
            return 0;
        } else if (i == 1) {
            return (((((((((a.a.a.b.b.a.cw(1) + 4) + 0) + (a.a.a.b.b.a.cw(2) + 4)) + (a.a.a.b.b.a.cw(3) + 4)) + (a.a.a.b.b.a.cw(4) + 4)) + a.a.a.a.dS(5, this.mUe)) + a.a.a.a.B(6, this.mUf)) + a.a.a.a.B(7, this.mUg)) + (a.a.a.b.b.a.cw(8) + 4)) + a.a.a.a.dS(9, this.jGV);
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
                awr com_tencent_mm_protocal_c_awr = (awr) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        com_tencent_mm_protocal_c_awr.mUa = aVar3.pMj.readFloat();
                        return 0;
                    case 2:
                        com_tencent_mm_protocal_c_awr.mUb = aVar3.pMj.readFloat();
                        return 0;
                    case 3:
                        com_tencent_mm_protocal_c_awr.mUc = aVar3.pMj.readFloat();
                        return 0;
                    case 4:
                        com_tencent_mm_protocal_c_awr.mUd = aVar3.pMj.readFloat();
                        return 0;
                    case 5:
                        com_tencent_mm_protocal_c_awr.mUe = aVar3.pMj.mH();
                        return 0;
                    case 6:
                        com_tencent_mm_protocal_c_awr.mUf = aVar3.pMj.mI();
                        return 0;
                    case 7:
                        com_tencent_mm_protocal_c_awr.mUg = aVar3.pMj.mI();
                        return 0;
                    case 8:
                        com_tencent_mm_protocal_c_awr.aJp = aVar3.pMj.readFloat();
                        return 0;
                    case 9:
                        com_tencent_mm_protocal_c_awr.jGV = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
