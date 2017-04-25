package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import java.util.LinkedList;

public final class uc extends aqx {
    public String coN;
    public String content;
    public String lZT;
    public String lZU;
    public String lZV;
    public String lZW;
    public String lZX;
    public String lZY;
    public String lZZ;
    public String maa;
    public String mab;
    public String mad;
    public String mae;
    public String maf;
    public String mag;
    public String mah;
    public boolean mai = false;
    public int maj;
    public int mak;
    public int mal;
    public String mam;
    public String man;
    public int mao;
    public String maq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            if (this.lZT != null) {
                aVar.e(2, this.lZT);
            }
            if (this.lZU != null) {
                aVar.e(3, this.lZU);
            }
            if (this.lZV != null) {
                aVar.e(4, this.lZV);
            }
            if (this.content != null) {
                aVar.e(5, this.content);
            }
            if (this.lZW != null) {
                aVar.e(6, this.lZW);
            }
            if (this.lZX != null) {
                aVar.e(7, this.lZX);
            }
            if (this.lZY != null) {
                aVar.e(8, this.lZY);
            }
            if (this.lZZ != null) {
                aVar.e(9, this.lZZ);
            }
            if (this.maa != null) {
                aVar.e(10, this.maa);
            }
            if (this.mab != null) {
                aVar.e(11, this.mab);
            }
            if (this.mad != null) {
                aVar.e(12, this.mad);
            }
            if (this.mae != null) {
                aVar.e(13, this.mae);
            }
            if (this.maf != null) {
                aVar.e(14, this.maf);
            }
            if (this.mag != null) {
                aVar.e(15, this.mag);
            }
            if (this.mah != null) {
                aVar.e(16, this.mah);
            }
            aVar.ab(17, this.mai);
            aVar.dV(18, this.maj);
            aVar.dV(19, this.mak);
            aVar.dV(20, this.mal);
            if (this.coN != null) {
                aVar.e(21, this.coN);
            }
            if (this.mam != null) {
                aVar.e(22, this.mam);
            }
            if (this.man != null) {
                aVar.e(23, this.man);
            }
            aVar.dV(24, this.mao);
            if (this.maq == null) {
                return 0;
            }
            aVar.e(25, this.maq);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.lZT != null) {
                r0 += a.a.a.b.b.a.f(2, this.lZT);
            }
            if (this.lZU != null) {
                r0 += a.a.a.b.b.a.f(3, this.lZU);
            }
            if (this.lZV != null) {
                r0 += a.a.a.b.b.a.f(4, this.lZV);
            }
            if (this.content != null) {
                r0 += a.a.a.b.b.a.f(5, this.content);
            }
            if (this.lZW != null) {
                r0 += a.a.a.b.b.a.f(6, this.lZW);
            }
            if (this.lZX != null) {
                r0 += a.a.a.b.b.a.f(7, this.lZX);
            }
            if (this.lZY != null) {
                r0 += a.a.a.b.b.a.f(8, this.lZY);
            }
            if (this.lZZ != null) {
                r0 += a.a.a.b.b.a.f(9, this.lZZ);
            }
            if (this.maa != null) {
                r0 += a.a.a.b.b.a.f(10, this.maa);
            }
            if (this.mab != null) {
                r0 += a.a.a.b.b.a.f(11, this.mab);
            }
            if (this.mad != null) {
                r0 += a.a.a.b.b.a.f(12, this.mad);
            }
            if (this.mae != null) {
                r0 += a.a.a.b.b.a.f(13, this.mae);
            }
            if (this.maf != null) {
                r0 += a.a.a.b.b.a.f(14, this.maf);
            }
            if (this.mag != null) {
                r0 += a.a.a.b.b.a.f(15, this.mag);
            }
            if (this.mah != null) {
                r0 += a.a.a.b.b.a.f(16, this.mah);
            }
            r0 = (((r0 + (a.a.a.b.b.a.cw(17) + 1)) + a.a.a.a.dS(18, this.maj)) + a.a.a.a.dS(19, this.mak)) + a.a.a.a.dS(20, this.mal);
            if (this.coN != null) {
                r0 += a.a.a.b.b.a.f(21, this.coN);
            }
            if (this.mam != null) {
                r0 += a.a.a.b.b.a.f(22, this.mam);
            }
            if (this.man != null) {
                r0 += a.a.a.b.b.a.f(23, this.man);
            }
            r0 += a.a.a.a.dS(24, this.mao);
            if (this.maq != null) {
                r0 += a.a.a.b.b.a.f(25, this.maq);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            uc ucVar = (uc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        ucVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    ucVar.lZT = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ucVar.lZU = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ucVar.lZV = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ucVar.content = aVar3.pMj.readString();
                    return 0;
                case 6:
                    ucVar.lZW = aVar3.pMj.readString();
                    return 0;
                case 7:
                    ucVar.lZX = aVar3.pMj.readString();
                    return 0;
                case 8:
                    ucVar.lZY = aVar3.pMj.readString();
                    return 0;
                case 9:
                    ucVar.lZZ = aVar3.pMj.readString();
                    return 0;
                case 10:
                    ucVar.maa = aVar3.pMj.readString();
                    return 0;
                case 11:
                    ucVar.mab = aVar3.pMj.readString();
                    return 0;
                case 12:
                    ucVar.mad = aVar3.pMj.readString();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    ucVar.mae = aVar3.pMj.readString();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    ucVar.maf = aVar3.pMj.readString();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    ucVar.mag = aVar3.pMj.readString();
                    return 0;
                case 16:
                    ucVar.mah = aVar3.pMj.readString();
                    return 0;
                case 17:
                    ucVar.mai = aVar3.bQJ();
                    return 0;
                case 18:
                    ucVar.maj = aVar3.pMj.mH();
                    return 0;
                case 19:
                    ucVar.mak = aVar3.pMj.mH();
                    return 0;
                case 20:
                    ucVar.mal = aVar3.pMj.mH();
                    return 0;
                case 21:
                    ucVar.coN = aVar3.pMj.readString();
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    ucVar.mam = aVar3.pMj.readString();
                    return 0;
                case 23:
                    ucVar.man = aVar3.pMj.readString();
                    return 0;
                case 24:
                    ucVar.mao = aVar3.pMj.mH();
                    return 0;
                case 25:
                    ucVar.maq = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
