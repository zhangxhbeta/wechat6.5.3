package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class bfv extends aqp {
    public double mhY;
    public double mhZ;
    public int mnk;
    public int mqS;
    public long mqT;
    public LinkedList<axr> myS = new LinkedList();
    public arf nbA;
    public arf nbB;
    public int nbC;
    public long nbz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.nbA == null) {
                throw new b("Not all required fields were included: NetName");
            } else if (this.nbB == null) {
                throw new b("Not all required fields were included: WifiName");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                aVar.C(2, this.nbz);
                aVar.C(3, this.mqT);
                aVar.dV(4, this.mnk);
                if (this.nbA != null) {
                    aVar.dX(5, this.nbA.aHr());
                    this.nbA.a(aVar);
                }
                if (this.nbB != null) {
                    aVar.dX(6, this.nbB.aHr());
                    this.nbB.a(aVar);
                }
                aVar.a(7, this.mhY);
                aVar.a(8, this.mhZ);
                aVar.dV(9, this.mqS);
                aVar.dV(10, this.nbC);
                aVar.d(11, 8, this.myS);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = ((r0 + a.a.a.a.B(2, this.nbz)) + a.a.a.a.B(3, this.mqT)) + a.a.a.a.dS(4, this.mnk);
            if (this.nbA != null) {
                r0 += a.a.a.a.dU(5, this.nbA.aHr());
            }
            if (this.nbB != null) {
                r0 += a.a.a.a.dU(6, this.nbB.aHr());
            }
            return ((((r0 + (a.a.a.b.b.a.cw(7) + 8)) + (a.a.a.b.b.a.cw(8) + 8)) + a.a.a.a.dS(9, this.mqS)) + a.a.a.a.dS(10, this.nbC)) + a.a.a.a.c(11, 8, this.myS);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.myS.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.nbA == null) {
                throw new b("Not all required fields were included: NetName");
            } else if (this.nbB != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: WifiName");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bfv com_tencent_mm_protocal_c_bfv = (bfv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            arf com_tencent_mm_protocal_c_arf;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        en enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfv.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bfv.nbz = aVar3.pMj.mI();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bfv.mqT = aVar3.pMj.mI();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_bfv.mnk = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfv.nbA = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfv.nbB = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_bfv.mhY = aVar3.pMj.readDouble();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_bfv.mhZ = aVar3.pMj.readDouble();
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_bfv.mqS = aVar3.pMj.mH();
                    return 0;
                case 10:
                    com_tencent_mm_protocal_c_bfv.nbC = aVar3.pMj.mH();
                    return 0;
                case 11:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        axr com_tencent_mm_protocal_c_axr = new axr();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_axr.a(aVar4, com_tencent_mm_protocal_c_axr, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bfv.myS.add(com_tencent_mm_protocal_c_axr);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
