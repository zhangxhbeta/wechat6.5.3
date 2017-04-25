package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class awp extends a {
    public awa mSF;
    public arf mTX;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mSF == null) {
                throw new b("Not all required fields were included: SnsObject");
            }
            if (this.mSF != null) {
                aVar.dX(1, this.mSF.aHr());
                this.mSF.a(aVar);
            }
            if (this.mTX == null) {
                return 0;
            }
            aVar.dX(2, this.mTX.aHr());
            this.mTX.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mSF != null) {
                r0 = a.a.a.a.dU(1, this.mSF.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mTX != null) {
                r0 += a.a.a.a.dU(2, this.mTX.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mSF != null) {
                return 0;
            }
            throw new b("Not all required fields were included: SnsObject");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            awp com_tencent_mm_protocal_c_awp = (awp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        awa com_tencent_mm_protocal_c_awa = new awa();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_awa.a(aVar4, com_tencent_mm_protocal_c_awa, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awp.mSF = com_tencent_mm_protocal_c_awa;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        arf com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awp.mTX = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
