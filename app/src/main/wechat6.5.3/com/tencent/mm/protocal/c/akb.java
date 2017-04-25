package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import android.support.v7.a.a.k;
import com.tencent.mmdb.FileUtils;
import java.util.LinkedList;

public final class akb extends aqp {
    public String cHh;
    public String efy;
    public String fvy;
    public String fvz;
    public String gln;
    public String mAR;
    public String mAS;
    public int mAT;
    public String mHh;
    public int mKJ;
    public int mKK;
    public int mKL;
    public String mKM;
    public String mKN;
    public String mKO;
    public String mKP;
    public int mar;
    public String mas;
    public String mat;
    public int meo;
    public String mep;
    public nr mew;
    public int mgA;
    public are mgD;
    public String mgI;
    public String mpB;
    public String mpz;
    public String mrB;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.gln != null) {
                aVar.e(2, this.gln);
            }
            if (this.mgI != null) {
                aVar.e(3, this.mgI);
            }
            if (this.efy != null) {
                aVar.e(4, this.efy);
            }
            aVar.dV(5, this.mar);
            if (this.mas != null) {
                aVar.e(6, this.mas);
            }
            if (this.mat != null) {
                aVar.e(7, this.mat);
            }
            if (this.mpB != null) {
                aVar.e(8, this.mpB);
            }
            aVar.dV(12, this.meo);
            aVar.dV(13, this.mKJ);
            aVar.dV(14, this.mAT);
            if (this.fvy != null) {
                aVar.e(15, this.fvy);
            }
            if (this.fvz != null) {
                aVar.e(16, this.fvz);
            }
            aVar.dV(17, this.mgA);
            if (this.mpz != null) {
                aVar.e(18, this.mpz);
            }
            if (this.mgD != null) {
                aVar.dX(19, this.mgD.aHr());
                this.mgD.a(aVar);
            }
            if (this.cHh != null) {
                aVar.e(20, this.cHh);
            }
            if (this.mAR != null) {
                aVar.e(21, this.mAR);
            }
            if (this.mAS != null) {
                aVar.e(22, this.mAS);
            }
            aVar.dV(23, this.mKK);
            aVar.dV(24, this.mKL);
            if (this.mep != null) {
                aVar.e(31, this.mep);
            }
            if (this.mHh != null) {
                aVar.e(32, this.mHh);
            }
            if (this.mKM != null) {
                aVar.e(33, this.mKM);
            }
            if (this.mrB != null) {
                aVar.e(34, this.mrB);
            }
            if (this.mKN != null) {
                aVar.e(35, this.mKN);
            }
            if (this.mKO != null) {
                aVar.e(36, this.mKO);
            }
            if (this.mew != null) {
                aVar.dX(37, this.mew.aHr());
                this.mew.a(aVar);
            }
            if (this.mKP == null) {
                return 0;
            }
            aVar.e(38, this.mKP);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.gln != null) {
                r0 += a.a.a.b.b.a.f(2, this.gln);
            }
            if (this.mgI != null) {
                r0 += a.a.a.b.b.a.f(3, this.mgI);
            }
            if (this.efy != null) {
                r0 += a.a.a.b.b.a.f(4, this.efy);
            }
            r0 += a.a.a.a.dS(5, this.mar);
            if (this.mas != null) {
                r0 += a.a.a.b.b.a.f(6, this.mas);
            }
            if (this.mat != null) {
                r0 += a.a.a.b.b.a.f(7, this.mat);
            }
            if (this.mpB != null) {
                r0 += a.a.a.b.b.a.f(8, this.mpB);
            }
            r0 = ((r0 + a.a.a.a.dS(12, this.meo)) + a.a.a.a.dS(13, this.mKJ)) + a.a.a.a.dS(14, this.mAT);
            if (this.fvy != null) {
                r0 += a.a.a.b.b.a.f(15, this.fvy);
            }
            if (this.fvz != null) {
                r0 += a.a.a.b.b.a.f(16, this.fvz);
            }
            r0 += a.a.a.a.dS(17, this.mgA);
            if (this.mpz != null) {
                r0 += a.a.a.b.b.a.f(18, this.mpz);
            }
            if (this.mgD != null) {
                r0 += a.a.a.a.dU(19, this.mgD.aHr());
            }
            if (this.cHh != null) {
                r0 += a.a.a.b.b.a.f(20, this.cHh);
            }
            if (this.mAR != null) {
                r0 += a.a.a.b.b.a.f(21, this.mAR);
            }
            if (this.mAS != null) {
                r0 += a.a.a.b.b.a.f(22, this.mAS);
            }
            r0 = (r0 + a.a.a.a.dS(23, this.mKK)) + a.a.a.a.dS(24, this.mKL);
            if (this.mep != null) {
                r0 += a.a.a.b.b.a.f(31, this.mep);
            }
            if (this.mHh != null) {
                r0 += a.a.a.b.b.a.f(32, this.mHh);
            }
            if (this.mKM != null) {
                r0 += a.a.a.b.b.a.f(33, this.mKM);
            }
            if (this.mrB != null) {
                r0 += a.a.a.b.b.a.f(34, this.mrB);
            }
            if (this.mKN != null) {
                r0 += a.a.a.b.b.a.f(35, this.mKN);
            }
            if (this.mKO != null) {
                r0 += a.a.a.b.b.a.f(36, this.mKO);
            }
            if (this.mew != null) {
                r0 += a.a.a.a.dU(37, this.mew.aHr());
            }
            if (this.mKP != null) {
                r0 += a.a.a.b.b.a.f(38, this.mKP);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            akb com_tencent_mm_protocal_c_akb = (akb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akb.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_akb.gln = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_akb.mgI = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_akb.efy = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_akb.mar = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_akb.mas = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_akb.mat = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_akb.mpB = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_akb.meo = aVar3.pMj.mH();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_akb.mKJ = aVar3.pMj.mH();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_akb.mAT = aVar3.pMj.mH();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_akb.fvy = aVar3.pMj.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_akb.fvz = aVar3.pMj.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_akb.mgA = aVar3.pMj.mH();
                    return 0;
                case k.MG /*18*/:
                    com_tencent_mm_protocal_c_akb.mpz = aVar3.pMj.readString();
                    return 0;
                case 19:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akb.mgD = enVar;
                    }
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_akb.cHh = aVar3.pMj.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_akb.mAR = aVar3.pMj.readString();
                    return 0;
                case k.MM /*22*/:
                    com_tencent_mm_protocal_c_akb.mAS = aVar3.pMj.readString();
                    return 0;
                case k.Nb /*23*/:
                    com_tencent_mm_protocal_c_akb.mKK = aVar3.pMj.mH();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_akb.mKL = aVar3.pMj.mH();
                    return 0;
                case 31:
                    com_tencent_mm_protocal_c_akb.mep = aVar3.pMj.readString();
                    return 0;
                case FileUtils.S_IRGRP /*32*/:
                    com_tencent_mm_protocal_c_akb.mHh = aVar3.pMj.readString();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_akb.mKM = aVar3.pMj.readString();
                    return 0;
                case 34:
                    com_tencent_mm_protocal_c_akb.mrB = aVar3.pMj.readString();
                    return 0;
                case 35:
                    com_tencent_mm_protocal_c_akb.mKN = aVar3.pMj.readString();
                    return 0;
                case 36:
                    com_tencent_mm_protocal_c_akb.mKO = aVar3.pMj.readString();
                    return 0;
                case 37:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new nr();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_akb.mew = enVar;
                    }
                    return 0;
                case 38:
                    com_tencent_mm_protocal_c_akb.mKP = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
