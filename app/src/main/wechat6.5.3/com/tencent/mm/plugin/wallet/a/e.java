package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class e extends a {
    public double kHA;
    public LinkedList<l> kHC = new LinkedList();
    public double kHH;
    public double kHI;
    public int kHJ;
    public String kHK;
    public String kHL;
    public b kHN;
    public String kHO;
    public double kHP;
    public LinkedList<b> kHQ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.kHO != null) {
                aVar.e(1, this.kHO);
            }
            aVar.a(2, this.kHP);
            aVar.a(3, this.kHA);
            aVar.d(4, 8, this.kHQ);
            aVar.d(5, 8, this.kHC);
            aVar.a(6, this.kHH);
            aVar.a(7, this.kHI);
            aVar.dV(8, this.kHJ);
            if (this.kHK != null) {
                aVar.e(9, this.kHK);
            }
            if (this.kHL != null) {
                aVar.e(10, this.kHL);
            }
            if (this.kHN == null) {
                return 0;
            }
            aVar.b(11, this.kHN);
            return 0;
        } else if (i == 1) {
            if (this.kHO != null) {
                r0 = a.a.a.b.b.a.f(1, this.kHO) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((((r0 + (a.a.a.b.b.a.cw(2) + 8)) + (a.a.a.b.b.a.cw(3) + 8)) + a.a.a.a.c(4, 8, this.kHQ)) + a.a.a.a.c(5, 8, this.kHC)) + (a.a.a.b.b.a.cw(6) + 8)) + (a.a.a.b.b.a.cw(7) + 8)) + a.a.a.a.dS(8, this.kHJ);
            if (this.kHK != null) {
                r0 += a.a.a.b.b.a.f(9, this.kHK);
            }
            if (this.kHL != null) {
                r0 += a.a.a.b.b.a.f(10, this.kHL);
            }
            if (this.kHN != null) {
                r0 += a.a.a.a.a(11, this.kHN);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.kHQ.clear();
            this.kHC.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    eVar.kHO = aVar3.pMj.readString();
                    return 0;
                case 2:
                    eVar.kHP = aVar3.pMj.readDouble();
                    return 0;
                case 3:
                    eVar.kHA = aVar3.pMj.readDouble();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        b bVar = new b();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        eVar.kHQ.add(bVar);
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        l lVar = new l();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lVar.a(aVar4, lVar, a.a(aVar4))) {
                        }
                        eVar.kHC.add(lVar);
                    }
                    return 0;
                case 6:
                    eVar.kHH = aVar3.pMj.readDouble();
                    return 0;
                case 7:
                    eVar.kHI = aVar3.pMj.readDouble();
                    return 0;
                case 8:
                    eVar.kHJ = aVar3.pMj.mH();
                    return 0;
                case 9:
                    eVar.kHK = aVar3.pMj.readString();
                    return 0;
                case 10:
                    eVar.kHL = aVar3.pMj.readString();
                    return 0;
                case 11:
                    eVar.kHN = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
