package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class gf extends aqx {
    public String bax;
    public int may;
    public String mdw;
    public aux mef;
    public String meg;
    public String mgG;
    public int mgH;
    public String mgI;
    public acg mgJ;
    public hu mgK;
    public ajs mgL;
    public String mgM;
    public int mgN;
    public ari mgO;
    public String mgP;
    public String mgQ;

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
            if (this.bax != null) {
                aVar.e(2, this.bax);
            }
            if (this.mgG != null) {
                aVar.e(3, this.mgG);
            }
            aVar.dV(4, this.mgH);
            if (this.mgI != null) {
                aVar.e(5, this.mgI);
            }
            if (this.mdw != null) {
                aVar.e(6, this.mdw);
            }
            if (this.mgJ != null) {
                aVar.dX(7, this.mgJ.aHr());
                this.mgJ.a(aVar);
            }
            if (this.mgK != null) {
                aVar.dX(8, this.mgK.aHr());
                this.mgK.a(aVar);
            }
            if (this.mgL != null) {
                aVar.dX(9, this.mgL.aHr());
                this.mgL.a(aVar);
            }
            if (this.meg != null) {
                aVar.e(10, this.meg);
            }
            aVar.dV(11, this.may);
            if (this.mgM != null) {
                aVar.e(12, this.mgM);
            }
            aVar.dV(13, this.mgN);
            if (this.mgO != null) {
                aVar.dX(14, this.mgO.aHr());
                this.mgO.a(aVar);
            }
            if (this.mgP != null) {
                aVar.e(15, this.mgP);
            }
            if (this.mgQ != null) {
                aVar.e(16, this.mgQ);
            }
            if (this.mef == null) {
                return 0;
            }
            aVar.dX(17, this.mef.aHr());
            this.mef.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.bax != null) {
                r0 += a.a.a.b.b.a.f(2, this.bax);
            }
            if (this.mgG != null) {
                r0 += a.a.a.b.b.a.f(3, this.mgG);
            }
            r0 += a.a.a.a.dS(4, this.mgH);
            if (this.mgI != null) {
                r0 += a.a.a.b.b.a.f(5, this.mgI);
            }
            if (this.mdw != null) {
                r0 += a.a.a.b.b.a.f(6, this.mdw);
            }
            if (this.mgJ != null) {
                r0 += a.a.a.a.dU(7, this.mgJ.aHr());
            }
            if (this.mgK != null) {
                r0 += a.a.a.a.dU(8, this.mgK.aHr());
            }
            if (this.mgL != null) {
                r0 += a.a.a.a.dU(9, this.mgL.aHr());
            }
            if (this.meg != null) {
                r0 += a.a.a.b.b.a.f(10, this.meg);
            }
            r0 += a.a.a.a.dS(11, this.may);
            if (this.mgM != null) {
                r0 += a.a.a.b.b.a.f(12, this.mgM);
            }
            r0 += a.a.a.a.dS(13, this.mgN);
            if (this.mgO != null) {
                r0 += a.a.a.a.dU(14, this.mgO.aHr());
            }
            if (this.mgP != null) {
                r0 += a.a.a.b.b.a.f(15, this.mgP);
            }
            if (this.mgQ != null) {
                r0 += a.a.a.b.b.a.f(16, this.mgQ);
            }
            if (this.mef != null) {
                r0 += a.a.a.a.dU(17, this.mef.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            gf gfVar = (gf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a eoVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        gfVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    gfVar.bax = aVar3.pMj.readString();
                    return 0;
                case 3:
                    gfVar.mgG = aVar3.pMj.readString();
                    return 0;
                case 4:
                    gfVar.mgH = aVar3.pMj.mH();
                    return 0;
                case 5:
                    gfVar.mgI = aVar3.pMj.readString();
                    return 0;
                case 6:
                    gfVar.mdw = aVar3.pMj.readString();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new acg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        gfVar.mgJ = eoVar;
                    }
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new hu();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        gfVar.mgK = eoVar;
                    }
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new ajs();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        gfVar.mgL = eoVar;
                    }
                    return 0;
                case 10:
                    gfVar.meg = aVar3.pMj.readString();
                    return 0;
                case 11:
                    gfVar.may = aVar3.pMj.mH();
                    return 0;
                case 12:
                    gfVar.mgM = aVar3.pMj.readString();
                    return 0;
                case 13:
                    gfVar.mgN = aVar3.pMj.mH();
                    return 0;
                case 14:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new ari();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        gfVar.mgO = eoVar;
                    }
                    return 0;
                case 15:
                    gfVar.mgP = aVar3.pMj.readString();
                    return 0;
                case 16:
                    gfVar.mgQ = aVar3.pMj.readString();
                    return 0;
                case 17:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new aux();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        gfVar.mef = eoVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
