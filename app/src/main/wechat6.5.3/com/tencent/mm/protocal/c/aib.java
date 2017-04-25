package com.tencent.mm.protocal.c;

import android.support.v7.a.a.k;
import com.tencent.mm.ba.a;
import com.tencent.mmdb.FileUtils;
import java.util.LinkedList;

public final class aib extends a {
    public String aXz;
    public int aYp;
    public String aZy;
    public int efm;
    public String gID;
    public String gkC;
    public String glb;
    public String jFe;
    public int jZD;
    public int jdV;
    public int mHO;
    public String mHP;
    public int mHQ;
    public int mHR;
    public aid mHS;
    public String mHT;
    public int mHU;
    public int mHV;
    public String mHW;
    public String mHX;
    public String mHY;
    public String mHZ;
    public String mIa;
    public int mIb;
    public long mIc;
    public String mId;
    public String mIe;
    public int mIf;
    public String mIg;
    public String mIh;
    public int mIi;
    public String mIj;
    public String mIk;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gID != null) {
                aVar.e(1, this.gID);
            }
            aVar.dV(2, this.efm);
            if (this.gkC != null) {
                aVar.e(3, this.gkC);
            }
            if (this.glb != null) {
                aVar.e(4, this.glb);
            }
            aVar.dV(5, this.mHO);
            if (this.mHP != null) {
                aVar.e(6, this.mHP);
            }
            aVar.dV(7, this.mHQ);
            aVar.dV(8, this.mHR);
            if (this.aXz != null) {
                aVar.e(9, this.aXz);
            }
            if (this.mHS != null) {
                aVar.dX(10, this.mHS.aHr());
                this.mHS.a(aVar);
            }
            if (this.mHT != null) {
                aVar.e(11, this.mHT);
            }
            aVar.dV(12, this.mHU);
            aVar.dV(13, this.jdV);
            aVar.dV(14, this.mHV);
            if (this.jFe != null) {
                aVar.e(15, this.jFe);
            }
            aVar.dV(16, this.aYp);
            if (this.aZy != null) {
                aVar.e(17, this.aZy);
            }
            if (this.mHW != null) {
                aVar.e(18, this.mHW);
            }
            if (this.mHX != null) {
                aVar.e(19, this.mHX);
            }
            if (this.mHY != null) {
                aVar.e(20, this.mHY);
            }
            aVar.dV(21, this.jZD);
            if (this.mHZ != null) {
                aVar.e(22, this.mHZ);
            }
            if (this.mIa != null) {
                aVar.e(23, this.mIa);
            }
            aVar.dV(24, this.mIb);
            aVar.C(25, this.mIc);
            if (this.mId != null) {
                aVar.e(26, this.mId);
            }
            if (this.mIe != null) {
                aVar.e(27, this.mIe);
            }
            aVar.dV(28, this.mIf);
            if (this.mIg != null) {
                aVar.e(29, this.mIg);
            }
            if (this.mIh != null) {
                aVar.e(30, this.mIh);
            }
            aVar.dV(31, this.mIi);
            if (this.mIj != null) {
                aVar.e(32, this.mIj);
            }
            if (this.mIk == null) {
                return 0;
            }
            aVar.e(33, this.mIk);
            return 0;
        } else if (i == 1) {
            if (this.gID != null) {
                r0 = a.a.a.b.b.a.f(1, this.gID) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.efm);
            if (this.gkC != null) {
                r0 += a.a.a.b.b.a.f(3, this.gkC);
            }
            if (this.glb != null) {
                r0 += a.a.a.b.b.a.f(4, this.glb);
            }
            r0 += a.a.a.a.dS(5, this.mHO);
            if (this.mHP != null) {
                r0 += a.a.a.b.b.a.f(6, this.mHP);
            }
            r0 = (r0 + a.a.a.a.dS(7, this.mHQ)) + a.a.a.a.dS(8, this.mHR);
            if (this.aXz != null) {
                r0 += a.a.a.b.b.a.f(9, this.aXz);
            }
            if (this.mHS != null) {
                r0 += a.a.a.a.dU(10, this.mHS.aHr());
            }
            if (this.mHT != null) {
                r0 += a.a.a.b.b.a.f(11, this.mHT);
            }
            r0 = ((r0 + a.a.a.a.dS(12, this.mHU)) + a.a.a.a.dS(13, this.jdV)) + a.a.a.a.dS(14, this.mHV);
            if (this.jFe != null) {
                r0 += a.a.a.b.b.a.f(15, this.jFe);
            }
            r0 += a.a.a.a.dS(16, this.aYp);
            if (this.aZy != null) {
                r0 += a.a.a.b.b.a.f(17, this.aZy);
            }
            if (this.mHW != null) {
                r0 += a.a.a.b.b.a.f(18, this.mHW);
            }
            if (this.mHX != null) {
                r0 += a.a.a.b.b.a.f(19, this.mHX);
            }
            if (this.mHY != null) {
                r0 += a.a.a.b.b.a.f(20, this.mHY);
            }
            r0 += a.a.a.a.dS(21, this.jZD);
            if (this.mHZ != null) {
                r0 += a.a.a.b.b.a.f(22, this.mHZ);
            }
            if (this.mIa != null) {
                r0 += a.a.a.b.b.a.f(23, this.mIa);
            }
            r0 = (r0 + a.a.a.a.dS(24, this.mIb)) + a.a.a.a.B(25, this.mIc);
            if (this.mId != null) {
                r0 += a.a.a.b.b.a.f(26, this.mId);
            }
            if (this.mIe != null) {
                r0 += a.a.a.b.b.a.f(27, this.mIe);
            }
            r0 += a.a.a.a.dS(28, this.mIf);
            if (this.mIg != null) {
                r0 += a.a.a.b.b.a.f(29, this.mIg);
            }
            if (this.mIh != null) {
                r0 += a.a.a.b.b.a.f(30, this.mIh);
            }
            r0 += a.a.a.a.dS(31, this.mIi);
            if (this.mIj != null) {
                r0 += a.a.a.b.b.a.f(32, this.mIj);
            }
            if (this.mIk != null) {
                r0 += a.a.a.b.b.a.f(33, this.mIk);
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
            aib com_tencent_mm_protocal_c_aib = (aib) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aib.gID = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aib.efm = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aib.gkC = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aib.glb = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aib.mHO = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aib.mHP = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aib.mHQ = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aib.mHR = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aib.aXz = aVar3.pMj.readString();
                    return 0;
                case 10:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a com_tencent_mm_protocal_c_aid = new aid();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aid.a(aVar4, com_tencent_mm_protocal_c_aid, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aib.mHS = com_tencent_mm_protocal_c_aid;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aib.mHT = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aib.mHU = aVar3.pMj.mH();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aib.jdV = aVar3.pMj.mH();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aib.mHV = aVar3.pMj.mH();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aib.jFe = aVar3.pMj.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aib.aYp = aVar3.pMj.mH();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_aib.aZy = aVar3.pMj.readString();
                    return 0;
                case k.MG /*18*/:
                    com_tencent_mm_protocal_c_aib.mHW = aVar3.pMj.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_aib.mHX = aVar3.pMj.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_aib.mHY = aVar3.pMj.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_aib.jZD = aVar3.pMj.mH();
                    return 0;
                case k.MM /*22*/:
                    com_tencent_mm_protocal_c_aib.mHZ = aVar3.pMj.readString();
                    return 0;
                case k.Nb /*23*/:
                    com_tencent_mm_protocal_c_aib.mIa = aVar3.pMj.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_aib.mIb = aVar3.pMj.mH();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_aib.mIc = aVar3.pMj.mI();
                    return 0;
                case k.Kr /*26*/:
                    com_tencent_mm_protocal_c_aib.mId = aVar3.pMj.readString();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_aib.mIe = aVar3.pMj.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_aib.mIf = aVar3.pMj.mH();
                    return 0;
                case 29:
                    com_tencent_mm_protocal_c_aib.mIg = aVar3.pMj.readString();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_aib.mIh = aVar3.pMj.readString();
                    return 0;
                case 31:
                    com_tencent_mm_protocal_c_aib.mIi = aVar3.pMj.mH();
                    return 0;
                case FileUtils.S_IRGRP /*32*/:
                    com_tencent_mm_protocal_c_aib.mIj = aVar3.pMj.readString();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_aib.mIk = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
