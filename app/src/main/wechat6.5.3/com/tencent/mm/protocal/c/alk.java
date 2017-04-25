package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class alk extends a {
    public int mMl;
    public are mMm;
    public int mMn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.mMl);
            if (this.mMm != null) {
                aVar.dX(2, this.mMm.aHr());
                this.mMm.a(aVar);
            }
            aVar.dV(3, this.mMn);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mMl) + 0;
            if (this.mMm != null) {
                r0 += a.a.a.a.dU(2, this.mMm.aHr());
            }
            return r0 + a.a.a.a.dS(3, this.mMn);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            alk com_tencent_mm_protocal_c_alk = (alk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_alk.mMl = aVar3.pMj.mH();
                    return 0;
                case 2:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a com_tencent_mm_protocal_c_are = new are();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alk.mMm = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_alk.mMn = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
