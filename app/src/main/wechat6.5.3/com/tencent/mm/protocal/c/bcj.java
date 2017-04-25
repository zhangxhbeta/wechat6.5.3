package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bcj extends aqx {
    public int hNS;
    public arf mXW;
    public int mbT;
    public arf mbU;
    public arf mbV;
    public long mcb;
    public int mdA;
    public int mdB;
    public int mdz;
    public String mjT;
    public String mjV;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mXW == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.mbU == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.mbV == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                aVar.dV(2, this.mbT);
                if (this.mXW != null) {
                    aVar.dX(3, this.mXW.aHr());
                    this.mXW.a(aVar);
                }
                if (this.mbU != null) {
                    aVar.dX(4, this.mbU.aHr());
                    this.mbU.a(aVar);
                }
                if (this.mbV != null) {
                    aVar.dX(5, this.mbV.aHr());
                    this.mbV.a(aVar);
                }
                aVar.dV(6, this.mdz);
                aVar.dV(7, this.mdA);
                aVar.dV(8, this.mdB);
                aVar.dV(9, this.hNS);
                aVar.C(10, this.mcb);
                if (this.mjT != null) {
                    aVar.e(11, this.mjT);
                }
                if (this.mjV == null) {
                    return 0;
                }
                aVar.e(12, this.mjV);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mbT);
            if (this.mXW != null) {
                r0 += a.a.a.a.dU(3, this.mXW.aHr());
            }
            if (this.mbU != null) {
                r0 += a.a.a.a.dU(4, this.mbU.aHr());
            }
            if (this.mbV != null) {
                r0 += a.a.a.a.dU(5, this.mbV.aHr());
            }
            r0 = ((((r0 + a.a.a.a.dS(6, this.mdz)) + a.a.a.a.dS(7, this.mdA)) + a.a.a.a.dS(8, this.mdB)) + a.a.a.a.dS(9, this.hNS)) + a.a.a.a.B(10, this.mcb);
            if (this.mjT != null) {
                r0 += a.a.a.b.b.a.f(11, this.mjT);
            }
            if (this.mjV != null) {
                r0 += a.a.a.b.b.a.f(12, this.mjV);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mXW == null) {
                throw new b("Not all required fields were included: ClientImgId");
            } else if (this.mbU == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.mbV != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: ToUserName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bcj com_tencent_mm_protocal_c_bcj = (bcj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a eoVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new eo();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcj.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bcj.mbT = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcj.mXW = eoVar;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcj.mbU = eoVar;
                    }
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bcj.mbV = eoVar;
                    }
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_bcj.mdz = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bcj.mdA = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bcj.mdB = aVar3.pMj.mH();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bcj.hNS = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bcj.mcb = aVar3.pMj.mI();
                    return 0;
                case 11:
                    com_tencent_mm_protocal_c_bcj.mjT = aVar3.pMj.readString();
                    return 0;
                case 12:
                    com_tencent_mm_protocal_c_bcj.mjV = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
