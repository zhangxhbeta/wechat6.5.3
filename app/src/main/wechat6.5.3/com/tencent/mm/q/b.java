package com.tencent.mm.q;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public class b extends a {
    public String bNm;
    public String bnR;
    public String bnS;
    public LinkedList<d> cqE = new LinkedList();
    public int cqF;
    public String name;
    public int type;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.type);
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.bnR != null) {
                aVar.e(3, this.bnR);
            }
            if (this.bnS != null) {
                aVar.e(4, this.bnS);
            }
            if (this.bNm != null) {
                aVar.e(5, this.bNm);
            }
            aVar.d(6, 8, this.cqE);
            aVar.dV(7, this.cqF);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.type) + 0;
            if (this.name != null) {
                r0 += a.a.a.b.b.a.f(2, this.name);
            }
            if (this.bnR != null) {
                r0 += a.a.a.b.b.a.f(3, this.bnR);
            }
            if (this.bnS != null) {
                r0 += a.a.a.b.b.a.f(4, this.bnS);
            }
            if (this.bNm != null) {
                r0 += a.a.a.b.b.a.f(5, this.bNm);
            }
            return (r0 + a.a.a.a.c(6, 8, this.cqE)) + a.a.a.a.dS(7, this.cqF);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.cqE.clear();
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
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar.type = aVar3.pMj.mH();
                    return 0;
                case 2:
                    bVar.name = aVar3.pMj.readString();
                    return 0;
                case 3:
                    bVar.bnR = aVar3.pMj.readString();
                    return 0;
                case 4:
                    bVar.bnS = aVar3.pMj.readString();
                    return 0;
                case 5:
                    bVar.bNm = aVar3.pMj.readString();
                    return 0;
                case 6:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a dVar = new d();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        bVar.cqE.add(dVar);
                    }
                    return 0;
                case 7:
                    bVar.cqF = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
