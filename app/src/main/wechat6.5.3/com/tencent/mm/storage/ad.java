package com.tencent.mm.storage;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ad extends a {
    public int nuQ;
    public LinkedList<Integer> nuR = new LinkedList();
    public LinkedList<Integer> nuS = new LinkedList();
    public LinkedList<Integer> nuT = new LinkedList();
    public LinkedList<Long> nuU = new LinkedList();
    public LinkedList<Long> nuV = new LinkedList();
    public LinkedList<Long> nuW = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.nuQ);
            aVar.d(2, 2, this.nuR);
            aVar.d(3, 2, this.nuS);
            aVar.d(4, 2, this.nuT);
            aVar.d(5, 3, this.nuU);
            aVar.d(6, 3, this.nuV);
            aVar.d(7, 3, this.nuW);
            return 0;
        } else if (i == 1) {
            return ((((((a.a.a.a.dS(1, this.nuQ) + 0) + a.a.a.a.c(2, 2, this.nuR)) + a.a.a.a.c(3, 2, this.nuS)) + a.a.a.a.c(4, 2, this.nuT)) + a.a.a.a.c(5, 3, this.nuU)) + a.a.a.a.c(6, 3, this.nuV)) + a.a.a.a.c(7, 3, this.nuW);
        } else {
            if (i == 2) {
                byte[] bArr = (byte[]) objArr[0];
                this.nuR.clear();
                this.nuS.clear();
                this.nuT.clear();
                this.nuU.clear();
                this.nuV.clear();
                this.nuW.clear();
                a.a.a.a.a aVar2 = new a.a.a.a.a(bArr, unknownTagHandler);
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
                ad adVar = (ad) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        adVar.nuQ = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        adVar.nuR.add(Integer.valueOf(aVar3.pMj.mH()));
                        return 0;
                    case 3:
                        adVar.nuS.add(Integer.valueOf(aVar3.pMj.mH()));
                        return 0;
                    case 4:
                        adVar.nuT.add(Integer.valueOf(aVar3.pMj.mH()));
                        return 0;
                    case 5:
                        adVar.nuU.add(Long.valueOf(aVar3.pMj.mI()));
                        return 0;
                    case 6:
                        adVar.nuV.add(Long.valueOf(aVar3.pMj.mI()));
                        return 0;
                    case 7:
                        adVar.nuW.add(Long.valueOf(aVar3.pMj.mI()));
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
