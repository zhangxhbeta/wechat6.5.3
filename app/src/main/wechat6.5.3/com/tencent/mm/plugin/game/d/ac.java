package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.eo;
import java.util.LinkedList;

public final class ac extends aqx {
    public String glU;
    public String glV;
    public at glW;
    public at glX;
    public av glY;
    public bq glZ;
    public cd gma;
    public w gmb;
    public bj gmc;
    public bc gmd;
    public l gme;
    public String gmf;
    public e gmg;
    public au gmh;
    public t gmi;
    public String gmj;
    public int gmk;
    public at gml;
    public an gmm;

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
            if (this.glU != null) {
                aVar.e(2, this.glU);
            }
            if (this.glV != null) {
                aVar.e(3, this.glV);
            }
            if (this.glW != null) {
                aVar.dX(4, this.glW.aHr());
                this.glW.a(aVar);
            }
            if (this.glX != null) {
                aVar.dX(5, this.glX.aHr());
                this.glX.a(aVar);
            }
            if (this.glY != null) {
                aVar.dX(6, this.glY.aHr());
                this.glY.a(aVar);
            }
            if (this.glZ != null) {
                aVar.dX(7, this.glZ.aHr());
                this.glZ.a(aVar);
            }
            if (this.gma != null) {
                aVar.dX(8, this.gma.aHr());
                this.gma.a(aVar);
            }
            if (this.gmb != null) {
                aVar.dX(9, this.gmb.aHr());
                this.gmb.a(aVar);
            }
            if (this.gmc != null) {
                aVar.dX(10, this.gmc.aHr());
                this.gmc.a(aVar);
            }
            if (this.gmd != null) {
                aVar.dX(11, this.gmd.aHr());
                this.gmd.a(aVar);
            }
            if (this.gme != null) {
                aVar.dX(12, this.gme.aHr());
                this.gme.a(aVar);
            }
            if (this.gmf != null) {
                aVar.e(13, this.gmf);
            }
            if (this.gmg != null) {
                aVar.dX(14, this.gmg.aHr());
                this.gmg.a(aVar);
            }
            if (this.gmh != null) {
                aVar.dX(15, this.gmh.aHr());
                this.gmh.a(aVar);
            }
            if (this.gmi != null) {
                aVar.dX(16, this.gmi.aHr());
                this.gmi.a(aVar);
            }
            if (this.gmj != null) {
                aVar.e(17, this.gmj);
            }
            aVar.dV(18, this.gmk);
            if (this.gml != null) {
                aVar.dX(19, this.gml.aHr());
                this.gml.a(aVar);
            }
            if (this.gmm == null) {
                return 0;
            }
            aVar.dX(20, this.gmm.aHr());
            this.gmm.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.glU != null) {
                r0 += a.a.a.b.b.a.f(2, this.glU);
            }
            if (this.glV != null) {
                r0 += a.a.a.b.b.a.f(3, this.glV);
            }
            if (this.glW != null) {
                r0 += a.a.a.a.dU(4, this.glW.aHr());
            }
            if (this.glX != null) {
                r0 += a.a.a.a.dU(5, this.glX.aHr());
            }
            if (this.glY != null) {
                r0 += a.a.a.a.dU(6, this.glY.aHr());
            }
            if (this.glZ != null) {
                r0 += a.a.a.a.dU(7, this.glZ.aHr());
            }
            if (this.gma != null) {
                r0 += a.a.a.a.dU(8, this.gma.aHr());
            }
            if (this.gmb != null) {
                r0 += a.a.a.a.dU(9, this.gmb.aHr());
            }
            if (this.gmc != null) {
                r0 += a.a.a.a.dU(10, this.gmc.aHr());
            }
            if (this.gmd != null) {
                r0 += a.a.a.a.dU(11, this.gmd.aHr());
            }
            if (this.gme != null) {
                r0 += a.a.a.a.dU(12, this.gme.aHr());
            }
            if (this.gmf != null) {
                r0 += a.a.a.b.b.a.f(13, this.gmf);
            }
            if (this.gmg != null) {
                r0 += a.a.a.a.dU(14, this.gmg.aHr());
            }
            if (this.gmh != null) {
                r0 += a.a.a.a.dU(15, this.gmh.aHr());
            }
            if (this.gmi != null) {
                r0 += a.a.a.a.dU(16, this.gmi.aHr());
            }
            if (this.gmj != null) {
                r0 += a.a.a.b.b.a.f(17, this.gmj);
            }
            r0 += a.a.a.a.dS(18, this.gmk);
            if (this.gml != null) {
                r0 += a.a.a.a.dU(19, this.gml.aHr());
            }
            if (this.gmm != null) {
                r0 += a.a.a.a.dU(20, this.gmm.aHr());
            }
            return r0;
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
            ac acVar = (ac) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            at atVar;
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
                        acVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    acVar.glU = aVar3.pMj.readString();
                    return 0;
                case 3:
                    acVar.glV = aVar3.pMj.readString();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        atVar = new at();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atVar.a(aVar4, atVar, aqx.a(aVar4))) {
                        }
                        acVar.glW = atVar;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        atVar = new at();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atVar.a(aVar4, atVar, aqx.a(aVar4))) {
                        }
                        acVar.glX = atVar;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        av avVar = new av();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = avVar.a(aVar4, avVar, aqx.a(aVar4))) {
                        }
                        acVar.glY = avVar;
                    }
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bq bqVar = new bq();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bqVar.a(aVar4, bqVar, aqx.a(aVar4))) {
                        }
                        acVar.glZ = bqVar;
                    }
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        cd cdVar = new cd();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = cdVar.a(aVar4, cdVar, aqx.a(aVar4))) {
                        }
                        acVar.gma = cdVar;
                    }
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        w wVar = new w();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = wVar.a(aVar4, wVar, aqx.a(aVar4))) {
                        }
                        acVar.gmb = wVar;
                    }
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bj bjVar = new bj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bjVar.a(aVar4, bjVar, aqx.a(aVar4))) {
                        }
                        acVar.gmc = bjVar;
                    }
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        bc bcVar = new bc();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = bcVar.a(aVar4, bcVar, aqx.a(aVar4))) {
                        }
                        acVar.gmd = bcVar;
                    }
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        l lVar = new l();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = lVar.a(aVar4, lVar, aqx.a(aVar4))) {
                        }
                        acVar.gme = lVar;
                    }
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    acVar.gmf = aVar3.pMj.readString();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        e eVar = new e();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eVar.a(aVar4, eVar, aqx.a(aVar4))) {
                        }
                        acVar.gmg = eVar;
                    }
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        au auVar = new au();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = auVar.a(aVar4, auVar, aqx.a(aVar4))) {
                        }
                        acVar.gmh = auVar;
                    }
                    return 0;
                case 16:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        t tVar = new t();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = tVar.a(aVar4, tVar, aqx.a(aVar4))) {
                        }
                        acVar.gmi = tVar;
                    }
                    return 0;
                case 17:
                    acVar.gmj = aVar3.pMj.readString();
                    return 0;
                case 18:
                    acVar.gmk = aVar3.pMj.mH();
                    return 0;
                case 19:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        atVar = new at();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = atVar.a(aVar4, atVar, aqx.a(aVar4))) {
                        }
                        acVar.gml = atVar;
                    }
                    return 0;
                case 20:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        an anVar = new an();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = anVar.a(aVar4, anVar, aqx.a(aVar4))) {
                        }
                        acVar.gmm = anVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
