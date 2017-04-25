package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class ako extends a {
    public int mLv;
    public String mLw;
    public are mLx;
    public int mLy;
    public b mfA;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mLx == null) {
                throw new a.a.a.b("Not all required fields were included: ClientKey");
            }
            aVar.dV(1, this.mLv);
            if (this.mfA != null) {
                aVar.b(2, this.mfA);
            }
            if (this.mLw != null) {
                aVar.e(3, this.mLw);
            }
            if (this.mLx != null) {
                aVar.dX(4, this.mLx.aHr());
                this.mLx.a(aVar);
            }
            aVar.dV(5, this.mLy);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.dS(1, this.mLv) + 0;
            if (this.mfA != null) {
                r0 += a.a.a.a.a(2, this.mfA);
            }
            if (this.mLw != null) {
                r0 += a.a.a.b.b.a.f(3, this.mLw);
            }
            if (this.mLx != null) {
                r0 += a.a.a.a.dU(4, this.mLx.aHr());
            }
            return r0 + a.a.a.a.dS(5, this.mLy);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mLx != null) {
                return 0;
            }
            throw new a.a.a.b("Not all required fields were included: ClientKey");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            ako com_tencent_mm_protocal_c_ako = (ako) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_ako.mLv = aVar3.pMj.mH();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_ako.mfA = aVar3.bQK();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_ako.mLw = aVar3.pMj.readString();
                    return 0;
                case 4:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        a com_tencent_mm_protocal_c_are = new are();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_are.a(aVar4, com_tencent_mm_protocal_c_are, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_ako.mLx = com_tencent_mm_protocal_c_are;
                    }
                    return 0;
                case 5:
                    com_tencent_mm_protocal_c_ako.mLy = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
