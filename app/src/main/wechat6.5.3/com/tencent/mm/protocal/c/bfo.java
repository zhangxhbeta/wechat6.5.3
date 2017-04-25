package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import java.util.LinkedList;

public final class bfo extends a {
    public int gGd;
    public bfs mZR;
    public bfs mZS;
    public int naY;
    public beh naZ;
    public beh nba;
    public int nbb;
    public int nbc;
    public int nbd;
    public int nbe;
    public are nbf;
    public int nbg;
    public beh nbh;
    public int nbi;
    public int nbj;
    public int nbk;
    public int nbl;
    public int nbm;
    public int nbn;
    public are nbo;
    public are nbp;
    public int nbq;
    public are nbr;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mZR == null) {
                throw new b("Not all required fields were included: PeerId");
            } else if (this.mZS == null) {
                throw new b("Not all required fields were included: CapInfo");
            } else {
                if (this.mZR != null) {
                    aVar.dX(1, this.mZR.aHr());
                    this.mZR.a(aVar);
                }
                if (this.mZS != null) {
                    aVar.dX(2, this.mZS.aHr());
                    this.mZS.a(aVar);
                }
                aVar.dV(3, this.naY);
                if (this.naZ != null) {
                    aVar.dX(4, this.naZ.aHr());
                    this.naZ.a(aVar);
                }
                if (this.nba != null) {
                    aVar.dX(5, this.nba.aHr());
                    this.nba.a(aVar);
                }
                aVar.dV(6, this.nbb);
                aVar.dV(7, this.nbc);
                aVar.dV(8, this.nbd);
                aVar.dV(9, this.nbe);
                if (this.nbf != null) {
                    aVar.dX(10, this.nbf.aHr());
                    this.nbf.a(aVar);
                }
                aVar.dV(11, this.nbg);
                if (this.nbh != null) {
                    aVar.dX(12, this.nbh.aHr());
                    this.nbh.a(aVar);
                }
                aVar.dV(13, this.nbi);
                aVar.dV(14, this.nbj);
                aVar.dV(15, this.nbk);
                aVar.dV(16, this.nbl);
                aVar.dV(17, this.nbm);
                aVar.dV(18, this.gGd);
                aVar.dV(19, this.nbn);
                if (this.nbo != null) {
                    aVar.dX(20, this.nbo.aHr());
                    this.nbo.a(aVar);
                }
                if (this.nbp != null) {
                    aVar.dX(21, this.nbp.aHr());
                    this.nbp.a(aVar);
                }
                aVar.dV(22, this.nbq);
                if (this.nbr == null) {
                    return 0;
                }
                aVar.dX(23, this.nbr.aHr());
                this.nbr.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.mZR != null) {
                r0 = a.a.a.a.dU(1, this.mZR.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mZS != null) {
                r0 += a.a.a.a.dU(2, this.mZS.aHr());
            }
            r0 += a.a.a.a.dS(3, this.naY);
            if (this.naZ != null) {
                r0 += a.a.a.a.dU(4, this.naZ.aHr());
            }
            if (this.nba != null) {
                r0 += a.a.a.a.dU(5, this.nba.aHr());
            }
            r0 = (((r0 + a.a.a.a.dS(6, this.nbb)) + a.a.a.a.dS(7, this.nbc)) + a.a.a.a.dS(8, this.nbd)) + a.a.a.a.dS(9, this.nbe);
            if (this.nbf != null) {
                r0 += a.a.a.a.dU(10, this.nbf.aHr());
            }
            r0 += a.a.a.a.dS(11, this.nbg);
            if (this.nbh != null) {
                r0 += a.a.a.a.dU(12, this.nbh.aHr());
            }
            r0 = ((((((r0 + a.a.a.a.dS(13, this.nbi)) + a.a.a.a.dS(14, this.nbj)) + a.a.a.a.dS(15, this.nbk)) + a.a.a.a.dS(16, this.nbl)) + a.a.a.a.dS(17, this.nbm)) + a.a.a.a.dS(18, this.gGd)) + a.a.a.a.dS(19, this.nbn);
            if (this.nbo != null) {
                r0 += a.a.a.a.dU(20, this.nbo.aHr());
            }
            if (this.nbp != null) {
                r0 += a.a.a.a.dU(21, this.nbp.aHr());
            }
            r0 += a.a.a.a.dS(22, this.nbq);
            if (this.nbr != null) {
                r0 += a.a.a.a.dU(23, this.nbr.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mZR == null) {
                throw new b("Not all required fields were included: PeerId");
            } else if (this.mZS != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: CapInfo");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bfo com_tencent_mm_protocal_c_bfo = (bfo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            bfs com_tencent_mm_protocal_c_bfs;
            a.a.a.a.a aVar4;
            boolean z;
            beh com_tencent_mm_protocal_c_beh;
            are com_tencent_mm_protocal_c_are;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_bfs = new bfs();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfs.a(aVar4, com_tencent_mm_protocal_c_bfs, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfo.mZR = com_tencent_mm_protocal_c_bfs;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_bfs = new bfs();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfs.a(aVar4, com_tencent_mm_protocal_c_bfs, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfo.mZS = com_tencent_mm_protocal_c_bfs;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfo.naY = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_beh = new beh();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_beh.a(aVar4, com_tencent_mm_protocal_c_beh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfo.naZ = com_tencent_mm_protocal_c_beh;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_beh = new beh();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_beh.a(aVar4, com_tencent_mm_protocal_c_beh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfo.nba = com_tencent_mm_protocal_c_beh;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bfo.nbb = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bfo.nbc = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bfo.nbd = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bfo.nbe = aVar3.pMj.mH();
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfo.nbf = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bfo.nbg = aVar3.pMj.mH();
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_beh = new beh();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_beh.a(aVar4, com_tencent_mm_protocal_c_beh, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfo.nbh = com_tencent_mm_protocal_c_beh;
                    }
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_bfo.nbi = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_bfo.nbj = aVar3.pMj.mH();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    com_tencent_mm_protocal_c_bfo.nbk = aVar3.pMj.mH();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bfo.nbl = aVar3.pMj.mH();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bfo.nbm = aVar3.pMj.mH();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_bfo.gGd = aVar3.pMj.mH();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bfo.nbn = aVar3.pMj.mH();
                    return 0;
                case 20:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfo.nbo = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 21:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfo.nbp = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    com_tencent_mm_protocal_c_bfo.nbq = aVar3.pMj.mH();
                    return 0;
                case 23:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfo.nbr = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
