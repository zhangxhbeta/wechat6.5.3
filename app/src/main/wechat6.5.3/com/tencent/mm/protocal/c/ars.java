package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import android.support.v7.a.a.k;
import com.tencent.mmdb.FileUtils;
import java.util.LinkedList;

public final class ars extends aqx {
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
    public arf mEj;
    public axg mFA;
    public mc mFB;
    public int mFu;
    public String mFv;
    public String mFw;
    public String mFx;
    public int mFy;
    public are mQI;
    public String mQJ;
    public int mQK;
    public are mbY;
    public String mlY;
    public String mlZ;
    public arf moC;
    public arf moD;
    public arf moM;
    public String mvR;
    public int mxP;
    public LinkedList<arq> mxQ = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.moM == null) {
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
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.moM != null) {
                    aVar.dX(2, this.moM.aHr());
                    this.moM.a(aVar);
                }
                if (this.mEj != null) {
                    aVar.dX(3, this.mEj.aHr());
                    this.mEj.a(aVar);
                }
                if (this.moC != null) {
                    aVar.dX(4, this.moC.aHr());
                    this.moC.a(aVar);
                }
                if (this.moD != null) {
                    aVar.dX(5, this.moD.aHr());
                    this.moD.a(aVar);
                }
                aVar.dV(6, this.cHc);
                if (this.mbY != null) {
                    aVar.dX(7, this.mbY.aHr());
                    this.mbY.a(aVar);
                }
                if (this.cHd != null) {
                    aVar.e(8, this.cHd);
                }
                if (this.cHe != null) {
                    aVar.e(9, this.cHe);
                }
                if (this.cHf != null) {
                    aVar.e(10, this.cHf);
                }
                aVar.dV(11, this.cHg);
                aVar.dV(12, this.mFu);
                if (this.mFv != null) {
                    aVar.e(13, this.mFv);
                }
                if (this.mFw != null) {
                    aVar.e(14, this.mFw);
                }
                if (this.cHh != null) {
                    aVar.e(15, this.cHh);
                }
                if (this.mFx != null) {
                    aVar.e(16, this.mFx);
                }
                aVar.dV(17, this.mFy);
                aVar.dV(18, this.cHj);
                aVar.dV(19, this.cHi);
                if (this.cHk != null) {
                    aVar.e(20, this.cHk);
                }
                if (this.mFA != null) {
                    aVar.dX(21, this.mFA.aHr());
                    this.mFA.a(aVar);
                }
                if (this.cHl != null) {
                    aVar.e(22, this.cHl);
                }
                if (this.cHm != null) {
                    aVar.e(23, this.cHm);
                }
                if (this.mFB != null) {
                    aVar.dX(24, this.mFB.aHr());
                    this.mFB.a(aVar);
                }
                aVar.dV(25, this.mxP);
                aVar.d(26, 8, this.mxQ);
                if (this.mlY != null) {
                    aVar.e(27, this.mlY);
                }
                if (this.mlZ != null) {
                    aVar.e(28, this.mlZ);
                }
                if (this.mQI != null) {
                    aVar.dX(29, this.mQI.aHr());
                    this.mQI.a(aVar);
                }
                if (this.mvR != null) {
                    aVar.e(30, this.mvR);
                }
                if (this.mQJ != null) {
                    aVar.e(31, this.mQJ);
                }
                aVar.dV(32, this.mQK);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.moM != null) {
                r0 += a.a.a.a.dU(2, this.moM.aHr());
            }
            if (this.mEj != null) {
                r0 += a.a.a.a.dU(3, this.mEj.aHr());
            }
            if (this.moC != null) {
                r0 += a.a.a.a.dU(4, this.moC.aHr());
            }
            if (this.moD != null) {
                r0 += a.a.a.a.dU(5, this.moD.aHr());
            }
            r0 += a.a.a.a.dS(6, this.cHc);
            if (this.mbY != null) {
                r0 += a.a.a.a.dU(7, this.mbY.aHr());
            }
            if (this.cHd != null) {
                r0 += a.a.a.b.b.a.f(8, this.cHd);
            }
            if (this.cHe != null) {
                r0 += a.a.a.b.b.a.f(9, this.cHe);
            }
            if (this.cHf != null) {
                r0 += a.a.a.b.b.a.f(10, this.cHf);
            }
            r0 = (r0 + a.a.a.a.dS(11, this.cHg)) + a.a.a.a.dS(12, this.mFu);
            if (this.mFv != null) {
                r0 += a.a.a.b.b.a.f(13, this.mFv);
            }
            if (this.mFw != null) {
                r0 += a.a.a.b.b.a.f(14, this.mFw);
            }
            if (this.cHh != null) {
                r0 += a.a.a.b.b.a.f(15, this.cHh);
            }
            if (this.mFx != null) {
                r0 += a.a.a.b.b.a.f(16, this.mFx);
            }
            r0 = ((r0 + a.a.a.a.dS(17, this.mFy)) + a.a.a.a.dS(18, this.cHj)) + a.a.a.a.dS(19, this.cHi);
            if (this.cHk != null) {
                r0 += a.a.a.b.b.a.f(20, this.cHk);
            }
            if (this.mFA != null) {
                r0 += a.a.a.a.dU(21, this.mFA.aHr());
            }
            if (this.cHl != null) {
                r0 += a.a.a.b.b.a.f(22, this.cHl);
            }
            if (this.cHm != null) {
                r0 += a.a.a.b.b.a.f(23, this.cHm);
            }
            if (this.mFB != null) {
                r0 += a.a.a.a.dU(24, this.mFB.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(25, this.mxP)) + a.a.a.a.c(26, 8, this.mxQ);
            if (this.mlY != null) {
                r0 += a.a.a.b.b.a.f(27, this.mlY);
            }
            if (this.mlZ != null) {
                r0 += a.a.a.b.b.a.f(28, this.mlZ);
            }
            if (this.mQI != null) {
                r0 += a.a.a.a.dU(29, this.mQI.aHr());
            }
            if (this.mvR != null) {
                r0 += a.a.a.b.b.a.f(30, this.mvR);
            }
            if (this.mQJ != null) {
                r0 += a.a.a.b.b.a.f(31, this.mQJ);
            }
            return r0 + a.a.a.a.dS(32, this.mQK);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mxQ.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.moM == null) {
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
            ars com_tencent_mm_protocal_c_ars = (ars) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            com.tencent.mm.ba.a eoVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new eo();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ars.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ars.moM = eoVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ars.mEj = eoVar;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ars.moC = eoVar;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ars.moD = eoVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ars.cHc = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ars.mbY = eoVar;
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ars.cHd = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ars.cHe = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_ars.cHf = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ars.cHg = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ars.mFu = aVar3.pMj.mH();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ars.mFv = aVar3.pMj.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ars.mFw = aVar3.pMj.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_ars.cHh = aVar3.pMj.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_ars.mFx = aVar3.pMj.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_ars.mFy = aVar3.pMj.mH();
                    return 0;
                case k.MG /*18*/:
                    com_tencent_mm_protocal_c_ars.cHj = aVar3.pMj.mH();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_ars.cHi = aVar3.pMj.mH();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_ars.cHk = aVar3.pMj.readString();
                    return 0;
                case 21:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new axg();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ars.mFA = eoVar;
                    }
                    return 0;
                case k.MM /*22*/:
                    com_tencent_mm_protocal_c_ars.cHl = aVar3.pMj.readString();
                    return 0;
                case k.Nb /*23*/:
                    com_tencent_mm_protocal_c_ars.cHm = aVar3.pMj.readString();
                    return 0;
                case 24:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new mc();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ars.mFB = eoVar;
                    }
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_ars.mxP = aVar3.pMj.mH();
                    return 0;
                case k.Kr /*26*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new arq();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ars.mxQ.add(eoVar);
                    }
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_ars.mlY = aVar3.pMj.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_ars.mlZ = aVar3.pMj.readString();
                    return 0;
                case 29:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ars.mQI = eoVar;
                    }
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_ars.mvR = aVar3.pMj.readString();
                    return 0;
                case 31:
                    com_tencent_mm_protocal_c_ars.mQJ = aVar3.pMj.readString();
                    return 0;
                case FileUtils.S_IRGRP /*32*/:
                    com_tencent_mm_protocal_c_ars.mQK = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
