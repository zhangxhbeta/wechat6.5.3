package com.tencent.mm.plugin.exdevice.e;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class g extends j {
    public String eeB;
    public int fvG;
    public int fvH;
    public int fvI;
    public int fvJ;
    public int fvK;
    public String fvL;
    public int fvM;
    public String fvN;
    public int fvO;
    public int fvP;
    public String fvQ;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.fvT == null) {
                throw new b("Not all required fields were included: BaseResponse");
            }
            if (this.fvT != null) {
                aVar.dX(1, this.fvT.aHr());
                this.fvT.a(aVar);
            }
            aVar.dV(2, this.fvG);
            aVar.dV(3, this.fvH);
            aVar.dV(4, this.fvI);
            aVar.dV(5, this.fvJ);
            aVar.dV(6, this.fvK);
            if (this.fvL != null) {
                aVar.e(11, this.fvL);
            }
            aVar.dV(12, this.fvM);
            if (this.eeB != null) {
                aVar.e(13, this.eeB);
            }
            if (this.fvN != null) {
                aVar.e(14, this.fvN);
            }
            aVar.dV(15, this.fvO);
            aVar.dV(16, this.fvP);
            if (this.fvQ == null) {
                return 0;
            }
            aVar.e(17, this.fvQ);
            return 0;
        } else if (i == 1) {
            if (this.fvT != null) {
                r0 = a.a.a.a.dU(1, this.fvT.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + a.a.a.a.dS(2, this.fvG)) + a.a.a.a.dS(3, this.fvH)) + a.a.a.a.dS(4, this.fvI)) + a.a.a.a.dS(5, this.fvJ)) + a.a.a.a.dS(6, this.fvK);
            if (this.fvL != null) {
                r0 += a.a.a.b.b.a.f(11, this.fvL);
            }
            r0 += a.a.a.a.dS(12, this.fvM);
            if (this.eeB != null) {
                r0 += a.a.a.b.b.a.f(13, this.eeB);
            }
            if (this.fvN != null) {
                r0 += a.a.a.b.b.a.f(14, this.fvN);
            }
            r0 = (r0 + a.a.a.a.dS(15, this.fvO)) + a.a.a.a.dS(16, this.fvP);
            if (this.fvQ != null) {
                r0 += a.a.a.b.b.a.f(17, this.fvQ);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = j.a(aVar2); r0 > 0; r0 = j.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.fvT != null) {
                return 0;
            }
            throw new b("Not all required fields were included: BaseResponse");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            g gVar = (g) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        e eVar = new e();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = eVar.a(aVar4, eVar, j.a(aVar4))) {
                        }
                        gVar.fvT = eVar;
                    }
                    return 0;
                case 2:
                    gVar.fvG = aVar3.pMj.mH();
                    return 0;
                case 3:
                    gVar.fvH = aVar3.pMj.mH();
                    return 0;
                case 4:
                    gVar.fvI = aVar3.pMj.mH();
                    return 0;
                case 5:
                    gVar.fvJ = aVar3.pMj.mH();
                    return 0;
                case 6:
                    gVar.fvK = aVar3.pMj.mH();
                    return 0;
                case 11:
                    gVar.fvL = aVar3.pMj.readString();
                    return 0;
                case 12:
                    gVar.fvM = aVar3.pMj.mH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    gVar.eeB = aVar3.pMj.readString();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    gVar.fvN = aVar3.pMj.readString();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    gVar.fvO = aVar3.pMj.mH();
                    return 0;
                case 16:
                    gVar.fvP = aVar3.pMj.mH();
                    return 0;
                case 17:
                    gVar.fvQ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
