package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import java.util.LinkedList;

public final class ahx extends aqp {
    public int gll;
    public String hOx;
    public int mHA;
    public int mHB;
    public are mHC;
    public int mHD;
    public int mHE;
    public int mHF;
    public int mHG;
    public int mHH;
    public String mHI;
    public String mHJ;
    public String mHK;
    public String mHu;
    public String mHv;
    public String mHw;
    public int mHx;
    public int mHy;
    public int mHz;
    public are mfq;
    public int mjJ;
    public int mjK;
    public int mzC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mfq == null) {
                throw new b("Not all required fields were included: DataBuffer");
            } else if (this.mHC == null) {
                throw new b("Not all required fields were included: ThumbData");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.mHu != null) {
                    aVar.e(2, this.mHu);
                }
                if (this.mHv != null) {
                    aVar.e(3, this.mHv);
                }
                if (this.mHw != null) {
                    aVar.e(4, this.mHw);
                }
                aVar.dV(5, this.gll);
                aVar.dV(6, this.mHx);
                if (this.mfq != null) {
                    aVar.dX(7, this.mfq.aHr());
                    this.mfq.a(aVar);
                }
                aVar.dV(8, this.mHy);
                aVar.dV(9, this.mHz);
                aVar.dV(10, this.mHA);
                aVar.dV(11, this.mHB);
                if (this.mHC != null) {
                    aVar.dX(12, this.mHC.aHr());
                    this.mHC.a(aVar);
                }
                aVar.dV(13, this.mHD);
                aVar.dV(14, this.mHE);
                aVar.dV(15, this.mHF);
                aVar.dV(16, this.mHG);
                aVar.dV(17, this.mzC);
                aVar.dV(18, this.mHH);
                if (this.mHI != null) {
                    aVar.e(19, this.mHI);
                }
                if (this.hOx != null) {
                    aVar.e(20, this.hOx);
                }
                aVar.dV(21, this.mjK);
                aVar.dV(22, this.mjJ);
                if (this.mHJ != null) {
                    aVar.e(23, this.mHJ);
                }
                if (this.mHK == null) {
                    return 0;
                }
                aVar.e(24, this.mHK);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mHu != null) {
                r0 += a.a.a.b.b.a.f(2, this.mHu);
            }
            if (this.mHv != null) {
                r0 += a.a.a.b.b.a.f(3, this.mHv);
            }
            if (this.mHw != null) {
                r0 += a.a.a.b.b.a.f(4, this.mHw);
            }
            r0 = (r0 + a.a.a.a.dS(5, this.gll)) + a.a.a.a.dS(6, this.mHx);
            if (this.mfq != null) {
                r0 += a.a.a.a.dU(7, this.mfq.aHr());
            }
            r0 = (((r0 + a.a.a.a.dS(8, this.mHy)) + a.a.a.a.dS(9, this.mHz)) + a.a.a.a.dS(10, this.mHA)) + a.a.a.a.dS(11, this.mHB);
            if (this.mHC != null) {
                r0 += a.a.a.a.dU(12, this.mHC.aHr());
            }
            r0 = (((((r0 + a.a.a.a.dS(13, this.mHD)) + a.a.a.a.dS(14, this.mHE)) + a.a.a.a.dS(15, this.mHF)) + a.a.a.a.dS(16, this.mHG)) + a.a.a.a.dS(17, this.mzC)) + a.a.a.a.dS(18, this.mHH);
            if (this.mHI != null) {
                r0 += a.a.a.b.b.a.f(19, this.mHI);
            }
            if (this.hOx != null) {
                r0 += a.a.a.b.b.a.f(20, this.hOx);
            }
            r0 = (r0 + a.a.a.a.dS(21, this.mjK)) + a.a.a.a.dS(22, this.mjJ);
            if (this.mHJ != null) {
                r0 += a.a.a.b.b.a.f(23, this.mHJ);
            }
            if (this.mHK != null) {
                r0 += a.a.a.b.b.a.f(24, this.mHK);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mfq == null) {
                throw new b("Not all required fields were included: DataBuffer");
            } else if (this.mHC != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ThumbData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ahx com_tencent_mm_protocal_c_ahx = (ahx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            are com_tencent_mm_protocal_c_are;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahx.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ahx.mHu = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ahx.mHv = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ahx.mHw = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ahx.gll = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ahx.mHx = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahx.mfq = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ahx.mHy = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ahx.mHz = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ahx.mHA = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ahx.mHB = aVar3.pMj.mH();
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahx.mHC = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_ahx.mHD = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_ahx.mHE = aVar3.pMj.mH();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    com_tencent_mm_protocal_c_ahx.mHF = aVar3.pMj.mH();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_ahx.mHG = aVar3.pMj.mH();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_ahx.mzC = aVar3.pMj.mH();
                    return 0;
                case 18:
                    com_tencent_mm_protocal_c_ahx.mHH = aVar3.pMj.mH();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_ahx.mHI = aVar3.pMj.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_ahx.hOx = aVar3.pMj.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_ahx.mjK = aVar3.pMj.mH();
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    com_tencent_mm_protocal_c_ahx.mjJ = aVar3.pMj.mH();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_ahx.mHJ = aVar3.pMj.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_ahx.mHK = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
