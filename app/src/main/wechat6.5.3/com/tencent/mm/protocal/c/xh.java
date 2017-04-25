package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class xh extends aqx {
    public int mbT;
    public arf mbU;
    public arf mbV;
    public long mcb;
    public int mdA;
    public int mdB;
    public int mdz;
    public are mfg;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mbU == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.mbV == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.mfg == null) {
                throw new b("Not all required fields were included: Data");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                aVar.dV(2, this.mbT);
                if (this.mbU != null) {
                    aVar.dX(3, this.mbU.aHr());
                    this.mbU.a(aVar);
                }
                if (this.mbV != null) {
                    aVar.dX(4, this.mbV.aHr());
                    this.mbV.a(aVar);
                }
                aVar.dV(5, this.mdz);
                aVar.dV(6, this.mdA);
                aVar.dV(7, this.mdB);
                if (this.mfg != null) {
                    aVar.dX(8, this.mfg.aHr());
                    this.mfg.a(aVar);
                }
                aVar.C(9, this.mcb);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mbT);
            if (this.mbU != null) {
                r0 += a.a.a.a.dU(3, this.mbU.aHr());
            }
            if (this.mbV != null) {
                r0 += a.a.a.a.dU(4, this.mbV.aHr());
            }
            r0 = ((r0 + a.a.a.a.dS(5, this.mdz)) + a.a.a.a.dS(6, this.mdA)) + a.a.a.a.dS(7, this.mdB);
            if (this.mfg != null) {
                r0 += a.a.a.a.dU(8, this.mfg.aHr());
            }
            return r0 + a.a.a.a.B(9, this.mcb);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mbU == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.mbV == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else if (this.mfg != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Data");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            xh xhVar = (xh) objArr[1];
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
                        xhVar.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    xhVar.mbT = aVar3.pMj.mH();
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
                        xhVar.mbU = eoVar;
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
                        xhVar.mbV = eoVar;
                    }
                    return 0;
                case 5:
                    xhVar.mdz = aVar3.pMj.mH();
                    return 0;
                case 6:
                    xhVar.mdA = aVar3.pMj.mH();
                    return 0;
                case 7:
                    xhVar.mdB = aVar3.pMj.mH();
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        xhVar.mfg = eoVar;
                    }
                    return 0;
                case 9:
                    xhVar.mcb = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
