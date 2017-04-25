package com.tencent.mm.protocal.c;

import android.support.v7.a.a.k;
import com.tencent.mm.ba.a;

public final class ol extends a {
    public String gnp;
    public String mdM;
    public int mqK;
    public String mqL;
    public String mqM;
    public String mqN;
    public String mqd;
    public String mqe;
    public String mqf;
    public String mqg;
    public int mqh;
    public int mqi;
    public String mql;
    public int mqm;
    public String mqn;
    public String mqo;
    public String mqp;
    public String mqq;
    public String mqu;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mdM != null) {
                aVar.e(1, this.mdM);
            }
            if (this.gnp != null) {
                aVar.e(2, this.gnp);
            }
            if (this.mqd != null) {
                aVar.e(3, this.mqd);
            }
            if (this.mqe != null) {
                aVar.e(4, this.mqe);
            }
            if (this.mqf != null) {
                aVar.e(5, this.mqf);
            }
            if (this.mqg != null) {
                aVar.e(6, this.mqg);
            }
            aVar.dV(7, this.mqh);
            aVar.dV(8, this.mqi);
            if (this.mql != null) {
                aVar.e(9, this.mql);
            }
            aVar.dV(10, this.mqm);
            if (this.mqn != null) {
                aVar.e(11, this.mqn);
            }
            aVar.dV(12, this.mqK);
            if (this.mqq != null) {
                aVar.e(13, this.mqq);
            }
            if (this.mqo != null) {
                aVar.e(14, this.mqo);
            }
            if (this.mqp != null) {
                aVar.e(15, this.mqp);
            }
            if (this.mqL != null) {
                aVar.e(16, this.mqL);
            }
            if (this.mqu != null) {
                aVar.e(17, this.mqu);
            }
            if (this.mqM != null) {
                aVar.e(18, this.mqM);
            }
            if (this.mqN == null) {
                return 0;
            }
            aVar.e(19, this.mqN);
            return 0;
        } else if (i == 1) {
            if (this.mdM != null) {
                r0 = a.a.a.b.b.a.f(1, this.mdM) + 0;
            } else {
                r0 = 0;
            }
            if (this.gnp != null) {
                r0 += a.a.a.b.b.a.f(2, this.gnp);
            }
            if (this.mqd != null) {
                r0 += a.a.a.b.b.a.f(3, this.mqd);
            }
            if (this.mqe != null) {
                r0 += a.a.a.b.b.a.f(4, this.mqe);
            }
            if (this.mqf != null) {
                r0 += a.a.a.b.b.a.f(5, this.mqf);
            }
            if (this.mqg != null) {
                r0 += a.a.a.b.b.a.f(6, this.mqg);
            }
            r0 = (r0 + a.a.a.a.dS(7, this.mqh)) + a.a.a.a.dS(8, this.mqi);
            if (this.mql != null) {
                r0 += a.a.a.b.b.a.f(9, this.mql);
            }
            r0 += a.a.a.a.dS(10, this.mqm);
            if (this.mqn != null) {
                r0 += a.a.a.b.b.a.f(11, this.mqn);
            }
            r0 += a.a.a.a.dS(12, this.mqK);
            if (this.mqq != null) {
                r0 += a.a.a.b.b.a.f(13, this.mqq);
            }
            if (this.mqo != null) {
                r0 += a.a.a.b.b.a.f(14, this.mqo);
            }
            if (this.mqp != null) {
                r0 += a.a.a.b.b.a.f(15, this.mqp);
            }
            if (this.mqL != null) {
                r0 += a.a.a.b.b.a.f(16, this.mqL);
            }
            if (this.mqu != null) {
                r0 += a.a.a.b.b.a.f(17, this.mqu);
            }
            if (this.mqM != null) {
                r0 += a.a.a.b.b.a.f(18, this.mqM);
            }
            if (this.mqN != null) {
                r0 += a.a.a.b.b.a.f(19, this.mqN);
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
            ol olVar = (ol) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    olVar.mdM = aVar3.pMj.readString();
                    return 0;
                case 2:
                    olVar.gnp = aVar3.pMj.readString();
                    return 0;
                case 3:
                    olVar.mqd = aVar3.pMj.readString();
                    return 0;
                case 4:
                    olVar.mqe = aVar3.pMj.readString();
                    return 0;
                case 5:
                    olVar.mqf = aVar3.pMj.readString();
                    return 0;
                case 6:
                    olVar.mqg = aVar3.pMj.readString();
                    return 0;
                case 7:
                    olVar.mqh = aVar3.pMj.mH();
                    return 0;
                case 8:
                    olVar.mqi = aVar3.pMj.mH();
                    return 0;
                case 9:
                    olVar.mql = aVar3.pMj.readString();
                    return 0;
                case 10:
                    olVar.mqm = aVar3.pMj.mH();
                    return 0;
                case 11:
                    olVar.mqn = aVar3.pMj.readString();
                    return 0;
                case 12:
                    olVar.mqK = aVar3.pMj.mH();
                    return 0;
                case 13:
                    olVar.mqq = aVar3.pMj.readString();
                    return 0;
                case 14:
                    olVar.mqo = aVar3.pMj.readString();
                    return 0;
                case 15:
                    olVar.mqp = aVar3.pMj.readString();
                    return 0;
                case 16:
                    olVar.mqL = aVar3.pMj.readString();
                    return 0;
                case 17:
                    olVar.mqu = aVar3.pMj.readString();
                    return 0;
                case k.MG /*18*/:
                    olVar.mqM = aVar3.pMj.readString();
                    return 0;
                case 19:
                    olVar.mqN = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
