package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import android.support.v7.a.a.k;
import com.tencent.mmdb.FileUtils;
import java.util.LinkedList;

public final class akc extends aqx {
    public int eeO;
    public int fvo;
    public String fvq;
    public String gln;
    public String lZp;
    public String mAR;
    public are mAU;
    public String mKQ;
    public int mKR;
    public String mKS;
    public int mKT;
    public amx mKU;
    public int mKV;
    public String mKW;
    public String mKX;
    public asj mKY;
    public String maA;
    public int maB;
    public String maC;
    public String mas;
    public int mav;
    public String maz;
    public String mec;
    public aux mef;
    public int mek;
    public acg mgJ;
    public hu mgK;
    public ajs mgL;
    public ih mwS;
    public ih mwT;
    public ih mwU;

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
            aVar.dV(2, this.fvo);
            if (this.lZp != null) {
                aVar.e(3, this.lZp);
            }
            if (this.maz != null) {
                aVar.e(4, this.maz);
            }
            if (this.maA != null) {
                aVar.e(5, this.maA);
            }
            if (this.mKQ != null) {
                aVar.e(6, this.mKQ);
            }
            if (this.mas != null) {
                aVar.e(7, this.mas);
            }
            aVar.dV(8, this.maB);
            aVar.dV(9, this.mKR);
            if (this.mKS != null) {
                aVar.e(10, this.mKS);
            }
            if (this.mgK != null) {
                aVar.dX(14, this.mgK.aHr());
                this.mgK.a(aVar);
            }
            if (this.maC != null) {
                aVar.e(15, this.maC);
            }
            if (this.gln != null) {
                aVar.e(16, this.gln);
            }
            aVar.dV(17, this.eeO);
            if (this.mgL != null) {
                aVar.dX(18, this.mgL.aHr());
                this.mgL.a(aVar);
            }
            aVar.dV(19, this.mKT);
            aVar.dV(20, this.mav);
            if (this.mec != null) {
                aVar.e(21, this.mec);
            }
            if (this.mKU != null) {
                aVar.dX(22, this.mKU.aHr());
                this.mKU.a(aVar);
            }
            if (this.fvq != null) {
                aVar.e(23, this.fvq);
            }
            aVar.dV(24, this.mKV);
            if (this.mgJ != null) {
                aVar.dX(25, this.mgJ.aHr());
                this.mgJ.a(aVar);
            }
            if (this.mKW != null) {
                aVar.e(26, this.mKW);
            }
            if (this.mwS != null) {
                aVar.dX(27, this.mwS.aHr());
                this.mwS.a(aVar);
            }
            if (this.mKX != null) {
                aVar.e(28, this.mKX);
            }
            if (this.mAR != null) {
                aVar.e(29, this.mAR);
            }
            if (this.mAU != null) {
                aVar.dX(30, this.mAU.aHr());
                this.mAU.a(aVar);
            }
            if (this.mef != null) {
                aVar.dX(31, this.mef.aHr());
                this.mef.a(aVar);
            }
            if (this.mwT != null) {
                aVar.dX(32, this.mwT.aHr());
                this.mwT.a(aVar);
            }
            if (this.mwU != null) {
                aVar.dX(33, this.mwU.aHr());
                this.mwU.a(aVar);
            }
            if (this.mKY != null) {
                aVar.dX(34, this.mKY.aHr());
                this.mKY.a(aVar);
            }
            aVar.dV(35, this.mek);
            return 0;
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.fvo);
            if (this.lZp != null) {
                r0 += a.a.a.b.b.a.f(3, this.lZp);
            }
            if (this.maz != null) {
                r0 += a.a.a.b.b.a.f(4, this.maz);
            }
            if (this.maA != null) {
                r0 += a.a.a.b.b.a.f(5, this.maA);
            }
            if (this.mKQ != null) {
                r0 += a.a.a.b.b.a.f(6, this.mKQ);
            }
            if (this.mas != null) {
                r0 += a.a.a.b.b.a.f(7, this.mas);
            }
            r0 = (r0 + a.a.a.a.dS(8, this.maB)) + a.a.a.a.dS(9, this.mKR);
            if (this.mKS != null) {
                r0 += a.a.a.b.b.a.f(10, this.mKS);
            }
            if (this.mgK != null) {
                r0 += a.a.a.a.dU(14, this.mgK.aHr());
            }
            if (this.maC != null) {
                r0 += a.a.a.b.b.a.f(15, this.maC);
            }
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(16, this.gln);
            }
            r0 += a.a.a.a.dS(17, this.eeO);
            if (this.mgL != null) {
                r0 += a.a.a.a.dU(18, this.mgL.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(19, this.mKT)) + a.a.a.a.dS(20, this.mav);
            if (this.mec != null) {
                r0 += a.a.a.b.b.a.f(21, this.mec);
            }
            if (this.mKU != null) {
                r0 += a.a.a.a.dU(22, this.mKU.aHr());
            }
            if (this.fvq != null) {
                r0 += a.a.a.b.b.a.f(23, this.fvq);
            }
            r0 += a.a.a.a.dS(24, this.mKV);
            if (this.mgJ != null) {
                r0 += a.a.a.a.dU(25, this.mgJ.aHr());
            }
            if (this.mKW != null) {
                r0 += a.a.a.b.b.a.f(26, this.mKW);
            }
            if (this.mwS != null) {
                r0 += a.a.a.a.dU(27, this.mwS.aHr());
            }
            if (this.mKX != null) {
                r0 += a.a.a.b.b.a.f(28, this.mKX);
            }
            if (this.mAR != null) {
                r0 += a.a.a.b.b.a.f(29, this.mAR);
            }
            if (this.mAU != null) {
                r0 += a.a.a.a.dU(30, this.mAU.aHr());
            }
            if (this.mef != null) {
                r0 += a.a.a.a.dU(31, this.mef.aHr());
            }
            if (this.mwT != null) {
                r0 += a.a.a.a.dU(32, this.mwT.aHr());
            }
            if (this.mwU != null) {
                r0 += a.a.a.a.dU(33, this.mwU.aHr());
            }
            if (this.mKY != null) {
                r0 += a.a.a.a.dU(34, this.mKY.aHr());
            }
            return r0 + a.a.a.a.dS(35, this.mek);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
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
            akc com_tencent_mm_protocal_c_akc = (akc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a eoVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akc.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akc.fvo = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akc.lZp = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akc.maz = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_akc.maA = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_akc.mKQ = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_akc.mas = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_akc.maB = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_akc.mKR = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_akc.mKS = aVar3.pMj.readString();
                    return 0;
                case 14:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new hu();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akc.mgK = eoVar;
                    }
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_akc.maC = aVar3.pMj.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_akc.gln = aVar3.pMj.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_akc.eeO = aVar3.pMj.mH();
                    return 0;
                case k.MG /*18*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new ajs();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akc.mgL = eoVar;
                    }
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_akc.mKT = aVar3.pMj.mH();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_akc.mav = aVar3.pMj.mH();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_akc.mec = aVar3.pMj.readString();
                    return 0;
                case k.MM /*22*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new amx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akc.mKU = eoVar;
                    }
                    return 0;
                case k.Nb /*23*/:
                    com_tencent_mm_protocal_c_akc.fvq = aVar3.pMj.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_akc.mKV = aVar3.pMj.mH();
                    return 0;
                case 25:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new acg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akc.mgJ = eoVar;
                    }
                    return 0;
                case k.Kr /*26*/:
                    com_tencent_mm_protocal_c_akc.mKW = aVar3.pMj.readString();
                    return 0;
                case 27:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new ih();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akc.mwS = eoVar;
                    }
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_akc.mKX = aVar3.pMj.readString();
                    return 0;
                case 29:
                    com_tencent_mm_protocal_c_akc.mAR = aVar3.pMj.readString();
                    return 0;
                case 30:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akc.mAU = eoVar;
                    }
                    return 0;
                case 31:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new aux();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akc.mef = eoVar;
                    }
                    return 0;
                case FileUtils.S_IRGRP /*32*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new ih();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akc.mwT = eoVar;
                    }
                    return 0;
                case 33:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new ih();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akc.mwU = eoVar;
                    }
                    return 0;
                case 34:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new asj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akc.mKY = eoVar;
                    }
                    return 0;
                case 35:
                    com_tencent_mm_protocal_c_akc.mek = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
