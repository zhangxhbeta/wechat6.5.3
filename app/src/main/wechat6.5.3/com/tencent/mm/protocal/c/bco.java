package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import android.support.v7.a.a.k;
import com.tencent.mmdb.FileUtils;
import java.util.LinkedList;

public final class bco extends aqp {
    public String gom;
    public String gon;
    public String mDH;
    public String mDJ;
    public int mHA;
    public int mHB;
    public are mHC;
    public int mHD;
    public int mRj;
    public String mYA;
    public int mYc;
    public int mYd;
    public int mYe;
    public int mYj;
    public int mYk;
    public are mYl;
    public int mYm;
    public int mYn;
    public String mYo;
    public int mYp;
    public String mYq;
    public String mYr;
    public int mYs;
    public String mYt;
    public String mYu;
    public String mYv;
    public String mYw;
    public String mYx;
    public String mYy;
    public String mYz;
    public String mbZ;
    public String mcN;
    public int mfj;
    public String mjT;
    public int mjU;
    public int mpQ;
    public int mpt;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mHC == null) {
                throw new b("Not all required fields were included: ThumbData");
            } else if (this.mYl == null) {
                throw new b("Not all required fields were included: VideoData");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.mcN != null) {
                    aVar.e(2, this.mcN);
                }
                if (this.gon != null) {
                    aVar.e(3, this.gon);
                }
                if (this.gom != null) {
                    aVar.e(4, this.gom);
                }
                aVar.dV(5, this.mHA);
                aVar.dV(6, this.mHB);
                if (this.mHC != null) {
                    aVar.dX(7, this.mHC.aHr());
                    this.mHC.a(aVar);
                }
                aVar.dV(8, this.mYj);
                aVar.dV(9, this.mYk);
                if (this.mYl != null) {
                    aVar.dX(10, this.mYl.aHr());
                    this.mYl.a(aVar);
                }
                aVar.dV(11, this.mYm);
                aVar.dV(12, this.mpt);
                aVar.dV(13, this.mHD);
                aVar.dV(14, this.mYn);
                if (this.mbZ != null) {
                    aVar.e(15, this.mbZ);
                }
                if (this.mYo != null) {
                    aVar.e(16, this.mYo);
                }
                if (this.mjT != null) {
                    aVar.e(17, this.mjT);
                }
                aVar.dV(18, this.mfj);
                if (this.mDH != null) {
                    aVar.e(19, this.mDH);
                }
                aVar.dV(20, this.mYc);
                aVar.dV(21, this.mYd);
                aVar.dV(22, this.mYe);
                if (this.mDJ != null) {
                    aVar.e(23, this.mDJ);
                }
                aVar.dV(24, this.mYp);
                aVar.dV(25, this.mpQ);
                if (this.mYq != null) {
                    aVar.e(26, this.mYq);
                }
                if (this.mYr != null) {
                    aVar.e(27, this.mYr);
                }
                aVar.dV(28, this.mYs);
                if (this.mYt != null) {
                    aVar.e(29, this.mYt);
                }
                if (this.mYu != null) {
                    aVar.e(30, this.mYu);
                }
                if (this.mYv != null) {
                    aVar.e(31, this.mYv);
                }
                if (this.mYw != null) {
                    aVar.e(32, this.mYw);
                }
                if (this.mYx != null) {
                    aVar.e(33, this.mYx);
                }
                if (this.mYy != null) {
                    aVar.e(34, this.mYy);
                }
                if (this.mYz != null) {
                    aVar.e(35, this.mYz);
                }
                aVar.dV(36, this.mRj);
                if (this.mYA != null) {
                    aVar.e(37, this.mYA);
                }
                aVar.dV(38, this.mjU);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mcN != null) {
                r0 += a.a.a.b.b.a.f(2, this.mcN);
            }
            if (this.gon != null) {
                r0 += a.a.a.b.b.a.f(3, this.gon);
            }
            if (this.gom != null) {
                r0 += a.a.a.b.b.a.f(4, this.gom);
            }
            r0 = (r0 + a.a.a.a.dS(5, this.mHA)) + a.a.a.a.dS(6, this.mHB);
            if (this.mHC != null) {
                r0 += a.a.a.a.dU(7, this.mHC.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(8, this.mYj)) + a.a.a.a.dS(9, this.mYk);
            if (this.mYl != null) {
                r0 += a.a.a.a.dU(10, this.mYl.aHr());
            }
            r0 = (((r0 + a.a.a.a.dS(11, this.mYm)) + a.a.a.a.dS(12, this.mpt)) + a.a.a.a.dS(13, this.mHD)) + a.a.a.a.dS(14, this.mYn);
            if (this.mbZ != null) {
                r0 += a.a.a.b.b.a.f(15, this.mbZ);
            }
            if (this.mYo != null) {
                r0 += a.a.a.b.b.a.f(16, this.mYo);
            }
            if (this.mjT != null) {
                r0 += a.a.a.b.b.a.f(17, this.mjT);
            }
            r0 += a.a.a.a.dS(18, this.mfj);
            if (this.mDH != null) {
                r0 += a.a.a.b.b.a.f(19, this.mDH);
            }
            r0 = ((r0 + a.a.a.a.dS(20, this.mYc)) + a.a.a.a.dS(21, this.mYd)) + a.a.a.a.dS(22, this.mYe);
            if (this.mDJ != null) {
                r0 += a.a.a.b.b.a.f(23, this.mDJ);
            }
            r0 = (r0 + a.a.a.a.dS(24, this.mYp)) + a.a.a.a.dS(25, this.mpQ);
            if (this.mYq != null) {
                r0 += a.a.a.b.b.a.f(26, this.mYq);
            }
            if (this.mYr != null) {
                r0 += a.a.a.b.b.a.f(27, this.mYr);
            }
            r0 += a.a.a.a.dS(28, this.mYs);
            if (this.mYt != null) {
                r0 += a.a.a.b.b.a.f(29, this.mYt);
            }
            if (this.mYu != null) {
                r0 += a.a.a.b.b.a.f(30, this.mYu);
            }
            if (this.mYv != null) {
                r0 += a.a.a.b.b.a.f(31, this.mYv);
            }
            if (this.mYw != null) {
                r0 += a.a.a.b.b.a.f(32, this.mYw);
            }
            if (this.mYx != null) {
                r0 += a.a.a.b.b.a.f(33, this.mYx);
            }
            if (this.mYy != null) {
                r0 += a.a.a.b.b.a.f(34, this.mYy);
            }
            if (this.mYz != null) {
                r0 += a.a.a.b.b.a.f(35, this.mYz);
            }
            r0 += a.a.a.a.dS(36, this.mRj);
            if (this.mYA != null) {
                r0 += a.a.a.b.b.a.f(37, this.mYA);
            }
            return r0 + a.a.a.a.dS(38, this.mjU);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mHC == null) {
                throw new b("Not all required fields were included: ThumbData");
            } else if (this.mYl != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: VideoData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bco com_tencent_mm_protocal_c_bco = (bco) objArr[1];
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
                        com_tencent_mm_protocal_c_bco.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bco.mcN = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bco.gon = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bco.gom = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bco.mHA = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bco.mHB = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bco.mHC = enVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bco.mYj = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bco.mYk = aVar3.pMj.mH();
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bco.mYl = enVar;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bco.mYm = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bco.mpt = aVar3.pMj.mH();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bco.mHD = aVar3.pMj.mH();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bco.mYn = aVar3.pMj.mH();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bco.mbZ = aVar3.pMj.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bco.mYo = aVar3.pMj.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bco.mjT = aVar3.pMj.readString();
                    return 0;
                case k.MG /*18*/:
                    com_tencent_mm_protocal_c_bco.mfj = aVar3.pMj.mH();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bco.mDH = aVar3.pMj.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_bco.mYc = aVar3.pMj.mH();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_bco.mYd = aVar3.pMj.mH();
                    return 0;
                case k.MM /*22*/:
                    com_tencent_mm_protocal_c_bco.mYe = aVar3.pMj.mH();
                    return 0;
                case k.Nb /*23*/:
                    com_tencent_mm_protocal_c_bco.mDJ = aVar3.pMj.readString();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_bco.mYp = aVar3.pMj.mH();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_bco.mpQ = aVar3.pMj.mH();
                    return 0;
                case k.Kr /*26*/:
                    com_tencent_mm_protocal_c_bco.mYq = aVar3.pMj.readString();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_bco.mYr = aVar3.pMj.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_bco.mYs = aVar3.pMj.mH();
                    return 0;
                case 29:
                    com_tencent_mm_protocal_c_bco.mYt = aVar3.pMj.readString();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_bco.mYu = aVar3.pMj.readString();
                    return 0;
                case 31:
                    com_tencent_mm_protocal_c_bco.mYv = aVar3.pMj.readString();
                    return 0;
                case FileUtils.S_IRGRP /*32*/:
                    com_tencent_mm_protocal_c_bco.mYw = aVar3.pMj.readString();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_bco.mYx = aVar3.pMj.readString();
                    return 0;
                case 34:
                    com_tencent_mm_protocal_c_bco.mYy = aVar3.pMj.readString();
                    return 0;
                case 35:
                    com_tencent_mm_protocal_c_bco.mYz = aVar3.pMj.readString();
                    return 0;
                case 36:
                    com_tencent_mm_protocal_c_bco.mRj = aVar3.pMj.mH();
                    return 0;
                case 37:
                    com_tencent_mm_protocal_c_bco.mYA = aVar3.pMj.readString();
                    return 0;
                case 38:
                    com_tencent_mm_protocal_c_bco.mjU = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
