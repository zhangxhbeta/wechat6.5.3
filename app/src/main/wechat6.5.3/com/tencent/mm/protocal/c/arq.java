package com.tencent.mm.protocal.c;

import a.a.a.b;
import android.support.v7.a.a.k;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class arq extends a {
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
    public are mbY;
    public String mlY;
    public String mlZ;
    public arf moC;
    public arf moD;
    public arf moM;
    public String mvR;

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
                if (this.cHd != null) {
                    aVar.e(7, this.cHd);
                }
                if (this.cHe != null) {
                    aVar.e(8, this.cHe);
                }
                if (this.cHf != null) {
                    aVar.e(9, this.cHf);
                }
                aVar.dV(10, this.cHg);
                aVar.dV(11, this.mFu);
                if (this.mFv != null) {
                    aVar.e(12, this.mFv);
                }
                if (this.mFw != null) {
                    aVar.e(13, this.mFw);
                }
                if (this.cHh != null) {
                    aVar.e(14, this.cHh);
                }
                if (this.mFx != null) {
                    aVar.e(15, this.mFx);
                }
                aVar.dV(16, this.mFy);
                aVar.dV(17, this.cHj);
                aVar.dV(18, this.cHi);
                if (this.cHk != null) {
                    aVar.e(19, this.cHk);
                }
                if (this.mFA != null) {
                    aVar.dX(20, this.mFA.aHr());
                    this.mFA.a(aVar);
                }
                if (this.cHl != null) {
                    aVar.e(21, this.cHl);
                }
                if (this.cHm != null) {
                    aVar.e(22, this.cHm);
                }
                if (this.mFB != null) {
                    aVar.dX(23, this.mFB.aHr());
                    this.mFB.a(aVar);
                }
                if (this.mlY != null) {
                    aVar.e(24, this.mlY);
                }
                if (this.mlZ != null) {
                    aVar.e(25, this.mlZ);
                }
                if (this.mvR == null) {
                    return 0;
                }
                aVar.e(26, this.mvR);
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
            if (this.cHd != null) {
                r0 += a.a.a.b.b.a.f(7, this.cHd);
            }
            if (this.cHe != null) {
                r0 += a.a.a.b.b.a.f(8, this.cHe);
            }
            if (this.cHf != null) {
                r0 += a.a.a.b.b.a.f(9, this.cHf);
            }
            r0 = (r0 + a.a.a.a.dS(10, this.cHg)) + a.a.a.a.dS(11, this.mFu);
            if (this.mFv != null) {
                r0 += a.a.a.b.b.a.f(12, this.mFv);
            }
            if (this.mFw != null) {
                r0 += a.a.a.b.b.a.f(13, this.mFw);
            }
            if (this.cHh != null) {
                r0 += a.a.a.b.b.a.f(14, this.cHh);
            }
            if (this.mFx != null) {
                r0 += a.a.a.b.b.a.f(15, this.mFx);
            }
            r0 = ((r0 + a.a.a.a.dS(16, this.mFy)) + a.a.a.a.dS(17, this.cHj)) + a.a.a.a.dS(18, this.cHi);
            if (this.cHk != null) {
                r0 += a.a.a.b.b.a.f(19, this.cHk);
            }
            if (this.mFA != null) {
                r0 += a.a.a.a.dU(20, this.mFA.aHr());
            }
            if (this.cHl != null) {
                r0 += a.a.a.b.b.a.f(21, this.cHl);
            }
            if (this.cHm != null) {
                r0 += a.a.a.b.b.a.f(22, this.cHm);
            }
            if (this.mFB != null) {
                r0 += a.a.a.a.dU(23, this.mFB.aHr());
            }
            if (this.mlY != null) {
                r0 += a.a.a.b.b.a.f(24, this.mlY);
            }
            if (this.mlZ != null) {
                r0 += a.a.a.b.b.a.f(25, this.mlZ);
            }
            if (this.mvR != null) {
                r0 += a.a.a.b.b.a.f(26, this.mvR);
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
            arq com_tencent_mm_protocal_c_arq = (arq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_arf;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_arq.moM = com_tencent_mm_protocal_c_arf;
                    }
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
                        com_tencent_mm_protocal_c_arq.mEj = com_tencent_mm_protocal_c_arf;
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
                        com_tencent_mm_protocal_c_arq.moC = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_arq.moD = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_arq.cHc = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_arq.mbY = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_arq.cHd = aVar3.pMj.readString();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_arq.cHe = aVar3.pMj.readString();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_arq.cHf = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_arq.cHg = aVar3.pMj.mH();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_arq.mFu = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_arq.mFv = aVar3.pMj.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_arq.mFw = aVar3.pMj.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_arq.cHh = aVar3.pMj.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_arq.mFx = aVar3.pMj.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_arq.mFy = aVar3.pMj.mH();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_arq.cHj = aVar3.pMj.mH();
                    return 0;
                case k.MG /*18*/:
                    com_tencent_mm_protocal_c_arq.cHi = aVar3.pMj.mH();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_arq.cHk = aVar3.pMj.readString();
                    return 0;
                case 20:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new axg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_arq.mFA = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_arq.cHl = aVar3.pMj.readString();
                    return 0;
                case k.MM /*22*/:
                    com_tencent_mm_protocal_c_arq.cHm = aVar3.pMj.readString();
                    return 0;
                case k.Nb /*23*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new mc();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_arq.mFB = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_arq.mlY = aVar3.pMj.readString();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_arq.mlZ = aVar3.pMj.readString();
                    return 0;
                case k.Kr /*26*/:
                    com_tencent_mm_protocal_c_arq.mvR = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
