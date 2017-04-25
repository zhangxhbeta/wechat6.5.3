package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import android.support.v7.a.a.k;
import java.util.LinkedList;

public final class bci extends aqp {
    public int gll;
    public String mDJ;
    public int mRj;
    public int mUu;
    public arf mXW;
    public String mXX;
    public String mXY;
    public int mXZ;
    public int mYa;
    public String mYb;
    public int mYc;
    public int mYd;
    public int mYe;
    public int mYf;
    public arf mbU;
    public arf mbV;
    public String mbZ;
    public int mdA;
    public int mdB;
    public int mdz;
    public are mfg;
    public int mfj;
    public String mfo;
    public String mjT;
    public int mjU;
    public int mnk;
    public String mpC;
    public int mpQ;
    public int mzC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mXW == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.mbU == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.mbV == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.mfg == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.mXW != null) {
                    aVar.dX(2, this.mXW.aHr());
                    this.mXW.a(aVar);
                }
                if (this.mbU != null) {
                    aVar.dX(3, this.mbU.aHr());
                    this.mbU.a(aVar);
                }
                if (this.mbV != null) {
                    aVar.dX(4, this.mbV.aHr());
                    this.mbV.a(aVar);
                }
                aVar.dV(5, this.mdz);
                aVar.dV(6, this.mdA);
                aVar.dV(7, this.mdB);
                if (this.mfg != null) {
                    aVar.dX(8, this.mfg.aHr());
                    this.mfg.a(aVar);
                }
                aVar.dV(9, this.gll);
                if (this.mbZ != null) {
                    aVar.e(10, this.mbZ);
                }
                aVar.dV(11, this.mzC);
                aVar.dV(12, this.mnk);
                aVar.dV(13, this.mUu);
                if (this.mfo != null) {
                    aVar.e(14, this.mfo);
                }
                if (this.mXX != null) {
                    aVar.e(15, this.mXX);
                }
                if (this.mXY != null) {
                    aVar.e(16, this.mXY);
                }
                if (this.mjT != null) {
                    aVar.e(17, this.mjT);
                }
                aVar.dV(18, this.mfj);
                aVar.dV(19, this.mXZ);
                aVar.dV(20, this.mYa);
                if (this.mYb != null) {
                    aVar.e(21, this.mYb);
                }
                aVar.dV(22, this.mYc);
                aVar.dV(23, this.mYd);
                aVar.dV(24, this.mYe);
                if (this.mDJ != null) {
                    aVar.e(25, this.mDJ);
                }
                aVar.dV(26, this.mpQ);
                if (this.mpC != null) {
                    aVar.e(27, this.mpC);
                }
                aVar.dV(28, this.mjU);
                aVar.dV(29, this.mYf);
                aVar.dV(30, this.mRj);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mXW != null) {
                r0 += a.a.a.a.dU(2, this.mXW.aHr());
            }
            if (this.mbU != null) {
                r0 += a.a.a.a.dU(3, this.mbU.aHr());
            }
            if (this.mbV != null) {
                r0 += a.a.a.a.dU(4, this.mbV.aHr());
            }
            r0 = ((r0 + a.a.a.a.dS(5, this.mdz)) + a.a.a.a.dS(6, this.mdA)) + a.a.a.a.dS(7, this.mdB);
            if (this.mfg != null) {
                r0 += a.a.a.a.dU(8, this.mfg.aHr());
            }
            r0 += a.a.a.a.dS(9, this.gll);
            if (this.mbZ != null) {
                r0 += a.a.a.b.b.a.f(10, this.mbZ);
            }
            r0 = ((r0 + a.a.a.a.dS(11, this.mzC)) + a.a.a.a.dS(12, this.mnk)) + a.a.a.a.dS(13, this.mUu);
            if (this.mfo != null) {
                r0 += a.a.a.b.b.a.f(14, this.mfo);
            }
            if (this.mXX != null) {
                r0 += a.a.a.b.b.a.f(15, this.mXX);
            }
            if (this.mXY != null) {
                r0 += a.a.a.b.b.a.f(16, this.mXY);
            }
            if (this.mjT != null) {
                r0 += a.a.a.b.b.a.f(17, this.mjT);
            }
            r0 = ((r0 + a.a.a.a.dS(18, this.mfj)) + a.a.a.a.dS(19, this.mXZ)) + a.a.a.a.dS(20, this.mYa);
            if (this.mYb != null) {
                r0 += a.a.a.b.b.a.f(21, this.mYb);
            }
            r0 = ((r0 + a.a.a.a.dS(22, this.mYc)) + a.a.a.a.dS(23, this.mYd)) + a.a.a.a.dS(24, this.mYe);
            if (this.mDJ != null) {
                r0 += a.a.a.b.b.a.f(25, this.mDJ);
            }
            r0 += a.a.a.a.dS(26, this.mpQ);
            if (this.mpC != null) {
                r0 += a.a.a.b.b.a.f(27, this.mpC);
            }
            return ((r0 + a.a.a.a.dS(28, this.mjU)) + a.a.a.a.dS(29, this.mYf)) + a.a.a.a.dS(30, this.mRj);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mXW == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.mbU == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.mbV == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.mfg != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bci com_tencent_mm_protocal_c_bci = (bci) objArr[1];
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
                        com_tencent_mm_protocal_c_bci.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bci.mXW = enVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bci.mbU = enVar;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bci.mbV = enVar;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_bci.mdz = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bci.mdA = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bci.mdB = aVar3.pMj.mH();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bci.mfg = enVar;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bci.gll = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bci.mbZ = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bci.mzC = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bci.mnk = aVar3.pMj.mH();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_bci.mUu = aVar3.pMj.mH();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_bci.mfo = aVar3.pMj.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_bci.mXX = aVar3.pMj.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_bci.mXY = aVar3.pMj.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_bci.mjT = aVar3.pMj.readString();
                    return 0;
                case k.MG /*18*/:
                    com_tencent_mm_protocal_c_bci.mfj = aVar3.pMj.mH();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_bci.mXZ = aVar3.pMj.mH();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_bci.mYa = aVar3.pMj.mH();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_bci.mYb = aVar3.pMj.readString();
                    return 0;
                case k.MM /*22*/:
                    com_tencent_mm_protocal_c_bci.mYc = aVar3.pMj.mH();
                    return 0;
                case k.Nb /*23*/:
                    com_tencent_mm_protocal_c_bci.mYd = aVar3.pMj.mH();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_bci.mYe = aVar3.pMj.mH();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_bci.mDJ = aVar3.pMj.readString();
                    return 0;
                case k.Kr /*26*/:
                    com_tencent_mm_protocal_c_bci.mpQ = aVar3.pMj.mH();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_bci.mpC = aVar3.pMj.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_bci.mjU = aVar3.pMj.mH();
                    return 0;
                case 29:
                    com_tencent_mm_protocal_c_bci.mYf = aVar3.pMj.mH();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_bci.mRj = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
