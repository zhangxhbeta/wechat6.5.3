package com.tencent.mm.plugin.sns.g;

import com.tencent.mm.ba.a;
import com.tencent.mm.protocal.c.aib;
import java.util.LinkedList;

public final class b extends a {
    public aib boL;
    public int cLB;
    public String jqo;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.boL != null) {
                aVar.dX(1, this.boL.aHr());
                this.boL.a(aVar);
            }
            if (this.jqo != null) {
                aVar.e(2, this.jqo);
            }
            aVar.dV(3, this.cLB);
            return 0;
        } else if (i == 1) {
            if (this.boL != null) {
                r0 = a.a.a.a.dU(1, this.boL.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.jqo != null) {
                r0 += a.a.a.b.b.a.f(2, this.jqo);
            }
            return r0 + a.a.a.a.dS(3, this.cLB);
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
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        aib com_tencent_mm_protocal_c_aib = new aib();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_aib.a(aVar4, com_tencent_mm_protocal_c_aib, a.a(aVar4))) {
                        }
                        bVar.boL = com_tencent_mm_protocal_c_aib;
                    }
                    return 0;
                case 2:
                    bVar.jqo = aVar3.pMj.readString();
                    return 0;
                case 3:
                    bVar.cLB = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
