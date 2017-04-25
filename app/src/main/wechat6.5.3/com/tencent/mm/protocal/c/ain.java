package com.tencent.mm.protocal.c;

import a.a.a.b;
import android.support.v7.a.a.k;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ain extends a {
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
    public are mbY;
    public String mlY;
    public String mlZ;
    public arf moC;
    public arf moD;
    public arf moM;
    public int mob;

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
            } else if (this.mIO == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.mIP == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.mIQ == null) {
                throw new b("Not all required fields were included: RemarkQuanPin");
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
                aVar.dV(7, this.mIT);
                if (this.mIO != null) {
                    aVar.dX(8, this.mIO.aHr());
                    this.mIO.a(aVar);
                }
                if (this.mIP != null) {
                    aVar.dX(9, this.mIP.aHr());
                    this.mIP.a(aVar);
                }
                if (this.mIQ != null) {
                    aVar.dX(10, this.mIQ.aHr());
                    this.mIQ.a(aVar);
                }
                aVar.dV(11, this.mob);
                if (this.cHd != null) {
                    aVar.e(12, this.cHd);
                }
                if (this.cHe != null) {
                    aVar.e(13, this.cHe);
                }
                if (this.cHf != null) {
                    aVar.e(14, this.cHf);
                }
                aVar.dV(15, this.cHg);
                aVar.dV(16, this.mFu);
                if (this.mFv != null) {
                    aVar.e(17, this.mFv);
                }
                if (this.mFw != null) {
                    aVar.e(18, this.mFw);
                }
                if (this.mAS != null) {
                    aVar.e(19, this.mAS);
                }
                if (this.mFx != null) {
                    aVar.e(20, this.mFx);
                }
                aVar.dV(21, this.mFy);
                aVar.dV(22, this.cHj);
                aVar.dV(23, this.cHi);
                if (this.cHk != null) {
                    aVar.e(24, this.cHk);
                }
                if (this.cHh != null) {
                    aVar.e(25, this.cHh);
                }
                if (this.mFA != null) {
                    aVar.dX(26, this.mFA.aHr());
                    this.mFA.a(aVar);
                }
                if (this.cHl != null) {
                    aVar.e(27, this.cHl);
                }
                if (this.mlY != null) {
                    aVar.e(28, this.mlY);
                }
                if (this.mlZ != null) {
                    aVar.e(29, this.mlZ);
                }
                if (this.cHm != null) {
                    aVar.e(30, this.cHm);
                }
                if (this.mFB == null) {
                    return 0;
                }
                aVar.dX(31, this.mFB.aHr());
                this.mFB.a(aVar);
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
            r0 += a.a.a.a.dS(7, this.mIT);
            if (this.mIO != null) {
                r0 += a.a.a.a.dU(8, this.mIO.aHr());
            }
            if (this.mIP != null) {
                r0 += a.a.a.a.dU(9, this.mIP.aHr());
            }
            if (this.mIQ != null) {
                r0 += a.a.a.a.dU(10, this.mIQ.aHr());
            }
            r0 += a.a.a.a.dS(11, this.mob);
            if (this.cHd != null) {
                r0 += a.a.a.b.b.a.f(12, this.cHd);
            }
            if (this.cHe != null) {
                r0 += a.a.a.b.b.a.f(13, this.cHe);
            }
            if (this.cHf != null) {
                r0 += a.a.a.b.b.a.f(14, this.cHf);
            }
            r0 = (r0 + a.a.a.a.dS(15, this.cHg)) + a.a.a.a.dS(16, this.mFu);
            if (this.mFv != null) {
                r0 += a.a.a.b.b.a.f(17, this.mFv);
            }
            if (this.mFw != null) {
                r0 += a.a.a.b.b.a.f(18, this.mFw);
            }
            if (this.mAS != null) {
                r0 += a.a.a.b.b.a.f(19, this.mAS);
            }
            if (this.mFx != null) {
                r0 += a.a.a.b.b.a.f(20, this.mFx);
            }
            r0 = ((r0 + a.a.a.a.dS(21, this.mFy)) + a.a.a.a.dS(22, this.cHj)) + a.a.a.a.dS(23, this.cHi);
            if (this.cHk != null) {
                r0 += a.a.a.b.b.a.f(24, this.cHk);
            }
            if (this.cHh != null) {
                r0 += a.a.a.b.b.a.f(25, this.cHh);
            }
            if (this.mFA != null) {
                r0 += a.a.a.a.dU(26, this.mFA.aHr());
            }
            if (this.cHl != null) {
                r0 += a.a.a.b.b.a.f(27, this.cHl);
            }
            if (this.mlY != null) {
                r0 += a.a.a.b.b.a.f(28, this.mlY);
            }
            if (this.mlZ != null) {
                r0 += a.a.a.b.b.a.f(29, this.mlZ);
            }
            if (this.cHm != null) {
                r0 += a.a.a.b.b.a.f(30, this.cHm);
            }
            if (this.mFB != null) {
                r0 += a.a.a.a.dU(31, this.mFB.aHr());
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
            } else if (this.mbY == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else if (this.mIO == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.mIP == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.mIQ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: RemarkQuanPin");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ain com_tencent_mm_protocal_c_ain = (ain) objArr[1];
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
                        com_tencent_mm_protocal_c_ain.moM = com_tencent_mm_protocal_c_arf;
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
                        com_tencent_mm_protocal_c_ain.mEj = com_tencent_mm_protocal_c_arf;
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
                        com_tencent_mm_protocal_c_ain.moC = com_tencent_mm_protocal_c_arf;
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
                        com_tencent_mm_protocal_c_ain.moD = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ain.cHc = aVar3.pMj.mH();
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
                        com_tencent_mm_protocal_c_ain.mbY = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_ain.mIT = aVar3.pMj.mH();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ain.mIO = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ain.mIP = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ain.mIQ = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_ain.mob = aVar3.pMj.mH();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_ain.cHd = aVar3.pMj.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_ain.cHe = aVar3.pMj.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_ain.cHf = aVar3.pMj.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_ain.cHg = aVar3.pMj.mH();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_ain.mFu = aVar3.pMj.mH();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_ain.mFv = aVar3.pMj.readString();
                    return 0;
                case k.MG /*18*/:
                    com_tencent_mm_protocal_c_ain.mFw = aVar3.pMj.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_ain.mAS = aVar3.pMj.readString();
                    return 0;
                case 20:
                    com_tencent_mm_protocal_c_ain.mFx = aVar3.pMj.readString();
                    return 0;
                case 21:
                    com_tencent_mm_protocal_c_ain.mFy = aVar3.pMj.mH();
                    return 0;
                case k.MM /*22*/:
                    com_tencent_mm_protocal_c_ain.cHj = aVar3.pMj.mH();
                    return 0;
                case k.Nb /*23*/:
                    com_tencent_mm_protocal_c_ain.cHi = aVar3.pMj.mH();
                    return 0;
                case 24:
                    com_tencent_mm_protocal_c_ain.cHk = aVar3.pMj.readString();
                    return 0;
                case 25:
                    com_tencent_mm_protocal_c_ain.cHh = aVar3.pMj.readString();
                    return 0;
                case k.Kr /*26*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new axg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ain.mFA = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 27:
                    com_tencent_mm_protocal_c_ain.cHl = aVar3.pMj.readString();
                    return 0;
                case 28:
                    com_tencent_mm_protocal_c_ain.mlY = aVar3.pMj.readString();
                    return 0;
                case 29:
                    com_tencent_mm_protocal_c_ain.mlZ = aVar3.pMj.readString();
                    return 0;
                case 30:
                    com_tencent_mm_protocal_c_ain.cHm = aVar3.pMj.readString();
                    return 0;
                case 31:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new mc();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ain.mFB = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
