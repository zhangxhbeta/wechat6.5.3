package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class beb extends aqp {
    public String mXJ;
    public int mXL;
    public int mZK;
    public LinkedList<arf> mZL = new LinkedList();
    public int mfb;
    public are mfg;
    public int mfh;
    public int miI;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mfg == null) {
                throw new b("Not all required fields were included: Data");
            }
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mfg != null) {
                aVar.dX(2, this.mfg.aHr());
                this.mfg.a(aVar);
            }
            aVar.dV(3, this.mfb);
            if (this.mXJ != null) {
                aVar.e(4, this.mXJ);
            }
            aVar.dV(5, this.mfh);
            aVar.dV(6, this.mXL);
            aVar.dV(7, this.miI);
            aVar.dV(8, this.mZK);
            aVar.d(9, 8, this.mZL);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mfg != null) {
                r0 += a.a.a.a.dU(2, this.mfg.aHr());
            }
            r0 += a.a.a.a.dS(3, this.mfb);
            if (this.mXJ != null) {
                r0 += a.a.a.b.b.a.f(4, this.mXJ);
            }
            return ((((r0 + a.a.a.a.dS(5, this.mfh)) + a.a.a.a.dS(6, this.mXL)) + a.a.a.a.dS(7, this.miI)) + a.a.a.a.dS(8, this.mZK)) + a.a.a.a.c(9, 8, this.mZL);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mZL.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mfg != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Data");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            beb com_tencent_mm_protocal_c_beb = (beb) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            com.tencent.mm.ba.a enVar;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        enVar = new en();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_beb.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        enVar = new are();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_beb.mfg = enVar;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_beb.mfb = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_beb.mXJ = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_beb.mfh = aVar3.pMj.mH();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_beb.mXL = aVar3.pMj.mH();
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_beb.miI = aVar3.pMj.mH();
                    return 0;
                case 8:
                    com_tencent_mm_protocal_c_beb.mZK = aVar3.pMj.mH();
                    return 0;
                case 9:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        enVar = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_beb.mZL.add(enVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
