package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class yq extends aqx {
    public int hKq;
    public String hKr;
    public long mAA;
    public boolean mAB;
    public boolean mAC;
    public boolean mAD;
    public String mAE;
    public String mAF;
    public String mAG;
    public String mAH;
    public boolean mAI;
    public String mAt;
    public String mAu;
    public String mAv;
    public String mAw;
    public String mAx;
    public boolean mAy;
    public String mAz;

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
            if (this.mAt != null) {
                aVar.e(4, this.mAt);
            }
            if (this.mAu != null) {
                aVar.e(5, this.mAu);
            }
            if (this.mAv != null) {
                aVar.e(6, this.mAv);
            }
            if (this.mAw != null) {
                aVar.e(7, this.mAw);
            }
            if (this.mAx != null) {
                aVar.e(8, this.mAx);
            }
            aVar.ab(9, this.mAy);
            if (this.mAz != null) {
                aVar.e(10, this.mAz);
            }
            aVar.C(11, this.mAA);
            aVar.ab(12, this.mAB);
            aVar.ab(13, this.mAC);
            aVar.ab(14, this.mAD);
            if (this.mAE != null) {
                aVar.e(15, this.mAE);
            }
            if (this.mAF != null) {
                aVar.e(16, this.mAF);
            }
            if (this.mAG != null) {
                aVar.e(17, this.mAG);
            }
            if (this.mAH != null) {
                aVar.e(18, this.mAH);
            }
            aVar.ab(19, this.mAI);
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
            if (this.mAt != null) {
                r0 += a.a.a.b.b.a.f(4, this.mAt);
            }
            if (this.mAu != null) {
                r0 += a.a.a.b.b.a.f(5, this.mAu);
            }
            if (this.mAv != null) {
                r0 += a.a.a.b.b.a.f(6, this.mAv);
            }
            if (this.mAw != null) {
                r0 += a.a.a.b.b.a.f(7, this.mAw);
            }
            if (this.mAx != null) {
                r0 += a.a.a.b.b.a.f(8, this.mAx);
            }
            r0 += a.a.a.b.b.a.cw(9) + 1;
            if (this.mAz != null) {
                r0 += a.a.a.b.b.a.f(10, this.mAz);
            }
            r0 = (((r0 + a.a.a.a.B(11, this.mAA)) + (a.a.a.b.b.a.cw(12) + 1)) + (a.a.a.b.b.a.cw(13) + 1)) + (a.a.a.b.b.a.cw(14) + 1);
            if (this.mAE != null) {
                r0 += a.a.a.b.b.a.f(15, this.mAE);
            }
            if (this.mAF != null) {
                r0 += a.a.a.b.b.a.f(16, this.mAF);
            }
            if (this.mAG != null) {
                r0 += a.a.a.b.b.a.f(17, this.mAG);
            }
            if (this.mAH != null) {
                r0 += a.a.a.b.b.a.f(18, this.mAH);
            }
            return r0 + (a.a.a.b.b.a.cw(19) + 1);
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
            yq yqVar = (yq) objArr[1];
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
                        yqVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    yqVar.hKq = aVar3.pMj.mH();
                    return 0;
                case 3:
                    yqVar.hKr = aVar3.pMj.readString();
                    return 0;
                case 4:
                    yqVar.mAt = aVar3.pMj.readString();
                    return 0;
                case 5:
                    yqVar.mAu = aVar3.pMj.readString();
                    return 0;
                case 6:
                    yqVar.mAv = aVar3.pMj.readString();
                    return 0;
                case 7:
                    yqVar.mAw = aVar3.pMj.readString();
                    return 0;
                case 8:
                    yqVar.mAx = aVar3.pMj.readString();
                    return 0;
                case 9:
                    yqVar.mAy = aVar3.bQJ();
                    return 0;
                case 10:
                    yqVar.mAz = aVar3.pMj.readString();
                    return 0;
                case 11:
                    yqVar.mAA = aVar3.pMj.mI();
                    return 0;
                case 12:
                    yqVar.mAB = aVar3.bQJ();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    yqVar.mAC = aVar3.bQJ();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    yqVar.mAD = aVar3.bQJ();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    yqVar.mAE = aVar3.pMj.readString();
                    return 0;
                case 16:
                    yqVar.mAF = aVar3.pMj.readString();
                    return 0;
                case 17:
                    yqVar.mAG = aVar3.pMj.readString();
                    return 0;
                case 18:
                    yqVar.mAH = aVar3.pMj.readString();
                    return 0;
                case 19:
                    yqVar.mAI = aVar3.bQJ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
