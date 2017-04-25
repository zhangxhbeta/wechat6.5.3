package com.tencent.mm.protocal.c;

import a.a.a.b;
import a.a.a.c.a;
import java.util.LinkedList;

public final class aou extends aqp {
    public String mhD;
    public String mhJ;
    public int time_stamp;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            a aVar = (a) objArr[0];
            if (this.mhJ == null) {
                throw new b("Not all required fields were included: brand_user_name");
            } else if (this.mhD == null) {
                throw new b("Not all required fields were included: bizchat_id");
            } else {
                if (this.mPU != null) {
                    aVar.dX(1, this.mPU.aHr());
                    this.mPU.a(aVar);
                }
                if (this.mhJ != null) {
                    aVar.e(2, this.mhJ);
                }
                if (this.mhD != null) {
                    aVar.e(3, this.mhD);
                }
                aVar.dV(4, this.time_stamp);
                return 0;
            }
        } else if (i == 1) {
            if (this.mPU != null) {
                r0 = a.a.a.a.dU(1, this.mPU.aHr()) + 0;
            } else {
                r0 = 0;
            }
            if (this.mhJ != null) {
                r0 += a.a.a.b.b.a.f(2, this.mhJ);
            }
            if (this.mhD != null) {
                r0 += a.a.a.b.b.a.f(3, this.mhD);
            }
            return r0 + a.a.a.a.dS(4, this.time_stamp);
        } else if (i == 2) {
            a.a.a.a.a aVar2 = new a.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (r0 = com.tencent.mm.ba.a.a(aVar2); r0 > 0; r0 = com.tencent.mm.ba.a.a(aVar2)) {
                if (!super.a(aVar2, this, r0)) {
                    aVar2.bQL();
                }
            }
            if (this.mhJ == null) {
                throw new b("Not all required fields were included: brand_user_name");
            } else if (this.mhD != null) {
                return 0;
            } else {
                throw new b("Not all required fields were included: bizchat_id");
            }
        } else if (i != 3) {
            return -1;
        } else {
            a.a.a.a.a aVar3 = (a.a.a.a.a) objArr[0];
            aou com_tencent_mm_protocal_c_aou = (aou) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList zQ = aVar3.zQ(intValue);
                    int size = zQ.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) zQ.get(intValue);
                        com.tencent.mm.ba.a enVar = new en();
                        a.a.a.a.a aVar4 = new a.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = enVar.a(aVar4, enVar, com.tencent.mm.ba.a.a(aVar4))) {
                        }
                        com_tencent_mm_protocal_c_aou.mPU = enVar;
                    }
                    return 0;
                case 2:
                    com_tencent_mm_protocal_c_aou.mhJ = aVar3.pMj.readString();
                    return 0;
                case 3:
                    com_tencent_mm_protocal_c_aou.mhD = aVar3.pMj.readString();
                    return 0;
                case 4:
                    com_tencent_mm_protocal_c_aou.time_stamp = aVar3.pMj.mH();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
