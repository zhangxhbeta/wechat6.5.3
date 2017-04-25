package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class vt extends aqx {
    public are mcz;
    public int myh;
    public LinkedList<ol> myi = new LinkedList();
    public oa myj;
    public int myk;
    public LinkedList<oa> myl = new LinkedList();
    public int mym;
    public LinkedList<oe> myn = new LinkedList();
    public int myo;
    public LinkedList<oc> myp = new LinkedList();
    public int myq;
    public int myr;
    public int mys;
    public LinkedList<oc> myt = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mcz == null) {
                throw new b("Not all required fields were included: ReqBuf");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.mcz != null) {
                    aVar.dX(2, this.mcz.aHr());
                    this.mcz.a(aVar);
                }
                aVar.dV(3, this.myh);
                aVar.d(4, 8, this.myi);
                if (this.myj != null) {
                    aVar.dX(5, this.myj.aHr());
                    this.myj.a(aVar);
                }
                aVar.dV(6, this.myk);
                aVar.d(7, 8, this.myl);
                aVar.dV(8, this.mym);
                aVar.d(9, 8, this.myn);
                aVar.dV(10, this.myo);
                aVar.d(11, 8, this.myp);
                aVar.dV(12, this.myq);
                aVar.dV(13, this.myr);
                aVar.dV(14, this.mys);
                aVar.d(15, 8, this.myt);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mcz != null) {
                r0 += a.a.a.a.dU(2, this.mcz.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(3, this.myh)) + a.a.a.a.c(4, 8, this.myi);
            if (this.myj != null) {
                r0 += a.a.a.a.dU(5, this.myj.aHr());
            }
            return (((((((((r0 + a.a.a.a.dS(6, this.myk)) + a.a.a.a.c(7, 8, this.myl)) + a.a.a.a.dS(8, this.mym)) + a.a.a.a.c(9, 8, this.myn)) + a.a.a.a.dS(10, this.myo)) + a.a.a.a.c(11, 8, this.myp)) + a.a.a.a.dS(12, this.myq)) + a.a.a.a.dS(13, this.myr)) + a.a.a.a.dS(14, this.mys)) + a.a.a.a.c(15, 8, this.myt);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.myi.clear();
            this.myl.clear();
            this.myn.clear();
            this.myp.clear();
            this.myt.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mcz != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ReqBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            vt vtVar = (vt) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            oa oaVar;
            oc ocVar;
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
                        vtVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqx.a(aVar4))) {
                        }
                        vtVar.mcz = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    vtVar.myh = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ol olVar = new ol();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = olVar.a(aVar4, olVar, aqx.a(aVar4))) {
                        }
                        vtVar.myi.add(olVar);
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        oaVar = new oa();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = oaVar.a(aVar4, oaVar, aqx.a(aVar4))) {
                        }
                        vtVar.myj = oaVar;
                    }
                    return 0;
                case 6:
                    vtVar.myk = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        oaVar = new oa();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = oaVar.a(aVar4, oaVar, aqx.a(aVar4))) {
                        }
                        vtVar.myl.add(oaVar);
                    }
                    return 0;
                case 8:
                    vtVar.mym = aVar3.pMj.mH();
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        oe oeVar = new oe();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = oeVar.a(aVar4, oeVar, aqx.a(aVar4))) {
                        }
                        vtVar.myn.add(oeVar);
                    }
                    return 0;
                case 10:
                    vtVar.myo = aVar3.pMj.mH();
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ocVar = new oc();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ocVar.a(aVar4, ocVar, aqx.a(aVar4))) {
                        }
                        vtVar.myp.add(ocVar);
                    }
                    return 0;
                case 12:
                    vtVar.myq = aVar3.pMj.mH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    vtVar.myr = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    vtVar.mys = aVar3.pMj.mH();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ocVar = new oc();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ocVar.a(aVar4, ocVar, aqx.a(aVar4))) {
                        }
                        vtVar.myt.add(ocVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
