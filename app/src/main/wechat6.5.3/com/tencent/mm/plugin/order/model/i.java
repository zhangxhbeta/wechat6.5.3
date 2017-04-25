package com.tencent.mm.plugin.order.model;

import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class i extends a {
    public String hNP;
    public double hNQ;
    public String hNR;
    public int hNS;
    public String hNT;
    public int hNU;
    public String hNV;
    public int hNW;
    public int hNX;
    public String hNY;
    public String hNZ;
    public String hOa;
    public String hOb;
    public String hOc;
    public String hOd;
    public int hOe;
    public LinkedList<k> hOf = new LinkedList();
    public String hOg;
    public String hOh;
    public double hOi;
    public String hOj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.hNP != null) {
                aVar.e(1, this.hNP);
            }
            aVar.a(2, this.hNQ);
            if (this.hNR != null) {
                aVar.e(3, this.hNR);
            }
            aVar.dV(4, this.hNS);
            if (this.hNT != null) {
                aVar.e(5, this.hNT);
            }
            aVar.dV(6, this.hNU);
            if (this.hNV != null) {
                aVar.e(7, this.hNV);
            }
            aVar.dV(8, this.hNW);
            aVar.dV(9, this.hNX);
            if (this.hNY != null) {
                aVar.e(10, this.hNY);
            }
            if (this.hNZ != null) {
                aVar.e(11, this.hNZ);
            }
            if (this.hOa != null) {
                aVar.e(12, this.hOa);
            }
            if (this.hOb != null) {
                aVar.e(13, this.hOb);
            }
            if (this.hOc != null) {
                aVar.e(14, this.hOc);
            }
            if (this.hOd != null) {
                aVar.e(15, this.hOd);
            }
            aVar.dV(16, this.hOe);
            aVar.d(17, 8, this.hOf);
            if (this.hOg != null) {
                aVar.e(18, this.hOg);
            }
            if (this.hOh != null) {
                aVar.e(19, this.hOh);
            }
            aVar.a(20, this.hOi);
            if (this.hOj == null) {
                return 0;
            }
            aVar.e(21, this.hOj);
            return 0;
        } else if (i == 1) {
            if (this.hNP != null) {
                r0 = a.a.a.b.b.a.f(1, this.hNP) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.b.b.a.cw(2) + 8;
            if (this.hNR != null) {
                r0 += a.a.a.b.b.a.f(3, this.hNR);
            }
            r0 += a.a.a.a.dS(4, this.hNS);
            if (this.hNT != null) {
                r0 += a.a.a.b.b.a.f(5, this.hNT);
            }
            r0 += a.a.a.a.dS(6, this.hNU);
            if (this.hNV != null) {
                r0 += a.a.a.b.b.a.f(7, this.hNV);
            }
            r0 = (r0 + a.a.a.a.dS(8, this.hNW)) + a.a.a.a.dS(9, this.hNX);
            if (this.hNY != null) {
                r0 += a.a.a.b.b.a.f(10, this.hNY);
            }
            if (this.hNZ != null) {
                r0 += a.a.a.b.b.a.f(11, this.hNZ);
            }
            if (this.hOa != null) {
                r0 += a.a.a.b.b.a.f(12, this.hOa);
            }
            if (this.hOb != null) {
                r0 += a.a.a.b.b.a.f(13, this.hOb);
            }
            if (this.hOc != null) {
                r0 += a.a.a.b.b.a.f(14, this.hOc);
            }
            if (this.hOd != null) {
                r0 += a.a.a.b.b.a.f(15, this.hOd);
            }
            r0 = (r0 + a.a.a.a.dS(16, this.hOe)) + a.a.a.a.c(17, 8, this.hOf);
            if (this.hOg != null) {
                r0 += a.a.a.b.b.a.f(18, this.hOg);
            }
            if (this.hOh != null) {
                r0 += a.a.a.b.b.a.f(19, this.hOh);
            }
            r0 += a.a.a.b.b.a.cw(20) + 8;
            if (this.hOj != null) {
                r0 += a.a.a.b.b.a.f(21, this.hOj);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.hOf.clear();
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
            i iVar = (i) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iVar.hNP = aVar3.pMj.readString();
                    return 0;
                case 2:
                    iVar.hNQ = aVar3.pMj.readDouble();
                    return 0;
                case 3:
                    iVar.hNR = aVar3.pMj.readString();
                    return 0;
                case 4:
                    iVar.hNS = aVar3.pMj.mH();
                    return 0;
                case 5:
                    iVar.hNT = aVar3.pMj.readString();
                    return 0;
                case 6:
                    iVar.hNU = aVar3.pMj.mH();
                    return 0;
                case 7:
                    iVar.hNV = aVar3.pMj.readString();
                    return 0;
                case 8:
                    iVar.hNW = aVar3.pMj.mH();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    iVar.hNX = aVar3.pMj.mH();
                    return 0;
                case NetStatusUtil.LTE /*10*/:
                    iVar.hNY = aVar3.pMj.readString();
                    return 0;
                case 11:
                    iVar.hNZ = aVar3.pMj.readString();
                    return 0;
                case 12:
                    iVar.hOa = aVar3.pMj.readString();
                    return 0;
                case 13:
                    iVar.hOb = aVar3.pMj.readString();
                    return 0;
                case 14:
                    iVar.hOc = aVar3.pMj.readString();
                    return 0;
                case 15:
                    iVar.hOd = aVar3.pMj.readString();
                    return 0;
                case 16:
                    iVar.hOe = aVar3.pMj.mH();
                    return 0;
                case 17:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        k kVar = new k();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = kVar.a(aVar4, kVar, a.a(aVar4))) {
                        }
                        iVar.hOf.add(kVar);
                    }
                    return 0;
                case 18:
                    iVar.hOg = aVar3.pMj.readString();
                    return 0;
                case 19:
                    iVar.hOh = aVar3.pMj.readString();
                    return 0;
                case 20:
                    iVar.hOi = aVar3.pMj.readDouble();
                    return 0;
                case 21:
                    iVar.hOj = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
