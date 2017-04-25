package com.tencent.mm.protocal.c;

import a.a.a.b;
import android.support.v7.a.a.k;
import com.tencent.mm.ba.a;
import com.tencent.mmdb.FileUtils;
import java.util.LinkedList;

public final class ais extends a {
    public String bCy;
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
    public String cHm;
    public String gor;
    public String mAS;
    public arf mEj;
    public axg mFA;
    public mc mFB;
    public int mFu;
    public String mFv;
    public String mFw;
    public String mFx;
    public int mFy;
    public arf mIO;
    public arf mIP;
    public arf mIQ;
    public int mIT;
    public arf mIX;
    public int mIY;
    public int mIZ;
    public String mJa;
    public String mJb;
    public String mJc;
    public String mJd;
    public String mJe;
    public String mJf;
    public String mJg;
    public String mJh;
    public bs mJi;
    public int mJj;
    public int mJk;
    public int mJl;
    public int mJm;
    public String mJn;
    public ams mJo;
    public int mJp;
    public are mbY;
    public int mcP;
    public String mdJ;
    public String mlY;
    public String mlZ;
    public int mnV;
    public int mnW;
    public arf moC;
    public arf moD;
    public arf moM;
    public String moP;
    public int mob;
    public int moc;
    public LinkedList<ard> mod = new LinkedList();
    public int mof;
    public int mog;
    public jo mxC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.moM == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.mEj == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.moC == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.moD == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.mbY == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                if (this.moM != null) {
                    aVar.dX(1, this.moM.aHr());
                    this.moM.a(aVar);
                }
                if (this.mEj != null) {
                    aVar.dX(2, this.mEj.aHr());
                    this.mEj.a(aVar);
                }
                if (this.moC != null) {
                    aVar.dX(3, this.moC.aHr());
                    this.moC.a(aVar);
                }
                if (this.moD != null) {
                    aVar.dX(4, this.moD.aHr());
                    this.moD.a(aVar);
                }
                aVar.dV(5, this.cHc);
                if (this.mbY != null) {
                    aVar.dX(6, this.mbY.aHr());
                    this.mbY.a(aVar);
                }
                aVar.dV(7, this.mnV);
                aVar.dV(8, this.mnW);
                aVar.dV(9, this.mIT);
                if (this.mIO != null) {
                    aVar.dX(10, this.mIO.aHr());
                    this.mIO.a(aVar);
                }
                if (this.mIP != null) {
                    aVar.dX(11, this.mIP.aHr());
                    this.mIP.a(aVar);
                }
                if (this.mIQ != null) {
                    aVar.dX(12, this.mIQ.aHr());
                    this.mIQ.a(aVar);
                }
                aVar.dV(13, this.mob);
                aVar.dV(14, this.moc);
                aVar.d(15, 8, this.mod);
                if (this.mIX != null) {
                    aVar.dX(16, this.mIX.aHr());
                    this.mIX.a(aVar);
                }
                aVar.dV(17, this.mof);
                aVar.dV(18, this.mog);
                if (this.cHd != null) {
                    aVar.e(19, this.cHd);
                }
                if (this.cHe != null) {
                    aVar.e(20, this.cHe);
                }
                if (this.cHf != null) {
                    aVar.e(21, this.cHf);
                }
                aVar.dV(22, this.cHg);
                aVar.dV(23, this.mIY);
                aVar.dV(24, this.mFu);
                if (this.mFv != null) {
                    aVar.e(25, this.mFv);
                }
                aVar.dV(26, this.mIZ);
                aVar.dV(27, this.mcP);
                if (this.mFw != null) {
                    aVar.e(28, this.mFw);
                }
                if (this.mAS != null) {
                    aVar.e(29, this.mAS);
                }
                if (this.cHh != null) {
                    aVar.e(30, this.cHh);
                }
                if (this.mJa != null) {
                    aVar.e(31, this.mJa);
                }
                if (this.mFx != null) {
                    aVar.e(32, this.mFx);
                }
                aVar.dV(33, this.mFy);
                aVar.dV(34, this.cHj);
                aVar.dV(35, this.cHi);
                if (this.cHk != null) {
                    aVar.e(36, this.cHk);
                }
                if (this.mFA != null) {
                    aVar.dX(37, this.mFA.aHr());
                    this.mFA.a(aVar);
                }
                if (this.cHl != null) {
                    aVar.e(38, this.cHl);
                }
                if (this.mlY != null) {
                    aVar.e(39, this.mlY);
                }
                if (this.mlZ != null) {
                    aVar.e(40, this.mlZ);
                }
                if (this.cHm != null) {
                    aVar.e(41, this.cHm);
                }
                if (this.mFB != null) {
                    aVar.dX(42, this.mFB.aHr());
                    this.mFB.a(aVar);
                }
                if (this.mJb != null) {
                    aVar.e(43, this.mJb);
                }
                if (this.mJc != null) {
                    aVar.e(44, this.mJc);
                }
                if (this.mJd != null) {
                    aVar.e(45, this.mJd);
                }
                if (this.mJe != null) {
                    aVar.e(46, this.mJe);
                }
                if (this.mJf != null) {
                    aVar.e(47, this.mJf);
                }
                if (this.mJg != null) {
                    aVar.e(48, this.mJg);
                }
                if (this.mJh != null) {
                    aVar.e(49, this.mJh);
                }
                if (this.mJi != null) {
                    aVar.dX(50, this.mJi.aHr());
                    this.mJi.a(aVar);
                }
                aVar.dV(53, this.mJj);
                if (this.gor != null) {
                    aVar.e(54, this.gor);
                }
                aVar.dV(55, this.mJk);
                aVar.dV(56, this.mJl);
                if (this.mxC != null) {
                    aVar.dX(57, this.mxC.aHr());
                    this.mxC.a(aVar);
                }
                aVar.dV(58, this.mJm);
                if (this.mdJ != null) {
                    aVar.e(59, this.mdJ);
                }
                if (this.mJn != null) {
                    aVar.e(60, this.mJn);
                }
                if (this.moP != null) {
                    aVar.e(61, this.moP);
                }
                if (this.mJo != null) {
                    aVar.dX(62, this.mJo.aHr());
                    this.mJo.a(aVar);
                }
                if (this.bCy != null) {
                    aVar.e(63, this.bCy);
                }
                aVar.dV(64, this.mJp);
                return 0;
            }
        } else if (i == 1) {
            if (this.moM != null) {
                r0 = a.a.a.a.dU(1, this.moM.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mEj != null) {
                r0 += a.a.a.a.dU(2, this.mEj.aHr());
            }
            if (this.moC != null) {
                r0 += a.a.a.a.dU(3, this.moC.aHr());
            }
            if (this.moD != null) {
                r0 += a.a.a.a.dU(4, this.moD.aHr());
            }
            r0 += a.a.a.a.dS(5, this.cHc);
            if (this.mbY != null) {
                r0 += a.a.a.a.dU(6, this.mbY.aHr());
            }
            r0 = ((r0 + a.a.a.a.dS(7, this.mnV)) + a.a.a.a.dS(8, this.mnW)) + a.a.a.a.dS(9, this.mIT);
            if (this.mIO != null) {
                r0 += a.a.a.a.dU(10, this.mIO.aHr());
            }
            if (this.mIP != null) {
                r0 += a.a.a.a.dU(11, this.mIP.aHr());
            }
            if (this.mIQ != null) {
                r0 += a.a.a.a.dU(12, this.mIQ.aHr());
            }
            r0 = ((r0 + a.a.a.a.dS(13, this.mob)) + a.a.a.a.dS(14, this.moc)) + a.a.a.a.c(15, 8, this.mod);
            if (this.mIX != null) {
                r0 += a.a.a.a.dU(16, this.mIX.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(17, this.mof)) + a.a.a.a.dS(18, this.mog);
            if (this.cHd != null) {
                r0 += a.a.a.b.b.a.f(19, this.cHd);
            }
            if (this.cHe != null) {
                r0 += a.a.a.b.b.a.f(20, this.cHe);
            }
            if (this.cHf != null) {
                r0 += a.a.a.b.b.a.f(21, this.cHf);
            }
            r0 = ((r0 + a.a.a.a.dS(22, this.cHg)) + a.a.a.a.dS(23, this.mIY)) + a.a.a.a.dS(24, this.mFu);
            if (this.mFv != null) {
                r0 += a.a.a.b.b.a.f(25, this.mFv);
            }
            r0 = (r0 + a.a.a.a.dS(26, this.mIZ)) + a.a.a.a.dS(27, this.mcP);
            if (this.mFw != null) {
                r0 += a.a.a.b.b.a.f(28, this.mFw);
            }
            if (this.mAS != null) {
                r0 += a.a.a.b.b.a.f(29, this.mAS);
            }
            if (this.cHh != null) {
                r0 += a.a.a.b.b.a.f(30, this.cHh);
            }
            if (this.mJa != null) {
                r0 += a.a.a.b.b.a.f(31, this.mJa);
            }
            if (this.mFx != null) {
                r0 += a.a.a.b.b.a.f(32, this.mFx);
            }
            r0 = ((r0 + a.a.a.a.dS(33, this.mFy)) + a.a.a.a.dS(34, this.cHj)) + a.a.a.a.dS(35, this.cHi);
            if (this.cHk != null) {
                r0 += a.a.a.b.b.a.f(36, this.cHk);
            }
            if (this.mFA != null) {
                r0 += a.a.a.a.dU(37, this.mFA.aHr());
            }
            if (this.cHl != null) {
                r0 += a.a.a.b.b.a.f(38, this.cHl);
            }
            if (this.mlY != null) {
                r0 += a.a.a.b.b.a.f(39, this.mlY);
            }
            if (this.mlZ != null) {
                r0 += a.a.a.b.b.a.f(40, this.mlZ);
            }
            if (this.cHm != null) {
                r0 += a.a.a.b.b.a.f(41, this.cHm);
            }
            if (this.mFB != null) {
                r0 += a.a.a.a.dU(42, this.mFB.aHr());
            }
            if (this.mJb != null) {
                r0 += a.a.a.b.b.a.f(43, this.mJb);
            }
            if (this.mJc != null) {
                r0 += a.a.a.b.b.a.f(44, this.mJc);
            }
            if (this.mJd != null) {
                r0 += a.a.a.b.b.a.f(45, this.mJd);
            }
            if (this.mJe != null) {
                r0 += a.a.a.b.b.a.f(46, this.mJe);
            }
            if (this.mJf != null) {
                r0 += a.a.a.b.b.a.f(47, this.mJf);
            }
            if (this.mJg != null) {
                r0 += a.a.a.b.b.a.f(48, this.mJg);
            }
            if (this.mJh != null) {
                r0 += a.a.a.b.b.a.f(49, this.mJh);
            }
            if (this.mJi != null) {
                r0 += a.a.a.a.dU(50, this.mJi.aHr());
            }
            r0 += a.a.a.a.dS(53, this.mJj);
            if (this.gor != null) {
                r0 += a.a.a.b.b.a.f(54, this.gor);
            }
            r0 = (r0 + a.a.a.a.dS(55, this.mJk)) + a.a.a.a.dS(56, this.mJl);
            if (this.mxC != null) {
                r0 += a.a.a.a.dU(57, this.mxC.aHr());
            }
            r0 += a.a.a.a.dS(58, this.mJm);
            if (this.mdJ != null) {
                r0 += a.a.a.b.b.a.f(59, this.mdJ);
            }
            if (this.mJn != null) {
                r0 += a.a.a.b.b.a.f(60, this.mJn);
            }
            if (this.moP != null) {
                r0 += a.a.a.b.b.a.f(61, this.moP);
            }
            if (this.mJo != null) {
                r0 += a.a.a.a.dU(62, this.mJo.aHr());
            }
            if (this.bCy != null) {
                r0 += a.a.a.b.b.a.f(63, this.bCy);
            }
            return r0 + a.a.a.a.dS(64, this.mJp);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mod.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.moM == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.mEj == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.moC == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.moD == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.mbY != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ais com_tencent_mm_protocal_c_ais = (ais) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a com_tencent_mm_protocal_c_arf;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ais.moM = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ais.mEj = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ais.moC = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ais.moD = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ais.cHc = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ais.mbY = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ais.mnV = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ais.mnW = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ais.mIT = aVar3.pMj.mH();
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ais.mIO = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ais.mIP = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 12:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ais.mIQ = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ais.mob = aVar3.pMj.mH();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ais.moc = aVar3.pMj.mH();
                    return 0;
                case 15:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new ard();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ais.mod.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 16:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ais.mIX = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_ais.mof = aVar3.pMj.mH();
                    return 0;
                case k.MG /*18*/:
                    com_tencent_mm_protocal_c_ais.mog = aVar3.pMj.mH();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_ais.cHd = aVar3.pMj.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_ais.cHe = aVar3.pMj.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_ais.cHf = aVar3.pMj.readString();
                    return 0;
                case k.MM /*22*/:
                    com_tencent_mm_protocal_c_ais.cHg = aVar3.pMj.mH();
                    return 0;
                case k.Nb /*23*/:
                    com_tencent_mm_protocal_c_ais.mIY = aVar3.pMj.mH();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_ais.mFu = aVar3.pMj.mH();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_ais.mFv = aVar3.pMj.readString();
                    return 0;
                case k.Kr /*26*/:
                    com_tencent_mm_protocal_c_ais.mIZ = aVar3.pMj.mH();
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_ais.mcP = aVar3.pMj.mH();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_ais.mFw = aVar3.pMj.readString();
                    return 0;
                case 29:
                    com_tencent_mm_protocal_c_ais.mAS = aVar3.pMj.readString();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_ais.cHh = aVar3.pMj.readString();
                    return 0;
                case 31:
                    com_tencent_mm_protocal_c_ais.mJa = aVar3.pMj.readString();
                    return 0;
                case FileUtils.S_IRGRP /*32*/:
                    com_tencent_mm_protocal_c_ais.mFx = aVar3.pMj.readString();
                    return 0;
                case 33:
                    com_tencent_mm_protocal_c_ais.mFy = aVar3.pMj.mH();
                    return 0;
                case 34:
                    com_tencent_mm_protocal_c_ais.cHj = aVar3.pMj.mH();
                    return 0;
                case 35:
                    com_tencent_mm_protocal_c_ais.cHi = aVar3.pMj.mH();
                    return 0;
                case 36:
                    com_tencent_mm_protocal_c_ais.cHk = aVar3.pMj.readString();
                    return 0;
                case 37:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new axg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ais.mFA = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 38:
                    com_tencent_mm_protocal_c_ais.cHl = aVar3.pMj.readString();
                    return 0;
                case 39:
                    com_tencent_mm_protocal_c_ais.mlY = aVar3.pMj.readString();
                    return 0;
                case 40:
                    com_tencent_mm_protocal_c_ais.mlZ = aVar3.pMj.readString();
                    return 0;
                case 41:
                    com_tencent_mm_protocal_c_ais.cHm = aVar3.pMj.readString();
                    return 0;
                case 42:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new mc();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ais.mFB = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 43:
                    com_tencent_mm_protocal_c_ais.mJb = aVar3.pMj.readString();
                    return 0;
                case 44:
                    com_tencent_mm_protocal_c_ais.mJc = aVar3.pMj.readString();
                    return 0;
                case 45:
                    com_tencent_mm_protocal_c_ais.mJd = aVar3.pMj.readString();
                    return 0;
                case 46:
                    com_tencent_mm_protocal_c_ais.mJe = aVar3.pMj.readString();
                    return 0;
                case 47:
                    com_tencent_mm_protocal_c_ais.mJf = aVar3.pMj.readString();
                    return 0;
                case 48:
                    com_tencent_mm_protocal_c_ais.mJg = aVar3.pMj.readString();
                    return 0;
                case 49:
                    com_tencent_mm_protocal_c_ais.mJh = aVar3.pMj.readString();
                    return 0;
                case 50:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new bs();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ais.mJi = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 53:
                    com_tencent_mm_protocal_c_ais.mJj = aVar3.pMj.mH();
                    return 0;
                case 54:
                    com_tencent_mm_protocal_c_ais.gor = aVar3.pMj.readString();
                    return 0;
                case 55:
                    com_tencent_mm_protocal_c_ais.mJk = aVar3.pMj.mH();
                    return 0;
                case FileUtils.S_IRWXG /*56*/:
                    com_tencent_mm_protocal_c_ais.mJl = aVar3.pMj.mH();
                    return 0;
                case 57:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new jo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ais.mxC = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 58:
                    com_tencent_mm_protocal_c_ais.mJm = aVar3.pMj.mH();
                    return 0;
                case 59:
                    com_tencent_mm_protocal_c_ais.mdJ = aVar3.pMj.readString();
                    return 0;
                case 60:
                    com_tencent_mm_protocal_c_ais.mJn = aVar3.pMj.readString();
                    return 0;
                case 61:
                    com_tencent_mm_protocal_c_ais.moP = aVar3.pMj.readString();
                    return 0;
                case 62:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new ams();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ais.mJo = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 63:
                    com_tencent_mm_protocal_c_ais.bCy = aVar3.pMj.readString();
                    return 0;
                case FileUtils.S_IXUSR /*64*/:
                    com_tencent_mm_protocal_c_ais.mJp = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
