package com.tencent.mm.protocal.c;

import a.a.a.c.a;
import java.util.LinkedList;

public final class afc extends aqp {
    public String mEZ;
    public LinkedList<String> mFc = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mPU != null) {
                aVar.dX(1, this.mPU.aHr());
                this.mPU.a(aVar);
            }
            if (this.mEZ != null) {
                aVar.e(2, this.mEZ);
            }
            aVar.d(3, 1, this.mFc);
            return 0;
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mEZ != null) {
                r0 += a.a.a.b.b.a.f(2, this.mEZ);
            }
            return r0 + a.a.a.a.c(3, 1, this.mFc);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mFc.clear();
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
            afc com_tencent_mm_protocal_c_afc = (afc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_afc.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_afc.mEZ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_afc.mFc.add(aVar3.pMj.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
