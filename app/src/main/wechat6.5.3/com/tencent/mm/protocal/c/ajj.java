package com.tencent.mm.protocal.c;

import android.support.v7.a.a.k;
import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;
import com.tencent.mmdb.FileUtils;
import java.util.LinkedList;

public final class ajj extends a {
    public int cHc;
    public String cHd;
    public String cHe;
    public String cHf;
    public int cHg;
    public String cHh;
    public int cHi;
    public int cHj;
    public String cHk;
    public String cHl;
    public int eeO;
    public arf mEj;
    public int mFu;
    public String mFv;
    public String mFw;
    public String mFx;
    public int mFy;
    public int mIZ;
    public int mJD;
    public int mJE;
    public b mJF;
    public int mJH = 2048;
    public arf mJI;
    public arf mJJ;
    public int mJK;
    public int mJL;
    public int mJM;
    public int mJN;
    public int mJO;
    public abj mJP;
    public int mJQ;
    public String mJR;
    public nh mJr;
    public int mar;
    public int mau;
    public arf moM;
    public long mrx;
    public String mry;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.moM == null) {
                throw new a.a.a.b("Not all required fields were included: UserName");
            } else if (this.mEj == null) {
                throw new a.a.a.b("Not all required fields were included: NickName");
            } else if (this.mJI == null) {
                throw new a.a.a.b("Not all required fields were included: BindEmail");
            } else if (this.mJJ == null) {
                throw new a.a.a.b("Not all required fields were included: BindMobile");
            } else {
                aVar.dV(1, this.mJH);
                if (this.moM != null) {
                    aVar.dX(2, this.moM.aHr());
                    this.moM.a(aVar);
                }
                if (this.mEj != null) {
                    aVar.dX(3, this.mEj.aHr());
                    this.mEj.a(aVar);
                }
                aVar.dV(4, this.mar);
                if (this.mJI != null) {
                    aVar.dX(5, this.mJI.aHr());
                    this.mJI.a(aVar);
                }
                if (this.mJJ != null) {
                    aVar.dX(6, this.mJJ.aHr());
                    this.mJJ.a(aVar);
                }
                aVar.dV(7, this.eeO);
                aVar.dV(8, this.mJE);
                if (this.mJF != null) {
                    aVar.b(9, this.mJF);
                }
                aVar.dV(10, this.cHc);
                if (this.cHd != null) {
                    aVar.e(11, this.cHd);
                }
                if (this.cHe != null) {
                    aVar.e(12, this.cHe);
                }
                if (this.cHf != null) {
                    aVar.e(13, this.cHf);
                }
                aVar.dV(14, this.cHg);
                if (this.mJr != null) {
                    aVar.dX(15, this.mJr.aHr());
                    this.mJr.a(aVar);
                }
                aVar.dV(16, this.mau);
                aVar.dV(17, this.mFu);
                if (this.mFv != null) {
                    aVar.e(18, this.mFv);
                }
                aVar.dV(19, this.mJK);
                aVar.dV(20, this.mJL);
                aVar.dV(21, this.mIZ);
                aVar.dV(22, this.mJM);
                aVar.dV(23, this.mJN);
                if (this.mFw != null) {
                    aVar.e(24, this.mFw);
                }
                aVar.dV(25, this.mJO);
                if (this.mJP != null) {
                    aVar.dX(26, this.mJP.aHr());
                    this.mJP.a(aVar);
                }
                if (this.cHh != null) {
                    aVar.e(27, this.cHh);
                }
                if (this.mFx != null) {
                    aVar.e(28, this.mFx);
                }
                aVar.dV(29, this.mFy);
                aVar.dV(30, this.mJQ);
                aVar.C(31, this.mrx);
                if (this.mry != null) {
                    aVar.e(32, this.mry);
                }
                aVar.dV(33, this.cHj);
                aVar.dV(34, this.cHi);
                if (this.cHk != null) {
                    aVar.e(35, this.cHk);
                }
                aVar.dV(36, this.mJD);
                if (this.mJR != null) {
                    aVar.e(37, this.mJR);
                }
                if (this.cHl != null) {
                    aVar.e(38, this.cHl);
                }
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mJH) + 0;
            if (this.moM != null) {
                r0 += a.a.a.a.dU(2, this.moM.aHr());
            }
            if (this.mEj != null) {
                r0 += a.a.a.a.dU(3, this.mEj.aHr());
            }
            r0 += a.a.a.a.dS(4, this.mar);
            if (this.mJI != null) {
                r0 += a.a.a.a.dU(5, this.mJI.aHr());
            }
            if (this.mJJ != null) {
                r0 += a.a.a.a.dU(6, this.mJJ.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(7, this.eeO)) + a.a.a.a.dS(8, this.mJE);
            if (this.mJF != null) {
                r0 += a.a.a.a.a(9, this.mJF);
            }
            r0 += a.a.a.a.dS(10, this.cHc);
            if (this.cHd != null) {
                r0 += a.a.a.b.b.a.f(11, this.cHd);
            }
            if (this.cHe != null) {
                r0 += a.a.a.b.b.a.f(12, this.cHe);
            }
            if (this.cHf != null) {
                r0 += a.a.a.b.b.a.f(13, this.cHf);
            }
            r0 += a.a.a.a.dS(14, this.cHg);
            if (this.mJr != null) {
                r0 += a.a.a.a.dU(15, this.mJr.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(16, this.mau)) + a.a.a.a.dS(17, this.mFu);
            if (this.mFv != null) {
                r0 += a.a.a.b.b.a.f(18, this.mFv);
            }
            r0 = ((((r0 + a.a.a.a.dS(19, this.mJK)) + a.a.a.a.dS(20, this.mJL)) + a.a.a.a.dS(21, this.mIZ)) + a.a.a.a.dS(22, this.mJM)) + a.a.a.a.dS(23, this.mJN);
            if (this.mFw != null) {
                r0 += a.a.a.b.b.a.f(24, this.mFw);
            }
            r0 += a.a.a.a.dS(25, this.mJO);
            if (this.mJP != null) {
                r0 += a.a.a.a.dU(26, this.mJP.aHr());
            }
            if (this.cHh != null) {
                r0 += a.a.a.b.b.a.f(27, this.cHh);
            }
            if (this.mFx != null) {
                r0 += a.a.a.b.b.a.f(28, this.mFx);
            }
            r0 = ((r0 + a.a.a.a.dS(29, this.mFy)) + a.a.a.a.dS(30, this.mJQ)) + a.a.a.a.B(31, this.mrx);
            if (this.mry != null) {
                r0 += a.a.a.b.b.a.f(32, this.mry);
            }
            r0 = (r0 + a.a.a.a.dS(33, this.cHj)) + a.a.a.a.dS(34, this.cHi);
            if (this.cHk != null) {
                r0 += a.a.a.b.b.a.f(35, this.cHk);
            }
            r0 += a.a.a.a.dS(36, this.mJD);
            if (this.mJR != null) {
                r0 += a.a.a.b.b.a.f(37, this.mJR);
            }
            if (this.cHl != null) {
                return r0 + a.a.a.b.b.a.f(38, this.cHl);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.moM == null) {
                throw new a.a.a.b("Not all required fields were included: UserName");
            } else if (this.mEj == null) {
                throw new a.a.a.b("Not all required fields were included: NickName");
            } else if (this.mJI == null) {
                throw new a.a.a.b("Not all required fields were included: BindEmail");
            } else if (this.mJJ != null) {
                return 0;
            } else {
                throw new a.a.a.b("Not all required fields were included: BindMobile");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ajj com_tencent_mm_protocal_c_ajj = (ajj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_arf;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_ajj.mJH = aVar3.pMj.mH();
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajj.moM = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajj.mEj = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ajj.mar = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajj.mJI = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajj.mJJ = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ajj.eeO = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ajj.mJE = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ajj.mJF = aVar3.bQK();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ajj.cHc = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ajj.cHd = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ajj.cHe = aVar3.pMj.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ajj.cHf = aVar3.pMj.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ajj.cHg = aVar3.pMj.mH();
                    return 0;
                case 15:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new nh();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajj.mJr = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_ajj.mau = aVar3.pMj.mH();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_ajj.mFu = aVar3.pMj.mH();
                    return 0;
                case k.MG /*18*/:
                    com_tencent_mm_protocal_c_ajj.mFv = aVar3.pMj.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_ajj.mJK = aVar3.pMj.mH();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_ajj.mJL = aVar3.pMj.mH();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_ajj.mIZ = aVar3.pMj.mH();
                    return 0;
                case k.MM /*22*/:
                    com_tencent_mm_protocal_c_ajj.mJM = aVar3.pMj.mH();
                    return 0;
                case k.Nb /*23*/:
                    com_tencent_mm_protocal_c_ajj.mJN = aVar3.pMj.mH();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_ajj.mFw = aVar3.pMj.readString();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_ajj.mJO = aVar3.pMj.mH();
                    return 0;
                case k.Kr /*26*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new abj();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajj.mJP = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_ajj.cHh = aVar3.pMj.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_ajj.mFx = aVar3.pMj.readString();
                    return 0;
                case 29:
                    com_tencent_mm_protocal_c_ajj.mFy = aVar3.pMj.mH();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_ajj.mJQ = aVar3.pMj.mH();
                    return 0;
                case 31:
                    com_tencent_mm_protocal_c_ajj.mrx = aVar3.pMj.mI();
                    return 0;
                case FileUtils.S_IRGRP /*32*/:
                    com_tencent_mm_protocal_c_ajj.mry = aVar3.pMj.readString();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_ajj.cHj = aVar3.pMj.mH();
                    return 0;
                case 34:
                    com_tencent_mm_protocal_c_ajj.cHi = aVar3.pMj.mH();
                    return 0;
                case 35:
                    com_tencent_mm_protocal_c_ajj.cHk = aVar3.pMj.readString();
                    return 0;
                case 36:
                    com_tencent_mm_protocal_c_ajj.mJD = aVar3.pMj.mH();
                    return 0;
                case 37:
                    com_tencent_mm_protocal_c_ajj.mJR = aVar3.pMj.readString();
                    return 0;
                case 38:
                    com_tencent_mm_protocal_c_ajj.cHl = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
