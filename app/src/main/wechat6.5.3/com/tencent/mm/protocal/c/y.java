package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class y extends aqx {
    public qz lZA;
    public dq lZB;
    public String lZC;
    public String lZD;
    public int lZE;
    public int lZm;
    public String lZs;
    public int lZt;
    public int lZu;
    public String lZv;
    public auy lZw;
    public aqb lZx;
    public auy lZy;
    public aoj lZz;

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
            if (this.lZs != null) {
                aVar.e(2, this.lZs);
            }
            aVar.dV(3, this.lZt);
            aVar.dV(4, this.lZu);
            if (this.lZv != null) {
                aVar.e(5, this.lZv);
            }
            if (this.lZw != null) {
                aVar.dX(6, this.lZw.aHr());
                this.lZw.a(aVar);
            }
            aVar.dV(7, this.lZm);
            if (this.lZx != null) {
                aVar.dX(8, this.lZx.aHr());
                this.lZx.a(aVar);
            }
            if (this.lZy != null) {
                aVar.dX(9, this.lZy.aHr());
                this.lZy.a(aVar);
            }
            if (this.lZz != null) {
                aVar.dX(10, this.lZz.aHr());
                this.lZz.a(aVar);
            }
            if (this.lZA != null) {
                aVar.dX(11, this.lZA.aHr());
                this.lZA.a(aVar);
            }
            if (this.lZB != null) {
                aVar.dX(12, this.lZB.aHr());
                this.lZB.a(aVar);
            }
            if (this.lZC != null) {
                aVar.e(13, this.lZC);
            }
            if (this.lZD != null) {
                aVar.e(14, this.lZD);
            }
            aVar.dV(15, this.lZE);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.lZs != null) {
                r0 += a.a.a.b.b.a.f(2, this.lZs);
            }
            r0 = (r0 + a.a.a.a.dS(3, this.lZt)) + a.a.a.a.dS(4, this.lZu);
            if (this.lZv != null) {
                r0 += a.a.a.b.b.a.f(5, this.lZv);
            }
            if (this.lZw != null) {
                r0 += a.a.a.a.dU(6, this.lZw.aHr());
            }
            r0 += a.a.a.a.dS(7, this.lZm);
            if (this.lZx != null) {
                r0 += a.a.a.a.dU(8, this.lZx.aHr());
            }
            if (this.lZy != null) {
                r0 += a.a.a.a.dU(9, this.lZy.aHr());
            }
            if (this.lZz != null) {
                r0 += a.a.a.a.dU(10, this.lZz.aHr());
            }
            if (this.lZA != null) {
                r0 += a.a.a.a.dU(11, this.lZA.aHr());
            }
            if (this.lZB != null) {
                r0 += a.a.a.a.dU(12, this.lZB.aHr());
            }
            if (this.lZC != null) {
                r0 += a.a.a.b.b.a.f(13, this.lZC);
            }
            if (this.lZD != null) {
                r0 += a.a.a.b.b.a.f(14, this.lZD);
            }
            return r0 + a.a.a.a.dS(15, this.lZE);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
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
            y yVar = (y) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            auy com_tencent_mm_protocal_c_auy;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        yVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    yVar.lZs = aVar3.pMj.readString();
                    return 0;
                case 3:
                    yVar.lZt = aVar3.pMj.mH();
                    return 0;
                case 4:
                    yVar.lZu = aVar3.pMj.mH();
                    return 0;
                case 5:
                    yVar.lZv = aVar3.pMj.readString();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_auy = new auy();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_auy.a(aVar4, com_tencent_mm_protocal_c_auy, aqx.a(aVar4))) {
                        }
                        yVar.lZw = com_tencent_mm_protocal_c_auy;
                    }
                    return 0;
                case 7:
                    yVar.lZm = aVar3.pMj.mH();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        aqb com_tencent_mm_protocal_c_aqb = new aqb();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aqb.a(aVar4, com_tencent_mm_protocal_c_aqb, aqx.a(aVar4))) {
                        }
                        yVar.lZx = com_tencent_mm_protocal_c_aqb;
                    }
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_auy = new auy();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_auy.a(aVar4, com_tencent_mm_protocal_c_auy, aqx.a(aVar4))) {
                        }
                        yVar.lZy = com_tencent_mm_protocal_c_auy;
                    }
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        aoj com_tencent_mm_protocal_c_aoj = new aoj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aoj.a(aVar4, com_tencent_mm_protocal_c_aoj, aqx.a(aVar4))) {
                        }
                        yVar.lZz = com_tencent_mm_protocal_c_aoj;
                    }
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        qz qzVar = new qz();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = qzVar.a(aVar4, qzVar, aqx.a(aVar4))) {
                        }
                        yVar.lZA = qzVar;
                    }
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        dq dqVar = new dq();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = dqVar.a(aVar4, dqVar, aqx.a(aVar4))) {
                        }
                        yVar.lZB = dqVar;
                    }
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    yVar.lZC = aVar3.pMj.readString();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    yVar.lZD = aVar3.pMj.readString();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    yVar.lZE = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
