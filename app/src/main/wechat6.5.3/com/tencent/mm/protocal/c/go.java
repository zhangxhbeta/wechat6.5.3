package com.tencent.mm.protocal.c;

import android.support.v7.a.a.k;
import com.tencent.mm.ba.a;

public final class go extends a {
    public String gkB;
    public int gkH;
    public String glj;
    public String maX;
    public String maY;
    public String mdJ;
    public String mdQ;
    public String mdS;
    public String mhk;
    public String mhl;
    public String mhm;
    public String mhn;
    public String mho;
    public String mhp;
    public String mhq;
    public String mhr;
    public String mhs;
    public int mht;
    public int mhu;
    public String mhv;
    public String mhw;
    public String mhx;
    public long mhy;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.glj != null) {
                aVar.e(1, this.glj);
            }
            if (this.gkB != null) {
                aVar.e(2, this.gkB);
            }
            if (this.mdJ != null) {
                aVar.e(3, this.mdJ);
            }
            if (this.mhk != null) {
                aVar.e(4, this.mhk);
            }
            if (this.mhl != null) {
                aVar.e(5, this.mhl);
            }
            if (this.mhm != null) {
                aVar.e(6, this.mhm);
            }
            if (this.mhn != null) {
                aVar.e(7, this.mhn);
            }
            if (this.mho != null) {
                aVar.e(8, this.mho);
            }
            if (this.mhp != null) {
                aVar.e(9, this.mhp);
            }
            if (this.mhq != null) {
                aVar.e(10, this.mhq);
            }
            if (this.mhr != null) {
                aVar.e(11, this.mhr);
            }
            if (this.maX != null) {
                aVar.e(12, this.maX);
            }
            if (this.mhs != null) {
                aVar.e(13, this.mhs);
            }
            if (this.mdQ != null) {
                aVar.e(14, this.mdQ);
            }
            if (this.mdS != null) {
                aVar.e(15, this.mdS);
            }
            aVar.dV(16, this.gkH);
            aVar.dV(17, this.mht);
            aVar.dV(18, this.mhu);
            if (this.mhv != null) {
                aVar.e(19, this.mhv);
            }
            if (this.mhw != null) {
                aVar.e(20, this.mhw);
            }
            if (this.mhx != null) {
                aVar.e(21, this.mhx);
            }
            if (this.maY != null) {
                aVar.e(22, this.maY);
            }
            aVar.C(23, this.mhy);
            return 0;
        } else if (i == 1) {
            if (this.glj != null) {
                r0 = a.a.a.b.b.a.f(1, this.glj) + 0;
            } else {
                r0 = 0;
            }
            if (this.gkB != null) {
                r0 += a.a.a.b.b.a.f(2, this.gkB);
            }
            if (this.mdJ != null) {
                r0 += a.a.a.b.b.a.f(3, this.mdJ);
            }
            if (this.mhk != null) {
                r0 += a.a.a.b.b.a.f(4, this.mhk);
            }
            if (this.mhl != null) {
                r0 += a.a.a.b.b.a.f(5, this.mhl);
            }
            if (this.mhm != null) {
                r0 += a.a.a.b.b.a.f(6, this.mhm);
            }
            if (this.mhn != null) {
                r0 += a.a.a.b.b.a.f(7, this.mhn);
            }
            if (this.mho != null) {
                r0 += a.a.a.b.b.a.f(8, this.mho);
            }
            if (this.mhp != null) {
                r0 += a.a.a.b.b.a.f(9, this.mhp);
            }
            if (this.mhq != null) {
                r0 += a.a.a.b.b.a.f(10, this.mhq);
            }
            if (this.mhr != null) {
                r0 += a.a.a.b.b.a.f(11, this.mhr);
            }
            if (this.maX != null) {
                r0 += a.a.a.b.b.a.f(12, this.maX);
            }
            if (this.mhs != null) {
                r0 += a.a.a.b.b.a.f(13, this.mhs);
            }
            if (this.mdQ != null) {
                r0 += a.a.a.b.b.a.f(14, this.mdQ);
            }
            if (this.mdS != null) {
                r0 += a.a.a.b.b.a.f(15, this.mdS);
            }
            r0 = ((r0 + a.a.a.a.dS(16, this.gkH)) + a.a.a.a.dS(17, this.mht)) + a.a.a.a.dS(18, this.mhu);
            if (this.mhv != null) {
                r0 += a.a.a.b.b.a.f(19, this.mhv);
            }
            if (this.mhw != null) {
                r0 += a.a.a.b.b.a.f(20, this.mhw);
            }
            if (this.mhx != null) {
                r0 += a.a.a.b.b.a.f(21, this.mhx);
            }
            if (this.maY != null) {
                r0 += a.a.a.b.b.a.f(22, this.maY);
            }
            return r0 + a.a.a.a.B(23, this.mhy);
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
            go goVar = (go) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    goVar.glj = aVar3.pMj.readString();
                    return 0;
                case 2:
                    goVar.gkB = aVar3.pMj.readString();
                    return 0;
                case 3:
                    goVar.mdJ = aVar3.pMj.readString();
                    return 0;
                case 4:
                    goVar.mhk = aVar3.pMj.readString();
                    return 0;
                case 5:
                    goVar.mhl = aVar3.pMj.readString();
                    return 0;
                case 6:
                    goVar.mhm = aVar3.pMj.readString();
                    return 0;
                case 7:
                    goVar.mhn = aVar3.pMj.readString();
                    return 0;
                case 8:
                    goVar.mho = aVar3.pMj.readString();
                    return 0;
                case 9:
                    goVar.mhp = aVar3.pMj.readString();
                    return 0;
                case 10:
                    goVar.mhq = aVar3.pMj.readString();
                    return 0;
                case 11:
                    goVar.mhr = aVar3.pMj.readString();
                    return 0;
                case 12:
                    goVar.maX = aVar3.pMj.readString();
                    return 0;
                case 13:
                    goVar.mhs = aVar3.pMj.readString();
                    return 0;
                case 14:
                    goVar.mdQ = aVar3.pMj.readString();
                    return 0;
                case 15:
                    goVar.mdS = aVar3.pMj.readString();
                    return 0;
                case 16:
                    goVar.gkH = aVar3.pMj.mH();
                    return 0;
                case 17:
                    goVar.mht = aVar3.pMj.mH();
                    return 0;
                case k.MG /*18*/:
                    goVar.mhu = aVar3.pMj.mH();
                    return 0;
                case 19:
                    goVar.mhv = aVar3.pMj.readString();
                    return 0;
                case 20:
                    goVar.mhw = aVar3.pMj.readString();
                    return 0;
                case 21:
                    goVar.mhx = aVar3.pMj.readString();
                    return 0;
                case k.MM /*22*/:
                    goVar.maY = aVar3.pMj.readString();
                    return 0;
                case k.Nb /*23*/:
                    goVar.mhy = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
