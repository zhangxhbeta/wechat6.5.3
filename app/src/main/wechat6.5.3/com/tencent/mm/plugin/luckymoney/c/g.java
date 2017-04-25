package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class g extends a {
    public int cWd;
    public int haL;
    public LinkedList<h> haY = new LinkedList();
    public int hbc;
    public long hbd;
    public int hbe;
    public long hbf;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.hbc);
            aVar.C(2, this.hbd);
            aVar.dV(3, this.hbe);
            aVar.C(4, this.hbf);
            aVar.dV(5, this.cWd);
            aVar.dV(6, this.haL);
            aVar.d(7, 8, this.haY);
            return 0;
        } else if (i == 1) {
            return ((((((a.a.a.a.dS(1, this.hbc) + 0) + a.a.a.a.B(2, this.hbd)) + a.a.a.a.dS(3, this.hbe)) + a.a.a.a.B(4, this.hbf)) + a.a.a.a.dS(5, this.cWd)) + a.a.a.a.dS(6, this.haL)) + a.a.a.a.c(7, 8, this.haY);
        } else {
            byte[] bArr;
            if (i == 2) {
                bArr = (byte[]) objArr[0];
                this.haY.clear();
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
                g gVar = (g) objArr[1];
                int intValue = ((Integer) objArr[2]).intValue();
                switch (intValue) {
                    case 1:
                        gVar.hbc = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        gVar.hbd = aVar3.pMj.mI();
                        return 0;
                    case 3:
                        gVar.hbe = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        gVar.hbf = aVar3.pMj.mI();
                        return 0;
                    case 5:
                        gVar.cWd = aVar3.pMj.mH();
                        return 0;
                    case 6:
                        gVar.haL = aVar3.pMj.mH();
                        return 0;
                    case 7:
                        LinkedList zQ = aVar3.zQ(intValue);
                        int size = zQ.size();
                        for (intValue = 0; intValue < size; intValue++) {
                            bArr = (byte[]) zQ.get(intValue);
                            h hVar = new h();
                            a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                            for (boolean z = true; z; z = hVar.a(aVar4, hVar, a.a(aVar4))) {
                            }
                            gVar.haY.add(hVar);
                        }
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
