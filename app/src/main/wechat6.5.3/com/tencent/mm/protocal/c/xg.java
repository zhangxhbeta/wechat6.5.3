package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class xg extends aqp {
    public int mbT;
    public arf mbU;
    public arf mbV;
    public long mcb;
    public int mdA;
    public int mdB;
    public int mdz;
    public int mzC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mbU == null) {
                throw new b("Not all required fields were included: FromUserName");
            } else if (this.mbV == null) {
                throw new b("Not all required fields were included: ToUserName");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
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
                aVar.dV(8, this.mzC);
                aVar.C(9, this.mcb);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
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
            return ((((r0 + a.a.a.a.dS(5, this.mdz)) + a.a.a.a.dS(6, this.mdA)) + a.a.a.a.dS(7, this.mdB)) + a.a.a.a.dS(8, this.mzC)) + a.a.a.a.B(9, this.mcb);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mbU == null) {
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
            xg xgVar = (xg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            com.tencent.mm.ba.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        xgVar.mPU = enVar;
                    }
                    return 0;
                case 2:
                    xgVar.mbT = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        xgVar.mbU = enVar;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        enVar = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        xgVar.mbV = enVar;
                    }
                    return 0;
                case 5:
                    xgVar.mdz = aVar3.pMj.mH();
                    return 0;
                case 6:
                    xgVar.mdA = aVar3.pMj.mH();
                    return 0;
                case 7:
                    xgVar.mdB = aVar3.pMj.mH();
                    return 0;
                case 8:
                    xgVar.mzC = aVar3.pMj.mH();
                    return 0;
                case 9:
                    xgVar.mcb = aVar3.pMj.mI();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
