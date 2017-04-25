package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import java.util.LinkedList;

public final class wz extends aqx {
    public String bom;
    public String coN;
    public String eBK;
    public String eBM;
    public String eBN;
    public String eBO;
    public int eBR;
    public String eCD;
    public int iOK;
    public String iOL;
    public String iOM;
    public String iON;
    public String iOP;
    public boolean iOQ;
    public boolean mzf;
    public boolean mzg;
    public String mzh;
    public String mzi;
    public int mzj;
    public String mzk;
    public int mzl;
    public String mzm;
    public String title;

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
            aVar.ab(2, this.mzf);
            aVar.ab(3, this.mzg);
            if (this.mzh != null) {
                aVar.e(4, this.mzh);
            }
            if (this.mzi != null) {
                aVar.e(5, this.mzi);
            }
            aVar.dV(6, this.mzj);
            if (this.mzk != null) {
                aVar.e(7, this.mzk);
            }
            aVar.dV(8, this.mzl);
            if (this.eBK != null) {
                aVar.e(9, this.eBK);
            }
            if (this.bom != null) {
                aVar.e(10, this.bom);
            }
            if (this.title != null) {
                aVar.e(11, this.title);
            }
            if (this.eBN != null) {
                aVar.e(12, this.eBN);
            }
            if (this.eBO != null) {
                aVar.e(13, this.eBO);
            }
            if (this.eCD != null) {
                aVar.e(14, this.eCD);
            }
            if (this.eBM != null) {
                aVar.e(15, this.eBM);
            }
            if (this.coN != null) {
                aVar.e(16, this.coN);
            }
            aVar.dV(17, this.iOK);
            if (this.iOL != null) {
                aVar.e(18, this.iOL);
            }
            if (this.iOM != null) {
                aVar.e(19, this.iOM);
            }
            if (this.iON != null) {
                aVar.e(20, this.iON);
            }
            aVar.dV(21, this.eBR);
            if (this.iOP != null) {
                aVar.e(22, this.iOP);
            }
            if (this.mzm != null) {
                aVar.e(23, this.mzm);
            }
            aVar.ab(24, this.iOQ);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + (a.a.a.b.b.a.cw(2) + 1)) + (a.a.a.b.b.a.cw(3) + 1);
            if (this.mzh != null) {
                r0 += a.a.a.b.b.a.f(4, this.mzh);
            }
            if (this.mzi != null) {
                r0 += a.a.a.b.b.a.f(5, this.mzi);
            }
            r0 += a.a.a.a.dS(6, this.mzj);
            if (this.mzk != null) {
                r0 += a.a.a.b.b.a.f(7, this.mzk);
            }
            r0 += a.a.a.a.dS(8, this.mzl);
            if (this.eBK != null) {
                r0 += a.a.a.b.b.a.f(9, this.eBK);
            }
            if (this.bom != null) {
                r0 += a.a.a.b.b.a.f(10, this.bom);
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(11, this.title);
            }
            if (this.eBN != null) {
                r0 += a.a.a.b.b.a.f(12, this.eBN);
            }
            if (this.eBO != null) {
                r0 += a.a.a.b.b.a.f(13, this.eBO);
            }
            if (this.eCD != null) {
                r0 += a.a.a.b.b.a.f(14, this.eCD);
            }
            if (this.eBM != null) {
                r0 += a.a.a.b.b.a.f(15, this.eBM);
            }
            if (this.coN != null) {
                r0 += a.a.a.b.b.a.f(16, this.coN);
            }
            r0 += a.a.a.a.dS(17, this.iOK);
            if (this.iOL != null) {
                r0 += a.a.a.b.b.a.f(18, this.iOL);
            }
            if (this.iOM != null) {
                r0 += a.a.a.b.b.a.f(19, this.iOM);
            }
            if (this.iON != null) {
                r0 += a.a.a.b.b.a.f(20, this.iON);
            }
            r0 += a.a.a.a.dS(21, this.eBR);
            if (this.iOP != null) {
                r0 += a.a.a.b.b.a.f(22, this.iOP);
            }
            if (this.mzm != null) {
                r0 += a.a.a.b.b.a.f(23, this.mzm);
            }
            return r0 + (a.a.a.b.b.a.cw(24) + 1);
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
            wz wzVar = (wz) objArr[1];
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
                        wzVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    wzVar.mzf = aVar3.bQJ();
                    return 0;
                case 3:
                    wzVar.mzg = aVar3.bQJ();
                    return 0;
                case 4:
                    wzVar.mzh = aVar3.pMj.readString();
                    return 0;
                case 5:
                    wzVar.mzi = aVar3.pMj.readString();
                    return 0;
                case 6:
                    wzVar.mzj = aVar3.pMj.mH();
                    return 0;
                case 7:
                    wzVar.mzk = aVar3.pMj.readString();
                    return 0;
                case 8:
                    wzVar.mzl = aVar3.pMj.mH();
                    return 0;
                case 9:
                    wzVar.eBK = aVar3.pMj.readString();
                    return 0;
                case 10:
                    wzVar.bom = aVar3.pMj.readString();
                    return 0;
                case 11:
                    wzVar.title = aVar3.pMj.readString();
                    return 0;
                case 12:
                    wzVar.eBN = aVar3.pMj.readString();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    wzVar.eBO = aVar3.pMj.readString();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    wzVar.eCD = aVar3.pMj.readString();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    wzVar.eBM = aVar3.pMj.readString();
                    return 0;
                case 16:
                    wzVar.coN = aVar3.pMj.readString();
                    return 0;
                case 17:
                    wzVar.iOK = aVar3.pMj.mH();
                    return 0;
                case 18:
                    wzVar.iOL = aVar3.pMj.readString();
                    return 0;
                case 19:
                    wzVar.iOM = aVar3.pMj.readString();
                    return 0;
                case 20:
                    wzVar.iON = aVar3.pMj.readString();
                    return 0;
                case 21:
                    wzVar.eBR = aVar3.pMj.mH();
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    wzVar.iOP = aVar3.pMj.readString();
                    return 0;
                case 23:
                    wzVar.mzm = aVar3.pMj.readString();
                    return 0;
                case 24:
                    wzVar.iOQ = aVar3.bQJ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
