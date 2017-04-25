package com.tencent.mm.protocal.c;

import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class acs extends a {
    public String gjT;
    public LinkedList<acu> mDM = new LinkedList();
    public int major;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.gjT != null) {
                aVar.e(1, this.gjT);
            }
            aVar.dV(2, this.major);
            aVar.d(3, 8, this.mDM);
            return 0;
        } else if (i == 1) {
            if (this.gjT != null) {
                r0 = a.a.a.b.b.a.f(1, this.gjT) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + a.a.a.a.dS(2, this.major)) + a.a.a.a.c(3, 8, this.mDM);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mDM.clear();
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
            acs com_tencent_mm_protocal_c_acs = (acs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    com_tencent_mm_protocal_c_acs.gjT = aVar3.pMj.readString();
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_acs.major = aVar3.pMj.mH();
                    return 0;
                case 3:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        acu com_tencent_mm_protocal_c_acu = new acu();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = com_tencent_mm_protocal_c_acu.a(aVar4, com_tencent_mm_protocal_c_acu, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_acs.mDM.add(com_tencent_mm_protocal_c_acu);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
