package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import com.tencent.mm.ba.b;
import java.util.LinkedList;

public final class biu extends a {
    public LinkedList<ayg> ndm = new LinkedList();
    public b ndn;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            aVar.d(1, 8, this.ndm);
            if (this.ndn != null) {
                aVar.b(2, this.ndn);
            }
            return 0;
        } else if (i == 1) {
            r0 = a.a.a.a.c(1, 8, this.ndm) + 0;
            if (this.ndn != null) {
                return r0 + a.a.a.a.a(2, this.ndn);
            }
            return r0;
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.ndm.clear();
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
            biu com_tencent_mm_protocal_c_biu = (biu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        ayg com_tencent_mm_protocal_c_ayg = new ayg();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_ayg.a(aVar4, com_tencent_mm_protocal_c_ayg, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_biu.ndm.add(com_tencent_mm_protocal_c_ayg);
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_biu.ndn = aVar3.bQK();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
