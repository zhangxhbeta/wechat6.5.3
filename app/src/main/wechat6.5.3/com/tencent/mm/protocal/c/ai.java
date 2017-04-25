package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;

public final class ai extends a {
    public String cHh;
    public int eeO;
    public String efy;
    public String gln;
    public String maA;
    public int maB;
    public String maC;
    public int mar;
    public String mas;
    public String mat;
    public int mau;
    public int mav;
    public String maw;
    public int may;
    public String maz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gln != null) {
                aVar.e(1, this.gln);
            }
            if (this.efy != null) {
                aVar.e(2, this.efy);
            }
            aVar.dV(3, this.mar);
            if (this.mas != null) {
                aVar.e(4, this.mas);
            }
            if (this.mat != null) {
                aVar.e(5, this.mat);
            }
            if (this.cHh != null) {
                aVar.e(6, this.cHh);
            }
            aVar.dV(8, this.eeO);
            aVar.dV(9, this.mau);
            aVar.dV(10, this.mav);
            if (this.maw != null) {
                aVar.e(11, this.maw);
            }
            aVar.dV(12, this.may);
            if (this.maz != null) {
                aVar.e(13, this.maz);
            }
            if (this.maA != null) {
                aVar.e(14, this.maA);
            }
            aVar.dV(15, this.maB);
            if (this.maC == null) {
                return 0;
            }
            aVar.e(16, this.maC);
            return 0;
        } else if (i == 1) {
            if (this.gln != null) {
                r0 = a.a.a.b.b.a.f(1, this.gln) + 0;
            } else {
                r0 = 0;
            }
            if (this.efy != null) {
                r0 += a.a.a.b.b.a.f(2, this.efy);
            }
            r0 += a.a.a.a.dS(3, this.mar);
            if (this.mas != null) {
                r0 += a.a.a.b.b.a.f(4, this.mas);
            }
            if (this.mat != null) {
                r0 += a.a.a.b.b.a.f(5, this.mat);
            }
            if (this.cHh != null) {
                r0 += a.a.a.b.b.a.f(6, this.cHh);
            }
            r0 = ((r0 + a.a.a.a.dS(8, this.eeO)) + a.a.a.a.dS(9, this.mau)) + a.a.a.a.dS(10, this.mav);
            if (this.maw != null) {
                r0 += a.a.a.b.b.a.f(11, this.maw);
            }
            r0 += a.a.a.a.dS(12, this.may);
            if (this.maz != null) {
                r0 += a.a.a.b.b.a.f(13, this.maz);
            }
            if (this.maA != null) {
                r0 += a.a.a.b.b.a.f(14, this.maA);
            }
            r0 += a.a.a.a.dS(15, this.maB);
            if (this.maC != null) {
                r0 += a.a.a.b.b.a.f(16, this.maC);
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
            ai aiVar = (ai) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aiVar.gln = aVar3.pMj.readString();
                    return 0;
                case 2:
                    aiVar.efy = aVar3.pMj.readString();
                    return 0;
                case 3:
                    aiVar.mar = aVar3.pMj.mH();
                    return 0;
                case 4:
                    aiVar.mas = aVar3.pMj.readString();
                    return 0;
                case 5:
                    aiVar.mat = aVar3.pMj.readString();
                    return 0;
                case 6:
                    aiVar.cHh = aVar3.pMj.readString();
                    return 0;
                case 8:
                    aiVar.eeO = aVar3.pMj.mH();
                    return 0;
                case 9:
                    aiVar.mau = aVar3.pMj.mH();
                    return 0;
                case 10:
                    aiVar.mav = aVar3.pMj.mH();
                    return 0;
                case 11:
                    aiVar.maw = aVar3.pMj.readString();
                    return 0;
                case 12:
                    aiVar.may = aVar3.pMj.mH();
                    return 0;
                case 13:
                    aiVar.maz = aVar3.pMj.readString();
                    return 0;
                case 14:
                    aiVar.maA = aVar3.pMj.readString();
                    return 0;
                case 15:
                    aiVar.maB = aVar3.pMj.mH();
                    return 0;
                case 16:
                    aiVar.maC = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
