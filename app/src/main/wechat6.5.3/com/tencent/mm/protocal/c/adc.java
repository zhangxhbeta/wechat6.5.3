package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class adc extends aqp {
    public String mEd;
    public LinkedList<String> mEe = new LinkedList();
    public String mop;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mop == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.mEd == null) {
                throw new b("Not all required fields were included: bizchat_name");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.mop != null) {
                    aVar.e(2, this.mop);
                }
                if (this.mEd != null) {
                    aVar.e(3, this.mEd);
                }
                aVar.d(4, 1, this.mEe);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mop != null) {
                r0 += a.a.a.b.b.a.f(2, this.mop);
            }
            if (this.mEd != null) {
                r0 += a.a.a.b.b.a.f(3, this.mEd);
            }
            return r0 + a.a.a.a.c(4, 1, this.mEe);
        } else if (i == 2) {
            r0 = (byte[]) objArr[0];
            this.mEe.clear();
            a.a.a.a.a aVar2 = new a.a.a.a.a(r0, unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mop == null) {
                throw new b("Not all required fields were included: corp_id");
            } else if (this.mEd != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: bizchat_name");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            adc com_tencent_mm_protocal_c_adc = (adc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        r0 = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(r0, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_adc.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_adc.mop = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_adc.mEd = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_adc.mEe.add(aVar3.pMj.readString());
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
