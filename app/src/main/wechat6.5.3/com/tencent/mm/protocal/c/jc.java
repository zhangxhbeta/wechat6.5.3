package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPausePlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.jsapi.y;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import java.util.LinkedList;

public final class jc extends a {
    public String aHM;
    public String bmJ;
    public String coN;
    public String eBK;
    public int eBL;
    public String eBM;
    public String eBN;
    public String eCC;
    public String eCD;
    public String hbX;
    public String mkK;
    public int mkL;
    public String mkM;
    public LinkedList<ld> mkN = new LinkedList();
    public LinkedList<ld> mkO = new LinkedList();
    public String mkP;
    public String mkQ;
    public int mkR;
    public String mkS;
    public String mkT;
    public int mkU;
    public String mkV;
    public String mkW;
    public long mkX;
    public String mkY;
    public String mkZ;
    public String mla;
    public iw mlb;
    public String mlc;
    public String mld;
    public int mle;
    public nd mlf;
    public bcv mlg;
    public qt mlh;
    public an mli;
    public int mlj;
    public int mlk;
    public String mll;
    public int mlm;
    public String mln;
    public int mlo;
    public ld mlp;
    public String mlq;
    public ld mlr;
    public String title;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.eBK != null) {
                aVar.e(1, this.eBK);
            }
            if (this.eBM != null) {
                aVar.e(2, this.eBM);
            }
            if (this.bmJ != null) {
                aVar.e(3, this.bmJ);
            }
            if (this.mkK != null) {
                aVar.e(4, this.mkK);
            }
            aVar.dV(5, this.mkL);
            aVar.dV(6, this.eBL);
            if (this.eCD != null) {
                aVar.e(7, this.eCD);
            }
            if (this.title != null) {
                aVar.e(8, this.title);
            }
            if (this.eBN != null) {
                aVar.e(9, this.eBN);
            }
            if (this.coN != null) {
                aVar.e(10, this.coN);
            }
            if (this.hbX != null) {
                aVar.e(11, this.hbX);
            }
            if (this.mkM != null) {
                aVar.e(12, this.mkM);
            }
            aVar.d(13, 8, this.mkN);
            aVar.d(14, 8, this.mkO);
            if (this.mkP != null) {
                aVar.e(15, this.mkP);
            }
            if (this.mkQ != null) {
                aVar.e(16, this.mkQ);
            }
            if (this.aHM != null) {
                aVar.e(17, this.aHM);
            }
            aVar.dV(18, this.mkR);
            if (this.eCC != null) {
                aVar.e(19, this.eCC);
            }
            if (this.mkS != null) {
                aVar.e(20, this.mkS);
            }
            if (this.mkT != null) {
                aVar.e(21, this.mkT);
            }
            aVar.dV(22, this.mkU);
            if (this.mkV != null) {
                aVar.e(23, this.mkV);
            }
            if (this.mkW != null) {
                aVar.e(24, this.mkW);
            }
            aVar.C(25, this.mkX);
            if (this.mkY != null) {
                aVar.e(26, this.mkY);
            }
            if (this.mkZ != null) {
                aVar.e(27, this.mkZ);
            }
            if (this.mla != null) {
                aVar.e(28, this.mla);
            }
            if (this.mlb != null) {
                aVar.dX(29, this.mlb.aHr());
                this.mlb.a(aVar);
            }
            if (this.mlc != null) {
                aVar.e(30, this.mlc);
            }
            if (this.mld != null) {
                aVar.e(31, this.mld);
            }
            aVar.dV(32, this.mle);
            if (this.mlf != null) {
                aVar.dX(33, this.mlf.aHr());
                this.mlf.a(aVar);
            }
            if (this.mlg != null) {
                aVar.dX(34, this.mlg.aHr());
                this.mlg.a(aVar);
            }
            if (this.mlh != null) {
                aVar.dX(35, this.mlh.aHr());
                this.mlh.a(aVar);
            }
            if (this.mli != null) {
                aVar.dX(36, this.mli.aHr());
                this.mli.a(aVar);
            }
            aVar.dV(37, this.mlj);
            aVar.dV(38, this.mlk);
            if (this.mll != null) {
                aVar.e(39, this.mll);
            }
            aVar.dV(40, this.mlm);
            if (this.mln != null) {
                aVar.e(41, this.mln);
            }
            aVar.dV(42, this.mlo);
            if (this.mlp != null) {
                aVar.dX(43, this.mlp.aHr());
                this.mlp.a(aVar);
            }
            if (this.mlq != null) {
                aVar.e(44, this.mlq);
            }
            if (this.mlr == null) {
                return 0;
            }
            aVar.dX(45, this.mlr.aHr());
            this.mlr.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.eBK != null) {
                r0 = a.a.a.b.b.a.f(1, this.eBK) + 0;
            } else {
                r0 = 0;
            }
            if (this.eBM != null) {
                r0 += a.a.a.b.b.a.f(2, this.eBM);
            }
            if (this.bmJ != null) {
                r0 += a.a.a.b.b.a.f(3, this.bmJ);
            }
            if (this.mkK != null) {
                r0 += a.a.a.b.b.a.f(4, this.mkK);
            }
            r0 = (r0 + a.a.a.a.dS(5, this.mkL)) + a.a.a.a.dS(6, this.eBL);
            if (this.eCD != null) {
                r0 += a.a.a.b.b.a.f(7, this.eCD);
            }
            if (this.title != null) {
                r0 += a.a.a.b.b.a.f(8, this.title);
            }
            if (this.eBN != null) {
                r0 += a.a.a.b.b.a.f(9, this.eBN);
            }
            if (this.coN != null) {
                r0 += a.a.a.b.b.a.f(10, this.coN);
            }
            if (this.hbX != null) {
                r0 += a.a.a.b.b.a.f(11, this.hbX);
            }
            if (this.mkM != null) {
                r0 += a.a.a.b.b.a.f(12, this.mkM);
            }
            r0 = (r0 + a.a.a.a.c(13, 8, this.mkN)) + a.a.a.a.c(14, 8, this.mkO);
            if (this.mkP != null) {
                r0 += a.a.a.b.b.a.f(15, this.mkP);
            }
            if (this.mkQ != null) {
                r0 += a.a.a.b.b.a.f(16, this.mkQ);
            }
            if (this.aHM != null) {
                r0 += a.a.a.b.b.a.f(17, this.aHM);
            }
            r0 += a.a.a.a.dS(18, this.mkR);
            if (this.eCC != null) {
                r0 += a.a.a.b.b.a.f(19, this.eCC);
            }
            if (this.mkS != null) {
                r0 += a.a.a.b.b.a.f(20, this.mkS);
            }
            if (this.mkT != null) {
                r0 += a.a.a.b.b.a.f(21, this.mkT);
            }
            r0 += a.a.a.a.dS(22, this.mkU);
            if (this.mkV != null) {
                r0 += a.a.a.b.b.a.f(23, this.mkV);
            }
            if (this.mkW != null) {
                r0 += a.a.a.b.b.a.f(24, this.mkW);
            }
            r0 += a.a.a.a.B(25, this.mkX);
            if (this.mkY != null) {
                r0 += a.a.a.b.b.a.f(26, this.mkY);
            }
            if (this.mkZ != null) {
                r0 += a.a.a.b.b.a.f(27, this.mkZ);
            }
            if (this.mla != null) {
                r0 += a.a.a.b.b.a.f(28, this.mla);
            }
            if (this.mlb != null) {
                r0 += a.a.a.a.dU(29, this.mlb.aHr());
            }
            if (this.mlc != null) {
                r0 += a.a.a.b.b.a.f(30, this.mlc);
            }
            if (this.mld != null) {
                r0 += a.a.a.b.b.a.f(31, this.mld);
            }
            r0 += a.a.a.a.dS(32, this.mle);
            if (this.mlf != null) {
                r0 += a.a.a.a.dU(33, this.mlf.aHr());
            }
            if (this.mlg != null) {
                r0 += a.a.a.a.dU(34, this.mlg.aHr());
            }
            if (this.mlh != null) {
                r0 += a.a.a.a.dU(35, this.mlh.aHr());
            }
            if (this.mli != null) {
                r0 += a.a.a.a.dU(36, this.mli.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(37, this.mlj)) + a.a.a.a.dS(38, this.mlk);
            if (this.mll != null) {
                r0 += a.a.a.b.b.a.f(39, this.mll);
            }
            r0 += a.a.a.a.dS(40, this.mlm);
            if (this.mln != null) {
                r0 += a.a.a.b.b.a.f(41, this.mln);
            }
            r0 += a.a.a.a.dS(42, this.mlo);
            if (this.mlp != null) {
                r0 += a.a.a.a.dU(43, this.mlp.aHr());
            }
            if (this.mlq != null) {
                r0 += a.a.a.b.b.a.f(44, this.mlq);
            }
            if (this.mlr != null) {
                r0 += a.a.a.a.dU(45, this.mlr.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mkN.clear();
            this.mkO.clear();
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
            jc jcVar = (jc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            ld ldVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    jcVar.eBK = aVar3.pMj.readString();
                    return 0;
                case 2:
                    jcVar.eBM = aVar3.pMj.readString();
                    return 0;
                case 3:
                    jcVar.bmJ = aVar3.pMj.readString();
                    return 0;
                case 4:
                    jcVar.mkK = aVar3.pMj.readString();
                    return 0;
                case 5:
                    jcVar.mkL = aVar3.pMj.mH();
                    return 0;
                case 6:
                    jcVar.eBL = aVar3.pMj.mH();
                    return 0;
                case 7:
                    jcVar.eCD = aVar3.pMj.readString();
                    return 0;
                case 8:
                    jcVar.title = aVar3.pMj.readString();
                    return 0;
                case 9:
                    jcVar.eBN = aVar3.pMj.readString();
                    return 0;
                case 10:
                    jcVar.coN = aVar3.pMj.readString();
                    return 0;
                case 11:
                    jcVar.hbX = aVar3.pMj.readString();
                    return 0;
                case 12:
                    jcVar.mkM = aVar3.pMj.readString();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ldVar = new ld();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ldVar.a(aVar4, ldVar, a.a(aVar4))) {
                        }
                        jcVar.mkN.add(ldVar);
                    }
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ldVar = new ld();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ldVar.a(aVar4, ldVar, a.a(aVar4))) {
                        }
                        jcVar.mkO.add(ldVar);
                    }
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    jcVar.mkP = aVar3.pMj.readString();
                    return 0;
                case 16:
                    jcVar.mkQ = aVar3.pMj.readString();
                    return 0;
                case 17:
                    jcVar.aHM = aVar3.pMj.readString();
                    return 0;
                case 18:
                    jcVar.mkR = aVar3.pMj.mH();
                    return 0;
                case 19:
                    jcVar.eCC = aVar3.pMj.readString();
                    return 0;
                case 20:
                    jcVar.mkS = aVar3.pMj.readString();
                    return 0;
                case 21:
                    jcVar.mkT = aVar3.pMj.readString();
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    jcVar.mkU = aVar3.pMj.mH();
                    return 0;
                case 23:
                    jcVar.mkV = aVar3.pMj.readString();
                    return 0;
                case 24:
                    jcVar.mkW = aVar3.pMj.readString();
                    return 0;
                case 25:
                    jcVar.mkX = aVar3.pMj.mI();
                    return 0;
                case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                    jcVar.mkY = aVar3.pMj.readString();
                    return 0;
                case bv.CTRL_INDEX /*27*/:
                    jcVar.mkZ = aVar3.pMj.readString();
                    return 0;
                case p.CTRL_INDEX /*28*/:
                    jcVar.mla = aVar3.pMj.readString();
                    return 0;
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        iw iwVar = new iw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = iwVar.a(aVar4, iwVar, a.a(aVar4))) {
                        }
                        jcVar.mlb = iwVar;
                    }
                    return 0;
                case 30:
                    jcVar.mlc = aVar3.pMj.readString();
                    return 0;
                case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    jcVar.mld = aVar3.pMj.readString();
                    return 0;
                case JsApiStopRecordVoice.CTRL_INDEX /*32*/:
                    jcVar.mle = aVar3.pMj.mH();
                    return 0;
                case JsApiStartPlayVoice.CTRL_INDEX /*33*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        nd ndVar = new nd();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ndVar.a(aVar4, ndVar, a.a(aVar4))) {
                        }
                        jcVar.mlf = ndVar;
                    }
                    return 0;
                case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bcv com_tencent_mm_protocal_c_bcv = new bcv();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bcv.a(aVar4, com_tencent_mm_protocal_c_bcv, a.a(aVar4))) {
                        }
                        jcVar.mlg = com_tencent_mm_protocal_c_bcv;
                    }
                    return 0;
                case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        qt qtVar = new qt();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = qtVar.a(aVar4, qtVar, a.a(aVar4))) {
                        }
                        jcVar.mlh = qtVar;
                    }
                    return 0;
                case JsApiChooseVideo.CTRL_INDEX /*36*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        an anVar = new an();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = anVar.a(aVar4, anVar, a.a(aVar4))) {
                        }
                        jcVar.mli = anVar;
                    }
                    return 0;
                case JsApiGetLocation.CTRL_INDEX /*37*/:
                    jcVar.mlj = aVar3.pMj.mH();
                    return 0;
                case aq.CTRL_INDEX /*38*/:
                    jcVar.mlk = aVar3.pMj.mH();
                    return 0;
                case y.CTRL_INDEX /*39*/:
                    jcVar.mll = aVar3.pMj.readString();
                    return 0;
                case 40:
                    jcVar.mlm = aVar3.pMj.mH();
                    return 0;
                case 41:
                    jcVar.mln = aVar3.pMj.readString();
                    return 0;
                case 42:
                    jcVar.mlo = aVar3.pMj.mH();
                    return 0;
                case 43:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ldVar = new ld();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ldVar.a(aVar4, ldVar, a.a(aVar4))) {
                        }
                        jcVar.mlp = ldVar;
                    }
                    return 0;
                case 44:
                    jcVar.mlq = aVar3.pMj.readString();
                    return 0;
                case 45:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ldVar = new ld();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ldVar.a(aVar4, ldVar, a.a(aVar4))) {
                        }
                        jcVar.mlr = ldVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
