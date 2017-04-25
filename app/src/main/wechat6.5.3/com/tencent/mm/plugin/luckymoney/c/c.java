package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.ba.a;

public final class c extends a {
    public int hai;
    public double haj;
    public String hak;
    public String hal;
    public double ham;
    public double han;
    public double hao;
    public int hap;
    public int haq;
    public String har;
    public String has;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.hai);
            aVar.a(2, this.haj);
            if (this.hak != null) {
                aVar.e(3, this.hak);
            }
            if (this.hal != null) {
                aVar.e(4, this.hal);
            }
            aVar.a(5, this.ham);
            aVar.a(6, this.han);
            aVar.a(7, this.hao);
            aVar.dV(8, this.hap);
            aVar.dV(9, this.haq);
            if (this.har != null) {
                aVar.e(10, this.har);
            }
            if (this.has != null) {
                aVar.e(11, this.has);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.dS(1, this.hai) + 0) + (a.a.a.b.b.a.cw(2) + 8);
            if (this.hak != null) {
                r0 += a.a.a.b.b.a.f(3, this.hak);
            }
            if (this.hal != null) {
                r0 += a.a.a.b.b.a.f(4, this.hal);
            }
            r0 = ((((r0 + (a.a.a.b.b.a.cw(5) + 8)) + (a.a.a.b.b.a.cw(6) + 8)) + (a.a.a.b.b.a.cw(7) + 8)) + a.a.a.a.dS(8, this.hap)) + a.a.a.a.dS(9, this.haq);
            if (this.har != null) {
                r0 += a.a.a.b.b.a.f(10, this.har);
            }
            if (this.has != null) {
                return r0 + a.a.a.b.b.a.f(11, this.has);
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
            c cVar = (c) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cVar.hai = aVar3.pMj.mH();
                    return 0;
                case 2:
                    cVar.haj = aVar3.pMj.readDouble();
                    return 0;
                case 3:
                    cVar.hak = aVar3.pMj.readString();
                    return 0;
                case 4:
                    cVar.hal = aVar3.pMj.readString();
                    return 0;
                case 5:
                    cVar.ham = aVar3.pMj.readDouble();
                    return 0;
                case 6:
                    cVar.han = aVar3.pMj.readDouble();
                    return 0;
                case 7:
                    cVar.hao = aVar3.pMj.readDouble();
                    return 0;
                case 8:
                    cVar.hap = aVar3.pMj.mH();
                    return 0;
                case 9:
                    cVar.haq = aVar3.pMj.mH();
                    return 0;
                case 10:
                    cVar.har = aVar3.pMj.readString();
                    return 0;
                case 11:
                    cVar.has = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
