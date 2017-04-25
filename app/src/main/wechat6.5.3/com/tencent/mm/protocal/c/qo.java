package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class qo extends a {
    public int muc;
    public int mud;
    public int mue;
    public int muf;
    public int mug;
    public int muh;
    public int mui;
    public int muj;
    public int muk;
    public int mul;
    public int mum;
    public int mun;
    public int muo;
    public int mup;
    public int muq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.muc);
            aVar.dV(2, this.mud);
            aVar.dV(3, this.mue);
            aVar.dV(4, this.muf);
            aVar.dV(5, this.mug);
            aVar.dV(6, this.muh);
            aVar.dV(7, this.mui);
            aVar.dV(8, this.muj);
            aVar.dV(9, this.muk);
            aVar.dV(10, this.mul);
            aVar.dV(11, this.mum);
            aVar.dV(12, this.mun);
            aVar.dV(13, this.muo);
            aVar.dV(14, this.mup);
            aVar.dV(15, this.muq);
            return 0;
        } else if (i == 1) {
            return ((((((((((((((a.a.a.a.dS(1, this.muc) + 0) + a.a.a.a.dS(2, this.mud)) + a.a.a.a.dS(3, this.mue)) + a.a.a.a.dS(4, this.muf)) + a.a.a.a.dS(5, this.mug)) + a.a.a.a.dS(6, this.muh)) + a.a.a.a.dS(7, this.mui)) + a.a.a.a.dS(8, this.muj)) + a.a.a.a.dS(9, this.muk)) + a.a.a.a.dS(10, this.mul)) + a.a.a.a.dS(11, this.mum)) + a.a.a.a.dS(12, this.mun)) + a.a.a.a.dS(13, this.muo)) + a.a.a.a.dS(14, this.mup)) + a.a.a.a.dS(15, this.muq);
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
                qo qoVar = (qo) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        qoVar.muc = aVar3.pMj.mH();
                        return 0;
                    case 2:
                        qoVar.mud = aVar3.pMj.mH();
                        return 0;
                    case 3:
                        qoVar.mue = aVar3.pMj.mH();
                        return 0;
                    case 4:
                        qoVar.muf = aVar3.pMj.mH();
                        return 0;
                    case 5:
                        qoVar.mug = aVar3.pMj.mH();
                        return 0;
                    case 6:
                        qoVar.muh = aVar3.pMj.mH();
                        return 0;
                    case 7:
                        qoVar.mui = aVar3.pMj.mH();
                        return 0;
                    case 8:
                        qoVar.muj = aVar3.pMj.mH();
                        return 0;
                    case 9:
                        qoVar.muk = aVar3.pMj.mH();
                        return 0;
                    case 10:
                        qoVar.mul = aVar3.pMj.mH();
                        return 0;
                    case 11:
                        qoVar.mum = aVar3.pMj.mH();
                        return 0;
                    case 12:
                        qoVar.mun = aVar3.pMj.mH();
                        return 0;
                    case 13:
                        qoVar.muo = aVar3.pMj.mH();
                        return 0;
                    case 14:
                        qoVar.mup = aVar3.pMj.mH();
                        return 0;
                    case 15:
                        qoVar.muq = aVar3.pMj.mH();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
