package com.tencent.mm.protocal.c;

import a.a.a.b;
import android.support.v7.a.a.k;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class aig extends a {
    public int cHc;
    public String cHd;
    public String cHe;
    public String cHf;
    public int cHg;
    public String cHl;
    public arf mEj;
    public int mFu;
    public String mFv;
    public int mIN;
    public arf mIO;
    public arf mIP;
    public arf mIQ;
    public arf moC;
    public arf moD;
    public arf moS;
    public int mob;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.moS == null) {
                throw new b("Not all required fields were included: MemberName");
            } else if (this.mEj == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.moC == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.moD == null) {
                throw new b("Not all required fields were included: QuanPin");
            } else if (this.mIO == null) {
                throw new b("Not all required fields were included: Remark");
            } else if (this.mIP == null) {
                throw new b("Not all required fields were included: RemarkPYInitial");
            } else if (this.mIQ == null) {
                throw new b("Not all required fields were included: RemarkQuanPin");
            } else {
                if (this.moS != null) {
                    aVar.dX(1, this.moS.aHr());
                    this.moS.a(aVar);
                }
                aVar.dV(2, this.mIN);
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
                if (this.mIO != null) {
                    aVar.dX(9, this.mIO.aHr());
                    this.mIO.a(aVar);
                }
                if (this.mIP != null) {
                    aVar.dX(10, this.mIP.aHr());
                    this.mIP.a(aVar);
                }
                if (this.mIQ != null) {
                    aVar.dX(11, this.mIQ.aHr());
                    this.mIQ.a(aVar);
                }
                aVar.dV(12, this.mob);
                if (this.cHd != null) {
                    aVar.e(13, this.cHd);
                }
                if (this.cHe != null) {
                    aVar.e(14, this.cHe);
                }
                if (this.cHf != null) {
                    aVar.e(15, this.cHf);
                }
                aVar.dV(16, this.cHg);
                aVar.dV(17, this.mFu);
                if (this.mFv != null) {
                    aVar.e(18, this.mFv);
                }
                if (this.cHl == null) {
                    return 0;
                }
                aVar.e(19, this.cHl);
                return 0;
            }
        } else if (i == 1) {
            if (this.moS != null) {
                r0 = a.a.a.a.dU(1, this.moS.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mIN);
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
            if (this.mIO != null) {
                r0 += a.a.a.a.dU(9, this.mIO.aHr());
            }
            if (this.mIP != null) {
                r0 += a.a.a.a.dU(10, this.mIP.aHr());
            }
            if (this.mIQ != null) {
                r0 += a.a.a.a.dU(11, this.mIQ.aHr());
            }
            r0 += a.a.a.a.dS(12, this.mob);
            if (this.cHd != null) {
                r0 += a.a.a.b.b.a.f(13, this.cHd);
            }
            if (this.cHe != null) {
                r0 += a.a.a.b.b.a.f(14, this.cHe);
            }
            if (this.cHf != null) {
                r0 += a.a.a.b.b.a.f(15, this.cHf);
            }
            r0 = (r0 + a.a.a.a.dS(16, this.cHg)) + a.a.a.a.dS(17, this.mFu);
            if (this.mFv != null) {
                r0 += a.a.a.b.b.a.f(18, this.mFv);
            }
            if (this.cHl != null) {
                r0 += a.a.a.b.b.a.f(19, this.cHl);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.moS == null) {
                throw new b("Not all required fields were included: MemberName");
            } else if (this.mEj == null) {
                throw new b("Not all required fields were included: NickName");
            } else if (this.moC == null) {
                throw new b("Not all required fields were included: PYInitial");
            } else if (this.moD == null) {
                throw new b("Not all required fields were included: QuanPin");
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
            aig com_tencent_mm_protocal_c_aig = (aig) objArr[1];
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
                        com_tencent_mm_protocal_c_aig.moS = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aig.mIN = aVar3.pMj.mH();
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
                        com_tencent_mm_protocal_c_aig.mEj = com_tencent_mm_protocal_c_arf;
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
                        com_tencent_mm_protocal_c_aig.moC = com_tencent_mm_protocal_c_arf;
                    }
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
                        com_tencent_mm_protocal_c_aig.moD = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_aig.cHc = aVar3.pMj.mH();
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
                        com_tencent_mm_protocal_c_aig.mIO = com_tencent_mm_protocal_c_arf;
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
                        com_tencent_mm_protocal_c_aig.mIP = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aig.mIQ = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_aig.mob = aVar3.pMj.mH();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_aig.cHd = aVar3.pMj.readString();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_aig.cHe = aVar3.pMj.readString();
                    return 0;
                case 15:
                    com_tencent_mm_protocal_c_aig.cHf = aVar3.pMj.readString();
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_aig.cHg = aVar3.pMj.mH();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_aig.mFu = aVar3.pMj.mH();
                    return 0;
                case k.MG /*18*/:
                    com_tencent_mm_protocal_c_aig.mFv = aVar3.pMj.readString();
                    return 0;
                case 19:
                    com_tencent_mm_protocal_c_aig.cHl = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
