package com.tencent.mm.plugin.game.d;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.eo;
import java.util.LinkedList;

public final class aa extends aqx {
    public d gkt;
    public String glG;
    public LinkedList<n> glH = new LinkedList();
    public ay glI;
    public ap glJ;
    public al glK;
    public bl glL;
    public LinkedList<o> glM = new LinkedList();
    public bv glN;
    public ao glO;
    public ak glP;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.gkt == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.glG == null) {
                throw new b("Not all required fields were included: BackGroundURL");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.gkt != null) {
                    aVar.dX(2, this.gkt.aHr());
                    this.gkt.a(aVar);
                }
                if (this.glG != null) {
                    aVar.e(3, this.glG);
                }
                aVar.d(4, 8, this.glH);
                if (this.glI != null) {
                    aVar.dX(5, this.glI.aHr());
                    this.glI.a(aVar);
                }
                if (this.glJ != null) {
                    aVar.dX(7, this.glJ.aHr());
                    this.glJ.a(aVar);
                }
                if (this.glK != null) {
                    aVar.dX(8, this.glK.aHr());
                    this.glK.a(aVar);
                }
                if (this.glL != null) {
                    aVar.dX(9, this.glL.aHr());
                    this.glL.a(aVar);
                }
                aVar.d(10, 8, this.glM);
                if (this.glN != null) {
                    aVar.dX(11, this.glN.aHr());
                    this.glN.a(aVar);
                }
                if (this.glO != null) {
                    aVar.dX(12, this.glO.aHr());
                    this.glO.a(aVar);
                }
                if (this.glP == null) {
                    return 0;
                }
                aVar.dX(13, this.glP.aHr());
                this.glP.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.gkt != null) {
                r0 += a.a.a.a.dU(2, this.gkt.aHr());
            }
            if (this.glG != null) {
                r0 += a.a.a.b.b.a.f(3, this.glG);
            }
            r0 += a.a.a.a.c(4, 8, this.glH);
            if (this.glI != null) {
                r0 += a.a.a.a.dU(5, this.glI.aHr());
            }
            if (this.glJ != null) {
                r0 += a.a.a.a.dU(7, this.glJ.aHr());
            }
            if (this.glK != null) {
                r0 += a.a.a.a.dU(8, this.glK.aHr());
            }
            if (this.glL != null) {
                r0 += a.a.a.a.dU(9, this.glL.aHr());
            }
            r0 += a.a.a.a.c(10, 8, this.glM);
            if (this.glN != null) {
                r0 += a.a.a.a.dU(11, this.glN.aHr());
            }
            if (this.glO != null) {
                r0 += a.a.a.a.dU(12, this.glO.aHr());
            }
            if (this.glP != null) {
                r0 += a.a.a.a.dU(13, this.glP.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.glH.clear();
            this.glM.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.gkt == null) {
                throw new b("Not all required fields were included: AppItem");
            } else if (this.glG != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: BackGroundURL");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aa aaVar = (aa) objArr[1];
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
                        aaVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        d dVar = new d();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = dVar.a(aVar4, dVar, aqx.a(aVar4))) {
                        }
                        aaVar.gkt = dVar;
                    }
                    return 0;
                case 3:
                    aaVar.glG = aVar3.pMj.readString();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        n nVar = new n();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = nVar.a(aVar4, nVar, aqx.a(aVar4))) {
                        }
                        aaVar.glH.add(nVar);
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ay ayVar = new ay();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = ayVar.a(aVar4, ayVar, aqx.a(aVar4))) {
                        }
                        aaVar.glI = ayVar;
                    }
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ap apVar = new ap();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = apVar.a(aVar4, apVar, aqx.a(aVar4))) {
                        }
                        aaVar.glJ = apVar;
                    }
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        al alVar = new al();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = alVar.a(aVar4, alVar, aqx.a(aVar4))) {
                        }
                        aaVar.glK = alVar;
                    }
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bl blVar = new bl();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = blVar.a(aVar4, blVar, aqx.a(aVar4))) {
                        }
                        aaVar.glL = blVar;
                    }
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        o oVar = new o();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = oVar.a(aVar4, oVar, aqx.a(aVar4))) {
                        }
                        aaVar.glM.add(oVar);
                    }
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bv bvVar = new bv();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = bvVar.a(aVar4, bvVar, aqx.a(aVar4))) {
                        }
                        aaVar.glN = bvVar;
                    }
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ao aoVar = new ao();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = aoVar.a(aVar4, aoVar, aqx.a(aVar4))) {
                        }
                        aaVar.glO = aoVar;
                    }
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ak akVar = new ak();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = akVar.a(aVar4, akVar, aqx.a(aVar4))) {
                        }
                        aaVar.glP = akVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
