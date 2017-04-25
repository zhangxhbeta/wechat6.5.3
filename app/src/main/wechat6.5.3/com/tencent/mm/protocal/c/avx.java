package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class avx extends a {
    public int hNS;
    public are mSR;
    public String mdw;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mSR == null) {
                throw new b("Not all required fields were included: HBBuffer");
            }
            if (this.mdw != null) {
                aVar.e(1, this.mdw);
            }
            aVar.dV(2, this.hNS);
            if (this.mSR == null) {
                return 0;
            }
            aVar.dX(3, this.mSR.aHr());
            this.mSR.a(aVar);
            return 0;
        } else if (i == 1) {
            if (this.mdw != null) {
                r0 = a.a.a.b.b.a.f(1, this.mdw) + 0;
            } else {
                r0 = 0;
            }
            r0 += a.a.a.a.dS(2, this.hNS);
            if (this.mSR != null) {
                r0 += a.a.a.a.dU(3, this.mSR.aHr());
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mSR != null) {
                return 0;
            }
            throw new b("Not all required fields were included: HBBuffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            avx com_tencent_mm_protocal_c_avx = (avx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_avx.mdw = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avx.hNS = aVar3.pMj.mH();
                    return 0;
                case 3:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a com_tencent_mm_protocal_c_are = new are();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avx.mSR = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
