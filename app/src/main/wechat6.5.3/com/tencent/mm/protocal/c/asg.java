package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class asg extends a {
    public int cHc;
    public String cHd;
    public String cHe;
    public String cHf;
    public int cHg;
    public String cHh;
    public String cHl;
    public arf mEj;
    public int mFu;
    public String mFv;
    public String mFw;
    public String mFx;
    public int mFy;
    public md mQX;
    public String mlY;
    public String mlZ;
    public arf moM;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.moM == null) {
                throw new b("Not all required fields were included: UserName");
            } else if (this.mEj == null) {
                throw new b("Not all required fields were included: NickName");
            } else {
                if (this.moM != null) {
                    aVar.dX(1, this.moM.aHr());
                    this.moM.a(aVar);
                }
                if (this.mEj != null) {
                    aVar.dX(2, this.mEj.aHr());
                    this.mEj.a(aVar);
                }
                aVar.dV(3, this.cHc);
                if (this.cHd != null) {
                    aVar.e(4, this.cHd);
                }
                if (this.cHe != null) {
                    aVar.e(5, this.cHe);
                }
                if (this.cHf != null) {
                    aVar.e(6, this.cHf);
                }
                aVar.dV(7, this.cHg);
                aVar.dV(8, this.mFu);
                if (this.mFv != null) {
                    aVar.e(9, this.mFv);
                }
                if (this.mFw != null) {
                    aVar.e(10, this.mFw);
                }
                if (this.cHh != null) {
                    aVar.e(11, this.cHh);
                }
                if (this.mFx != null) {
                    aVar.e(12, this.mFx);
                }
                aVar.dV(13, this.mFy);
                if (this.cHl != null) {
                    aVar.e(14, this.cHl);
                }
                if (this.mQX != null) {
                    aVar.dX(15, this.mQX.aHr());
                    this.mQX.a(aVar);
                }
                if (this.mlY != null) {
                    aVar.e(16, this.mlY);
                }
                if (this.mlZ == null) {
                    return 0;
                }
                aVar.e(17, this.mlZ);
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
            r0 += a.a.a.a.dS(3, this.cHc);
            if (this.cHd != null) {
                r0 += a.a.a.b.b.a.f(4, this.cHd);
            }
            if (this.cHe != null) {
                r0 += a.a.a.b.b.a.f(5, this.cHe);
            }
            if (this.cHf != null) {
                r0 += a.a.a.b.b.a.f(6, this.cHf);
            }
            r0 = (r0 + a.a.a.a.dS(7, this.cHg)) + a.a.a.a.dS(8, this.mFu);
            if (this.mFv != null) {
                r0 += a.a.a.b.b.a.f(9, this.mFv);
            }
            if (this.mFw != null) {
                r0 += a.a.a.b.b.a.f(10, this.mFw);
            }
            if (this.cHh != null) {
                r0 += a.a.a.b.b.a.f(11, this.cHh);
            }
            if (this.mFx != null) {
                r0 += a.a.a.b.b.a.f(12, this.mFx);
            }
            r0 += a.a.a.a.dS(13, this.mFy);
            if (this.cHl != null) {
                r0 += a.a.a.b.b.a.f(14, this.cHl);
            }
            if (this.mQX != null) {
                r0 += a.a.a.a.dU(15, this.mQX.aHr());
            }
            if (this.mlY != null) {
                r0 += a.a.a.b.b.a.f(16, this.mlY);
            }
            if (this.mlZ != null) {
                r0 += a.a.a.b.b.a.f(17, this.mlZ);
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
            } else if (this.mEj != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: NickName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            asg com_tencent_mm_protocal_c_asg = (asg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            arf com_tencent_mm_protocal_c_arf;
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
                        com_tencent_mm_protocal_c_asg.moM = com_tencent_mm_protocal_c_arf;
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
                        com_tencent_mm_protocal_c_asg.mEj = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_asg.cHc = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asg.cHd = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_asg.cHe = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_asg.cHf = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_asg.cHg = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_asg.mFu = aVar3.pMj.mH();
                    return 0;
                case NetStatusUtil.MOBILE /*9*/:
                    com_tencent_mm_protocal_c_asg.mFv = aVar3.pMj.readString();
                    return 0;
                case NetStatusUtil.LTE /*10*/:
                    com_tencent_mm_protocal_c_asg.mFw = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_asg.cHh = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_asg.mFx = aVar3.pMj.readString();
                    return 0;
                case 13:
                    com_tencent_mm_protocal_c_asg.mFy = aVar3.pMj.mH();
                    return 0;
                case 14:
                    com_tencent_mm_protocal_c_asg.cHl = aVar3.pMj.readString();
                    return 0;
                case 15:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        md mdVar = new md();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mdVar.a(aVar4, mdVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asg.mQX = mdVar;
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_asg.mlY = aVar3.pMj.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_asg.mlZ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
