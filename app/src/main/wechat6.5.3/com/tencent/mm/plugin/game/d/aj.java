package com.tencent.mm.plugin.game.d;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class aj extends a {
    public String aXz;
    public int efm;
    public String gkC;
    public String gkT;
    public int gkU;
    public String gkV;
    public LinkedList<bw> gmA = new LinkedList();
    public String gmz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.aXz != null) {
                aVar.e(1, this.aXz);
            }
            if (this.gkC != null) {
                aVar.e(2, this.gkC);
            }
            aVar.dV(3, this.efm);
            if (this.gkT != null) {
                aVar.e(4, this.gkT);
            }
            if (this.gmz != null) {
                aVar.e(5, this.gmz);
            }
            aVar.d(6, 8, this.gmA);
            aVar.dV(7, this.gkU);
            if (this.gkV == null) {
                return 0;
            }
            aVar.e(8, this.gkV);
            return 0;
        } else if (i == 1) {
            if (this.aXz != null) {
                r0 = a.a.a.b.b.a.f(1, this.aXz) + 0;
            } else {
                r0 = 0;
            }
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkC);
            }
            r0 += a.a.a.a.dS(3, this.efm);
            if (this.gkT != null) {
                r0 += a.a.a.b.b.a.f(4, this.gkT);
            }
            if (this.gmz != null) {
                r0 += a.a.a.b.b.a.f(5, this.gmz);
            }
            r0 = (r0 + a.a.a.a.c(6, 8, this.gmA)) + a.a.a.a.dS(7, this.gkU);
            if (this.gkV != null) {
                r0 += a.a.a.b.b.a.f(8, this.gkV);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.gmA.clear();
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
            aj ajVar = (aj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ajVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 2:
                    ajVar.gkC = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ajVar.efm = aVar3.pMj.mH();
                    return 0;
                case 4:
                    ajVar.gkT = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ajVar.gmz = aVar3.pMj.readString();
                    return 0;
                case 6:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bw bwVar = new bw();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = bwVar.a(aVar4, bwVar, a.a(aVar4))) {
                        }
                        ajVar.gmA.add(bwVar);
                    }
                    return 0;
                case 7:
                    ajVar.gkU = aVar3.pMj.mH();
                    return 0;
                case 8:
                    ajVar.gkV = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
