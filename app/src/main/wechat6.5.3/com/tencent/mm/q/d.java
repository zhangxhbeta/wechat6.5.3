package com.tencent.mm.q;

import com.tencent.mm.ba.a;

public final class d extends a {
    public String cqG;
    public String cqH;
    public String cqI;
    public String cqJ;
    public String cqK;
    public int cqL;
    public int cqM;
    public long time;
    public String title;
    public int type;
    public String url;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            if (this.cqG != null) {
                aVar.e(3, this.cqG);
            }
            if (this.cqH != null) {
                aVar.e(4, this.cqH);
            }
            aVar.C(5, this.time);
            if (this.cqI != null) {
                aVar.e(6, this.cqI);
            }
            if (this.cqJ != null) {
                aVar.e(7, this.cqJ);
            }
            if (this.cqK != null) {
                aVar.e(8, this.cqK);
            }
            aVar.dV(9, this.type);
            aVar.dV(10, this.cqL);
            aVar.dV(11, this.cqM);
            return 0;
        } else if (i == 1) {
            if (this.title != null) {
                r0 = a.a.a.b.b.a.f(1, this.title) + 0;
            } else {
                r0 = 0;
            }
            if (this.url != null) {
                r0 += a.a.a.b.b.a.f(2, this.url);
            }
            if (this.cqG != null) {
                r0 += a.a.a.b.b.a.f(3, this.cqG);
            }
            if (this.cqH != null) {
                r0 += a.a.a.b.b.a.f(4, this.cqH);
            }
            r0 += a.a.a.a.B(5, this.time);
            if (this.cqI != null) {
                r0 += a.a.a.b.b.a.f(6, this.cqI);
            }
            if (this.cqJ != null) {
                r0 += a.a.a.b.b.a.f(7, this.cqJ);
            }
            if (this.cqK != null) {
                r0 += a.a.a.b.b.a.f(8, this.cqK);
            }
            return ((r0 + a.a.a.a.dS(9, this.type)) + a.a.a.a.dS(10, this.cqL)) + a.a.a.a.dS(11, this.cqM);
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
            d dVar = (d) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dVar.title = aVar3.pMj.readString();
                    return 0;
                case 2:
                    dVar.url = aVar3.pMj.readString();
                    return 0;
                case 3:
                    dVar.cqG = aVar3.pMj.readString();
                    return 0;
                case 4:
                    dVar.cqH = aVar3.pMj.readString();
                    return 0;
                case 5:
                    dVar.time = aVar3.pMj.mI();
                    return 0;
                case 6:
                    dVar.cqI = aVar3.pMj.readString();
                    return 0;
                case 7:
                    dVar.cqJ = aVar3.pMj.readString();
                    return 0;
                case 8:
                    dVar.cqK = aVar3.pMj.readString();
                    return 0;
                case 9:
                    dVar.type = aVar3.pMj.mH();
                    return 0;
                case 10:
                    dVar.cqL = aVar3.pMj.mH();
                    return 0;
                case 11:
                    dVar.cqM = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
