package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ald extends a {
    public ale mLY;
    public int mcj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mLY == null) {
                throw new b("Not all required fields were included: OplogRet");
            }
            aVar.dV(1, this.mcj);
            if (this.mLY != null) {
                aVar.dX(2, this.mLY.aHr());
                this.mLY.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mcj) + 0;
            if (this.mLY != null) {
                return r0 + a.a.a.a.dU(2, this.mLY.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mLY != null) {
                return 0;
            }
            throw new b("Not all required fields were included: OplogRet");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ald com_tencent_mm_protocal_c_ald = (ald) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_ald.mcj = aVar3.pMj.mH();
                    return 0;
                case 2:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a com_tencent_mm_protocal_c_ale = new ale();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_ale.a(aVar4, com_tencent_mm_protocal_c_ale, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ald.mLY = com_tencent_mm_protocal_c_ale;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
