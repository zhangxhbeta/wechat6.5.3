package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bm extends a {
    public int eeO;
    public int gll;
    public int hNS;
    public int mbT;
    public arf mbU;
    public arf mbV;
    public arf mbW;
    public int mbX;
    public are mbY;
    public String mbZ;
    public String mca;
    public long mcb;
    public int mcc;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mbU == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.mbV == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.mbW == null) {
                throw new b("Not all required fields were included: Content");
            } else if (this.mbY == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else {
                aVar.dV(1, this.mbT);
                if (this.mbU != null) {
                    aVar.dX(2, this.mbU.aHr());
                    this.mbU.a(aVar);
                }
                if (this.mbV != null) {
                    aVar.dX(3, this.mbV.aHr());
                    this.mbV.a(aVar);
                }
                aVar.dV(4, this.gll);
                if (this.mbW != null) {
                    aVar.dX(5, this.mbW.aHr());
                    this.mbW.a(aVar);
                }
                aVar.dV(6, this.eeO);
                aVar.dV(7, this.mbX);
                if (this.mbY != null) {
                    aVar.dX(8, this.mbY.aHr());
                    this.mbY.a(aVar);
                }
                aVar.dV(9, this.hNS);
                if (this.mbZ != null) {
                    aVar.e(10, this.mbZ);
                }
                if (this.mca != null) {
                    aVar.e(11, this.mca);
                }
                aVar.C(12, this.mcb);
                aVar.dV(13, this.mcc);
                return 0;
            }
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mbT) + 0;
            if (this.mbU != null) {
                r0 += a.a.a.a.dU(2, this.mbU.aHr());
            }
            if (this.mbV != null) {
                r0 += a.a.a.a.dU(3, this.mbV.aHr());
            }
            r0 += a.a.a.a.dS(4, this.gll);
            if (this.mbW != null) {
                r0 += a.a.a.a.dU(5, this.mbW.aHr());
            }
            r0 = (r0 + a.a.a.a.dS(6, this.eeO)) + a.a.a.a.dS(7, this.mbX);
            if (this.mbY != null) {
                r0 += a.a.a.a.dU(8, this.mbY.aHr());
            }
            r0 += a.a.a.a.dS(9, this.hNS);
            if (this.mbZ != null) {
                r0 += a.a.a.b.b.a.f(10, this.mbZ);
            }
            if (this.mca != null) {
                r0 += a.a.a.b.b.a.f(11, this.mca);
            }
            return (r0 + a.a.a.a.B(12, this.mcb)) + a.a.a.a.dS(13, this.mcc);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mbU == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.mbV == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.mbW == null) {
                throw new b("Not all required fields were included: Content");
            } else if (this.mbY != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ImgBuf");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bm bmVar = (bm) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_arf;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    bmVar.mbT = aVar3.pMj.mH();
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
                        bmVar.mbU = com_tencent_mm_protocal_c_arf;
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
                        bmVar.mbV = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 4:
                    bmVar.gll = aVar3.pMj.mH();
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
                        bmVar.mbW = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 6:
                    bmVar.eeO = aVar3.pMj.mH();
                    return 0;
                case 7:
                    bmVar.mbX = aVar3.pMj.mH();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        bmVar.mbY = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 9:
                    bmVar.hNS = aVar3.pMj.mH();
                    return 0;
                case 10:
                    bmVar.mbZ = aVar3.pMj.readString();
                    return 0;
                case 11:
                    bmVar.mca = aVar3.pMj.readString();
                    return 0;
                case 12:
                    bmVar.mcb = aVar3.pMj.mI();
                    return 0;
                case 13:
                    bmVar.mcc = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
