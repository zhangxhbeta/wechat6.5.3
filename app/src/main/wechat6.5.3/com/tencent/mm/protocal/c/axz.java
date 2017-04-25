package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class axz extends a {
    public aya mVt;
    public axy mVu;
    public axx mVv;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mVt != null) {
                aVar.dX(1, this.mVt.aHr());
                this.mVt.a(aVar);
            }
            if (this.mVu != null) {
                aVar.dX(2, this.mVu.aHr());
                this.mVu.a(aVar);
            }
            if (this.mVv == null) {
                return 0;
            }
            aVar.dX(3, this.mVv.aHr());
            this.mVv.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mVt != null) {
                r0 = a.a.a.a.dU(1, this.mVt.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mVu != null) {
                r0 += a.a.a.a.dU(2, this.mVu.aHr());
            }
            if (this.mVv != null) {
                r0 += a.a.a.a.dU(3, this.mVv.aHr());
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
            axz com_tencent_mm_protocal_c_axz = (axz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_aya;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_aya = new aya();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aya.a(aVar4, com_tencent_mm_protocal_c_aya, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axz.mVt = com_tencent_mm_protocal_c_aya;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_aya = new axy();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aya.a(aVar4, com_tencent_mm_protocal_c_aya, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axz.mVu = com_tencent_mm_protocal_c_aya;
                    }
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_aya = new axx();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_aya.a(aVar4, com_tencent_mm_protocal_c_aya, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_axz.mVv = com_tencent_mm_protocal_c_aya;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
