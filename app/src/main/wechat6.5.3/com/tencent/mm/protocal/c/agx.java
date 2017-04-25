package com.tencent.mm.protocal.c;

import android.support.v7.a.a.k;
import com.tencent.mm.ba.a;
import com.tencent.mmdb.FileUtils;

public final class agx extends a {
    public String bmJ;
    public int mGA;
    public int mGB;
    public String mGC;
    public int mGD;
    public int mGE;
    public String mGF;
    public int mGG;
    public int mGH;
    public int mGI;
    public String mGJ;
    public String mGK;
    public String mGL;
    public String mGM;
    public String mGt;
    public String mGu;
    public String mGv;
    public String mGw;
    public int mGx;
    public int mGy;
    public String mGz;
    public String mlK;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.bmJ != null) {
                aVar.e(1, this.bmJ);
            }
            if (this.mGt != null) {
                aVar.e(20, this.mGt);
            }
            if (this.mGu != null) {
                aVar.e(21, this.mGu);
            }
            if (this.mGv != null) {
                aVar.e(22, this.mGv);
            }
            if (this.mGw != null) {
                aVar.e(23, this.mGw);
            }
            if (this.mlK != null) {
                aVar.e(31, this.mlK);
            }
            aVar.dV(32, this.mGx);
            aVar.dV(33, this.mGy);
            if (this.mGz != null) {
                aVar.e(34, this.mGz);
            }
            aVar.dV(35, this.mGA);
            aVar.dV(36, this.mGB);
            if (this.mGC != null) {
                aVar.e(37, this.mGC);
            }
            aVar.dV(38, this.mGD);
            aVar.dV(39, this.mGE);
            if (this.mGF != null) {
                aVar.e(41, this.mGF);
            }
            aVar.dV(200, this.mGG);
            aVar.dV(201, this.mGH);
            aVar.dV(202, this.mGI);
            if (this.mGJ != null) {
                aVar.e(203, this.mGJ);
            }
            if (this.mGK != null) {
                aVar.e(204, this.mGK);
            }
            if (this.mGL != null) {
                aVar.e(205, this.mGL);
            }
            if (this.mGM == null) {
                return 0;
            }
            aVar.e(206, this.mGM);
            return 0;
        } else if (i == 1) {
            if (this.bmJ != null) {
                r0 = a.a.a.b.b.a.f(1, this.bmJ) + 0;
            } else {
                r0 = 0;
            }
            if (this.mGt != null) {
                r0 += a.a.a.b.b.a.f(20, this.mGt);
            }
            if (this.mGu != null) {
                r0 += a.a.a.b.b.a.f(21, this.mGu);
            }
            if (this.mGv != null) {
                r0 += a.a.a.b.b.a.f(22, this.mGv);
            }
            if (this.mGw != null) {
                r0 += a.a.a.b.b.a.f(23, this.mGw);
            }
            if (this.mlK != null) {
                r0 += a.a.a.b.b.a.f(31, this.mlK);
            }
            r0 = (r0 + a.a.a.a.dS(32, this.mGx)) + a.a.a.a.dS(33, this.mGy);
            if (this.mGz != null) {
                r0 += a.a.a.b.b.a.f(34, this.mGz);
            }
            r0 = (r0 + a.a.a.a.dS(35, this.mGA)) + a.a.a.a.dS(36, this.mGB);
            if (this.mGC != null) {
                r0 += a.a.a.b.b.a.f(37, this.mGC);
            }
            r0 = (r0 + a.a.a.a.dS(38, this.mGD)) + a.a.a.a.dS(39, this.mGE);
            if (this.mGF != null) {
                r0 += a.a.a.b.b.a.f(41, this.mGF);
            }
            r0 = ((r0 + a.a.a.a.dS(200, this.mGG)) + a.a.a.a.dS(201, this.mGH)) + a.a.a.a.dS(202, this.mGI);
            if (this.mGJ != null) {
                r0 += a.a.a.b.b.a.f(203, this.mGJ);
            }
            if (this.mGK != null) {
                r0 += a.a.a.b.b.a.f(204, this.mGK);
            }
            if (this.mGL != null) {
                r0 += a.a.a.b.b.a.f(205, this.mGL);
            }
            if (this.mGM != null) {
                r0 += a.a.a.b.b.a.f(206, this.mGM);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
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
            agx com_tencent_mm_protocal_c_agx = (agx) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    com_tencent_mm_protocal_c_agx.bmJ = aVar3.pMj.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_agx.mGt = aVar3.pMj.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_agx.mGu = aVar3.pMj.readString();
                    return 0;
                case k.MM /*22*/:
                    com_tencent_mm_protocal_c_agx.mGv = aVar3.pMj.readString();
                    return 0;
                case k.Nb /*23*/:
                    com_tencent_mm_protocal_c_agx.mGw = aVar3.pMj.readString();
                    return 0;
                case 31:
                    com_tencent_mm_protocal_c_agx.mlK = aVar3.pMj.readString();
                    return 0;
                case FileUtils.S_IRGRP /*32*/:
                    com_tencent_mm_protocal_c_agx.mGx = aVar3.pMj.mH();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_agx.mGy = aVar3.pMj.mH();
                    return 0;
                case 34:
                    com_tencent_mm_protocal_c_agx.mGz = aVar3.pMj.readString();
                    return 0;
                case 35:
                    com_tencent_mm_protocal_c_agx.mGA = aVar3.pMj.mH();
                    return 0;
                case 36:
                    com_tencent_mm_protocal_c_agx.mGB = aVar3.pMj.mH();
                    return 0;
                case 37:
                    com_tencent_mm_protocal_c_agx.mGC = aVar3.pMj.readString();
                    return 0;
                case 38:
                    com_tencent_mm_protocal_c_agx.mGD = aVar3.pMj.mH();
                    return 0;
                case 39:
                    com_tencent_mm_protocal_c_agx.mGE = aVar3.pMj.mH();
                    return 0;
                case 41:
                    com_tencent_mm_protocal_c_agx.mGF = aVar3.pMj.readString();
                    return 0;
                case 200:
                    com_tencent_mm_protocal_c_agx.mGG = aVar3.pMj.mH();
                    return 0;
                case 201:
                    com_tencent_mm_protocal_c_agx.mGH = aVar3.pMj.mH();
                    return 0;
                case 202:
                    com_tencent_mm_protocal_c_agx.mGI = aVar3.pMj.mH();
                    return 0;
                case 203:
                    com_tencent_mm_protocal_c_agx.mGJ = aVar3.pMj.readString();
                    return 0;
                case 204:
                    com_tencent_mm_protocal_c_agx.mGK = aVar3.pMj.readString();
                    return 0;
                case 205:
                    com_tencent_mm_protocal_c_agx.mGL = aVar3.pMj.readString();
                    return 0;
                case 206:
                    com_tencent_mm_protocal_c_agx.mGM = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
