package com.tencent.mm.plugin.report.service;

import com.tencent.mm.ba.a;

public final class b extends a {
    public int aRI;
    public int itH;
    public int itI;
    public boolean itJ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.aRI);
            aVar.dV(2, this.itH);
            aVar.dV(3, this.itI);
            aVar.ab(4, this.itJ);
            return 0;
        } else if (i == 1) {
            return (((a.a.a.a.dS(1, this.aRI) + 0) + a.a.a.a.dS(2, this.itH)) + a.a.a.a.dS(3, this.itI)) + (a.a.a.b.b.a.cw(4) + 1);
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
                b bVar = (b) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        bVar.aRI = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        bVar.itH = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        bVar.itI = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        bVar.itJ = aVar3.bQJ();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
