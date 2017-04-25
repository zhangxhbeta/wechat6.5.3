package com.tencent.mm.plugin.address.c;

import com.tencent.mm.ba.a;

public final class b extends a {
    public String dxC;
    public String dxD;
    public String dxE;
    public String dxF;
    public String dxG;
    public String dxH;
    public String dxI;
    public String dxJ;
    public String dxK;
    public int id;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.id);
            if (this.dxC != null) {
                aVar.e(2, this.dxC);
            }
            if (this.dxD != null) {
                aVar.e(3, this.dxD);
            }
            if (this.dxE != null) {
                aVar.e(4, this.dxE);
            }
            if (this.dxF != null) {
                aVar.e(5, this.dxF);
            }
            if (this.dxG != null) {
                aVar.e(6, this.dxG);
            }
            if (this.dxH != null) {
                aVar.e(7, this.dxH);
            }
            if (this.dxI != null) {
                aVar.e(8, this.dxI);
            }
            if (this.dxJ != null) {
                aVar.e(9, this.dxJ);
            }
            if (this.dxK != null) {
                aVar.e(10, this.dxK);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.id) + 0;
            if (this.dxC != null) {
                r0 += a.a.a.b.b.a.f(2, this.dxC);
            }
            if (this.dxD != null) {
                r0 += a.a.a.b.b.a.f(3, this.dxD);
            }
            if (this.dxE != null) {
                r0 += a.a.a.b.b.a.f(4, this.dxE);
            }
            if (this.dxF != null) {
                r0 += a.a.a.b.b.a.f(5, this.dxF);
            }
            if (this.dxG != null) {
                r0 += a.a.a.b.b.a.f(6, this.dxG);
            }
            if (this.dxH != null) {
                r0 += a.a.a.b.b.a.f(7, this.dxH);
            }
            if (this.dxI != null) {
                r0 += a.a.a.b.b.a.f(8, this.dxI);
            }
            if (this.dxJ != null) {
                r0 += a.a.a.b.b.a.f(9, this.dxJ);
            }
            if (this.dxK != null) {
                return r0 + a.a.a.b.b.a.f(10, this.dxK);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bVar.id = aVar3.pMj.mH();
                    return 0;
                case 2:
                    bVar.dxC = aVar3.pMj.readString();
                    return 0;
                case 3:
                    bVar.dxD = aVar3.pMj.readString();
                    return 0;
                case 4:
                    bVar.dxE = aVar3.pMj.readString();
                    return 0;
                case 5:
                    bVar.dxF = aVar3.pMj.readString();
                    return 0;
                case 6:
                    bVar.dxG = aVar3.pMj.readString();
                    return 0;
                case 7:
                    bVar.dxH = aVar3.pMj.readString();
                    return 0;
                case 8:
                    bVar.dxI = aVar3.pMj.readString();
                    return 0;
                case 9:
                    bVar.dxJ = aVar3.pMj.readString();
                    return 0;
                case 10:
                    bVar.dxK = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
