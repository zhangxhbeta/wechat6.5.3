package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class abx extends a {
    public int efm;
    public int hNS;
    public long mDf;
    public are meT;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.meT == null) {
                throw new b("Not all required fields were included: Buffer");
            }
            aVar.C(1, this.mDf);
            aVar.dV(2, this.hNS);
            if (this.meT != null) {
                aVar.dX(3, this.meT.aHr());
                this.meT.a(aVar);
            }
            aVar.dV(4, this.efm);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.B(1, this.mDf) + 0) + a.a.a.a.dS(2, this.hNS);
            if (this.meT != null) {
                r0 += a.a.a.a.dU(3, this.meT.aHr());
            }
            return r0 + a.a.a.a.dS(4, this.efm);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.meT != null) {
                return 0;
            }
            throw new b("Not all required fields were included: Buffer");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            abx com_tencent_mm_protocal_c_abx = (abx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_abx.mDf = aVar3.pMj.mI();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_abx.hNS = aVar3.pMj.mH();
                    return 0;
                case 3:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        are com_tencent_mm_protocal_c_are = new are();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_abx.meT = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_abx.efm = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
