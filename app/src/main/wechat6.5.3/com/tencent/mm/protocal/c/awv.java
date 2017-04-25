package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class awv extends a {
    public int eet;
    public LinkedList<arf> eeu = new LinkedList();
    public String gmM;
    public long mUj;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.C(1, this.mUj);
            if (this.gmM != null) {
                aVar.e(2, this.gmM);
            }
            aVar.dV(3, this.eet);
            aVar.d(4, 8, this.eeu);
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.B(1, this.mUj) + 0;
            if (this.gmM != null) {
                r0 += a.a.a.b.b.a.f(2, this.gmM);
            }
            return (r0 + a.a.a.a.dS(3, this.eet)) + a.a.a.a.c(4, 8, this.eeu);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.eeu.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
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
            awv com_tencent_mm_protocal_c_awv = (awv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_awv.mUj = aVar3.pMj.mI();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_awv.gmM = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_awv.eet = aVar3.pMj.mH();
                    return 0;
                case 4:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        arf com_tencent_mm_protocal_c_arf = new arf();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_awv.eeu.add(com_tencent_mm_protocal_c_arf);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
