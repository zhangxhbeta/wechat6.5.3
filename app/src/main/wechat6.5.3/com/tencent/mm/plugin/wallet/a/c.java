package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class c extends a {
    public double kHA;
    public String kHB;
    public LinkedList<l> kHC = new LinkedList();
    public d kHD;
    public int kHE;
    public String kHF;
    public String kHG;
    public double kHH;
    public double kHI;
    public int kHJ;
    public String kHK;
    public String kHL;
    public double kHy;
    public double kHz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.a(1, this.kHy);
            aVar.a(2, this.kHz);
            aVar.a(3, this.kHA);
            if (this.kHB != null) {
                aVar.e(4, this.kHB);
            }
            aVar.d(5, 8, this.kHC);
            if (this.kHD != null) {
                aVar.dX(6, this.kHD.aHr());
                this.kHD.a(aVar);
            }
            aVar.dV(7, this.kHE);
            if (this.kHF != null) {
                aVar.e(8, this.kHF);
            }
            if (this.kHG != null) {
                aVar.e(9, this.kHG);
            }
            aVar.a(10, this.kHH);
            aVar.a(11, this.kHI);
            aVar.dV(12, this.kHJ);
            if (this.kHK != null) {
                aVar.e(13, this.kHK);
            }
            if (this.kHL != null) {
                aVar.e(14, this.kHL);
            }
            return 0;
        } else if (i == 1) {
            r0 = (((a.a.a.b.b.a.cw(1) + 8) + 0) + (a.a.a.b.b.a.cw(2) + 8)) + (a.a.a.b.b.a.cw(3) + 8);
            if (this.kHB != null) {
                r0 += a.a.a.b.b.a.f(4, this.kHB);
            }
            r0 += a.a.a.a.c(5, 8, this.kHC);
            if (this.kHD != null) {
                r0 += a.a.a.a.dU(6, this.kHD.aHr());
            }
            r0 += a.a.a.a.dS(7, this.kHE);
            if (this.kHF != null) {
                r0 += a.a.a.b.b.a.f(8, this.kHF);
            }
            if (this.kHG != null) {
                r0 += a.a.a.b.b.a.f(9, this.kHG);
            }
            r0 = ((r0 + (a.a.a.b.b.a.cw(10) + 8)) + (a.a.a.b.b.a.cw(11) + 8)) + a.a.a.a.dS(12, this.kHJ);
            if (this.kHK != null) {
                r0 += a.a.a.b.b.a.f(13, this.kHK);
            }
            if (this.kHL != null) {
                return r0 + a.a.a.b.b.a.f(14, this.kHL);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.kHC.clear();
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
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    cVar.kHy = aVar3.pMj.readDouble();
                    return 0;
                case 2:
                    cVar.kHz = aVar3.pMj.readDouble();
                    return 0;
                case 3:
                    cVar.kHA = aVar3.pMj.readDouble();
                    return 0;
                case 4:
                    cVar.kHB = aVar3.pMj.readString();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        l lVar = new l();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = lVar.a(aVar4, lVar, a.a(aVar4))) {
                        }
                        cVar.kHC.add(lVar);
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        d dVar = new d();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.kHD = dVar;
                    }
                    return 0;
                case 7:
                    cVar.kHE = aVar3.pMj.mH();
                    return 0;
                case 8:
                    cVar.kHF = aVar3.pMj.readString();
                    return 0;
                case 9:
                    cVar.kHG = aVar3.pMj.readString();
                    return 0;
                case 10:
                    cVar.kHH = aVar3.pMj.readDouble();
                    return 0;
                case 11:
                    cVar.kHI = aVar3.pMj.readDouble();
                    return 0;
                case 12:
                    cVar.kHJ = aVar3.pMj.mH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    cVar.kHK = aVar3.pMj.readString();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    cVar.kHL = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
