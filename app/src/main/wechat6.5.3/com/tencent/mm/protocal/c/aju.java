package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class aju extends a {
    public acg mgJ;
    public hu mgK;
    public ajs mgL;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mgJ != null) {
                aVar.dX(1, this.mgJ.aHr());
                this.mgJ.a(aVar);
            }
            if (this.mgL != null) {
                aVar.dX(2, this.mgL.aHr());
                this.mgL.a(aVar);
            }
            if (this.mgK == null) {
                return 0;
            }
            aVar.dX(3, this.mgK.aHr());
            this.mgK.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mgJ != null) {
                r0 = a.a.a.a.dU(1, this.mgJ.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mgL != null) {
                r0 += a.a.a.a.dU(2, this.mgL.aHr());
            }
            if (this.mgK != null) {
                r0 += a.a.a.a.dU(3, this.mgK.aHr());
            }
            return r0;
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
            aju com_tencent_mm_protocal_c_aju = (aju) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_acg;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_acg = new acg();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_acg.a(aVar4, com_tencent_mm_protocal_c_acg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aju.mgJ = com_tencent_mm_protocal_c_acg;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_acg = new ajs();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_acg.a(aVar4, com_tencent_mm_protocal_c_acg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aju.mgL = com_tencent_mm_protocal_c_acg;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_acg = new hu();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_acg.a(aVar4, com_tencent_mm_protocal_c_acg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aju.mgK = com_tencent_mm_protocal_c_acg;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
