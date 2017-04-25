package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ayc extends aqp {
    public String gom;
    public String gon;
    public int mVA;
    public int mVB;
    public LinkedList<aye> mVC = new LinkedList();
    public ayb mVD;
    public int mVE;
    public LinkedList<ayb> mVF = new LinkedList();
    public String mcN;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.mVA);
            if (this.gon != null) {
                aVar.e(3, this.gon);
            }
            if (this.gom != null) {
                aVar.e(4, this.gom);
            }
            if (this.mcN != null) {
                aVar.e(5, this.mcN);
            }
            aVar.dV(6, this.mVB);
            aVar.d(7, 8, this.mVC);
            if (this.mVD != null) {
                aVar.dX(8, this.mVD.aHr());
                this.mVD.a(aVar);
            }
            aVar.dV(9, this.mVE);
            aVar.d(10, 8, this.mVF);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.mVA);
            if (this.gon != null) {
                r0 += a.a.a.b.b.a.f(3, this.gon);
            }
            if (this.gom != null) {
                r0 += a.a.a.b.b.a.f(4, this.gom);
            }
            if (this.mcN != null) {
                r0 += a.a.a.b.b.a.f(5, this.mcN);
            }
            r0 = (r0 + a.a.a.a.dS(6, this.mVB)) + a.a.a.a.c(7, 8, this.mVC);
            if (this.mVD != null) {
                r0 += a.a.a.a.dU(8, this.mVD.aHr());
            }
            return (r0 + a.a.a.a.dS(9, this.mVE)) + a.a.a.a.c(10, 8, this.mVF);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mVC.clear();
            this.mVF.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ayc com_tencent_mm_protocal_c_ayc = (ayc) objArr[1];
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
                        com_tencent_mm_protocal_c_ayc.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ayc.mVA = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ayc.gon = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ayc.gom = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ayc.mcN = aVar3.pMj.readString();
                    return 0;
                case 6:
                    com_tencent_mm_protocal_c_ayc.mVB = aVar3.pMj.mH();
                    return 0;
                case 7:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        enVar = new aye();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ayc.mVC.add(enVar);
                    }
                    return 0;
                case 8:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        enVar = new ayb();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ayc.mVD = enVar;
                    }
                    return 0;
                case 9:
                    com_tencent_mm_protocal_c_ayc.mVE = aVar3.pMj.mH();
                    return 0;
                case 10:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        enVar = new ayb();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ayc.mVF.add(enVar);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
