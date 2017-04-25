package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class ahp extends a {
    public ahq mHk;
    public aho mHl;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mHk == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.mHl == null) {
                throw new b("Not all required fields were included: AesReqData");
            } else {
                if (this.mHk != null) {
                    aVar.dX(1, this.mHk.aHr());
                    this.mHk.a(aVar);
                }
                if (this.mHl == null) {
                    return 0;
                }
                aVar.dX(2, this.mHl.aHr());
                this.mHl.a(aVar);
                return 0;
            }
        } else if (i == 1) {
            if (this.mHk != null) {
                r0 = a.a.a.a.dU(1, this.mHk.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mHl != null) {
                r0 += a.a.a.a.dU(2, this.mHl.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mHk == null) {
                throw new b("Not all required fields were included: RsaReqData");
            } else if (this.mHl != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: AesReqData");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ahp com_tencent_mm_protocal_c_ahp = (ahp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            a com_tencent_mm_protocal_c_ahq;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_ahq = new ahq();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ahq.a(aVar4, com_tencent_mm_protocal_c_ahq, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahp.mHk = com_tencent_mm_protocal_c_ahq;
                    }
                    return 0;
                case 2:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_ahq = new aho();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_ahq.a(aVar4, com_tencent_mm_protocal_c_ahq, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ahp.mHl = com_tencent_mm_protocal_c_ahq;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
