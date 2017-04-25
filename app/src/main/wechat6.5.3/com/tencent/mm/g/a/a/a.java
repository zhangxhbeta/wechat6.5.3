package com.tencent.mm.g.a.a;

import java.util.LinkedList;

public final class a extends com.tencent.mm.ba.a {
    public int biE;
    public int bkU;
    public LinkedList<b> caF = new LinkedList();
    public int caG;
    public String caH;
    public int caI;
    public int status;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.caF);
            aVar.dV(2, this.bkU);
            aVar.dV(3, this.type);
            aVar.dV(4, this.status);
            aVar.dV(5, this.caG);
            if (this.caH != null) {
                aVar.e(6, this.caH);
            }
            aVar.dV(7, this.biE);
            aVar.dV(8, this.caI);
            return 0;
        } else if (i == 1) {
            r0 = ((((a.a.a.a.c(1, 8, this.caF) + 0) + a.a.a.a.dS(2, this.bkU)) + a.a.a.a.dS(3, this.type)) + a.a.a.a.dS(4, this.status)) + a.a.a.a.dS(5, this.caG);
            if (this.caH != null) {
                r0 += a.a.a.b.b.a.f(6, this.caH);
            }
            return (r0 + a.a.a.a.dS(7, this.biE)) + a.a.a.a.dS(8, this.caI);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.caF.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a bVar = new b();
                        a.a.a.a.a aVar5 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = bVar.a(aVar5, bVar, com.tencent.mm.ba.a.a(aVar5))) {
                        }
                        aVar4.caF.add(bVar);
                    }
                    return 0;
                case 2:
                    aVar4.bkU = aVar3.pMj.mH();
                    return 0;
                case 3:
                    aVar4.type = aVar3.pMj.mH();
                    return 0;
                case 4:
                    aVar4.status = aVar3.pMj.mH();
                    return 0;
                case 5:
                    aVar4.caG = aVar3.pMj.mH();
                    return 0;
                case 6:
                    aVar4.caH = aVar3.pMj.readString();
                    return 0;
                case 7:
                    aVar4.biE = aVar3.pMj.mH();
                    return 0;
                case 8:
                    aVar4.caI = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
