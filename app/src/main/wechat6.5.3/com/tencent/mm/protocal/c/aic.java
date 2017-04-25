package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import com.tencent.mm.plugin.appbrand.jsapi.bf;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.qqvideo.proxy.common.VcSystemInfo;
import java.util.LinkedList;

public final class aic extends a {
    public String aZj;
    public String bnX;
    public int cxZ;
    public int hav;
    public int jJL;
    public int mHR;
    public long mIA;
    public String mIB;
    public boolean mIC;
    public int mIl;
    public int mIm;
    public LinkedList<ago> mIn = new LinkedList();
    public LinkedList<axj> mIo = new LinkedList();
    public int mIp;
    public long mIq;
    public int mIr;
    public LinkedList<Long> mIs = new LinkedList();
    public int mIt;
    public String mIu;
    public int mIv;
    public LinkedList<arf> mIw = new LinkedList();
    public awk mIx;
    public LinkedList<awr> mIy = new LinkedList();
    public String mIz;
    public String mbN;
    public String mpB;
    public String token;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mIl);
            aVar.dV(2, this.mIm);
            aVar.dV(3, this.mHR);
            if (this.mbN != null) {
                aVar.e(4, this.mbN);
            }
            aVar.d(5, 8, this.mIn);
            aVar.d(6, 8, this.mIo);
            aVar.dV(7, this.mIp);
            aVar.dV(8, this.cxZ);
            aVar.C(9, this.mIq);
            aVar.dV(10, this.mIr);
            aVar.d(11, 3, this.mIs);
            aVar.dV(12, this.jJL);
            aVar.dV(13, this.mIt);
            if (this.token != null) {
                aVar.e(14, this.token);
            }
            if (this.mIu != null) {
                aVar.e(15, this.mIu);
            }
            aVar.dV(16, this.mIv);
            aVar.d(17, 8, this.mIw);
            if (this.mIx != null) {
                aVar.dX(18, this.mIx.aHr());
                this.mIx.a(aVar);
            }
            if (this.bnX != null) {
                aVar.e(19, this.bnX);
            }
            aVar.d(20, 8, this.mIy);
            if (this.aZj != null) {
                aVar.e(21, this.aZj);
            }
            if (this.mIz != null) {
                aVar.e(22, this.mIz);
            }
            if (this.mpB != null) {
                aVar.e(23, this.mpB);
            }
            aVar.dV(24, this.hav);
            aVar.C(25, this.mIA);
            if (this.mIB != null) {
                aVar.e(26, this.mIB);
            }
            aVar.ab(27, this.mIC);
            return 0;
        } else if (i == 1) {
            r0 = ((a.a.a.a.dS(1, this.mIl) + 0) + a.a.a.a.dS(2, this.mIm)) + a.a.a.a.dS(3, this.mHR);
            if (this.mbN != null) {
                r0 += a.a.a.b.b.a.f(4, this.mbN);
            }
            r0 = ((((((((r0 + a.a.a.a.c(5, 8, this.mIn)) + a.a.a.a.c(6, 8, this.mIo)) + a.a.a.a.dS(7, this.mIp)) + a.a.a.a.dS(8, this.cxZ)) + a.a.a.a.B(9, this.mIq)) + a.a.a.a.dS(10, this.mIr)) + a.a.a.a.c(11, 3, this.mIs)) + a.a.a.a.dS(12, this.jJL)) + a.a.a.a.dS(13, this.mIt);
            if (this.token != null) {
                r0 += a.a.a.b.b.a.f(14, this.token);
            }
            if (this.mIu != null) {
                r0 += a.a.a.b.b.a.f(15, this.mIu);
            }
            r0 = (r0 + a.a.a.a.dS(16, this.mIv)) + a.a.a.a.c(17, 8, this.mIw);
            if (this.mIx != null) {
                r0 += a.a.a.a.dU(18, this.mIx.aHr());
            }
            if (this.bnX != null) {
                r0 += a.a.a.b.b.a.f(19, this.bnX);
            }
            r0 += a.a.a.a.c(20, 8, this.mIy);
            if (this.aZj != null) {
                r0 += a.a.a.b.b.a.f(21, this.aZj);
            }
            if (this.mIz != null) {
                r0 += a.a.a.b.b.a.f(22, this.mIz);
            }
            if (this.mpB != null) {
                r0 += a.a.a.b.b.a.f(23, this.mpB);
            }
            r0 = (r0 + a.a.a.a.dS(24, this.hav)) + a.a.a.a.B(25, this.mIA);
            if (this.mIB != null) {
                r0 += a.a.a.b.b.a.f(26, this.mIB);
            }
            return r0 + (a.a.a.b.b.a.cw(27) + 1);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mIn.clear();
            this.mIo.clear();
            this.mIs.clear();
            this.mIw.clear();
            this.mIy.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            aic com_tencent_mm_protocal_c_aic = (aic) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_aic.mIl = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aic.mIm = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aic.mHR = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aic.mbN = aVar3.pMj.readString();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ago com_tencent_mm_protocal_c_ago = new ago();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ago.a(aVar4, com_tencent_mm_protocal_c_ago, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aic.mIn.add(com_tencent_mm_protocal_c_ago);
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        axj com_tencent_mm_protocal_c_axj = new axj();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_axj.a(aVar4, com_tencent_mm_protocal_c_axj, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aic.mIo.add(com_tencent_mm_protocal_c_axj);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_aic.mIp = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_aic.cxZ = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_aic.mIq = aVar3.pMj.mI();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_aic.mIr = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_aic.mIs.add(Long.valueOf(aVar3.pMj.mI()));
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aic.jJL = aVar3.pMj.mH();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_aic.mIt = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_aic.token = aVar3.pMj.readString();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    com_tencent_mm_protocal_c_aic.mIu = aVar3.pMj.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aic.mIv = aVar3.pMj.mH();
                    return 0;
                case 17:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        arf com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aic.mIw.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 18:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        awk com_tencent_mm_protocal_c_awk = new awk();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_awk.a(aVar4, com_tencent_mm_protocal_c_awk, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aic.mIx = com_tencent_mm_protocal_c_awk;
                    }
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_aic.bnX = aVar3.pMj.readString();
                    return 0;
                case 20:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        awr com_tencent_mm_protocal_c_awr = new awr();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_awr.a(aVar4, com_tencent_mm_protocal_c_awr, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aic.mIy.add(com_tencent_mm_protocal_c_awr);
                    }
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_aic.aZj = aVar3.pMj.readString();
                    return 0;
                case bf.CTRL_INDEX /*22*/:
                    com_tencent_mm_protocal_c_aic.mIz = aVar3.pMj.readString();
                    return 0;
                case 23:
                    com_tencent_mm_protocal_c_aic.mpB = aVar3.pMj.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_aic.hav = aVar3.pMj.mH();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_aic.mIA = aVar3.pMj.mI();
                    return 0;
                case VcSystemInfo.PLAYER_LEVEL_26 /*26*/:
                    com_tencent_mm_protocal_c_aic.mIB = aVar3.pMj.readString();
                    return 0;
                case bv.CTRL_INDEX /*27*/:
                    com_tencent_mm_protocal_c_aic.mIC = aVar3.bQJ();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
