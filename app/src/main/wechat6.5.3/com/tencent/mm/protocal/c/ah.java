package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import com.tencent.mars.comm.NetStatusUtil;
import java.util.LinkedList;

public final class ah extends aqx {
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
            ah ahVar = (ah) objArr[1];
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
                        ahVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    ahVar.lZT = aVar3.pMj.readString();
                    return 0;
                case 3:
                    ahVar.lZU = aVar3.pMj.readString();
                    return 0;
                case 4:
                    ahVar.lZV = aVar3.pMj.readString();
                    return 0;
                case 5:
                    ahVar.content = aVar3.pMj.readString();
                    return 0;
                case 6:
                    ahVar.lZW = aVar3.pMj.readString();
                    return 0;
                case 7:
                    ahVar.lZX = aVar3.pMj.readString();
                    return 0;
                case 8:
                    ahVar.lZY = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    ahVar.lZZ = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.LTE /*10*/:
                    ahVar.maa = aVar3.pMj.readString();
                    return 0;
                case 11:
                    ahVar.mab = aVar3.pMj.readString();
                    return 0;
                case 12:
                    ahVar.mad = aVar3.pMj.readString();
                    return 0;
                case 13:
                    ahVar.mae = aVar3.pMj.readString();
                    return 0;
                case 14:
                    ahVar.maf = aVar3.pMj.readString();
                    return 0;
                case 15:
                    ahVar.mag = aVar3.pMj.readString();
                    return 0;
                case 16:
                    ahVar.mah = aVar3.pMj.readString();
                    return 0;
                case 17:
                    ahVar.mai = aVar3.bQJ();
                    return 0;
                case 18:
                    ahVar.maj = aVar3.pMj.mH();
                    return 0;
                case 19:
                    ahVar.mak = aVar3.pMj.mH();
                    return 0;
                case 20:
                    ahVar.mal = aVar3.pMj.mH();
                    return 0;
                case 21:
                    ahVar.coN = aVar3.pMj.readString();
                    return 0;
                case 22:
                    ahVar.mam = aVar3.pMj.readString();
                    return 0;
                case 23:
                    ahVar.man = aVar3.pMj.readString();
                    return 0;
                case 24:
                    ahVar.mao = aVar3.pMj.mH();
                    return 0;
                case 25:
                    ahVar.maq = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
