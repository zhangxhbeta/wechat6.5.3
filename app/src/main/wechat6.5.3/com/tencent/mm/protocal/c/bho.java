package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class bho extends a {
    public long ncA;
    public String ncB;
    public LinkedList<bhp> ncC = new LinkedList();
    public long ncz;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.ncB == null) {
                throw new b("Not all required fields were included: TotalMsg");
            }
            aVar.C(1, this.ncA);
            aVar.C(2, this.ncz);
            if (this.ncB != null) {
                aVar.e(3, this.ncB);
            }
            aVar.d(4, 8, this.ncC);
            return 0;
        } else if (i == 1) {
            r0 = (a.a.a.a.B(1, this.ncA) + 0) + a.a.a.a.B(2, this.ncz);
            if (this.ncB != null) {
                r0 += a.a.a.b.b.a.f(3, this.ncB);
            }
            return r0 + a.a.a.a.c(4, 8, this.ncC);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ncC.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.ncB != null) {
                return 0;
            }
            throw new b("Not all required fields were included: TotalMsg");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            bho com_tencent_mm_protocal_c_bho = (bho) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_bho.ncA = aVar3.pMj.mI();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_bho.ncz = aVar3.pMj.mI();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_bho.ncB = aVar3.pMj.readString();
                    return 0;
                case 4:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        bhp com_tencent_mm_protocal_c_bhp = new bhp();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_bhp.a(aVar4, com_tencent_mm_protocal_c_bhp, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_bho.ncC.add(com_tencent_mm_protocal_c_bhp);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
