package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class avn extends a {
    public long mSS;
    public avm mST;
    public avm mSU;
    public String mbN;
    public long mjq;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mST == null) {
                throw new b("Not all required fields were included: CurrentAction");
            }
            aVar.C(1, this.mjq);
            aVar.C(2, this.mSS);
            if (this.mST != null) {
                aVar.dX(3, this.mST.aHr());
                this.mST.a(aVar);
            }
            if (this.mSU != null) {
                aVar.dX(4, this.mSU.aHr());
                this.mSU.a(aVar);
            }
            if (this.mbN != null) {
                aVar.e(5, this.mbN);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.B(1, this.mjq) + 0) + a.a.a.a.B(2, this.mSS);
            if (this.mST != null) {
                r0 += a.a.a.a.dU(3, this.mST.aHr());
            }
            if (this.mSU != null) {
                r0 += a.a.a.a.dU(4, this.mSU.aHr());
            }
            if (this.mbN != null) {
                return r0 + a.a.a.b.b.a.f(5, this.mbN);
            }
            return r0;
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mST != null) {
                return 0;
            }
            throw new b("Not all required fields were included: CurrentAction");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            avn com_tencent_mm_protocal_c_avn = (avn) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            avm com_tencent_mm_protocal_c_avm;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_avn.mjq = aVar3.pMj.mI();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_avn.mSS = aVar3.pMj.mI();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_avm = new avm();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avm.a(aVar4, com_tencent_mm_protocal_c_avm, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avn.mST = com_tencent_mm_protocal_c_avm;
                    }
                    return 0;
                case 4:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_avm = new avm();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_avm.a(aVar4, com_tencent_mm_protocal_c_avm, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_avn.mSU = com_tencent_mm_protocal_c_avm;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_avn.mbN = aVar3.pMj.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
