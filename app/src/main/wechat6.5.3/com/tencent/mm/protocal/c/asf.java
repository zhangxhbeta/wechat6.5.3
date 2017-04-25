package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import com.tencent.mm.plugin.appbrand.jsapi.am;
import com.tencent.mm.plugin.appbrand.jsapi.an;
import com.tencent.mm.plugin.appbrand.jsapi.as;
import java.util.LinkedList;

public final class asf extends a {
    public int cHc;
    public String cHd;
    public String cHe;
    public String cHf;
    public int cHg;
    public String cHh;
    public String cHl;
    public arf mEj;
    public mc mFB;
    public int mFu;
    public String mFv;
    public String mFw;
    public String mFx;
    public int mFy;
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
                if (this.mFB != null) {
                    aVar.dX(15, this.mFB.aHr());
                    this.mFB.a(aVar);
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
            if (this.mFB != null) {
                r0 += a.a.a.a.dU(15, this.mFB.aHr());
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
            asf com_tencent_mm_protocal_c_asf = (asf) objArr[1];
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
                        com_tencent_mm_protocal_c_asf.moM = com_tencent_mm_protocal_c_arf;
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
                        com_tencent_mm_protocal_c_asf.mEj = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_asf.cHc = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_asf.cHd = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_asf.cHe = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_asf.cHf = aVar3.pMj.readString();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_asf.cHg = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_asf.mFu = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_asf.mFv = aVar3.pMj.readString();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_asf.mFw = aVar3.pMj.readString();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_asf.cHh = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_asf.mFx = aVar3.pMj.readString();
                    return 0;
                case as.CTRL_INDEX /*13*/:
                    com_tencent_mm_protocal_c_asf.mFy = aVar3.pMj.mH();
                    return 0;
                case an.CTRL_INDEX /*14*/:
                    com_tencent_mm_protocal_c_asf.cHl = aVar3.pMj.readString();
                    return 0;
                case am.CTRL_INDEX /*15*/:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        mc mcVar = new mc();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = mcVar.a(aVar4, mcVar, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_asf.mFB = mcVar;
                    }
                    return 0;
                case 16:
                    com_tencent_mm_protocal_c_asf.mlY = aVar3.pMj.readString();
                    return 0;
                case 17:
                    com_tencent_mm_protocal_c_asf.mlZ = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
