package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class acz extends a {
    public arf mDZ;
    public are mbY;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mbY == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else if (this.mDZ == null) {
                throw new b("Not all required fields were included: Username");
            } else {
                if (this.mbY != null) {
                    aVar.dX(1, this.mbY.aHr());
                    this.mbY.a(aVar);
                }
                if (this.mDZ == null) {
                    return 0;
                }
                aVar.dX(2, this.mDZ.aHr());
                this.mDZ.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.mbY != null) {
                r0 = a.a.a.a.dU(1, this.mbY.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mDZ != null) {
                r0 += a.a.a.a.dU(2, this.mDZ.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mbY == null) {
                throw new b("Not all required fields were included: ImgBuf");
            } else if (this.mDZ != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: Username");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            acz com_tencent_mm_protocal_c_acz = (acz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_are;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_acz.mbY = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_acz.mDZ = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
