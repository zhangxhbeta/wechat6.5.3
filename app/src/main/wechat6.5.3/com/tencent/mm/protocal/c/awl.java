package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import java.util.LinkedList;

public final class awl extends aqp {
    public int mIm;
    public LinkedList<avw> mIs = new LinkedList();
    public LinkedList<arf> mIw = new LinkedList();
    public awk mIx;
    public int mKB;
    public bah mNq;
    public int mTN;
    public int mTO;
    public int mTP;
    public awj mTQ;
    public are mTR;
    public String mTS;
    public ir mTT;
    public are mTg;
    public int mTp;
    public LinkedList<arf> mTq = new LinkedList();
    public long mTu;
    public int mTv;
    public LinkedList<arf> mTw = new LinkedList();
    public int mTx;
    public awq mTz;
    public String mbN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mTg == null) {
                throw new b("Not all required fields were included: ObjectDesc");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mTg != null) {
                aVar.dX(2, this.mTg.aHr());
                this.mTg.a(aVar);
            }
            aVar.dV(3, this.mTp);
            aVar.d(4, 8, this.mTq);
            aVar.dV(5, this.mTN);
            aVar.dV(6, this.mIm);
            if (this.mbN != null) {
                aVar.e(7, this.mbN);
            }
            aVar.dV(8, this.mTO);
            aVar.dV(9, this.mKB);
            aVar.d(10, 8, this.mIs);
            aVar.dV(11, this.mTP);
            aVar.C(12, this.mTu);
            aVar.dV(13, this.mTv);
            aVar.d(14, 8, this.mTw);
            if (this.mNq != null) {
                aVar.dX(15, this.mNq.aHr());
                this.mNq.a(aVar);
            }
            aVar.dV(16, this.mTx);
            aVar.d(17, 8, this.mIw);
            if (this.mTQ != null) {
                aVar.dX(18, this.mTQ.aHr());
                this.mTQ.a(aVar);
            }
            if (this.mIx != null) {
                aVar.dX(19, this.mIx.aHr());
                this.mIx.a(aVar);
            }
            if (this.mTz != null) {
                aVar.dX(20, this.mTz.aHr());
                this.mTz.a(aVar);
            }
            if (this.mTR != null) {
                aVar.dX(21, this.mTR.aHr());
                this.mTR.a(aVar);
            }
            if (this.mTS != null) {
                aVar.e(22, this.mTS);
            }
            if (this.mTT == null) {
                return 0;
            }
            aVar.dX(23, this.mTT.aHr());
            this.mTT.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mTg != null) {
                r0 += a.a.a.a.dU(2, this.mTg.aHr());
            }
            r0 = (((r0 + a.a.a.a.dS(3, this.mTp)) + a.a.a.a.c(4, 8, this.mTq)) + a.a.a.a.dS(5, this.mTN)) + a.a.a.a.dS(6, this.mIm);
            if (this.mbN != null) {
                r0 += a.a.a.b.b.a.f(7, this.mbN);
            }
            r0 = ((((((r0 + a.a.a.a.dS(8, this.mTO)) + a.a.a.a.dS(9, this.mKB)) + a.a.a.a.c(10, 8, this.mIs)) + a.a.a.a.dS(11, this.mTP)) + a.a.a.a.B(12, this.mTu)) + a.a.a.a.dS(13, this.mTv)) + a.a.a.a.c(14, 8, this.mTw);
            if (this.mNq != null) {
                r0 += a.a.a.a.dU(15, this.mNq.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(16, this.mTx)) + a.a.a.a.c(17, 8, this.mIw);
            if (this.mTQ != null) {
                r0 += a.a.a.a.dU(18, this.mTQ.aHr());
            }
            if (this.mIx != null) {
                r0 += a.a.a.a.dU(19, this.mIx.aHr());
            }
            if (this.mTz != null) {
                r0 += a.a.a.a.dU(20, this.mTz.aHr());
            }
            if (this.mTR != null) {
                r0 += a.a.a.a.dU(21, this.mTR.aHr());
            }
            if (this.mTS != null) {
                r0 += a.a.a.b.b.a.f(22, this.mTS);
            }
            if (this.mTT != null) {
                r0 += a.a.a.a.dU(23, this.mTT.aHr());
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mTq.clear();
            this.mIs.clear();
            this.mTw.clear();
            this.mIw.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mTg != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ObjectDesc");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            awl com_tencent_mm_protocal_c_awl = (awl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            are com_tencent_mm_protocal_c_are;
            arf com_tencent_mm_protocal_c_arf;
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
                        com_tencent_mm_protocal_c_awl.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awl.mTg = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_awl.mTp = aVar3.pMj.mH();
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awl.mTq.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_awl.mTN = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_awl.mIm = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_awl.mbN = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_awl.mTO = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_awl.mKB = aVar3.pMj.mH();
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        avw com_tencent_mm_protocal_c_avw = new avw();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avw.a(aVar4, com_tencent_mm_protocal_c_avw, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awl.mIs.add(com_tencent_mm_protocal_c_avw);
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_awl.mTP = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_awl.mTu = aVar3.pMj.mI();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_awl.mTv = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awl.mTw.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bah com_tencent_mm_protocal_c_bah = new bah();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_bah.a(aVar4, com_tencent_mm_protocal_c_bah, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awl.mNq = com_tencent_mm_protocal_c_bah;
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_awl.mTx = aVar3.pMj.mH();
                    return 0;
                case 17:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awl.mIw.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 18:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        awj com_tencent_mm_protocal_c_awj = new awj();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_awj.a(aVar4, com_tencent_mm_protocal_c_awj, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awl.mTQ = com_tencent_mm_protocal_c_awj;
                    }
                    return 0;
                case 19:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        awk com_tencent_mm_protocal_c_awk = new awk();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_awk.a(aVar4, com_tencent_mm_protocal_c_awk, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awl.mIx = com_tencent_mm_protocal_c_awk;
                    }
                    return 0;
                case 20:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        awq com_tencent_mm_protocal_c_awq = new awq();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_awq.a(aVar4, com_tencent_mm_protocal_c_awq, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awl.mTz = com_tencent_mm_protocal_c_awq;
                    }
                    return 0;
                case 21:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awl.mTR = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    com_tencent_mm_protocal_c_awl.mTS = aVar3.pMj.readString();
                    return 0;
                case 23:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ir irVar = new ir();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = irVar.a(aVar4, irVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awl.mTT = irVar;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
