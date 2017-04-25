package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class bfm extends aqp {
    public int mNO;
    public String mOk;
    public int mUW;
    public bfs mZR;
    public bfs mZS;
    public long mZV;
    public int mnk;
    public int mqS;
    public long mqT;
    public int naJ;
    public int naU;
    public LinkedList<arf> naV = new LinkedList();
    public int naW;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mZR == null) {
                throw new b("Not all required fields were included: PeerId");
            } else if (this.mZS == null) {
                throw new b("Not all required fields were included: CapInfo");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.mOk != null) {
                    aVar.e(2, this.mOk);
                }
                aVar.dV(3, this.naU);
                aVar.d(4, 8, this.naV);
                if (this.mZR != null) {
                    aVar.dX(6, this.mZR.aHr());
                    this.mZR.a(aVar);
                }
                if (this.mZS != null) {
                    aVar.dX(7, this.mZS.aHr());
                    this.mZS.a(aVar);
                }
                aVar.dV(8, this.mnk);
                aVar.dV(9, this.mUW);
                aVar.dV(10, this.mqS);
                aVar.C(11, this.mqT);
                aVar.dV(12, this.naJ);
                aVar.C(13, this.mZV);
                aVar.dV(14, this.naW);
                aVar.dV(15, this.mNO);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mOk != null) {
                r0 += a.a.a.b.b.a.f(2, this.mOk);
            }
            r0 = (r0 + a.a.a.a.dS(3, this.naU)) + a.a.a.a.c(4, 8, this.naV);
            if (this.mZR != null) {
                r0 += a.a.a.a.dU(6, this.mZR.aHr());
            }
            if (this.mZS != null) {
                r0 += a.a.a.a.dU(7, this.mZS.aHr());
            }
            return (((((((r0 + a.a.a.a.dS(8, this.mnk)) + a.a.a.a.dS(9, this.mUW)) + a.a.a.a.dS(10, this.mqS)) + a.a.a.a.B(11, this.mqT)) + a.a.a.a.dS(12, this.naJ)) + a.a.a.a.B(13, this.mZV)) + a.a.a.a.dS(14, this.naW)) + a.a.a.a.dS(15, this.mNO);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.naV.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
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
            bfm com_tencent_mm_protocal_c_bfm = (bfm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            bfs com_tencent_mm_protocal_c_bfs;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfm.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfm.mOk = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfm.naU = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        arf com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfm.naV.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_bfs = new bfs();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfs.a(aVar4, com_tencent_mm_protocal_c_bfs, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfm.mZR = com_tencent_mm_protocal_c_bfs;
                    }
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_bfs = new bfs();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bfs.a(aVar4, com_tencent_mm_protocal_c_bfs, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfm.mZS = com_tencent_mm_protocal_c_bfs;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bfm.mnk = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bfm.mUW = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bfm.mqS = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bfm.mqT = aVar3.pMj.mI();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bfm.naJ = aVar3.pMj.mH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_bfm.mZV = aVar3.pMj.mI();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_bfm.naW = aVar3.pMj.mH();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    com_tencent_mm_protocal_c_bfm.mNO = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
