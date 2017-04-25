package com.tencent.mm.protocal.c;

import a.a.a.b;
import com.tencent.mm.ba.a;
import java.util.LinkedList;

public final class apw extends a {
    public arf mPm;
    public int mPn;
    public LinkedList<asf> mPo = new LinkedList();

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a.a.a.c.a aVar = (a.a.a.c.a) objArr[0];
            if (this.mPm == null) {
                throw new b("Not all required fields were included: GroupName");
            }
            if (this.mPm != null) {
                aVar.dX(1, this.mPm.aHr());
                this.mPm.a(aVar);
            }
            aVar.dV(2, this.mPn);
            aVar.d(3, 8, this.mPo);
            return 0;
        } else if (i == 1) {
            if (this.mPm != null) {
                r0 = a.a.a.a.dU(1, this.mPm.aHr()) + 0;
            } else {
                r0 = 0;
            }
            return (r0 + a.a.a.a.dS(2, this.mPn)) + a.a.a.a.c(3, 8, this.mPo);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mPo.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = a.a(aVar2); r0 > 0; r0 = a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mPm != null) {
                return 0;
            }
            throw new b("Not all required fields were included: GroupName");
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            apw com_tencent_mm_protocal_c_apw = (apw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            LinkedList zQ;
            int size;
            a.a.a.a.a aVar4;
            boolean z;
            switch (intValue) {
                case 1:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        arf com_tencent_mm_protocal_c_arf = new arf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_arf.a(aVar4, com_tencent_mm_protocal_c_arf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apw.mPm = com_tencent_mm_protocal_c_arf;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_apw.mPn = aVar3.pMj.mH();
                    return 0;
                case 3:
                    zQ = aVar3.zQ(intValue);
                    size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        asf com_tencent_mm_protocal_c_asf = new asf();
                        aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (z = true; z; z = com_tencent_mm_protocal_c_asf.a(aVar4, com_tencent_mm_protocal_c_asf, a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_apw.mPo.add(com_tencent_mm_protocal_c_asf);
                    }
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
