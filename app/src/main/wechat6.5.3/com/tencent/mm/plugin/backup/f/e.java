package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class e extends a {
    public LinkedList<g> ehA = new LinkedList();
    public LinkedList<String> ehB = new LinkedList();
    public String ehC;
    public int ehD;
    public int ehE;
    public int ehF;
    public int ehG;
    public long ehH;
    public int eha;
    public int eho;
    public String ehp;
    public int ehq;
    public int ehv;
    public LinkedList<d> ehz = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.eho);
            if (this.ehp != null) {
                aVar.e(2, this.ehp);
            }
            aVar.dV(3, this.ehq);
            aVar.d(4, 8, this.ehz);
            aVar.d(5, 8, this.ehA);
            aVar.d(6, 1, this.ehB);
            if (this.ehC != null) {
                aVar.e(7, this.ehC);
            }
            aVar.dV(8, this.ehD);
            aVar.dV(9, this.ehE);
            aVar.dV(10, this.eha);
            aVar.dV(11, this.ehv);
            aVar.dV(12, this.ehF);
            aVar.dV(13, this.ehG);
            aVar.C(14, this.ehH);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.eho) + 0;
            if (this.ehp != null) {
                r0 += a.a.a.b.b.a.f(2, this.ehp);
            }
            r0 = (((r0 + a.a.a.a.dS(3, this.ehq)) + a.a.a.a.c(4, 8, this.ehz)) + a.a.a.a.c(5, 8, this.ehA)) + a.a.a.a.c(6, 1, this.ehB);
            if (this.ehC != null) {
                r0 += a.a.a.b.b.a.f(7, this.ehC);
            }
            return ((((((r0 + a.a.a.a.dS(8, this.ehD)) + a.a.a.a.dS(9, this.ehE)) + a.a.a.a.dS(10, this.eha)) + a.a.a.a.dS(11, this.ehv)) + a.a.a.a.dS(12, this.ehF)) + a.a.a.a.dS(13, this.ehG)) + a.a.a.a.B(14, this.ehH);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ehz.clear();
            this.ehA.clear();
            this.ehB.clear();
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
            a dVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    eVar.eho = aVar3.pMj.mH();
                    return 0;
                case 2:
                    eVar.ehp = aVar3.pMj.readString();
                    return 0;
                case 3:
                    eVar.ehq = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        dVar = new d();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        eVar.ehz.add(dVar);
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        dVar = new g();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        eVar.ehA.add(dVar);
                    }
                    return 0;
                case 6:
                    eVar.ehB.add(aVar3.pMj.readString());
                    return 0;
                case 7:
                    eVar.ehC = aVar3.pMj.readString();
                    return 0;
                case 8:
                    eVar.ehD = aVar3.pMj.mH();
                    return 0;
                case 9:
                    eVar.ehE = aVar3.pMj.mH();
                    return 0;
                case 10:
                    eVar.eha = aVar3.pMj.mH();
                    return 0;
                case 11:
                    eVar.ehv = aVar3.pMj.mH();
                    return 0;
                case 12:
                    eVar.ehF = aVar3.pMj.mH();
                    return 0;
                case 13:
                    eVar.ehG = aVar3.pMj.mH();
                    return 0;
                case 14:
                    eVar.ehH = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
