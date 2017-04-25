package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class cp extends a {
    public long mcU;
    public int mcV;
    public int mcW;
    public int mcX;
    public int mcY;
    public int mcZ;
    public int mda;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.C(1, this.mcU);
            aVar.dV(2, this.mcV);
            aVar.dV(3, this.mcW);
            aVar.dV(4, this.mcX);
            aVar.dV(5, this.mcY);
            aVar.dV(6, this.mcZ);
            aVar.dV(7, this.mda);
            return 0;
        } else if (i == 1) {
            return ((((((a.a.a.a.B(1, this.mcU) + 0) + a.a.a.a.dS(2, this.mcV)) + a.a.a.a.dS(3, this.mcW)) + a.a.a.a.dS(4, this.mcX)) + a.a.a.a.dS(5, this.mcY)) + a.a.a.a.dS(6, this.mcZ)) + a.a.a.a.dS(7, this.mda);
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
                cp cpVar = (cp) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        cpVar.mcU = aVar3.pMj.mI();
                        return 0;
                    case 2:
                        cpVar.mcV = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        cpVar.mcW = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        cpVar.mcX = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        cpVar.mcY = aVar3.pMj.mH();
                        return 0;
                    case 6:
                        cpVar.mcZ = aVar3.pMj.mH();
                        return 0;
                    case 7:
                        cpVar.mda = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
