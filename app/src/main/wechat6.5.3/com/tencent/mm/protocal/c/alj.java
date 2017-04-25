package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class alj extends a {
    public are mMi;
    public int mMj;
    public are mMk;
    public int uin;
    public int version;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.dV(1, this.uin);
            aVar.dV(2, this.version);
            if (this.mMi != null) {
                aVar.dX(3, this.mMi.aHr());
                this.mMi.a(aVar);
            }
            aVar.dV(4, this.mMj);
            if (this.mMk != null) {
                aVar.dX(5, this.mMk.aHr());
                this.mMk.a(aVar);
            }
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.dS(1, this.uin) + 0) + a.a.a.a.dS(2, this.version);
            if (this.mMi != null) {
                r0 += a.a.a.a.dU(3, this.mMi.aHr());
            }
            r0 += a.a.a.a.dS(4, this.mMj);
            if (this.mMk != null) {
                return r0 + a.a.a.a.dU(5, this.mMk.aHr());
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
            alj com_tencent_mm_protocal_c_alj = (alj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            byte[] bArr;
            are com_tencent_mm_protocal_c_are;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_alj.uin = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_alj.version = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alj.mMi = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_alj.mMj = aVar3.pMj.mH();
                    return 0;
                case 5:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) zQ.get(intValue);
                        com_tencent_mm_protocal_c_are = new are();
                        aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_alj.mMk = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
