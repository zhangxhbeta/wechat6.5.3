package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import java.util.LinkedList;

public final class t extends aqx {
    public int cqN;
    public int hKq = 268513600;
    public String hKr = "请求不成功，请稍候再试";
    public LinkedList<r> lYB = new LinkedList();
    public String lYR;
    public long lYS;
    public int lYT;
    public long lYU;
    public int lYV;
    public int lYW;
    public int lYX;
    public int lYY;
    public long lYZ;
    public String lYw;
    public long lZa;
    public long lZb;
    public int lZc;
    public String lZd;
    public String lZe;
    public int lZf;
    public int state;
    public String title;
    public int type;

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
            aVar.dV(2, this.hKq);
            if (this.hKr != null) {
                aVar.e(3, this.hKr);
            }
            if (this.lYw != null) {
                aVar.e(4, this.lYw);
            }
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            aVar.dV(6, this.type);
            if (this.lYR != null) {
                aVar.e(7, this.lYR);
            }
            aVar.C(8, this.lYS);
            aVar.dV(9, this.lYT);
            aVar.C(10, this.lYU);
            aVar.dV(11, this.lYV);
            aVar.dV(12, this.state);
            aVar.dV(13, this.lYW);
            aVar.dV(14, this.lYX);
            aVar.dV(15, this.cqN);
            aVar.dV(16, this.lYY);
            aVar.C(17, this.lYZ);
            aVar.C(18, this.lZa);
            aVar.C(19, this.lZb);
            aVar.dV(20, this.lZc);
            if (this.lZd != null) {
                aVar.e(21, this.lZd);
            }
            aVar.d(22, 8, this.lYB);
            if (this.lZe != null) {
                aVar.e(23, this.lZe);
            }
            aVar.dV(24, this.lZf);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.hKq);
            if (this.hKr != null) {
                r0 += a.a.a.b.b.a.f(3, this.hKr);
            }
            if (this.lYw != null) {
                r0 += a.a.a.b.b.a.f(4, this.lYw);
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(5, this.title);
            }
            r0 += a.a.a.a.dS(6, this.type);
            if (this.lYR != null) {
                r0 += a.a.a.b.b.a.f(7, this.lYR);
            }
            r0 = ((((((((((((r0 + a.a.a.a.B(8, this.lYS)) + a.a.a.a.dS(9, this.lYT)) + a.a.a.a.B(10, this.lYU)) + a.a.a.a.dS(11, this.lYV)) + a.a.a.a.dS(12, this.state)) + a.a.a.a.dS(13, this.lYW)) + a.a.a.a.dS(14, this.lYX)) + a.a.a.a.dS(15, this.cqN)) + a.a.a.a.dS(16, this.lYY)) + a.a.a.a.B(17, this.lYZ)) + a.a.a.a.B(18, this.lZa)) + a.a.a.a.B(19, this.lZb)) + a.a.a.a.dS(20, this.lZc);
            if (this.lZd != null) {
                r0 += a.a.a.b.b.a.f(21, this.lZd);
            }
            r0 += a.a.a.a.c(22, 8, this.lYB);
            if (this.lZe != null) {
                r0 += a.a.a.b.b.a.f(23, this.lZe);
            }
            return r0 + a.a.a.a.dS(24, this.lZf);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.lYB.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            t tVar = (t) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eo eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, aqx.a(aVar4))) {
                        }
                        tVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    tVar.hKq = aVar3.pMj.mH();
                    return 0;
                case 3:
                    tVar.hKr = aVar3.pMj.readString();
                    return 0;
                case 4:
                    tVar.lYw = aVar3.pMj.readString();
                    return 0;
                case 5:
                    tVar.title = aVar3.pMj.readString();
                    return 0;
                case 6:
                    tVar.type = aVar3.pMj.mH();
                    return 0;
                case 7:
                    tVar.lYR = aVar3.pMj.readString();
                    return 0;
                case 8:
                    tVar.lYS = aVar3.pMj.mI();
                    return 0;
                case 9:
                    tVar.lYT = aVar3.pMj.mH();
                    return 0;
                case 10:
                    tVar.lYU = aVar3.pMj.mI();
                    return 0;
                case 11:
                    tVar.lYV = aVar3.pMj.mH();
                    return 0;
                case 12:
                    tVar.state = aVar3.pMj.mH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    tVar.lYW = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    tVar.lYX = aVar3.pMj.mH();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    tVar.cqN = aVar3.pMj.mH();
                    return 0;
                case 16:
                    tVar.lYY = aVar3.pMj.mH();
                    return 0;
                case 17:
                    tVar.lYZ = aVar3.pMj.mI();
                    return 0;
                case 18:
                    tVar.lZa = aVar3.pMj.mI();
                    return 0;
                case 19:
                    tVar.lZb = aVar3.pMj.mI();
                    return 0;
                case 20:
                    tVar.lZc = aVar3.pMj.mH();
                    return 0;
                case 21:
                    tVar.lZd = aVar3.pMj.readString();
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        r rVar = new r();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = rVar.a(aVar4, rVar, aqx.a(aVar4))) {
                        }
                        tVar.lYB.add(rVar);
                    }
                    return 0;
                case 23:
                    tVar.lZe = aVar3.pMj.readString();
                    return 0;
                case 24:
                    tVar.lZf = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
