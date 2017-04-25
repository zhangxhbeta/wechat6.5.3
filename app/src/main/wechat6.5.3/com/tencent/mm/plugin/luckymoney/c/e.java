package com.tencent.mm.plugin.luckymoney.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import java.util.LinkedList;

public final class e extends a {
    public long bst;
    public String haA;
    public String haB;
    public String haC;
    public String haD;
    public long haE;
    public long haF;
    public int haG;
    public long haH;
    public String haI;
    public int haJ;
    public int haK;
    public int haL;
    public String haM;
    public int haN;
    public int haO;
    public a haP;
    public int haQ;
    public String haR;
    public LinkedList<ag> haS = new LinkedList();
    public ag haT;
    public String haU;
    public String haV;
    public int haW;
    public String haX;
    public LinkedList<m> haY = new LinkedList();
    public String haZ;
    public int hau;
    public int hav;
    public String haw;
    public String hax;
    public String hay;
    public String haz;
    public String hba;
    public int resourceId;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.hau);
            aVar.dV(2, this.hav);
            if (this.haw != null) {
                aVar.e(3, this.haw);
            }
            if (this.hax != null) {
                aVar.e(4, this.hax);
            }
            if (this.hay != null) {
                aVar.e(5, this.hay);
            }
            if (this.haz != null) {
                aVar.e(6, this.haz);
            }
            if (this.haA != null) {
                aVar.e(7, this.haA);
            }
            if (this.haB != null) {
                aVar.e(8, this.haB);
            }
            if (this.haC != null) {
                aVar.e(9, this.haC);
            }
            if (this.haD != null) {
                aVar.e(10, this.haD);
            }
            aVar.C(11, this.bst);
            aVar.C(12, this.haE);
            aVar.C(13, this.haF);
            aVar.dV(14, this.haG);
            aVar.C(15, this.haH);
            if (this.haI != null) {
                aVar.e(16, this.haI);
            }
            aVar.dV(17, this.haJ);
            aVar.dV(18, this.haK);
            aVar.dV(19, this.haL);
            if (this.haM != null) {
                aVar.e(20, this.haM);
            }
            aVar.dV(21, this.haN);
            aVar.dV(22, this.haO);
            if (this.haP != null) {
                aVar.dX(23, this.haP.aHr());
                this.haP.a(aVar);
            }
            aVar.dV(24, this.haQ);
            if (this.haR != null) {
                aVar.e(25, this.haR);
            }
            aVar.d(26, 8, this.haS);
            if (this.haT != null) {
                aVar.dX(27, this.haT.aHr());
                this.haT.a(aVar);
            }
            if (this.haU != null) {
                aVar.e(28, this.haU);
            }
            if (this.haV != null) {
                aVar.e(29, this.haV);
            }
            aVar.dV(30, this.haW);
            aVar.dV(31, this.resourceId);
            if (this.haX != null) {
                aVar.e(32, this.haX);
            }
            aVar.d(33, 8, this.haY);
            if (this.haZ != null) {
                aVar.e(34, this.haZ);
            }
            if (this.hba != null) {
                aVar.e(35, this.hba);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.dS(1, this.hau) + 0) + a.a.a.a.dS(2, this.hav);
            if (this.haw != null) {
                r0 += a.a.a.b.b.a.f(3, this.haw);
            }
            if (this.hax != null) {
                r0 += a.a.a.b.b.a.f(4, this.hax);
            }
            if (this.hay != null) {
                r0 += a.a.a.b.b.a.f(5, this.hay);
            }
            if (this.haz != null) {
                r0 += a.a.a.b.b.a.f(6, this.haz);
            }
            if (this.haA != null) {
                r0 += a.a.a.b.b.a.f(7, this.haA);
            }
            if (this.haB != null) {
                r0 += a.a.a.b.b.a.f(8, this.haB);
            }
            if (this.haC != null) {
                r0 += a.a.a.b.b.a.f(9, this.haC);
            }
            if (this.haD != null) {
                r0 += a.a.a.b.b.a.f(10, this.haD);
            }
            r0 = ((((r0 + a.a.a.a.B(11, this.bst)) + a.a.a.a.B(12, this.haE)) + a.a.a.a.B(13, this.haF)) + a.a.a.a.dS(14, this.haG)) + a.a.a.a.B(15, this.haH);
            if (this.haI != null) {
                r0 += a.a.a.b.b.a.f(16, this.haI);
            }
            r0 = ((r0 + a.a.a.a.dS(17, this.haJ)) + a.a.a.a.dS(18, this.haK)) + a.a.a.a.dS(19, this.haL);
            if (this.haM != null) {
                r0 += a.a.a.b.b.a.f(20, this.haM);
            }
            r0 = (r0 + a.a.a.a.dS(21, this.haN)) + a.a.a.a.dS(22, this.haO);
            if (this.haP != null) {
                r0 += a.a.a.a.dU(23, this.haP.aHr());
            }
            r0 += a.a.a.a.dS(24, this.haQ);
            if (this.haR != null) {
                r0 += a.a.a.b.b.a.f(25, this.haR);
            }
            r0 += a.a.a.a.c(26, 8, this.haS);
            if (this.haT != null) {
                r0 += a.a.a.a.dU(27, this.haT.aHr());
            }
            if (this.haU != null) {
                r0 += a.a.a.b.b.a.f(28, this.haU);
            }
            if (this.haV != null) {
                r0 += a.a.a.b.b.a.f(29, this.haV);
            }
            r0 = (r0 + a.a.a.a.dS(30, this.haW)) + a.a.a.a.dS(31, this.resourceId);
            if (this.haX != null) {
                r0 += a.a.a.b.b.a.f(32, this.haX);
            }
            r0 += a.a.a.a.c(33, 8, this.haY);
            if (this.haZ != null) {
                r0 += a.a.a.b.b.a.f(34, this.haZ);
            }
            if (this.hba != null) {
                return r0 + a.a.a.b.b.a.f(35, this.hba);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.haS.clear();
            this.haY.clear();
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
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            ag agVar;
            switch (intValue) {
                case 1:
                    eVar.hau = aVar3.pMj.mH();
                    return 0;
                case 2:
                    eVar.hav = aVar3.pMj.mH();
                    return 0;
                case 3:
                    eVar.haw = aVar3.pMj.readString();
                    return 0;
                case 4:
                    eVar.hax = aVar3.pMj.readString();
                    return 0;
                case 5:
                    eVar.hay = aVar3.pMj.readString();
                    return 0;
                case 6:
                    eVar.haz = aVar3.pMj.readString();
                    return 0;
                case 7:
                    eVar.haA = aVar3.pMj.readString();
                    return 0;
                case 8:
                    eVar.haB = aVar3.pMj.readString();
                    return 0;
                case 9:
                    eVar.haC = aVar3.pMj.readString();
                    return 0;
                case 10:
                    eVar.haD = aVar3.pMj.readString();
                    return 0;
                case 11:
                    eVar.bst = aVar3.pMj.mI();
                    return 0;
                case 12:
                    eVar.haE = aVar3.pMj.mI();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    eVar.haF = aVar3.pMj.mI();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    eVar.haG = aVar3.pMj.mH();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    eVar.haH = aVar3.pMj.mI();
                    return 0;
                case 16:
                    eVar.haI = aVar3.pMj.readString();
                    return 0;
                case 17:
                    eVar.haJ = aVar3.pMj.mH();
                    return 0;
                case 18:
                    eVar.haK = aVar3.pMj.mH();
                    return 0;
                case 19:
                    eVar.haL = aVar3.pMj.mH();
                    return 0;
                case 20:
                    eVar.haM = aVar3.pMj.readString();
                    return 0;
                case 21:
                    eVar.haN = aVar3.pMj.mH();
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    eVar.haO = aVar3.pMj.mH();
                    return 0;
                case 23:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        a aVar5 = new a();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = aVar5.a(aVar4, aVar5, a.a(aVar4))) {
                        }
                        eVar.haP = aVar5;
                    }
                    return 0;
                case 24:
                    eVar.haQ = aVar3.pMj.mH();
                    return 0;
                case 25:
                    eVar.haR = aVar3.pMj.readString();
                    return 0;
                case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        agVar = new ag();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = agVar.a(aVar4, agVar, a.a(aVar4))) {
                        }
                        eVar.haS.add(agVar);
                    }
                    return 0;
                case bv.CTRL_INDEX /*27*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        agVar = new ag();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = agVar.a(aVar4, agVar, a.a(aVar4))) {
                        }
                        eVar.haT = agVar;
                    }
                    return 0;
                case p.CTRL_INDEX /*28*/:
                    eVar.haU = aVar3.pMj.readString();
                    return 0;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    eVar.haV = aVar3.pMj.readString();
                    return 0;
                case 30:
                    eVar.haW = aVar3.pMj.mH();
                    return 0;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    eVar.resourceId = aVar3.pMj.mH();
                    return 0;
                case JsApiStopRecordVoice.CTRL_INDEX /*32*/:
                    eVar.haX = aVar3.pMj.readString();
                    return 0;
                case JsApiStartPlayVoice.CTRL_INDEX /*33*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        m mVar = new m();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = mVar.a(aVar4, mVar, a.a(aVar4))) {
                        }
                        eVar.haY.add(mVar);
                    }
                    return 0;
                case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
                    eVar.haZ = aVar3.pMj.readString();
                    return 0;
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    eVar.hba = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
