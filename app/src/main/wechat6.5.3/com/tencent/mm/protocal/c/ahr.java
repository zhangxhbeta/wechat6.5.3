package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class ahr extends aqp {
    public LinkedList<aht> mHm = new LinkedList();
    public int mHn;
    public String mHo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            aVar.d(2, 8, this.mHm);
            aVar.dV(3, this.mHn);
            if (this.mHo == null) {
                return 0;
            }
            aVar.e(4, this.mHo);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            r0 = (r0 + a.a.a.a.c(2, 8, this.mHm)) + a.a.a.a.dS(3, this.mHn);
            if (this.mHo != null) {
                r0 += a.a.a.b.b.a.f(4, this.mHo);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mHm.clear();
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
            ahr com_tencent_mm_protocal_c_ahr = (ahr) objArr[1];
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
                        com_tencent_mm_protocal_c_ahr.mPU = enVar;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        aht com_tencent_mm_protocal_c_aht = new aht();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aht.a(aVar4, com_tencent_mm_protocal_c_aht, aqp.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahr.mHm.add(com_tencent_mm_protocal_c_aht);
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ahr.mHn = aVar3.pMj.mH();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ahr.mHo = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
