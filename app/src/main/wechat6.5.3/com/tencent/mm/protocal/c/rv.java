package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import android.support.v7.a.a.k;
import java.util.LinkedList;

public final class rv extends aqx {
    public String SSID;
    public String aXz;
    public String gln;
    public String hQP;
    public String lZj;
    public int lZu;
    public String mvK;
    public String mvL;
    public adv mvM;
    public rr mvN;
    public String mvO;
    public int mvP;
    public LinkedList<hp> mvQ = new LinkedList();
    public String mvR;
    public me mvS;
    public are mvT;
    public int mvU;
    public LinkedList<ach> mvV = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.mQl != null) {
                aVar.dX(1, this.mQl.aHr());
                this.mQl.a(aVar);
            }
            if (this.mvK != null) {
                aVar.e(2, this.mvK);
            }
            if (this.mvL != null) {
                aVar.e(3, this.mvL);
            }
            aVar.dV(4, this.lZu);
            if (this.aXz != null) {
                aVar.e(5, this.aXz);
            }
            if (this.hQP != null) {
                aVar.e(6, this.hQP);
            }
            if (this.mvM != null) {
                aVar.dX(7, this.mvM.aHr());
                this.mvM.a(aVar);
            }
            if (this.mvN != null) {
                aVar.dX(8, this.mvN.aHr());
                this.mvN.a(aVar);
            }
            if (this.gln != null) {
                aVar.e(9, this.gln);
            }
            if (this.mvO != null) {
                aVar.e(15, this.mvO);
            }
            aVar.dV(16, this.mvP);
            aVar.d(17, 8, this.mvQ);
            if (this.mvR != null) {
                aVar.e(18, this.mvR);
            }
            if (this.SSID != null) {
                aVar.e(20, this.SSID);
            }
            if (this.lZj != null) {
                aVar.e(21, this.lZj);
            }
            if (this.mvS != null) {
                aVar.dX(22, this.mvS.aHr());
                this.mvS.a(aVar);
            }
            if (this.mvT != null) {
                aVar.dX(23, this.mvT.aHr());
                this.mvT.a(aVar);
            }
            aVar.dV(24, this.mvU);
            aVar.d(25, 8, this.mvV);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mvK != null) {
                r0 += a.a.a.b.b.a.f(2, this.mvK);
            }
            if (this.mvL != null) {
                r0 += a.a.a.b.b.a.f(3, this.mvL);
            }
            r0 += a.a.a.a.dS(4, this.lZu);
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(5, this.aXz);
            }
            if (this.hQP != null) {
                r0 += a.a.a.b.b.a.f(6, this.hQP);
            }
            if (this.mvM != null) {
                r0 += a.a.a.a.dU(7, this.mvM.aHr());
            }
            if (this.mvN != null) {
                r0 += a.a.a.a.dU(8, this.mvN.aHr());
            }
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(9, this.gln);
            }
            if (this.mvO != null) {
                r0 += a.a.a.b.b.a.f(15, this.mvO);
            }
            r0 = (r0 + a.a.a.a.dS(16, this.mvP)) + a.a.a.a.c(17, 8, this.mvQ);
            if (this.mvR != null) {
                r0 += a.a.a.b.b.a.f(18, this.mvR);
            }
            if (this.SSID != null) {
                r0 += a.a.a.b.b.a.f(20, this.SSID);
            }
            if (this.lZj != null) {
                r0 += a.a.a.b.b.a.f(21, this.lZj);
            }
            if (this.mvS != null) {
                r0 += a.a.a.a.dU(22, this.mvS.aHr());
            }
            if (this.mvT != null) {
                r0 += a.a.a.a.dU(23, this.mvT.aHr());
            }
            return (r0 + a.a.a.a.dS(24, this.mvU)) + a.a.a.a.c(25, 8, this.mvV);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mvQ.clear();
            this.mvV.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            rv rvVar = (rv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            com.tencent.mm.ba.a eoVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        rvVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    rvVar.mvK = aVar3.pMj.readString();
                    return 0;
                case 3:
                    rvVar.mvL = aVar3.pMj.readString();
                    return 0;
                case 4:
                    rvVar.lZu = aVar3.pMj.mH();
                    return 0;
                case 5:
                    rvVar.aXz = aVar3.pMj.readString();
                    return 0;
                case 6:
                    rvVar.hQP = aVar3.pMj.readString();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new adv();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        rvVar.mvM = eoVar;
                    }
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new rr();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        rvVar.mvN = eoVar;
                    }
                    return 0;
                case 9:
                    rvVar.gln = aVar3.pMj.readString();
                    return 0;
                case 15:
                    rvVar.mvO = aVar3.pMj.readString();
                    return 0;
                case 16:
                    rvVar.mvP = aVar3.pMj.mH();
                    return 0;
                case 17:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new hp();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        rvVar.mvQ.add(eoVar);
                    }
                    return 0;
                case k.MG /*18*/:
                    rvVar.mvR = aVar3.pMj.readString();
                    return 0;
                case 20:
                    rvVar.SSID = aVar3.pMj.readString();
                    return 0;
                case 21:
                    rvVar.lZj = aVar3.pMj.readString();
                    return 0;
                case k.MM /*22*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new me();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        rvVar.mvS = eoVar;
                    }
                    return 0;
                case k.Nb /*23*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        rvVar.mvT = eoVar;
                    }
                    return 0;
                case 24:
                    rvVar.mvU = aVar3.pMj.mH();
                    return 0;
                case 25:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new ach();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        rvVar.mvV.add(eoVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
