package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ahl extends a {
    public int mGY;
    public afv mGZ;
    public int mHa;
    public int maG;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.maG);
            aVar.dV(2, this.mGY);
            if (this.mGZ != null) {
                aVar.dX(3, this.mGZ.aHr());
                this.mGZ.a(aVar);
            }
            aVar.dV(4, this.mHa);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.dS(1, this.maG) + 0) + a.a.a.a.dS(2, this.mGY);
            if (this.mGZ != null) {
                r0 += a.a.a.a.dU(3, this.mGZ.aHr());
            }
            return r0 + a.a.a.a.dS(4, this.mHa);
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
            ahl com_tencent_mm_protocal_c_ahl = (ahl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_ahl.maG = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ahl.mGY = aVar3.pMj.mH();
                    return 0;
                case 3:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        afv com_tencent_mm_protocal_c_afv = new afv();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_afv.a(aVar4, com_tencent_mm_protocal_c_afv, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahl.mGZ = com_tencent_mm_protocal_c_afv;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_ahl.mHa = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
