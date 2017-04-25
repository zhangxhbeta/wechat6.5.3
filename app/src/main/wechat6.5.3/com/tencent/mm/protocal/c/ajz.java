package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class ajz extends aqx {
    public are mKC;
    public are mKD;
    public int mKE;
    public int mKF;
    public LinkedList<kz> mKG = new LinkedList();
    public int mKH;
    public int miR;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mKC == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.mKD == null) {
                throw new b("Not all required fields were included: MaxSynckey");
            } else {
                if (this.mQl != null) {
                    aVar.dX(1, this.mQl.aHr());
                    this.mQl.a(aVar);
                }
                if (this.mKC != null) {
                    aVar.dX(2, this.mKC.aHr());
                    this.mKC.a(aVar);
                }
                if (this.mKD != null) {
                    aVar.dX(3, this.mKD.aHr());
                    this.mKD.a(aVar);
                }
                aVar.dV(4, this.miR);
                aVar.dV(5, this.mKE);
                aVar.dV(6, this.mKF);
                aVar.d(7, 8, this.mKG);
                aVar.dV(8, this.mKH);
                return 0;
            }
        } else if (i == 1) {
            if (this.mQl != null) {
                r0 = a.a.a.a.dU(1, this.mQl.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mKC != null) {
                r0 += a.a.a.a.dU(2, this.mKC.aHr());
            }
            if (this.mKD != null) {
                r0 += a.a.a.a.dU(3, this.mKD.aHr());
            }
            return ((((r0 + a.a.a.a.dS(4, this.miR)) + a.a.a.a.dS(5, this.mKE)) + a.a.a.a.dS(6, this.mKF)) + a.a.a.a.c(7, 8, this.mKG)) + a.a.a.a.dS(8, this.mKH);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mKG.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mQl == null) {
                throw new b("Not all required fields were included: BaseResponse");
            } else if (this.mKC == null) {
                throw new b("Not all required fields were included: CurrentSynckey");
            } else if (this.mKD != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: MaxSynckey");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ajz com_tencent_mm_protocal_c_ajz = (ajz) objArr[1];
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
                        com_tencent_mm_protocal_c_ajz.mQl = eoVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajz.mKC = eoVar;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajz.mKD = eoVar;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ajz.miR = aVar3.pMj.mH();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ajz.mKE = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ajz.mKF = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        eoVar = new kz();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = eoVar.a(aVar4, eoVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ajz.mKG.add(eoVar);
                    }
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_ajz.mKH = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
