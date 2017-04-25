package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class awy extends aqp {
    public int eet;
    public LinkedList<arf> eeu = new LinkedList();
    public String gmM;
    public int lZm;
    public long mUj;
    public int maG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.dV(2, this.lZm);
            aVar.C(3, this.mUj);
            if (this.gmM != null) {
                aVar.e(4, this.gmM);
            }
            aVar.dV(5, this.eet);
            aVar.d(6, 8, this.eeu);
            aVar.dV(7, this.maG);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.dS(2, this.lZm)) + a.a.a.a.B(3, this.mUj);
            if (this.gmM != null) {
                r0 += a.a.a.b.b.a.f(4, this.gmM);
            }
            return ((r0 + a.a.a.a.dS(5, this.eet)) + a.a.a.a.c(6, 8, this.eeu)) + a.a.a.a.dS(7, this.maG);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.eeu.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = aqp.a(aVar2); r0 > 0; r0 = aqp.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            awy com_tencent_mm_protocal_c_awy = (awy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
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
                        com_tencent_mm_protocal_c_awy.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_awy.lZm = aVar3.pMj.mH();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_awy.mUj = aVar3.pMj.mI();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_awy.gmM = aVar3.pMj.readString();
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_awy.eet = aVar3.pMj.mH();
                    return 0;
                case 6:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        arf com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awy.eeu.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                case 7:
                    com_tencent_mm_protocal_c_awy.maG = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
