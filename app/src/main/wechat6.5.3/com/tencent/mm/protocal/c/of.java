package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class of extends a {
    public int eet;
    public LinkedList<afq> eeu = new LinkedList();
    public String mpC;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mpC != null) {
                aVar.e(1, this.mpC);
            }
            aVar.dV(2, this.eet);
            aVar.d(3, 8, this.eeu);
            return 0;
        } else if (i == 1) {
            if (this.mpC != null) {
                r0 = a.a.a.b.b.a.f(1, this.mpC) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + a.a.a.a.dS(2, this.eet)) + a.a.a.a.c(3, 8, this.eeu);
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
            of ofVar = (of) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ofVar.mpC = aVar3.pMj.readString();
                    return 0;
                case 2:
                    ofVar.eet = aVar3.pMj.mH();
                    return 0;
                case 3:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        afq com_tencent_mm_protocal_c_afq = new afq();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_afq.a(aVar4, com_tencent_mm_protocal_c_afq, a.a(aVar4))) {
                        }
                        ofVar.eeu.add(com_tencent_mm_protocal_c_afq);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
