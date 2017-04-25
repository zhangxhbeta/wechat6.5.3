package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import java.util.LinkedList;

public final class bej extends aqx {
    public int mZW;
    public bfo mZX;
    public int mZY;
    public int mZZ;
    public int meD;
    public LinkedList<beg> meE = new LinkedList();
    public int mqS;
    public long mqT;
    public int nae;
    public LinkedList<bfp> naf = new LinkedList();
    public int nag;
    public int nah;
    public int nai;
    public int naj;
    public int nak;
    public int nal;
    public int nam;
    public int nan;
    public int nao;
    public int nap;
    public int naq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mZX == null) {
                throw new b("Not all required fields were included: RelayData");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                aVar.dV(2, this.meD);
                aVar.d(3, 8, this.meE);
                aVar.dV(4, this.mqS);
                aVar.C(5, this.mqT);
                aVar.dV(6, this.mZW);
                if (this.mZX != null) {
                    aVar.dX(7, this.mZX.aHr());
                    this.mZX.a(aVar);
                }
                aVar.dV(8, this.nae);
                aVar.d(9, 8, this.naf);
                aVar.dV(10, this.nag);
                aVar.dV(11, this.nah);
                aVar.dV(12, this.nai);
                aVar.dV(13, this.naj);
                aVar.dV(14, this.nak);
                aVar.dV(15, this.nal);
                aVar.dV(16, this.mZY);
                aVar.dV(17, this.nam);
                aVar.dV(18, this.nan);
                aVar.dV(19, this.mZZ);
                aVar.dV(20, this.nao);
                aVar.dV(21, this.nap);
                aVar.dV(22, this.naq);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((((r0 + a.a.a.a.dS(2, this.meD)) + a.a.a.a.c(3, 8, this.meE)) + a.a.a.a.dS(4, this.mqS)) + a.a.a.a.B(5, this.mqT)) + a.a.a.a.dS(6, this.mZW);
            if (this.mZX != null) {
                r0 += a.a.a.a.dU(7, this.mZX.aHr());
            }
            return ((((((((((((((r0 + a.a.a.a.dS(8, this.nae)) + a.a.a.a.c(9, 8, this.naf)) + a.a.a.a.dS(10, this.nag)) + a.a.a.a.dS(11, this.nah)) + a.a.a.a.dS(12, this.nai)) + a.a.a.a.dS(13, this.naj)) + a.a.a.a.dS(14, this.nak)) + a.a.a.a.dS(15, this.nal)) + a.a.a.a.dS(16, this.mZY)) + a.a.a.a.dS(17, this.nam)) + a.a.a.a.dS(18, this.nan)) + a.a.a.a.dS(19, this.mZZ)) + a.a.a.a.dS(20, this.nao)) + a.a.a.a.dS(21, this.nap)) + a.a.a.a.dS(22, this.naq);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.meE.clear();
            this.naf.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqx.a(aVar2); r0 > 0; r0 = aqx.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mZX != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RelayData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bej com_tencent_mm_protocal_c_bej = (bej) objArr[1];
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
                        com_tencent_mm_protocal_c_bej.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bej.meD = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        beg com_tencent_mm_protocal_c_beg = new beg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_beg.a(aVar4, com_tencent_mm_protocal_c_beg, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bej.meE.add(com_tencent_mm_protocal_c_beg);
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bej.mqS = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bej.mqT = aVar3.pMj.mI();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bej.mZW = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bfo com_tencent_mm_protocal_c_bfo = new bfo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfo.a(aVar4, com_tencent_mm_protocal_c_bfo, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bej.mZX = com_tencent_mm_protocal_c_bfo;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bej.nae = aVar3.pMj.mH();
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bfp com_tencent_mm_protocal_c_bfp = new bfp();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfp.a(aVar4, com_tencent_mm_protocal_c_bfp, aqx.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bej.naf.add(com_tencent_mm_protocal_c_bfp);
                    }
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bej.nag = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bej.nah = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bej.nai = aVar3.pMj.mH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_bej.naj = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_bej.nak = aVar3.pMj.mH();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    com_tencent_mm_protocal_c_bej.nal = aVar3.pMj.mH();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bej.mZY = aVar3.pMj.mH();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bej.nam = aVar3.pMj.mH();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_bej.nan = aVar3.pMj.mH();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bej.mZZ = aVar3.pMj.mH();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_bej.nao = aVar3.pMj.mH();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_bej.nap = aVar3.pMj.mH();
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    com_tencent_mm_protocal_c_bej.naq = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
