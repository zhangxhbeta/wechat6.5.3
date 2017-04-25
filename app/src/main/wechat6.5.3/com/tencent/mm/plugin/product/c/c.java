package com.tencent.mm.plugin.product.c;

import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class c extends a {
    public String cqK;
    public String hNg;
    public LinkedList<d> hQR = new LinkedList();
    public int hQS;
    public int hQT;
    public int hQU;
    public LinkedList<String> hQV = new LinkedList();
    public String hQW;
    public LinkedList<String> hQX = new LinkedList();
    public LinkedList<b> hQY = new LinkedList();
    public LinkedList<String> hQZ = new LinkedList();
    public int hRa;
    public int hRb;
    public LinkedList<m> hRc = new LinkedList();
    public LinkedList<a> hRd = new LinkedList();
    public k hRe;
    public String name;
    public int version;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            aVar.d(2, 8, this.hQR);
            aVar.dV(3, this.hQS);
            aVar.dV(4, this.hQT);
            aVar.dV(5, this.hQU);
            aVar.d(6, 1, this.hQV);
            if (this.cqK != null) {
                aVar.e(7, this.cqK);
            }
            if (this.hQW != null) {
                aVar.e(8, this.hQW);
            }
            aVar.d(9, 1, this.hQX);
            aVar.d(10, 8, this.hQY);
            aVar.d(11, 1, this.hQZ);
            aVar.dV(12, this.hRa);
            aVar.dV(13, this.hRb);
            aVar.d(14, 8, this.hRc);
            aVar.dV(15, this.version);
            aVar.d(16, 8, this.hRd);
            if (this.hNg != null) {
                aVar.e(17, this.hNg);
            }
            if (this.hRe == null) {
                return 0;
            }
            aVar.dX(18, this.hRe.aHr());
            this.hRe.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.name != null) {
                r0 = a.a.a.b.b.a.f(1, this.name) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + a.a.a.a.c(2, 8, this.hQR)) + a.a.a.a.dS(3, this.hQS)) + a.a.a.a.dS(4, this.hQT)) + a.a.a.a.dS(5, this.hQU)) + a.a.a.a.c(6, 1, this.hQV);
            if (this.cqK != null) {
                r0 += a.a.a.b.b.a.f(7, this.cqK);
            }
            if (this.hQW != null) {
                r0 += a.a.a.b.b.a.f(8, this.hQW);
            }
            r0 = (((((((r0 + a.a.a.a.c(9, 1, this.hQX)) + a.a.a.a.c(10, 8, this.hQY)) + a.a.a.a.c(11, 1, this.hQZ)) + a.a.a.a.dS(12, this.hRa)) + a.a.a.a.dS(13, this.hRb)) + a.a.a.a.c(14, 8, this.hRc)) + a.a.a.a.dS(15, this.version)) + a.a.a.a.c(16, 8, this.hRd);
            if (this.hNg != null) {
                r0 += a.a.a.b.b.a.f(17, this.hNg);
            }
            if (this.hRe != null) {
                r0 += a.a.a.a.dU(18, this.hRe.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.hQR.clear();
            this.hQV.clear();
            this.hQX.clear();
            this.hQY.clear();
            this.hQZ.clear();
            this.hRc.clear();
            this.hRd.clear();
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
                    cVar.name = aVar3.pMj.readString();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        d dVar = new d();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, a.a(aVar4))) {
                        }
                        cVar.hQR.add(dVar);
                    }
                    return 0;
                case 3:
                    cVar.hQS = aVar3.pMj.mH();
                    return 0;
                case 4:
                    cVar.hQT = aVar3.pMj.mH();
                    return 0;
                case 5:
                    cVar.hQU = aVar3.pMj.mH();
                    return 0;
                case 6:
                    cVar.hQV.add(aVar3.pMj.readString());
                    return 0;
                case 7:
                    cVar.cqK = aVar3.pMj.readString();
                    return 0;
                case 8:
                    cVar.hQW = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    cVar.hQX.add(aVar3.pMj.readString());
                    return 0;
                case NetStatusUtil.LTE /*10*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        b bVar = new b();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bVar.a(aVar4, bVar, a.a(aVar4))) {
                        }
                        cVar.hQY.add(bVar);
                    }
                    return 0;
                case 11:
                    cVar.hQZ.add(aVar3.pMj.readString());
                    return 0;
                case 12:
                    cVar.hRa = aVar3.pMj.mH();
                    return 0;
                case 13:
                    cVar.hRb = aVar3.pMj.mH();
                    return 0;
                case 14:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        m mVar = new m();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = mVar.a(aVar4, mVar, a.a(aVar4))) {
                        }
                        cVar.hRc.add(mVar);
                    }
                    return 0;
                case 15:
                    cVar.version = aVar3.pMj.mH();
                    return 0;
                case 16:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = aVar5.a(aVar4, aVar5, a.a(aVar4))) {
                        }
                        cVar.hRd.add(aVar5);
                    }
                    return 0;
                case 17:
                    cVar.hNg = aVar3.pMj.readString();
                    return 0;
                case 18:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        k kVar = new k();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = kVar.a(aVar4, kVar, a.a(aVar4))) {
                        }
                        cVar.hRe = kVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
