package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import java.util.LinkedList;

public final class aud extends a {
    public int cHc;
    public String cHd;
    public String cHe;
    public String cHf;
    public String cHl;
    public String cHm;
    public String efy;
    public String gln;
    public String mAS;
    public axg mFA;
    public mc mFB;
    public String mFt;
    public int mFu;
    public String mFv;
    public String mFw;
    public String mFx;
    public int mFy;
    public int mFz;
    public int mRI;
    public are mRJ;
    public int mRK;
    public int mbX;
    public String mlY;
    public String mlZ;
    public String mvR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mRJ == null) {
                throw new b("Not all required fields were included: ImgBuffer");
            }
            if (this.gln != null) {
                aVar.e(1, this.gln);
            }
            if (this.efy != null) {
                aVar.e(2, this.efy);
            }
            if (this.cHd != null) {
                aVar.e(3, this.cHd);
            }
            if (this.cHe != null) {
                aVar.e(4, this.cHe);
            }
            if (this.cHf != null) {
                aVar.e(5, this.cHf);
            }
            if (this.mFt != null) {
                aVar.e(6, this.mFt);
            }
            aVar.dV(7, this.cHc);
            aVar.dV(8, this.mbX);
            aVar.dV(9, this.mRI);
            if (this.mRJ != null) {
                aVar.dX(10, this.mRJ.aHr());
                this.mRJ.a(aVar);
            }
            aVar.dV(11, this.mRK);
            if (this.mFw != null) {
                aVar.e(12, this.mFw);
            }
            if (this.mFx != null) {
                aVar.e(13, this.mFx);
            }
            aVar.dV(14, this.mFy);
            aVar.dV(15, this.mFu);
            if (this.mFv != null) {
                aVar.e(16, this.mFv);
            }
            if (this.mAS != null) {
                aVar.e(17, this.mAS);
            }
            aVar.dV(21, this.mFz);
            if (this.mFA != null) {
                aVar.dX(22, this.mFA.aHr());
                this.mFA.a(aVar);
            }
            if (this.cHl != null) {
                aVar.e(23, this.cHl);
            }
            if (this.mlY != null) {
                aVar.e(24, this.mlY);
            }
            if (this.mlZ != null) {
                aVar.e(25, this.mlZ);
            }
            if (this.cHm != null) {
                aVar.e(26, this.cHm);
            }
            if (this.mFB != null) {
                aVar.dX(27, this.mFB.aHr());
                this.mFB.a(aVar);
            }
            if (this.mvR == null) {
                return 0;
            }
            aVar.e(28, this.mvR);
            return 0;
        } else if (i == 1) {
            if (this.gln != null) {
                r0 = a.a.a.b.b.a.f(1, this.gln) + 0;
            } else {
                r0 = 0;
            }
            if (this.efy != null) {
                r0 += a.a.a.b.b.a.f(2, this.efy);
            }
            if (this.cHd != null) {
                r0 += a.a.a.b.b.a.f(3, this.cHd);
            }
            if (this.cHe != null) {
                r0 += a.a.a.b.b.a.f(4, this.cHe);
            }
            if (this.cHf != null) {
                r0 += a.a.a.b.b.a.f(5, this.cHf);
            }
            if (this.mFt != null) {
                r0 += a.a.a.b.b.a.f(6, this.mFt);
            }
            r0 = ((r0 + a.a.a.a.dS(7, this.cHc)) + a.a.a.a.dS(8, this.mbX)) + a.a.a.a.dS(9, this.mRI);
            if (this.mRJ != null) {
                r0 += a.a.a.a.dU(10, this.mRJ.aHr());
            }
            r0 += a.a.a.a.dS(11, this.mRK);
            if (this.mFw != null) {
                r0 += a.a.a.b.b.a.f(12, this.mFw);
            }
            if (this.mFx != null) {
                r0 += a.a.a.b.b.a.f(13, this.mFx);
            }
            r0 = (r0 + a.a.a.a.dS(14, this.mFy)) + a.a.a.a.dS(15, this.mFu);
            if (this.mFv != null) {
                r0 += a.a.a.b.b.a.f(16, this.mFv);
            }
            if (this.mAS != null) {
                r0 += a.a.a.b.b.a.f(17, this.mAS);
            }
            r0 += a.a.a.a.dS(21, this.mFz);
            if (this.mFA != null) {
                r0 += a.a.a.a.dU(22, this.mFA.aHr());
            }
            if (this.cHl != null) {
                r0 += a.a.a.b.b.a.f(23, this.cHl);
            }
            if (this.mlY != null) {
                r0 += a.a.a.b.b.a.f(24, this.mlY);
            }
            if (this.mlZ != null) {
                r0 += a.a.a.b.b.a.f(25, this.mlZ);
            }
            if (this.cHm != null) {
                r0 += a.a.a.b.b.a.f(26, this.cHm);
            }
            if (this.mFB != null) {
                r0 += a.a.a.a.dU(27, this.mFB.aHr());
            }
            if (this.mvR != null) {
                r0 += a.a.a.b.b.a.f(28, this.mvR);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mRJ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: ImgBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aud com_tencent_mm_protocal_c_aud = (aud) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aud.gln = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aud.efy = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aud.cHd = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aud.cHe = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_aud.cHf = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aud.mFt = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aud.cHc = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aud.mbX = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aud.mRI = aVar3.pMj.mH();
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aud.mRJ = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aud.mRK = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aud.mFw = aVar3.pMj.readString();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_aud.mFx = aVar3.pMj.readString();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_aud.mFy = aVar3.pMj.mH();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    com_tencent_mm_protocal_c_aud.mFu = aVar3.pMj.mH();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aud.mFv = aVar3.pMj.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_aud.mAS = aVar3.pMj.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_aud.mFz = aVar3.pMj.mH();
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        axg com_tencent_mm_protocal_c_axg = new axg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_axg.a(aVar4, com_tencent_mm_protocal_c_axg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aud.mFA = com_tencent_mm_protocal_c_axg;
                    }
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_aud.cHl = aVar3.pMj.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_aud.mlY = aVar3.pMj.readString();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_aud.mlZ = aVar3.pMj.readString();
                    return 0;
                case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                    com_tencent_mm_protocal_c_aud.cHm = aVar3.pMj.readString();
                    return 0;
                case bv.CTRL_INDEX /*27*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        mc mcVar = new mc();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mcVar.a(aVar4, mcVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aud.mFB = mcVar;
                    }
                    return 0;
                case p.CTRL_INDEX /*28*/:
                    com_tencent_mm_protocal_c_aud.mvR = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
